/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chmykhun.command;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
    String execute(HttpServletRequest request, HttpServletResponse responce) throws ServletException, IOException;
}
