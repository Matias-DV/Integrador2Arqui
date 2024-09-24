package repository;

import entity.Estudiante;

import java.util.List;

public interface EstudianteRepository {

    Estudiante getEstudiante(Estudiante estudiante);
    List<Estudiante> getEstudiantes();
    void addEstudiante(Estudiante estudiante);
    void updateEstudiante(Estudiante estudiante);
    void deleteEstudiante(Estudiante estudiante);
}
