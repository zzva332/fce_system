package com.fce.system.clientes;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// repositorio para cliente
@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {

}
