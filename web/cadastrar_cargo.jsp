<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="bootstrap/css/bootstrap-theme.min.css">
        <title> Cadastro de Cargo </title>
    </head>
    <body class="container">
        <h1> Cadastrar Cargos </h1>
            <form action="CargoController" method="POST">
            <input type="hidden" name="id" value="${c.id}" />
    <div class="row">       
    <div class="form-group col-sm-8">
    <label for="tipo" class="control-label"> Tipo </label>
    <input type="text" class="form-control" id="tipo" name="tipo" required value="${c.tipo}"/>
    </div>
    </div>
    <button class="btn btn-success"> Salvar </button>  
    <a href="listar_cargo.jsp" class="btn btn-warning"> Voltar </a>
</form>
</body>
</html>
