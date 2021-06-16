<%@ page language="java" contentType="text/html; charset=ISO-8859-1, UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
            crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="/spring-aulas">Blog</a>
        <button class="navbar-toggler" type="button"
                data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false"
                aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item"><a class="nav-link active"
                                        aria-current="page" href="posts/list">Posts</a></li>
                <li class="nav-item"><a class="nav-link active"
                                        aria-current="page" href="users/list">Usuários</a></li>
            </ul>
        </div>
        <form class="d-flex">
            <input class="form-control me-2" type="search"
                   placeholder="O que você procura?" aria-label="Search">
            <button class="btn btn-outline-success" type="submit">Pesquisar</button>
        </form>
    </div>
</nav>
<p>
<h5 style="text-align: center">Boa leitura!</h5>
</p>
<div class="card">
    <div class="container">
        <div class="container-fluid">
            <div class="card-body">
                <div class="row">
                    <c:forEach var="obj" items="${posts}">
                        <h4><strong>${obj.descriptionTitle}</strong></h4>
                        <strong>${obj.descriptionSubTitle}</strong>
                        <br/>
                        <p>
                                ${obj.descriptionBody}
                        </p>

                        <small><strong>Por: ${obj.createdBy.name}</strong></small>
                        <p>
                            <strong><h5>Comentários</h5></strong>

                        <small> <c:forEach var="com" items="${obj.comments}">
                            <p>
                                <strong>${com.createdBy == obj.createdBy ? '(Autor)' : com.createdBy.name}:</strong> ${com.description}
                                <a href="comments/delete/${com.id}">Excluir</a>
                            </p>
                        </c:forEach>
                        </small>
                        <p>
                        <form:form method="POST" modelAttribute="comments"
                                   action="comments/save/${obj.id}">


                            <form:input type="hidden" id="id" path="id"/>
                            <div class="row">
                                <div class="col-md-8">
                                    <div class="form-group">
                                        <form:input class="form-control" id="description"
                                                    placeholder="Deixe aqui seu comentário" path="description"/>
                                    </div>
                                    <p></p>
                                </div>

                                <div class="col-md-4">
                                    <div class="form-group">
                                        <form:select class="form-control" id="createdBy"
                                                     path="createdBy">
                                            <form:option value=""> --Selecione seu usuário--</form:option>
                                            <form:options items="${users}" itemLabel="name"
                                                          itemValue="id"></form:options>
                                        </form:select>
                                    </div>
                                </div>

                                <div style="width: 150px;">
                                    <form:button type="submit" class="btn btn-primary mb-3">Comentar</form:button>
                                </div>
                            </div>
                        </form:form>
                        </p>
                        <hr>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</div>


<script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
        crossorigin="anonymous"></script>

</body>
</html>