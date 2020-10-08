package dd.mhja.exercise1;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import dd.mhja.dao.HibUtil;

public class ClientDAO {
	
	public ClientDAO() {}
	
	public List<Client> getAll(){
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
		}finally {
            em.close();
        }
	}
	
}
