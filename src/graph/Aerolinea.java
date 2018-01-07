package graph;

public class Aerolinea {
	
	private String id;
	private String nombre;
	private String alias;
	private String iATA;
	private String iCAO;
	private String senal;
	private String pais;
	private String activo;
	
	public Aerolinea(String id, String nombre, String alias, String iATA, String iCAO, String senal, String pais,
			String activo) {
		this.id = id;
		this.nombre = nombre;
		this.alias = alias;
		this.iATA = iATA;
		this.iCAO = iCAO;
		this.senal = senal;
		this.pais = pais;
		this.activo = activo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getiATA() {
		return iATA;
	}

	public void setiATA(String iATA) {
		this.iATA = iATA;
	}

	public String getiCAO() {
		return iCAO;
	}

	public void setiCAO(String iCAO) {
		this.iCAO = iCAO;
	}

	public String getSenal() {
		return senal;
	}

	public void setSenal(String senal) {
		this.senal = senal;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

}
