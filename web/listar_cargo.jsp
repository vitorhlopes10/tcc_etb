<%@page import="bin.Cargo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.CargoDAO"%>
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
          function confirmarExclusao(id, tipo) {
              if ( confirm('Deseja realmente excluir o Cargo ' + tipo + '?') ) {
                  location.href='CargoController?acao=excluir&id=' + id;
              }
          }
      </script>
        <title> Cargos da Academia </title>
    </head>
    <body>
        <div class="container">
        <table class="table table-hover">
                   <tr>
                      <th></th>
                      <th> Id </th>
                      <th> Tipo </th>
                    </tr>
          <h2> Lista de cargos </h2>
           <jsp:useBean id="cDAO" class="model.CargoDAO" />
           <a:forEach var="cargo" items="${cDAO.lista}">           
        <tr>
        <td>
            <a class="btn btn-primary" href="CargoController?acao=alterar&id=${cargo.id}">
            <i class="glyphicon glyphicon-pencil"></i></a>
            
            <button class="btn btn-danger" onclick="confirmarExclusao(${cargo.id}, '${cargo.tipo}')">
            <i class="glyphicon glyphicon-trash"></i> </button>
                       
        </td>
        <td>${cargo.id}</td>
        <td>${cargo.tipo}</td>
        </tr>
        </a:forEach> 
        </table>
<br>  <a href="cadastrar_cargo.jsp"> Novo cadastro de cargo </a>
</div>
</body>
</html>
