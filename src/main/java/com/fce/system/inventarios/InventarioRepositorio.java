package com.fce.system.inventarios;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventarioRepositorio extends JpaRepository<Inventario, Long> {

}
