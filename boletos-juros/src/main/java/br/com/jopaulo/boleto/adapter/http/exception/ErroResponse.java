package br.com.jopaulo.boleto.adapter.http.exception;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErroResponse {

	private List<String> mensagens = new ArrayList<>();
	private String erro;
	private int codigo;
	private Date timestamp;
	private String path;
}
