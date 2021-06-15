<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Usuários</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="/spring-aulas">Blog</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="../posts/list">Posts</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="../users/list">Usuários</a>
                </li>
            </ul>
        </div>
        <form class="d-flex">
            <input class="form-control me-2" type="search" placeholder="O que você procura?" aria-label="Search">
            <button class="btn btn-outline-success" type="submit">Pesquisar</button>
        </form>
    </div>
</nav>

<div class="container">
    <div class="container-fluid">
        <br/>
        <div class="card">
            <div class="card-header">
                <h4 class="card-title">Usuários</h4>
            </div>

            <form:form method="POST" modelAttribute="obj" action="save">

                <div class="card-body">
                    <div class="row">

                        <form:input type="hidden" id="id" path="id"/>

                        <div class="col-md-12">
                            <div class="form-group">
                                <label for="name">Nome</label>
                                <form:input class="form-control" id="name" path="name"/>
                            </div>
                        </div>

                        <p></p>

                        <div class="col-md-12">
                            <div class="form-group">
                                <label for="local">Local</label>
                                <form:input class="form-control" id="local" path="local"/>
                            </div>
                        </div>

                    </div>
                </div>

                <div class="card-footer">
                    <form:button type="submit" class="btn btn-primary mb-3">Salvar</form:button>
                </div>

            </form:form>
            <p></p>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
        crossorigin="anonymous"></script>
</body>
</html>