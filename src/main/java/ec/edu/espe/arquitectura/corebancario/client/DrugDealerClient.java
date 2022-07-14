package ec.edu.espe.arquitectura.corebancario.client;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DrugDealerClient {
  @Getter private final String baseUrl;
  @Getter private final RestTemplate restTemplate;

  public DrugDealerClient(@Value("${dealer.c.url}") String baseUrl) {
    this.baseUrl = baseUrl + "/dealer/{fullName}";
    this.restTemplate = new RestTemplate(getClientHttpRequestFactory());
  }

  private ClientHttpRequestFactory getClientHttpRequestFactory() {
    HttpComponentsClientHttpRequestFactory clientHttpRequestFactory =
        new HttpComponentsClientHttpRequestFactory();
    int connectTimeout = 5000;
    int readTimeout = 5000;
    clientHttpRequestFactory.setConnectTimeout(connectTimeout);
    clientHttpRequestFactory.setReadTimeout(readTimeout);
    return clientHttpRequestFactory;
  }
}
