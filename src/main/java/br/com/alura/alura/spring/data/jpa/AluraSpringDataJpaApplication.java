package br.com.alura.alura.spring.data.jpa;

import br.com.alura.alura.spring.data.jpa.orm.Cargo;
import br.com.alura.alura.spring.data.jpa.repository.CargoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AluraSpringDataJpaApplication implements CommandLineRunner {

	private final CargoRepository repository;

	public AluraSpringDataJpaApplication(CargoRepository repository) {
		this.repository = repository;
	}

	public static void main(String[] args) {
		SpringApplication.run(AluraSpringDataJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Cargo cargo = new Cargo("Desenvolvedor de Software");
		repository.save(cargo);
	}
}
