package CincoCinco;

import java.util.Scanner;

public class Usuario {

	public static void main(String[] args) {
		
		//Pessoa
		
		System.out.println("- - - - - - - - - - - -   P E S S O A   - - - - - - - - - - - - -");
		System.out.println("                                                                 ");
		
		Scanner leitura = new Scanner(System.in);
		
		System.out.print("Nome: ");
		String nomePessoa = leitura.nextLine();
		
		System.out.print("Idade: ");
		String idadePessoa = leitura.nextLine();
		
		System.out.print("Telefone: ");
		String telefonePessoa = leitura.nextLine();
		
		System.out.println("                                                                 ");
		
		Pessoa ty = new Pessoa();
		ty.configuraDadosPessoa(nomePessoa,idadePessoa, telefonePessoa);
		ty.exibirDadosPessoa();
		
		System.out.println("                                                                 ");
		System.out.println("- - - - - - - - - - - F U N C I O N Á R I O - - - - - - - - - - -");
		System.out.println("                                                                 ");
		
		//Funcionario
		
		var leitura1 = new Scanner(System.in);
		
		System.out.print("Funcionário: ");
		String nome = leitura1.nextLine();
		
		System.out.print("Idade: ");
		String idade = leitura1.nextLine();
		
		System.out.print("Telefone: ");
		String telefone = leitura1.nextLine();
		
		System.out.print("Cargo: ");
		String cargo = leitura1.nextLine();
		
		System.out.print("Setor: ");
		String setor = leitura1.nextLine();
		
		System.out.print("Função: ");
		String funcao = leitura1.nextLine();

		System.out.println("                                                                 ");
		
		Funcionario x = new Funcionario();
		x.atribuirValores(nome, idade, telefone, setor, cargo, funcao);
		x.exibirDadosFuncionario();
		
		

	}

}
