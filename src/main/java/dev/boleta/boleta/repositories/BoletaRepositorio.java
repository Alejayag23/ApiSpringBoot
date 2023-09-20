package dev.boleta.boleta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.boleta.boleta.model.Boleta;

@Repository
public interface BoletaRepositorio extends JpaRepository<Boleta, Long>{
    
}
