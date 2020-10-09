package dd.mhja.exercise1;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dd.mhja.dao.HibUtil;

public class ClientDAO {
	static final Logger LOG = LoggerFactory.getLogger(ClientDAO.class);
	public ClientDAO() {
	}

	public List<Client> getAll() {
		EntityManager em = HibUtil.getEntityManager();
		try {
			return em.createQuery("FROM Client C", Client.class).getResultList();
		} finally {
			em.close();
		}
	}

	public Optional<Client> get(int id) {
		EntityManager em = HibUtil.getEntityManager();
		try {
			return Optional.ofNullable(em.find(Client.class, id));
		} finally {
			em.close();
		}
	}
	
	public boolean create(Client client) {
        EntityManager em = HibUtil.getEntityManager();

        try {
            LOG.trace("enter create method");
            EntityTransaction et = em.getTransaction();
            et.begin();
            em.persist(client);
            et.commit();
            return true;
        } catch (Exception ex) {
            LOG.warn("Can't persist entity", ex);
            return false;
        } finally {
            em.close();
        }
    }
	
	public boolean update(Client client) {
        EntityManager em = null;

        try {
            em = HibUtil.getEntityManager();
            EntityTransaction et = em.getTransaction();
            et.begin();
            em.merge(client);
            et.commit();
            return true;
        } catch (Exception ex) {
            LOG.warn("Can't merge client", ex);
            return false;
        } finally {
            em.close();
        }
    }
	
	public boolean delete(int id) {
        EntityManager em = null;

        try {
            em = HibUtil.getEntityManager();
            EntityTransaction et = em.getTransaction();
            et.begin();
            Client client = em.find(Client.class, id);
            if (client != null) {
                em.remove(client);
                et.commit();
                return true;
            } else {
                LOG.info("Can't remove missing client " + id);
                et.rollback();
                return false;
            }
        } catch (Exception ex) {
            LOG.warn("Can't remove client " + id, ex);
            return false;
        } finally {
            em.close();
        }
    }
}
