<%-- 
    Document   : login
    Created on : 10/05/2018, 11:18:28 PM
    Author     : PCHINOL
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.Map"%>
<%@page import="entity.Usuario"%>
<%@page import="servlets.estadoUsuario"%>
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

<body >
    <div class="container">
        <br>
        <h2>Lista de usuarios</h2>
        <a href="Login.jsp" class="btn btn-danger btn-lg"><i class="fa fa-backward"></i>  VOLVER</a>
        <br><br>
        <table class="table table-bordered table-striped">
            <thead>
                <th>Codigo</th>
                <th>Usuario</th>
                <th>Password</th>
                <th>Estado</th>
                <th>Privilegio</th>
                <th>Activar</th>
                <th>Desactivar</th>
            </thead>
            <tbody>
                <%
                    try {
                            ArrayList<Usuario> arr = (ArrayList<Usuario>) request.getAttribute("listado");                
                   for (Usuario u  : arr) {
                           %>
                           
                           <tr>
                                <td><c:out value="<%= u.getIdUsuario() %>"></c:out></td>
                                <td><c:out value="<%= u.getUsuario()%>"></c:out></td>
                                <td><c:out value="<%= u.getPassword()%>"></c:out></td>
                                <td><c:out value="<%= u.getEstado().getEstado() %>"></c:out></td>
                                <td><c:out value="<%= u.getTipo_usuario().getTipo_Usuario() %>"></c:out></td>
                                <td class="text-center"><a href="estadoUsuario?cod=<c:out value="<%= u.getIdUsuario() %>"></c:out>&action=a" class="btn btn-success"><i class="fa fa-check"></i></a></td>
                                <td class="text-center"><a href="estadoUsuario?cod=<c:out value="<%= u.getIdUsuario() %>"></c:out>&action=d" class="btn btn-danger"><i class="fa fa-times"></i></a></td>
                           </tr>
                           
                           
                           <%
                       }
                        } catch (Exception e) {
                            System.out.println("da "+e.getMessage());
                        }
                    
                           
                 %>

               
            </tbody>
        </table>
    </div>
</body>
</html>
