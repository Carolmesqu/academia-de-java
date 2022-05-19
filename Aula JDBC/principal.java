import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
//import com.mysql.cj.xdevapi.Statement;
//import java.sql.SQLClientInfoException;

public class principal {

	public static void main(String[] args) {
	
		Connection conexao;	
		String driver = "com.mysql.cj.jdbc.Driver";
		String UrlBD =  "jdbc:mysql://localhost:3306/reuniao?user=root&password=";
		String queryBD = "SELECT * FROM pessoa";
		//String queryBDI = "INSERT INTO pessoa (nome, email, cargo) values ('Carolina', 'test@test.com', 'Aluno')";
		String queryBDI = "DELETE FROM pessoa WHERE ID=2";
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
			  System.out.println("id: " + resultado.getString("ID") + "\t nome: " + resultado.getString("nome")
				+ "\t email: " + resultado.getString("email") + resultado.getString("email") + "\\t Cargo: " 
				+ resultado.getString("Cargo"));
			}
		
		// System.out.println(st.execute("INSERT INTO pessoa (nome, email, cargo) values ('Carolina', 'test@test.com', 'Aluno');
		
		//Inserir, alterar e excluir 
		System.out.println(st.execute(queryBDI));
		
		} catch(SQLException e) {
			e.printStackTrace();
			//System.out.println("SQL Exception");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
			//System.out.println("Class not found")
		}
		
	}

}
