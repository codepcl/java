<%-- 
    Document   : RegistrarUsuario
    Created on : 10/05/2018, 11:37:30 PM
    Author     : PCHINOL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
    <script type="text/javascript">
        $(document).ready(function(){
            $("#dni").change(function(){
                console.log($(this).val().length);
                if($(this).val().length > 8 ){
                    alert("El dni no puede exceder de 8 digitos");
                    $(this).val("");
                }
            });
        });
    </script>
    <body>
        <div class="container">
            <form action="agregarUsuario" method="post">
                <br>
                <h2>FORMULARIO DE USUARIO</h2>
                <br><br>
  <div class="form-group row">
    <label for="dni" class="col-sm-2 col-form-label">DNI</label>
    <div class="col-sm-6">
        <input type="number" required name="dni" class="form-control" id="dni" placeholder="Max 8 dig.">
    </div>
  </div>
  <div class="form-group row">
    <label for="nombre" class="col-sm-2 col-form-label">Nombre</label>
    <div class="col-sm-6">
      <input type="text" required class="form-control" name="name" id="nombre" placeholder="Nombre">
    </div>
  </div>
                <div class="form-group row">
    <label for="apellido" class="col-sm-2 col-form-label">Apellido</label>
    <div class="col-sm-6">
      <input type="text" required class="form-control" name="apellido"  id="apellido" placeholder="Apellido">
    </div>
  </div>
                <div class="form-group row">
    <label for="direccion" class="col-sm-2 col-form-label">Direccion</label>
    <div class="col-sm-6">
        <input type="text" class="form-control" name="direccion" id="direccion" placeholder="Direccion">
    </div>
  </div>
                <div class="form-group row">
    <label for="telefono" class="col-sm-2 col-form-label">Telefono</label>
    <div class="col-sm-6">
        <input type="text" class="form-control" name="telefono" id="telefono" placeholder="Telefono">
    </div>
  </div>
                <div class="form-group row">
    <label for="usuario" class="col-sm-2 col-form-label">Usuario</label>
    <div class="col-sm-6">
      <input type="text" required class="form-control" name="usuario" placeholder="Usuario">
    </div>
  </div>
                     <div class="form-group row">
    <label for="password" class="col-sm-2 col-form-label">Password</label>
    <div class="col-sm-6">
      <input type="password" required class="form-control" name="password" placeholder="Password">
    </div>
  </div>      
                        <div class="form-group row">
                            <button type="submit" class="btn btn-info btn-lg"><i class="fa fa-plus"></i>  REGISTRAR USUARIO</button>
                            <a href="Login.jsp" class="btn btn-danger btn-lg"><i class="fa fa-backward"></i>  VOLVER</a>
  </div>                    
</form>
        </div>
    </body>
</html>
