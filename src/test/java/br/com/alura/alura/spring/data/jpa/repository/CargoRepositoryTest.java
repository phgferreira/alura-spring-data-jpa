package br.com.alura.alura.spring.data.jpa.repository;

import br.com.alura.alura.spring.data.jpa.model.Cargo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CargoRepositoryTest {

    private CargoRepository repository;

    @Test
    @DisplayName("deve inserir um cargo no banco de dados")
    void insertTest() {
       Cargo cargo = new Cargo("Desenvolvedor de Software");
       repository.save(cargo);
    }

}