package Display.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFrame;

import org.graphstream.algorithm.Dijkstra;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.MultiGraph;
import org.graphstream.ui.swingViewer.View;
import org.graphstream.ui.swingViewer.Viewer;

public class Consulta extends JFrame {

	public Consulta() {

	}
	
	Scanner scan = new Scanner(System.in);
	Aeropuerto destino;
	Aeropuerto origen;
	 
	public void visual (){
		 Consulta frame = new Consulta();
		  frame.setSize(300, 300);
		  frame.setVisible(true);
	}
	  
	public void consultarUsuario (List<Aeropuerto> mundoA,List<Ruta> mundoR, String n4Origen, String n4Destino){
		
		  
		  
		  //El usuario introduce la informacion de su viaje.
		
		  String paisAux = n4Origen;
		  String paisOrigen = '"' + paisAux + '"';
		  System.out.println(" ");
		  origen = dameAeropuertos(paisOrigen, mundoA);
		  
		  System.out.println(" ");
		  
		 
		  paisAux = n4Destino;
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
		  Aeropuerto elegido = null;
		  //Llenar lista de aeropuertos del pais
		
		  
		  //Elegir aeropuerto del pais
		  if (mundoA.size()>0){

				  String aeropuerto = paisIngresado;
				  
				  for (int i=0;i<mundoA.size();i++){
					  try{
					  if (mundoA.get(i).getN4().equals(aeropuerto)){
						  elegido = mundoA.get(i);
					  }
				  }catch(Exception e){};
				  }
			  
		  }
		  
		 
		  
	  return elegido;
	  }
	  

}
