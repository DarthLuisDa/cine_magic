package com.example.cine_magic.repositories;

import com.example.cine_magic.models.Funcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionRepository extends JpaRepository<Funcion,Long> {


}
