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
        CarreraRepositoryImp carreraRepositoryImp = new CarreraRepositoryImp(em);


        List<Estudiante> estudiantes = new ArrayList<>();
        Carrera c10 = new Carrera( "Química");
        estudiantes = estudiantecarreraRepository.getEstudiantesByCarreraFiltroCiudad(c10,"Bahía Blanca");

        for (Estudiante est : estudiantes) {
            System.out.println(est);
        }

        transaction.commit();
        em.close();
        emf.close();
    }
}
