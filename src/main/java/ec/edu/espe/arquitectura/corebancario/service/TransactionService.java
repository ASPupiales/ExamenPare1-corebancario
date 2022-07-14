package ec.edu.espe.arquitectura.corebancario.service;

import ec.edu.espe.arquitectura.corebancario.dao.AccountRepository;
import ec.edu.espe.arquitectura.corebancario.dao.TransactionRepository;
import ec.edu.espe.arquitectura.corebancario.exception.EntityNotFoundException;
import ec.edu.espe.arquitectura.corebancario.exception.TransferException;
import ec.edu.espe.arquitectura.corebancario.model.Account;
import ec.edu.espe.arquitectura.corebancario.model.Transaction;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionService {

  private final TransactionRepository transactionRepository;
  private final AccountRepository accountRepository;

  public Transaction transfer(String debtor, String creditor, BigDecimal amount) {

    Optional<Account> debtorAccount = this.accountRepository.findByInternalCode(debtor);
    if (debtorAccount.isEmpty()) {
      throw new EntityNotFoundException("There is no account wiht internal code: " + debtor);
    }

    Account debtorDb = debtorAccount.get();

    Optional<Account> creditorAccount = this.accountRepository.findByInternalCode(creditor);
    if (creditorAccount.isEmpty()) {
      throw new EntityNotFoundException("There is no account wiht internal code: " + debtor);
    }

    Account creditorDb = creditorAccount.get();

    if (debtorDb.getBalance().compareTo(amount) == -1) {
      throw new TransferException("Amount exceeds the balance");
    }

    debtorDb.setBalance(debtorDb.getBalance().subtract(amount));
    debtorDb.setLastDate(new Date());
    this.accountRepository.save(debtorDb);

    creditorDb.setBalance(creditorDb.getBalance().add(amount));
    creditorDb.setLastDate(new Date());
    this.accountRepository.save(creditorDb);

    Transaction transfer =
        Transaction.builder()
            .internalCode(UUID.randomUUID().toString())
            .date(new Date())
            .debtorAccount(debtorDb.getInternalCode())
            .creditorAccount(creditorDb.getInternalCode())
            .amount(amount)
            .state("state")
            .build();

    this.transactionRepository.save(transfer);

    return transfer;
  }
}
