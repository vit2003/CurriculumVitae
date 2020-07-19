<%-- 
    Document   : viewcart
    Created on : Jul 14, 2020, 10:04:23 AM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View My Cart</title>
    </head>
    <body>
        <c:set var="current_account" value="${sessionScope.CURRENT_ACCOUNT}"/>
        <h1>${current_account.fullname} cart</h1>
        <c:set var="cart" value="${sessionScope.CART}"/>
        <c:if test="${empty cart.item}">
            <h3>Your cart is empty!</h3>
        </c:if>
        <c:if test="${not empty cart.item}">
            <table border='1'>
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>Book name</th>
                        <th>Quantity</th>
                        <th>Price</th>
                        <th>Total</th>
                        <th>Delete</th>
                    </tr>
                </thead>
                <tbody>
                <form action="deletecart">
                    <c:forEach var="item" items="${cart.item}" varStatus="counter">
                        <tr>
                            <td>${counter.count}</td>
                            <td> ${item.key.name} </td>
                            <td> ${item.value} </td>
                            <td> ${item.key.price} </td>
                            <td> ${item.key.price * item.value} </td>
                            <td> <input type="checkbox" name="chkDelete" value="${item.key.name}" /> </td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td colspan="5"><b>Total: </b></td>
                        <td> ${sessionScope.TOTAL_ALL_CART} </td>
                    </tr>
                    <tr>
                        <td colspan="5"></td>
                        <td> <input type="submit" value="delete" /> </td>
                    </tr>
                </form>
            </tbody>
        </table>

    </c:if>
    <form action="shoppingPageServlet">
        <input type="submit" value="Back to shopping" />
    </form>
    <form action="checkout">

        <input type="submit" value="check out" />
    </form>
    <form action="logOut">
        <input type="submit" value="Log Out" />
    </form>
</body>
</html>
