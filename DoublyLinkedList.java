public class DoublyLinkedList {

    CacheNode head;
    CacheNode tail;

    public void addFirst(CacheNode node) {

        if (head == null) {
            head = node;
            tail = node;
            return;
        }

        node.next = head;
        head.prev = node;

        head = node;
    }

    public void removeNode(CacheNode node) {

    if (node == null) {
        return;
    }

    if (node == head) {
        head = head.next;

        if (head != null) {
            head.prev = null;
        }

        return;
    }

    if (node == tail) {
        tail = tail.prev;

        if (tail != null) {
            tail.next = null;
        }

        return;
    }

    node.prev.next = node.next;
    node.next.prev = node.prev;
}

public CacheNode removeLast() {

    if (tail == null) {
        return null;
    }

    CacheNode node = tail;

    if (head == tail) {
        head = null;
        tail = null;
        return node;
    }

    tail = tail.prev;
    tail.next = null;

    return node;
}


}