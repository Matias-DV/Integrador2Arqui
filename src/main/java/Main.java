import entity.Carrera;
import entity.Estudiante;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import repository.EstudianteCarreraRepositoryImp;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Integrador2");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction =em.getTransaction();
        em.getTransaction().begin();


        long myLongValue = 1L; // El sufijo 'L' indica que es un literal long

        EstudianteCarreraRepositoryImp ecr = new EstudianteCarreraRepositoryImp(em);
        Carrera carr = new Carrera(myLongValue, "Ingeniería en Sistemas");
        System.out.println(carr.toString());
        ArrayList<Estudiante> estudiantes = (ArrayList<Estudiante>) ecr.getEstudiantesByCarreraFiltroCiudad(carr, "Tandil");
        for(Estudiante est : estudiantes) {
            System.out.println(est.toString());
        }
        transaction.commit();
        em.close();
        emf.close();


    }
}
