package br.com.jopaulo.boleto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BoletosJurosApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoletosJurosApplication.class, args);
	}

}
