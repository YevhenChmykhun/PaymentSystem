package com.chmykhun.command.admin;

import com.chmykhun.command.Command;
import com.chmykhun.manager.Config;
import com.chmykhun.service.CardService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetUserCardsCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse responce) throws ServletException, IOException {
        String page = Config.getInstance().getProperty(Config.ADMIN_CARDS_PAGE);

        Long userId = Long.parseLong(request.getParameter("user_id"));
        request.setAttribute("cards", CardService.getAllByUserId(userId));

        return page;
    }

}
