package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import metier.entities.Livre;
import util.JPAutil;

public class LivreDaoImpl implements ILivreDao {
    
    private EntityManager entityManager = JPAutil.getEntityManager("TPDV5_JEE");
    
    @Override
    public Livre save(Livre l) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(l);
        tx.commit();
        return l;
    }
    
    @Override
    public List<Livre> livresParMC(String mc) {
        List<Livre> livres = entityManager.createQuery("select l from Livre l where l.titre like :mc or l.auteur like :mc").setParameter("mc", "%" + mc + "%").getResultList();
        return livres;
    }
    
    @Override
    public Livre getLivre(Long id) {
        return entityManager.find(Livre.class, id);
    }
    
    @Override
    public Livre updateLivre(Livre l) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.merge(l);
        tx.commit();
        return l;
    }
    
    @Override
    public void deleteLivre(Long id) {
        Livre livre = entityManager.find(Livre.class, id);
        entityManager.getTransaction().begin();
        entityManager.remove(livre);
        entityManager.getTransaction().commit();
    }
}