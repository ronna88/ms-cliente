package br.com.ronna.ms.cliente.repositories;

import br.com.ronna.ms.cliente.models.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {
}
