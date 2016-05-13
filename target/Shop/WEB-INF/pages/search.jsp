<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

    <c:import url="fragments/header.jsp"/>

    <div class="container">

        <h1 class="page-header">Laptop Search</h1>

        <c:url value='/search' var="search"/>

        <form:form role="form" modelAttribute="laptopSample" method="post" action="${search}">

            <div class="row">
                <div class="col-md-8">
                    <div class="form-group">
                        <label for="Brand">Brand</label>
                        <form:input type="text" class="form-control" id="Brand" path="brand"/>
                    </div>
                    <div class="form-group">
                        <label for="Model">Model</label>
                        <form:input type="text" class="form-control" id="Model" path="processorModel"/>
                    </div>
                    <div class="form-group">
                        <label for="screen">Screen Size</label>
                        <form:input type="text" class="form-control" id="screen" path="screen"/>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-3">
                    <div class="form-group">
                        <label for="clockFrom">Clock Frequency (from)</label>
                        <form:input type="text" class="form-control" id="clockFrom" path="clockFrom"/>
                    </div>
                    <div class="form-group">
                        <label for="procCountFrom">Processors count (from)</label>
                        <form:input type="text" class="form-control" id="procCountFrom" path="procCountFrom"/>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="form-group">
                        <label for="clockTo">Clock Frequency (to)</label>
                        <form:input type="text" class="form-control" id="clockTo" path="clockTo"/>
                    </div>
                    <div class="form-group">
                        <label for="procCountFrom">Processors count (to)</label>
                        <form:input type="text" class="form-control" id="procCountTo" path="procCountTo"/>
                    </div>
                </div>
            </div>


            <div class="row">
                <div class="col-md-8">
                    <div class="form-group">
                        <label for="capacity">Hard Drive Capacity</label>
                        <form:input type="text" class="form-control" id="capacity" path="capacity"/>
                    </div>
                    <div class="form-group">
                        <label for="memoryType">Memory Size</label>
                        <form:input type="text" class="form-control" id="memoryType" path="memoryType"/>
                    </div>
                </div>
            </div>

            <br/><br/><br/>

            <div class="row">
                <div class="col-md-3 col-md-offset-3 text-center">
                    <button type="submit" class="btn btn-success btn-lg button-size">Поиск</button>
                </div>
                <div class="col-md-1 text-center">
                    <button type="submit" class="btn btn-info btn-lg button-size">Назад</button>
                </div>
            </div>

        </form:form>

    </div>

    <div class="page-bottom"></div>

</body>
</html>
