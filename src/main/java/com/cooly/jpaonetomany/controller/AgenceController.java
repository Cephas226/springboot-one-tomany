package com.cooly.jpaonetomany.controller;

import com.cooly.jpaonetomany.exception.ResourceNotFoundException;
import com.cooly.jpaonetomany.model.Agence;


import com.cooly.jpaonetomany.repository.agenceRepository;
import com.cooly.jpaonetomany.repository.banqueRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@RestController
public class AgenceController implements Serializable {

  @Autowired
  private agenceRepository AgenceRepository;

  @Autowired
  private banqueRepository BanqueRepository;

 @GetMapping("/banque/{banqueId}/agences")
  public List <Agence> getAgenceByBanque(@PathVariable(value = "banqueId") Long banqueId) {
    return AgenceRepository.findByBanqueId(banqueId);
  }
  @GetMapping("/banque/{banque_id}/agence/{id_agence}")
  public List <Agence> getAgenceByBanque(
    @PathVariable (value = "banque_id") Long banque_id,
    @PathVariable(value = "id_agence") Long id_agence) {
    return AgenceRepository.findByBanqueAndBanque(id_agence,banque_id);
  }
  @PostMapping("/banque/{banque_id}/agence")
  public Optional<Agence> postAgence(@RequestBody Agence agenceRequest,@PathVariable (value = "banque_id") Long banque_id) {
    return BanqueRepository.findById(banque_id).map(banque -> {
      agenceRequest.setBanque(banque);
      return AgenceRepository.save(agenceRequest);
    });
  }

  @PutMapping("/banque/{banque_id}/agence/{id_agence}")
  public Optional<Agence> updateAgence(@RequestBody Agence agenceRequest,
                                       @PathVariable (value = "banque_id")  Long banque_id, @PathVariable (value = "id_agence")  Long id_agence) {
    if(!BanqueRepository.existsById(banque_id)) {
      throw new ResourceNotFoundException("PostId " + banque_id + " not found");
    }
    return AgenceRepository.findById(id_agence).map(agence -> {
      agence.setLibelle(agenceRequest.getLibelle());
      return AgenceRepository.save(agence);
    });
  };
  @DeleteMapping("/agences/{id_agence}")
  public Optional<ResponseEntity<String>> deleteAgence(@PathVariable (value = "id_agence") Long id_agence){
     return AgenceRepository.findByBanqueIdAndAgenceId(id_agence).map(agence->{
       AgenceRepository.delete(agence);
       return ResponseEntity.ok().body("Successfully deleted specified record");
     });
}
}
