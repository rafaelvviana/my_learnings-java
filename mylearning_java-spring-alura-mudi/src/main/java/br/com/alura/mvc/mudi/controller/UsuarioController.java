package br.com.alura.mvc.mudi.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;

@Controller
@RequestMapping("usuario")
public class UsuarioController {
	
	@Autowired
	private PedidoRepository repository;
	
	@GetMapping("pedido")
	public String home(Model model, Principal principal) {
		List<Pedido> pedidos = repository.findAllByUsuario(principal.getName());		
		model.addAttribute("pedidos", pedidos);
		return "usuario/home";
	}
	
	@GetMapping("pedido/{status}")
	public String status(@PathVariable("status") String status, Model model, Principal principal) {
		List<Pedido> pedidos = repository.findByStatusEUsuario(StatusPedido.valueOf(status.toUpperCase()), principal.getName());		
		model.addAttribute("pedidos", pedidos);
		model.addAttribute("status", status);		
		return "usuario/home";
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public String OnError() {
		return "redirect:/usuario/home";
	}

}
