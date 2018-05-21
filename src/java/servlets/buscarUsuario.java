/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entity.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Conexion;
import modelo.UsuarioDao;

/**
 *
 * @author PCHINOL
 */
public class buscarUsuario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    UsuarioDao usuarioController = new UsuarioDao();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
        String n=request.getParameter("username");  
        String p=request.getParameter("password"); 
        
        HttpSession session = request.getSession(false);
        session.setAttribute("name", n);
           String privilegio = usuarioController.validar(n, p);     
        if(privilegio.equals("admin")){  
            request.setAttribute("listado", usuarioController.arreglo());
            RequestDispatcher rd=request.getRequestDispatcher("ListarUsuario.jsp");  
            
            rd.forward(request,response);  
        }
        else if(privilegio.equals("usuario")){
            Usuario us = new Usuario();
            us = usuarioController.arregloUsuario(n);
            request.setAttribute("usuarioDatos", us);
            RequestDispatcher rd=request.getRequestDispatcher("Welcome.jsp");  
            rd.forward(request,response);  
        }
        else{  
            out.print("<p class='alert alert-danger'>Sorry username or password error</p>");  
            RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");  
            rd.include(request,response);  
        }  

        out.close(); 
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
