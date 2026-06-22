import java.util.ArrayList;
import java.util.HashMap;

public class LRUCache {

    private int capacity;
    private HashMap<String, CacheNode> cache;
    private DoublyLinkedList list;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.list = new DoublyLinkedList();
    }

    public String get(String key) {

        if (!cache.containsKey(key)) {
            return null;
        }

        CacheNode node = cache.get(key);

        // Check whether the item has expired
        if (System.currentTimeMillis() > node.expiryTime) {

            list.removeNode(node);

            cache.remove(key);

            return null;
        }

        // Move recently used item to the front
        list.removeNode(node);

        list.addFirst(node);

        return node.value;
    }

    public void put(String key, String value, long ttl) {

        // If key already exists
        if (cache.containsKey(key)) {

            CacheNode existingNode = cache.get(key);

            existingNode.value = value;

            existingNode.expiryTime =
                    System.currentTimeMillis() + ttl;

            list.removeNode(existingNode);

            list.addFirst(existingNode);

            return;
        }

        // Create a new node
        CacheNode newNode =
                new CacheNode(key, value, ttl);

        cache.put(key, newNode);

        list.addFirst(newNode);

        // Remove least recently used item if cache is full
        if (cache.size() > capacity) {

            CacheNode removed =
                    list.removeLast();

            cache.remove(removed.key);
        }
    }

    public void removeExpired() {

    ArrayList<String> expiredKeys =
            new ArrayList<>();

    for (String key : cache.keySet()) {

        CacheNode node = cache.get(key);

        if (System.currentTimeMillis() >
                node.expiryTime) {

            expiredKeys.add(key);
        }
    }

    for (String key : expiredKeys) {

        CacheNode node = cache.get(key);

        list.removeNode(node);

        cache.remove(key);

        System.out.println(key + " removed.");
    }
  }
  public CacheNode getNode(String key) {

    return cache.get(key);
}
}