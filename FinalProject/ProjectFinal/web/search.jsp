<%-- 
    Document   : search
    Created on : Jul 12, 2020, 1:06:53 PM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Account Management Page</title>
    </head>
    <body>
        <c:set var="loginAccount" value="${sessionScope.CURRENT_ACCOUNT}"/>
        <c:set var="updateAccountError" value="${sessionScope.UPDATE_ERROR}"/>
        <c:if test="${not empty loginAccount}">
            <c:if test="${not loginAccount.isAdmin.booleanValue()}">
                <c:redirect url="shoppingPage"/>
            </c:if>
        </c:if>
        <c:if test="${empty loginAccount}">
            <c:redirect url="loginPage"/>
        </c:if>
        <h1>Admin Page</h1>
        <h3 style="color: red">${loginAccount.fullname}</h3>
        <form action="search">
            Search: <input type="text" name="txtSearch" value="${param.txtSearch}" /> &nbsp;
            <input type="submit" value="Search" />
        </form>
        <c:if test="${not empty updateAccountError.changeCurrentAccountErr}">
            <h3 style="color: red">${updateAccountError.changeCurrentAccountErr}</h3> 
        </c:if>
        <c:if test="${not empty updateAccountError.updateDatabaseErr}">
            <h3 style="color: red">${updateAccountError.updateDatabaseErr}</h3> 
        </c:if>
        <c:if test="${not empty requestScope.DELETE_ACCOUNT_ERROR}">
            <h3 style="color: red">${requestScope.DELETE_ACCOUNT_ERROR}</h3>
        </c:if>
        <c:if test="${not empty requestScope.First_Search}">
            <c:set var="searchResult" value="${requestScope.SEARCH_RESULT}"/>
            <c:if test="${not empty searchResult}">
                <table border='1'>
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Username</th>
                            <th>Password</th>
                            <th>Fullname</th>
                            <th>IsAdmin</th>
                            <th>Address</th>
                            <th>Delete</th>
                            <th>Update</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="dto" items="${searchResult}" varStatus="counter">
                        <form action="update">
                            <tr>
                                <td>${counter.count}.</td>
                                <td>
                                    ${dto.username}
                                    <input type="hidden" name="txtUsername" value="${dto.username}" />
                                </td>
                                <td>
                                    <input type="text" name="txtPassword" value="${dto.password}" />
                                </td>
                                <td>${dto.fullname}</td>
                                <td>
                                    <c:if test="${dto.isAdmin.booleanValue()}">
                                        <input type="checkbox" name="chkAdmin" value="ON" checked="checked" />
                                    </c:if>
                                    <c:if test="${not dto.isAdmin.booleanValue()}">
                                        <input type="checkbox" name="chkAdmin" value="ON"/>
                                    </c:if>
                                </td>
                                <td> <input type="text" name="txtAddress" value="${dto.address}" /> </td>
                                <td>
                                    <c:url var="deleteRewrite" value="delete">
                                        <c:param name="pk" value="${dto.username}"/>
                                        <c:param name="searchValue" value="${param.txtSearch}"/>
                                    </c:url>
                                    <a href="${deleteRewrite}">delete</a>
                                </td>
                                <td>
                                    <input type="hidden" name="txtLastSearch" value="${param.txtSearch}" />
                                    <input type="submit" value="update" />
                                </td>
                            </tr>
                        </form>
                    </c:forEach>
                </tbody>
            </table>
            <c:if test="${not empty updateAccountError.passwordLegthErr}">
                <h5 style="color: red">${updateAccountError.passwordLegthErr}</h5> 
            </c:if>
            <c:if test="${not empty updateAccountError.unAdminErr}">
                <h5 style="color: red">${updateAccountError.unAdminErr}</h5> 
            </c:if>
            <c:if test="${not empty updateAccountError.nullAddressErr}">
                <h5 style="color: red">${updateAccountError.nullAddressErr}</h5> 
            </c:if>
        </c:if>
        <c:if test="${empty searchResult}">
            <h3>No record is matched !!!</h3>
        </c:if>
    </c:if>
            <form action="shoppingPageServlet">
                <input type="submit" value="Shopping book online" />
            </form>
    <form action="logOut">
        <input type="submit" value="Log Out" />
    </form>
</body>
</html>
