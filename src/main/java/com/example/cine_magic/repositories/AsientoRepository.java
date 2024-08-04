package com.example.cine_magic.repositories;

import com.example.cine_magic.models.Asiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsientoRepository extends JpaRepository<Asiento,Long> {


}
