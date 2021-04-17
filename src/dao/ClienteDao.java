package dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Cliente;

public class ClienteDao {
	private static Session session;
	private Transaction tx;
	private static ClienteDao instancia = null; // Patrón Singleton

	protected ClienteDao() {
	}

	public static ClienteDao getInstance() {
		if (instancia == null)
			instancia = new ClienteDao();
		return instancia;
	}

	protected void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	protected void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}
	
	public int agregar(Cliente objeto) {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(objeto).toString());
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
		return id;
	}

	public Cliente traer(int idCliente) {
		Cliente objeto = null;
		try {
			iniciaOperacion();
			objeto = (Cliente) session.createQuery("from Cliente c where c.idCliente =" + idCliente).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}
	
	
	// -------------------------------------------------------------------
	// -------------------------------------------------------------------
	// -------------------------------------------------------------------
	// -------------------------------------------------------------------
	// -------------------------------------------------------------------
	// -------------------------------------------------------------------
	// -------------------------------------------------------------------
	// ------------------------alan---------------------------------------
	public Cliente traerNroCliente(String nroCliente) {
		Cliente objeto = null;
		try {
			iniciaOperacion();
			objeto = (Cliente) session.createQuery("from Cliente c where c.nroCliente =" + nroCliente).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}
	
		public Cliente traerCUIT(String cuit) {
			Cliente objeto = null;
			try {
				iniciaOperacion();
				objeto = (Cliente) session.createQuery("from Cliente c where c.cuit = '" + cuit+"'").uniqueResult();
			} finally {
				session.close();
			}
			return objeto;
		}
		
		public Cliente traerDNI(int dni) {
			Cliente objeto = null;
			try {
				iniciaOperacion();
				objeto = (Cliente) session.createQuery("from Cliente c where c.dni =" + dni).uniqueResult();
			} finally {
				session.close();
			}
			return objeto;
		}
	// ------------------------alan---------------------------------------
	// -------------------------------------------------------------------
	// -------------------------------------------------------------------
	// -------------------------------------------------------------------
	// -------------------------------------------------------------------
	// -------------------------------------------------------------------
	// -------------------------------------------------------------------
	// -------------------------------------------------------------------
	
		
		
		
		
		
		
		
		
		
		
		

	@SuppressWarnings("unchecked")
	public List<Cliente> traer() throws HibernateException {
		List<Cliente> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Cliente").list();
		} finally {
			session.close();
		}
		return lista;
	}
}
