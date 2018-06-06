package csheets.core.monetaryformula.exchangerates;

import csheets.core.monetaryformula.Currency;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Defines strategy for reading exchange rates.
 *
 * @author Pedro Costa
 */
public interface ExchangeRatesRead
{
    List<IExchangeRate> readExchangeRates(String file);
}
