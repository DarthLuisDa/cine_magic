package com.example.cine_magic.repositories;

import com.example.cine_magic.models.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SucursalRepository extends JpaRepository<Sucursal,Long> {


}
