package csheets.core.monetaryformula.exchangerates;

import csheets.core.monetaryformula.Currency;

import java.math.BigDecimal;

/**
 * Centralizes the creation of exchange rates.
 */
public class ExchangeRatesFactory
{
    /**
     *
     * @param strFrom
     * @param strTo
     * @param strExchangeRate
     * @return
     */
    public IExchangeRate generateExchangeRate(String strFrom, String strTo, String strExchangeRate)
    {
        Currency from = Currency.parseCurrency(strFrom);
        Currency to = Currency.parseCurrency(strTo);
        BigDecimal exchangeRate = new BigDecimal(strExchangeRate);

        return new ExchangeRate(from,to,exchangeRate);
    }
}
