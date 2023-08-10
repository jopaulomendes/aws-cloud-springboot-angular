package br.com.jopaulo.boleto.adapter.http.mapper;

import org.mapstruct.Mapper;

import br.com.jopaulo.boleto.adapter.http.dto.CalculoBoletoResponse;
import br.com.jopaulo.boleto.core.domain.BoletoCalculado;

@Mapper(componentModel = "spring")
public interface CalculoBoletoMapper {
	CalculoBoletoResponse toDTO(BoletoCalculado boletoCalculado);
}
