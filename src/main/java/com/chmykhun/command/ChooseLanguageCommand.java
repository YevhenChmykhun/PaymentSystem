package com.chmykhun.command;

import com.chmykhun.manager.Config;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChooseLanguageCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse responce) throws ServletException, IOException {

        // get language choice
        String language = request.getParameter("language");

        // place in request scope
        request.setAttribute("language", language);

        return Config.getInstance().getProperty(Config.SIGN_IN_PAGE);
    }
}
