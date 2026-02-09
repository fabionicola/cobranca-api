package br.com.fabionicola.cobranca_api.repository;


import br.com.fabionicola.cobranca_api.model.Titulo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TituloRepository extends JpaRepository<Titulo, Long> {
}

