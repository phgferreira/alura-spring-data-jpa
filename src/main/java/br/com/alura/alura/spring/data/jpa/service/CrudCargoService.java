package br.com.alura.alura.spring.data.jpa.service;

import br.com.alura.alura.spring.data.jpa.model.Cargo;
import br.com.alura.alura.spring.data.jpa.repository.CargoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Scanner;

@Service
public class CrudCargoService {

    private Boolean isRunning = true;

    private final CargoRepository repository;

    public CrudCargoService(CargoRepository repository) {
        this.repository = repository;
    }

    public void inicial(Scanner scanner) {
        while (isRunning) {
            System.out.println("""
                        Qual ação de cargo deseja executar?
                        0 - Sair
                        1 - Salvar
                        2 - Atualizar
                        3 - Visualizar
                        4 - Deletar
                        """);
            int opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 0:
                    isRunning = false;
                    break;
                case 1:
                    salvar(scanner);
                    break;
                case 2:
                    atualizar(scanner);
                    break;
                case 3:
                    visualizar();
                    break;
                case 4:
                    deletar(scanner);
                    break;
            }
        }
    }

    private void salvar(Scanner scanner) {
        System.out.println("Descrição do cargo: ");
        String descricao = scanner.nextLine();

        Cargo cargo = new Cargo(descricao);
        repository.save(cargo);
        System.out.printf("%s salvo com sucesso", cargo.getDescricao());
    }

    private void atualizar(Scanner scanner) {
        System.out.println("Informe o ID do cargo por favor: ");
        repository.findAll().forEach(cargo -> System.out.println(cargo));

        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Informa a nova descrição do cargo: ");
        String novaDescricao = scanner.nextLine();

        Cargo cargo = new Cargo(id, novaDescricao);
        repository.save(cargo);
    }

    private void visualizar() {
        repository.findAll().forEach(cargo -> System.out.println(cargo));
    }

    private void deletar(Scanner scanner) {
        System.out.println("Qual cargo gostaria de deletar?");
        repository.findAll().forEach(cargo -> System.out.println(cargo));
        int id = scanner.nextInt();
        scanner.nextLine();

        Optional<Cargo> cargo = repository.findById(id);
        repository.deleteById(id);
        System.out.printf("%s deletado com sucesso!", cargo);
    }
}
