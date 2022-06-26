<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Editar</title>
<link rel="icon" href="imagens/coração.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<div class="box3">
		<h1>Editar Produto:</h1>

		<form name="frmNovo" action="update">
			<table>
				<tr>
					<td>Id</td>
					<td><input type="number" name="id" class="Caixa1" readonly
						value="<%out.print(request.getAttribute("id"));%>"></td>
				</tr>

				<tr>
					<td>Código</td>
					<td><input type="number" name="codigo" class="Caixa1"
						value="<%out.print(request.getAttribute("codigo"));%>"></td>
				</tr>

				<tr>
					<td>Nome</td>
					<td><input type="text" name="nome" class="Caixa1"
						value="<%out.print(request.getAttribute("nome"));%>"></td>
				</tr>

				<tr>
					<td>Categoria</td>
					<td><input type="text" name="categoria" class="Caixa1"
						value="<%out.print(request.getAttribute("categoria"));%>"></td>
				</tr>

				<tr>
					<td>Valor</td>
					<td><input type="number" name="valor" class="Caixa1"
						value="<%out.print(request.getAttribute("valor"));%>"></td>
				</tr>

				<tr>
					<td>Quantidade</td>
					<td><input type="number" name="quantidade" class="Caixa1"
						value="<%out.print(request.getAttribute("quantidade"));%>"></td>
				</tr>
			</table>
			<br> <input type="button" value="Salvar" class="Botao1"
				onclick="validar()"> <a href="index.html" class="Botao1">Voltar</a>
			<script>
				function funcao() {
					alert("É obrigatório informar valor para os campos: \n ✩ Código (Número inteiro) \n✩ Nome \n ✩ Valor (Número inteiro ou decimal) \n ✩ Quantidade(Número inteiro).")
				}
			</script>
			<input type="button" onclick="funcao()" value="Informações"
				class="Botao1" />
		</form>
		<script src="scripts/validador.js"></script>
	</div>
</body>
<footer>Academia Java Atos ©2022</footer>
</html>