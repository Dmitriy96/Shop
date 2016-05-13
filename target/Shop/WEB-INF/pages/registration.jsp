<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<html>
    <head>
        <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <title>Registration Page</title>

        <c:url value='/resources/css/bootstrap.min.css' var="bootstrap"/>
        <link href="${bootstrap}" rel="stylesheet"/>
        <c:url value='/resources/css/style.css' var="style"/>
        <link href="${style}" rel="stylesheet" />
    </head>
    <body>
        <c:import url="fragments/header.jsp"/>

        <c:url value='/registration?${_csrf.parameterName}=${_csrf.token}' var="register"/>

        <div class="container">
            <form:form id="form" name='signupForm' modelAttribute="user" method="post" action="${register}" enctype="multipart/form-data" role="form" cssClass="form-horizontal">
                <h2 class="form-signin-heading col-sm-offset-3">Please sign up</h2>
                <div>${error}</div>
                <form:errors cssClass="errorMessage"/>

                <div class="form-group">
                    <div class="row">
                        <label for="username" class="col-sm-3 col-md-3 control-label">Username</label>
                        <div class="col-sm-6 col-md-6">
                            <form:input type="text" id="username" path="username" cssClass="form-control" placeholder="Username"/>
                            <form:errors cssClass="errorMessage" path="username"/>
                            <c:if test="${not empty usernameExists}">
                                <span class="errorMessage"><c:out value="${usernameExists}"/></span>
                            </c:if>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <div class="row">
                        <label for="email" class="col-sm-3 col-md-3 control-label">Email</label>
                        <div class="col-sm-6 col-md-6">
                            <form:input type="email" id="email" path="email" cssClass="form-control" placeholder="Email"/>
                            <form:errors cssClass="errorMessage" path="email"/>
                            <c:if test="${not empty emailExists}">
                                <span class="errorMessage"><c:out value="${emailExists}"/></span>
                            </c:if>
                        </div>
                    </div>
                </div>

                <div class="form-group" id="passwordBlock">
                    <div class="row">
                        <label for="password" class="col-sm-3 col-md-3 control-label">Password</label>
                        <div class="col-sm-6 col-md-6">
                            <form:password id="password" path="password" class="form-control" placeholder="Password"/>
                            <span class="errorMessage" style="display: none">Please, input password</span>
                            <form:errors cssClass="errorMessage" path="password"/>
                        </div>
                    </div>
                </div>

                <div class="form-group" id="confirmPasswordBlock">
                    <div class="row">
                        <label for="confirmPassword" class="col-sm-3 col-md-3 control-label">Confirm Password</label>
                        <div class="col-sm-6 col-md-6">
                            <input id="confirmPassword" type="password" class="form-control" placeholder="Confirm Password"/>
                            <span class="errorMessage" style="display: none">Check your confirm password value</span>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <div class="row">
                        <div class="col-sm-offset-5 col-sm-2">
                            <button class="btn btn-lg btn-primary center-block btn-block" id="submit" type="submit">Sign up</button>
                        </div>
                    </div>
                </div>
            </form:form>
        </div>

        <c:url value="/resources/js/jquery-1.11.3.min.js" var="jquery"/>
        <script type="text/javascript" src="${jquery}"></script>
        <c:url value="/resources/js/passwordCheck.js" var="passwordCheck"/>
        <script type="text/javascript" src="${passwordCheck}"></script>

    </body>
</html>
