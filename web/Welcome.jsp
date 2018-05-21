<%-- 
    Document   : Welcome
    Created on : 11/05/2018, 12:21:55 PM
    Author     : PCHINOL
--%>

<%@page import="entity.Usuario"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <body>
        <div class="container text-center">
            <h1 class="text-primary"><i class="fa fa-warning"></i> Felicitaciones</h1>
            <h1 class="text-info">Usted está registrado Sr(a) <c:out value="<%= session.getAttribute("name") %>"></c:out>  </h1>
            <% 
               Usuario us = null;
               us =(Usuario) request.getAttribute("usuarioDatos");   
               
            %>
            <table class="table table-striped table-bordered table-condensed">
                 <thead>
                    <th>Codigo</th>
                    <th>DNI</th>
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>Direccion</th>
                    <th>Telefono</th>
                    <th>Usuario</th>
                    <th>Estado</th>
                    <th>Tipo Usuario</th>
            </thead>
            <tbody>
                <tr>
                  <td><c:out value="<%= us.getIdUsuario()%>"></c:out></td>
                  <td><c:out value="<%= us.getDNI()%>"></c:out></td>
                  <td><c:out value="<%= us.getNombre()%>"></c:out></td>
                  <td><c:out value="<%= us.getApellido()%>"></c:out></td>
                  <td><c:out value="<%= us.getDireccion()%>"></c:out></td>
                  <td><c:out value="<%= us.getTelefono()%>"></c:out></td>
                  <td><c:out value="<%= us.getUsuario()%>"></c:out></td>
                  <td><c:out value="<%= us.getEstado().getEstado() %>"></c:out></td>
                  <td><c:out value="<%= us.getTipo_usuario().getTipo_Usuario() %>"></c:out></td>
                </tr>
            </tbody>
            </table> 
                  <c:if test="<%= us.getEstado().getIdEstado() == 2 %>">
                      <span class="alert alert-danger">Este usuario no se encuentra activo, comuníquese con un administrador</span>
                  </c:if>
                  <c:if test="<%= us.getEstado().getIdEstado() == 1 %>">
                      <span class="alert alert-success">Este usuario se encuentra activo</span>
                  </c:if>
                      <br>                      <br>

        <a href="Login.jsp" class="btn btn-danger btn-lg"><i class="fa fa-backward"></i>  VOLVER</a>
        </div>
        
    </body>
</html>
