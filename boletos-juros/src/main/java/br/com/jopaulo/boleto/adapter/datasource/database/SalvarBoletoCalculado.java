package br.com.jopaulo.boleto.adapter.datasource.database;

import org.springframework.stereotype.Component;

import br.com.jopaulo.boleto.adapter.datasource.database.repository.BoletoCalculadoRepository;
import br.com.jopaulo.boleto.adapter.datasource.mapper.BoletoCalculadoMapper;
import br.com.jopaulo.boleto.core.domain.BoletoCalculado;
import br.com.jopaulo.boleto.core.port.out.SalvarCalculoBoletoPort;

@Component
public class SalvarBoletoCalculado implements SalvarCalculoBoletoPort {
	
	private final BoletoCalculadoRepository repository;
	private final BoletoCalculadoMapper mapper;

	public SalvarBoletoCalculado(BoletoCalculadoRepository repository, BoletoCalculadoMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public void executar(BoletoCalculado boletoCalculado) {
		var entity = mapper.toEntity(boletoCalculado);
		repository.save(entity);
	}

}
