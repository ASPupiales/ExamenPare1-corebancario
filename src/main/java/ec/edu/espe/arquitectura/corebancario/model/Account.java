package ec.edu.espe.arquitectura.corebancario.model;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "cuenta")
@TypeAlias("cuenta")
public class Account {

  @Id private String id;

  private String clientId;

  private String internalCode;

  private BigDecimal balance;

  private Date lastDate;

  private String state;
}
