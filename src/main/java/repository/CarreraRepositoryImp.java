package repository;

import entity.Carrera;
import entity.Estudiante;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class CarreraRepositoryImp implements CarreraRepository {
    private EntityManager em;

    public CarreraRepositoryImp(EntityManager em) {
        this.em = em;
    }

    @Override
    public Carrera getCarrera(Carrera carrera) {
        TypedQuery<Carrera> query = em.createQuery("SELECT c FROM Carrera c WHERE c.id = :id", Carrera.class);
        query.setParameter("id", carrera.getId());
        return query.getSingleResult();
    }

    @Override
    public List<Carrera> getCarreras() {
        return List.of();
    }

    @Override
    public void addCarrera(Carrera carrera) {

    }

    @Override
    public void updateCarrera(Carrera carrera) {

    }

    @Override
    public void deleteCarrera(Long carrera) {

    }
}