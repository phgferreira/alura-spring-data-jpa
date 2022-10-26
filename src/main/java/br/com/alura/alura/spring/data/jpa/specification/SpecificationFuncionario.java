package br.com.alura.alura.spring.data.jpa.specification;

import br.com.alura.alura.spring.data.jpa.model.Funcionario;
import org.springframework.data.jpa.domain.Specification;

public class SpecificationFuncionario {

    public static Specification<Funcionario> nome(String nome) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder
                .like(root.get("nome"), "%" + nome + "%");
    }

}
