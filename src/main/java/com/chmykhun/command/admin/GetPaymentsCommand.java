package com.chmykhun.command.admin;

import com.chmykhun.command.Command;
import com.chmykhun.manager.Config;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetPaymentsCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse responce) throws ServletException, IOException {
        String page = Config.getInstance().getProperty(Config.ADMIN_PAYMENTS_PAGE);

/*        PaymentDao dao = (PaymentDao) DaoFactory.getDaoFactory().getDaoByEntityClass(Payment.class);
        List<Payment> payments = dao.findAll();

        request.setAttribute("payments", payments);*/

        return page;
    }
}
