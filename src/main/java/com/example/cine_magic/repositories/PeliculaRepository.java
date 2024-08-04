package com.example.cine_magic.repositories;

import com.example.cine_magic.models.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula,Long> {


}
