<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Cadastro de Aparelho</title>
        <!-- Tell the browser to be responsive to screen width -->
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <!-- Bootstrap 3.3.6 -->
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="bootstrap/css/bootstrap-theme.min.css">
    </head>
    <body class="container">
        <h1>Cadastro de Aparelho</h1>        
        <form action="AparelhoController" method="POST">
            <input type="hidden" name="id" value="${a.id}" />
            <div class="row">
                <div class="form-group col-sm-8">
                    <label for="numero" class="control-label">Número:</label>
                    <input type="text" class="form-control" id="numero" name="numero" required value="${a.numero}"/>
                </div>
                
                <div class="form-group col-sm-4">
                    <label for="nome" class="control-label">Nome:</label>
                    <input type="text" class="form-control" id="nome" name="nome" maxlength="50" required value="${a.nome}"/>
                </div>
                
                <div class="form-group col-sm-12">
                    <label for="descricao" class="control-label">Descrição:</label>
                    <input type="text" class="form-control" id="descricao" name="descricao" required value="${a.descricao}"/>
                </div>
               
            </div>
            <button class="btn btn-success"> Salvar </button>  
            <a href="listaaparelho.jsp" class="btn btn-warning">Voltar</a>
        </form>
    </body>
</html>