package ec.edu.espe.arquitectura.corebancario.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "cliente")
@TypeAlias("cliente")
public class Client {

  @Id private String id;

  private String document;

  private String fullName;

  private String state;
}
