package test;

import datos.Cliente;
import datos.PersonaJuridica;
import negocio.ClienteABM;

public class TestModificarPersona {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ClienteABM abmCliente =ClienteABM.getInstance();
		String cuit = "cuit123123";
		String nroCliente = "99999";
		int idCliente =99999;
		int dni =99999;
		
		try {
			PersonaJuridica p =  (PersonaJuridica) abmCliente.traerCUIT(cuit);
			abmCliente.modificarPersonaJuridica(p, "cuit123123");
//			abmCliente.modificarPersonaJuridica(p, cuit);
//			System.out.println(abmCliente.traerCUIT(cuit));
//			System.out.println(abmCliente.traerNroCliente(nroCliente));
//			System.out.println(abmCliente.traer(idCliente));
//			System.out.println(abmCliente.traerDNI(dni));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}

}
