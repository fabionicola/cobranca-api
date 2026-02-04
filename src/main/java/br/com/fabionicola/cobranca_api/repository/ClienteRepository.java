package br.com.fabionicola.cobranca_api.repository;

import br.com.fabionicola.cobranca_api.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}