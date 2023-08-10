package br.com.jopaulo.boleto.adapter.datasource.integration.cliet;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.jopaulo.boleto.adapter.datasource.integration.dto.BoletoDTO;

@FeignClient(value = "complementos", url = "${api.boleto}")
public interface ComplementoBoletoClient {

	@GetMapping("/{codigo}")
	BoletoDTO getBoleto(@PathVariable(value = "codigo") String codigo);
}
