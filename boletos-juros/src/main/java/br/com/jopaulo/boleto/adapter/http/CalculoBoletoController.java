package br.com.jopaulo.boleto.adapter.http;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jopaulo.boleto.adapter.http.dto.CalculoBoletoRequest;
import br.com.jopaulo.boleto.adapter.http.dto.CalculoBoletoResponse;
import br.com.jopaulo.boleto.adapter.http.mapper.CalculoBoletoMapper;
import br.com.jopaulo.boleto.core.port.in.CalculoBoletoPort;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/boleto")
public class CalculoBoletoController {
	
	private final CalculoBoletoPort calculoBoletoPort;
	private final CalculoBoletoMapper mapper;

	public CalculoBoletoController(CalculoBoletoPort calculoBoletoPort, CalculoBoletoMapper mapper) {
		this.calculoBoletoPort = calculoBoletoPort;
		this.mapper = mapper;
	}

	@PostMapping("/calculo")
	@Operation(summary = "Calcular juros de um boleto")
	public ResponseEntity<CalculoBoletoResponse> calcularBoleto(@Valid @RequestBody CalculoBoletoRequest boleto){
		var boletoCalculado = calculoBoletoPort.executar(boleto.getCodigo(), boleto.getDataPagamento());
		return ResponseEntity.ok(mapper.toDTO(boletoCalculado));
	}
}
