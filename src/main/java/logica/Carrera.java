package logica;

import jakarta.persistence.*;

@Entity
public class Carrera {

    @Id
    @Column(name="ID_Carrera")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String Nombre;

    public Carrera() {

    }

    public Carrera(Long id, String nombre) {
        this.id = id;
        Nombre = nombre;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public Long getId() {
        return id;
    }
}
