package ex03;
import java.util.UUID;

public class TransactionsLinkedList implements TransactionsList {
    private Node list;
    private int count;
    private void linkNodes(Node prev, Node next) {
        prev.next = next;
        next.prev = prev;
    }

    public TransactionsLinkedList() {
        list = new Node();
        list.next = list;
        list.prev = list;
        count = 0;
    }
    @Override
    public void addTransaction(Transaction t) {
        Node nodeToInsert = new Node();
        nodeToInsert.data = t;
        Node lastNode = list.prev;
        linkNodes(lastNode, nodeToInsert);
        linkNodes(nodeToInsert, list);
        count++;
    }
    @Override
    public void removeTransactionById(UUID id) throws TransactionNotFoundException {
        Node current = list.next;
        while (current != list)
        {
            if (current.data.getId().equals(id))
            {
                linkNodes(current.prev, current.next);
                count--;
                return;
            }
            current = current.next;
        }
        throw new TransactionNotFoundException();
    }

    @Override
    public Transaction[] toArray() {
        Transaction[] transactionArray = new Transaction[count];
        Node current = list.next;
        int arrayIndex = 0;
        while (current != list)
        {
            transactionArray[arrayIndex] = current.data;
            arrayIndex++;
            current = current.next;
        }
        return transactionArray;
    }

    @Override
    public String toString() {
        String lineOne = "---TransactionLinkedList object---\n";
        String lineTwo = "Transactions count: " + count;
        return lineOne + lineTwo;
    }

}
