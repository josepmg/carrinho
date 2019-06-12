package br.uff.carrinho.controler;

import br.uff.carrinho.model.Pedido;
import br.uff.carrinho.model.Produto;
import br.uff.carrinho.model.ProdutoDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CarrinhoServlet extends HttpServlet {
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
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void criaCarrinho(HttpServletRequest request, HttpServletResponse response) {
        Pedido carrinho = new Pedido();
        request.setAttribute("carrinho", carrinho);
    }

    private void deletaCarrinho(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().removeAttribute("carrinho");
    }

    private void mostraCarrinho(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Verifica se já há um carrinho
        if(request.getSession().getAttribute("carrinho") == null){
            Pedido carrinhoLocal = new Pedido();
            request.getSession().setAttribute("carrinho", carrinhoLocal);
        }
        getServletConfig().getServletContext().getRequestDispatcher("/carrinho.jsp").forward(request, response);
    }

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
    
    private void alteraQuantidade(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Verifica se existe um carrinho
        if(request.getSession().getAttribute("carrinho") == null){
            getServletConfig().getServletContext().getRequestDispatcher("/carrinho/produtoServlet?acao=listaProdutos").forward(request, response);
        }
        if(request.getParameter("qtdItem").equals("0")){
            removeProduto(request, response);
        } else{
            Pedido carrinhoLocal = (Pedido) request.getSession().getAttribute("carrinho");
            // Recupera posição do item no array do pedido
            int itemPos = Integer.valueOf(request.getParameter("itemPos"));
            // Recupera quantidade informada no form
            int qtdItem = Integer.valueOf(request.getParameter("qtdItem"));
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
