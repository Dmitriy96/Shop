<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<html>
    <head>
        <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <title>Login Page</title>

        <c:url value='/resources/css/bootstrap.min.css' var="bootstrap"/>
        <link href="${bootstrap}" rel="stylesheet"/>
        <c:url value='/resources/css/signin.css' var="signin"/>
        <link href="${signin}" rel="stylesheet"/>
    </head>
    <body>

        <c:import url="fragments/header.jsp"/>

        <div class="container">

            <c:if test="${not empty error}">
                <div class="error">${error}</div>
            </c:if>
            <c:if test="${not empty msg}">
                <div class="msg">${msg}</div>
            </c:if>

            <c:url value='/j_spring_security_check' var="check"/>

            <form name='loginForm' action="${check}" method='post' class="form-signin">
                <h2 class="form-signin-heading">Please sign in</h2>
                <label for="inputUsername" class="sr-only">Username</label>
                <input type="text" id="inputUsername" name="username" class="form-control" placeholder="Username"/>
                <label for="inputPassword" class="sr-only">Password</label>
                <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password"/>
                <div class="checkbox">
                    <label>
                        <input type="checkbox" value="remember-me"> Remember me</input>
                    </label>
                </div>
                <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            </form>

        </div>
    </body>
</html>
