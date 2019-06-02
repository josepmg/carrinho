/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.carrinho.controler;

import br.uff.carrinho.model.Item;
import br.uff.carrinho.model.Pedido;
import br.uff.carrinho.model.PedidoDAO;
import br.uff.carrinho.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JP
 */
public class PedidoServlet extends HttpServlet {

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
            case "fazPedido":
                fazPedido(request, response);
                break;
            case "listaPedidos":
                listaPedidos(request, response);
                break;
            case "alteraDados":
                alteraEstado(request, response);
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
    private void fazPedido(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        // Verifica se há um usuario logado
        if (request.getSession().getAttribute("usuarioLogado") == null){
           response.sendRedirect("login.jsp");
           return;
        } else{
            // Recupera o usuário logado
            Usuario usuarioLogado = (Usuario) request.getSession().getAttribute("usuarioLogado");
            
            // Recupera carrinho
            Pedido carrinho = (Pedido) request.getSession().getAttribute("carrinho");
            // Verifica se o carrinho esta vazio
            if (carrinho == null || (carrinho.getItensPedido()).isEmpty()){
                response.sendRedirect("carrinho.jsp");
                return;
            } 
            // Se não tivr vazio (nulo ou sem itens
            else{
                // Cria um novo pedido no banco de dados
                (new PedidoDAO()).cria(carrinho);
                // Esvazia o carrinho na sessao Http (remove o atributo)
                request.getSession().removeAttribute("carrinho");
                // Vai para tela com todos os pedidos do usuario
                listaPedidos(request, response);
//                // Adiciona a lista de pedidos do usuario logado
//                request.getSession().setAttribute("pedidos", (new PedidoDAO().listaPorUsuario(usuarioLogado)));
//                // Troca de tela pelo Dispatcher (lado servidor)
//                getServletConfig().getServletContext().getRequestDispatcher("/conta.jsp").forward(request, response);
            }
        }
    }

    /* ------ */
    /* TESTAR */
    /* ------ */
    private void listaPedidos(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        if (request.getSession().getAttribute("usuarioLogado") == null){
           response.sendRedirect("login.jsp");
           return;
        } else{
            // Recupera o usuário logado
            Usuario usuarioLogado = (Usuario) request.getSession().getAttribute("usuarioLogado");
            // Adiciona a lista de pedidos do usuario logado
            request.getSession().setAttribute("pedidos", (new PedidoDAO().listaPorUsuario(usuarioLogado)));
            // Troca de tela pelo Dispatcher (lado servidor)
            getServletConfig().getServletContext().getRequestDispatcher("/conta.jsp").forward(request, response);
        }
    }

    /* ------ */
    /* FAZER */
    /* ------ */
    private void alteraEstado(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
