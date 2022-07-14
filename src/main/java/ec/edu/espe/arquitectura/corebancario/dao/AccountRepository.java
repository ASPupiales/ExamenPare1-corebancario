package ec.edu.espe.arquitectura.corebancario.dao;

import ec.edu.espe.arquitectura.corebancario.model.Account;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository<Account, String> {

  Optional<Account> findByInternalCode(String internalCode);
}
