/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.carrinho.controler;

import br.uff.carrinho.model.PedidoDAO;
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
       
        switch(request.getParameter("acao")){
            case "fazLogin":
                fazLogin(request, response);
                break;
            case "fazLogout":
                fazLogout(request, response);
                break;
            case "criaConta":
                criaUsuario(request, response);
                break;
            case "exibeConta":
                exibeConta(request, response);
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

    /* ----------- */ 
    /* FUNCIONANDO */
    /* ----------- */
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
            
            // Recupera o usuário logado
            Usuario usuarioLogado = (Usuario) request.getSession().getAttribute("usuarioLogado");
            // Adiciona a lista de pedidos do usuario logado
            request.getSession().setAttribute("historicoPedidos", (new PedidoDAO().listaPorUsuario(usuarioLogado)));
            // Redireciona
            getServletConfig().getServletContext().getRequestDispatcher("/produtoServlet?acao=listaProdutos").forward(request, response);
        } else{
            response.sendRedirect("/carrinho/login.jsp");
        }
    }

    /* ----------- */ 
    /* FUNCIONANDO */
    /* ----------- */
    private void fazLogout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().invalidate();
        response.sendRedirect("/carrinho/produtoServlet?acao=listaProdutos");
    }

    /* ----------- */ 
    /* FUNCIONANDO */
    /* ----------- */
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
        getServletConfig().getServletContext().getRequestDispatcher("/produtoServlet?acao=listaProdutos").forward(request, response);
    }
    
    /* ----------- */ 
    /* FUNCIONANDO */
    /* ----------- */
    private void exibeConta(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        if (request.getSession().getAttribute("usuarioLogado") == null){
           response.sendRedirect("/carrinho/login.jsp");
           return;
        } else{
            // Usa o dispatcher pra trocar de tela
            getServletConfig().getServletContext().getRequestDispatcher("/conta.jsp").forward(request, response);
        }
    }

    /* ------ */ 
    /* TESTAR */
    /* ------ */
    private void trocaSenha(HttpServletRequest request, HttpServletResponse response) 
            throws IOException {        
        // Recupera o usuario da session http
        Usuario usuario = (new UsuarioDAO()).buscaPorEmail(request.getParameter("email"));
        if(request.getParameter("senha").equals(request.getParameter("confSenha"))){
            usuario.setSenha(request.getParameter("senha"));
            // Chama método para cadastrar usuário
            (new UsuarioDAO()).alteraSenha(usuario);
            response.sendRedirect("/carrinho/usuarioServlet?acao=exibeConta");
        } else{
            response.sendRedirect("/carrinho/login.jsp");
        }
    }

    /* ----------- */ 
    /* FUNCIONANDO */
    /* ----------- */
    private void alteraDados(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getSession().getAttribute("usuarioLogado") == null){
           response.sendRedirect("/carrinho/login.jsp");
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
            
            System.out.println(request.getParameter("nomeCompleto"));
            // Chama método para cadastrar usuário
            usuarioDAO.altera(usuario);

            request.getSession().setAttribute("usuarioLogado", usuario);
            response.sendRedirect("/carrinho/produtoServlet?acao=listaProdutos");
        }
    }
}
