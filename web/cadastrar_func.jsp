
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="bootstrap/css/bootstrap-theme.min.css">
        <title> Cadastro de Funcionário </title>
 </head>
    <body class="container">
        <h1> Cadastrar Funcionário </h1>
        
            <form action="FuncionarioController" method="POST">
            <input type="hidden" name="id" value="${f.id}" />
            <div class="row">
                
                <div class="form-group col-sm-4">
                <label for="matricula" class="control-label"> Matricula </label>
                <input type="text" class="form-control" id="matricula" name="matricula" required value="${f.matricula}"/>
                </div>
                <div class="form-group col-sm-4">
                <label for="cpf" class="control-label"> CPF </label>
                <input type="text" class="form-control" id="cpf" name="cpf" maxlength="11" required value="${f.cpf}"/>
                </div>
                
                
                <div class="form-group col-sm-9">
                <label for="nome" class="control-label"> Nome </label>
                <input type="text" class="form-control" id="nome" name="nome" required value="${f.nome}"/>
                </div>
                
                <div class="form-group col-sm-4">
                <label for="data_nasc" class="control-label"> Data de Nascimento </label>
                <input type="text" class="form-control" id="data_nasc" name="data_nasc" required value="${f.data_nasc}"/>
                </div>
                
 
                <div class="form-group col-sm-4">
                <label for="sexo" class="control-label"> Sexo </label>
                <input type="text" class="form-control" id="sexo" name="sexo" required value="${f.sexo}"/>
                </div>
                <div class="form-group col-sm-4">
                <label for="turno" class="control-label"> Turno </label>
                <input type="text" class="form-control" id="turno" name="turno" maxlength="11" required value="${f.turno}"/>
                </div>
                
       
                <div class="form-group col-sm-12">
                <label for="endereco" class="control-label"> Endereço </label>
                <input type="text" class="form-control" id="endereco" name="endereco" required value="${f.endereco}"/>
                </div>
                
                <div class="form-group col-sm-4">
                <label for="email" class="control-label"> Email </label>
                <input type="text" class="form-control" id="email" name="email" required value="${f.email}"/>
                </div>
       
                
                <div class="form-group col-sm-4">
                <label for="telefone" class="control-label"> Telefone </label>
                <input type="text" class="form-control" id="telefone" name="telefone" required value="${f.telefone}"/>
                </div>
                
            <div class="form-group col-sm-4">
            <label for="senha" class="control-label">Senha</label>
            <input type="password" id="senha" name="senha" required value="${f.senha}"/>
            </div>
         
            <div class="form-group col-sm-12">
                <label for="cargo" class="control-label">Cargo</label>
                <jsp:useBean id="cdao" class="model.CargoDAO"></jsp:useBean>
            <select id="cargo" name="cargo" class="form-control" required>
                <option></option>
                <c:forEach var="cargo" items="${cdao.lista}">
                <c:if test="${f.cargo.id == cargo.id}">
                 <option value="${cargo.id}" selected>${cargo.tipo}</option>
                </c:if>
                <c:if test="${f.cargo.id != cargo.id}">
                  <option value="${cargo.id}">${cargo.tipo}</option>                                
                </c:if>
                </c:forEach>
            </select>
                </div>
            
            
            
              <div class="form-group col-sm-12">
                  <label for="academia" class="control-label"> Academia </label>
                <jsp:useBean id="AcademiaDAO" class="model.AcademiaDAO"></jsp:useBean>
                <select id="academia" name="academia" class="form-control" required>
                <option></option>
                <c:forEach var="academia" items="${AcademiaDAO.lista}">
                    <c:if test="${f.academia.id == academia.id}">
                <option value="${academia.id}" selected>${academia.nome}</option>
                    </c:if>
                    <c:if test="${f.academia.id != academia.id}">
                <option value="${academia.id}">${academia.nome}</option>                                
                    </c:if>
                </c:forEach>
                </select>
            </div>
            
            
            
            
                </div>
                
            
            <button class="btn btn-success"> Salvar </button>  
            <a href="listar_func.jsp" class="btn btn-warning"> Voltar </a>
</form>
</body>
</html>
