<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>New Author</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
    <div class="container form-container">
        <h2>Add New Author</h2>
        <c:if test="${not empty error}">
            <div class="alert alert-danger">${error}</div>
        </c:if>
        <form:form action="/saveAuthor" modelAttribute="author" method="POST">
            <div class="form-group">
                <label>Name:</label>
                <form:input path="name" required="required" />
                <form:errors path="name" cssClass="error" />
            </div>
            <div class="form-group">
                <label>Email:</label>
                <form:input path="email" required="required" type="email" />
                <form:errors path="email" cssClass="error" />
            </div>
            <button type="submit" class="btn btn-primary">Save Author</button>
            <a href="/" class="btn btn-secondary">Cancel</a>
        </form:form>
    </div>
</body>
</html>
