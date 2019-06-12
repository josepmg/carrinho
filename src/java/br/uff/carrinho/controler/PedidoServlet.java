package br.uff.carrinho.controler;

import br.uff.carrinho.model.Cartao;
import br.uff.carrinho.model.CartaoDAO;
import br.uff.carrinho.model.Pedido;
import br.uff.carrinho.model.PedidoDAO;
import br.uff.carrinho.model.Usuario;
import br.uff.carrinho.model.UsuarioDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PedidoServlet extends HttpServlet {
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

    private void fazPedido(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        // Verifica se há um usuario logado
        if (request.getSession().getAttribute("usuarioLogado") == null){
           response.sendRedirect("/carrinho/login.jsp");
           return;
        } else{
            // Recupera o usuário logado
            Usuario usuarioLogado = (Usuario) request.getSession().getAttribute("usuarioLogado");
            // Recupera carrinho
            Pedido carrinho = (Pedido) request.getSession().getAttribute("carrinho");
            // Verifica se o carrinho está vazio
            if (carrinho == null || (carrinho.getItensPedido()).isEmpty()){
                response.sendRedirect("/carrinho/produtoServlet?acao=listaProdutos");
                return;
            } 
            else{
                // Informa o usuario do pedido
                carrinho.setCliente(usuarioLogado);                    
                // Se o cliente não possuir cartão cadastrado, o faz com os dados do formulário
                if(usuarioLogado.getCartao() == null){
                    // Cria um cartão no BD e recupera o index dele
                    int idCartao = (new CartaoDAO()).cria(
                            new Cartao(
                                    request.getParameter("numeroCartao"),
                                    request.getParameter("validadeCartao"),
                                    request.getParameter("titularCartao"),
                                    request.getParameter("ccvCartao")
                            ));
                    // Adiciona o cartão recém criado ao usuário
                    usuarioLogado.setCartao(
                            (Cartao) ((new CartaoDAO()).buscaPorNumero(request.getParameter("numeroCartao")))
                    );
                    // Associa o cartao ao usuario no BD
                    (new UsuarioDAO()).adicionaCartao(usuarioLogado.getCartao().getIdCartao(), usuarioLogado.getIdUsuario());
                }
                // Adciona o cartão ao carrinho
                carrinho.setCartao(usuarioLogado.getCartao());
                // Adciona o endereço de entrega ao pedido
                carrinho.setEnderecoEntrega(request.getParameter("enderecoEntrega"));
                // Cria um novo pedido no banco de dados
                (new PedidoDAO()).cria(carrinho);
                // Esvazia o carrinho na sessao Http (remove o atributo)
                request.getSession().removeAttribute("carrinho");
                // Vai para tela com todos os pedidos do usuario
                listaPedidos(request, response);
            }
        }
    }
    
    private void listaPedidos(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        if (request.getSession().getAttribute("usuarioLogado") == null){
           response.sendRedirect("login.jsp");
           return;
        } else{
            // Recupera o usuário logado
            Usuario usuarioLogado = (Usuario) request.getSession().getAttribute("usuarioLogado");
            // Adiciona a lista de pedidos do usuario logado
            request.getSession().setAttribute("historicoPedidos", (new PedidoDAO().listaPorUsuario(usuarioLogado)));
            // Troca de tela pelo Dispatcher (lado servidor)
            getServletConfig().getServletContext().getRequestDispatcher("/conta.jsp").forward(request, response);
        }
    }
}
