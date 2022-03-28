package fr.ensim.dp.cache;

import java.util.HashMap;
import java.util.Map;

public class MemoryCache implements ICache {

    private HashMap<String, byte[]> cache = new HashMap();
    private static MemoryCache singleton = new MemoryCache();

    public static MemoryCache getInstance(){ return singleton; }

    @Override
    public long size() {
        return cache.values().stream().mapToLong(data -> data.length).sum();
    }

    @Override
    public boolean add(String key, byte[] buf) {
        if (this.retreive(key) == null) {
            cache.put(key, buf);
            return true;
        }
        return false;
    }

    @Override
    public byte[] retreive(String key) {
        return cache.get(key);
    }

    @Override
    public void clear() { cache.clear(); }
}
