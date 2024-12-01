package com.davidguiolm.app.lectorama.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.davidguiolm.app.lectorama.entities.Usuario;
import com.davidguiolm.app.lectorama.services.UsuariosService;
import com.davidguiolm.app.lectorama.services.exceptions.RegistroNotFoundException;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	protected UsuariosService usuariosService;

	@GetMapping
	public String getLogin(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "login";
	}
	
	@PostMapping
	public String doLogin(@ModelAttribute Usuario usuario, Model model) {
		try {
			Usuario usuarioConsultado = usuariosService.consultarPorNombreUsuarioPassword(usuario);
			model.addAttribute("usuarioSesion", usuarioConsultado);
			return "inicio";
		}
		catch(RegistroNotFoundException e) {
			e.printStackTrace();
			return "loginError";
		}
		
	}
	
	

}
