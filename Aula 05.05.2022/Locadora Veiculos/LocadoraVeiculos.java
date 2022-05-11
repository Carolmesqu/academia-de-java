import java.util.Scanner;

public class LocadoraVeiculos {

	public static void main(String[] args) {
		
		//1 parte
		/*Moto moto = new Moto();
		moto.configuraDados("Honda4545", "Biz 125", "124,9cc");
		moto.exibirDados();*/
		
		Scanner leitura = new Scanner(System.in);
		System.out.println("Qual a marca?");
		String marcaCarro = leitura.nextLine();
		
		System.out.println("Qual o modelo?");
		String modeloCarro = leitura.nextLine();
		
		System.out.println("Qual é o ano?");
		String anoCarro = leitura.nextLine();
		
		Moto ty = new Moto();
		ty.configuraDados(marcaCarro, modeloCarro, anoCarro);
		ty.exibirDados();
					
	}

}
