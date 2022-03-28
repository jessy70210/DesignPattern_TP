package fr.ensim.dp.cache;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemoryCacheTest {

    @Test
    void size() {
        MemoryCache cache = new MemoryCache();
        assertEquals(0, cache.size());
        cache.add("http://exemple1.fr", new byte[]{8, 'a', 'b'});
        cache.add("http://exemple2.fr", new byte[]{5, 'd', 'z'});
        assertEquals(6, cache.size());
    }

    @Test
    void add() {
        MemoryCache cache = new MemoryCache();
        cache.add("http://exemple1.fr", new byte[]{0, 'a', 'b'});
        assertEquals(null, cache.retreive("http://exemple2.fr"));
        assertArrayEquals(new byte[]{0, 'a', 'b'}, cache.retreive("http://exemple1.fr"));
    }

    @Test
    void retreive() {
        MemoryCache cache = new MemoryCache();
        cache.add("http://exemple1.fr", new byte[]{0, 'a', 'b'});
        cache.add("http://exemple2.fr", new byte[]{2, 'a', 'b'});
        assertArrayEquals(new byte[]{0, 'a', 'b'}, cache.retreive("http://exemple1.fr"));
    }

    @Test
    void clear() {
        MemoryCache cache = new MemoryCache();

        cache.add("http://exemple1.fr", new byte[]{8, 'a', 'b'});
        cache.add("http://exemple2.fr", new byte[]{5, 'd', 'z'});

        cache.clear();

        assertEquals(0, cache.size());
    }
}