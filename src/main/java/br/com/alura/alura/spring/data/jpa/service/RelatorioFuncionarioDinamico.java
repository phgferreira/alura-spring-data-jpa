package br.com.alura.alura.spring.data.jpa.service;

import br.com.alura.alura.spring.data.jpa.model.Funcionario;
import br.com.alura.alura.spring.data.jpa.repository.FuncionarioRepository;
import br.com.alura.alura.spring.data.jpa.specification.SpecificationFuncionario;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Scanner;

public class RelatorioFuncionarioDinamico {

    private final FuncionarioRepository repository;

    public RelatorioFuncionarioDinamico(FuncionarioRepository repository) {
        this.repository = repository;
    }

    public void initial(Scanner scanner) {
        System.out.println("Digite um nome: ");
        String nome = scanner.nextLine();

        List<Funcionario> funcionarios = repository.findAll( Specification.where( SpecificationFuncionario.nome(nome) ) );
    }
}
