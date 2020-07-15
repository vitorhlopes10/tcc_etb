<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="cabecalho.jsp" %>
<body>

    <div class="wrapper">
        <div class="sidebar" data-color="azure" data-image="assets/img/sidebar-6.jpg">

            <div class="sidebar-wrapper">
                <div class="logo">
                    <a href="http://localhost/academia" class="simple-text">
                        Academia
                    </a>
            </div>
                 <%@include file="menuesquerdo.jsp" %>
            </div>
        </div>

        <div class="main-panel">
            <nav class="navbar navbar-default navbar-fixed">
            <div class="container-fluid">
                    <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navigation-example-2">
                       <span class="sr-only">Toggle navigation</span>
                       <span class="icon-bar"></span>
                       <span class="icon-bar"></span>
                       <span class="icon-bar"></span>
                    </button>
                        <a class="navbar-brand" href="#">User</a>
                    </div>
                    <div class="collapse navbar-collapse">

                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <a href="">
                            <p>Account</p>
                            </a>
                        </li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    <p>
                                        Dropdown
                                        <b class="caret"></b>
                                    </p>
                                </a>
                                <ul class="dropdown-menu">
                                    <li><a href="#">Usuário</a></li>
                                    <li><a href="#">Another action</a></li>
                                    <li><a href="#">Something</a></li>
                                    <li><a href="#">Another action</a></li>
                                    <li><a href="#">Something</a></li>
                                    <li class="divider"></li>
                                    <li><a href="#">Separated link</a></li>
                                </ul>
                            </li>
                            <li>
                                <a href="#">
                                    <p>Log out</p>
                                </a>
                            </li>
                            <li class="separator hidden-lg hidden-md"></li>
                        </ul>
                    </div>
                </div>
            </nav>


            <div class="content">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="card">
                            <div class="header">
                                <h4 class="title"> Cadastrar Funcionário </h4>
                            </div>
                                <div class="content">
                                <form>
                                    <div class="row">
                                       
                                        
            <form action="FuncionarioController" method="POST">
            <input type="hidden" name="id" value="${f.id}" />
            <div class="row">     
                                    <div class="content">    
                                    <div class="col-md-6">
                                    <div class="form-group">
                                    <label> Matrícula </label>
                                    <input type="text" class="form-control" id="matricula" placeholder="0000000000" value="${f.matricula}">
                                    </div>
                                    </div>
                                    
                                    <div class="col-md-4">
                                    <div class="form-group">
                                    <label> CPF </label>
                                    <input type="text" class="form-control" id="cpf" placeholder="000.000.000-00" value="${f.cpf}">
                                    </div>
                                    </div>
                                    
                                    <div class="content">
                                    <div class="row">
                                    <div class="col-md-6">
                                    <div class="form-group">
                                    <label> Nome </label>
                                    <input type="text" class="form-control"  id="nome" placeholder="nome" value="${f.nome}">
                                    </div>
                                    </div>
                                    
                                                                                  
                                    <div class="col-md-4">
                                    <div class="form-group">
                                    <label> Data de nascimento </label>
                                    <input type="text" class="form-control" id="data_nasc" placeholder="00/00/0000" value="${f.data_nasc}">
                                    </div>
                                    </div>
                                    </div>
                                    </div>
                                    </div>
                                    
                                 <div class="content">
                                    
                                    <div class="col-md-6">
                                    <div class="form-group">
                                    <label> Sexo </label>
                                    <input type="text" class="form-control"  id="sexo" placeholder="sexo" value="${f.sexo}">
                                    </div>
                                    </div>
                                    
                                                                                  
                                    <div class="col-md-4">
                                    <div class="form-group">
                                    <label> Turno </label>
                                    <input type="text" class="form-control" id="turno" placeholder="turno" value="${f.turno}">
                                    </div>
                                    </div>
                                    </div>
                                    </div>
                                    </div>
                                    
                                    
                                    <div class="content">
                                    <div class="row">
                                    <div class="col-md-6">
                                    <div class="form-group">
                                    <label> Endereço </label>
                                    <input type="text" class="form-control" id="endereco" placeholder="endereço" value="${f.endereco}">
                                    </div>
                                    </div>
                              
                                    <div class="col-md-4">
                                    <div class="form-group">
                                    <label for="exampleInputEmail1"> Email  </label>
                                    <input type="email" class="form-control" id="email" placeholder="email" value="${f.email}">
                                    </div>
                                    </div>
                                    </div>
                                    
                                    
                                    <div class="row">
                                    <div class="col-md-6">
                                    <div class="form-group">
                                    <label> Telefone </label>
                                    <input type="text" class="form-control" id="telefone" placeholder="000000-0000" value="${f.telefone}">
                                    </div>
                                    </div>
                                   
                              
                                    <div class="col-md-4">
                                    <div class="form-group">
                                    <label> Senha </label>
                                    <input type="password" class="form-control"  id="senha" placeholder="senha" value="${f.senha}">
                                    </div>
                                    </div>
                                    </div>
                                     </div>

                                
                                    
                <div class="form-group col-sm-12">
                <label for="cargo" class="control-label">Cargo</label>
                
                <jsp:useBean id="cdao" class="model.CargoDAO"></jsp:useBean>
                <select id="cargo" name="cargo" class="form-control"  required>
                <option></option>
                <c:forEach var="cargo" items="${cdao.lista}">
                <c:if test="${f.cargo.id == cargo.id}">
                 <option  value="${cargo.id}" selected>${cargo.tipo}</option>
                </c:if>
                <c:if test="${f.cargo.id != cargo.id}">
                  <option  value="${cargo.id}">${cargo.tipo}</option>                                
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
                                          
                                      

                                        
                                
        <div class="content">                                
        <button class="btn btn-success"> Salvar </button>  
        <a href="listar_func.jsp" class="btn btn-warning"> Voltar </a>
          </div> 
   
        <div class="clearfix"></div>
                </form>
                    </div>
                        </div>
                        </div>
                    </div>
                </div>
            </div>


            <footer class="footer">
                <div class="container-fluid">
                    <nav class="pull-left">
                        <ul>
                            <li>
                                <a href="#">
                                    Home
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    Company
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    Portfolio
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    Blog
                                </a>
                            </li>
                    </ul>
                    </nav>
                    <p class="copyright pull-right">
                        &copy; <script>document.write(new Date().getFullYear())</script> <a href="http://www.creative-tim.com">Creative Tim</a>, made with love for a better web
                    </p>
            </div>
            </footer>

    </div>
    </div>


</body>

<%@include file="rodape.jsp" %>