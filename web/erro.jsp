<html>
<head>

<link rel="stylesheet" href="css/bootstrap-4.3.1/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="css/estilo.css">
</head>
<body>
	<div class="container-principal">
		<div class="jumbotron">
			<div class="row">
				<div class="col-md-12">
					<div class="error-template">
						<h1>Oops!</h1>
						<h4>${erro}</h4>
						<div class="error-actions">
							<a href="#" onclick="javascript:history.back();"
								class="btn btn-primary btn-lg"><span
								class="glyphicon glyphicon-home"></span> Voltar </a><a href="#"
								class="btn btn-default btn-lg"><span
								class="glyphicon glyphicon-envelope"></span> Contact Support </a>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="/footer.jsp"%>
</body>
</html>