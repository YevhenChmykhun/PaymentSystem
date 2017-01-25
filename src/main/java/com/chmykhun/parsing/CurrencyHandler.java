package com.chmykhun.parsing;

import com.chmykhun.util.DateUtils;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CurrencyHandler extends DefaultHandler {
    private static Logger log = LogManager.getLogger(CurrencyHandler.class);

    private List<Currency> currencies = new ArrayList<>();
    private Currency currency;
    private String thisElement;

    public List<Currency> getCurrencies() {
        return currencies;
    }

    @Override
    public void startDocument() throws SAXException {
        log.log(Level.DEBUG, "Start parsing XML to get exchange rate");
    }

    @Override
    public void startElement(String namespaceURI, String localName,
                             String qName, Attributes atts) throws SAXException {
        thisElement = qName;
        if (qName.equalsIgnoreCase("currency")) {
            currency = new Currency();
        }
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName)
            throws SAXException {
        if (qName.equalsIgnoreCase("currency")) {
            currencies.add(currency);
            currency = new Currency();
        }
        thisElement = "";
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        if (thisElement.equalsIgnoreCase("rate")) {
            currency.setRate(new BigDecimal(new String(ch, start, length)));
        }
        if (thisElement.equalsIgnoreCase("cc")) {
            currency.setCurrencyCode(new String(ch, start, length));
        }
        if (thisElement.equalsIgnoreCase("exchangedate")) {
            currency.setExchangeDate(DateUtils.stringToLocalDate(new String(ch, start, length), DateUtils.DD_MM_YYYY));
        }
    }

    @Override
    public void endDocument() {
        log.log(Level.DEBUG, "Stop parsing XML");
    }

}
