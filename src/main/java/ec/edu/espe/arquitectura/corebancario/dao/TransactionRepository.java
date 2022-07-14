package ec.edu.espe.arquitectura.corebancario.dao;

import ec.edu.espe.arquitectura.corebancario.model.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TransactionRepository extends MongoRepository<Transaction, String> {}
