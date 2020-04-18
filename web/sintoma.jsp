<%@ include file="/menu.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CoronApp - Cadastro de Sintomas</title>

<script src="js/script.js"></script>
</head>
<body>

	<div class="container-principal">
		<div class="jumbotron">

			<form action="/coronapp/salvarsintoma" method="post">
				<div class="container">
					<h5>
						Cadastro >> <small>Sintomas</small>
					</h5>
					<hr>
					<c:if test="${not empty sessionScope.msg}">
						<h3 style="color: green; text-align: center">${sessionScope.msg}</h3>
						<c:remove var="msg" scope="session" />
					</c:if>
					<div class="form-row">
						<div class="form-group col-md-6">
							<input name="dessin" type="text" class="form-control"
								aria-describedby="emailHelp"
								placeholder="Digite a descrição do sintoma">
						</div>

						<div class="form-group col-md-3">
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