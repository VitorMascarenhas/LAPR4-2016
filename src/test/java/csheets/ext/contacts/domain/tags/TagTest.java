package csheets.ext.contacts.domain.tags;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author José Vilela - 1010500
 */
public class TagTest {
    
    public TagTest() {
    }

    /**
     * Test of toString method, of class Tag.
     */
    @Test
    public void testToString() {
        Tag instance = new Tag("teste");
        String expResult = "teste";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of tagName method, of class Tag.
     */
    @Test
    public void testTagName() {
        Tag instance = new Tag("teste");
        String expResult = "teste";
        String result = instance.tagName();
        assertEquals(expResult, result);
    }

    /**
     * Test of update method, of class Tag.
     */
    @Test
    public void testUpdate() {
        ITag tag = new Tag("teste");
        Tag instance = new Tag("teste2");
        boolean expResult = true;
        boolean result = instance.update(tag);
        assertEquals(expResult, result);
        assertEquals(instance.toString(), tag.toString());
    }

    /**
     * Test of isValid method, of class Tag.
     */
    @Test
    public void testIsValid() {
        Tag instance = new Tag();
        boolean expResult = false;
        boolean result = instance.isValid();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCount method, of class Tag.
     */
    @Test
    public void testGetCount() {
        Tag instance = new Tag("teste");
        int expResult = 0;
        int result = instance.getCount();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCount method, of class Tag.
     */
    @Test
    public void testSetCount() {
        int expResult = 5;
        Tag instance = new Tag("teste");
        instance.setCount(expResult);
        int result = instance.getCount();
        assertEquals(expResult, result);
    }

    /**
     * Test of compareTo method, of class Tag.
     */
    @Test
    public void testCompareTo() {
        Tag instance = new Tag("teste");
        Tag instance2 = new Tag("teste2");
        int expResult = 2;
        instance.setCount(5);
        instance2.setCount(7);
        int result = instance.compareTo(instance2);
        assertEquals(expResult, result);
    }
    
}
