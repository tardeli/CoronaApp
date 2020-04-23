<%@ include file="/menu.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CoronApp - Relação de Pacientes</title>
<link rel="stylesheet"
	href="../css/bootstrap-4.3.1/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="../css/estilo.css">
</head>
<body>
	<div class="container-principal">
		<h5>
			Relatórios >> <small>Relatório de Pacientes acima de 60 anos, com Náuseas, Febre e Dificuldade de respirar</small>
		</h5>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Cód.</th>
					<th scope="col">Nome</th>
					<th scope="col">Nascimento</th>
					<th scope="col">Sexo</th>
					<th scope="col">Latitude</th>
					<th scope="col">Longitude</th>
					<th scope="col">Sintomas</th>
					
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${relacaoPacientesIdadeSintomas}" var="paciente">
					<tr>
						<td>${paciente.codigo}</td>
						<td>${paciente.nome}</td>
						<td><fmt:formatDate pattern="dd/MM/yyyy" value="${paciente.dataNascimento}" /></td>
						<td>${paciente.sexo}</td>
						<td>${paciente.latitude}</td>
						<td>${paciente.longitude}</td>
						<td>${paciente.sintomas}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<hr>
	<a href="../relatorio.jsp">Voltar</a><br>
	</div>
	
	<%@ include file="/footer.jsp"%>
	<script src="../js/jquery-3.5.0.min.js" type="text/javascript"></script>
	<script src="../css/bootstrap-4.3.1/js/bootstrap.min.js"
		type="text/javascript"></script>

</body>
</html>