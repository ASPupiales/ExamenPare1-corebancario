package ec.edu.espe.arquitectura.corebancario.resource;

import ec.edu.espe.arquitectura.corebancario.model.Transaction;
import ec.edu.espe.arquitectura.corebancario.service.TransactionService;
import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/transaction")
@RequiredArgsConstructor
public class TransactionResource {

  private final TransactionService service;

  @PostMapping
  public ResponseEntity<Transaction> transfer(
      @RequestParam("debtor") String debtor,
      @RequestParam("creditor") String creditor,
      @RequestParam("amount") BigDecimal amount) {
    try {
      Transaction transfeTransaction = this.service.transfer(debtor, creditor, amount);
      return ResponseEntity.ok(transfeTransaction);
    } catch (Exception e) {
      return ResponseEntity.badRequest().build();
    }
  }
}
