package br.com.jopaulo.boleto.adapter.http.exception;

import java.util.Arrays;
import java.util.Date;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.jopaulo.boleto.core.exception.ApplicationException;

@ControllerAdvice
public class ApplicationExceptionHandle extends ResponseEntityExceptionHandler{

	@ExceptionHandler(ApplicationException.class)
	public ResponseEntity<ErroResponse> applicationException(ApplicationException ex, WebRequest request){
		var response = ErroResponse.builder()
				.mensagens(Arrays.asList(ex.getTipoExcecao().getMensagemErro()))
				.erro(ex.getTipoExcecao().toString().toLowerCase())
				.codigo(HttpStatus.BAD_REQUEST.value())
				.timestamp(new Date())
				.path(request.getDescription(false))
				.build();
		
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
	
	// tratar erro 500
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		var erros = ex.getFieldErrors().stream()
				.map(item -> item.getField() + " " + item.getDefaultMessage())
				.collect(Collectors.toList());

		var response = ErroResponse.builder()
				.mensagens(erros)
				.erro("Erro na validação")
				.codigo(HttpStatus.BAD_REQUEST.value())
				.timestamp(new Date())
				.path(request.getDescription(false))
				.build();
		
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
}
