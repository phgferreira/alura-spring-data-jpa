package br.com.alura.alura.spring.data.jpa.repository;

import br.com.alura.alura.spring.data.jpa.model.Funcionario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface FuncionarioRepository extends CrudRepository<Funcionario, Integer> {

    List<Funcionario> findByNome(String nome);

    @Query("select f from Funcionario f where f.nome = :nome and f.salario >= :salario and f.dataContratacao = :dataContratacao")
    List<Funcionario> findByNomeAndSalario(String nome, BigDecimal salario, LocalDate dataContratacao);

}
