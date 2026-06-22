public class CleanerThread implements Runnable {

    private LRUCache cache;

    public CleanerThread(LRUCache cache) {
        this.cache = cache;
    }

    @Override
    public void run() {

        while (true) {

            try {

                Thread.sleep(5000);

                cache.removeExpired();

            } catch (InterruptedException e) {

                e.printStackTrace();
            }
        }
    }
}