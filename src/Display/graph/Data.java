package Display.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Data {
	
	String[] dataSplit;
	List<String> info;
	HashMap<Integer, List<String>> mapaAeropuerto = new HashMap<Integer, List<String>>();
	HashMap<Integer, List<String>> mapaAerolineas = new HashMap<Integer, List<String>>();
	HashMap<Integer, List<String>> mapaRutas = new HashMap<Integer, List<String>>();
	
	
	@SuppressWarnings("unchecked")
	public void dividir(int i,int f) {
		if (f==0) {
		List<String> iterador = UrlToList.Aeropuertos;
		dataSplit =  iterador.get(i).toString().split(",");}
		else if (f==1) {		
		List<String> iterador = UrlToList.Rutas;
		dataSplit =  iterador.get(i).toString().split(",");}
		else if (f==2) {
			List<String> iterador = UrlToList.Aerolineas;
			dataSplit =  iterador.get(i).toString().split(",");
		}
	}

	public HashMap<Integer, List<String>> llenarListaA() {
		for (int i = 0; i < UrlToList.Aeropuertos.size(); i++) {
			this.dividir(i,0);
			info= new ArrayList<String>(Arrays.asList(dataSplit));
			mapaAeropuerto.put(Integer.parseInt(info.get(0)), info);
			dataSplit = null;
		}
		return mapaAeropuerto;

	}
	
	public HashMap<Integer, List<String>> llenarListaR() {
		for (int i = 0; i < UrlToList.Rutas.size(); i++) {
			this.dividir(i,1);
			info= new ArrayList<String>(Arrays.asList(dataSplit));
			mapaRutas.put(i, info);
			dataSplit = null;
		}
		return mapaRutas;

	}
	
	public HashMap<Integer, List<String>> llenarListaL() {
		for (int i = 0; i < UrlToList.Aerolineas.size(); i++) {
			this.dividir(i,2);
			info= new ArrayList<String>(Arrays.asList(dataSplit));
			mapaAerolineas.put(Integer.parseInt(info.get(0)), info);
			dataSplit = null;
		}
		return mapaAerolineas;

	}
	
}
