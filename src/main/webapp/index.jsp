<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="customtags" prefix="ctg" %>

<%-- Set language based on user's choice --%>
<c:if test="${!empty language}">
    <fmt:setLocale value="${language}" scope="session"/>
</c:if>

<!DOCTYPE html>
<html>
<head>
    <title><fmt:message key='title.index'/></title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:600">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
</head>
<body>

<div class="login-wrap">
    <div class="login-html">

        <header class="header">
            <div class="exchange-rates-container" data-name="exchange-rates-container">
                <div class="section">
                    <div class="section-content type"><fmt:message key="currency.usd"/></div>
                    <div class="section-content rate"><ctg:currency code="usd"/></div>
                </div>
                <div class="section">
                    <div class="section-content type"><fmt:message key="currency.eur"/></div>
                    <div class="section-content rate"><ctg:currency code="eur"/></div>
                </div>
            </div>
            <%@ include file="WEB-INF/view/common/languages_toggle.jsp" %>
        </header>

        <div class="action-container">
            <input id="tab-1" type="radio" name="tab" class="sign-in" checked><label for="tab-1"
                                                                                     class="tab"><fmt:message
                key='label.sign_in'/></label>
            <input id="tab-2" type="radio" name="tab" class="sign-up"><label for="tab-2" class="tab"><fmt:message
                key='label.sign_up'/></label>
            <div class="login-form">
                <div class="sign-in-htm">
                    <form data-name="form" action="${pageContext.request.contextPath}/controller" method="post"
                          name="sign-in" class="form" novalidate="novalidate">
                        <input type="hidden" name="command" value="sign_in">

                        <div class="group">
                            <label class="label"><fmt:message key='label.phone_number'/></label>
                            <input class="input valid" name="phoneNumber" type="text" autofocus="" value="+380"
                                   autocomplete="off" placeholder="" aria-required="true" aria-invalid="false">
                        </div>
                        <div class="group">
                            <label class="label"><fmt:message key='label.password'/></label>
                            <input type="password" class="input" data-type="password" name="password"
                                   autofocus="" autocomplete="off" placeholder="">

                        </div>
                        <div class="group">
                            <input type="submit" class="button" value="<fmt:message key="button.submit"/>">
                        </div>
                    </form>
                </div>

                <div class="sign-up-htm">
                    <div class="group">
                        <label class="label">Username</label>
                        <input type="text" class="input">
                    </div>
                    <div class="group">
                        <label class="label">Password</label>
                        <input type="password" class="input" data-type="password">
                    </div>
                    <div class="group">
                        <label class="label">Repeat Password</label>
                        <input type="password" class="input" data-type="password">
                    </div>
                    <div class="group">
                        <label class="label">Email Address</label>
                        <input type="text" class="input">
                    </div>
                    <div class="group">
                        <input type="submit" class="button" value="<fmt:message key="button.submit"/>">
                    </div>
                    <div class="hr"></div>
                    <div class="foot-lnk">
                        <label for="tab-1">Already Member?</label>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.16.0/jquery.validate.min.js"></script>

<ctg:js-localization prefixe="validation"/>
<script src="${pageContext.request.contextPath}/js/common.js"></script>
<script src="${pageContext.request.contextPath}/js/validation.js"></script>

</body>
</html>