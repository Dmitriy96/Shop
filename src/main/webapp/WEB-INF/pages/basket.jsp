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
                <div class="col-md-12">
                    <div class="table-responsive">
                        <c:if test="${not empty laptops}">
                            <table id="productsTable" class="table table-hover">
                                <thead>
                                    <tr>Name</tr>
                                    <tr>Cost</tr>
                                    <tr></tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${laptops}" var="laptop">
                                    <tr>
                                        <td>
                                            <div class="cell-text-alignment">
                                                 ${laptop.brandName} ${laptop.series} ${laptop.modelNumber}
                                            </div>
                                        </td>
                                        <td>
                                            <div class="cell-text-alignment">${laptop.cost} $</div>
                                        </td>
                                        <td>
                                            <div class="cell-alignment">
                                                <button type="button" name="removeLaptop" class="btn btn-danger" data-url="${pageContext.request.contextPath}/user/basket/remove/${laptop.idLaptop}" title="Remove">
                                                    <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                                                </button>
                                            </div>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </c:if>
                        <c:if test="${empty laptops}">
                            <div id="emptyBasket" class="well well-lg text-center">
                                Your basket is empty.
                            </div>
                        </c:if>
                    </div>
                </div>
            </form:form>
            <c:url value='/user/basket?${_csrf.parameterName}=${_csrf.token}' var="basketUrl"/>
            <form:form id="purchaseForm" action="${basketUrl}" method="post">
                <div>
                    <c:set var="basketLaptopIds" value=""/>
                    <c:forEach items="${laptops}" var="laptop">
                        <c:set var="idAsString">${laptop.idLaptop}</c:set>
                        <c:set var="basketLaptopIds" value="${basketLaptopIds} ${idAsString}"/>
                    </c:forEach>
                    <input id="basketLaptopIds" name="basketLaptopIds" class="hidden" type="text" value="${basketLaptopIds}"/>
                </div>
                <button type="submit" id="purchaseButton" class="btn btn-info text-center pull-right" data-url="${pageContext.request.contextPath}/user/basket?${_csrf.parameterName}=${_csrf.token}" title="Purchase">
                    Purchase
                </button>
            </form:form>
        </div>

    </div>

    <c:url value="/resources/js/basket.js" var="basket"/>
    <script type="text/javascript" src="${basket}"></script>

</body>
</html>
