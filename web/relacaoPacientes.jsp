<%@ include file="/menu.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CoronApp - Rela��o de Pacientes</title>
</head>
<body>
	<div class="container-principal">
		<h5>
			Relat�rios >> <small>Relat�rio por Sintomas</small>
		</h5>

		<div class="">
			<table class="table">
				<thead>
					<tr>
						<th scope="col">C�digo</th>
						<th scope="col">Nome</th>
						<th scope="col">Data</th>
						<th scope="col">Sexo</th>
						<th scope="col">Latitude</th>
						<th scope="col">Longitude</th>
						<th scope="col">Sintomas</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${relacaoPacientes}" var="paciente">
						<tr>
							<td>${paciente.codigo}</td>
							<td>${paciente.nome}</td>
							<td>${paciente.dataNascimento}</td>
							<td>${paciente.sexo}</td>
							<td>${paciente.latitude}</td>
							<td>${paciente.longitude}</td>
									
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>