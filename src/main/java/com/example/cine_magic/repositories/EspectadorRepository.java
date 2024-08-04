package com.example.cine_magic.repositories;

import com.example.cine_magic.models.Espectador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspectadorRepository extends JpaRepository<Espectador,Long> {


}
