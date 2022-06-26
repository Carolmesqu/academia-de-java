/**
 * Validação de formulário
 * @author Maria Carolina
 */
 
 function validar (){
	let codigo = frmNovo.codigo.value
	let nome = frmNovo.nome.value
	let valor = frmNovo.valor.value
	let quantidade = frmNovo.quantidade.value
	
	 if (codigo === ""){
		alert('Preencha o campo Código.')
		frmNovo.codigo.focus()
		return false
					
	}  else if (nome === ""){
		alert('Preencha o campo Nome.')
		frmNovo.nome.focus()
		return false
	
	} else if (valor === ""){
		alert('Preencha o campo Valor.')
		frmNovo.valor.focus()
		return false		
	
	}  else if (quantidade === ""){
		alert('Preencha o campo Quantidade.')
		frmNovo.quantidade.focus()
		return false
	
	} else {
		document.forms["frmNovo"].submit()
	}
}