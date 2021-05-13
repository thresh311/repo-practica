package ejercicio01;

import java.time.LocalDate;

public class EnConvenio extends Empleado {
	
	protected Integer antiguedad;
	protected Double sueldoBasico;
	
	@Override
	public double calcularSueldo() {
		
		if(LocalDate.now().getMonth().equals(fechaNacimiento.getMonth()))
			return sueldoBasico + this.ventas.stream().map(v -> v.monto)
					.reduce(0.0, (acum, e) -> acum+e)*0.15 + 20000;
		
		return sueldoBasico + this.ventas.stream().map(v -> v.monto)
				.reduce(0.0, (acum, e) -> acum+e)*0.15;
	}

}
