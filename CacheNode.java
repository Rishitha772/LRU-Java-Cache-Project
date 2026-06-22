import java.io.Serializable;

public class CacheNode implements Serializable {

     private static final long serialVersionUID = 1L;

    String key;
    String value;

    long expiryTime;

    CacheNode prev;
    CacheNode next;

    public CacheNode(String key, String value, long ttl) {
        this.key = key;
        this.value = value;
        this.expiryTime = System.currentTimeMillis() + ttl;
    }
}