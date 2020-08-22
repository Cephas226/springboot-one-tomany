package com.cooly.jpaonetomany.controller;

import com.cooly.jpaonetomany.model.Banque;
import com.cooly.jpaonetomany.repository.banqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.Optional;

@RestController
public class BanqueController implements Serializable
{
  @Autowired
  private banqueRepository BanqueRepository;


  @GetMapping("/banque")
  public Page<Banque> getAllBanques(Pageable pageable){
    return BanqueRepository.findAll(pageable);
  }
  @PostMapping("/banque")
  public Banque postBanque(@RequestBody Banque Banque){
    return BanqueRepository.save(Banque);
  }
  @PutMapping("/banque/{id_Banque}")
  public Optional<Banque> updateBanque(@PathVariable Long id_banque, @RequestBody Banque banqueRequest){
      return BanqueRepository.findById(id_banque).map(Banque ->{
        Banque.setNom_banque(banqueRequest.getNom_banque());
       return BanqueRepository.save(Banque);
    });
  }
  @DeleteMapping("/banque/{banque_id}")
  public Optional<ResponseEntity<Object>> deleteBanque(@PathVariable (value = "banque_id") Long banque_id) {
    return BanqueRepository.findById(banque_id).map(Banque -> {
      BanqueRepository.delete(Banque);
      return ResponseEntity.ok().body("Successfully deleted specified record");
    });
  }
}
