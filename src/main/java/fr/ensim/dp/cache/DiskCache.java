package fr.ensim.dp.cache;

import fr.ensim.dp.util.FileUtil;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class DiskCache implements ICache{

    static private HashMap<String, DiskCache> map = new HashMap<>();
    private File dirCache;


    private DiskCache (String naneMap) {
        dirCache = new File("H:\\Home\\Documents\\IdeaProjects\\tp1v3-dp-squelette-maven\\carte", naneMap);
        dirCache.mkdir();
        System.out.println(dirCache.getAbsolutePath());
    }

    public static DiskCache getInstance(String nameMap) {
        if (!map.containsKey(nameMap))
            map.put(nameMap, new DiskCache(nameMap));
        return map.get(nameMap);
    }

    @Override
    public long size() {
        return FileUtil.dirLength(dirCache);
    }

    @Override
    public boolean add(String key, byte[] buf) {
        File file = new File(dirCache, key);
        return FileUtil.copy(new ByteArrayInputStream(buf), file);
    }

    @Override
    public byte[] retreive(String key) {
        File file = new File(dirCache, key);
        try {
            return FileUtil.readFile(file);
        } catch (IOException e) {
            System.err.println(e);
            return null;
        }
    }

    @Override
    public void clear() {
        System.out.println("clear " +dirCache.getAbsolutePath());
        FileUtil.deleteDirectory(dirCache);
    }

    public static void main(String[] args) {
        DiskCache.getInstance("azaerty");
    }
}
