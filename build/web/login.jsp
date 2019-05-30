<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

    <!-- INICIO PAGINA DE ESTILO -->

    <style>
        *:focus {
            box-shadow: none !important;
        }

        body,
        html {
            background-color: #f34747;
            padding: 0;
            margin: 0;
        }

        input,
        select {
            border: none !important;
            border-bottom: 1px solid black !important;
            border-radius: 0 !important;
            box-shadow: 3px 3px 15px rgba(0, 0, 0, 0.2);
        }

        .container-fluid {
            width: 100%;
            background-color: white;
        }

        .esquerda,
        .direita {
            width: 100%;
            height: 100vh;
            margin: auto auto;
        }

        .esquerda h2,
        .direita h2 {
            color: white;
            padding-top: 10%;
            margin-bottom: 3%;
        }

        .esquerda {
            background-color: #282725;
        }

        .direita {
            background-color: #f34747;
        }

        .btnlogin {
            margin-top: 5% !important;
            width: 50%;
            background-color: #f34747;
            margin: auto;
        }

        label {
            color: white;
        }

        button {
            border: none !important;
            width: 200px !important;
        }

        #entrar:hover {
            background-color: #f34747 !important;
        }

        #cadastrar:hover {
            background-color: #282725 !important;
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

    <!-- JS -->

</head>

<body>

    <!-- INICIO TOPO -->
    <nav style="font-family: 'Montserrat Alternates', sans-serif; padding-left: 40%;"
        class="navbar navbar-expand-lg navbar-dark bg-dark">
        <i style="color: white; font-size: 40px; padding: 1% 2%" class="fas fa-shopping-cart text-center"></i>
        <a class="navbar-brand" href="#">
            <span style="font-size: 28px; color: #f34747; font-weight: bold">MEU</span>carrinho</a>
    </nav>

    <!-- FIM TOPO -->

    <!-- INICIO FORM LOGIN -->

    <div class="container-fluid col-xs-12 colsm-12 col-md-12 col-lg-12">
        <div class="row">
            <div class="esquerda col-lg-6">
                <h2 class="text-center">Login</h2>
                <form>
                    <div style="margin: auto;" class="row col-lg-6">
                        <div class="form-group col-lg-12">
                            <label for="exampleFormControlInput1">E-mail</label>
                            <input style="border-bottom: 1px solid #f34747!important;" type="email" class="form-control"
                                id="exampleFormControlInput1" placeholder="E-mail de login">
                        </div>
                        <div class="form-group col-lg-12">
                            <label for="exampleFormControlInput1">Senha</label>
                            <input style="border-bottom: 1px solid #f34747!important;" type="password"
                                class="form-control" id="Example" placeholder="Senha">
                            <a style="color: #f34747; cursor: pointer">Esqueceu a senha?</a>
                        </div>
                        <button id="entrar" style="            background:#282725;
                        border: 1px solid white!important;" type="button"
                            class="btn btn-primary btnlogin">Entrar</button>
                    </div>
                </form>
            </div>

            <!-- FIM FORM LOGIN -->

            <!-- INICIO FORM CADASTRO -->

            <div class="direita col-lg-6">
                <h2 style="padding-top:10%;" class="text-center">Cadastre-se</h2>
                <form>
                    <div style="margin: auto;" class="row col-lg-10">
                        <div class="form-group col-lg-6">
                            <label for="exampleFormControlInput1">Nome</label>
                            <input type="text" class="form-control" id="exampleFormControlInput1" placeholder="Nome">
                        </div>
                        <div class="form-group col-lg-6">
                            <label for="exampleFormControlInput1">Sobrenome</label>
                            <input type="text" class="form-control" id="exampleFormControlInput1"
                                placeholder="Sobrenome">
                        </div>
                        <div class="form-group col-lg-6">
                            <label for="exampleFormControlInput1">E-mail</label>
                            <input type="password" class="form-control" id="Example" placeholder="E-mail">
                        </div>
                        <div class="form-group col-lg-6">
                            <label for="exampleFormControlInput1">Data de Nascimento</label>
                            <input type="date" class="form-control" id="Example" placeholder="Data">
                        </div>
                        <div class="form-group col-lg-6">
                            <label for="exampleFormControlInput1">Senha</label>
                            <input type="password" class="form-control" id="Example" placeholder="Senha">
                        </div>
                        <div class="form-group col-lg-6 ">
                            <label for="exampleFormControlInput1">Confirma Senha</label>
                            <input type="password" class="form-control" id="Example" placeholder="Confirme a senha">
                        </div>
                        <button id="cadastrar" style="border: 1px solid white!important;" type="button"
                            class="btn btn-primary btnlogin">Cadastrar</button>
                    </div>
                </form>
            </div>

            <!-- FIM FORM CADASTRO -->

        </div>
    </div>

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