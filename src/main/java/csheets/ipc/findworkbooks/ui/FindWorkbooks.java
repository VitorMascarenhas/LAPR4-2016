/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ipc.findworkbooks.ui;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import static java.nio.file.FileVisitResult.CONTINUE;

/**
 * @author 1950689 Nuno Mota
 */
public class FindWorkbooks extends Observable implements Runnable {

    private Path searchPath;
    private String pattern;
    private List<File> workbookFiles;

    /**
     *
     * @param dirPath
     * @param pattern
     */
    public FindWorkbooks(Path dirPath, String pattern) {
        this.searchPath = dirPath;
        this.pattern = pattern;
    }

    @Override
    protected synchronized void setChanged() {
        super.setChanged();
    }

    @Override
    protected synchronized void clearChanged() {
        super.clearChanged();
    }

    @Override
    public void run() {
        WorkbookFinder finder = new WorkbookFinder(pattern);
        this.workbookFiles = new ArrayList<>();
        try {
            Files.walkFileTree(this.searchPath, finder);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!workbookFiles.isEmpty()) {
            setChanged();
            notifyObservers();
        }
    }

    protected List<File> getWorkbookFiles() {
        return this.workbookFiles;
    }


    private class WorkbookFinder extends SimpleFileVisitor<Path> {
        private String pattern;

        private final PathMatcher matcher;
        private int numMatches = 0;

        public WorkbookFinder(String pattern) {
            this.pattern = pattern;

            this.matcher = FileSystems.getDefault()
                    .getPathMatcher("regex:"+this.pattern);
        }

        // Compares the glob pattern against
        // the file or directory name.
        void find(Path file) {
            Path name = file.getFileName();
            if (name != null && matcher.matches(name) && !Files.isDirectory(file)) {
                numMatches++;
                workbookFiles.add(file.toFile());
            }
        }

        // Invoke the pattern matching
        // method on each file.
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
            find(file);
            return CONTINUE;
        }

        // Invoke the pattern matching
        // method on each directory.
        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
            find(dir);
            return CONTINUE;
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) {
            System.err.println(exc);
            return CONTINUE;
        }
    }
}
