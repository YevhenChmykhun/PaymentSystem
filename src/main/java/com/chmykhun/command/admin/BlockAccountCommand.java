package com.chmykhun.command.admin;

import com.chmykhun.command.Command;
import com.chmykhun.manager.Config;
import com.chmykhun.service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BlockAccountCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse responce) throws ServletException, IOException {
        String page = request.getParameter("next_page");

        Long accountId = Long.parseLong(request.getParameter("account_id"));
        AccountService.blockById(accountId);

        return page;
    }

}
