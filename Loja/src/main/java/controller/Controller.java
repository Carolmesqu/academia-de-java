package controller;

import java.io.IOException;
import java.util.ArrayList;
//import java.util.Iterator;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO;
import model.JavaBeans;

@WebServlet(urlPatterns = {"/Controller", "/main", "/insert", "/select", "/update", "/delete" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    DAO dao = new DAO();
    JavaBeans produtos = new JavaBeans();

    public Controller() {
        super();
       
    }
    	//metodo principal do servlet
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//teste de conexao
		//dao.testeConexao();
		String action = request.getServletPath();
		System.out.println(action);
		
		if(action.equals("/main")) {
			produtos(request, response);
		
		} else if(action.equals("/insert")) {
			novoProduto(request, response);
		}  else if(action.equals("/select")) {
			listarProduto(request, response);
		} 	else if(action.equals("/update")) {
			editarProduto(request, response);
		}	else if(action.equals("/delete")) {
			removerProduto(request, response);
			}
			else {
			response.sendRedirect("index.html");
	}
	
	}

	//Listar Produtos
	protected void produtos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.sendRedirect("produtos.jsp");
		//Criando um objeto que ira receber os  dados JavaBeans
		ArrayList<JavaBeans> lista = dao.listarProdutos();	
		//Encaminhar a lista ao documento produtos.jsp
		request.setAttribute("produtos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("produtos.jsp");
		rd.forward(request,response);
		
		//teste de recebimento da lista 
		//for (int i = 0; i < lista.size(); i++) {
			//System.out.println(lista.get(i).getCodigo());	
			//System.out.println(lista.get(i).getNome());
			//System.out.println(lista.get(i).getCategoria());
			//System.out.println(lista.get(i).getValor());
			//System.out.println(lista.get(i).getQuantidade());
			
		}
 	
	//Novo Produto
	protected void novoProduto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Teste de recebimento dos dados do formulário
		//System.out.println(request.getParameter("codigo"));
		//System.out.println(request.getParameter("nome"));
		//System.out.println(request.getParameter("categoria"));
		//System.out.println(request.getParameter("valor"));
		//System.out.println(request.getParameter("quantidade"));
		
		//Setar as variaveis JavaBeans
		produtos.setCodigo(Integer.parseInt(request.getParameter("codigo")));
		produtos.setNome(request.getParameter("nome"));
		produtos.setCategoria(request.getParameter("categoria"));
		produtos.setValor(Float.parseFloat(request.getParameter("valor").replaceAll(",", ".")));
		produtos.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
		//Invocar o método inserirProdutos passando o objeto produto
		dao.inserirProdutos(produtos);
		//redirecionador para o documentos produtos.jsp
		response.sendRedirect("main");
		
		
		
	}
	
	//Editar produto
		protected void listarProduto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recebimento do codigo do produto que será editado
		int id = (Integer.parseInt(request.getParameter("id"))); //request.getParameter("id");
		//System.out.println(codigo);
		//setar a variavel JavaBeans
		produtos.setId(id);
		//Executar o metodo selecionar produto
		dao.selecionarProdutos(produtos);
		//teste de recebimento
		//System.out.println(produtos.getCodigo());
		//System.out.println(produtos.getNome());
		//System.out.println(produtos.getCategoria());
		//System.out.println(produtos.getValor());
		//System.out.println(produtos.getQuantidade());
		//setar os atributos do formulario com o conteudo javabeans
		request.setAttribute("id", produtos.getId());
		request.setAttribute("codigo", produtos.getCodigo());
		request.setAttribute("nome", produtos.getNome());
		request.setAttribute("categoria", produtos.getCategoria());
		request.setAttribute("valor", produtos.getValor());
		request.setAttribute("quantedade", produtos.getQuantidade());
		//encaminhar oa docuemnto edita.jsp
		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);
				
	}
		protected void editarProduto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//teste de recebimento
			//System.out.println(request.getParameter("codigo"));
			//System.out.println(request.getParameter("nome"));
			//System.out.println(request.getParameter("categoria"));
			//System.out.println(request.getParameter("valor"));
			//System.out.println(request.getParameter("quantidade"));
			
			//setar as variavais javabeans(vamos armazenar temporariamente na JavaBeans
			produtos.setId(Integer.parseInt(request.getParameter("id")));
			produtos.setCodigo(Integer.parseInt(request.getParameter("codigo")));
			produtos.setNome(request.getParameter("nome"));
			produtos.setCategoria(request.getParameter("categoria"));
			produtos.setValor(Float.parseFloat(request.getParameter("valor")));
			produtos.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
			//executar o metodo alterar contato
			dao.alterarProdutos(produtos);
			//redirecionar o documento produtos.jsp (atualizando as alterações)
			response.sendRedirect("main");
	}
		//remover um produto
		protected void removerProduto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//recebimento do codigo do produto a ser excluido (validado.js)
			int id = (Integer.parseInt(request.getParameter("id"))); //request.getParameter("id");
			//teste
			//System.out.println(codigo);
			//setar a varial codigo JavaBeans
			produtos.setId(id);
			//executar o metodo deletarProdutos (DAO) passando o objeto produtos
			dao.deletarProdutos(produtos);
			//redirecionar o documento produtos.jsp (atualizando as alterações)
			response.sendRedirect("main");
			
		
	}
}
	
	
