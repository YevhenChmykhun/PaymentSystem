package com.chmykhun.tag;

import com.chmykhun.parsing.Currency;
import com.chmykhun.parsing.Exchange;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class CurrencyTag extends TagSupport {
    private static Logger log = LogManager.getLogger(CurrencyTag.class);

    private static final String ERROR = "wrong currency code";
    private static final String DOUBLE_FORMAT = "#0.0000";

    private String code;

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public int doStartTag() throws JspException {
        try {
            Exchange exchange = new Exchange();
            Currency currency = exchange.getCurrencyByCode(code.toLowerCase());
            if (currency != null) {
                NumberFormat formatter = new DecimalFormat(DOUBLE_FORMAT);
                pageContext.getOut().write(formatter.format(currency.getRate()));
            } else {
                pageContext.getOut().write(ERROR);
            }
        } catch (SAXException | ParserConfigurationException | IOException e) {
            log.log(Level.ERROR, e);
        }

        return SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }

}
