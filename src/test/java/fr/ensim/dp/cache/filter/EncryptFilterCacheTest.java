package fr.ensim.dp.cache.filter;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class EncryptFilterCacheTest {

    @Test
    void doRetreive() {
        EncryptFilterCache encryptFilterCache = new EncryptFilterCache();
        final byte[] buf = {1, 2, 'A', 'R', 9};
        final String key = "key1";

        byte[] bufEncrypt = encryptFilterCache.doAdd(key, buf);
        byte[] bufDecrypt = encryptFilterCache.doRetreive(key, bufEncrypt);
        assertArrayEquals(buf, bufDecrypt);
    }
}