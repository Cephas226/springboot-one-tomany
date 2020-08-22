package com.cooly.jpaonetomany.repository;

import com.cooly.jpaonetomany.model.Banque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface banqueRepository extends JpaRepository<Banque, Long> {
}
