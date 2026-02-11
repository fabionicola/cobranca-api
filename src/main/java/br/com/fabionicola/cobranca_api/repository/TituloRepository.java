package br.com.fabionicola.cobranca_api.repository;


import br.com.fabionicola.cobranca_api.model.StatusTitulo;
import br.com.fabionicola.cobranca_api.model.Titulo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;


public interface TituloRepository extends JpaRepository<Titulo, Long> {
    List<Titulo> findByStatusAndVencimentoBefore(StatusTitulo status, LocalDate data);
}

