package br.com.alura.alura.spring.data.jpa.service;

import br.com.alura.alura.spring.data.jpa.model.Funcionario;
import br.com.alura.alura.spring.data.jpa.repository.FuncionarioRepository;
import br.com.alura.alura.spring.data.jpa.specification.SpecificationFuncionario;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

// O @Service é para futuramente poder usar injeção de dependência
@Service
public class RelatorioFuncionarioDinamico {

    private final DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private final FuncionarioRepository repository;

    public RelatorioFuncionarioDinamico(FuncionarioRepository repository) {
        this.repository = repository;
    }

    public void inicia(Scanner scanner) {
        System.out.println("Digite um nome: ");
        String nome = scanner.nextLine();
        System.out.println(nome);

        System.out.println("Digite o cpf: ");
        String cpf = scanner.nextLine();
        System.out.println(cpf);

        System.out.println("Digite o salário: ");
        String salarioString = scanner.nextLine();
        BigDecimal salario = (salarioString.equals("") ? null : new BigDecimal(salarioString));
        System.out.println(salario);

        System.out.println("Digite a data de contratacao (dd/mm/yyyy): ");
        String dataString = scanner.nextLine();
        LocalDate dataContratacao = (dataString.equals("") ? null : LocalDate.parse(dataString, format));

        List<Funcionario> funcionarios = repository.findAll(
                Specification.where( SpecificationFuncionario.nome(nome) )
                        .or(SpecificationFuncionario.cpf(cpf))
                        .or(SpecificationFuncionario.salario(salario))
                        .or(SpecificationFuncionario.dataContratacao(dataContratacao))
        );

        System.out.println("Lista de funcionarios");
        funcionarios.forEach( System.out::println );
    }
}
