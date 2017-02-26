package utils;

import antlr.collections.List;
import beans.Page;
import beans.Site;
import entities.PageEntity;
import entities.SiteEntity;
import org.apache.log4j.Logger;

public class EntityCopyUtil {
    private static final String CREATE_AND_COPY_FIELDS_ERROR = "Create And Copy Fields Error";

    private static Logger logger = Logger.getLogger(EntityCopyUtil.class);

    private EntityCopyUtil() {
        /* static class */
    }

    public static <D, S> D createAndCopyFields(Class<D> destionationClass, S source) {
        try {
            D destination = destionationClass.newInstance();
            CopyUtil.copyFields(destination, source, new CopySetting[]{new CopySetting(SiteEntity.class, Site.class),
                    new CopySetting(PageEntity.class, Page.class), new CopySetting(Page.class, PageEntity.class),
                    new CopySetting(Site.class, SiteEntity.class)}, new Class<?>[]{List.class}, 3);

            return destination;
        } catch (Exception e) {
            logger.error(CREATE_AND_COPY_FIELDS_ERROR, e);

            throw new UtilException(e);
        }
    }
}
