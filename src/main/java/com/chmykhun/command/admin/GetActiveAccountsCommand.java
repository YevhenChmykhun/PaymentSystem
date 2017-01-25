package com.chmykhun.command.admin;

import com.chmykhun.command.Command;
import com.chmykhun.manager.Config;
import com.chmykhun.service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetActiveAccountsCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse responce) throws ServletException, IOException {
        String page = Config.getInstance().getProperty(Config.ADMIN_ACTIVE_ACCOUNTS_PAGE);

        request.setAttribute("accounts", AccountService.getActiveAccounts());

        return page;
    }
}
