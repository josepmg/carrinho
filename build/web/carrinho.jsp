<!doctype html>
<html lang="pt-br">

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css"
    integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
  <link href="https://fonts.googleapis.com/css?family=Montserrat+Alternates&display=swap" rel="stylesheet">

  <style>
    body {
      background-color: #c3c3c3 !important;
    }

    .container {
      background-color: #c3c3c3 !important;
    }
  </style>


  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="css/bootstrap.min.css">


  <link rel="stylesheet" type="text/css" href="css/style.css">

  <title>Meu carrinho - MeuCarrinho!</title>

  <!-- INICIO PAGINA DE ESTILO -->

  <style>
    @media screen and (max-width:600px) {
      .fundoProdutos {
        width: 100% !important;
        padding: 0;
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

    @media screen and (max-width:768px) {
      .fundoProdutos {
        width: 100% !important;
        padding: 0;
      }

      .box {
        margin-bottom: 5% !important;
        justify-content: center !important;
      }
    }

    @media screen and (max-width:992px) {
      .container {
        width: 100%;
      }

      .fundoHome {
        width: 100% !important;
      }

      .fundoProdutos {
        width: 100% !important;
        padding: 0;
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
    }
  </style>

  <!-- FIM PAGINA DE ESTILO -->

</head>

<body>

  <!-- INICIO MENU -->

  <nav style="font-family: 'Montserrat Alternates', sans-serif;" class="navbar navbar-expand-lg navbar-dark bg-dark">
    <i style="color: white; font-size: 40px; padding: 1% 2%" class="fas fa-shopping-cart"></i>
    <a class="navbar-brand" href="#">
      <span style="font-size: 28px; color: #f34747; font-weight: bold">MEU</span>carrinho</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText"
      aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div style="margin-left: 15%; justify-content: center;" class="collapse navbar-collapse" id="navbarText">
      <ul style="font-size: 18px" class="navbar-nav mr-auto">
        <li class="nav-item">
          <a class="nav-link" href="index.jsp">
            <i class="fas fa-tags"></i>

            Produtos</a>
        </li>
        <li class="nav-item active">
          <a style="color: #f34747;" class="nav-link" href="carrinho.jsp">
            <i class="fas fa-shopping-basket"></i>

            Meu carrinho</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="compra.jsp">
            <i class="fas fa-receipt"></i>

            Compra </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="conta.jsp">
            <i class="fas fa-user-cog"></i>
            Conta</a>
        </li>
        <li class="nav-item">
          <a style="color: black;" class="nav-link" href="#">
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

  <div style="padding:0!important; " class="container">
    <div class="fundoHome">
      <div
        style="width:100%; height: 100vh; background-color: white; padding-top: 1%;margin-top: 5%!important; padding-bottom: 5%;z"
        class="fundoProdutos">
        <h2 style="font-family: 'Montserrat Alternates', sans-serif; padding-top: 2%; margin-left: 15%;">
          <i class="fas fa-shopping-basket"></i>
          Meu Carrinho</h2>
        <div style="margin-top: 4%;" class="row justify-content-md-center">

          <!-- PRODUTO -->

          <div style="border: 1px solid black; height: 150px; margin-left: 5px; background-color: white;"
            class="col-xs-10 col-sm-5 col-md-4 col-lg-2 box">
            Produto 1 - x quantd.
            <button style="bottom: 5px; right: 5px; float: right; position: absolute;" type="button"
              class="btn btn-danger">
              <i class="fas fa-minus"></i>

            </button>
          </div>

          <!-- PRODUTO -->

          <div style="border: 1px solid black;width:300px; height: 150px; margin-left: 5px; background-color: white;"
            class="col-xs-10 col-sm-6 col-sm-6 col-md-4 col-lg-2 box">
            Produto 2 - x quantd.
            <button style="bottom: 5px; right: 5px; float: right; position: absolute;" type="button"
              class="btn btn-danger">
              <i class="fas fa-minus"></i>

            </button>
          </div>

          <!-- PRODUTO -->

          <div style="border: 1px solid black;width:300px; height: 150px; margin-left: 5px; background-color: white;"
            class="col-xs-10 col-sm-6 col-sm-6 col-md-4 col-lg-2 box">
            Produto 3 - x quantd.
            <button style="bottom: 5px; right: 5px; float: right; position: absolute;" type="button"
              class="btn btn-danger">
              <i class="fas fa-minus"></i>

            </button>
          </div>

          <!-- PRODUTO -->

          <div style="border: 1px solid black;width:300px; height: 150px; margin-left: 5px; background-color: white;"
            class="col-xs-10 col-sm-6 col-sm-6 col-md-4 col-lg-2 box">
            Produto 4 - x quantd.
            <button style="bottom: 5px; right: 5px; float: right; position: absolute;" type="button"
              class="btn btn-danger">
              <i class="fas fa-minus"></i>

            </button>
          </div>
        </div>

        <!-- PRODUTO -->

        <div style="margin-top: 1%;" class="row justify-content-md-center">
          <div style="border: 1px solid black;width:300px; height: 150px; margin-left: 5px; background-color: white;"
            class="col-xs-10 col-sm-6 col-sm-6 col-md-4 col-lg-2 box">
            Produto 5 - x quantd.
            <button style="bottom: 5px; right: 5px; float: right; position: absolute;" type="button"
              class="btn btn-danger">
              <i class="fas fa-minus"></i>

            </button>
          </div>

          <!-- PRODUTO -->

          <div style="border: 1px solid black;width:300px; height: 150px;margin-left: 5px; background-color: white;"
            class="col-xs-10 col-sm-6 col-sm-6 col-md-4 col-lg-2 box">
            Produto 6 - x quantd.
            <button style="bottom: 5px; right: 5px; float: right; position: absolute;" type="button"
              class="btn btn-danger">
              <i class="fas fa-minus"></i>

            </button>
          </div>

          <!-- PRODUTO -->

          <div style="border: 1px solid black;width:300px; height: 150px;margin-left: 5px; background-color: white;"
            class="col-xs-10 col-sm-6col-sm-6 col-md-4 col-lg-2 box">
            Produto 7 - x quantd.
            <button style="bottom: 5px; right: 5px; float: right; position: absolute;" type="button"
              class="btn btn-danger">
              <i class="fas fa-minus"></i>

            </button>
          </div>

          <!-- PRODUTO -->

          <div style="border: 1px solid black;width:300px; height: 150px;margin-left: 5px; background-color: white;"
            class=" col-xs-10 col-sm-6 col-sm-6 col-md-4 col-lg-2 box">
            Produto 8 - x quantd.
            <button style="bottom: 5px; right: 5px; float: right; position: absolute;" type="button"
              class="btn btn-danger">
              <i class="fas fa-minus"></i>

            </button>
          </div>
        </div>

        <!-- PRODUTO -->

        <div style="margin-top: 1%; " class="row justify-content-md-center">
          <div style="border: 1px solid black;width:300px; height: 150px; margin-left: 5px; background-color: white;"
            class="col-sm-6 col-md-4 col-lg-2 box">
            Produto 9 - x quantd.
            <button style="bottom: 5px; right: 5px; float: right; position: absolute;" type="button"
              class="btn btn-danger">
              <i class="fas fa-minus"></i>

            </button>
          </div>

          <!-- PRODUTO -->

          <div style="border: 1px solid black;width:300px; height: 150px; margin-left: 5px; background-color: white;"
            class="col-xs-10 col-sm-6 col-sm-6 col-md-4 col-lg-2 box">
            Produto 10 - x quantd.
            <button style="bottom: 5px; right: 5px; float: right; position: absolute;" type="button"
              class="btn btn-danger">
              <i class="fas fa-minus"></i>

            </button>
          </div>

          <!-- PRODUTO -->

          <div style="border: 1px solid black;width:300px; height: 150px; margin-left: 5px; background-color: white;"
            class="col-xs-10 col-sm-6 col-sm-6 col-md-4 col-lg-2 box">
            Produto 11 - x quantd.
            <button style="bottom: 5px; right: 5px; float: right; position: absolute;" type="button"
              class="btn btn-danger">
              <i class="fas fa-minus"></i>

            </button>
          </div>

          <!-- PRODUTO -->

          <div style="border: 1px solid black;width:300px; height: 150px; margin-left: 5px; background-color: white;"
            class="col-xs-10 col-sm-6 col-sm-6 col-md-4 col-lg-2 box">
            Produto 10 - x quantd.
            <button style="bottom: 5px; right: 5px; float: right; position: absolute;" type="button"
              class="btn btn-danger">
              <i class="fas fa-minus"></i>

            </button>
          </div>
        </div>
      </div>
    </div>
  </div>

  <!-- FIM PRODUTOS -->

  <!-- INICIO SUBTOTAL -->

  <div
    style="border:0.5px solid black; padding: 1% 1% ;bottom:0; position: fixed; margin-bottom: 2%; display: block; width: 250px; border-radius: 0px 5px 5px 0px; background: white;"
    class="subtotal">
    <span style="width: 250px;margin-top: 3%; display: inline-block;">
      <i style="color: black; font-size: 40px" class="fas fa-cart-plus"></i>Subtotal: R$ xx,xx
    </span>
    <button
      style="float: right; font-size: 14px; padding:5px; color: black; margin-top: 10%!important; bottom: 5%;display: inline-block;"
      class="btn btn btn-success my-2 my-sm-0" type="submit">Finalizar</button>
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