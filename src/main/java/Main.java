import entity.Carrera;
import entity.Estudiante;
import entity.EstudianteCarrera;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import repository.CarreraRepositoryImp;
import repository.EstudianteCarreraRepositoryImp;
import repository.EstudianteRepositoryImp;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Integrador2");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction =em.getTransaction();
        em.getTransaction().begin();

        EstudianteCarreraRepositoryImp estudiantecarreraRepository = new EstudianteCarreraRepositoryImp(em);
        EstudianteRepositoryImp estudianteRepository = new EstudianteRepositoryImp(em);

        System.out.println("   ----------------------------------------   ");

        List<Estudiante> estudiantes1 = new ArrayList<>();
        estudiantes1 = estudianteRepository.getEstudiantesByGenero("Masculino");

        for (Estudiante estudiante : estudiantes1) {
            estudiante.toString();
        }

        System.out.println("   ----------------------------------------   ");

        Estudiante estudiantes2 = estudianteRepository.getEstudianteByLegajo(1001);
        estudiantes2.toString();

        System.out.println("   ----------------------------------------   ");

        //Chequear porque solo muestra la consulta sql
        List<Estudiante> estudiantes = new ArrayList<>();
        Carrera c10 = new Carrera( "Química");
        estudiantes = estudiantecarreraRepository.getEstudiantesByCarreraFiltroCiudad(c10,"Bahía Blanca");

        for (Estudiante est : estudiantes) {
            System.out.println(est);
        }

        System.out.println("   ----------------------------------------   ");

        //Chequear este metodo porque no anda
        List<Carrera> carreras = new ArrayList<>();
        carreras = estudiantecarreraRepository.getCarrerasInscriptosOrdenadas();

        for (Carrera c : carreras) {
            System.out.println(c);
        }

        System.out.println("   ----------------------------------------   ");

        //Chequear este metodo porque no anda
        List<Carrera> carreras1 = new ArrayList<>();
        carreras1 = estudiantecarreraRepository.reporteCarreras();

        for (Carrera c : carreras1) {
            System.out.println(c);
        }

        transaction.commit();
        em.close();
        emf.close();
    }
}
