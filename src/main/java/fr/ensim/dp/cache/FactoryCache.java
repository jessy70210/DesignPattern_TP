package fr.ensim.dp.cache;

public class FactoryCache {

    private FactoryCache() { }

    public static ICache getInstanceDiskCache (String nameMap) {
        return DiskCache.getInstance(nameMap);
    }

    public static ICache getInstanceMemoryCache () {
        return MemoryCache.getInstance();
    }


}
