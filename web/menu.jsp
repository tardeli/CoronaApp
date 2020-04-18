<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap-4.3.1/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="css/estilo.css">


</head>

<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavDropdown">
    <ul class="navbar-nav">
      <li class="nav-item dropdown">
        <a class="navbar-brand dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Cadastros
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
          <a class="dropdown-item" href="/coronapp/paciente">Paciente</a>
          <a class="dropdown-item" href="#">Sintomas</a>
        </div>
      </li>
      <li class="nav-item dropdown">
        <a class="navbar-brand dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Relatórios
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
          <a class="dropdown-item" href="#">Por idade</a>
          <a class="dropdown-item" href="#">Por Sintomas</a>
        </div>
      </li>
      <li class="nav-item">
        <a class="navbar-brand" href="/coronapp/sobre.jsp">Sobre</a>
      </li>
      <li class="nav-item">
        <a class="navbar-brand" href="/coronapp/sair">Sair</a>
        <span class="usuariologado">Login: ${email} </span>
      </li>
    </ul>
  </div>
</nav>
<script src="js/jquery-3.5.0.min.js" type="text/javascript"></script>
<script src="css/bootstrap-4.3.1/js/bootstrap.min.js" type="text/javascript"></script>

</body>
</html>