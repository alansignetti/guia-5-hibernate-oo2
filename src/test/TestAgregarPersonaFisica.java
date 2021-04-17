package test;

import negocio.ClienteABM;

public class TestAgregarPersonaFisica {
	
	public static void main(String[] args) {
		
		// variables
			String nroCliente = "444";
			String apellido = "apellido111";
			String nombre = "nombre111";
			int dni=444 ;
		// variables
			
			
			ClienteABM abmCliente =ClienteABM.getInstance();
//			PersonaJuridica p = PersonaJuridica;
			int id;
			try {
				id = abmCliente.agregarPersonaFisica(nroCliente, apellido, nombre, dni);
				System.out.println("Agregado: "+ abmCliente.traer(id));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}	
		
	}
	
}
