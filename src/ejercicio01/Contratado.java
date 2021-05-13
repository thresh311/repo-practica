package ejercicio01;

import java.time.*;

public class Contratado extends Empleado{
		protected Double costoPorHora;
		protected Integer horasTrabajadas;
		
		public double calcularSueldo() {
			
			if(LocalDate.now().getMonth().equals(fechaNacimiento.getMonth()))
				return costoPorHora * horasTrabajadas +
						this.ventas.stream().filter(v -> v.monto > 10000)
						.count()*10*costoPorHora + 20000;
				
			
			return costoPorHora * horasTrabajadas +
					this.ventas.stream().filter(v -> v.monto > 10000)
					.count()*10*costoPorHora;
		}
		
}
