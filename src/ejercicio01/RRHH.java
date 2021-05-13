package ejercicio01;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RRHH {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static List<ReciboSueldo> generarRecibos(ArrayList<Empleado> empleados) {
		return empleados.stream().map(e -> new ReciboSueldo(LocalDate.now().getMonth(), e.calcularSueldo(), e)).collect(Collectors.toList());
	}

}
