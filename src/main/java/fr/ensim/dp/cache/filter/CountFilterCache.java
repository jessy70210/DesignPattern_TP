package fr.ensim.dp.cache.filter;

import java.io.IOException;

public class CountFilterCache implements IFilterCache{

    private IFilterCache next;

    private static int countDoAdd = 0;
    private static int countDoRetreive = 0;


    @Override
    public byte[] doAdd(String key, byte[] buf) {
        ++countDoAdd;
        try {
            return next != null ? next.doAdd(key, buf) : buf;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buf;
    }

    @Override
    public byte[] doRetreive(String key, byte[] buf) {
        ++countDoRetreive;
        try {
            return next != null ? next.doRetreive(key, buf) : buf;
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

    public static int getCountDoAdd() {
        return countDoAdd;
    }

    public static int getCountDoRetreive() {
        return countDoRetreive;
    }
}
