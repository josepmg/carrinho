<%@page import="br.uff.carrinho.model.Pedido"%>
<%@page import="br.uff.carrinho.model.Item"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
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

  <script type="text/javascript" src="js/bootstrap.min.js"></script>

  <link rel="stylesheet" type="text/css" href="css/style.css">

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.11/jquery.mask.min.js"></script>

  <link rel="stylesheet" type="text/css" href="css/style.css">

  <title>Meu carrinho - MeuCarrinho!</title>


  <!-- INICIO PAGINA DE ESTILO -->
  <style>
    body {
      background-color: #c3c3c3 !important;
    }

    .container-fluid {
      height: auto !important;
    }

    .box {
      justify-content: center !important;
    }

    #btnConf {
      width: 273px;
      margin-left: 15px;
    }

    #Voltar {
      width: 150px;
    }

    .logo {
      margin-left: 10%;
    }

    @media screen and (max-width: 507px) {
      .logo {
        width: 100px !important;
        margin-left: 5% !important;
      }
    }

    @media screen and (max-width:600px) {
      .container-fluid {
        width: 100% !important;
        padding: 0;
        height: 100%;
      }

      #carouselInicio {
        display: none !important;
      }

      .box {
        margin-left: 15% !important;
        margin-bottom: 5% !important;
        justify-content: center !important;
      }
    }

    #navbarText {
      width: 100%;
      text-align: center !important;
    }

    .logo {
      min-width: 300px !important;
    }

    @media screen and (max-width:768px) {
      .container-fluid {
        width: 100% !important;
        padding: 0;
        height: 100%;
      }

      .box {
        margin-bottom: 5% !important;
        justify-content: center !important;
      }
    }

    @media screen and (max-width:992px) {
      .fundoHome {
        width: 100% !important;
      }

      .fundoProdutos {
        width: 100% !important;
        padding: 0;
      }

      .container-fluid {
        width: 100% !important;
        padding: 0;
        height: 100% !important;
      }

      .box {
        margin-bottom: 5% !important;
        justify-content: center !important;
      }

      .subtotal {
        display: none !important;
      }

      #navbarText {
        margin-left: 0px !important;
      }

      .logo {
        margin-left: 35%;
      }
    }
  </style>

  <!-- FIM PAGINA DE ESTILO -->

  <!-- JS -->
  <script type="text/javascript">
    $("#cpf").mask("000.000.000-00");
  </script>
  <script type="text/javascript">
    $("#cartao").mask("0000.0000.0000.0000");
  </script>
  <script type="text/javascript">
    $("#cv").mask("000");
  </script>
  <script>
    $(function () {
      $('[data-toggle="tooltip"]').tooltip()
    })
  </script>
  <script>
    $('#example').tooltip({boundary: 'window'})
  </script>
  <!-- Fim JS -->
</head>

