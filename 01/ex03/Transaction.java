import java.util.UUID;

public class Transaction {
    private UUID identifier;
    private User recipient;
    private User sender;
    private TransferCategory transferCategory;
    private int transferAmount;

    public Transaction(User _recipient, User _sender, TransferCategory _category, int _transferAmount) {
        this.identifier = UUID.randomUUID();
        this.recipient = _recipient;
        this.sender = _sender;
        this.transferCategory = _category;
        if (isTransferAmountValid(_transferAmount, _category)){
            this.transferAmount = _transferAmount;
        }
        else {
            transferAmount = 0;
        }
    }

    public UUID getId() {
        return identifier;
    }

    public User getRecipient() {
        return recipient;
    }

    public User getSender() {
        return sender;
    }

    public int getTransferAmount() {
        return transferAmount;
    }

    public String getCategoryName() {
        if (transferCategory == TransferCategory.DEBITS) {
            return "Debits";
        }
        else if (transferCategory == TransferCategory.CREDITS) {
            return "Credits";
        }
        else {
            return "undefined";
        }
    }

    private boolean isTransferAmountValid(int amount, TransferCategory category) {
        if ((category == TransferCategory.CREDITS) && (amount <= 0)) {
            return  true;
        }
        if ((category == TransferCategory.DEBITS) && (amount >= 0)) {
            return  true;
        }
        return false;
    }

    @Override
    public String toString() {
        String lineOne = "---Transaction object--\n";
        String lineTwo = "ID: " + identifier + "\n";
        String lineThree = "Recipient name: " + recipient.getName() + "\n";
        String lineFour = "Sender name: " + sender.getName() + "\n";
        String lineFive = "Category: " + getCategoryName() + "\n";
        String lineSix = "Transfer amount: " + transferAmount + "\n";
        return lineOne + lineTwo + lineThree + lineFour + lineFive + lineSix;
    }
}

enum TransferCategory {
    DEBITS,
    CREDITS
}
