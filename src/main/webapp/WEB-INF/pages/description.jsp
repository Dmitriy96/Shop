<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <title>Product description</title>

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

        <div class="row page-header">
            <div class="col-md-9">
                <h1>${laptop.brandName} ${laptop.series} ${laptop.modelNumber}</h1>
            </div>
            <sec:authorize access="hasAnyRole('ROLE_USER')">
                <c:if test="${laptop.available}">
                    <c:url value='/user/basket/add/${laptop.idLaptop}' var="addToBasketUrl"/>
                    <form:form id="form" action="${addToBasketUrl}" method="post">
                        <div class="col-md-3 control-buttons-alignment">
                            <button type="submit" id="addToBasket" class="btn btn-primary" title="addToBasket">
                                <span class="glyphicon glyphicon-plus" aria-hidden="true"></span> Add to basket
                            </button>
                        </div>
                    </form:form>
                </c:if>
            </sec:authorize>
        </div>

        <div class="row">
            <div class="col-md-3">
                <img id="image"
                     class="img-responsive clickable"
                     src='${pageContext.request.contextPath}/resources/images/laptops/${laptop.idLaptop}.jpg'
                     alt=""
                     onerror="this.src='${pageContext.request.contextPath}/resources/images/laptops/default_laptop.jpg'">
            </div>
            <div class="col-md-4">
                <ul class="group-text-block">
                    <li class="text-block">
                        <h3>OS</h3>
                        <p><c:out value="${laptop.operatingSystem}"/> </p>
                    </li>
                    <li class="text-block">
                        <h3>Processor</h3>
                        <p><c:out value="${laptop.processorBrand} ${laptop.processorModel}"/></p>
                    </li>
                    <li class="text-block">
                        <h3>Clock Frequency</h3>
                        <p><c:out value="${laptop.processorClockFrequency} GHz"/></p>
                    </li>
                    <li class="text-block">
                        <h3>Processors count</h3>
                        <p><c:out value="${laptop.processorCount}"/></p>
                    </li>
                </ul>
            </div>
            <div class="col-md-4">
                <ul class="group-text-block">
                    <li class="text-block">
                        <h3>Battery Type</h3>
                        <p><c:out value="${laptop.batteryType}"/></p>
                    </li>
                    <li class="text-block">
                        <h3>Average Battery Life</h3>
                        <p><c:out value="${laptop.averageBatteryLife} hours"/></p>
                    </li>
                    <li class="text-block">
                        <h3>Screen size</h3>
                        <p><c:out value="${laptop.screenSize}'"/></p>
                    </li>
                </ul>
            </div>
        </div>

        <div class="row">
            <div class="col-md-6">
                <ul class="group-text-block">
                    <li class="text-block">
                        <h3>Memory Type</h3>
                        <p><c:out value="${laptop.memoryType}"/></p>
                    </li>
                    <li class="text-block">
                        <h3>Memory Size</h3>
                        <p><c:out value="${laptop.memorySize} MB"/></p>
                    </li>
                    <li class="text-block">
                        <h3>Hard Drive Capacity</h3>
                        <p><c:out value="${laptop.hardDriveCapacity} GB"/></p>
                    </li>
                    <li class="text-block">
                        <h3>Hard Drive Rotational Speed</h3>
                        <p><c:out value="${laptop.hardDriveRotationalSpeed} Turns/min"/></p>
                    </li>
                    <li class="text-block">
                        <h3>USB 2.0 parts number</h3>
                        <p><c:out value="${laptop.USB2_0Count}"/></p>
                    </li>
                    <li class="text-block">
                        <h3>USB 3.0 parts number</h3>
                        <p><c:out value="${laptop.USB3_0Count}"/></p>
                    </li>
                </ul>
            </div>
            <div class="col-md-6">
                <ul class="group-text-block">
                    <li class="text-block">
                        <h3>Dimension</h3>
                        <p><c:out value="${laptop.dimensionH}x${laptop.dimensionL}x${laptop.dimensionW}"/></p>
                    </li>
                    <li class="text-block">
                        <h3>Color</h3>
                        <p><c:out value="${laptop.color}"/></p>
                    </li>
                    <li class="text-block">
                        <h3>Weight</h3>
                        <p><c:out value="${laptop.weight} Kg"/></p>
                    </li>
                    <li class="text-block">
                        <h3>Screen Resolution</h3>
                        <p><c:out value="${laptop.screenResolutionX}x${laptop.screenResolutionY}"/></p>
                    </li>
                </ul>
            </div>
        </div>
        <sec:authorize access="hasRole('ROLE_ADMIN')">
            <form id="deleteProductForm" method="post" action="${pageContext.request.contextPath}/admin/product/delete/${laptop.idLaptop}?${_csrf.parameterName}=${_csrf.token}">
                <div class="form-group">
                    <button id="deleteButton" type="submit" class="btn-lg btn-primary pull-right">Delete product</button>
                </div>
            </form>
        </sec:authorize>
    </div>

    <div class="page-bottom"></div>

    <script type="javascript">
        window.onload = function() {
            document.getElementById("deleteButton").onclick = function() {
                var isConfirmed = confirm("Really delete this product?");
                if (isConfirmed) {
                    var form = document.getElementById("deleteProductForm");
                    form.submit();
                }
            };
        }
    </script>

</body>
</html>
