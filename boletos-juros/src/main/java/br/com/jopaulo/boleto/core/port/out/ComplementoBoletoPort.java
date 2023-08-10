package br.com.jopaulo.boleto.core.port.out;

import br.com.jopaulo.boleto.core.domain.Boleto;

public interface ComplementoBoletoPort {
	Boleto executar(String codigo);
}
