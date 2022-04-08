package fr.ensim.dp.cache.filter;

import java.io.IOException;
import java.util.logging.Logger;

public class LogFilterCache implements IFilterCache{

    private IFilterCache next;

    private static Logger logger = Logger.getLogger(LogFilterCache.class.getName());

    @Override
    public byte[] doAdd(String key, byte[] buf) {
        logger.info("doAdd");
        try {
            return next != null ? next.doAdd(key, buf) : buf;
        } catch (IOException e) {
            logger.warning(e.getMessage());
        }
        return buf;
    }

    @Override
    public byte[] doRetreive(String key, byte[] buf) {
        logger.info("doRetreive");
        try {
            return next != null ? next.doRetreive(key, buf) : buf;
        } catch (Exception e) {
            logger.warning(e.getMessage());
        }
        return buf;
    }

    @Override
    public IFilterCache setNext(IFilterCache next) {
        this.next = next;
        return this.next;
    }
}
