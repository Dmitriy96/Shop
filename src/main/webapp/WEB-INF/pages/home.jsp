<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />

        <title>Home</title>

        <c:url value="/resources/css/bootstrap.min.css" var="bootstrapCss"/>
        <link href="${bootstrapCss}" rel="stylesheet"/>
        <c:url value="/resources/css/shop-homepage.css" var="homepageCss"/>
        <link href="${homepageCss}" rel="stylesheet"/>
        <c:url value="/resources/css/custom.css" var="customCss"/>
        <link href="${customCss}" rel="stylesheet"/>
    </head>
    <body>

        <c:import url="fragments/header.jsp"/>

        <div class="container">
            <c:forEach items="${laptops}" var="laptop">
                <div class="col-sm-4 col-lg-4 col-md-4">
                    <div class="thumbnail">
                        <div>
                            <img src="${pageContext.request.contextPath}/resources/images/laptops/${laptop.idLaptop}.jpg"
                                class="img-size"
                                onerror="this.src='${pageContext.request.contextPath}/resources/images/laptops/default_laptop.jpg'" sizes=""/>
                        </div>
                        <div class="caption">
                            <h4 class="pull-right">${laptop.inStock.cost} $</h4>
                            <h4><a href="${pageContext.request.contextPath}/laptop/${laptop.idLaptop}">${laptop.brandName} ${laptop.series} ${laptop.modelNumber}</a>
                            </h4>
                            <p><strong>OS:</strong> ${laptop.operatingSystem}, <strong>Hard Drive:</strong> ${laptop.hardDriveCapacity} GB, <strong>Memory size:</strong> ${laptop.memorySize} MB, <strong>Processor count:</strong> ${laptop.processorCount}</p>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>

        <input id="currentPageNumber" class="hidden" type="text" value="${currentPageNumber}"/>
        <input id="pagesNumber" class="hidden" type="text" value="${pagesNumber}"/>
        <div id="qunit"></div>
        <div id="qunit-fixture"></div>
        <ul id="pagination"></ul>

        <div class="page-bottom"></div>

        <c:url value="/resources/js/jquery-1.11.3.min.js" var="jquery"/>
        <script type="text/javascript" src="${jquery}"></script>
        <c:url value="/resources/js/bootstrap.min.js" var="bootstrapJs"/>
        <script type="text/javascript" src="${bootstrapJs}"></script>
        <%--<c:url value="/resources/js/pagination.js" var="pagination"/>
        <script type="text/javascript" src="${pagination}"></script>--%>
        <c:url value="/resources/js/loadingLaptops.js" var="loadingLaptops"/>
        <script type="text/javascript" src="${loadingLaptops}"></script>

    </body>
</html>
