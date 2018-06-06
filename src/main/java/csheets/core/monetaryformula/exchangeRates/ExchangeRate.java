package csheets.core.monetaryformula.exchangerates;

import csheets.core.monetaryformula.Currency;

import java.math.BigDecimal;

/**
 * Implements the concept of exchange rate.
 *
 * @author Pedro Costa
 */
public class ExchangeRate implements IExchangeRate
{
    private Currency from;
    private Currency to;
    private BigDecimal value;

    /**
     * Constructor.
     *
     * @param from Original currency
     * @param to Output currency
     * @param exchangeRate Exchange Rate to apply
     */
    public ExchangeRate(Currency from, Currency to, BigDecimal exchangeRate)
    {
        this.to = to;
        this.from = from;
        this.value = exchangeRate;
    }

    /**
     * Return the original currency.
     *
     * @return Currency
     */
    @Override
    public Currency from()
    {
        return this.from;
    }

    /**
     * Return the output currency.
     *
     * @return Currency
     */
    @Override
    public Currency to()
    {
        return this.to;
    }

    /**
     * Return the exchange rate.
     *
     * @return Currency
     */
    @Override
    public BigDecimal value()
    {
        return this.value;
    }
}
