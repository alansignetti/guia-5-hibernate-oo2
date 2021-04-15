package datos;

public class Contacto {
	private int idContacto;
	private String email;
	private String movil;
	private String fijo;
	
	public Contacto() {
	}

	public Contacto(String email, String movil, String fijo, Cliente cliente) {
		this.email = email;
		this.movil = movil;
		this.fijo = fijo;
	}

	public long getIdContacto() {
		return idContacto;
	}

	protected void setIdContacto(int idContacto) {
		this.idContacto = idContacto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMovil() {
		return movil;
	}

	public void setMovil(String movil) {
		this.movil = movil;
	}

	public String getFijo() {
		return fijo;
	}

	public void setFijo(String fijo) {
		this.fijo = fijo;
	}

	public String toString() {
		return email + " " + " Movil: " + movil + " Teléfono: " + fijo;
	}
}
