package datos;

public class InscripcionAfip {
	private int idInscripcionAfip;
	private String inscripcionAfip;
	
	public InscripcionAfip() {
	}

	public InscripcionAfip(String inscripcionAfip) {
		this.inscripcionAfip = inscripcionAfip;
	}

	public int getIdInscripcionAfip() {
		return idInscripcionAfip;
	}

	public void setIdInscripcionAfip(int idInscripcionAfip) {
		this.idInscripcionAfip = idInscripcionAfip;
	}

	public String getInscripcionAfip() {
		return inscripcionAfip;
	}

	public void setInscripcionAfip(String inscripcionAfip) {
		this.inscripcionAfip = inscripcionAfip;
	}

	@Override
	public String toString() {
		return "\nidInscripcionAfip=" + idInscripcionAfip + "\ninscripcionAfip=" + inscripcionAfip + "]";
	}
	
	
	
}
