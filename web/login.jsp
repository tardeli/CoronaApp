<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CoronApp - Login</title>
<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

html {
	height: 100%;
}

body {
	font-family: 'Segoe UI', sans-serif;;
	font-size: 1rem;
	line-height: 1.6;
	height: 100%;
}

.wrap {
	width: 100%;
	height: 100%;
	display: flex;
	justify-content: center;
	align-items: center;
	background: #fafafa;
}

.login-form {
	width: 350px;
	margin: 0 auto;
	border: 1px solid #ddd;
	padding: 2rem;
	background: #ffffff;
}

.form-input {
	background: #fafafa;
	border: 1px solid #eeeeee;
	padding: 12px;
	width: 100%;
}

.form-group {
	margin-bottom: 1rem;
}

.form-button {
	background: #69d2e7;
	border: 1px solid #ddd;
	color: #ffffff;
	padding: 10px;
	width: 100%;
	text-transform: uppercase;
}

.form-button:hover {
	background: #69c8e7;
}

.form-header {
	text-align: center;
	margin-bottom: 2rem;
}

.form-footer {
	text-align: center;
}
</style>
</head>
<body>
	<div class="wrap">
		<form class="login-form" action="/coronapp/autenticacao" method="post">
			<div class="form-header">
				<h3>CoronApp - Login</h3>
				<p>Faça login para o Menu Principal</p>
			</div>
			<!-- E-mail -->
			<div class="form-group">
				<input type="text" name="email" class="form-input"
					placeholder="email@exemplo.com" required="required">
			</div>
			<!-- Senha -->
			<div class="form-group">
				<input type="password" name="senha" class="form-input"
					placeholder="senha" required="required">
			</div>
			<!-- BotÃ£o de login -->
			<div class="form-group">
				<button class="form-button" type="submit">Login</button>
			</div>
		</form>
	</div>
	<!--/.wrap-->
</body>
</html>