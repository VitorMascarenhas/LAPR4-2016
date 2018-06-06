package csheets.core.monetaryformula;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test parse of currencies.
 * @author Pedro Costa
 */
public class CurrencyTest {

    String euro1;
    String euro2;
    String euro3;
    String euro5;
    String euro6;
    String euro7;
    String euro8;
    String dollar1;
    String dollar3;
    String pounds2;
    String pounds3;
    String pounds4;



    @Before
    public void setUp()
    {
        this.euro1 = "eur";
        this.euro2 = "euro";
        this.euro3 = "euros";
        this.euro5 = "Eur";
        this.euro6 = "Euro";
        this.euro7 = "Euros";
        this.euro8 = "EurOs";
        this.dollar1 = "DOLlar";
        this.dollar3 = "dollars";
        this.pounds2 = "pound";
        this.pounds3 = "pounds";
        this.pounds4 = "pouNd";

    }
    @Test
    public void parseCurrencyEuro() throws Exception
    {
        assertEquals(Currency.parseCurrency(euro1),Currency.EURO);
        assertEquals(Currency.parseCurrency(euro2),Currency.EURO);
        assertEquals(Currency.parseCurrency(euro3),Currency.EURO);
        assertEquals(Currency.parseCurrency(euro5),Currency.EURO);
        assertEquals(Currency.parseCurrency(euro6),Currency.EURO);
        assertEquals(Currency.parseCurrency(euro7),Currency.EURO);
        assertEquals(Currency.parseCurrency(euro8),Currency.EURO);
        assertNotEquals(Currency.parseCurrency(pounds2),Currency.EURO);
        assertNotEquals(Currency.parseCurrency(pounds3),Currency.EURO);
        assertNotEquals(Currency.parseCurrency(pounds4),Currency.EURO);

    }

    @Test
    public void parseCurrencyDollar() throws Exception
    {
        assertEquals(Currency.parseCurrency(dollar1),Currency.DOLLAR);
        assertEquals(Currency.parseCurrency(dollar3),Currency.DOLLAR);
        assertNotEquals(Currency.parseCurrency(euro1),Currency.DOLLAR);
        assertNotEquals(Currency.parseCurrency(euro2),Currency.DOLLAR);
        assertNotEquals(Currency.parseCurrency(euro3),Currency.DOLLAR);
        assertNotEquals(Currency.parseCurrency(euro5),Currency.DOLLAR);
        assertNotEquals(Currency.parseCurrency(euro6),Currency.DOLLAR);
        assertNotEquals(Currency.parseCurrency(euro7),Currency.DOLLAR);
        assertNotEquals(Currency.parseCurrency(euro8),Currency.DOLLAR);
        assertNotEquals(Currency.parseCurrency(pounds2),Currency.DOLLAR);
        assertNotEquals(Currency.parseCurrency(pounds3),Currency.DOLLAR);
        assertNotEquals(Currency.parseCurrency(pounds4),Currency.DOLLAR);
    }

    @Test
    public void parseCurrencyPound() throws Exception
    {

        assertEquals(Currency.parseCurrency(pounds2),Currency.POUND);
        assertEquals(Currency.parseCurrency(pounds3),Currency.POUND);
        assertEquals(Currency.parseCurrency(pounds4),Currency.POUND);
        assertNotEquals(Currency.parseCurrency(euro1),Currency.POUND);
        assertNotEquals(Currency.parseCurrency(euro2),Currency.POUND);
        assertNotEquals(Currency.parseCurrency(euro3),Currency.POUND);
        assertNotEquals(Currency.parseCurrency(euro5),Currency.POUND);
        assertNotEquals(Currency.parseCurrency(euro6),Currency.POUND);
        assertNotEquals(Currency.parseCurrency(euro7),Currency.POUND);
        assertNotEquals(Currency.parseCurrency(euro8),Currency.POUND);
        assertNotEquals(Currency.parseCurrency(dollar1),Currency.POUND);
        assertNotEquals(Currency.parseCurrency(dollar3),Currency.POUND);
    }

    @Test
    public void parseCurrencyUnknown() throws Exception
    {
        String unknown = "unknown";

        try {
            Currency.parseCurrency(unknown);
        } catch (IllegalArgumentException e)
        {
            return;
        }

        assertTrue(false);
    }

}