
<%@page import="bin.Funcionario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.FuncionarioDAO"%>
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
           function confirmarExclusao(id, nome) {
              if ( confirm('Deseja realmente excluir o Funcionário ' + nome + '?') ) {
                  location.href='FuncionarioController?acao=excluir&id=' + id;
              }
          }
      </script>
        <title> Funcionários da Academia </title>
    </head>
    <body>
        <div class="container">
        <table class="table table-hover">
                <tr>
                      <th></th>
                      <th> Id </th>
                      <th> Matrícula </th>
                      <th> CPF </th>
                      <th> Nome </th>
                      <th> Data de nascimento </th>
                      <th> Sexo </th>
                      <th> Turno </th>
                      <th> Endereço </th>
                      <th> Email </th>
                      <th> Telefone </th>
                      <th> Cargo </th>
                      <th> Academia </th>
                      
                </tr>
          <h2> Lista de Funcionários </h2>
           <jsp:useBean id="fdao" class="model.FuncionarioDAO" />
           <a:forEach var="func" items="${fdao.lista}">           
        <tr>
        <td>
            <a class="btn btn-primary" href="FuncionarioController?acao=alterar&id=${func.id}">
            <i class="glyphicon glyphicon-pencil"></i></a>
            
            <button class="btn btn-danger" onclick="confirmarExclusao(${func.id}, '${func.nome}')">
            <i class="glyphicon glyphicon-trash"></i> </button>
                       
        </td>
        
       <td>${func.id}</td>
       <td>${func.matricula}</td>
       <td>${func.cpf}</td>
       <td>${func.nome}</td>
       <td>${func.data_nasc}</td>
       <td>${func.sexo}</td>
       <td>${func.turno}</td>
       <td>${func.endereco}</td>
       <td>${func.email}</td>
       <td>${func.telefone}</td>
       <td>${func.cargo.tipo}</td>
       <td>${func.academia.nome}</td>
   
       
        </tr>
        </a:forEach> 
        </table>
<br>  <a href="cadastrar_func.jsp"> Novo cadastro de funcionário </a>
</div>
</body>
</html>