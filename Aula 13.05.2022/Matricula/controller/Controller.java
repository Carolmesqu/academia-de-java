package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO;
import model.JavaBeans;

@WebServlet(urlPatterns = {"/home", "/create", "/insert", "/read"})
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//objeto de acesso ao banco de dados
	DAO dao = new DAO();
	//objeto para armazenar dados temporariamente
	JavaBeans aluno = new JavaBeans();
	
    public Controller() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		if(action.equals("/home")) {
			response.sendRedirect("index.html");
		}else if(action.equals("/create")) {
			response.sendRedirect("cadastro.html");
		}else if (action.equals("/insert")){
			adicionarAlunos(request, response);
		}
	}

	private void adicionarAlunos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Nome:" + request.getParameter("nome"));
		aluno.setId(request.getParameter("id"));
		aluno.setNome(request.getParameter("nome"));
		aluno.setEmail(request.getParameter("email"));
		aluno.setFone(request.getParameter("fone"));
		dao.inserirAluno(aluno);
		response.sendRedirect("index.html");
	}

}

//<img alt="" src="Imagens/exemplo.png"> no index abaixo de home page
