<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Book</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
    <div class="container form-container">
        <h2>Update Book</h2>
        <c:if test="${not empty error}">
            <div class="alert alert-danger">${error}</div>
        </c:if>
        <form:form action="/saveBook" modelAttribute="book" method="POST">
            <form:hidden path="id" />
            <div class="form-group">
                <label>Title:</label>
                <form:input path="title" required="required" />
                <form:errors path="title" cssClass="error" />
            </div>
            <div class="form-group">
                <label>ISBN:</label>
                <form:input path="isbn" required="required" />
                <form:errors path="isbn" cssClass="error" />
            </div>
            <div class="form-group">
                <label>Author:</label>
                <form:select path="author.id" required="required">
                    <form:options items="${authors}" itemValue="id" itemLabel="name"/>
                </form:select>
            </div>
            <button type="submit" class="btn btn-warning">Update Book</button>
            <a href="/" class="btn btn-secondary">Cancel</a>
        </form:form>
    </div>
</body>
</html>
