package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
	  Graph graph = new MultiGraph("Mundo");
	  
	  
	public void consultaInicial (List<Aeropuerto> mundoA,List<Ruta> mundoR){
		//Consultas
		

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
		  trazarRuta(origen,destino,mundoA,mundoR);
		  
		
		  Viewer viewer = graph.display();
		  View view = viewer.getDefaultView();
		  view.getCamera().setViewPercent(1);
		  viewer.disableAutoLayout();

	  }
	  
	private void trazarRuta(Aeropuerto origen, Aeropuerto destino, List<Aeropuerto> mundoA,List<Ruta> mundoR) {
		 List<Ruta> vuelos = new ArrayList<Ruta>();
		 for (int i=1;i<mundoR.size();i++){
			 if (mundoR.get(i).getIdOrigen().equals(origen.getId()) && mundoR.get(i).getIdDestino().equals(destino.getId())){ 
				 System.out.println(mundoR.get(i).getAerolinea());
				 vuelos.add(mundoR.get(i));
				 Node nodeO = graph.getNode(origen.getId());
				 Node nodeD = graph.getNode(destino.getId());
				 graph.removeEdge(mundoR.get(i).getId());
				 graph.addEdge(mundoR.get(i).getId(), nodeO, nodeD);
				 graph.addAttribute("ui.stylesheet", 
					  		"        edge { shape: L-square-line;" +
					  		"        fill-mode: gradient-horizontal;" + 
					  		"		 fill-color: red"+	
					  		"		 arrow-size: 10px;}" +
					  		
					  		"        graph {fill-color: red;}"
					  );
				 
//				 graph.getEdge(mundoR.get(i).getId()).changeAttribute("ui.stylesheet", 
	//		  		"        edge { shape: L-square-line;" +
		//	  		"        fill-mode: gradient-horizontal;" + 
			//  		"		 fill-color: Red;"+	
			  //		"		 arrow-size: 10px;}");
				 
				
			 }

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
