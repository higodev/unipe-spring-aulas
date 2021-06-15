<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Usuários</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Blog</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="../posts/cadastro">Posts</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="../users/cadastro">Usuários</a>
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
            ${message}
            <div class="card-header">
                <div class="row">
                    <h4 class="card-title">Usuários</h4>
                    <div class="card-tools">
                        <div class="input-group input-group-sm" style="width: 150px;">
                            <a class="btn btn-block btn-primary btn-sm float-right" href="new">Novo
                                Cadastro</a>
                        </div>
                    </div>
                </div>
            </div>

            <div class="card-body">
                <div class="row">
                    <div class="card-body table-responsive p-0" style="height: 500px">
                        <table class="table table-hover table-head-fixed text-nowrap">
                            <thead>
                            <tr>
                                <th>#</th>
                                <th>Nome</th>
                                <th>Local</th>
                                <th>Ação</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="user" items="${users}">
                                <tr>
                                    <td style="width: 5%">${user.id}</td>
                                    <td style="width: 50%">${user.name}</td>
                                    <td style="width: 35%">${user.local}</td>
                                    <td style="width: 10%"><a href="editar/${user.id}">Editar</a> <a
                                            href="excluir/${user.id}">Excluir</a></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>

            </div>
        </div>
    </div>

</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
        crossorigin="anonymous"></script>

</body>
</html>