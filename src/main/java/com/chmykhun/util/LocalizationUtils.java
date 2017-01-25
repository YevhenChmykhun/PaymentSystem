package com.chmykhun.util;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;
import java.util.ResourceBundle;

public class LocalizationUtils {

    private static final String RESOURCE_BUNDLE_NAME = "messages";
    private static final String LOCALE_KEY = "javax.servlet.jsp.jstl.fmt.locale.session";

    public static Locale getCurrentLocale(HttpServletRequest request) {
        Locale locale = (Locale) request.getSession().getAttribute(LOCALE_KEY);
        if (locale == null) {
            locale = request.getLocale();
        }
        return locale;
    }

    public static ResourceBundle getResourceBundle(HttpServletRequest request) {
        return ResourceBundle.getBundle(RESOURCE_BUNDLE_NAME, getCurrentLocale(request));
    }

}
