package isi.died.parcial01.ejercicio02.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Alumno {
	
	private static Integer ID_GENERATOR=0;
	
	private Integer id;
	private String nombre;

	private List<Inscripcion> materiasCursadas;
	private List<Examen> examenes;
	
	public Alumno() {
		this.id = ID_GENERATOR++;
		this.materiasCursadas = new ArrayList<Inscripcion>();
		this.examenes = new ArrayList<Examen>();
	}
	
	
	public Alumno(String nombre) {
		this();
		this.nombre = nombre;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void addExamen(Examen e) {
		this.examenes.add(e);
		e.setAlumno(this);
	}
	
	public void addCursada(Inscripcion e) {
		this.materiasCursadas.add(e);
		e.setInscripto(this);
	}
	
	public List<Examen> getExamenes() {
		return this.examenes;
	}


	public void marcarPromocionada(Materia materia) {
		// TODO Auto-generated method stub
		List<Inscripcion> insMateria = this.materiasCursadas.stream().filter(ins -> ins.getMateria().equals(materia))
				.sorted((i1, i2) -> i1.getCicloLectivo().compareTo(i2.getCicloLectivo())*-1).collect(Collectors.toList());
		
		insMateria.get(0).setEstado(Inscripcion.Estado.PROMOCIONADO);
	}

}
