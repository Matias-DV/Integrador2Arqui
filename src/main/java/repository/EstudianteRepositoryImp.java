package repository;

import entity.Carrera;
import entity.Estudiante;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import javax.swing.text.html.parser.Entity;
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
        return List.of();
    }

    @Override
    public void addEstudiante(Estudiante estudiante) {

    }

    @Override
    public void updateEstudiante(Estudiante estudiante) {

    }

    @Override
    public void deleteEstudiante(Estudiante estudiante) {

    }
}
