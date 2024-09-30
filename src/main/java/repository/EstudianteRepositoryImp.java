package repository;

import entity.Estudiante;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class EstudianteRepositoryImp implements EstudianteRepository {
    private EntityManager em;

    public EstudianteRepositoryImp(EntityManager em) {
        this.em = em;
    }

    @Override
    public Estudiante getEstudiante(Estudiante estudiante) {
        TypedQuery<Estudiante> query = em.createQuery("SELECT e FROM Estudiante e WHERE e.dni = :dni", Estudiante.class);
        query.setParameter("dni", estudiante.getDni());
        return query.getSingleResult();
    }

    @Override
    public List<Estudiante> getEstudiantes() {
        List<Estudiante> estudiantes;
        TypedQuery<Estudiante> query = em.createQuery("SELECT e FROM Estudiante e ORDER BY e.apellido ASC", Estudiante.class);
        estudiantes = query.getResultList();
        return estudiantes;
    }

    //Consigna dar de alta un estudiante
    @Override
    public void addEstudiante(Estudiante estudiante) {
        em.persist(estudiante);
    }

    @Override
    public void updateEstudiante(Estudiante estudiante) {
        em.merge(estudiante);
    }

    @Override
    public void deleteEstudiante(Estudiante estudiante) {
        Estudiante est = em.find(Estudiante.class, estudiante);
        if (est != null) {
            em.remove(est);
        }
    }

    @Override
    public Estudiante getEstudianteByLegajo(int legajo) {
        TypedQuery<Estudiante> query = em.createQuery("SELECT e FROM Estudiante e WHERE e.legajo = :legajo", Estudiante.class);
        query.setParameter("legajo", legajo);
        return query.getSingleResult();
    }

    @Override
    public List<Estudiante> getEstudiantesByGenero(String genero) {
        List<Estudiante> estudiantes;
        TypedQuery<Estudiante> query = em.createQuery("SELECT e FROM Estudiante e WHERE e.genero = :genero", Estudiante.class);
        query.setParameter("genero", genero);
        estudiantes = query.getResultList();
        return estudiantes;
    }


}
