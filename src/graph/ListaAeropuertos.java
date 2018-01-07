package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class ListaAeropuertos {
	
	private HashMap<Integer,List<String>> mapa = null;
	private List<Aeropuerto> listaAeropuertos = new ArrayList<Aeropuerto>();
	private List<Ruta> listaRuta = new ArrayList<Ruta>();
	private List<Aerolinea> listaAerolineas = new ArrayList<Aerolinea>();
	
	public List<Aeropuerto> llenarListaA(HashMap<Integer,List<String>> mapita){
		mapa = mapita;
		
		
			for (Entry<Integer, List<String>> i : mapa.entrySet())
			{
				Aeropuerto aeropuerto = new Aeropuerto(
						i.getValue().get(0),
						i.getValue().get(1),
						i.getValue().get(2),
						i.getValue().get(3),
						i.getValue().get(4),
						i.getValue().get(5),
						i.getValue().get(6),
						i.getValue().get(7),
						i.getValue().get(8),
						i.getValue().get(9),
						i.getValue().get(10),
						i.getValue().get(11),
						i.getValue().get(12),
						i.getValue().get(13));
				listaAeropuertos.add(aeropuerto);
		}
			return listaAeropuertos;
	}
	
	
	
	public List<Ruta> llenarListaR(HashMap<Integer,List<String>> mapita){
		
		for (Entry<Integer, List<String>> i : mapita.entrySet())
		{
			Ruta ruta = new Ruta(
					i.getKey().toString(),
					i.getValue().get(0),
					i.getValue().get(1),
					i.getValue().get(2),
					i.getValue().get(3),
					i.getValue().get(4),
					i.getValue().get(5),
					i.getValue().get(6),
					i.getValue().get(7),
					i.getValue().get(8));
			listaRuta.add(ruta);
			
			}
		return listaRuta;}
	
	
	
	public List<Aerolinea> llenarListaL(HashMap<Integer,List<String>> mapita){
		
		for (Entry<Integer, List<String>> i : mapita.entrySet())
		{
			Aerolinea aerolinea = new Aerolinea(
					i.getValue().get(0),
					i.getValue().get(1),
					i.getValue().get(2),
					i.getValue().get(3),
					i.getValue().get(4),
					i.getValue().get(5),
					i.getValue().get(6),
					i.getValue().get(7));
			listaAerolineas.add(aerolinea);
			}
		
		return listaAerolineas;}

}
