package com.example.cine_magic.repositories;

import com.example.cine_magic.models.Boleto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoletoRepository extends JpaRepository<Boleto,Long> {


}