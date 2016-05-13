<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Orders</title>
        <c:url value="/resources/css/bootstrap.min.css" var="bootstrap"/>
        <link href="${bootstrap}" rel="stylesheet"/>
    </head>
    <body>

        <c:import url="../fragments/header.jsp"/>

        <div>
            <div class="container">
                <h2>Orders of ${user.username}</h2>
                <div class="table-responsive">
                    <table id="ordersTable" class="table table-hover">
                        <tbody>
                        <c:forEach items="${placedOrderList}" var="order">
                            <tr>
                                <td>
                                    <div class="cell-text-alignment">{laptop.brandName} ${laptop.series} ${laptop.modelNumber}</div>
                                </td>
                                <td>
                                    <div class="cell-text-alignment">${laptop.operatingSystem}</div>
                                </td>
                                <td>
                                    <div class="cell-text-alignment">${laptop.inStock.cost} $</div>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <div id="emptyOrders" class="well well-lg text-center hidden">
                        You haven't got orders.
                    </div>
                </div>
            </div>
        </div>

        <script type="javascript">
            window.onload = function() {
                checkTableEmpty();

                function checkTableEmpty() {
                    var ordersTable = document.getElementById("ordersTable");
                    if (ordersTable.lastElementChild.childElementCount == 0) {
                        document.getElementById("emptyOrders").classList.remove("hidden");
                    }
                }
            }
        </script>
    </body>
</html>
