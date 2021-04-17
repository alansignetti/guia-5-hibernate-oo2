package test;


import negocio.ClienteABM;

public class TestAgregarPersonaJuridica {
	public static void main(String[] args) {
		
		// variables
			String nroCliente = "11123";
			String razonSocial = "razonSocial111";
			String cuit = "cuit111";
		// variables
		
			
		ClienteABM abmCliente =ClienteABM.getInstance();
		int id;
		try {
			id = abmCliente.agregarPersonaJuridica(nroCliente, razonSocial, cuit);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		

	}
}
