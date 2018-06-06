package csheets.ui.enums;

/**
 * Created by berme on 6/7/2016.
 */
public enum SortOption {
    //TODO extract to resource bundle
    ASCENDING("Ascending"),
    DESCENDING("Descending");

    private String description;

    SortOption(String description) {
        this.description = description;
    }

    public String description() {
        return this.description;
    }
}
