package negocio;

import java.util.ArrayList;
import java.util.Iterator;
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

	ClienteDao dao = ClienteDao.getInstance();

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

	public Cliente traer(int idCliente) throws Exception {
		if (dao.traer(idCliente) == null) {
			throw new Exception("El idCliente (" + idCliente + ") no corresponde a un Cliente");
		}
		return ClienteDao.getInstance().traer(idCliente);
	}

	// ------------------------alan---------------------------------------
	public Cliente traerNroCliente(String nroCliente) throws Exception {
		if (dao.traerCUIT(nroCliente) == null) {
			throw new Exception("El nroCliente (" + nroCliente + ") no corresponde a un Cliente");
		}
		return dao.traerNroCliente(nroCliente);
	}

	public Cliente traerDNI(int dni) throws Exception {
		if (dao.traerDNI(dni) instanceof PersonaFisica == false || dao.traerDNI(dni) == null) {
			throw new Exception("El dni (" + dni + ") no corresponde a una Persona Fisica");
		}
		return dao.traerDNI(dni);
	}

	public Cliente traerCUIT(String cuit) throws Exception {
		if (dao.traerCUIT(cuit) instanceof PersonaJuridica == false || dao.traerCUIT(cuit) == null) {
			throw new Exception("El cuit (" + cuit + ") no corresponde a una Persona Juridica");
		}
		return dao.traerCUIT(cuit);
	}

	public int agregarPersonaFisica(String nroCliente, String apellido, String nombre, int dni) throws Exception {
		String mensajeException;
		// validacion que no exista ningun cliente con el mismo nroCliente o una
		// personafisica con el mismo DNI
		if (dao.traerNroCliente(nroCliente) != null) {
			mensajeException = "Ya existe un cliente con ese nroCliente(" + nroCliente + ")  en la base de datos";
			throw new Exception(mensajeException);
		}
		if (dao.traerDNI(dni) != null) {
			mensajeException = "Ya existe un cliente con ese DNI(" + dni + ") en la base de datos";
			throw new Exception(mensajeException);
		}

		return dao.agregar(new PersonaFisica(nroCliente, apellido, nombre, dni));
	}

	public int agregarPersonaJuridica(String nroCliente, String razonSocial, String cuit) throws Exception {
		String mensajeException;
		// validacion que no exista ningun cliente con el mismo nroCliente o una
		// personajuridica con el mismo cuit
		if (dao.traerNroCliente(nroCliente) != null) {
			mensajeException = "Ya existe un cliente con ese nroCliente(" + nroCliente + ")  en la base de datos";
			throw new Exception(mensajeException);
		}
		if (dao.traerCUIT(cuit) != null) {
			mensajeException = "Ya existe un cliente con ese Cuit(" + cuit + ") en la base de datos";
			throw new Exception(mensajeException);
		}

		return dao.agregar(new PersonaJuridica(nroCliente, razonSocial, cuit));
	}
	// ------------------------alan---------------------------------------

	public List<PersonaFisica> traerPersonasFisicas() {

		List<Cliente> listaCliente = dao.traer();
		List<PersonaFisica> lista = new ArrayList<PersonaFisica>();
		Iterator<Cliente> it = listaCliente.iterator();
		PersonaFisica p = new PersonaFisica();
		Cliente c;

		while (it.hasNext()) {
			c = it.next();
			if (c instanceof PersonaFisica) {
				p = (PersonaFisica) c;
				lista.add(p);
			}
		}

		return lista;
	}

	public List<PersonaJuridica> traerPersonasJuridicas() {

		List<Cliente> listaCliente = dao.traer();
		List<PersonaJuridica> lista = new ArrayList<PersonaJuridica>();
		Iterator<Cliente> it = listaCliente.iterator();
		PersonaJuridica p = new PersonaJuridica();
		Cliente c;

		while (it.hasNext()) {
			c = it.next();
			if (c instanceof PersonaJuridica) {
				p = (PersonaJuridica) c;
				lista.add(p);
			}
		}

		return lista;
	}

	public void modificarPersonaJuridica(PersonaJuridica p, String cuit) throws Exception {
		Cliente c = dao.traerCUIT(cuit);
		
		if (c != null) { // no existe un cliente con ese cuit

			throw new Exception(
					"No se pudo modificar debido a que ese CUIT (" + cuit + ") ya existe en la Base de Datos");
		}
		p.setCuit(cuit);
		dao.actualizar(p);
	}

//	public void eliminar(long idCliente) {
//		Cliente c = dao.traer(idCliente);
//		dao.eliminar(c);
//	}
}
