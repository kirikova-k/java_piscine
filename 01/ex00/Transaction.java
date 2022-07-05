package  ex00;
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
            this.transferAmount = 0;
        }
    }

    public String getId() {
        return identifier.toString();
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

}

enum TransferCategory {
    DEBITS,
    CREDITS
}
