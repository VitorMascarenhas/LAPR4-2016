/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ui.ext;

import csheets.core.Cell;
import csheets.core.Value;
import csheets.ipc.MockCell;
import csheets.ui.enums.SortOption;
import org.junit.*;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

/**
 *
 * @author smoli
 */
@RunWith(MockitoJUnitRunner.class)
public class CellRangeSortTest {

    public CellRangeSortTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of sort method, of class CellRangeSort.
     */
    @Test
    public void testSort_with_column_index_ascending() {
        
        System.out.println("sort_with_column_index_ascending");
        Cell[][] original = new Cell[2][2];
        Cell[][] expected = new Cell[2][2];

        original[0][0] = new MockCell(new Value("4"));
        original[1][0] = new MockCell(new Value("2"));
        original[0][1] = new MockCell(new Value("Valor 2"));
        original[1][1] = new MockCell(new Value("Valor 1"));
        
        expected[0][0] = new MockCell(new Value("2"));
        expected[1][0] = new MockCell(new Value("4"));
        expected[0][1] = new MockCell(new Value("Valor 1"));
        expected[1][1] = new MockCell(new Value("Valor 2"));
        
        
        CellRangeSort instance = new CellRangeSort(original, SortOption.ASCENDING);
        Value[][] sort = instance.sort(0);
        for(int i = 0; i < original.length; i ++){
            for(int j = 0; j <original[0].length; j++){
                original[i][j] = new MockCell(new Value(sort[i][j].toString()));
            }
        }

        Assert.assertArrayEquals(expected, original);

    }

    @Test
    public void testSort_with_column_index_descending() {
        System.out.println("sort_with_column_index_descending");
        Cell[][] original = new Cell[2][2];
        Cell[][] expected = new Cell[2][2];

        original[0][0] = new MockCell(new Value("2"));
        original[1][0] = new MockCell(new Value("4"));
        original[0][1] = new MockCell(new Value("Valor 1"));
        original[1][1] = new MockCell(new Value("Valor 2"));
        
        expected[0][0] = new MockCell(new Value("4"));
        expected[1][0] = new MockCell(new Value("2"));
        expected[0][1] = new MockCell(new Value("Valor 2"));
        expected[1][1] = new MockCell(new Value("Valor 1"));
        
        
        CellRangeSort instance = new CellRangeSort(original, SortOption.DESCENDING);
        Value[][] sort = instance.sort(0);
        for(int i = 0; i < original.length; i ++){
            for(int j = 0; j <original[0].length; j++){
                original[i][j] = new MockCell(new Value(sort[i][j].toString()));
            }
        }

        Assert.assertArrayEquals(original, expected);

    }
}
