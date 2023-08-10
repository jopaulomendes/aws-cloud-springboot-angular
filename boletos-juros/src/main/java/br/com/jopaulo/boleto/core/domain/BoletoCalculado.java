package br.com.jopaulo.boleto.core.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.jopaulo.boleto.core.domain.enums.TipoBoleto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BoletoCalculado {
	private String codigo;
	private BigDecimal valorOriginal;
	private BigDecimal valor;
	private LocalDate dataVencimento;
	private LocalDate dataPagamento;
	private BigDecimal juros;
	private TipoBoleto tipo;
}
