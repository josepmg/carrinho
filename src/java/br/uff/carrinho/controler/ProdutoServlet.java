package br.uff.carrinho.controler;

import br.uff.carrinho.model.Produto;
import br.uff.carrinho.model.ProdutoDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProdutoServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        switch(request.getParameter("acao")){
            case "listaProdutos":
                listaProdutos(request, response);
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

    private void listaProdutos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Produto> listaProdutos = (new ProdutoDAO()).listaTodos();
        // Adiciona a lista de todos os produtos na requeste
        request.setAttribute("listaProdutos", listaProdutos);
        // Troca de tela pelo Dispatcher (lado servidor)
        getServletConfig().getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
