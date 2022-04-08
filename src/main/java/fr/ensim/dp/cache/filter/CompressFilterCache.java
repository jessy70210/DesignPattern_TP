package fr.ensim.dp.cache.filter;

import fr.ensim.dp.util.GzipUtil;

import java.io.IOException;

public class CompressFilterCache implements IFilterCache{

    private IFilterCache next;

    @Override
    public byte[] doAdd(String key, byte[] buf) {
        try {
            byte[] bufCompress = GzipUtil.compress(buf);
            return next != null ? next.doAdd(key, bufCompress) : bufCompress;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buf;
    }

    @Override
    public byte[] doRetreive(String key, byte[] buf) {
        try {
            return next != null ? GzipUtil.uncompress(next.doRetreive(key, buf)) :  GzipUtil.uncompress(buf);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buf;
    }

    @Override
    public IFilterCache setNext(IFilterCache next) {
        this.next = next;
        return this.next;
    }
}
