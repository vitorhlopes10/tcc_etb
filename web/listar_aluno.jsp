
<%@page import="model.Aluno"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.AlunoDAO"%>
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
              if ( confirm('Deseja realmente excluir o Aluno ' + nome + '?') ) {
                  location.href='AlunoController?funcionalidade=excluir&id=' + id;
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
                      <th> CPF </th>
                      <th> Nome </th>
                      <th> Email </th>
                      <th> Data de nascimento </th>
                      <th> Sexo </th>
                      <th> Endereço </th>
                      <th> Telefone </th>
                      <th> Status </th>
                      <th> Valor da Mensalidade </th>
                      <th> Plano </th>
                      <th> Senha </th>
                      <th> Academia </th>
          
                      
                      
                    </tr>
          <h2> Lista de Alunos </h2>
           <jsp:useBean id="dao" class="model.AlunoDAO" />
           <a:forEach var="alu" items="${dao.lista}">           
        <tr>
        <td>
                 <a class="btn btn-primary" href="AlunoController?funcionalidade=alterar&id=${alu.id}">
            <i class="glyphicon glyphicon-pencil"></i></a>
            
            <button class="btn btn-danger" onclick="confirmarExclusao(${alu.id}, '${alu.nome}')">
            <i class="glyphicon glyphicon-trash"></i> </button>
                       
        </td>
       <td>${alu.id}</td>
       <td>${alu.cpf}</td>
       <td>${alu.nome}</td>
       <td>${alu.email}</td>
      <td>${alu.data_nasc}</td>
       <td>${alu.sexo}</td>
       <td>${alu.endereco}</td>
       <td>${alu.telefone}</td>
       <td>${alu.status}</td>
       <td>${alu.valor_mensalidade}</td>
       <td>${alu.plano}</td>
       <td>${alu.senha}</td>
       <td>${alu.academia.nome}</td>
   
       
        </tr>
        </a:forEach> 
        </table>
<br>  <a href="cadastrar_aluno.jsp"> Novo cadastro de Aluno </a>
</div>
</body>
</html>