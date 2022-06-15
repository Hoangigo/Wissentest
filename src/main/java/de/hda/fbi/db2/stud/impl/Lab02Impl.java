package de.hda.fbi.db2.stud.impl;

import de.hda.fbi.db2.api.Lab02EntityManager;
import de.hda.fbi.db2.stud.entity.Category;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Lab02Impl extends Lab02EntityManager {

  private EntityManager em;
  private Lab01Impl lab01 = new Lab01Impl();

  @Override
  public void init() {
    em = getEntityManager();
  }

  @Override
  public void destroy() {
    em.close();
  }

  @Override
  public void persistData() {
    List<Category> cateList = null;

    try {
      cateList = lab01.getCategories();
    } catch (URISyntaxException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    em.getTransaction().begin();

    for (int i = 0; i < cateList.size(); i++) {
      em.persist(cateList.get(i));
    }

    em.getTransaction().commit();
    em.close();

  }

  @Override
  public EntityManager getEntityManager() {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("fbi-postgresPU");
    EntityManager em = emf.createEntityManager();
    return em;
  }
}
