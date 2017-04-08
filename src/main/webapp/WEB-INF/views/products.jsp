<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Products Page</title>

    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            overflow: hidden;
            word-break: normal;
            border: 1px solid #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            overflow: hidden;
            word-break: normal;
            border: 1px solid #ccc;
            color: #333;
            background-color: #f0f0f0;
        }
    </style>
</head>
<body>
<a href="${pageContext.request.contextPath}/WEB-INF/views/welcome.jsp">Back to main menu</a>

<br/>
<br/>

<h1>Product List</h1>

<c:if test="${!empty listproducts}">
    <table class ="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Name</th>
            <th width="120">Producer</th>
            <th width="120">Cost</th>
            <th width="100">Info</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listproducts}" var="product">
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.producer}</td>
                <td>${product.cost}</td>
                <td>${product.info}</td>
                <td><a href="<c:url value='/edit/${product.id}'/>">">Edit</a></td>
                <td><a href="<c:url value='/delete/${product.id}'/>">">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<h1>Add a Product</h1>

<c:url var="addAction" value="/products/add"/>

<form:form action="${addAction}" commandName="product">
    <table>
        <c:if test="${!empty product.name}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="id"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="name">
                    <spring:message text="Name"/>
                </form:label>
            </td>
            <td>
                <form:input path="Name"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="producer">
                    <spring:message text="Producer"/>
                </form:label>
            </td>
            <td>
                <form:input path="producer"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="cost">
                    <spring:message text="Cost"/>
                </form:label>
            </td>
            <td>
                <form:input path="cost"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="info">
                    <spring:message text="Info"/>
                </form:label>
            </td>
            <td>
                <form:input path="info"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty product.name}">
                    <input type="submit"
                           value="<spring:message text="Edit Product"/>"/>
                </c:if>
                <c:if test="${empty product.name}">
                    <input type="submit"
                           value="<spring:message text="Add Product"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>

</body>
</html>
