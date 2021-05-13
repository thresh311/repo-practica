package ejercicio01;

import java.time.*;
import java.util.ArrayList;

public abstract class Empleado {
		protected Long cuit;
		protected String nombre;
		protected LocalDate fechaNacimiento;
		protected String email;
		protected ArrayList<Venta> ventas;
		
		
		public abstract double calcularSueldo();
		
}
