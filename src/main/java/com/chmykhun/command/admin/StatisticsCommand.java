package com.chmykhun.command.admin;

import com.chmykhun.command.Command;
import com.chmykhun.manager.Config;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StatisticsCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse responce) throws ServletException, IOException {
        String page = Config.getInstance().getProperty(Config.ADMIN_MAIN_PAGE);

/*        VisitorDao dao = (VisitorDao) DaoFactory.getDaoFactory().getDaoByEntityClass(Visitor.class);
        List<Visitor> visitors = dao.findAll();

        DateConverter dateConverter = new DateConverter();
        List<String> dates = new ArrayList<>();
        for (Visitor visitor : visitors) {
            String date = dateConverter.toDateInString(visitor.getDate(), DateConverter.YYYY_MM_DD);
            dates.add(date);
        }

        request.setAttribute("visitors", visitors);
        request.setAttribute("dates", dates);*/

        return page;
    }
}
