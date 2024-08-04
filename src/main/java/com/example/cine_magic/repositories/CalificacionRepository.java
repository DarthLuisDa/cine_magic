package com.example.cine_magic.repositories;

import com.example.cine_magic.models.Calificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalificacionRepository extends JpaRepository<Calificacion,Long> {


}