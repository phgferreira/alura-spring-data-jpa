package br.com.alura.alura.spring.data.jpa.service;

import br.com.alura.alura.spring.data.jpa.orm.Cargo;
import br.com.alura.alura.spring.data.jpa.repository.CargoRepository;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class CrudCargoService {

    private final CargoRepository repository;

    public CrudCargoService(CargoRepository repository) {
        this.repository = repository;
    }

    public void inicial(Scanner scanner) {
        salvar(scanner);
    }

    private void salvar(Scanner scanner) {
        System.out.println("Descrição do cargo: ");
        String descricao = scanner.nextLine();

        Cargo cargo = new Cargo(descricao);
        repository.save(cargo);
        System.out.printf("%s salvo com sucesso", cargo.getDescricao());
    }
}
