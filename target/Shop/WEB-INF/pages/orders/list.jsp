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
                <c:if test="${not empty placedOrderList}">
                    <c:out value="${placedOrderList.size()}"/>
                    <table id="ordersTable" class="table table-hover">
                        <thead>
                            <tr>
                                <td>
                                    <div class="cell-text-alignment">Ordering Date</div>
                                </td>
                                <td>
                                    <div class="cell-text-alignment">Laptop Name</div>
                                </td>
                                <td>
                                    <div class="cell-text-alignment">Laptop OS</div>
                                </td>
                                <td>
                                    <div class="cell-text-alignment">Laptop cost, $</div>
                                </td>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${placedOrderList}" var="order">
                            <c:forEach items="${order.laptopList}" var="laptop">
                                <tr>
                                    <td>
                                        <div class="cell-text-alignment">${order.orderingDate}</div>
                                    </td>
                                    <td>
                                        <div class="cell-text-alignment">
                                            <a href="${pageContext.request.contextPath}/laptop/${laptop.idLaptop}">
                                                ${laptop.brandName} ${laptop.series} ${laptop.modelNumber}
                                            </a>
                                        </div>
                                    </td>
                                    <td>
                                        <div class="cell-text-alignment">${laptop.operatingSystem}</div>
                                    </td>
                                    <td>
                                        <div class="cell-text-alignment">${laptop.cost}</div>
                                    </td>
                                </tr>
                            </c:forEach>
                        </c:forEach>
                        </tbody>
                    </table>
                </c:if>
                <c:if test="${empty placedOrderList}">
                    <div id="emptyOrders" class="well well-lg text-center">
                        You haven't got orders.
                    </div>
                </c:if>
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
