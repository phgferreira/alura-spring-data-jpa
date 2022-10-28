package br.com.alura.alura.spring.data.jpa;

import br.com.alura.alura.spring.data.jpa.service.CrudCargoService;
import br.com.alura.alura.spring.data.jpa.service.RelatorioFuncionarioDinamico;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class AluraSpringDataJpaApplication implements CommandLineRunner {

	private Boolean isRunning = true;

	private final CrudCargoService cargo;
	private final RelatorioFuncionarioDinamico relatorio;

	// Através desse construtor rebemos a injeção de dependência do Spring Data
	public AluraSpringDataJpaApplication(CrudCargoService service, RelatorioFuncionarioDinamico relatorio) {
		this.cargo = service;
		this.relatorio = relatorio;
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
  				2 - Relatorio de Funcionario
  				""");
			int opcao = scanner.nextInt();
			scanner.nextLine();
			// https://stackoverflow.com/questions/26586489/integer-parseintscanner-nextline-vs-scanner-nextint

			switch (opcao) {
				case 0:
					isRunning = false;
					break;
				case 1:
					cargo.inicial(scanner);
					break;
				case 2:
					relatorio.inicia(scanner);
					break;
			}
		}
	}
}
