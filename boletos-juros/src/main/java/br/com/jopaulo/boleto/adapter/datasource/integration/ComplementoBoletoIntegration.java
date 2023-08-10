package br.com.jopaulo.boleto.adapter.datasource.integration;

import org.springframework.stereotype.Component;

import br.com.jopaulo.boleto.adapter.datasource.integration.cliet.ComplementoBoletoClient;
import br.com.jopaulo.boleto.adapter.datasource.mapper.BoletoMapper;
import br.com.jopaulo.boleto.core.domain.Boleto;
import br.com.jopaulo.boleto.core.port.out.ComplementoBoletoPort;

@Component
public class ComplementoBoletoIntegration implements ComplementoBoletoPort{
	
	private final ComplementoBoletoClient client;
	private final BoletoMapper mapper;
	
	public ComplementoBoletoIntegration(ComplementoBoletoClient client, BoletoMapper mapper) {
		this.client = client;
		this.mapper = mapper;
	}

	@Override
	public Boleto executar(String codigo) {
		var boletoDTO = client.getBoleto(codigo);
		return mapper.toDomain(boletoDTO);
	}
}
