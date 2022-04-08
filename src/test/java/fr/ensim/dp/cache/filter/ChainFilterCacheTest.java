package fr.ensim.dp.cache.filter;

import fr.ensim.dp.cache.MemoryCache;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ChainFilterCacheTest {


    @Test
    void doRetreive() {
        CountFilterCache countFilterCache = new CountFilterCache();
        countFilterCache
                .setNext(new CompressFilterCache())
                .setNext(new EncryptFilterCache())
                .setNext(new LogFilterCache());
        final byte[] buf = {1, 2, 'A', 'R', 9};
        final String key = "key1";

        assertEquals(0, CountFilterCache.getCountDoAdd());
        assertEquals(0, CountFilterCache.getCountDoRetreive());

        byte[] bufInput = countFilterCache.doAdd(key, buf);
        System.out.println(Arrays.toString(bufInput));
        byte[] bufOutput = countFilterCache.doRetreive(key, bufInput);
        System.out.println(Arrays.toString(bufOutput));

        assertArrayEquals(buf, bufOutput);
    }

}