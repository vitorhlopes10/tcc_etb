
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

    <head>
         <link href="bootstrap/css/style.css" rel="stylesheet" type="text/css" media="all" />
        <link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
        <script src="bootstrap/js/jquery.min.js"></script>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="keywords" content="Princi_Gym Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
              Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
        <script type="text/javascript" src="bootstrap/js/move-top.js"></script>
        <script type="text/javascript" src="bootstrap/js/easing.js"></script>
        <title>Lista de Aparelho</title>
        <!-- Tell the browser to be responsive to screen width -->
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <!-- Bootstrap 3.3.6 -->
        <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
        <link rel="stylesheet" href="bootstrap/css/component.css">
        <link rel="stylesheet" href="bootstrap/css/default.css">
        <link rel="stylesheet" href="bootstrap/css/demo-page.css">
        <link rel="stylesheet" href="bootstrap/css/font-awesome.min.css">
        <link rel="stylesheet" href="bootstrap/css/style.css">
        <link rel="stylesheet" href="bootstrap/js/classie.js">
        <link rel="stylesheet" href="bootstrap/js/easing.js">
        <link rel="stylesheet" href="bootstrap/js/jquery-1.11.0.min.js.js">
        <link rel="stylesheet" href="bootstrap/js/jquery.min.js.js">
        <link rel="stylesheet" href="bootstrap/js/modernizr.custom.js.js">
        <link rel="stylesheet" href="bootstrap/js/move-top.js.js">
        <link rel="stylesheet" href="bootstrap/js/responsiveslides.min.js.js">
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="bootstrap/css/bootstrap-theme.min.css">
        <script>
            function confirmarExclusao(id, numero) {
                if (confirm('Deseja realmente excluir o aparelho ' + numero + '?')) {
                    location.href = 'AparelhoController?acao=excluir&id=' + id;
                }
            }
        </script>
    </head>
    <body>
   
    <div class="container">
            <h1>Lista de Aparelho </h1>
            <div class="menuglobal"> 
                <tr> 
                    
                    
                    <a class="btn btn-primary" href=aparelho.jsp>Cadastrar Aparelho</a>
                    <a class="btn btn-danger" href=index.jsp>Sair</a>
                     
                     
                    
                     
                <tr>    
            </div>  
        <table class="table">
            <tr>
                <th></th>
                <th>Id</th>
                <th>Número</th>
                <th>Nome</th>
                <th>Descrição</th>

            </tr>
            <jsp:useBean id="dao" class="model.AparelhoDAO"></jsp:useBean>
            <c:forEach var="aparelho" items="${dao.lista}">
                <tr>
                    <td>
                        <a class="btn btn-primary" href="AparelhoController?acao=alterar&id=${aparelho.id}">
                            <i class="glyphicon glyphicon-pencil"></i>
                        </a>
                        <button class="btn btn-danger" onclick="confirmarExclusao(${aparelho.id}, '${aparelho.numero}')">
                            <i class="glyphicon glyphicon-trash "></i>
                        </button>
                    </td>
                    <td>${aparelho.id}</td>
                    <td>${aparelho.numero}</td>
                    <td>${aparelho.nome}</td>
                    <td>${aparelho.descricao}</td>

                </tr>
            </c:forEach>
        </table>

        <!--div class="alert alert-success">
            Nenhum contato cadastrado!
        </div -->

    </div>



</body>
</html>
