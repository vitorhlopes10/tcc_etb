
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
        <title> Cadastro de Alunos </title>
    </head>
    <body class="container">
        <h1> Cadastrar Aluno </h1>

        <form action="AlunoController" method="POST">
            <input type="hidden" name="id" value="${alu.id}" />
            <div class="row">
                <div class="form-group col-sm-4">
                    <label for="cpf" class="control-label"> CPF </label>
                    <input type="text" class="form-control" id="cpf" name="cpf" required value="${alu.cpf}"/>
                </div>

                <div class="form-group col-sm-4">
                    <label for="nome" class="control-label"> Nome </label>
                    <input type="text" class="form-control" id="nome" name="nome" maxlength="11" required value="${alu.nome}"/>
                </div>


                <div class="form-group col-sm-9">
                    <label for="email" class="control-label"> Email </label>
                    <input type="text" class="form-control" id="email" name="email" required value="${alu.email}"/>
                </div>

                <div class="form-group col-sm-4">
                    <label for="data_nasc" class="control-label"> Data de Nascimento </label>
                    <input type="text" class="form-control" id="data_nasc" name="data_nasc" required value="${alu.data_nasc}"/>
                </div>


                <div class="form-group col-sm-4">
                    <label for="sexo" class="control-label"> Sexo </label>
                    <input type="text" class="form-control" id="sexo" name="sexo" required value="${alu.sexo}"/>
                </div>
                <div class="form-group col-sm-4">
                    <label for="endereco" class="control-label"> Endereço </label>
                    <input type="text" class="form-control" id="endereco" name="endereco" maxlength="50" required value="${alu.endereco}"/>
                </div>


                <div class="form-group col-sm-12">
                    <label for="telefone" class="control-label"> Telefone </label>
                    <input type="text" class="form-control" id="telefone" name="telefone" required value="${alu.telefone}"/>
                </div>

                <div class="form-group col-sm-4">
                    <label for="status" class="control-label"> Status </label>
                    <input type="text" class="form-control" id="status" name="status" required value="${alu.status}"/>
                </div>


                <div class="form-group col-sm-4">
                    <label for="valor_mensalidade" class="control-label"> Valor da Mensalidade do Aluno </label>
                    <input type="text" class="form-control" id="valor_mensalidade" name="valor_mensalidade" required value="${alu.valor_mensalidade}"/>
                </div>

                <div class="form-group col-sm-4">
                    <label for="plano" class="control-label"> Plano </label>
                    <input type="text" id="plano" name="plano" required value="${alu.plano}"/>
                </div>

                <div class="form-group col-sm-4">
                    <label for="senha" class="control-label"> Senha </label>
                    <input type="text" id="senha" name="senha" required value="${alu.senha}"/>
                </div>
                
                <div class="form-group col-sm-12">
                  <label for="academia" class="control-label"> Academia </label>
                <jsp:useBean id="daoAcademia" class="model.AcademiaDAO"></jsp:useBean>
                <select id="academia" name="academia" class="form-control" required>
                <option></option>
                <c:forEach var="academia" items="${daoAcademia.lista}">
                    <c:if test="${alu.academia.id == academia.id}">
                <option value="${academia.id}" selected>${academia.nome}</option>
                    </c:if>
                    <c:if test="${alu.academia.id != academia.id}">
                <option value="${academia.id}">${academia.nome}</option>                                
                    </c:if>
                </c:forEach>
                </select>
            </div>

            </div>
            <button class="btn btn-success"> Salvar </button>  
            <a href="listar_aluno.jsp" class="btn btn-warning"> Voltar </a>
        </form>
    </body>
</html>
