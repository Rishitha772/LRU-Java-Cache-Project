import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class CachePersistence {

    public static void save(CacheNode node) {

        try {

            FileOutputStream file = new FileOutputStream("cache.dat");

            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(node);

            out.close();
            file.close();

            System.out.println("Saved.");

        } catch (Exception e) {e.printStackTrace();
        }
    }

    public static CacheNode load() {

    try {

        FileInputStream file =
                new FileInputStream("cache.dat");

        ObjectInputStream in =
                new ObjectInputStream(file);

        CacheNode node =
                (CacheNode) in.readObject();

        in.close();
        file.close();

        return node;

    } catch (Exception e) {

        return null;
    }
}
}