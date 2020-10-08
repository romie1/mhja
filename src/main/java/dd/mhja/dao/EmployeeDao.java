package dd.mhja.dao;

import java.util.List;

import javax.persistence.EntityManager;

public class EmployeeDao extends Dao<Employee, Integer> {
    public EmployeeDao() {
        super(Employee.class);
    }

    public List<Employee> readSalaryRange(double low, double high) {
        EntityManager em = null;

        try {
            em = HibUtil.getEntityManager();
            String jpql = "SELECT e from Employee e where e.salary > ?1 and e.salary < ?2";
            var query = em.createQuery(jpql, Employee.class);
            query.setParameter(1, low);
            query.setParameter(2, high);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public List<Employee> readSalaryTop(double low) {
        EntityManager em = null;

        try {
            em = HibUtil.getEntityManager();
            var query = em.createNamedQuery("getTopSalaried", Employee.class);
            query.setParameter("low", low);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
}
