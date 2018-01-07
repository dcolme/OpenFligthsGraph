package Display.graph;

public class Ruta {

	private String id;
	private String aerolinea;
	private String aerolineaID;
	private String n4Origen;
	private String idOrigen;
	private String n4Destino;
	private String idDestino;
	private String codeShare;
	private String paradas;
	private String equipamiento;
	private double distancia = -1;	

	public Ruta(String id, String aerolinea, String aerolineaID, String n4Origen, String idOrigen, String n4Destino,
			String idDestino, String codeShare,String paradas, String equipamiento) {
		this.id= id;
		this.aerolinea = aerolinea;
		this.aerolineaID = aerolineaID;
		this.n4Origen = n4Origen;
		this.idOrigen = idOrigen;
		this.n4Destino = n4Destino;
		this.idDestino = idDestino;
		this.paradas = paradas;
		this.equipamiento = equipamiento;
		this.setCodeShare(codeShare);
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAerolinea() {
		return aerolinea;
	}

	public void setAerolinea(String aerolinea) {
		this.aerolinea = aerolinea;
	}

	public String getAerolineaID() {
		return aerolineaID;
	}

	public void setAerolineaID(String aerolineaID) {
		this.aerolineaID = aerolineaID;
	}

	public String getN4Origen() {
		return n4Origen;
	}

	public void setN4Origen(String n4Origen) {
		this.n4Origen = n4Origen;
	}

	public String getIdOrigen() {
		return idOrigen;
	}

	public void setIdOrigen(String idOrigen) {
		this.idOrigen = idOrigen;
	}

	public String getN4Destino() {
		return n4Destino;
	}

	public void setN4Destino(String n4Destino) {
		this.n4Destino = n4Destino;
	}

	public String getIdDestino() {
		return idDestino;
	}

	public void setIdDestino(String idDestino) {
		this.idDestino = idDestino;
	}

	public String getParadas() {
		return paradas;
	}

	public void setParadas(String paradas) {
		this.paradas = paradas;
	}

	public String getEquipamiento() {
		return equipamiento;
	}

	public void setEquipamiento(String equipamiento) {
		this.equipamiento = equipamiento;
	}

	public double getDistancia() {
		return distancia;
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}

	public String getCodeShare() {
		return codeShare;
	}

	public void setCodeShare(String codeShare) {
		this.codeShare = codeShare;
	}

	
}
