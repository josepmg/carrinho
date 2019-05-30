<!doctype html>
<html lang="pt-br">

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css"
    integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
  <link href="https://fonts.googleapis.com/css?family=Montserrat+Alternates&display=swap" rel="stylesheet">
  <script type="text/javascript" src="js/bootstrap.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.11/jquery.mask.min.js"></script>



  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="css/bootstrap.min.css">


  <!-- INICIO PAGINA DE ESTILO -->
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
      background-color: #c3c3c3;
      width: 100%;
      padding: 2%;
      box-shadow: 3px 3px 5px rgba(0, 0, 0, 0.2);
    }

    #navbarText {
      width: 100%;
      text-align: center !important;
    }

    #btnConf:hover {
      background-color: red !important;
    }

    .container-fluid h2 {
      margin: 3% auto;
    }

    .container-fluid button {
      border-radius: 0;
      width: 100%;
      margin-top: 30px;
      border: none;
    }

    @media screen and(max-width: 992px) {
      #navbarText {
        margin-left: 0px !important;
      }
    }
  </style>

  <!-- FIM PAGINA DE ESTILO -->

  <!-- JS -->

  <script type="text/javascript">
    $("#celular").mask("(00) 00000-0000");
  </script>

  <!-- JS -->

  <link rel="stylesheet" type="text/css" href="css/style.css">

  <title>Minha conta - MeuCarrinho!</title>
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
    <div style="margin-left: 15%;" class="collapse navbar-collapse" id="navbarText">
      <ul style="font-size: 18px!important" class="navbar-nav mr-auto">
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
        <li class="nav-item">
          <a class="nav-link" href="compra.jsp">
            <i class="fas fa-receipt"></i>

            Compra </a>
        </li>
        <li class="nav-item active">
          <a style="color: #f34747;" class="nav-link" href="conta.jsp">
            <i class="fas fa-user-cog"></i>
            Conta</a>
        </li>
        <li class="nav-item">
          <a style="color: black; text-shadow: .5px .5px 4px rgba(255,255,255,0.4);" class="nav-link" href="#">
            <i class="fas fa-sign-out-alt"></i>



            Sair</a>
        </li>
      </ul>
    </div>
  </nav>

  <!-- FIM MENU -->

  <!-- INICIO FORM CONTA -->

  <div class="container-fluid col-xs-12 colsm-12 col-md-12 col-lg-12">
    <div class="row">
      <div style="background:white;border: 1px solid rgba(0,0,0,0.2);box-shadow: 3px 3px 5px rgba(0, 0, 0, 0.2);"
        class="esquerda offset-lg-2 col-lg-4">
        <h2 style="font-family: 'Montserrat Alternates', sans-serif;">
          <i style="margin-right: 5%;" class="fas fa-user-cog"></i>Sua conta</h2>
        <form>
          <div class="row">
            <div class="form-group col-lg-12">
              <label for="exampleFormControlInput1">Nome completo</label>
              <input type="text" class="form-control" id="exampleFormControlInput1">
            </div>
            <div class="form-group col-lg-12">
              <label for="exampleFormControlInput1">E-mail</label>
              <input type="email" class="form-control" id="Example">
            </div>

          </div>
          <div class="row">
            <div class="form-group col-lg-6">
              <label for="exampleFormControlInput1">Celular</label>
              <input type="telefone" class="form-control" id="celular">
            </div>
            <div class="form-group col-lg-6">
              <label for="exampleFormControlInput1">Senha</label>
              <input type="password" class="form-control" id="Example">
            </div>
          </div>
          <div class="row">
            <div class="form-group col-lg-6">
              <label for="exampleFormControlInput1">Nova Senha</label>
              <input type="password" class="form-control" id="Example" ">
            </div>
            <div class=" form-group col-lg-6">
              <label for="exampleFormControlInput1">Confirme a nova senha </label>
              <input type="password" class="form-control" id="Example">
            </div>
          </div>
        </form>
        <div class="row">
          <div class="form-group col-lg-4">
            <button type="button" class="btn btn-secondary">Voltar</button>
          </div>
          <div class="form-group col-lg-8">
            <button id="btnConf" style="background-color:#f34747;" type="button" class="btn btn-success">Enviar</button>
          </div>
        </div>
      </div>

      <!-- FIM FORM CONTA -->

      <!-- INICIO HISTÓRICO COMPRAS -->
      <div style="background:white;border: 1px solid rgba(0,0,0,0.2);box-shadow: 3px 3px 5px rgba(0, 0, 0, 0.2);"
        class="direita offset-lg-1 col-lg-3">
        <h2 style="font-family: 'Montserrat Alternates', sans-serif;padding-top:5%;" class="text-center">
          <i style="margin-left: 5%;" class="fa fa-history" aria-hidden="true"></i>
          Histórico de compras</h2>
        <div style="font-size: 15px;margin-bottom: 15px;;border-bottom: 1px solid #f34747" class="history">

          <i style="color:green;" class="fa fa-check" aria-hidden="true"></i>
          <a style="cursor: pointer; color:blue;">Nº pedido</a> | Nome do usuário | Valor compra: R$ 00,00
        </div>
        <div style="font-size: 15px;margin-bottom: 15px;;border-bottom: 1px solid #f34747" class="history">

          <i style="color:green;" class="fa fa-check" aria-hidden="true"></i>
          <a style="cursor: pointer; color:blue;">Nº pedido</a> | Nome do usuário | Valor compra: R$ 00,00
        </div>
        <div style="font-size: 15px;margin-bottom: 15px;;border-bottom: 1px solid #f34747" class="history">

          <i style="color:green;" class="fa fa-check" aria-hidden="true"></i>
          <a style="cursor: pointer; color:blue;">Nº pedido</a> | Nome do usuário | Valor compra: R$ 00,00
        </div>
        <div style="font-size: 15px;margin-bottom: 15px;;border-bottom: 1px solid #f34747" class="history">

          <i style="color:green;" class="fa fa-check" aria-hidden="true"></i>
          <a style="cursor: pointer; color:blue;">Nº pedido</a> | Nome do usuário | Valor compra: R$ 00,00
        </div>
        <div style="font-size: 15px;margin-bottom: 15px;;border-bottom: 1px solid #f34747" class="history">

          <i style="color:green;" class="fa fa-check" aria-hidden="true"></i>
          <a style="cursor: pointer; color:blue;">Nº pedido</a> | Nome do usuário | Valor compra: R$ 00,00
        </div>
        <div style="font-size: 15px;margin-bottom: 15px;;border-bottom: 1px solid #f34747" class="history">

          <i style="color:green;" class="fa fa-check" aria-hidden="true"></i>
          <a style="cursor: pointer; color:blue;">Nº pedido</a> | Nome do usuário | Valor compra: R$ 00,00
        </div>
        <div style="font-size: 15px;margin-bottom: 15px;;border-bottom: 1px solid #f34747" class="history">

          <i style="color:green;" class="fa fa-check" aria-hidden="true"></i>
          <a style="cursor: pointer; color:blue;">Nº pedido</a> | Nome do usuário | Valor compra: R$ 00,00
        </div>
        <div style="font-size: 15px;margin-bottom: 15px;;border-bottom: 1px solid #f34747" class="history">

          <i style="color:green;" class="fa fa-check" aria-hidden="true"></i>
          <a style="cursor: pointer; color:blue;">Nº pedido</a> | Nome do usuário | Valor compra: R$ 00,00
        </div>
      </div>
      <!-- FIM HISTÓRICO COMPRAS -->
    </div>
  </div>
  </div>




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