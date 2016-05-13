<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Admin add product page</title>
        <c:url value="/resources/css/bootstrap.min.css" var="bootstrap"/>
        <link href="${bootstrap}" rel="stylesheet"/>
        <c:url value='/resources/css/style.css' var="style"/>
        <link href="${style}" rel="stylesheet" />
    </head>
    <body>
        <c:import url="../fragments/header.jsp"/>

        <c:url value='/admin/product/add?${_csrf.parameterName}=${_csrf.token}' var="product"/>

        <div class="container">
            <h4>Add laptop:</h4>
            <form:form method="post" modelAttribute="laptop" action="${product}" role="form" cssClass="form-horizontal">
                <div class="form-group row">
                    <label for="brandName" class="col-sm-3 col-md-3 control-label">Brand</label>
                    <div class="col-sm-6 col-md-6">
                        <form:select id="brandName" cssClass="form-control" path="brandName" items="${brandNameMap}"/>
                        <form:errors path="brandName" cssClass="control-label errorMessage" />
                    </div>
                </div>
                <div class="form-group row">
                    <label for="series" class="col-sm-3 col-md-3 control-label">Series</label>
                    <div class="col-sm-6 col-md-6">
                        <form:input id="series" type="text" cssClass="form-control" path="series"/>
                        <form:errors path="series" cssClass="control-label errorMessage" />
                    </div>
                </div>
                <div class="form-group row">
                    <label for="modelNumber" class="col-sm-3 col-md-3 control-label">Model Number</label>
                    <div class="col-sm-6 col-md-6">
                        <form:input id="modelNumber" type="text" cssClass="form-control" path="modelNumber"/>
                        <form:errors path="modelNumber" cssClass="control-label errorMessage" />
                    </div>
                </div>
                <div class="form-group row">
                    <label for="operatingSystem" class="col-sm-3 col-md-3 control-label">Brand</label>
                    <div class="col-sm-6 col-md-6">
                        <form:select id="operatingSystem" cssClass="form-control" path="operatingSystem" items="${operatingSystemMap}"/>
                        <form:errors path="operatingSystem" cssClass="control-label errorMessage" />
                    </div>
                </div>
                <div class="form-group row">
                    <label for="weight" class="col-sm-3 col-md-3 control-label">Weight</label>
                    <div class="col-sm-6 col-md-6">
                        <form:input id="weight" type="text" cssClass="form-control" path="weight"/>
                        <form:errors path="weight" cssClass="control-label errorMessage" />
                    </div>
                </div>
                <div class="form-group row">
                    <label for="dimensionL" class="col-sm-3 col-md-3 control-label">DimensionL</label>
                    <div class="col-sm-6 col-md-6">
                        <form:input id="dimensionL" type="text" cssClass="form-control" path="dimensionL"/>
                        <form:errors path="dimensionL" cssClass="control-label errorMessage" />
                    </div>
                </div>
                <div class="form-group row">
                    <label for="dimensionW" class="col-sm-3 col-md-3 control-label">DimensionW</label>
                    <div class="col-sm-6 col-md-6">
                        <form:input id="dimensionW" type="text" cssClass="form-control" path="dimensionW"/>
                        <form:errors path="dimensionW" cssClass="control-label errorMessage" />
                    </div>
                </div>
                <div class="form-group row">
                    <label for="dimensionH" class="col-sm-3 col-md-3 control-label">DimensionH</label>
                    <div class="col-sm-6 col-md-6">
                        <form:input id="dimensionH" type="text" cssClass="form-control" path="dimensionH"/>
                        <form:errors path="dimensionH" cssClass="control-label errorMessage" />
                    </div>
                </div>
                <div class="form-group row">
                    <label for="color" class="col-sm-3 col-md-3 control-label">Color</label>
                    <div class="col-sm-6 col-md-6">
                        <form:input id="color" type="text" cssClass="form-control" path="color"/>
                        <form:errors path="color" cssClass="control-label errorMessage" />
                    </div>
                </div>
                <div class="form-group row">
                    <label for="batteryType" class="col-sm-3 col-md-3 control-label">Battery Type</label>
                    <div class="col-sm-6 col-md-6">
                        <form:input id="batteryType" type="text" cssClass="form-control" path="batteryType"/>
                        <form:errors path="batteryType" cssClass="control-label errorMessage" />
                    </div>
                </div>
                <div class="form-group row">
                    <label for="averageBatteryLife" class="col-sm-3 col-md-3 control-label">Average Battery Life</label>
                    <div class="col-sm-6 col-md-6">
                        <form:input id="averageBatteryLife" type="text" cssClass="form-control" path="averageBatteryLife"/>
                        <form:errors path="averageBatteryLife" cssClass="control-label errorMessage" />
                    </div>
                </div>
                <div class="form-group row">
                    <label for="laptopScreenSize" class="col-sm-3 col-md-3 control-label">Screen Size</label>
                    <div class="col-sm-6 col-md-6">
                        <form:input id="laptopScreenSize" type="text" cssClass="form-control" path="screenSize"/>
                        <form:errors path="screenSize" cssClass="control-label errorMessage" />
                    </div>
                </div>
                <div class="form-group row">
                    <label for="screenResolutionY" class="col-sm-3 col-md-3 control-label">Screen Resolution Y</label>
                    <div class="col-sm-6 col-md-6">
                        <form:input id="screenResolutionY" type="text" cssClass="form-control" path="screenResolutionY"/>
                        <form:errors path="screenResolutionY" cssClass="control-label errorMessage" />
                    </div>
                </div>
                <div class="form-group row">
                    <label for="screenResolutionX" class="col-sm-3 col-md-3 control-label">Screen Resolution X</label>
                    <div class="col-sm-6 col-md-6">
                        <form:input id="screenResolutionX" type="text" cssClass="form-control" path="screenResolutionX"/>
                        <form:errors path="screenResolutionX" cssClass="control-label errorMessage" />
                    </div>
                </div>
                <div class="form-group row">
                    <label for="processorBrand" class="col-sm-3 col-md-3 control-label">Processor Brand</label>
                    <div class="col-sm-6 col-md-6">
                        <form:select id="processorBrand" cssClass="form-control" path="processorBrand" items="${processorBrandMap}"/>
                        <form:errors path="processorBrand" cssClass="control-label errorMessage" />
                    </div>
                </div>
                <div class="form-group row">
                    <label for="processorModel" class="col-sm-3 col-md-3 control-label">Processor Model</label>
                    <div class="col-sm-6 col-md-6">
                        <form:select id="processorModel" cssClass="form-control" path="processorModel" items="${processorModelMap}"/>
                        <form:errors path="processorModel" cssClass="control-label errorMessage" />
                    </div>
                </div>
                <div class="form-group row">
                    <label for="processorClockFrequency" class="col-sm-3 col-md-3 control-label">Processor Clock Frequency, GHz</label>
                    <div class="col-sm-6 col-md-6">
                        <form:input id="processorClockFrequency" type="text" cssClass="form-control" path="processorClockFrequency"/>
                        <form:errors path="processorClockFrequency" cssClass="control-label errorMessage" />
                    </div>
                </div>
                <div class="form-group row">
                    <label for="processorCount" class="col-sm-3 col-md-3 control-label">Processors Count</label>
                    <div class="col-sm-6 col-md-6">
                        <form:input id="processorCount" type="text" cssClass="form-control" path="processorCount"/>
                        <form:errors path="processorCount" cssClass="control-label errorMessage" />
                    </div>
                </div>
                <div class="form-group row">
                    <label for="memoryType" class="col-sm-3 col-md-3 control-label">Memory Type</label>
                    <div class="col-sm-6 col-md-6">
                        <form:select id="memoryType" cssClass="form-control" path="memoryType" items="${memoryTypeMap}"/>
                        <form:errors path="memoryType" cssClass="control-label errorMessage" />
                    </div>
                </div>
                <div class="form-group row">
                    <label for="memorySize" class="col-sm-3 col-md-3 control-label">Memory Size</label>
                    <div class="col-sm-6 col-md-6">
                        <form:input id="memorySize" type="text" cssClass="form-control" path="memorySize"/>
                        <form:errors path="memorySize" cssClass="control-label errorMessage" />
                    </div>
                </div>
                <div class="form-group row">
                    <label for="hardDriveCapacity" class="col-sm-3 col-md-3 control-label">Hard Drive Capacity</label>
                    <div class="col-sm-6 col-md-6">
                        <form:input id="hardDriveCapacity" type="text" cssClass="form-control" path="hardDriveCapacity" />
                        <form:errors path="hardDriveCapacity" cssClass="control-label errorMessage" />
                    </div>
                </div>
                <div class="form-group row">
                    <label for="hardDriveRotationalSpeed" class="col-sm-3 col-md-3 control-label">Hard Drive Rotational Speed</label>
                    <div class="col-sm-6 col-md-6">
                        <form:input id="hardDriveRotationalSpeed" type="text" cssClass="form-control" path="hardDriveRotationalSpeed" />
                        <form:errors path="hardDriveRotationalSpeed" cssClass="control-label errorMessage" />
                    </div>
                </div>
                <div class="form-group row">
                    <label for="USB2_0Count" class="col-sm-3 col-md-3 control-label">USB 2.0 Count</label>
                    <div class="col-sm-6 col-md-6">
                        <form:input id="USB2_0Count" type="text" cssClass="form-control" path="USB2_0Count" />
                        <form:errors path="USB2_0Count" cssClass="control-label errorMessage" />
                    </div>
                </div>
                <div class="form-group row">
                    <label for="USB3_0Count" class="col-sm-3 col-md-3 control-label">USB 3.0 Count</label>
                    <div class="col-sm-6 col-md-6">
                        <form:input id="USB3_0Count" type="text" cssClass="form-control" path="USB3_0Count" />
                        <form:errors path="USB3_0Count" cssClass="control-label errorMessage" />
                    </div>
                </div>
                <div class="form-group row">
                    <label for="cost" class="col-sm-3 col-md-3 control-label">Cost, $</label>
                    <div class="col-sm-6 col-md-6">
                        <form:input id="cost" type="text" cssClass="form-control" path="cost" />
                        <form:errors path="cost" cssClass="control-label errorMessage" />
                    </div>
                </div>
                <div class="form-group">
                    <button type="submit" class="btn-lg btn-primary pull-right">Add product</button>
                </div>
            </form:form>
        </div>

    </body>
</html>
