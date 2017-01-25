package com.chmykhun.parsing;

import com.chmykhun.manager.Config;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class Exchange {

    public static final String USD = "usd";
    public static final String EUR = "eur";

    private List<Currency> currencies;

    public Exchange() throws IOException, SAXException,
            ParserConfigurationException {
        URL url = new URL(Config.getInstance().getProperty(Config.EXCHANGE_SOURCE));
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        CurrencyHandler handler = new CurrencyHandler();
        saxParser.parse(url.openStream(), handler);
        currencies = handler.getCurrencies();
    }

    public List<Currency> getCurrencies() {
        return currencies;
    }

    public Currency getCurrencyByCode(String currencyCode) {
        Currency result = null;
        for (Currency currency : currencies) {
            if (currency.getCurrencyCode().equalsIgnoreCase(currencyCode)) {
                result = currency;
            }
        }
        return result;
    }

}
