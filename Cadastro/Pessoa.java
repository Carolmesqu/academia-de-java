package CincoCinco;
		
public class Pessoa {
	public String nome;
	public String idade;
	public String telefone;
	
	public void configuraDadosPessoa(String nomePessoa, String idadePessoa, String telefonePessoa) {
		this.nome = nomePessoa;
		this.idade = idadePessoa;
		this.telefone = telefonePessoa;
			
		}
	
	public void exibirDadosPessoa() {
		System.out.print("Nome: " + nome);
		System.out.print("Idade: " + idade);
		System.out.print("Telefone: " + telefone);
		
	}
	
	

}


//Uma empresa está cadastrando seus funcionários em sua base de dados. 
//Sabendo que Funcionario é uma Pessoa, e que pessoas possuem (nome, idade e telefone), 
//e que seus funcionários são divididos por (setor, cargo e função). Crie uma classe executável, 
//e cadastre 3 funcionários, preferencialmente solicitando as informações via console ao usuário. 
//Após esse cadastro, exiba esses funcionários na tela. A classe Funcionario deve herdar as características da classe Pessoa. 