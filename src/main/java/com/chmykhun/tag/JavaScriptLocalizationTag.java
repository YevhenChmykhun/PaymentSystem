package com.chmykhun.tag;

import com.chmykhun.util.LocalizationUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.Enumeration;
import java.util.ResourceBundle;

public class JavaScriptLocalizationTag extends TagSupport {

    private String prefixe;

    public void setPrefixe(String prefixe) {
        this.prefixe = prefixe;
    }

    @Override
    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        try {
            out.write("<script type=\"text/javascript\"> var localization = { ");
            ResourceBundle bundle = LocalizationUtils.getResourceBundle((HttpServletRequest) pageContext.getRequest());
            Enumeration keys = bundle.getKeys();
            while (keys.hasMoreElements()) {
                String key = (String) keys.nextElement();
                if (key.startsWith(prefixe)) {
                    out.write("\"" + key + "\" : \"" + bundle.getString(key) + "\",");
                }
            }
            out.write("} </script>");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }

}
