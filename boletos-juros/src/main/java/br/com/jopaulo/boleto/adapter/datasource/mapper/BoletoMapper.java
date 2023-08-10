package br.com.jopaulo.boleto.adapter.datasource.mapper;

import org.mapstruct.Mapper;

import br.com.jopaulo.boleto.adapter.datasource.integration.dto.BoletoDTO;
import br.com.jopaulo.boleto.core.domain.Boleto;

@Mapper(componentModel = "spring")
public interface BoletoMapper {

	Boleto toDomain(BoletoDTO boletoDTO);
}
