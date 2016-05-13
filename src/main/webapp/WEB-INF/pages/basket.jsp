<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <title>Basket</title>

    <c:url value="/resources/css/bootstrap.min.css" var="bootstrapCss"/>
    <link href="${bootstrapCss}" rel="stylesheet"/>
    <c:url value="/resources/css/shop-item.css" var="shopItemCss"/>
    <link href="${shopItemCss}" rel="stylesheet"/>
    <c:url value="/resources/css/custom.css" var="customCss"/>
    <link href="${customCss}" rel="stylesheet"/>
</head>
<body>

    <c:import url="fragments/header.jsp"/>

    <div class="container">

        <div class="row">
            <form:form id="form" action="" method="post" modelAttribute="laptops">
                <div class="col-md-10 col-md-offset-2 left-vertical-divider">
                    <c:if test="${message != null}">
                        <div class="alert alert-danger" role="alert">
                            <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                            <span class="sr-only">Error:</span>
                            ${message}
                        </div>
                    </c:if>
                    <div class="table-responsive">
                        <table id="productsTable" class="table table-hover">
                            <tbody>
                            <c:forEach items="${laptops}" var="laptop">
                                <tr>
                                    <td>
                                        <div class="checkbox">
                                            <label>
                                                <input type="checkbox" name="contact" value="${laptop.idLaptop}">
                                            </label>
                                        </div>
                                    </td>
                                    <td>
                                        <div class="cell-text-alignment">${laptop.brandName} ${laptop.series} ${laptop.modelNumber}</div>
                                    </td>
                                    <td>
                                        <div class="cell-text-alignment">${laptop.inStock.cost} $</div>
                                    </td>
                                    <td>
                                        <div class="cell-alignment">
                                            <button type="button" id="deleteButton" name="removeLaptop" class="btn btn-info" data-url="${pageContext.request.contextPath}/user/basket/${laptop.idLaptop}" title="Remove">
                                                <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                                            </button>
                                        </div>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                        <div id="emptyBasket" class="well well-lg text-center hidden">
                            Your basket is empty.
                        </div>
                    </div>
                </div>
                <button type="button" id="purchaseButton" class="btn btn-info text-center" data-url="${pageContext.request.contextPath}/user/basket?${_csrf.parameterName}=${_csrf.token}" title="Purchase">
                    Purchase
                </button>
            </form:form>
        </div>

    </div>

    <script type="javascript">
        window.onload = function() {
            checkBasketEmpty();

            function checkBasketEmpty() {
                var productsTable = document.getElementById("productsTable");
                if (productsTable.lastElementChild.childElementCount == 0) {
                    document.getElementById("emptyBasket").classList.remove("hidden");
                }
            }
            document.getElementById("deleteButton").onclick = function() {
                var form = document.getElementById("form");
                form.action = this.getAttribute("data-url");
                form.submit();
            };
            document.getElementById("purchaseButton").onclick = function() {
                var form = document.getElementById("form");
                form.action = this.getAttribute("data-url");
                form.submit();
            };
        }
    </script>

</body>
</html>
