<%@ include file="/menu.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CoronApp - Cadastro de Pacientes</title>

<script src="js/script.js"></script>
</head>
<body>

	<div class="container-principal">
		<div class="jumbotron">

			<form action="/coronapp/salvarpaciente" method="post">
				<div class="container">
					<h5>
						Cadastro >> <small>Paciente</small>
					</h5>
					<hr>
					<c:if test="${not empty sessionScope.msg}">
						<h3 style="color: green; text-align: center">${sessionScope.msg}</h3>
						<c:remove var="msg" scope="session" />
					</c:if>

					<div class="form-row">
						<div class="form-group col-md-6">
							<input name="nome" type="text" class="form-control"
								aria-describedby="emailHelp" placeholder="Digite seu nome">
						</div>

						<div class="form-group col-md-3">
							<input name="dataNascimento" type="date" class="form-control"
								aria-describedby="emailHelp">
						</div>

						<div class="col-md-3">
							Sexo: <label class="radio-inline" for="radios-0"> <input
								name="sexo" value="feminino" type="radio" required /> Feminino
							</label> <label class="radio-inline" for="radios-1"> <input
								name="sexo" value="masculino" type="radio" /> Masculino
							</label>
						</div>

					</div>

					<div class="form-row">
						<div class="form-group col-md-3">
							<input id="latitude" name="latitude" type="number"
								class="form-control" aria-describedby="latitude"
								placeholder="Latitude" step="0.00000001">

						</div>
						<div class="form-group col-md-3">
							<input id="longitude" name="longitude" type="number"
								class="form-control" aria-describedby="longitude"
								placeholder="Longitude" step="0.00000001">

						</div>
						<div class="form-group col-md-3">
							<button class="btn btn-primary" name="capturar"
								onclick="javascript: showPosition(); return false;">Capturar</button>
						</div>

					</div>

					<div class="form-row">
						Selecione os sintomas: <select class="form-control"
							name="sintomas" multiple="multiple" required="required">
							<c:forEach items="${listaSintomas}" var="sintoma">
								<option value="${sintoma.codigo}">${sintoma.descricao}</option>
							</c:forEach>
						</select>
					</div><hr>

					<div class="form-row">
						<div class="form-group">
							<button class="btn btn-primary" type="Submit">Salvar</button>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
	<%@ include file="/footer.jsp"%>
</body>
</html>