package csheets.core.monetaryformula;

import csheets.core.monetaryformula.exchangerates.ExchangeRatesConverter;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Test Currency Manager test.
 * @author Pedro Costa
 */
public class ExchangeRatesConverterTest
{
    private static final String TEST_FILE_01="exchangeRates_test01.xml";
    //Rates are strings just euro reproduce behavior of parser
    private static final String RATE_DOLLAR_TO_EURO = "0.89249855";
    private static final String RATE_POUND_TO_EURO = "1.26002945";
    private static final String RATE_POUND_TO_DOLLAR = "1.4178";
    private Currency dollar;
    private Currency euro;
    private BigDecimal amount;
    private ExchangeRatesConverter manager;

    @Before
    public void setUp()
    {
        this.dollar = Currency.DOLLAR;
        this.euro = Currency.EURO;
        this.amount = new BigDecimal(10);
        this.manager = new ExchangeRatesConverter();
        ExchangeRatesConverter.updateExchangeRates
            (new BigDecimal(RATE_POUND_TO_EURO), new BigDecimal(RATE_DOLLAR_TO_EURO), new BigDecimal(RATE_POUND_TO_DOLLAR));
    }


    @Test
    public void exchangeDollarToEuro() throws Exception
    {

        BigDecimal expResult = this.amount.multiply(new BigDecimal(RATE_DOLLAR_TO_EURO));
        BigDecimal result = this.manager.exchange(this.dollar,this.euro,this.amount);
        assertEquals(expResult,result);
    }

    @Test
    public void exchangeDollarToPound() throws Exception
    {
        BigDecimal expResult = this.amount.multiply(new BigDecimal(1).divide(new BigDecimal(RATE_POUND_TO_DOLLAR),5,BigDecimal.ROUND_CEILING));
        BigDecimal result = this.manager.exchange(this.dollar,Currency.POUND,this.amount);
        assertEquals(expResult,result);
    }

    @Test
    public void exchangeEuroToDollar() throws Exception
    {
        BigDecimal expResult = this.amount.multiply(new BigDecimal(1).divide(new BigDecimal(RATE_DOLLAR_TO_EURO),5,BigDecimal.ROUND_CEILING));
        BigDecimal result = this.manager.exchange(this.euro,this.dollar,this.amount);
        assertEquals(expResult,result);
    }

    @Test
    public void exchangeEuroToPound() throws Exception
    {
        BigDecimal expResult = this.amount.multiply(new BigDecimal(1).divide(new BigDecimal(RATE_POUND_TO_EURO),5,BigDecimal.ROUND_CEILING));
        BigDecimal result = this.manager.exchange(this.euro,Currency.POUND,this.amount);
        assertEquals(expResult,result);
    }

    @Test
    public void exchangePoundToDollar() throws Exception
    {
        BigDecimal expResult = this.amount.multiply((new BigDecimal(RATE_POUND_TO_DOLLAR)));
        BigDecimal result = this.manager.exchange(Currency.POUND,this.dollar,this.amount);
        assertEquals(expResult,result);
    }

    @Test
    public void exchangePoundToEuro() throws Exception
    {
        BigDecimal expResult = this.amount.multiply((new BigDecimal(RATE_POUND_TO_EURO)));
        BigDecimal result = this.manager.exchange(Currency.POUND,this.euro,this.amount);
        assertEquals(expResult,result);
    }

    @Test
    public void exchangeEuroToEuro() throws Exception
    {
        BigDecimal result = this.manager.exchange(Currency.EURO,this.euro,this.amount);
        assertEquals(this.amount,result);
    }

    @Test
    public void exchangeDollarToDollar() throws Exception
    {
        BigDecimal result = this.manager.exchange(Currency.DOLLAR,this.dollar,this.amount);
        assertEquals(this.amount,result);
    }

    @Test
    public void exchangePoundToPound() throws Exception
    {
        BigDecimal result = this.manager.exchange(Currency.POUND,Currency.POUND,this.amount);
        assertEquals(this.amount,result);
    }

}