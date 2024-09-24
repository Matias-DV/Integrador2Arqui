package repository;

import entity.Carrera;
import entity.Estudiante;
import entity.EstudianteCarrera;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class EstudianteCarreraRepositoryImp implements EstudianteCarreraRepository {
    private EntityManager em;

    public EstudianteCarreraRepositoryImp(EntityManager em) {
        this.em = em;
    }

    @Override
    public EstudianteCarrera getEstudianteCarrera(Estudiante estudiante, Carrera carrera) {
        TypedQuery<EstudianteCarrera> query = em.createQuery("SELECT ec FROM EstudianteCarrera ec WHERE ec.estudiante = :dni AND ec.idCarrera = :ID_Carrera", EstudianteCarrera.class);
        query.setParameter("dni", estudiante.getDni());
        query.setParameter("ID_Carrera", carrera.getId());
        return query.getSingleResult();
    }

    @Override
    public List<EstudianteCarrera> getEstudiantesCarreras() {
        return List.of();
    }

    @Override
    public void addEstudianteCarrera(EstudianteCarrera estudianteCarrera) {

    }

    @Override
    public void updateCarrera(EstudianteCarrera estudianteCarrera) {

    }

    @Override
    public void deleteCarrera(Estudiante estudiante, Carrera carrera) {

    }

    @Override
    public List<Estudiante> getEstudiantesByCarreraFiltroCiudad(Carrera carrera, String ciudad) {
        List<Estudiante> estudiantes = new ArrayList<Estudiante>();
        TypedQuery<Estudiante> query = em.createQuery(
                "SELECT e FROM Estudiante e JOIN EstudianteCarrera ec ON e.dni = ec.estudiante.dni WHERE ec.idCarrera.id = :ID_Carrera AND e.ciudad = :ciudad",
                Estudiante.class);
        query.setParameter("ID_Carrera", carrera.getId());
        query.setParameter("ciudad", ciudad);
        System.out.println(carrera.getId() + " " +ciudad);

        estudiantes = query.getResultList();
        return estudiantes;
    }

    @Override
    public List<Carrera> getCarrerasInscriptosOrdenadas() {
        return List.of();
    }
}