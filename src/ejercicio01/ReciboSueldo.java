package ejercicio01;

import java.time.Month;

public class ReciboSueldo {
	
	protected Long numero;
	protected Month mes;
	protected Double total;
	protected Empleado empleado;
	
	protected static long ultimoId = 1;
	
	public ReciboSueldo(Month mes, Double total, Empleado empleado) {
		this.numero = ultimoId;
		this.mes = mes;
		this.total = total;
		this.empleado = empleado;
		
		ultimoId++;
	}

}
