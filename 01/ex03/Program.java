import java.util.UUID;

public class Program {
    public static void main(String[] av) {
        TransactionsList transactionsList = new TransactionsLinkedList();
        System.out.println(transactionsList.toString());
        User sender = new User("John", 10);
        User recipient = new User("Bill", 20);
        System.out.println();
        Transaction transaction = new Transaction(recipient, sender, TransferCategory.DEBITS, 100);
        System.out.println(transaction.toString());

        transactionsList.addTransaction(transaction);
        System.out.println(transactionsList.toString());
        System.out.println();

        Transaction transaction2 = new Transaction(recipient, sender, TransferCategory.CREDITS, -100);
        Transaction transaction3 = new Transaction(recipient, sender, TransferCategory.CREDITS, -1);
        Transaction transaction4 = new Transaction(recipient, sender, TransferCategory.CREDITS, -11231);
        Transaction transaction5 = new Transaction(recipient, sender, TransferCategory.DEBITS, 10);

        transactionsList.addTransaction(transaction2);
        transactionsList.addTransaction(transaction3);
        transactionsList.addTransaction(transaction4);
        transactionsList.addTransaction(transaction5);
        System.out.println(transactionsList.toString());
        System.out.println();
        System.out.println("---Print all transactions in list---");
        System.out.println("---Using return of toArray()---");
        System.out.println();
        Transaction[] transactionArray = transactionsList.toArray();
        for (int i = 0; i < transactionArray.length; i++)
        {
            System.out.println(transactionArray[i]);
        }
        System.out.println("---Remove transaction by id---");
        System.out.println();
        System.out.println(transaction4);
        System.out.println();
        transactionsList.removeTransactionById(transaction4.getId());
        System.out.println(transactionsList.toString());
        System.out.println();
        transactionArray = transactionsList.toArray();
        for (int i = 0; i < transactionArray.length; i++)
        {
            System.out.println(transactionArray[i]);
        }
        System.out.println();
        System.out.println("---Remove transaction by id---");
        System.out.println();
        System.out.println(transaction3);
        System.out.println();
        transactionsList.removeTransactionById(transaction3.getId());
        System.out.println(transactionsList.toString());
        System.out.println();
        transactionArray = transactionsList.toArray();
        for (int i = 0; i < transactionArray.length; i++)
        {
            System.out.println(transactionArray[i]);
        }
        System.out.println();
        System.out.println("---Attempt to emove non existent transaction by id---");
        System.out.println();
        try {
            transactionsList.removeTransactionById(UUID.randomUUID());
        } catch (TransactionNotFoundException ex) {
            System.out.println(ex);
        }
    }
}