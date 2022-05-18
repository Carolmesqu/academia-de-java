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
		//String queryBD = "SELECT * FROM autor";
		String queryBDI = "INSERT INTO autor (nacionalidade, nome) values ('Brasileiro', 'Ziraldo')";
		//String queryBDI = "DELETE FROM autor WHERE ID=1";
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
		resultado = st.executeQuery(queryBD);
		
		if (resultado != null)
			while (resultado.next()) {
			  System.out.println("ID: " + resultado.getString("ID") + "\t nome: " + resultado.getString("nome"));
			}
		
		//System.out.println(st.execute("INSERT INTO autor (nacionalidade, nome) values ('Brasileiro', 'Ziraldo');"
		
		//Inserir, alterar e excluir 
		System.out.println(st.execute(queryBDI));
		
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("SQL Exception");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Class not found");
		}
		
	}
}