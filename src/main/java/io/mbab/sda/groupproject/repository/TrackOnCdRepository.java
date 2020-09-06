package io.mbab.sda.groupproject.repository;

import io.mbab.sda.groupproject.entity.Cd;
import io.mbab.sda.groupproject.entity.TrackOnCd;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import java.util.List;

@RequiredArgsConstructor
public class TrackOnCdRepository implements CrudRepository<TrackOnCd, Integer> {

  private final EntityManager em;

  @Override
  public List<TrackOnCd> getAll() {
    return em.createQuery("FROM TrackOnCd", TrackOnCd.class).getResultList();
  }

  @Override
  public TrackOnCd findById(Integer id) {
    return null;
  }

  @Override
  public TrackOnCd create(TrackOnCd entity) {
    em.getTransaction().begin();
    em.persist(entity);
    em.getTransaction().commit();
    return entity;
  }

  @Override
  public TrackOnCd update(TrackOnCd entity) {
    return null;
  }

  @Override
  public void delete(Integer o) {}

  public List<TrackOnCd> findByCdId(Integer id) {
    String jpql = "FROM TrackOnCd trackOnCd  WHERE cd.id = :id";
    return em.createQuery(jpql, TrackOnCd.class).setParameter("id", id).getResultList();
  }
}
