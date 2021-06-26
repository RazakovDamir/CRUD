package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

   @PersistenceContext
   private EntityManager em;

   @Override
   public List<User> getAllUsers() {
      CriteriaBuilder cb = em.getCriteriaBuilder();
      CriteriaQuery<User> cq = cb.createQuery(User.class);
      Root<User> rootEntry = cq.from(User.class);
      CriteriaQuery<User> all = cq.select(rootEntry);
      TypedQuery<User> allQuery = em.createQuery(all);
      return allQuery.getResultList();
   }

   @Override
   public void add(User user) {
      em.persist(user);
   }

   @Override
   public void delete(int id) {
      User user = new User();
      user.setId(id);
      em.remove(em.contains(user) ? em : em.merge(user));
   }

   @Override
   public void update(User user) {
      em.merge(user);
   }

   @Override
   public User getById(long id) {
      return em.find(User.class, id);
   }
}
