package com.guido.testServicios.repositories;

import com.guido.testServicios.models.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta,Long>{

   @Query("SELECT c FROM Cuenta c WHERE c.nombre= ?1")
    Optional<Cuenta> FindByNombre(String nombre);

}
