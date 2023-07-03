<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="DAO.ClienteDAO" %>
<%@ page import="MODELO.clientes" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
	<meta charset="UTF-8">
	<title>Faça seu Login!</title>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
	<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body >

<head>
 <meta charset="utf-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
 
<title>Locadora de Carros</title>

  <style>
    .label-size {
      width: 100px;
    }
  </style>



  
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
 
</head>
<body  >

<nav class="navbar navbar-expand-lg navbar-light" style="background: linear-gradient(to right, blue, white);">
 <br>
  <br>

</nav>
    
    
    
    
    <form action="loginServlet" method="POST">
    
  <br>
  <br>
  <br>
<!--  ----------------------------------------------------------------------------------------------------------------------- -->
  
 <div class="row justify-content-md-center">
    <div class="col-md-4 mb-3">
      <label class="form-label label-size">Email</label>
        <input type="email" class="form-control ${erro}" id="email" placeholder="Email" aria-describedby="inputGroupPrepend3" name="email" required>
      </div>
    </div>

  <!--=============================================================================================================== -->
  <div class="row justify-content-md-center">  
    <div class="col-md-4 mb-3">
      <label class="form-label label-size">Senha</label>
     
        <input type="password" class="form-control ${erro}" id="senha" placeholder="Senha" name="senha" required>
      </div>
    </div>
  
   <input type="hidden" name="login" value="0">
  
    <div class="container-fliud mb-3" align="center">                      
    <button type="submit"  id="btn-login"  class="btn btn-primary text-light mb-2 mt-3">Entrar</button> 
  </div>
</form>
  
  
  
  
  </body>
</html>