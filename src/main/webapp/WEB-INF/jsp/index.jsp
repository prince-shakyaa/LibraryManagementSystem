<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Library Management</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
    <div class="container">
        <h1>Library Management System</h1>

        <c:if test="${not empty message}">
            <div class="alert alert-success">${message}</div>
        </c:if>

        <div class="section">
            <h2>Authors</h2>
            <a href="/showNewAuthorForm" class="btn btn-primary">Add New Author</a>
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="author" items="${listAuthors}">
                        <tr>
                            <td>${author.id}</td>
                            <td>${author.name}</td>
                            <td>${author.email}</td>
                            <td>
                                <a href="/showFormForAuthorUpdate/${author.id}" class="btn btn-warning">Update</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

        <div class="section">
            <h2>Books</h2>
            <a href="/showNewBookForm" class="btn btn-primary">Add New Book</a>
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Title</th>
                        <th>ISBN</th>
                        <th>Author Name</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="book" items="${listBooks}">
                        <tr>
                            <td>${book.id}</td>
                            <td>${book.title}</td>
                            <td>${book.isbn}</td>
                            <td>${book.author.name}</td>
                            <td>
                                <a href="/showFormForBookUpdate/${book.id}" class="btn btn-warning">Update</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
