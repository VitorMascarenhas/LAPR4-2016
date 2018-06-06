package csheets.core.monetaryformula;

/**
 * Enumerator with current supported currencies of CleanSheet.
 * @author Pedro Costa
 */
public enum Currency
{
    EURO, POUND, DOLLAR;

    /**
     * Parse a string to currency.
     *
     * @param strCurrency String to parse to ExchangeRatesLoader
     *
     * @return ExchangeRatesLoader enum if match, IllegalArgumentException otherwise.
     */
    public static Currency parseCurrency(String strCurrency)
    {
        switch (strCurrency.toLowerCase().trim())
        {
            case "eur":
            case "euro":
            case "euros":
            case "€":
                return EURO;

            case "pound":
            case "pounds":
            case "£":
                return POUND;

            case "dollar":
            case "dollars":
            case "$":
                return DOLLAR;

            default:
                throw new IllegalArgumentException("Not a valid currency: " + strCurrency);
        }
    }
}
