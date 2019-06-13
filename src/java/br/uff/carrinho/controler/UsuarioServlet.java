package br.uff.carrinho.controler;

import br.uff.carrinho.model.PedidoDAO;
import br.uff.carrinho.model.Usuario;
import br.uff.carrinho.model.UsuarioDAO;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UsuarioServlet", urlPatterns = {"/usuarioServlet"})
public class UsuarioServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
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
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    private void fazLogin(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        // Busca credenciais no BD
        Usuario usuario = (new UsuarioDAO()).buscaLogin(
                request.getParameter("email"), 
                request.getParameter("senha")
        );
        // Verifica se houve retorno
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

    private void fazLogout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().invalidate();
        response.sendRedirect("/carrinho/produtoServlet?acao=listaProdutos");
    }
    
    private void criaUsuario(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException, ParseException {
        // Recupera a string da data de nascimento, e cria uma nova Data utilizando o padrão descrito abaixo
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("dataNascimento"));
        // Cria um novo usuário com os dados dos Form
        Usuario usuario = new Usuario(
                request.getParameter("nomeCompleto"),
                date.getTime(),
                request.getParameter("apelido"), 
                request.getParameter("email"), 
                request.getParameter("senha")
        );
        // Cria um objeto de acesso ao BD
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        // Chama método para cadastrar usuário
        usuarioDAO.cria(usuario);
        // Salva na sessão Http e redireciona pelo Dispatcher
        request.getSession().setAttribute("usuarioLogado", (Usuario) (new UsuarioDAO()).buscaPorEmail(usuario.getEmail()));
        getServletConfig().getServletContext().getRequestDispatcher("/produtoServlet?acao=listaProdutos").forward(request, response);
    }

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

    private void trocaSenha(HttpServletRequest request, HttpServletResponse response) 
            throws IOException {        
        // Recupera o usuario da session http
        Usuario usuario = (new UsuarioDAO()).buscaPorEmail(request.getParameter("email"));
        // Verifica se as senhas são iguais. Se sim, redireciona para página de conta
        // Se não for, redireciona para a página de login
        if(request.getParameter("senha").equals(request.getParameter("confSenha"))){
            usuario.setSenha(request.getParameter("senha"));
            // Chama método para cadastrar usuário
            (new UsuarioDAO()).alteraSenha(usuario);
            request.getSession().setAttribute("usuarioLogado", usuario);
            response.sendRedirect("/carrinho/usuarioServlet?acao=exibeConta");
        } else{
            response.sendRedirect("/carrinho/login.jsp");
        }
    }
    
    private void alteraDados(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
        if (request.getSession().getAttribute("usuarioLogado") == null){
           response.sendRedirect("/carrinho/login.jsp");
           return;
       } else{   
            // Recupera a string da data de nascimento, e cria uma nova Data utilizando o padrão descrito abaixo
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("dataNascimento"));   
            // Cria usuário temporário com dados do formulário
            Usuario usuario = new Usuario(
                    request.getParameter("nomeCompleto"),
                    date.getTime(),
                    request.getParameter("apelido"), 
                    request.getParameter("email"), 
                    request.getParameter("senha"));
            usuario.setIdUsuario(Integer.valueOf(request.getParameter("idUsuario")));
            // Chama método para cadastrar usuário
            (new UsuarioDAO()).altera(usuario);
            // Salva usuário na sessão (com dados novos) e redireciona
            request.getSession().setAttribute("usuarioLogado", usuario);
            response.sendRedirect("/carrinho/produtoServlet?acao=listaProdutos");
        }
    }
}
