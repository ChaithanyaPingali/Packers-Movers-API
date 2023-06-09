package com.movesmart.movesmartapi.controller;

import java.util.List;
import com.movesmart.movesmartapi.model.Packer;
import com.movesmart.movesmartapi.repository.PackerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;


@Slf4j
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/packer")
public class PackerController {

  @Autowired
  private PackerRepository packerRepository;

  //  @CrossOrigin(origins = "http://localhost:3000")
  @GetMapping("/getAllPackers")
  public List<Packer> getPackers() {
    log.info("Read request received to get all Packers ");
    return packerRepository.findAll();
  }

  @GetMapping("/{id}")
  public Packer getUser(@PathVariable String id) {
    return packerRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Packer not found with id: " + id));
  }

  @PostMapping("")
  public Packer createUser(@RequestBody Packer packer) {
    return packerRepository.save(packer);
  }

  @PutMapping("/{id}")
  public Packer updateUser(@PathVariable String id, @RequestBody Packer packer) {
    return packerRepository.findById(id)
        .map(u -> {
          u.setPhoneNo(packer.getPhoneNo());
          u.setName(packer.getName());
          u.setCity(packer.getCity());
          u.setState(packer.getState());
          u.setEmail(packer.getEmail());
          return packerRepository.save(u);
        })
        .orElseThrow(() -> new EntityNotFoundException("Packer not found with id: " + id));
  }

  @DeleteMapping("/{id}")
  public void deleteUser(@PathVariable String id) {
    packerRepository.deleteById(id);
  }

}
