package test;


import negocio.ClienteABM;

public class TestAgregarPersonaJuridica {
	public static void main(String[] args) {
		
		// variables
			String nroCliente = "99999";
			String razonSocial = "razonSocial111";
			String cuit = "99999";
		// variables
		
			
		ClienteABM abmCliente =ClienteABM.getInstance();
		int id;
		try {
			id = abmCliente.agregarPersonaJuridica(nroCliente, razonSocial, cuit);
			System.out.println("Agregado: "+ abmCliente.traer(id));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		

	}
}
