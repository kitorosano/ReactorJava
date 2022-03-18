package reactividad.operadores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.reactivex.Observable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import sofka.estudiantes.Estudiantes;

@SpringBootApplication
public class OperadoresApplication {

  public void reactor(){
    Mono.just(new Estudiantes(1, "Diego", 6))
        // .doOnNext(); //depuracion
        .subscribe();
  }

  public static Flux<Estudiantes> flux(List<Estudiantes> estudiantes){
    return Flux.fromIterable(estudiantes);
  }

  public static void fluxmono(Flux<Estudiantes> flux_estudiantes){    
    flux_estudiantes.collectList();
  }

  // transformacion
  public static Flux<Estudiantes> ejemploMap(Flux<Estudiantes> flux_estudiantes){
    return flux_estudiantes.map(e -> {
      e.setNota(e.getNota() + 10);
      return e;
    });
  }
  
  // filtrado
  public static Flux<Estudiantes> ejemploFiltrado(Flux<Estudiantes> flux_estudiantes){
    return flux_estudiantes.filter(e -> e.getNota() < 0);
  }
  // filtrado
  public static Flux<Estudiantes> ejemploDistinto(Flux<Estudiantes> flux_estudiantes){
    return flux_estudiantes.distinct((e) -> e.getIdEstudiantes());
  }
  
  // combinacion
  public static Flux<Estudiantes> ejemploMerge(Flux<Estudiantes> flux_estudiantes, Flux<Estudiantes> flux_estudiantes2){
    return Flux.merge(flux_estudiantes, flux_estudiantes2);
  }
  
  // condicional
  public static Flux<Estudiantes> ejemploIsEmpty(Flux<Estudiantes> flux_estudiantes){
    return flux_estudiantes.defaultIfEmpty(new Estudiantes(9, "Esteban3", 10));
  }

  // creacion
  public static Flux<Estudiantes> ejemploEmpty(){
    return Flux.empty();
  }


  // public static Flux<Estudiantes> rxjava2(){
  //   Observable.just(new Estudiantes(1, "Diego", 6))
  //             .subscribe();
  // }

	public static void main(String[] args) {
		SpringApplication.run(OperadoresApplication.class, args);

    List<Estudiantes> lista_estudiantes1 = new ArrayList<Estudiantes>(); 
    lista_estudiantes1.add(new Estudiantes(1, "Esteban", 10));
    lista_estudiantes1.add(new Estudiantes(1, "Franco", 0));
    lista_estudiantes1.add(new Estudiantes(3, "Mauricio", -1));
    lista_estudiantes1.add(new Estudiantes(4, "Ignacio", 0));
    
    List<Estudiantes> lista_estudiantes2 = new ArrayList<Estudiantes>(); 
    lista_estudiantes2.add(new Estudiantes(5, "Esteban2", 10));
    lista_estudiantes2.add(new Estudiantes(6, "Franco2", 0));
    lista_estudiantes2.add(new Estudiantes(7, "Mauricio2", -1));
    lista_estudiantes2.add(new Estudiantes(8, "Ignacio2", 0));


    lista_estudiantes1.forEach(e -> System.out.println("\nLista1:\n" + e.toString()));
    // lista_estudiantes2.forEach(e -> System.out.println("\nLista2:\n" + e.toString()));

    Flux<Estudiantes> flux_estudiantes = flux(lista_estudiantes1);
    Flux<Estudiantes> flux_estudiantes2 = flux(lista_estudiantes2);
    Flux<Estudiantes> flux_vacio = ejemploEmpty();

    // Flux<Estudiantes> nuevo_fluxEstudiantes = ejemploMap(flux_estudiantes);
    
    // Flux<Estudiantes> nuevo_fluxEstudiantes = ejemploFiltrado(flux_estudiantes);
    
    // Flux<Estudiantes> nuevo_fluxEstudiantes = ejemploDistinto(flux_estudiantes);

    // Flux<Estudiantes> nuevo_fluxEstudiantes = ejemploMerge(flux_estudiantes, flux_estudiantes2);

    // Flux<Estudiantes> nuevo_fluxEstudiantes = ejemploIsEmpty(flux_estudiantes);
    Flux<Estudiantes> nuevo_fluxEstudiantes = ejemploIsEmpty(flux_vacio);


    System.out.println("\nResultado:\n");
    nuevo_fluxEstudiantes.subscribe(e -> System.out.println(e.toString()));
	}

}
