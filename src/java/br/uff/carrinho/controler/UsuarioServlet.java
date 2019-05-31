/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.carrinho.controler;

import br.uff.carrinho.model.Usuario;
import br.uff.carrinho.model.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author JP
 */
@WebServlet(name = "UsuarioServlet", urlPatterns = {"/usuarioServlet"})
public class UsuarioServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String nomeAcao = request.getParameter("acao");
        
        switch(nomeAcao){
            case "fazLogin":
                fazLogin(request, response);
                break;
            case "fazLogout":
                fazLogout(request, response);
                break;
            case "criaConta":
                criaUsuario(request, response);
                break;
            case "trocaSenha":
                trocaSenha(request, response);
                break;
            case "alteraDados":
                alteraDados(request, response);
                break;
            default:
                break;
        }
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

    /* ------ */ 
    /* TESTAR */
    /* ------ */
    private void fazLogin(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        Usuario usuario = (new UsuarioDAO()).buscaLogin(
                request.getParameter("email"), 
                request.getParameter("senha")
        );
        
        if (usuario !=  null){
            // Salva na session
            request
                    .getSession()
                    .setAttribute("usuarioLogado", usuario);
            // Redireciona
            getServletConfig().getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        } else{
            response.sendRedirect("/index.jsp");
        }
    }

    /* ------ */ 
    /* TESTAR */
    /* ------ */
    private void fazLogout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().invalidate();
        response.sendRedirect("index.jsp");
    }

    /* ------ */ 
    /* TESTAR */
    /* ------ */
    private void criaUsuario(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Cria um novo usuário com os dados dos Form
        Usuario usuario = new Usuario(
                request.getParameter("nomeCompleto"),
                request.getParameter("dataNascimento"),
                request.getParameter("apelido"), 
                request.getParameter("email"), 
                request.getParameter("senha")
        );

        // Cria um objeto de acesso ao BD
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        // Chama método para cadastrar usuário
        usuarioDAO.cria(usuario);

        request.getSession().setAttribute("usuarioLogado", usuario);
        getServletConfig().getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }

    /* ------ */ 
    /* TESTAR */
    /* ------ */
    private void trocaSenha(HttpServletRequest request, HttpServletResponse response) 
            throws IOException {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        
        // Recupera o usuario da session http
        Usuario usuario = usuarioDAO.buscaPorEmail(request.getParameter("email"));
        usuario.setSenha(request.getParameter("senha"));
        
        // Chama método para cadastrar usuário
        usuarioDAO.alteraSenha(usuario);

        response.sendRedirect("index.jsp");
    }

    /* ------ */ 
    /* TESTAR */
    /* ------ */
    private void alteraDados(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getSession().getAttribute("usuarioLogado") == null){
           response.sendRedirect("login.jsp");
           return;
       } else{        
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            
            Usuario usuario = new Usuario(
                    request.getParameter("nomeCompleto"),
                    request.getParameter("dataNascimento"),
                    request.getParameter("apelido"), 
                    request.getParameter("email"), 
                    request.getParameter("senha"));
            usuario.setIdUsuario(Integer.valueOf(request.getParameter("idUsuario")));

            // Chama método para cadastrar usuário
            usuarioDAO.altera(usuario);

            request.getSession().setAttribute("usuarioLogado", usuario);
            response.sendRedirect("index.jsp");
        }
    }

}
