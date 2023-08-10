package br.com.jopaulo.boleto.core.port.in;

import java.time.LocalDate;

import br.com.jopaulo.boleto.core.domain.BoletoCalculado;

public interface CalculoBoletoPort {
	BoletoCalculado executar(String codigo, LocalDate dataPagamento);
}
