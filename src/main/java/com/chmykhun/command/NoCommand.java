package com.chmykhun.command;

import com.chmykhun.manager.Config;
import com.chmykhun.parsing.Currency;
import com.chmykhun.parsing.Exchange;
import org.xml.sax.SAXException;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;

public class NoCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse responce) throws ServletException, IOException {
        return Config.getInstance().getProperty(Config.SIGN_IN_PAGE);
    }
}
