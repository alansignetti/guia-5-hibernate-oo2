package test;

import negocio.ClienteABM;

public class TestAgregarPersonaFisica {
	
	public static void main(String[] args) {
		
		// variables
			String nroCliente = "99999";
			String apellido = "apellido9999";
			String nombre = "nombre9999";
			int dni= 0;
		// variables
			
			
			ClienteABM abmCliente =ClienteABM.getInstance();
//			PersonaJuridica p = PersonaJuridica;
			int id = abmCliente.agregarPersonaFisica(nroCliente, apellido, nombre, dni);
			System.out.println("agregado: "+ abmCliente.traer(id));
			
		
	}
	
}
