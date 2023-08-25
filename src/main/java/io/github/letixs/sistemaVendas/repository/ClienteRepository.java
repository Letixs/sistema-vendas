package io.github.letixs.sistemaVendas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.letixs.sistemaVendas.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
