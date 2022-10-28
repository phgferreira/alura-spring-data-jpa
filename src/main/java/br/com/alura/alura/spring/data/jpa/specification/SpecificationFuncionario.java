package br.com.alura.alura.spring.data.jpa.specification;

import br.com.alura.alura.spring.data.jpa.model.Funcionario;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SpecificationFuncionario {

    public static Specification<Funcionario> nome(String nome) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder
                .like(root.get("nome"), "%" + nome + "%");
    }

    public static Specification<Funcionario> cpf(String cpf) {
        // OBS: é equal e não equalS
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder
                .equal(root.get("cpf"), cpf);
    }

    public static Specification<Funcionario> salario(BigDecimal salario) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder
                .greaterThan(root.get("salario"), salario);
    }

    public static Specification<Funcionario> dataContratacao(LocalDate dataContratacao) {
        // O parametro String nome do campo é o nome em Java e não em SQL
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder
                .greaterThan(root.get("dataContratacao"), dataContratacao);
    }
}
