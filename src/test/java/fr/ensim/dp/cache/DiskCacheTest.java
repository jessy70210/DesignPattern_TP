package fr.ensim.dp.cache;

import fr.ensim.dp.util.FileUtil;
import org.junit.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DiskCacheTest {


    @Test
    void size() {
        System.out.println("size");

        DiskCache cacheMorte = DiskCache.getInstance("testImages");
        cacheMorte.clear();
        cacheMorte.add("blabla1", new byte[]{0,'A','e'});
        cacheMorte.add("blabla2", new byte[]{5,'p','w'});
        assertEquals(6, cacheMorte.size());
    }

    @Test
    void add() {
        DiskCache cacheMorte = DiskCache.getInstance("testImages");
        cacheMorte.add("blabla1", new byte[]{0,'A','e'});
        cacheMorte.add("blabla2", new byte[]{5,'p','w'});
        assertArrayEquals(new byte[]{0,'A','e'}, cacheMorte.retreive("blabla1"));
        assertArrayEquals(new byte[]{5,'p','w'}, cacheMorte.retreive("blabla2"));
    }

    @Test
    void retreive() {
        DiskCache cacheMorte = DiskCache.getInstance("testImages");
        cacheMorte.add("blabla1", new byte[]{0,'A','e'});
        assertArrayEquals(new byte[]{0,'A','e'}, cacheMorte.retreive("blabla1"));
    }

    @Test
    void clear() {
        DiskCache cacheMorte = DiskCache.getInstance("testImages");
        cacheMorte.add("blabla1", new byte[]{0,'A','e'});
        cacheMorte.add("blabla2", new byte[]{5,'p','w'});
        cacheMorte.clear();
        assertEquals(0, cacheMorte.size());
    }

    @AfterEach
    void afterTest () {
        System.out.println("afterTest");
        DiskCache cacheMorte = DiskCache.getInstance("testImages");
//        File file = new File(FileUtil.userHome(), "testImages");
//        FileUtil.deleteDirectory(file);
    }
}