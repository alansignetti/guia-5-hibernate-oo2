package test;

import negocio.ClienteABM;

public class TestAgregarPersonaFisica {
	
	public static void main(String[] args) {
		
		// variables
			String nroCliente = "111";
			String apellido = "apellido111";
			String nombre = "nombre111";
			int dni=1112 ;
		// variables
			
			
			ClienteABM abmCliente =ClienteABM.getInstance();
//			PersonaJuridica p = PersonaJuridica;
			int id;
			try {
				id = abmCliente.agregarPersonaFisica(nroCliente, apellido, nombre, dni);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}	
		
	}
	
}
