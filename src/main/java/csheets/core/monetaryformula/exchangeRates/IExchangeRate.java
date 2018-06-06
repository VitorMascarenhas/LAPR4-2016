package csheets.core.monetaryformula.exchangerates;

import csheets.core.monetaryformula.Currency;

import java.math.BigDecimal;

/**
 * Defines contract for exchange rates.
 * @author Pedro Costa
 */
public interface IExchangeRate
{
    Currency from();
    Currency to();
    BigDecimal value();
}
