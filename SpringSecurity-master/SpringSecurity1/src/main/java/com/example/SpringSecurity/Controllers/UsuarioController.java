package com.example.SpringSecurity.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.SpringSecurity.Models.Usuario;
import com.example.SpringSecurity.Repositories.UsuarioRepository;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping("/cadastrar")
	public String getUsuario(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "cadastrarUsuario";
	}
	
	@PostMapping("/cadastrar")
	public String setUsuario(@ModelAttribute Usuario usuario, Model model) {
		usuarioRepository.save(usuario);
		List<Usuario> listaUsuarios = usuarioRepository.findAll();
		model.addAttribute("usuario", listaUsuarios);
		return "listarUsuarios";
	}

	@GetMapping("/excluir/{id}")
	@ResponseStatus(HttpStatus.OK)
	public String excluir(Model model, @PathVariable Long id) {
		usuarioRepository.deleteById(id);
		List<Usuario> listaUsuarios = usuarioRepository.findAll();
		model.addAttribute("usuarios", listaUsuarios);
		return "listarUsuarios";
	}

	@GetMapping ("{id}")
	Usuario getUsuario (@PathVariable Long id) {
		return usuarioRepository.findById(id).get();
	}
	
	@GetMapping("/alterar/{id}")
	public String altUsuarios(@PathVariable Long id, Model model) {
		Usuario p = usuarioRepository.findById(id).get();
		model.addAttribute("usuario", p);
		return "alterarUsuario";
	}

	@PostMapping("/alterar")
	public String alterarUsuario(@ModelAttribute Usuario novoUsuario, Model model) {
		Usuario p = usuarioRepository.findById(novoUsuario.getId()).get();
		if(novoUsuario.getEmail()!= null) {
		p.setEmail(novoUsuario.getEmail());
		}
		if(novoUsuario.getSenha()!= null) {
		p.setSenha(novoUsuario.getSenha());
		}
		p.setEmail(novoUsuario.getEmail());
		p.setSenha(novoUsuario.getSenha());
		p.setRole(novoUsuario.getRole());
		usuarioRepository.save(p);
		List<Usuario> listaUsuarios = usuarioRepository.findAll();
		model.addAttribute("usuarios", listaUsuarios);
		return "listarUsuarios";
	}

}