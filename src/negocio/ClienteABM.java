package negocio;

import java.util.List;

import dao.ClienteDao;
import datos.Cliente;
import datos.PersonaFisica;
import datos.PersonaJuridica;

public class ClienteABM {
	private static ClienteABM instancia = null;// Patrón Singleton
//	private static ClienteDao instanciaDao = null;// Patrón Singleton

	protected ClienteABM() {
	}

//	public static ClienteDao getInstance() {
//		if (instanciaDao == null)
//			instanciaDao = new ClienteDao();
//		return instanciaDao;
//	}
	public static ClienteABM getInstance() {
		if (instancia == null)
			instancia = new ClienteABM();
		return instancia;
	}

	public Cliente traer(int idCliente) {
		return ClienteDao.getInstance().traer(idCliente);
	}

	// ------------------------alan---------------------------------------
	public Cliente traerNroCliente(String nroCliente) {
		return ClienteDao.getInstance().traerNroCliente(nroCliente);
	}
	public Cliente traerDNI(int dni) {
		return ClienteDao.getInstance().traerDNI(dni);
	}
	public Cliente traerCUIT(String cuit) {
		return ClienteDao.getInstance().traerCUIT(cuit);
	}
	
	
	public int agregarPersonaFisica(String nroCliente, String apellido, String nombre, int dni) throws Exception {
		String mensajeException;
		// validacion que no exista ningun cliente con el mismo nroCliente o una
		// personafisica con el mismo DNI
		if (ClienteDao.getInstance().traerNroCliente(nroCliente) != null) {
			mensajeException = "Ya existe un cliente con ese nroCliente(" + nroCliente + ")  en la base de datos";
			throw new Exception(mensajeException);
		}
		if (ClienteDao.getInstance().traerDNI(dni) != null) {
			mensajeException = "Ya existe un cliente con ese DNI(" + dni + ") en la base de datos";
			throw new Exception(mensajeException);
		}
		
		return ClienteDao.getInstance().agregar(new PersonaFisica(nroCliente, apellido, nombre, dni));
	}
	
	public int agregarPersonaJuridica(String nroCliente, String razonSocial, String cuit) throws Exception {
		String mensajeException;
		// validacion que no exista ningun cliente con el mismo nroCliente o una
		// personajuridica con el mismo cuit
		if (ClienteDao.getInstance().traerNroCliente(nroCliente) != null) {
			mensajeException = "Ya existe un cliente con ese nroCliente(" + nroCliente + ")  en la base de datos";
			throw new Exception(mensajeException);
		}
		if (ClienteDao.getInstance().traerCUIT(cuit) != null) {
			mensajeException = "Ya existe un cliente con ese Cuit(" + cuit + ") en la base de datos";
			throw new Exception(mensajeException);
		}

		return ClienteDao.getInstance().agregar(new PersonaJuridica(nroCliente, razonSocial, cuit));
	}
	// ------------------------alan---------------------------------------

	public List<Cliente> traer() {
		return ClienteDao.getInstance().traer();
	}
}