<body>

  <!-- MODAL COMPRA -->

  <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
    aria-hidden="true">
    <div class="modal-dialog" role="document">

      <div style="padding: 15px 10px!important;" class="modal-content">
        <div class="modal-header">
          <h2 style="width: 300px;font-family: 'Montserrat Alternates', sans-serif;font-size: 30px;">
            <i style="font-size: 30px;margin-right: 5%;" class="fas fa-receipt"></i>Dados da compra</h2>
          <button
            style="margin-left: 0px!important;width:50px!important;font-size: 25px!important;color: black!important;"
            type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span style="float:right; color: black!important;" aria-hidden="true">&times;</span>
          </button>
        </div>
        <div class="modal-body">

          <!-- FIM MODAL COMPRA -->

          <!-- FORM COMPRA -->
          <form method="POST" action="/carrinho/pedidoServlet?acao=fazPedido" id="formCompra">
            <div class="row">
              <div class="form-group col-lg-6">
                <label for="exampleFormControlInput1">N�mero do cart�o</label>
                <input type="text" class="form-control" id="cartao" name="numeroCartao" value="${usuarioLogado.cartao.numero}">
              </div>
              <div class="form-group col-lg-6">
                <label for="exampleFormControlInput1">Validade</label>
                <input type="date" class="form-control" id="exampleFormControlInput1" name="validadeCartao" value="${usuarioLogado.cartao.validade}">
              </div>
            </div>
            <div class="row">
              <div class="form-group col-lg-9">
                <label for="exampleFormControlInput1">Nome do titular</label>
                <input type="text" class="form-control" id="exampleFormControlInput1" name="titularCartao" value="${usuarioLogado.cartao.titular}">
              </div>
              <div class="form-group col-lg-3">
                <label for="exampleFormControlInput1">CCV</label>
                <input type="text" class="form-control" id="cv" name="ccvCartao" value="${usuarioLogado.cartao.ccv}">
              </div>
            </div>
            <div class="row">
              <div class="form-group col-lg-6">
                <label for="exampleFormControlSelect1">Parcelas</label>
                <select class="form-control" id="exampleFormControlSelect1">
                    <fmt:setLocale value="pt_BR" /> 
                    <c:forEach var="i" begin="1" end="5" >
                        <option><c:out value="${i}"/>x de <fmt:formatNumber value="${carrinho.valorTotal/i}" type="currency" /></option>
                    </c:forEach>
                </select>
              </div>
            </div>
              <div class="row">
              <div class="form-group col-lg-12">
                <label for="exampleFormControlSelect1">Endere�o de entrega</label>
                <input type="text" class="form-control" id="exampleFormControlInput1" name="enderecoEntrega">
              </div>
            </div>
          </form>
          <div class="row">
            <div class="form-group col-lg-4">
                <button id="Voltar" type="reset" class="btn btn-secondary" class="close" data-dismiss="modal"
                aria-label="Close" form="formCompra">Voltar</button>
            </div>
            <div class="form-group col-lg-8">
                <button id="btnConf" style="background-color:#f34747; color: white" class="btn"
                class="close" aria-label="Close" form="formCompra" type="submit"><a>Confirmar</a></button>
            </div>
          </div>
        </div>
        <!-- FIM RECUPERA��O DE SENHA -->
      </div>
    </div>
  </div>

  <!-- INICIO MENU -->
  <nav style="font-family: 'Montserrat Alternates', sans-serif;" class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="logo"><i style="color: white; font-size: 40px; padding: 1% 2%!important;"
        class="fas fa-shopping-cart text-center"></i>
      <a class="navbar-brand" href="#">
        <span style="font-size: 28px; color: #f34747; font-weight: bold">MEU</span>carrinho</a></div>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText"
      aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div style="margin-left: 10%; justify-content: center;" class="collapse navbar-collapse" id="navbarText">
      <ul style="font-size: 18px" class="navbar-nav mr-auto">
        <li class="nav-item">
          <a class="nav-link" href="/carrinho/produtoServlet?acao=listaProdutos">
            <i class="fas fa-tags"></i>
            Produtos</a>
        </li>
        <li class="nav-item active">
          <a style="color: #f34747;" class="nav-link" href="/carrinho/carrinhoServlet?acao=mostraCarrinho">
            <i class="fas fa-shopping-basket"></i>
            Meu carrinho</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/carrinho/usuarioServlet?acao=exibeConta">
            <i class="fas fa-user-cog"></i>
            Conta</a>
        </li>
        <li class="nav-item">
          <a style="color: black;" class="nav-link" href="/carrinho/usuarioServlet?acao=fazLogout">
            <i class="fas fa-sign-out-alt"></i>
            Sair</a>
        </li>
      </ul>
    </div>
  </nav>
  <!-- FIM MENU -->

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

  <!-- INICIO PRODUTOS -->
  <div class="container-fluid">
    <div style="padding-top: 3%;" class="fundoHome">
      <div
        style="width:70%;height: 100%; background-color: white; padding-top: 1%;padding-bottom: 10%; margin: auto;box-shadow: 3px 3px 5px rgba(0, 0, 0, 0.2);"
        class="fundoProdutos">
        <nav class="navbar navbar-dark">
          <div class="row col-lg-12">
            <div class="nomeProdutos  col-lg-10">
              <h2 style="font-family: 'Montserrat Alternates', sans-serif; padding-top: 2%; margin-left: 15%;">
                <i class="fas fa-shopping-basket"></i>
                Meu Carrinho</h2>
            </div>
        </nav>

        <div style="margin-top: 4%;" class="row justify-content-md-center">
          <!-- PRODUTO -->
          <c:if test="${carrinho != null}">
            <c:forEach var="i" items="${carrinho.itensPedido}" varStatus="loop">
              <div
                style="border: 1px solid black;width:300px; height: 300px!important; margin-left: 5px; background-color: white; background-image: url(${i.produto.imagePath}); "
                class="col-sm-6 col-md-2 col-lg-2 box">
                <p style=" padding:0%;width: 100% ; background-color: white;">${i.produto.nome}
                  <br />
                  <fmt:setLocale value="pt_BR" />
                  <fmt:formatNumber value="${i.preco}" type="currency" />
                </p>
                <form method="POST" action="/carrinho/carrinhoServlet?acao=alteraQuantidade" id="formItemCarrinho">
                  <input type="hidden" name="itemPos" value="${loop.index}" />
                  <input type="number" name="qtdItem" value="${i.quantidade}" />
                  <button style="bottom: 5px; right: 5px; float: right; position: absolute;" type="submit"
                    class="btn btn-danger">
                    <i class="fas fa-minus"></i>
                  </button>
                </form>
              </div>
            </c:forEach>
          </c:if>
        </div>
      </div>
    </div>
  </div>
  <!-- FIM PRODUTOS -->

  <!-- INICIO SUBTOTAL -->
  <div
    style="border:0.5px solid black; padding: 1% 1% ;bottom:0; left :0; position: fixed; margin-bottom: 2%; display: block; width: 250px; border-radius: 0px 5px 5px 0px; background: white;box-shadow: 3px 3px 5px rgba(0, 0, 0, 0.2)!important;"
    class="subtotal">
    <span style="width: 250px;margin-top: 3%; display: inline-block;">
      <i style="color: black; font-size: 40px" class="fas fa-cart-plus"></i>
      <fmt:setLocale value="pt_BR" />
      Subtotal: <fmt:formatNumber value="${carrinho.valorTotal}" type="currency" />
    </span>
    <button
      style="margin-left: 33%; font-size: 14px; padding:5px; color: black; margin-top: 10%!important; bottom: 5%;display: inline-block;"
      class="btn btn btn-success my-2 my-sm-0" type="submit"><a data-toggle="modal"
        data-target="#exampleModal">Finalizar</a></button>
  </div>

  <!-- FIM SUBTOTAL -->
  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
    integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
    crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.10.9/umd/popper.min.js"
    integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
    crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
    integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
    crossorigin="anonymous"></script>

</body>

</html>