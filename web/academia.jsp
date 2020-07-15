
<%-- 
    Document   : academia
    Created on : 28/10/2017, 09:54:33
    Author     : Apolo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Cadastro de Academia</title>
        <!-- Tell the browser to be responsive to screen width -->
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <!-- Bootstrap 3.3.6 -->
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="bootstrap/css/bootstrap-theme.min.css">
         
    </head>
    <body class="container">
        <h1>Cadastro de Academia</h1>        
        <form action="AcademiaControle" method="POST">
            <input type="hidden" name="id" value="${a.id}" />
            <div class="row">
                <div class="form-group col-sm-8">
                    <label for="cnpj" class="control-label">CNPJ:</label>
                    <input type="text" class="form-control" maxlength="14" autocomplete="on" id="cnpj" name="cnpj" required value="${a.cnpj}"/>
                </div>
                
                <div class="form-group col-sm-4">
                    <label for="nome" class="control-label">Nome:</label>
                    <input type="text" class="form-control" id="nome" name="nome" maxlength="50" required value="${a.nome}"/>
                </div>
                
                <div class="form-group col-sm-12">
                    <label for="endereco" class="control-label">Endereço:</label>
                    <input type="text" class="form-control" id="endereco" name="endereco" required value="${a.endereco}"/>
                </div>
                
                 <div class="form-group col-sm-12">
                    <label for="telefone" class="control-label">Telefone:</label>
                    <input type="text" class="form-control" id="telefone" name="telefone" required value="${a.telefone}"/>
                </div>
            </div>
            <button class="btn btn-success">Gravar</button>  
            <a href="listaacademia.jsp" class="btn btn-warning">Voltar</a>
        </form>
    </body>
</html>
