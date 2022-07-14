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
@Document(collection = "transaccion")
@TypeAlias("transaccion")
public class Transaction {

  @Id private String id;

  private String internalCode;

  private Date date;

  private String debtorAccount;

  private String creditorAccount;

  private BigDecimal amount;

  private String state;
}
