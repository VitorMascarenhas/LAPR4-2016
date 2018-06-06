package csheets.core.monetaryformula.exchangerates;

import csheets.core.monetaryformula.Currency;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Test loader of exchange rates.
 * @author Pedro Costa
 */
public class ExchangeRatesLoaderTest {

    public static final String XML_TEST_FILE_NAME1 ="ext/exchangerates/exchangerates1.xml";
    public static final String XML_TEST_FILE_NAME2 ="ext/exchangerates/exchangerates2.xml";
    private ExchangeRatesLoader loader;

    @Before
    public void setUp()
    {
        this.loader = new ExchangeRatesLoader();
    }

    @Test
    public void readExchangeRates() throws Exception
    {

        List<IExchangeRate> rates = this.loader.readExchangeRates(XML_TEST_FILE_NAME1);
        assertTrue(rates.size()==3);

        IExchangeRate dollarEur = rates.stream().filter(er -> er.from()== Currency.DOLLAR && er.to()== Currency.EURO).findFirst().get();
        IExchangeRate poundEur = rates.stream().filter(er -> er.from()== Currency.POUND && er.to()== Currency.EURO).findFirst().get();
        IExchangeRate poundDollar = rates.stream().filter(er -> er.from()== Currency.POUND && er.to()== Currency.DOLLAR).findFirst().get();

        assertTrue(rates.size()==3);
        assertTrue(dollarEur.value().equals(new BigDecimal("0.89249855")));
        assertTrue(poundEur.value().equals(new BigDecimal("1.26002945")));
        assertTrue(poundDollar.value().equals(new BigDecimal("1.4178")));
    }

    @Test
    public void readExchangeRatesFail() throws Exception
    {
        try {
            List<IExchangeRate> rates = this.loader.readExchangeRates(XML_TEST_FILE_NAME2);
        } catch (IllegalArgumentException e) {
            return;
        }
        assertTrue(false);
   }

}