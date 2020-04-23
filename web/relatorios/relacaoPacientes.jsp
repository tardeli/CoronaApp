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
			Relatórios >> <small>Relatório de Pacientes</small>
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
					<th scope="col">Mapa</th>
					<th scope="col">Excluir</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${relacaoPacientes}" var="paciente">
					<tr>
						<td>${paciente.codigo}</td>
						<td>${paciente.nome}</td>
						<td><fmt:formatDate pattern="dd/MM/yyyy"
								value="${paciente.dataNascimento}" /></td>
						<td>${paciente.sexo}</td>
						<td>${paciente.latitude}</td>
						<td>${paciente.longitude}</td>
						<td>${paciente.sintomas}</td>
						<td><a
							href="http://google.com/maps/@${paciente.latitude},${paciente.longitude}"
							target="blank_">Visualizar</a></td>
						<td><a
							href="/coronapp/excluirpaciente?codigo=${paciente.codigo}">Excluir</a></td>
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