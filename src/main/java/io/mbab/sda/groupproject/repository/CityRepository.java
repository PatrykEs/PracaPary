package io.mbab.sda.groupproject.repository;

import io.mbab.sda.groupproject.entity.City;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import java.util.List;

@RequiredArgsConstructor
public class CityRepository implements CrudRepository<Cd, Integer> {

  private final EntityManager em;

  @Override
  public List<Cd> getAll() {
    return em.createQuery("FROM City", Cd.class)
            .getResultList();
  }

  @Override
  public Cd findById(Integer id) {
    return null;
  }

  @Override
  public Cd create(Cd entity) {
    em.getTransaction().begin();
    em.persist(entity);
    em.getTransaction().commit();
    return entity;
  }

  @Override
  public Cdupdate(Cd entity) {
    return null;
  }

  @Override
  public void delete(Integer o) {}
}
