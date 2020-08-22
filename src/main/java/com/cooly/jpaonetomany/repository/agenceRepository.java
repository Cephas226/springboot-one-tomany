package com.cooly.jpaonetomany.repository;

import com.cooly.jpaonetomany.model.Agence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Repository
public interface agenceRepository extends JpaRepository<Agence, Long> {


  @Query("SELECT p FROM Agence p WHERE id_agence = :id_agence")
  Optional<Agence>findByBanqueIdAndAgenceId(@Param("id_agence")Long id_agence);

  @Query("SELECT p FROM Agence p WHERE banque_id = :banque_id")
  List<Agence>  findByBanqueId(@Param("banque_id") Long banque_id);

  @Query("SELECT p FROM Agence p WHERE id_agence = :id_agence and banque_id = :banque_id")
  List<Agence>  findByBanqueAndBanque(@Param("id_agence")Long id_agence, @Param("banque_id") Long banque_id);
}
