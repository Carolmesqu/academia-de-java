
public class Moto {
	public String marca;
	public String modelo;
	public String cilindradas;
	
	//função escrever nas variavais
	public void configuraDados(String marcaMoto, String modeloMoto, String cilindradasMoto) {
	this.marca = marcaMoto;
	this.modelo = modeloMoto;
	this.cilindradas = cilindradasMoto;
		
	}
	
//Crie uma classe chamada Moto com três atributos (marca, modelo e cilindradas)
//	e dois métodos (atribuir valores e retornar valores). 
	
	public void exibirDados() {
		System.out.println("Dados da moto: " + marca + ", " + modelo + " de " + cilindradas + " cilindradas.");
		
	}
		
}
