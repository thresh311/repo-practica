package isi.died.parcial01.ejercicio02.app;

import java.util.List;

import ejercicio02.resolucion.FallaAlGuardarException;
import ejercicio02.resolucion.NoCumpleCorrelatividadException;
import isi.died.parcial01.ejercicio02.dominio.*;



public interface MySysAcad {
	
	public void registrarMateria(Materia d);
	
	
	public void registrarDocente(Docente d) ;
	
	
	public void registrarAlumnos(Alumno d);
	/**
	 * crea una nueva instancia de Inscripcion y 
	 * asigna la inscripcion a la lista de inscripciones del alumno, 
	 * de la materia y del docente
	 */
	public void inscribirAlumnoCursada(Docente d,Alumno a, Materia m,Integer cicloLectivo);

	/**
	 * crea una nueva instancia de Inscripcion y 
	 * asigna la inscripcion a la lista de inscripciones del alumno, 
	 * de la materia y del docente
	 * @throws FallaAlGuardarException 
	 * @throws NoCumpleCorrelatividadException 
	 */
	public void inscribirAlumnoExamen(Docente d,Alumno a, Materia m) throws FallaAlGuardarException, NoCumpleCorrelatividadException;
	
	public Double promedio(Integer cilcoLectiv,Materia m);
	
	public List<Examen> buscarExamenesNoAprobados(Docente a, Materia m);
}
