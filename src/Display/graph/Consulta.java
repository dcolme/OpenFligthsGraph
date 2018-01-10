package Display.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.graphstream.algorithm.Dijkstra;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.MultiGraph;
import org.graphstream.ui.swingViewer.View;
import org.graphstream.ui.swingViewer.Viewer;

public class Consulta {

	public Consulta() {

	}
	
	Scanner scan = new Scanner(System.in);
	Aeropuerto destino;
	Aeropuerto origen;

	  
	public void consultarUsuario (List<Aeropuerto> mundoA,List<Ruta> mundoR){
		
		  //El usuario introduce la informacion de su viaje.
		  System.out.println("Ingrese su pais origen: ");
		  String paisAux = scan.nextLine();
		  String paisOrigen = '"' + paisAux + '"';
		  System.out.println(" ");
		  origen = dameAeropuertos(paisOrigen,mundoA);
		  
		  System.out.println(" ");
		  
		  System.out.println("Ingrese su pais destino: ");
		  paisAux = scan.nextLine();
		  String paisDestino = '"' + paisAux + '"';
		  System.out.println(" ");
		  destino = dameAeropuertos(paisDestino,mundoA);
		  
		  //Ruta
		  System.out.println(" ");
		  System.out.println(origen.getNombre() + " ---> " + destino.getNombre());
		  dibujarRuta(origen,destino,mundoA,mundoR);
		  
	  }
	  
	private void dibujarRuta(Aeropuerto origen, Aeropuerto destino, List<Aeropuerto> mundoA,List<Ruta> mundoR) {

		// Si el vuelo directo existe, dibujar y agregar a una lista las diferentes aerolineas.
		List<Ruta> rutaAerolineas = new ArrayList<Ruta>();
		
		for (int i=0;i<mundoR.size();i++){
			if (mundoR.get(i).getIdOrigen().equals(origen.getId()) && mundoR.get(i).getIdDestino().equals(destino.getId())){ 
				//System.out.println(mundoR.get(i).getAerolinea());
				rutaAerolineas.add(mundoR.get(i));
				Node nodoOrigen = Display.graph.getNode(origen.getId());
				Node nodoDestino = Display.graph.getNode(destino.getId());
				 
				//Eliminar todos los nodos y agregar exclusivamente el seleccionado. 
				for (int j = 0; j <mundoR.size(); j++){
					try{
						Display.graph.removeEdge(mundoR.get(j).getId());
					} catch(Exception e) {};
				}
				 
				Display.graph.addEdge(mundoR.get(i).getId(), nodoOrigen, nodoDestino);
				Display.graph.addAttribute("ui.stylesheet", 
								"		 node {shape: circle;" + 
						  		"        size: 2px;" + 
				
						  		"        fill-color: rgba(3, 166, 120,200);}" + 
						  		
						  		"        edge { shape: cubic-curve;" +
						  		"        fill-mode: gradient-horizontal;" + 
						  		"		 fill-color: rgba(250,190,88,250);"+	
						  		"        z-index: 100;" + 
						  		"		 arrow-size: 10px;}" +
						  		
						  		"        graph {fill-color: #2C3E50;}"
				);
				
			}
		 }
		
		
		if (rutaAerolineas.size() == 0){
			System.out.println("No hay ruta directa");
			DijkstraAlgorithm dijkstra = new DijkstraAlgorithm();
			dijkstra.shortestPath(origen, destino, mundoR);
		}
		else {
			Viewer viewer = Display.graph.display();
			View view = viewer.getDefaultView();
			 //view.getCamera().setViewPercent(1.7);
			viewer.disableAutoLayout();  
		}
	}

	private Aeropuerto dameAeropuertos(String paisIngresado, List<Aeropuerto> mundoA){
		
		  System.out.println("Aeropuertos: ");
		  
		  //Llenar lista de aeropuertos del pais
		  List<Aeropuerto> listaAeropuertosPais = new ArrayList<Aeropuerto>();
		  for (int i=0;i<mundoA.size();i++){	
			  if(mundoA.get(i).getPais().equals(paisIngresado)){
				  listaAeropuertosPais.add(mundoA.get(i));
				  System.out.println(mundoA.get(i).getNombre()+"  "+mundoA.get(i).getN4()+"  "+mundoA.get(i).getCiudad());
			  }
		  }
		  
		  //Elegir aeropuerto del pais
		  if (listaAeropuertosPais.size()>0){
			  while (true){
				  System.out.println(" ");
				  System.out.println("Elige un aeropuerto (IATA) valido: [EJEMPLO " + listaAeropuertosPais.get(0).getN4() + "]");
				  String aeropuertoAux = scan.nextLine();
				  String aeropuerto = '"' + aeropuertoAux + '"';
				  
				  for (int i=0;i<listaAeropuertosPais.size();i++){
					  if (listaAeropuertosPais.get(i).getN4().equals(aeropuerto)){
						  return listaAeropuertosPais.get(i);
					  }
				  }
			  }
		  }
		  
		  else {
			  System.out.println("No hay aeropuertos disponibles para ese pais, ingrese otro pais:");
			  String paisIngresadoAux = scan.nextLine();
			  paisIngresado = '"' + paisIngresadoAux + '"';
			  dameAeropuertos(paisIngresado, mundoA);
		  }
		  
	  return dameAeropuertos(paisIngresado,mundoA);
	  }
	  

}
