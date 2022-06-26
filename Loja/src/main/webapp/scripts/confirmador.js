/**
 * Confirmação de exclusão de um contato
 * @author Maria
 */
 
 function confirmar(id){
	let resposta = confirm("Confirma a exclusão deste produto?")
	if (resposta === true){
		//teste
		//alert(codigo)
		window.location.href = "delete?id=" + id
	}
	
}