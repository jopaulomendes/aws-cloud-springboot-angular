package br.com.jopaulo.boleto.adapter.datasource.integration.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.jopaulo.boleto.core.domain.enums.TipoBoleto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoletoDTO {

	private String codigo;
	@JsonProperty("data_vencimento")
	private LocalDate dataVencimento;
	private BigDecimal valor;
	private TipoBoleto tipo;
}
