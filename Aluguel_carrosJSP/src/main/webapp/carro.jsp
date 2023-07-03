<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="DAO.CarroDAO" %>

<%@ page import="MODELO.carros" %>

<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
 <meta charset="utf-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
 
<title> Faça sua Reserva</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light" style="background: linear-gradient(to right, blue, white);">
  <div class="container-fluid">
    
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarScroll" aria-controls="navbarScroll" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarScroll">
      <ul class="navbar-nav me-auto my-2 my-lg-0 navbar-nav-scroll" style="--bs-scroll-height: 100px;">
        <li class="nav-item">
          <a class="nav-link active text-white" aria-current="page" href="index.jsp"><strong>Inicio</strong></a>
        </li>
         
     
        <li class="nav-item" >
      
          <a class="nav-link text-white" href="carroservlet"><strong>Aluguel de carros</strong></a>
        </li>
       
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle text-white" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false"><strong>Contatos</strong></a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
            <li>
              <a class="dropdown-item" href="https://github.com/DevPauloV">
                <span style="display: flex; align-items: center; font-family: 'Verdana', sans-serif;">GitHub <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-github" viewBox="0 0 16 16" style="margin-left: 20px;">
                    <path d="M8 0C3.58 0 0 3.58 0 8c0 3.54 2.29 6.53 5.47 7.59.4.07.55-.17.55-.38 0-.19-.01-.82-.01-1.49-2.01.37-2.53-.49-2.69-.94-.09-.23-.48-.94-.82-1.13-.28-.15-.68-.52-.01-.53.63-.01 1.08.58 1.23.82.72 1.21 1.87.87 2.33.66.07-.52.28-.87.51-1.07-1.78-.2-3.64-.89-3.64-3.95 0-.87.31-1.59.82-2.15-.08-.2-.36-1.02.08-2.12 0 0 .67-.21 2.2.82.64-.18 1.32-.27 2-.27.68 0 1.36.09 2 .27 1.53-1.04 2.2-.82 2.2-.82.44 1.1.16 1.92.08 2.12.51.56.82 1.27.82 2.15 0 3.07-1.87 3.75-3.65 3.95.29.25.54.73.54 1.48 0 1.07-.01 1.93-.01 2.2 0 .21.15.46.55.38A8.012 8.012 0 0 0 16 8c0-4.42-3.58-8-8-8z" />
                  </svg>
                </span>
              </a>
            </li>
            <li>
              <hr class="dropdown-divider">
            </li>
            <li>
              <a  class="text-light dropdown-item" href="#">Another action</a>
            </li>
            <li>
              <hr class="dropdown-divider">
            </li>
            <li>
              <a   class="text-light dropdown-item" href="#">Something else here</a>
            </li>
          </ul>
        </li>
        
        <li class="nav-item">
          <a  class="nav-link text-white" href="aluguelservlet"><strong>Reservas</strong></a>
        </li>
        <li class="nav-item">
          <div class="nav-link text-white">|</div>
        </li>
        <li class="nav-item">
          <% if (session.getAttribute("Clientelogado") != null) { %>
          <input type="hidden" name="login" value="1">
          <button   role="button" class="nav-link text-white"> <strong>Sair</strong> </button>
          <% } else { %>
          <a   class="nav-link text-white" href="login.jsp"> <strong>Entrar</strong></a>
          <% } %>
        </li>
</ul>
           <ul class="nav">
             <li class="nav-item">
               <a class="nav-link" href=".."> <strong>${Clientelogado.getnome()}</strong> </a>
            </li>
      </ul>
    </div>

    
  </div>
