package dd.mhja.exercise2;

import java.util.List;

import javax.persistence.EntityManager;

import dd.mhja.dao.HibUtil;

public class RegionDAO {
	public List<dd.mhja.exercise2.Region> readAllEager() {
        EntityManager em = null;

        try {
            em = HibUtil.getEntityManager();
            String jpql = "SELECT distinct e FROM RegionEx2 e JOIN FETCH e.countries";
            return em.createQuery(jpql, dd.mhja.exercise2.Region.class).getResultList();
        } finally {
            em.close();
        }
    }
}
