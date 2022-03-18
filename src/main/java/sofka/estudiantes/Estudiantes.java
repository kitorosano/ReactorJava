package sofka.estudiantes;

import java.util.Objects;

import reactor.core.publisher.Flux;

public class Estudiantes {
  
  private Integer idEstudiantes;
  private String nombre;
  private Integer nota;

  public Estudiantes(){};

  public Estudiantes(Integer idEstudiantes, String nombre, Integer nota) {
    this.idEstudiantes = idEstudiantes;
    this.nombre = nombre;
    this.nota = nota;
  }


  public Integer getIdEstudiantes() {
    return this.idEstudiantes;
  }

  public void setIdEstudiantes(Integer idEstudiantes) {
    this.idEstudiantes = idEstudiantes;
  }

  public String getNombre() {
    return this.nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public Integer getNota() {
    return this.nota;
  }

  public void setNota(Integer nota) {
    this.nota = nota;
  }


  @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Estudiantes)) {
            return false;
        }
        Estudiantes estudiantes = (Estudiantes) o;
        return Objects.equals(idEstudiantes, estudiantes.idEstudiantes) && Objects.equals(nombre, estudiantes.nombre) && Objects.equals(nota, estudiantes.nota);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idEstudiantes, nombre, nota);
  }


  @Override
  public String toString() {
    return "{" +
      " idEstudiantes='" + getIdEstudiantes() + "'" +
      ", nombre='" + getNombre() + "'" +
      ", nota='" + getNota() + "'" +
      "}";
  }

  public Flux<Estudiantes> defaultIfEmpty(Estudiantes fluxEstudiantes) {
    return null;
  }

}
