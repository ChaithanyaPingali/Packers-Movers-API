package com.movesmart.movesmartapi.service;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReadSetupServiceImpl implements ReadSetupService {


//  private final  accountsPayableRepository;
  private final EntityManager entityManager;


  @Override
  @SneakyThrows
  public JsonNode getDMSSetups() {

    return new ObjectMapper().createObjectNode();
  }


}
