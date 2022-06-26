<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>
<%
@SuppressWarnings("unchecked")
ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("produtos");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Produtos</title>
<link rel="icon" href="imagens/coração.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<div class="box3">
		<h1>Produtos</h1>
		<table>
			<thead>
				<tr>
					<th>Id</th>
					<th>Código</th>
					<th>Descrição</th>
					<th>Categoria</th>
					<th>Valor</th>
					<th>Quantidade</th>
					<th>Opções</th>
				</tr>
			</thead>
			<%
			for (int i = 0; i < lista.size(); i++) {
			%>
			<tr>
				<td><%=lista.get(i).getId()%></td>
				<td><%=lista.get(i).getCodigo()%></td>
				<td><%=lista.get(i).getNome()%></td>
				<td><%=lista.get(i).getCategoria()%></td>
				<td><%=lista.get(i).getValor()%></td>
				<td><%=lista.get(i).getQuantidade()%></td>
				<td><a href="novo.html" class="Botao1">Novo</a> <a
					href="select?id=<%=lista.get(i).getId()%>" class="Botao1">
						Editar</a> <a href="javascript: confirmar(<%=lista.get(i).getId()%>)"
					class="Botao3"> Excluir</a></td>
			</tr>
			<%
			}
			%>
		</table>
		 <a href="index.html" class="Botao1">Voltar</a>
	</div>
	<script src="scripts/confirmador.js"></script>
	<footer>Academia Java Atos ©2022</footer>
</body>
</html>