package br.com.jopaulo.apiproduto.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class inicioController {

	@GetMapping
	public String inicio() {
		return "Api funcionando";
	}
}