</nav>
<!--  -----------------------------------------------------------------------------------------------------------'    -->  
<div class="container">
  <br>
  <br>
  <div class="row">
    <div class="col-md-4">
      <div class="card-body text-dark">
       <br>
       <br>
        <form method="post" action="carroservlet">
          <img class="card-img-top" src="https://th.bing.com/th/id/OIP.DEept2mh4Qh376x4zb_hygHaEo?pid=ImgDet&rs=1" alt="Imagem de capa do card">
          <input type="hidden" name="id_carro" value="1">
        </form>
        <form action="aluguel.jsp?id_carro=1" method="POST">
         <h5 class="card-title">SANTA FÉ</h5>
         <br>

          <div class="row mb-3">
            <div class="col">
              <label for="data_inicio" class="form-label">Data de Retirada</label>
              <input type="date" class="form-control" id="data_inicio" name="data_inicio" required>
            </div>
            <div class="col">
              <label for="data_fim" class="form-label">Data de Devolução</label>
              <input type="date" class="form-control" id="data_fim" name="data_fim" required>
            </div>
          </div>

          <div class="mb-3">
            <label for="quant_dias" class="form-label">Quantidade de Dias</label>
            <input type="text" class="form-control" id="quant_dias" name="quant_dias" readonly>
          </div>
          <div class="d-grid gap-2 col-6 mx-auto">
            <input type="submit" class="btn btn-primary" href="aluguel.jsp?id_carro=1" role="button" value="reservar"/>
          </div>
        </form>
        <br>
      </div>
    </div>

    <div class="col-md-4">
      <div class="card-body text-dark">
      <br>
        <br>
        <br>
        <form method="post" action="carroservlet">
          <img class="card-img-top" src="https://www.automaistv.com.br/wp-content/uploads/2018/07/Hyundai-HB20-1-Million-1.jpg" alt="Imagem de capa do card">
          <input type="hidden" name="id_carro" value="2">
        </form>
        <form action="aluguel.jsp?id_carro=2" method="POST">
         <h5 class="card-title">HB20</h5>
         <br>
          <div class="row mb-3">
            <div class="col">
              <label for="data_inicio" class="form-label">Data de Retirada</label>
              <input type="date" class="form-control" id="data_inicio" name="data_inicio" required>
            </div>
            <div class="col">
              <label for="data_fim" class="form-label">Data de Devolução</label>
              <input type="date" class="form-control" id="data_fim" name="data_fim" required>
            </div>
          </div>

          <div class="mb-3">
            <label for="quant_dias" class="form-label">Quantidade de Dias</label>
            <input type="text" class="form-control" id="quant_dias" name="quant_dias" readonly>
          </div>
          <div class="d-grid gap-2 col-6 mx-auto">
            <input type="submit" class="btn btn-primary" href="aluguel.jsp?id_carro=2" role="button" value="reservar"/>
          </div>
        </form>
        <br>
      </div>
    </div>

    <div class="col-md-4">
      <div class="card-body text-dark">
        
      
        <form method="post" action="carroservlet">
          <img class="card-img-top" src="https://sudamerics.com.ar/wp-content/uploads/2019/10/onix-800x600.jpg" alt="Imagem de capa do card">
          <input type="hidden" name="id_carro" value="3">
        </form>
        <form action="aluguel.jsp?id_carro=3" method="POST">
        <h5 class="card-title">ONIX</h5>
        <br>
          <div class="row mb-3">
            <div class="col">
              <label for="data_inicio" class="form-label">Data de Retirada</label>
              <input type="date" class="form-control" id="data_inicio" name="data_inicio" required>
            </div>
            <div class="col">
              <label for="data_fim" class="form-label">Data de Devolução</label>
              <input type="date" class="form-control" id="data_fim" name="data_fim" required>
            </div>
          </div>

          <div class="mb-3">
            <label for="quant_dias" class="form-label">Quantidade de Dias</label>
            <input type="text" class="form-control" id="quant_dias" name="quant_dias" readonly>
          </div>
          <div class="d-grid gap-2 col-6 mx-auto">
            <input type="submit" class="btn btn-primary" href="aluguel.jsp?id_carro=3" role="button" value="reservar"/>
          </div>
        </form>
        <br>
      </div>
    </div>
  </div>
</div>

<script>
        document.getElementById("data_fim").addEventListener("change", calcularQuantidadeDias);

        function calcularQuantidadeDias() {
            var data_inicio = new Date(document.getElementById("data_inicio").value);
            var data_fim = new Date(document.getElementById("data_fim").value);
            var diffTime = Math.abs(data_inicio - data_fim);
            var diffDays = Math.ceil(diffTime / (1000 * 60 * 60 * 24));
            document.getElementById("quant_dias").value = diffDays;
        }
    </script>


</body>
</html>