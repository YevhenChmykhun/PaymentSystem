/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chmykhun.command;

import com.chmykhun.jdbc.entity.User;
import com.chmykhun.jdbc.entity.UserType;
import com.chmykhun.manager.Config;
import com.chmykhun.service.UserService;
import com.chmykhun.validation.ValidatorTool;
import com.chmykhun.validation.form.SignInForm;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignInCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse responce) throws ServletException, IOException {
        String page = null;

        SignInForm signInForm = new ValidatorTool(request, SignInForm.class).validate();
        if (signInForm.isValid()) {

        } else {

        }

        User user = UserService.sighIn(signInForm.getPhoneNumber(), signInForm.getPassword());

        if (user == null) {
            page = Config.getInstance().getProperty(Config.SIGN_IN_PAGE);
            return page;
        }

        if (user.getUserType().equals(UserType.ADMIN)) {
            request.getSession().setAttribute("admin", user);
            page = Config.getInstance().getProperty(Config.ADMIN_MAIN_PAGE);
        } else {
            request.getSession().setAttribute("user", user);
            page = Config.getInstance().getProperty(Config.USER_MAIN_PAGE);
        }

        return page;
    }
}
