package repository;

import entity.Carrera;
import entity.Estudiante;
import entity.EstudianteCarrera;

import java.util.List;

public interface EstudianteCarreraRepository {
    EstudianteCarrera getEstudianteCarrera(Estudiante estudiante, Carrera carrera);
    List<EstudianteCarrera> getEstudiantesCarreras();
    void addEstudianteCarrera(EstudianteCarrera estudianteCarrera);
    void updateCarrera(EstudianteCarrera estudianteCarrera);
    void deleteCarrera(Estudiante estudiante, Carrera carrera);
    List<Estudiante>getEstudiantesByCarreraFiltroCiudad(Carrera carrera, String ciudad);
    List<Carrera>getCarrerasInscriptosOrdenadas();
}
