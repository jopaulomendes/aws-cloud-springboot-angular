package br.com.jopaulo.boleto.adapter.http.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CalculoBoletoRequest {
	@NotNull
	private String codigo;
	@NotNull
	@JsonProperty("data_pagamento")
	@JsonFormat(pattern = "yyy-MM-dd")
	private LocalDate dataPagamento;
}
