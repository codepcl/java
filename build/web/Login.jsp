<%-- 
    Document   : login
    Created on : 10/05/2018, 11:18:28 PM
    Author     : PCHINOL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Login Test</title>
  <link rel="stylesheet" href="resources/css/bootstrap.css">
  <link rel="stylesheet" href="resources/font-awesome/css/font-awesome.min.css">
  <script src="resources/js/jquery-3.2.1.min.js" charset="utf-8"></script>
  <script src="resources/js/bootstrap.js" charset="utf-8"></script>
</head>
<style media="screen">
  html, body{
    height: 100%;
  }

  #contenedor{
    position: absolute;
    width: 300px;
    height: 200px;
    z-index: 15;
    top: 50%;
    left: 50%;
    margin: -100px 0 0 -150px;
  }
.panel{
  margin-bottom: 0px ;
}
.panel-body{
  padding: 20px;
}
</style>
<body style="background:#2AF7E4">
  <div id="contenedor" >
    <div class="panel panel-success">
      <div class="panel-heading">
        <h5 class="panel-title">
          <i class="fa fa-address-card"></i> Login</h5>
      </div>
      <div class=" panel panel-body">
          <form class="form-horizontal" action="buscarUsuario" method="post">
            <div class="form-group">
              <!-- <label for="IdUser" class="col-sm-2 control-label"> Usuario </label> -->
              <div class="input-group ">
                <span class="input-group-addon"><i class="fa fa-user"></i></span>
                <input type="text" autofocus name="username" id="IdUser" class="form-control" placeholder="Usuario" value="">
              </div>
            </div>
            <div class="form-group">
              <!-- <label for="IdPass" class="col-sm-2 control-label"> Clave </label> -->
              <div class="input-group ">
                <span class="input-group-addon"><i class="fa fa-key"></i></span>
                <input type="password"  name="password" id="IdPass" class="form-control" placeholder="Clave" value="">
              </div>
            </div>
              <div class="form-group text-center">
                  <a href="RegistrarUsuario.jsp">Registrar usuario</a>
              </div>
            <div class="form-group row">
              <div class="col-lg-6 col-xs-6">
                <button type="submit" class="btn btn-primary" name="button"><i class="fa fa-paper-plane"></i> Acceder</button>
              </div>
              <div class="col-lg-6 col-xs-6">
                <button type="reset" class="btn btn-danger" name="button"><i class="fa fa-eraser"></i> Limpiar</button>
              </div>
            </div>
          </form>
      </div>
    </div>

  </div>
</body>
</html>