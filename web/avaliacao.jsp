
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
        <title> Cadastro de Avaliacao </title>
 </head>
    <body class="container">
        <h1> Cadastrar Avaliacao </h1>
        
            <form action="AvaliacaoController" method="POST">
            <input type="hidden" name="id" value="${a.id}" />
            <div class="row">
                
                 <div class="form-group col-sm-12">
                  <label for="aluno" class="control-label"> Aluno </label>
                <jsp:useBean id="daoAluno" class="model.AlunoDAO"></jsp:useBean>
                <select id="aluno" name="aluno" class="form-control" required>
                <option></option>
                <c:forEach var="aluno" items="${daoAluno.lista}">
                    <c:if test="${a.aluno.id == aluno.id}">
                <option value="${aluno.id}" selected>${aluno.nome}</option>
                    </c:if>
                    <c:if test="${a.aluno.id != aluno.id}">
                <option value="${aluno.id}">${aluno.nome}</option>                                
                    </c:if>
                </c:forEach>
                </select>
            </div>
                
                <div class="form-group col-sm-4">
                <label for="biotipo" class="control-label"> Biotipo </label>
                <input type="text" class="form-control" id="biotipo" name="biotipo" required value="${a.biotipo}"/>
                </div>
                
                <div class="form-group col-sm-4">
                <label for="data_ava" class="control-label"> Data de Avaliacao </label>
                <input type="text" class="form-control" id="data_ava" name="data_ava" maxlength="11" required value="${a.data_ava}"/>
                </div>
                
                <div class="form-group col-sm-9">
                <label for="idade" class="control-label"> Idade </label>
                <input type="text" class="form-control" id="idade" name="idade" required value="${a.idade}"/>
                </div>
                
                <div class="form-group col-sm-9">
                <label for="peso" class="control-label"> Peso </label>
                <input type="text" class="form-control" id="peso" name="peso" required value="${a.peso}"/>
                </div>
                
                <div class="form-group col-sm-4">
                <label for="ombro" class="control-label"> Ombro </label>
                <input type="text" class="form-control" id="ombro" name="ombro" required value="${a.ombro}"/>
                </div>
                
 
                <div class="form-group col-sm-4">
                <label for="braco_relaxado" class="control-label"> Braco relaxado </label>
                <input type="text" class="form-control" id="braco_relaxado" name="braco_relaxado" required value="${a.braco_relaxado}"/>
                </div>
                
                <div class="form-group col-sm-4">
                <label for="braco_contraido" class="control-label"> Braco Contraido </label>
                <input type="text" class="form-control" id="braco_contraido" name="braco_contraido" maxlength="11" required value="${a.braco_contraido}"/>
                </div>
                
       
                <div class="form-group col-sm-12">
                <label for="antebraco" class="control-label"> Antebraco </label>
                <input type="text" class="form-control" id="antebraco" name="antebraco" required value="${a.antebraco}"/>
                </div>
                
                <div class="form-group col-sm-4">
                <label for="torax" class="control-label"> Torax </label>
                <input type="text" class="form-control" id="torax" name="torax" required value="${a.torax}"/>
                </div>
       
                
                <div class="form-group col-sm-4">
                <label for="panturrilha" class="control-label"> Panturrilha </label>
                <input type="text" class="form-control" id="panturrilha" name="panturrilha" required value="${a.panturrilha}"/>
                </div>
                
                <div class="form-group col-sm-4">
                <label for="cintura" class="control-label"> Cintura </label>
                <input type="text" class="form-control" id="cintura" name="cintura" required value="${a.cintura}"/>
                </div>
                
                <div class="form-group col-sm-4">
                <label for="abdomen" class="control-label"> Abdomen </label>
                <input type="text" class="form-control" id="abdomen" name="abdomen" required value="${a.abdomen}"/>
                </div>
                
                <div class="form-group col-sm-4">
                <label for="quadril" class="control-label"> Quadril </label>
                <input type="text" class="form-control" id="quadril" name="quadril" required value="${a.quadril}"/>
                </div>
                
                <div class="form-group col-sm-4">
                <label for="coxa" class="control-label"> Coxa </label>
                <input type="text" class="form-control" id="coxa" name="coxa" required value="${a.coxa}"/>
                </div>
                
                  <div class="form-group col-sm-4">
                <label for="validade_ava" class="control-label"> Validade da Avaliacao </label>
                <input type="text" class="form-control" id="validade_ava" name="validade_ava" required value="${a.validade_ava}"/>
                </div>
                
                
            
            </div>
            <button class="btn btn-success"> Salvar </button>  
            <a href="index.jsp" class="btn btn-warning"> Voltar </a>
</form>
</body>
</html>
