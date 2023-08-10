package br.com.jopaulo.boleto.core.exception;

import br.com.jopaulo.boleto.core.domain.enums.TipoExcecao;
import lombok.AllArgsConstructor;
import lombok.Getter;

@SuppressWarnings("serial")
@Getter
@AllArgsConstructor
public class ApplicationException extends RuntimeException {
	private TipoExcecao tipoExcecao;
}
