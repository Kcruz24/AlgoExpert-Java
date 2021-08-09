package LRUCache;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class LRUCache
{
    // the prefix 'm' stands for member. This is to designate a naming convention for better readability.
    private final HashMap<String, Integer> m_keyValueCache = new LinkedHashMap<>();
    private int maxSize;

    public LRUCache(int maxSize) {
        this.maxSize = Math.max(maxSize, 1);
    }

    public void insertKeyValuePair(String key, int value) {
        // Write your code here.
        m_keyValueCache.put(key, value);
    }

    public int getValueFromKey(String key) {
        // Write your code here.

        return m_keyValueCache.get(key);
    }

    public String getMostRecentKey() {
        // Write your code here.
        String mostRecentKey;

        mostRecentKey = (String) m_keyValueCache.keySet().toArray()[maxSize - 1];

        return mostRecentKey;
    }

    @Override
    public String toString() {
        return "LRUCache:\n" +
                "   m_keyValueCache: " + m_keyValueCache;
    }
}
