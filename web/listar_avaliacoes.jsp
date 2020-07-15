
<%@page import="model.Avaliacao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.AvaliacaoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="a" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="bootstrap/css/bootstrap-theme.min.css">
        <script>
            function confirmarExclusao(id) {
                if (confirm('Deseja realmente excluir esta Avaliação Física?')) {
                    location.href = 'AvaliacaoController?funcionalidade=excluir&id=' + id;
                }
            }
        </script>
        <title> Avaliações fisicas da Academia </title>
    </head>
    <body>
        <div class="container">
            <table class="table table-hover">
                <tr>
                    <th></th>
                    <th> Id </th>
                    <th> Aluno </th>
                    <th> Biotipo </th>
                    <th> Data da Avaliação </th>
                    <th> Idade </th>
                    <th> Peso </th>
                    <th> Ombro </th>
                    <th> Braço Relaxado </th>
                    <th> Braço Contraído </th>
                    <th> Antebraço </th>
                    <th> Torax </th>
                    <th> Panturrilha </th>
                    <th> Cintura </th>
                    <th> Abdomen </th>
                    <th> Quadril </th>
                    <th> Coxa </th>
                    <th> Validade da Avaliação </th>
                    



                </tr>
                <h2> Lista de Avaliações Físicas </h2>
                <jsp:useBean id="dao" class="model.AvaliacaoDAO" />
                <a:forEach var="a" items="${dao.lista}">           
                    <tr>
                        <td>
                            <a class="btn btn-primary" href="AvaliacaoController?funcionalidade=alterar&id=${a.id}">
                                <i class="glyphicon glyphicon-pencil"></i></a>

                            <button class="btn btn-danger" onclick="confirmarExclusao(${a.id}, '${a.data_ava}')">
                                <i class="glyphicon glyphicon-trash"></i> </button>

                        </td>
                        <td>${a.id}</td>
                        <td>${a.aluno.nome}</td>
                        <td>${a.biotipo}</td>
                        <td>${a.data_ava}</td>
                        <td>${a.idade}</td>
                        <td>${a.peso}</td>
                        <td>${a.ombro}</td>
                        <td>${a.braco_relaxado}</td>
                        <td>${a.braco_contraido}</td>
                        <td>${a.antebraco}</td>
                        <td>${a.torax}</td>
                        <td>${a.panturrilha}</td>
                        <td>${a.cintura}</td>
                        <td>${a.abdomen}</td>
                        <td>${a.quadril}</td>
                        <td>${a.coxa}</td>
                        <td>${a.validade_ava}</td>
                        

                    </tr>
                </a:forEach> 
            </table>
            <br>  <a href="index.jsp"> Novo cadastro de Avaliação </a>
        </div>
    </body>
</html>