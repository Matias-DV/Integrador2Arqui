package repository;

import entity.Carrera;
import entity.Estudiante;
import entity.EstudianteCarrera;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class EstudianteCarreraRepositoryImp implements EstudianteCarreraRepository {
    private EntityManager em;

    public EstudianteCarreraRepositoryImp(EntityManager em) {
        this.em = em;
    }

    @Override
    public EstudianteCarrera getEstudianteCarrera(Estudiante estudiante, Carrera carrera) {
        TypedQuery<EstudianteCarrera> query = em.createQuery("SELECT ec FROM EstudianteCarrera ec WHERE ec.estudiante = :dni AND ec.Carrera = :ID_Carrera", EstudianteCarrera.class);
        query.setParameter("dni", estudiante.getDni());
        query.setParameter("ID_Carrera", carrera.getId());
        return query.getSingleResult();
    }

    @Override
    public List<EstudianteCarrera> getEstudiantesCarreras() {
        List<EstudianteCarrera> estudiantes;
        TypedQuery<EstudianteCarrera> query = em.createQuery("SELECT ec FROM EstudianteCarrera ec ",   EstudianteCarrera.class);
        estudiantes = query.getResultList();
        return estudiantes;
    }

    @Override
    public void addEstudianteCarrera(EstudianteCarrera estudianteCarrera) {
        //matricular un estudiante en una carrera (crear relación)
        em.persist(estudianteCarrera);
    }

    @Override
    public void updateCarrera(EstudianteCarrera estudianteCarrera) {
        em.merge(estudianteCarrera);
    }

    @Override
    public void deleteCarrera(Estudiante estudiante, Carrera carrera) {
        Query query = em.createQuery("DELETE FROM EstudianteCarrera ec WHERE ec.estudiante = :estudiante AND ec.Carrera = :carrera");
        query.setParameter("estudiante", estudiante);
        query.setParameter("carrera", carrera);
        query.executeUpdate();
    }

    @Override
    public List<Estudiante> getEstudiantesByCarreraFiltroCiudad(Carrera carrera, String ciudad) {
        List<Estudiante> estudiantes;
        TypedQuery<Estudiante> query = em.createQuery("SELECT e FROM Estudiante e JOIN EstudianteCarrera ec ON e.dni = ec.estudiante.dni WHERE ec.Carrera.id = :ID_Carrera AND e.ciudad = :ciudad", Estudiante.class);
        query.setParameter("ID_Carrera", carrera.getId());
        query.setParameter("ciudad", ciudad);
        estudiantes = query.getResultList();
        return estudiantes;
    }

    @Override
    public List<Carrera> getCarrerasInscriptosOrdenadas() {
        List<Carrera> carreras;
        TypedQuery<Carrera> query = em.createQuery("SELECT c.Nombre, COUNT(ec.Carrera.id) AS cantidad_inscriptos  FROM EstudianteCarrera ec JOIN Carrera c ON ec.Carrera.id = c.id GROUP BY c.id, c.Nombre ORDER BY cantidad_inscriptos DESC", Carrera.class);
        carreras = query.getResultList();
        return carreras;
    }

    @Override
    public List<Carrera> reporteCarreras() {
        List<Carrera> reporte;
        TypedQuery<Carrera> query = em.createQuery("SELECT c.Nombre AS carrera, DATE_SUB(CURDATE(), INTERVAL ec.antiguedad YEAR) AS fecha_calculada COUNT(CASE WHEN ec.esGraduado = false THEN 1 END) AS inscriptos COUNT(CASE WHEN ec.esGraduado = true THEN 1 END) AS egresados FROM EstudianteCarrera ec " +
                " JOIN " +
                "    Carrera c ON ec.Carrera.id = c.id " +
                " GROUP BY " +
                "    c.nombre, ec.antiguedad " +
                " ORDER BY " +
                "    c.nombre ASC, ec.antiguedad ASC", Carrera.class);

        reporte = query.getResultList();
        return reporte;
    }

}