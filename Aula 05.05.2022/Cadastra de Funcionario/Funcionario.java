package CincoCinco;

public class Funcionario extends Pessoa {
	String setor;
	String cargo;
	String funcao;
	
	public void atribuirValores(String nome, String idade, String telefone, String setor, String cargo, String funcao) {
		super.nome = nome;
		super.idade = idade;
		super.telefone = telefone;
		this.setor = setor;
		this.cargo = cargo;
		this.funcao = funcao;
			
		}
	
	public void exibirDadosFuncionario() {
		System.out.println("Funcionário: " + nome);
		System.out.println("Idade: " + idade);
		System.out.println ("Telefone: " + telefone);
		System.out.println ("Setor: " + setor);
		System.out.println ("Cargo: " + cargo);
		System.out.println ("Função: " + funcao);
	}
}

