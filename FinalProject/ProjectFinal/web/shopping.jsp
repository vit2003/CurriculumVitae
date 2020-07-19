<%-- 
    Document   : shopping.jsp
    Created on : Jul 12, 2020, 1:17:58 PM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping Page</title>
    </head>
    <body>
        <c:set var="loginAccount" value="${sessionScope.CURRENT_ACCOUNT}"/>
        <c:if test="${empty loginAccount}">
            <c:redirect url="loginPage"/>
        </c:if>
        <h1>Book Store</h1>
        <h3 style="color: red"> Welcome ${loginAccount.fullname} </h3>
        <c:set var="store" value="${sessionScope.PRODUCT_STORE}"/>
        <c:set var="listCategories" value="${sessionScope.CATEGORY_DTO}"/>
        <c:forEach var="category" items="${listCategories}">
            <h4>${category.name} book</h4>
            <hr/>
            <table border='1'>
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Add to cart</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="book" items="${store}">
                        <c:if test="${book.category eq category.id}">
                            <tr>
                        <form action="addToCart">
                            <td>${book.name}</td>
                            <td>${book.price}</td>
                            <td> 
                                <input type="submit" value="add book to cart" />
                                <input type="hidden" name="txtBookName" value="${book.name}" />
                            </td>
                        </form>
                    </tr>
                </c:if>
            </c:forEach>
        </tbody>
    </table>
</c:forEach>
<form action="viewmycart">
    <input type="submit" value="View My Cart" />
</form>
            <c:if test="${not empty requestScope.CHECKOUT_STATUS}">
                <h3>${requestScope.CHECKOUT_STATUS}</h3>
            </c:if>
<form action="logOut">
    <input type="submit" value="Log Out" />
</form>
</body>
</html>
