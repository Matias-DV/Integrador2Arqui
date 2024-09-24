package entity;

import jakarta.persistence.*;


@Entity
public class EstudianteCarrera {
    @Id
    @ManyToOne
    @JoinColumn(name="dni")
    private Estudiante estudiante;
    @Id
    @ManyToOne
    @JoinColumn(name="ID_Carrera")
    private Carrera idCarrera;
    @Column
    private int antiguedad;
    @Column(nullable = false)
    private Boolean esGraduado;


    public EstudianteCarrera(int antiguedad, Boolean esGraduado) {
        this.antiguedad = antiguedad;
        this.esGraduado = esGraduado;
    }

    public EstudianteCarrera() {

    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public Boolean getEsGraduado() {
        return esGraduado;
    }

    public void setEsGraduado(Boolean esGraduado) {
        this.esGraduado = esGraduado;
    }

    @Override
    public String toString() {
        return "EstudianteCarrera{" +
                "estudiante=" + estudiante +
                ", idCarrera=" + idCarrera +
                ", antiguedad=" + antiguedad +
                ", esGraduado=" + esGraduado +
                '}';
    }
}
