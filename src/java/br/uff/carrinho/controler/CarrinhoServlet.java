/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.carrinho.controler;

import br.uff.carrinho.model.Item;
import br.uff.carrinho.model.Pedido;
import br.uff.carrinho.model.Produto;
import br.uff.carrinho.model.ProdutoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JP
 */
public class CarrinhoServlet extends HttpServlet {

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
        switch(request.getParameter("acao")){
            case "criaCarrinho":
                criaCarrinho(request, response);
                break;
            case "deletaCarrinho":
                deletaCarrinho(request, response);
                break;
            case "mostraCarrinho":
                mostraCarrinho(request, response);
                break;
            case "adicionaProduto":
                adicionaProduto(request, response);
                break;
            case "alteraQuantidade":
                alteraQuantidade(request, response);
                break;
            case "removeProduto":
                removeProduto(request, response);
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
    private void criaCarrinho(HttpServletRequest request, HttpServletResponse response) {
        Pedido carrinho = new Pedido();
        request.setAttribute("carrinho", carrinho);
    }

    /* ------ */
    /* TESTAR */
    /* ------ */
    private void deletaCarrinho(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().removeAttribute("carrinho");
    }
    
    /* ------ */
    /* TESTAR */
    /* ------ */
    private void mostraCarrinho(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Verifica se já há um carrinho
        if(request.getSession().getAttribute("carrinho") == null){
            Pedido carrinhoLocal = new Pedido();
            request.getSession().setAttribute("carrinho", carrinhoLocal);
        }
        getServletConfig().getServletContext().getRequestDispatcher("/carrinho.jsp").forward(request, response);
    }

    /* ------ */
    /* TESTAR */
    /* ------ */
    private void adicionaProduto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Recupera carrinho
        Pedido carrinhoLocal = null;
        // Verifica se já há um carrinho
        if(request.getSession().getAttribute("carrinho") == null){
            carrinhoLocal = new Pedido();
        } else{
            carrinhoLocal = (Pedido) request.getSession().getAttribute("carrinho");
        }
        
        System.out.println("Produto:" + request.getParameter("idProduto"));
        // Adiciona produto ao carrinho
        carrinhoLocal.adicionaProduto(
                (Produto) (new ProdutoDAO()).busca(Integer.valueOf(request.getParameter("idProduto")))
        );
        
        // Atualiza valor total do carrinho
        carrinhoLocal.calculaValorTotal();
        // Coloca o carrinho atualziado na sessão
        request.getSession().setAttribute("carrinho", carrinhoLocal);
        
        // Usa o dispatcher pra trocar de tela
        getServletConfig().getServletContext().getRequestDispatcher("/produtoServlet?acao=listaProdutos").forward(request, response);
    }

    /* ------ */
    /* TESTAR */
    /* ------ */
    private void alteraQuantidade(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Verifica se existe um carrinho
        if(request.getSession().getAttribute("carrinho") == null){
            getServletConfig().getServletContext().getRequestDispatcher("/carrinho/produtoServlet?acao=listaProdutos").forward(request, response);
        }
        
        if(request.getParameter("quantidade").equals("0")){
            removeProduto(request, response);
        } else{
            Pedido carrinhoLocal = (Pedido) request.getSession().getAttribute("carrinho");

            // Recupera posição do item no array do pedido
            int itemPos = Integer.valueOf(request.getParameter("itemPos"));
            System.out.println("pos: " + itemPos);
            // Recupera quantidade informada no form
            int qtdItem=  Integer.valueOf(request.getParameter("quantidade"));
            System.out.println("qtdItem: " + qtdItem);
            // Altera a quantidade do item
            ((carrinhoLocal.getItensPedido()).get(itemPos)).setQuantidade(qtdItem);

            // Atualiza valor total do carrinho
            carrinhoLocal.calculaValorTotal();
            // Coloca o carrinho atualziado na sessão
            request.getSession().setAttribute("carrinho", carrinhoLocal);

            // Mostra o carrinho
            mostraCarrinho(request, response);
        }
        
    }

    /* ------ */
    /* TESTAR */
    /* ------ */
    private void removeProduto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Verifica se existe um carrinho
        if(request.getSession().getAttribute("carrinho") == null){
            getServletConfig().getServletContext().getRequestDispatcher("/carrinho/produtoServlet?acao=listaProdutos").forward(request, response);
        }
        
        Pedido carrinhoLocal = (Pedido) request.getSession().getAttribute("carrinho");

        // Recupera posição do item no array do pedido
        int itemPos = Integer.valueOf(request.getParameter("itemPos"));
        
        // Altera a quantidade do item
        (carrinhoLocal.getItensPedido()).remove(itemPos);
        
        // Atualiza valor total do carrinho
        carrinhoLocal.calculaValorTotal();
        // Coloca o carrinho atualziado na sessão
        request.getSession().setAttribute("carrinho", carrinhoLocal);
        
        // Mostra o carrinho
        mostraCarrinho(request, response);
    }

}
