package br.com.alura.alura.spring.data.jpa;

import br.com.alura.alura.spring.data.jpa.service.CrudCargoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class AluraSpringDataJpaApplication implements CommandLineRunner {

	private Boolean isRunning = true;

	private final CrudCargoService service;

	public AluraSpringDataJpaApplication(CrudCargoService service) {
		this.service = service;
	}

	public static void main(String[] args) {
		SpringApplication.run(AluraSpringDataJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner( System.in );
		while (isRunning) {
			System.out.println("""
  				Qual ação você quer executar?
  				0 - Sair
  				1 - Cargo
  				""");
			int opcao = scanner.nextInt();
//			scanner.nextLine();
			// https://stackoverflow.com/questions/26586489/integer-parseintscanner-nextline-vs-scanner-nextint

			if (opcao == 1) {
				service.inicial(scanner);
			} else {
				isRunning = false;
			}
		}
	}
}
