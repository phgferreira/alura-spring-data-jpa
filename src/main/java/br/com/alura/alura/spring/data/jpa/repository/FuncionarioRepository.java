package br.com.alura.alura.spring.data.jpa.repository;

import br.com.alura.alura.spring.data.jpa.model.Funcionario;
import br.com.alura.alura.spring.data.jpa.model.FuncionarioProjecao;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

    public interface FuncionarioRepository extends PagingAndSortingRepository<Funcionario, Integer> {

    List<Funcionario> findByNome(String nome, Pageable pageable);

    @Query("select f from Funcionario f where f.nome = :nome and f.salario >= :salario and f.dataContratacao = :dataContratacao")
    List<Funcionario> findByNomeAndSalario(String nome, BigDecimal salario, LocalDate dataContratacao, Pageable pageable);

    @Query(nativeQuery = true, value="select * from funcionario f where f.data_contratacao >= :data")
    List<Funcionario> findByDataContratacaoMaior(LocalDate data);

    @Query(nativeQuery = true, value = "select f.id, f.nome, f.salario from funcionario f")
    List<FuncionarioProjecao> findFuncionarioSalario();
}
