import java.util.UUID;

public interface TransactionsList {
    void addTransaction(Transaction t);
    void removeTransactionById(UUID id) throws TransactionNotFoundException;
    Transaction[] toArray();
}
