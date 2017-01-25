package com.chmykhun.validation;

import com.chmykhun.util.LocalizationUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.validator.*;
import org.xml.sax.SAXException;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class ValidatorTool {

    private static final String VALIDATOR_RULES = "validator.xml";

    private Class formClass;
    private ResourceBundle bundle;
    private HttpServletRequest request;

    public ValidatorTool(HttpServletRequest request, Class formClass) {
        this.request = request;
        this.formClass = formClass;
        this.bundle = LocalizationUtils.getResourceBundle(request);
    }

    public <T> T validate() {

        return null;
    }

    private ValidatorResults performValidation() {
        Object formEntity = populateFormEntity(request);
        String className = formClass.getSimpleName();
        return performValidation(formEntity, className);
    }

    private ValidatorResults performValidation(Object bean, String form) {
        ValidatorResults results = null;
        ValidatorResources resources = null;
        try (InputStream inputStream = this.getClass().getResourceAsStream(VALIDATOR_RULES)) {
            resources = new ValidatorResources(inputStream);
            Validator validator = new Validator(resources, form);
            validator.setParameter(Validator.BEAN_PARAM, bean);
            results = validator.validate();
        } catch (IOException | SAXException | ValidatorException e) {
            throw new RuntimeException(e);
        }
        return results;
    }

    private Object populateFormEntity(HttpServletRequest request) {
        Object formEntity = null;
        try {
            formEntity = formClass.newInstance();
            BeanUtils.populate(formEntity, request.getParameterMap());
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return formEntity;
    }


/*    private String[] printResults(Object bean, ValidatorResults results,
                                  ValidatorResources res, String formName) {
        List messages = new ArrayList();

        Form form = resources.getForm(Locale.ENGLISH, formName);
        Iterator propertyNames = results.getPropertyNames().iterator();

        while (propertyNames.hasNext()) {
            String propertyName = (String) propertyNames.next();
            Field field = form.getField(propertyName);
            ValidatorResult result = results.getValidatorResult(propertyName);

            Iterator keys = result.getActions();

            while (keys.hasNext()) {
                String actName = (String) keys.next();
                ValidatorAction action = resources.getValidatorAction(actName);

                if (!result.isValid(actName)) {
                    //First, the field message
                    String msgKey = null;
                    msgKey = field.getMsg(actName);
                    //Else, the action message
                    if (msgKey == null) {
                        msgKey = action.getMsg();
                    }

                    //Add the message to the list
                    messages.add(msgKey);
                }
            }
        }

        if (messages.size() == 0) {
            return null;
        } else {
            return (String[]) messages.toArray(new String[messages.size()]);
        }
    }*/


}
