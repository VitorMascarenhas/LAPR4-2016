package csheets.core.monetaryformula.exchangerates;

import csheets.core.monetaryformula.Currency;
import csheets.core.monetaryformula.exchangerates.ExchangeRatesLoader;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import static csheets.core.monetaryformula.Currency.*;

/**
 * Implements the currency conversion loading exchange rates from a configuration file.
 * @author Pedro Costa
 */
public class ExchangeRatesConverter
{
    private static BigDecimal exchangeRateDollarToEur;
    private static BigDecimal exchangeRatePoundToEur;
    private static BigDecimal exchangeRatePoundToDollar;

    /**
     * Converts an currency amount value to another according current exchange rate in
     * configuration file.
     *
     * @param from current currency
     * @param to target currency
     * @param amount amount of currency
     *
     * @return BigDecimal in the target currency
     */
    public BigDecimal exchange(Currency from, Currency to, BigDecimal amount)
    {
        if(exchangeRateDollarToEur == null || exchangeRatePoundToEur == null || exchangeRatePoundToDollar == null)
            throw new IllegalArgumentException("No exchange rates");

        if(from==to)
            return amount;

        switch (from)
        {
            case DOLLAR:
                if(to == EURO)
                    return dollarToEur(amount);
                if(to == POUND)
                    return dollarToPound(amount);
            case EURO:
                if(to == DOLLAR)
                    return eurToDollar(amount);
                if(to == POUND)
                    return eurToPound(amount);
            case POUND:
                if(to == EURO)
                    return poundToEur(amount);
                if(to == DOLLAR)
                    return poundToDollar(amount);
        }

        throw new IllegalArgumentException("Unknown currency");
    }

    /**
     * Converts euros to pounds.
     * @param amount BigDecimal
     *
     * @return converted amount
     */
    private static BigDecimal eurToPound(BigDecimal amount)
    {
        return amount.multiply(new BigDecimal(1).divide(exchangeRatePoundToEur,5,BigDecimal.ROUND_CEILING));
    }

    /**
     * Converts euros to dollars.
     * @param amount BigDecimal
     *
     * @return converted amount
     */
    private static BigDecimal eurToDollar(BigDecimal amount)
    {
        return amount.multiply(new BigDecimal(1).divide(exchangeRateDollarToEur,5,BigDecimal.ROUND_CEILING));
    }

    /**
     * Converts pounds to euros.
     * @param amount BigDecimal
     *
     * @return converted amount
     */
    private static BigDecimal poundToEur(BigDecimal amount)
    {
        return amount.multiply(exchangeRatePoundToEur);
    }

    /**
     * Converts dollars to euros.
     * @param amount BigDecimal
     *
     * @return converted amount
     */
    private static BigDecimal dollarToEur(BigDecimal amount)
    {
        return amount.multiply(exchangeRateDollarToEur);
    }

    /**
     *
     * Converts dollars to pounds.
     * @param amount BigDecimal
     *
     * @return converted amount
     */
    private static BigDecimal dollarToPound(BigDecimal amount)
    {
        return amount.multiply(new BigDecimal(1).divide(exchangeRatePoundToDollar,5,BigDecimal.ROUND_CEILING));
    }

    /**
     *
     * Converts pounds to dollars.
     * @param amount BigDecimal
     *
     * @return converted amount
     */
    private static BigDecimal poundToDollar(BigDecimal amount)
    {
        return amount.multiply(exchangeRatePoundToDollar);
    }


    /**
     * Load exchange rates from a configuration file
     *
     * @return boolean if read with success, false otherwise.
     */
    public static boolean readExchangeRates(String file)
    {
        ExchangeRatesLoader manager = new ExchangeRatesLoader();
        List<IExchangeRate> exchangeRates = manager.readExchangeRates(file);

        exchangeRateDollarToEur =
            exchangeRates.stream().filter(e -> e.from()==Currency.DOLLAR && e.to()==Currency.EURO).findFirst().get().value();
        exchangeRatePoundToEur =
            exchangeRates.stream().filter(e -> e.from()==Currency.POUND && e.to()==Currency.EURO).findFirst().get().value();
        exchangeRatePoundToDollar =
            exchangeRates.stream().filter(e -> e.from()==Currency.POUND && e.to()==Currency.DOLLAR).findFirst().get().value();

        return exchangeRateDollarToEur != null && exchangeRatePoundToEur != null && exchangeRatePoundToDollar != null;
    }

    /**
     * Updates exchange rates.
     *
     * @param poundToEur BigDecimal of new exchange rate (Pound to Euro)
     * @param dollarToEur BigDecimal of new exchange rate (Dollar to Euro)
     * @param poundToDollar BigDecimal of new exchange rate (Pound to Dollar)
     *
     * @return boolean if updated with success, false otherwise.
     */
    public static boolean updateExchangeRates(BigDecimal poundToEur, BigDecimal dollarToEur, BigDecimal poundToDollar)
    {
        exchangeRatePoundToEur = poundToEur;
        exchangeRateDollarToEur = dollarToEur;
        exchangeRatePoundToDollar = poundToDollar;

        return exchangeRateDollarToEur != null && exchangeRatePoundToEur != null && exchangeRatePoundToDollar != null;
    }
}
