package fr.ensim.dp.cache.filter;

import fr.ensim.dp.cache.MemoryCache;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountFilterCacheTest {

    @Test
    void doAdd() {

        CountFilterCache countFilterCache = new CountFilterCache();

        assertEquals(0, CountFilterCache.getCountDoAdd());


        final byte[] buf = {1, 2, 'A', 'R', 9};
        final String key = "key1";

        byte[] bufFilter = countFilterCache.doAdd(key, buf);

        assertEquals(1, CountFilterCache.getCountDoAdd());
    }

    @Test
    void doRetreive() {
        CountFilterCache countFilterCache = new CountFilterCache();

        final byte[] buf = {1, 2, 'A', 'R', 9};
        final String key = "key1";

        assertEquals(0, CountFilterCache.getCountDoRetreive());

        byte[] bufFilter = countFilterCache.doRetreive(key, buf);

        assertEquals(1, CountFilterCache.getCountDoRetreive());
    }
}