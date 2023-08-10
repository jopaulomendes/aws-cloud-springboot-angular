package br.com.jopaulo.boleto.core.port.out;

import br.com.jopaulo.boleto.core.domain.BoletoCalculado;

public interface SalvarCalculoBoletoPort {

	void executar(BoletoCalculado boletoCalculado);
}
