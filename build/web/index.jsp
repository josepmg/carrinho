<%@page import="br.uff.carrinho.model.Pedido"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.uff.carrinho.model.Produto"%>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
    ArrayList<Produto> listaProdutos = (ArrayList<Produto>)request.getAttribute("listaProdutos");
    // A lista de usu?rios ? colocada no contexto da p?gina. Assim o JSTL ter? acesso a ela
    pageContext.setAttribute("listaProdutos", listaProdutos);

    Pedido carrinho = (Pedido) request.getAttribute("carrinho");
    // A lista de usu?rios ? colocada no contexto da p?gina. Assim o JSTL ter? acesso a ela
    pageContext.setAttribute("carrinho", carrinho);
%>
<!doctype html>
<html lang="pt-br">
  <head>
    <!-- Required meta tags -->
    <meta charset="iso-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css"
      integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css?family=Montserrat+Alternates&display=swap" rel="stylesheet">
    
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">

    <title>Produtos - MeuCarrinho!</title>

    <!-- INICIO PAGINA DE ESTILO -->
    <style>
      *:focus {
        box-shadow: none !important;
      }
      input:focus {
        box-shadow: 2px 2px 5px rgba(0, 0, 0, 0.2) !important;
      }
      .container-fluid {
        padding: 0 !important;
      }
      .fundoHome {
        background-color: #c3c3c3;
      }
      .box {
        justify-content: center !important;
      }
      #navbarText {
        width: 100%;
        text-align: center !important;
      }
      #myCart {
        position: fixed;
        bottom: 50px;
        border: 1px solid black;
        background: white;
        padding: 10px 20px;
        border-radius: 0px 0px 10px 0px;
        left: -500px;
      }
      #myBtn {
        width: 50px;
        background: #f34747;
        border-radius: 0px 30px 30px 0px;
        position: fixed;
        font-size: 20px;
        color: black;
        bottom: 168px;
        left: 0;
        z-index: 10;
      }
      #myBtn:hover {
        width: 55px;
        background: rgba(247, 27, 27, 0.9);
      }
      .logo {
        margin-left: 10%;
        min-width: 300px;
      }
      #navbarText {
        margin-left: 0 !important;
      }
  
      @media screen and (max-width:600px) {
        .fundoProdutos {
          width: 100% !important;
          padding: 0;
        }
        #carouselInicio{
          display:none!important;
        }
        .box {
  
          margin-bottom: 5% !important;
          justify-content: center !important;
        }
    
        nav>.collapse {
          margin-left: 0% !important;
        }
  
        .logo {
          min-width: 300px !important;
        }
      }
      @media screen and (max-width:768px) {
        .fundoProdutos {
          width: 100% !important;
          padding: 0;
        }
        .box {
          margin-bottom: 5% !important;
          justify-content: center !important;
        }
        .carousel-inner {
          height: 150px !important;
        }
        #myBtn {
          margin-left: -10000px;
        }
      }
      @media screen and (max-width:992px) {
        .fundoProdutos {
          width: 100% !important;
          padding: 0;
        }
        .box {
          margin-bottom: 5% !important;
          justify-content: center !important;
        }
        #navbarText {
          margin-left: 0 !important;
        }
        .logo {
          margin-left: 35%;
        }
      }
      @media screen and (max-width: 507px) {
        .logo {
          margin-left: 5% !important;
        }
      }
    </style>
    <!-- FIM PAGINA DE ESTILO -->

    <!-- JS -->
    <script>
      function myFunction(myCart, myBtn) {
        var botao = document.getElementById('myCart');
        var botao2 = document.getElementById('myBtn');
        num = botao.style.left;
        if (botao.style.left == '-500px') {
          botao.style.transition = '.4s';
          botao.style.left = '0';
          botao2.style.transition = '.45s';
          botao2.style.left = '292px';
        }
        else {
          botao.style.left = '-500px';
          botao.style.transition = '0.4s';
          botao2.style.left = '0px';
          botao2.style.transition = '0.45s';
        }
      }
    </script>
    <script>
      $(function () {
        $('[data-toggle="tooltip"]').tooltip()
      })
    </script>
    <!-- FIM JS -->
  </head>
  <body>

    <!-- INICIO MENU TOPO -->
    <nav style="font-family: 'Montserrat Alternates', sans-serif;" class="navbar navbar-expand-lg navbar-dark bg-dark">
      <div class="logo"><i style="color: white; font-size: 40px; padding: 1% 2%"
          class="fas fa-shopping-cart text-center"></i>
          <a class="navbar-brand" href="/carrinho/produtoServlet?acao=listaProdutos">
            <span style="font-size: 28px; color: #f34747; font-weight: bold">MEU</span>carrinho
          </a>
      </div>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText"
        aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
      </button>
      <div style="margin-left: 10%!important;" class="collapse navbar-collapse" id="navbarText">
        <ul style="font-size: 18px" class="navbar-nav mr-auto">
          <li class="nav-item active">
            <a style="color: #f34747;" class="nav-link" href="/carrinho/produtoServlet?acao=listaProdutos">
              <i class="fas fa-tags"></i>
              Produtos
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/carrinho/carrinhoServlet?acao=mostraCarrinho">
              <i class="fas fa-shopping-basket"></i>
              Meu carrinho
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/carrinho/usuarioServlet?acao=exibeConta">
              <i class="fas fa-user-cog"></i>
              Conta</a>
          </li>
          <li class="nav-item">
            <a style="color: black;text-shadow: .5px .5px 4px rgba(255,255,255,0.4);" class="nav-link" href="/carrinho/usuarioServlet?acao=fazLogout">
              <i class="fas fa-sign-out-alt"></i>
              Sair</a>
          </li>
        </ul>
      </div>
    </nav>
    <!-- FIM MENU TOPO -->

    <!-- INICIO CARROSSEL -->
    <div id="carouselInicio" class="carousel slide" data-ride="carousel">
      <div class="carousel-inner" style="height:50vh;" role="listbox">
        <div class="carousel-item active carousel-fade">
          <img class="d-block w-100" src="img/inicioFundo.jpg" alt="First slide">
        </div>
        <div class="carousel-item carousel-fade">
          <img class="d-block w-100" src="img/Snow.jpg" alt="Second slide">
        </div>
        <div class="carousel-item carousel-fade">
          <img class="d-block w-100" src="img/shopping.jpg" alt="Third slide">
        </div>
      </div>
      <a class="carousel-control-prev" href="#carouselInicio" role="button" data-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
      </a>
      <a class="carousel-control-next" href="#carouselInicio" role="button" data-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
      </a>
    </div>
    <!-- FIM CARROSSEL -->

    <!-- CORPO PRINCIPAL -->
    <div class="container-fluid">
      <div style="padding-top: 3%;" class="fundoHome">
        <div
          style="width:70%;height: 100%; background-color: white; padding-top: 1%;padding-bottom: 10%; margin: auto;box-shadow: 3px 3px 5px rgba(0, 0, 0, 0.2);"
          class="fundoProdutos">
          <!-- IN�CIO TITULOS CABE�ALHO -->
          <nav class="navbar navbar-dark">
            <div class="row col-lg-12">
              <div class="nomeProdutos offset-lg-3 col-lg-3">
                <h2
                  style="width:100%!important;font-family: 'Montserrat Alternates', sans-serif; padding-top: 2%;margin:5% auto;">
                  <i class="fas fa-tags"></i>
                  Produtos
                </h2>
              </div>
              <div class="formProdutos offset-lg-3 col-lg-3" style="margin:auto;">
                <form class="form-inline" style="min-width: 300px!important; margin:5% auto;">
                  <input style="border: 1px solid black!important;" class="form-control mr-sm-2" type="search"
                    placeholder="Buscar produto" aria-label="Search">
                  <button style="color: white; border-color: white;background-color: #f34747;"
                    class="btn btn-outline-danger my-2 my-sm-0" type="submit">
                    <i class="fas fa-search"></i>
                  </button>
                </form>
              </div>
            </div>
          </nav>
          <!-- FIM TITULOS CABE�ALHO -->
          <!-- INICIO PRODUTOS -->
          <div style="margin-top: 4%;" class="row justify-content-md-center">
            <c:if test="${listaProdutos != null}">
              <c:forEach var="p" items="${listaProdutos}">
                <!-- PRODUTO -->
                <div
                  style="border: 1px solid black;height: 200px; margin-left: 5px; background-color: white; background-image: url(${p.imagePath}); background-size: 80%; background-repeat: no-repeat"
                  class=" col-sm-5 col-md-4 col-lg-2 box" data-toggle="tooltip" data-placement="top"
                  title="${p.descricao}">
                  <p style=" padding:0%;width: 100% ; background-color: white;">
                    ${p.idProduto} - ${p.nome}
                    <br />
                    <fmt:setLocale value="pt_BR" />
                    <fmt:formatNumber value="${p.preco}" type="currency" />
                  </p>
                  <!-- form="formProduto" -->
                  <form method="POST" action="/carrinho/carrinhoServlet?acao=adicionaProduto" id="formProduto">
                    <input type="hidden" name="idProduto" value="${p.idProduto}" />
                    <button style="bottom: 5px; right: 5px; float: right; position: absolute;" type="submit"
                      class="btn btn-success">
                      <i class="fas fa-plus"></i>
                    </button>
                  </form>
                </div>
                <!-- FIM PRODUTO -->
              </c:forEach>
            </c:if>
          </div>
          <!-- FIM PRODUTOS -->
        </div>
      </div>
    </div>

    <!-- INICIO CARD SUBTOTAL -->
    <div style="box-shadow: 3px 3px 5px rgba(0, 0, 0, 0.2)!important;" id="myCart" class="subtotal">
      <span style="font-weight: bold;">Seu carrinho!</span><br>
      <span style="width: 250px;margin-top: 3%; display: inline-block; margin-top: 15%;margin-bottom: 15%;">
        <i style="color: black; font-size: 40px; margin-right: 5%;" class="fas fa-cart-plus"></i>
        <fmt:setLocale value="pt_BR" />
        Subtotal:
        <fmt:formatNumber value="${carrinho.valorTotal}" type="currency" />
      </span>
    </div>
    <button onClick="myFunction('#myCart','#myBtn')" id="myBtn" type="button" class="btn"><i
        class="fas fa-cart-plus"></i>
    </button>
    <!-- FIM CARD SUBTOTAL -->

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
      integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
      crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
      integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
      crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
      integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
      crossorigin="anonymous"></script>
  </body>
</html>