<!doctype html>
<html lang="pt-br">

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
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


  <title>Início - MeuCarrinho!</title>


  <!-- INICIO DA PAGINA DE ESTILO -->
  <style>
    *:focus {
      box-shadow: none !important;
    }

    body {
      background-color: #c3c3c3;
    }

    input,
    select {
      border: none !important;
      border-bottom: 1px solid #f34747 !important;
      border-radius: 5px 5px 0px 0px !important;
      background-color: #f5eded !important;
    }

    .container-fluid {
      background-color: white;
      width: 100%;
      padding: 2%;
      margin: 2% auto;
      box-shadow: 3px 3px 5px rgba(0, 0, 0, 0.2);
    }

    .container-fluid h2 {
      margin: 3% auto;
    }

    .container-fluid button {
      border-radius: 0;
      width: 100%;
      margin-top: 30px;
    }

    #btnConf:hover {
      background-color: red !important;
    }

    #navbarText {
      width: 100%;
      text-align: center !important;
    }

    @media screen and (max-width: 992px) {
      #navbarText {
        margin-left: 0px !important;
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
  <!-- Fim JS -->

</head>



<body>

  <!-- INICIO MENU TOPO -->

  <nav style="font-family: 'Montserrat Alternates', sans-serif;" class="navbar navbar-expand-lg navbar-dark bg-dark">
    <i style="color: white; font-size: 40px; padding: 1% 2%" class="fas fa-shopping-cart"></i>
    <a class="navbar-brand" href="#">
      <span style="font-size: 28px; color: #f34747; font-weight: bold">MEU</span>carrinho</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText"
      aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div style="margin-left: 15%;" class="collapse navbar-collapse" id="navbarText">
      <ul style="font-size: 18px" class="navbar-nav mr-auto">
        <li class="nav-item">
          <a class="nav-link" href="index.jsp">
            <i class="fas fa-tags"></i>

            Produtos</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="carrinho.jsp">
            <i class="fas fa-shopping-basket"></i>

            Meu carrinho</a>
        </li>
        <li class="nav-item active">
          <a style="color: #f34747;" class="nav-link" href="compra.jsp">
            <i class="fas fa-receipt"></i>

            Compra </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="conta.jsp">
            <i class="fas fa-user-cog"></i>
            Conta</a>
        </li>
        <li class="nav-item">
          <a style="color: black;text-shadow: .5px .5px 4px rgba(255,255,255,0.4);" class="nav-link" href="#">
            <i class="fas fa-sign-out-alt"></i>



            Sair</a>
        </li>
      </ul>
    </div>
  </nav>

  <!-- FIM MENU TOPO -->

  <!-- INICIO FORM COMPRA -->


  <div class="container-fluid col-xs-12 colsm-12 col-md-10 col-lg-4">
    <h2 style="font-family: 'Montserrat Alternates', sans-serif;">
      <i style="margin-right: 5%;" class="fas fa-receipt"></i>Sua compra</h2>
    <form>
      <div class="row">
        <div class="form-group col-lg-6">
          <label for="exampleFormControlInput1">Número do cartão</label>
          <input type="email" class="form-control" id="cartao">
        </div>
        <div class="form-group col-lg-6">
          <label for="exampleFormControlInput1">Validade</label>
          <input type="month" class="form-control" id="exampleFormControlInput1">
        </div>
      </div>
      <div class="row">
        <div class="form-group col-lg-9">
          <label for="exampleFormControlInput1">Nome completo</label>
          <input type="email" class="form-control" id="exampleFormControlInput1">
        </div>
        <div class="form-group col-lg-3">
          <label for="exampleFormControlInput1">CV</label>
          <input type="email" class="form-control" id="cv">
        </div>
      </div>
      <div class="row">
        <div class="form-group col-lg-6">
          <label for="exampleFormControlInput1">Data de nascimento</label>
          <input type="date" class="form-control" id="datanasc">
        </div>
      </div>
      <div class="row">
        <div class="form-group col-lg-7">
          <label for="exampleFormControlInput1">CPF </label>
          <input type="text" class="form-control" id="cpf">
        </div>
        <div class="form-group col-lg-5">
          <label for="exampleFormControlSelect1">Parcelas</label>
          <select class="form-control" id="exampleFormControlSelect1">
            <option>x1 R$ 00,00</option>
            <option>x2 R$ 00,00</option>
            <option>x3 R$ 00,00</option>
            <option>x4 R$ 00,00</option>
            <option>x5 R$ 00,00</option>
          </select>
        </div>
      </div>
    </form>
    <div class="row">
      <div class="form-group col-lg-4">
        <button type="button" class="btn btn-secondary">Voltar</button>
      </div>
      <div class="form-group col-lg-8">
        <button id="btnConf" style="background-color:#f34747; color: white" type="button" class="btn">Confirmar</button>
      </div>
    </div>
  </div>
  </div>
  <!-- FIM FORM COMPRA -->


  <!-- Optional JavaScript -->
  <!-- jQuery first, then Popper.js, then Bootstrap JS -->
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