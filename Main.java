public class Main {

    public static void main(String[] args) {

        CacheNode node = CachePersistence.load();

        if (node != null) {

            System.out.println(node.key);

            System.out.println(node.value);

        } else {

            System.out.println("No data found.");
        }
    }
}