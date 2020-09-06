package io.mbab.sda.groupproject.repository;

import io.mbab.sda.groupproject.entity.Cd;
import io.mbab.sda.groupproject.entity.TrackOnCd;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class CdRepository implements CrudRepository<Cd, Integer> {

  private final EntityManager em;

  @Override
  public List<Cd> getAll() {
    return em.createQuery("FROM Cd", Cd.class).getResultList();
  }

  @Override
  public Cd findById(Integer id) {
    String jpql = "FROM Cd cd  WHERE cd.id = :id";
    return em.createQuery(jpql, Cd.class).setParameter("id", id).getSingleResult();
  }

  @Override
  public Cd create(Cd entity) {
    em.getTransaction().begin();
    em.persist(entity);
    em.getTransaction().commit();
    return entity;
  }

  @Override
  public Cd update(Cd entity) {
    return null;
  }

  @Override
  public void delete(Integer o) {}

  public List<Cd> findByBand(String bandName) {
    String jpql = "FROM Cd cd  WHERE cd.bandName = :bandName";
    return em.createQuery(jpql, Cd.class).setParameter("bandName", bandName).getResultList();
  }
}