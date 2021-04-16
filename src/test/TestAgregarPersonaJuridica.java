package test;


import negocio.ClienteABM;

public class TestAgregarPersonaJuridica {
	public static void main(String[] args) {
		
		// variables
			String nroCliente = "8899999";
			String razonSocial = "razonSocial889999";
			String cuit = "cuit889999";
		// variables
		
			
		ClienteABM abmCliente =ClienteABM.getInstance();
		int id = abmCliente.agregarPersonaJuridica(nroCliente, razonSocial, cuit);
		System.out.println("agregado: "+ abmCliente.traer(id));
		
		

	}
}
