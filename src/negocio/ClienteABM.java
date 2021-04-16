package negocio;

import java.util.List;

import dao.ClienteDao;
import datos.Cliente;
import datos.PersonaFisica;
import datos.PersonaJuridica;

public class ClienteABM {
	private static ClienteABM instancia = null;// Patrón Singleton

	protected ClienteABM() {
	}

	public static ClienteABM getInstance() {
		if (instancia == null)
			instancia = new ClienteABM();
		return instancia;
	}

	public int agregarPersonaFisica(String nroCliente, String apellido, String nombre, int dni) {
		return ClienteDao.getInstance().agregar(new PersonaFisica(nroCliente, apellido, nombre, dni));
	}

	public int agregarPersonaJuridica(String nroCliente, String razonSocial, String cuit) {
		return ClienteDao.getInstance().agregar(new PersonaJuridica(nroCliente, razonSocial, cuit));
	}

////
//	public boolean agregarPersonaJuridica(String nombre, String apellido, long dni, int sueldoBase) {
//		boolean devolver = false;
//		Persona p=this.traerPersona(dni);
//		int id=1;
//		if (lstPersonas.size()!=0) {
//			id=lstPersonas.get(lstPersonas.size()-1).getIdPersona()+1;
//		}

	public Cliente traer(int idCliente) {
		return ClienteDao.getInstance().traer(idCliente);
	}

	public List<Cliente> traer() {
		return ClienteDao.getInstance().traer();
	}
}
