package persistence;


import logica.Estudiante;

/*
 * Recibe las peticiones desde la logica(o de donde mandemos) y delega dependiendo del JpaController que estemos usando
 * */
public class ControladoraPersistencia {
    CarreraJPAController carrJPA = new CarreraJPAController();
    EstudianteJPAController EstJPA = new EstudianteJPAController();
    EstudianteCarreraJPAController ecJPA = new EstudianteCarreraJPAController();


    public void crearCarrera() {

    }

    public void eliminarCarrera() {

    }

    public void editarCarrera() {

    }

    public void crearEstudiante() {

    }

    public void eliminarEstudiante() {

    }

    public void editarEstudiante() {

    }
    public void crearEstudianteCarrera() {

    }

    public void eliminarEstudianteCarrera() {

    }

    public void editarEstudianteCarrera() {

    }
}
