<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Head</title>
        <c:url value="/resources/css/bootstrap.min.css" var="bootstrap"/>
        <link href="${bootstrap}" rel="stylesheet"/>
    </head>
    <body>

        <c:url value="/j_spring_security_logout" var="logoutUrl" />

        <div class="container">
            <nav class="navbar navbar-default">
                <div class="container">
                    <div class="container-fluid">
                        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                            <ul class="nav navbar-nav">
                                <li><a href="${pageContext.request.contextPath}/home">Home</a></li>
                                <sec:authorize access="hasAnyRole('ROLE_USER')">
                                    <li><a href="${pageContext.request.contextPath}/user/orders">Orders</a></li>
                                    <li><a href="${pageContext.request.contextPath}/user/basket">Basket</a></li>
                                </sec:authorize>
                                <sec:authorize access="hasRole('ROLE_ADMIN')">
                                    <li><a href="${pageContext.request.contextPath}/admin/product/add">Add Product</a></li>
                                    <li><a href="${pageContext.request.contextPath}/admin/user/delete">Delete User</a></li>
                                </sec:authorize>
                            </ul>
                            <sec:authorize access="isAuthenticated()">
                                <ul class="nav navbar-nav navbar-right">
                                    <li>
                                        <a href="javascript:submitLogout()">Logout</a>
                                    </li>
                                </ul>
                            </sec:authorize>
                            <sec:authorize access="!isAuthenticated()">
                                <ul class="nav navbar-nav navbar-right">
                                    <li>
                                        <a href="${pageContext.request.contextPath}/login">Login</a>
                                    </li>
                                </ul>
                                <ul class="nav navbar-nav navbar-right">
                                    <li>
                                        <a href="${pageContext.request.contextPath}/registration">Sign up</a>
                                    </li>
                                </ul>
                            </sec:authorize>
                        </div>
                    </div>
                </div>
            </nav>
        </div>

        <form action="${logoutUrl}" method="post" id="logoutForm">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        </form>
        <script>
            function submitLogout() {
                document.getElementById("logoutForm").submit();
            }
        </script>

    </body>
</html>
