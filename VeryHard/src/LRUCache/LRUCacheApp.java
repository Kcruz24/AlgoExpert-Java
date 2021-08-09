package LRUCache;

public class LRUCacheApp
{
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);

        cache.insertKeyValuePair("b", 2);
        cache.insertKeyValuePair("a", 1);
        cache.insertKeyValuePair("c", 3);

        System.out.println(cache);

        System.out.println("Most recent key: " + cache.getMostRecentKey());
        System.out.println("Value from key: " + cache.getValueFromKey("a"));
        System.out.println("Most recent key: " + cache.getMostRecentKey());
    }
}
