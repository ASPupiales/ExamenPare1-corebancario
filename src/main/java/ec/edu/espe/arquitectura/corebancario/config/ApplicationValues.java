package ec.edu.espe.arquitectura.corebancario.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class ApplicationValues {
  private final String mongoHost;
  private final String mongoDB;
  private final String mongoUsr;
  private final String mongoPwd;
  private final String mongoAut;

  public ApplicationValues(
      @Value("${mongoserver.mongo.host}") String mongoHost,
      @Value("${mongoserver.mongo.db}") String mongoDB,
      @Value("${mongoserver.mongo.usr}") String mongoUsr,
      @Value("${mongoserver.mongo.pwd}") String mongoPwd,
      @Value("${mongoserver.mongo.aut}") String mongoAut) {

    this.mongoHost = mongoHost;
    this.mongoDB = mongoDB;
    this.mongoUsr = mongoUsr;
    this.mongoPwd = mongoPwd;
    this.mongoAut = mongoAut;
  }
}
