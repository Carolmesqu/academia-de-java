import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class Principal {

	public static void main(String[] args) {
	
		Connection conexao;	
		String driver = "com.mysql.cj.jdbc.Driver";
		String UrlBD =  "jdbc:mysql://localhost:3306/biblioteca1?user=root&password=";
		//consulta por ordem alfabetica
		String queryBD = "select * from livro select livro.isbn as 'ISBN', livro.titulo as 'Título', livro.ano as 'Ano', editora.nome as 'Editora', "
				+ "	categoria.tipo_categoria as 'Categoria' from livro, editora, categoria where livro.fk_editora = editora.id 	and livro.fk_categoria = categoria.id"
				+ "	order by livro.titulo";
		
		//("ISBN: " + resultado.getString("titulo"));
		//String queryBDI = "INSERT INTO livroautor (fk_livro, fk_autor) values('8532512062',6);";
		//String queryBDI = "DELETE FROM autor WHERE ID=4";
		// || = ou && e 
		//String queryBDI = "DELETE FROM pessoa WHERE ID=" +5;
		//String id=4;
		
				
		Statement st;
		ResultSet resultado;		
		
		try {
		Class.forName(driver);
		conexao = (Connection) DriverManager.getConnection(UrlBD);
		System.out.println("Conectado");
		//cria as variaveis para busca no banco de dados
		
		//busca banco de dados
		st = conexao.createStatement();
		//System.out.println(st.execute(queryBDI));
		resultado = st.executeQuery(queryBD);
		
		
		
		//resultado = st.executeQuery(queryBD);
		if (resultado != null)
			while (resultado.next()) {
			  System.out.println("Titulo: " + resultado.getString("titulo"));
			}
		
		//System.out.println(st.execute("INSERT INTO autor (nacionalidade, nome) values ('Brasileiro', 'Ziraldo');"
		
		//Inserir, alterar e excluir

		
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("SQL Exception");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Class not found");
		}
		
	}
}
