package com.example.cadastropessoas.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.cadastropessoas.model.Pessoa;

@Controller
public class PessoasController {
	//cria uma lista de pessoas
	ArrayList<Pessoa> lista = new ArrayList<Pessoa>();
		
	@GetMapping("/cadastro")
	public String registrarPessoas(Model model) {
		//Pessoa pessoa = new Pessoa(); < um opção
		//model.addAttribute("pessoa", pessoa);
		//mando para o form um objeto do tipo pessoa para ser utilizado.
		
		model.addAttribute("pessoa", new Pessoa());
		//redireciona para a pagina cadastro.html
		return "cadastro";
	}
	
	@PostMapping("/cadastro")
	public String addPessoa(@ModelAttribute Pessoa pessoa, Model model) {
		//pode-se inserir em um banco de dados 
		// para inserir no banco de dadps > dao.insert(pessoa)
		lista.add(pessoa);
		//System.out.println(pessoa.getId());
		//System.out.println(pessoa.getNome());
		//System.out.println(pessoa.getEmail());
		//System.out.println(pessoa.getFone());		
		
		//enviar a lista d eobjetos para a pagina
		model.addAttribute("listaPessoa", lista);
				
		//redireciona para a pagina lista.html
		return"lista";
		
		
	}

}
