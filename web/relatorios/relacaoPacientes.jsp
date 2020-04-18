<%@ include file="/menu.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CoronApp - Relação de Pacientes</title>
</head>
<body>
	<span style="font-weight: bold; font-size: 20px; padding: 10px">Relação de Pacientes</span>
	<table border="1">
		<tr>
			<th>Código</th>
			<th>Nome</th>
			<th>Data de Nascimento</th>
			<th>Sexo</th>
			<th>Latitude</th>
			<th>Longitude</th>
			<th>Sintomas</th>
		</tr>
		<c:forEach items="${relacaoPacientes}" var="paciente">
			<tr>
				<td>${paciente.codigo}</td>
				<td>${paciente.nome}</td>
				<td>${paciente.dataNascimento}</td>
				<td>${paciente.sexo}</td>
				<td>${paciente.latitude}</td>
				<td>${paciente.longitude}</td>
				<td>${paciente.sintomas}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>