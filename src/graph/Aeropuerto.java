package graph;

public class Aeropuerto {

	private String id;
	private String nombre;
	private String ciudad;
	private String pais;
	private String n3;
	private String n4;
	private String latitud;
	private String longitud;
	private String altitud;
	private String zonaHoraria;
	private String dst;
	private String zoneHorariaRegion;
	private String type;
	private String source;
	
	 public Aeropuerto(String id, String nombre, String ciudad, String pais, String n3, String n4, String latitud,
			String longitud, String altitud, String zonaHoraria, String dst, String zoneHorariaRegion, String type,
			String source) {
		 
		this.id = id;
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.pais = pais;
		this.n3 = n3;
		this.n4 = n4;
		this.latitud = latitud;
		this.longitud = longitud;
		this.altitud = altitud;
		this.zonaHoraria = zonaHoraria;
		this.dst = dst;
		this.zoneHorariaRegion = zoneHorariaRegion;
		this.type = type;
		this.source = source;
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

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getN3() {
		return n3;
	}

	public void setN3(String n3) {
		this.n3 = n3;
	}

	public String getN4() {
		return n4;
	}

	public void setN4(String n4) {
		this.n4 = n4;
	}

	public String getLatitud() {
		return latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getLongitud() {
		return longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	public String getAltitud() {
		return altitud;
	}

	public void setAltitud(String altitud) {
		this.altitud = altitud;
	}

	public String getZonaHoraria() {
		return zonaHoraria;
	}

	public void setZonaHoraria(String zonaHoraria) {
		this.zonaHoraria = zonaHoraria;
	}

	public String getDst() {
		return dst;
	}

	public void setDst(String dst) {
		this.dst = dst;
	}

	public String getZoneHorariaRegion() {
		return zoneHorariaRegion;
	}

	public void setZoneHorariaRegion(String zoneHorariaRegion) {
		this.zoneHorariaRegion = zoneHorariaRegion;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
	 
	 
}
