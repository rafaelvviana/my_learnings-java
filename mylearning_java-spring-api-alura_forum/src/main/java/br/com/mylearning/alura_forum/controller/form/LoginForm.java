package br.com.mylearning.alura_forum.controller.form;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class LoginForm {
	
	private String email;
	private String senha;
	
	public LoginForm() {
		
	}
	
	public String getEmail() {
		return email;
	}
	public String getSenha() {
		return senha;
	}

	public UsernamePasswordAuthenticationToken converter() {		
		return new UsernamePasswordAuthenticationToken(email, senha);
	}

}
