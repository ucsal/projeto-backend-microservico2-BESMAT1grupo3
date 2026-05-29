package br.edu.ucsal.ms_professor_projeto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class MsProfessorProjetoApplication {

	public static void main(String[] args) {
		SpringApplication.run(
				MsProfessorProjetoApplication.class,
				args
		);
	}

}