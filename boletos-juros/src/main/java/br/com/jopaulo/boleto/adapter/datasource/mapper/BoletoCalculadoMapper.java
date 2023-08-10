package br.com.jopaulo.boleto.adapter.datasource.mapper;

import org.mapstruct.Mapper;

import br.com.jopaulo.boleto.adapter.datasource.database.entity.BoletoCalculadoEntity;
import br.com.jopaulo.boleto.core.domain.BoletoCalculado;

@Mapper(componentModel = "spring")
public interface BoletoCalculadoMapper {
	BoletoCalculadoEntity toEntity(BoletoCalculado boletoCalculado);
}
