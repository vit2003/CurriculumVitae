<%-- 
    Document   : createaccount
    Created on : Jul 15, 2020, 8:34:24 PM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create New Account</title>
    </head>
    <body>
        <h1>Create account page</h1>
        <c:set var="error" value="${requestScope.CREATE_ACCOUNT_ERROR}"/>
        <form action="newaccount">
            Username*: <input type="text" name="txtUsername" value="${param.txtUsername}" /><br/>
            <c:if test="${not empty error.usernameLegthErr}">
                <h4 style="color: red">${error.usernameLegthErr}</h4>
            </c:if>
            Password*: <input type="password" name="txtPassword" value="" /><br/>
            <c:if test="${not empty error.passwordLegthErr}">
                <h4 style="color: red">${error.passwordLegthErr}</h4>
            </c:if>
            Confirm*: <input type="password" name="txtConfirm" value="" /><br/>
            <c:if test="${not empty error.confirmWrongErr}">
                <h4 style="color: red">${error.confirmWrongErr}</h4>
            </c:if>
                Fullname*: <input type="text" name="txtFullname" value="${param.txtFullname}" /><br/>
            <c:if test="${not empty error.fullnameLegthErr}">
                <h4 style="color: red">${error.fullnameLegthErr}</h4>
            </c:if>
                Address*: <input type="text" name="txtAddress" value="${param.txtAddress}" /><br/>
            <c:if test="${not empty error.addressLegthErr}">
                <h4 style="color: red">${error.addressLegthErr}</h4>
            </c:if>
            <input type="submit" value="Create" /> &nbsp;
            <input type="reset" value="Reset" />
        </form>
        <c:if test="${not empty error.duplacateAccountErr}">
                <h4 style="color: red">${error.duplacateAccountErr}</h4>
            </c:if>
        <a href="loginPage">Back to login</a>
    </body>
</html>
