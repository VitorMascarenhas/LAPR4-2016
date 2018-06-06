package csheets.core.formula;

import csheets.core.Value;
import csheets.core.formula.util.ExpressionVisitor;
import csheets.core.monetaryformula.Currency;
import csheets.core.monetaryformula.exchangerates.ExchangeRatesConverter;
import csheets.core.monetaryformula.exchangerates.ExchangeRatesLoader;

import java.math.BigDecimal;

/**
 * Implements an Expression that executes currencies exchange.
 * @author Pedro Costa
 */
public class LiteralCurrency implements Expression
{
    /** The value of the literal */
    private Value value;

    /**
     * Exchange a currency amount.
     *
     * @param amount Amount of currency to be exchange
     * @param currency Current currency
     * @param outputCurrency Currency of output
     */
    public LiteralCurrency(String amount, String currency, String outputCurrency)
    {
        ExchangeRatesConverter manager = new ExchangeRatesConverter();
        if(!ExchangeRatesConverter.readExchangeRates(ExchangeRatesLoader.DEFAULT_XML_FILE_NAME))
            throw new IllegalArgumentException("No available exchange rates");

        BigDecimal numericValue = manager.exchange(Currency.parseCurrency(currency), Currency.parseCurrency(outputCurrency),new BigDecimal(amount));
        this.value = new Value(numericValue);
    }

    /**
     * Creates a new literal.
     * @param value the value of literal
     */
    public LiteralCurrency(Value value) {
        this.value = value;
    }

    @Override
    public Value evaluate()
    {
        return this.value;
    }

    @Override
    public Object accept(ExpressionVisitor visitor)
    {
        return visitor.visitLiteralCurrency(this);
    }

    /**
     * Returns the value of the literal.
     * @return the value of the literal
     */
    public Value getValue() {
        return this.value;
    }
}
