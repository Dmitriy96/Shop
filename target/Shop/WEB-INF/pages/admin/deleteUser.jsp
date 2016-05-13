<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin products page</title>
    <c:url value="/resources/css/bootstrap.min.css" var="bootstrap"/>
    <link href="${bootstrap}" rel="stylesheet"/>
    <c:url value='/resources/css/style.css' var="style"/>
    <link href="${style}" rel="stylesheet" />
</head>
<body>

    <c:import url="../fragments/header.jsp"/>
    <c:url value='/admin/user/delete?${_csrf.parameterName}=${_csrf.token}' var="user"/>

    <div class="container">
        <h4>Please, input user name for delete:</h4>
        <form method="post" action="${user}" role="form" class="form-horizontal">
            <label for="series" class="col-sm-3 col-md-3 control-label">Username</label>
            <div class="col-sm-6 col-md-6">
                <input id="series" name="username" type="text" class="form-control"/>
            </div>
            <div class="form-group">
                <button type="submit" class="btn-lg btn-primary pull-right">Delete</button>
            </div>
        </form>
    </div>

</body>
</html>
