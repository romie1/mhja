package dd.mhja.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibUtil {
	private static EntityManagerFactory factory;

    static {
        try {
            factory = Persistence.createEntityManagerFactory("hr");
        } catch (Throwable th) {
            throw new IllegalStateException("Can't create EntityManagerFactory", th);
        }
    }
    
    private HibUtil() {}
    
    public static EntityManager getEntityManager() {
        return factory.createEntityManager();
    }
}
