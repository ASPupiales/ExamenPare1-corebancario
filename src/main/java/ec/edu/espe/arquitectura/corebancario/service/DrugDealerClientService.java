package ec.edu.espe.arquitectura.corebancario.service;

import ec.edu.espe.arquitectura.corebancario.client.DrugDealerClient;
import ec.edu.espe.arquitectura.corebancario.model.DrugDealer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DrugDealerClientService {

  private final DrugDealerClient client;

  public DrugDealer obtainByName(String fullName) {

    ResponseEntity<DrugDealer> response =
        client.getRestTemplate().getForEntity(client.getBaseUrl(), DrugDealer.class);
    return response.getBody();
  }
}
