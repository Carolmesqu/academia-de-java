package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
	
	/** Módulo de conexão **/
	// Parâmetros de conexão
	
	private String 	driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/loja?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String passowrd = "";
		
	
	// Método de conexão
	
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, passowrd);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
			
		}
	}
	
	//Teste de conexão
		//public void testeConexao() {
		//try {
		//	Connection con = conectar();
			//System.out.println(con);
			//con.close();
		//} catch (Exception e) {
		//	System.out.println(e);
		//}
	//}
		
		/** CRUD CREATE **/
		public void inserirProdutos(JavaBeans produtos) {
			String create = "insert into produtos (codigo, nome, categoria, valor, quantidade) values (?, ?, ?, ?, ?)";
			try {
				//abrir a conexão
				Connection con = conectar();
				//prepara a query para execução no bd
				PreparedStatement pst = con.prepareStatement(create);
				//Substituir os parametros pelos conteudoss da variavel java beans
				pst.setInt(1, produtos.getCodigo());
				pst.setString(2, produtos.getNome());
				pst.setString(3, produtos.getCategoria());
				pst.setFloat(4, produtos.getValor());
				pst.setInt(5, produtos.getQuantidade());
				//Executar a query
				pst.executeUpdate();
				//Encerrar a conexão com o bd
				con.close();
				
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
		/** CRUD READ**/
		public ArrayList<JavaBeans> listarProdutos(){
			//Criando o objeto para acessar classe JavaBeans 
			ArrayList<JavaBeans> produtos = new ArrayList<>();
			String read = "select * from produtos order by nome";
			try {
				Connection con = conectar ();
				PreparedStatement pst = con.prepareStatement(read);
				ResultSet rs = pst.executeQuery();
				// laço abaixo será executado enquanto houver produtos
				while (rs.next()) {
					//variaveis de apoio que recebem os dados do banco
					int id = rs.getInt(1);
					int codigo = rs.getInt(2);
					String nome = rs.getString(3);
					String categoria = rs.getString(4);
					float valor = rs.getFloat(5);
					int quantidade = rs.getInt(6);
					//populando o ArrayList
					produtos.add(new JavaBeans(id,codigo,nome,categoria,valor,quantidade));
					
				}
				con.close();
				return produtos;
			} catch (Exception e) {
				System.out.println(e);
				return null;
			}
		}
			
			/**CRUDE UPDATE**/
			
			//Selecionar o contato
			public void selecionarProdutos(JavaBeans produtos) {
				String read2 = "select * from produtos where id = ?";
				try {
					Connection con = conectar();
					PreparedStatement pst = con.prepareStatement(read2);
					pst.setInt(1, produtos.getId());
					ResultSet rs = pst.executeQuery();
					while (rs.next()) {
						//setar as variaveis de JavaBeans
						produtos.setId(rs.getInt(1));
						produtos.setCodigo(rs.getInt(2));
						produtos.setNome(rs.getString(3));
						produtos.setCategoria(rs.getString(4));
						produtos.setValor(rs.getFloat(5));
						produtos.setQuantidade(rs.getInt(6));
					}
					con.close();
				} catch (Exception e) {
					System.out.println(e);
				}
			
		}
			//editar o produto
			public void alterarProdutos(JavaBeans produtos) {
				String create = "update produtos set codigo=?, nome=?, categoria=?, valor=?, quantidade=? where id=?";
				try {
					Connection con = conectar();
					PreparedStatement pst = con.prepareStatement(create);
					pst.setInt(1, produtos.getCodigo());
					pst.setString(2, produtos.getNome());
					pst.setString(3, produtos.getCategoria());
					pst.setFloat(4, produtos.getValor());
					pst.setInt(5, produtos.getQuantidade());
					pst.setInt(6, produtos.getId());
					pst.executeUpdate();
					con.close();
				} catch (Exception e) {
					System.out.println(e);
				}
			}
			
			/** CRUD DELETE **/
			public void deletarProdutos(JavaBeans produtos) {
				String delete = "delete from produtos where id=?";
				try {
					Connection con = conectar();
					PreparedStatement pst = con.prepareStatement(delete);
					pst.setInt(1, produtos.getId());	
					pst.executeUpdate();
					con.close();
				} catch (Exception e) {
					System.out.println(e);
				}
			}
}
