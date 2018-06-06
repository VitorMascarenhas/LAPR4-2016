package csheets.ext.contacts.domain.Professions;

import java.util.HashSet;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Pedro Costa
 */
public class ProfessionsManagerXmlTest {

    private Set<String> professions;

    public ProfessionsManagerXmlTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.professions = new HashSet<>();

        this.professions.add("Fire fighter");
        this.professions.add("Teacher");
        this.professions.add("Engineer");
        this.professions.add("Photographer");
        this.professions.add("Farmer");
        this.professions.add("Nurse");
        this.professions.add("Accountant");
        this.professions.add("Electrician");
        this.professions.add("Journalist");
        this.professions.add("Postman");
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of read method, of class ProfessionsManagerXml.
     */
    @Test
    public void testRead() {
        System.out.println("read");

        int count = 0;
        ProfessionsManagerXml instance = new ProfessionsManagerXml();

        Set<IProfession> result = instance.read();

        for (IProfession iProfession : result) {
            if(!this.professions.contains(iProfession))
            {
                count++;
            }

        }

        assertEquals(this.professions.size(), count);

    }

}
