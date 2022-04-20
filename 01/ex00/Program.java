
public class Program {

    public static void main(String[] args) {
        System.out.println("-----------------USER_TESTS-----------------------");
        System.out.println("---Create new user---");
        User userOne = new User("John", 15);
        System.out.println("User name: " + userOne.getName());
        System.out.println("User id: " + userOne.getId());
        System.out.println("User balance: " + userOne.getBalance());
        System.out.println("---Attempt to set correct (balance > 0) balance---");
        userOne.setBalance(10);
        System.out.println("User balance: " + userOne.getBalance());
        System.out.println("---Attempt to set INcorrect (balance < 0) balance---");
        userOne.setBalance(-1);
        System.out.println("User balance: " + userOne.getBalance());
        System.out.println("---Create new user with initial balance less then zero---");
        User userTwo = new User("Kate", -1);
        System.out.println("User name: " + userTwo.getName());
        System.out.println("User id: " + userTwo.getId());
        System.out.println("User balance: " + userTwo.getBalance());
        System.out.println("---Create new user---");
        User userThree = new User("Jack", 1000);
        System.out.println("User name: " + userThree.getName());
        System.out.println("User id: " + userThree.getId());
        System.out.println("User balance: " + userThree.getBalance());
        System.out.println("----------TRANSACTION_TESTS-----------------------");
        System.out.println("---Create debit transaction with positive transfer amount (correct)---");
        Transaction transactionOne = new Transaction(userOne, userTwo, TransferCategory.DEBITS, 10);
        System.out.println("Sender name: " + transactionOne.getSender().getName());
        System.out.println("Recipient name: " + transactionOne.getRecipient().getName());
        System.out.println("Transaction type : " + transactionOne.getCategoryName());
        System.out.println("Transaction id : " + transactionOne.getId());
        System.out.println("Transaction amount : " + transactionOne.getTransferAmount());

        System.out.println("---Create debit transaction with negative transfer amount (INcorrect)---");
        Transaction transactionTwo = new Transaction(userOne, userTwo, TransferCategory.DEBITS, -1);
        System.out.println("Sender name: " + transactionTwo.getSender().getName());
        System.out.println("Recipient name: " + transactionTwo.getRecipient().getName());
        System.out.println("Transaction type : " + transactionTwo.getCategoryName());
        System.out.println("Transaction id : " + transactionTwo.getId());
        System.out.println("Transaction amount : " + transactionTwo.getTransferAmount());

        System.out.println("---Create credit transaction with positive transfer amount (INcorrect)---");
        Transaction transactionThree = new Transaction(userOne, userTwo, TransferCategory.CREDITS, 100);
        System.out.println("Sender name: " + transactionThree.getSender().getName());
        System.out.println("Recipient name: " + transactionThree.getRecipient().getName());
        System.out.println("Transaction type : " + transactionThree.getCategoryName());
        System.out.println("Transaction id : " + transactionThree.getId());
        System.out.println("Transaction amount : " + transactionThree.getTransferAmount());

        System.out.println("---Create credit transaction with negative transfer amount (correct)---");
        Transaction transactionFour = new Transaction(userOne, userTwo, TransferCategory.CREDITS, -100);
        System.out.println("Sender name: " + transactionFour.getSender().getName());
        System.out.println("Recipient name: " + transactionFour.getRecipient().getName());
        System.out.println("Transaction type : " + transactionFour.getCategoryName());
        System.out.println("Transaction id : " + transactionFour.getId());
        System.out.println("Transaction amount : " + transactionFour.getTransferAmount());

    }
}
