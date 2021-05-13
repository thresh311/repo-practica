package isi.died.parcial01.ejercicio02.app;

import java.util.ArrayList;
import java.util.List;

import ejercicio02.resolucion.FallaAlGuardarException;
import ejercicio02.resolucion.NoCumpleCorrelatividadException;
import isi.died.parcial01.ejercicio02.db.BaseDeDatos;
import isi.died.parcial01.ejercicio02.db.BaseDeDatosExcepcion;
import isi.died.parcial01.ejercicio02.dominio.*;


public class MySysAcadImpl implements MySysAcad {
	private static final BaseDeDatos DB = new BaseDeDatos();


	private List<Materia> materia = new ArrayList<Materia>();
	
	@Override
	public void registrarMateria(Materia d) {
		this.materia.add(d);
	}
	
	private List<Docente> docentes = new ArrayList<Docente>();
	
	@Override
	public void registrarDocente(Docente d) {
		this.docentes.add(d);
	}
	
	private List<Alumno> alumnos = new ArrayList<Alumno>();
	
	@Override
	public void registrarAlumnos(Alumno d) {
		this.alumnos.add(d);
	}
	

	@Override
	public void inscribirAlumnoCursada(Docente d, Alumno a, Materia m, Integer cicloLectivo) {
		Inscripcion insc = new Inscripcion(cicloLectivo,Inscripcion.Estado.CURSANDO);
		d.agregarInscripcion(insc);
		a.addCursada(insc);
		m.addInscripcion(insc);
		// DESCOMENTAR Y gestionar excepcion
		// DB.guardar(insc);
	}

	@Override
	public void inscribirAlumnoExamen(Docente d, Alumno a, Materia m) throws FallaAlGuardarException, NoCumpleCorrelatividadException {
		Examen e = new Examen();
		
		m.puedeRendir(a);
		
		a.addExamen(e);
		d.agregarExamen(e);
		m.addExamen(e);
		
		// DESCOMENTAR Y gestionar excepcion
		try {
			DB.guardar(e);
		} catch (BaseDeDatosExcepcion e1) {
			// TODO Auto-generated catch block
			throw new FallaAlGuardarException();
		}
	}
	

}
