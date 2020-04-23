<%@ include file="/menu.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Relatório</title>
<link rel="stylesheet" href="css/bootstrap-4.3.1/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="css/estilo.css">
</head>
<body>
	<div class="container-principal">
		<div class="jumbotron">

			<h5>
				Página Principal >> <small>Relatórios</small>
			</h5>
			<hr>
			<a href="/coronapp/relatorios/pacientes">Listar Pacientes. </a> <br>
			<a href="/coronapp/relatorios/idade">Relatório de pacientes por idade entre 20 a 30 anos. </a> <br> 
			<a href="relatorioidadeesintoma.jsp">Relatório de paciente acima de 60 anos, com Diarréia, Náuseas e Dificuldade de Respirar. </a> <br>
		</div>

		<%@ include file="/footer.jsp"%>
	</div>





</body>
</html>