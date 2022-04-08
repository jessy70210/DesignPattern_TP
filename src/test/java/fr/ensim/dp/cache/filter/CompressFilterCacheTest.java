package fr.ensim.dp.cache.filter;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CompressFilterCacheTest {

    @Test
    void doRetreive() {
        CompressFilterCache compressFilterCache = new CompressFilterCache();
        final byte[] buf = {1, 2, 'A', 'R', 9};
        final String key = "key1";

        byte[] bufCompress = compressFilterCache.doAdd(key, buf);
        byte[] bufDecompress = compressFilterCache.doRetreive(key, bufCompress);

        assertArrayEquals(buf, bufDecompress);

    }
}