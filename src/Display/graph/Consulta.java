package Display.graph;

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

	  
	  
	public void consultaInicial (List<Aeropuerto> mundoA,List<Ruta> mundoR){
		
		 
		

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
		  

	  }
	  
	private void trazarRuta(Aeropuerto origen, Aeropuerto destino, List<Aeropuerto> mundoA,List<Ruta> mundoR) {

		 List<Ruta> vuelos = new ArrayList<Ruta>();
		 for (int i=0;i<mundoR.size();i++){

			 if (mundoR.get(i).getIdOrigen().equals(origen.getId()) && mundoR.get(i).getIdDestino().equals(destino.getId())){ 
				 System.out.println(mundoR.get(i).getAerolinea());
				 vuelos.add(mundoR.get(i));
				 Node nodeO = Display.graph.getNode(origen.getId());
				 Node nodeD = Display.graph.getNode(destino.getId());
				 
				 
				 for (int j = 0; j <mundoR.size(); j++){
					 try{
						 Display.graph.removeEdge(mundoR.get(j).getId());
					 }catch(Exception e){};
				 }
				 
				 Display.graph.addEdge(mundoR.get(i).getId(), nodeO, nodeD);
				 Display.graph.addAttribute("ui.stylesheet", 
									"		 node {shape: circle;" + 
							  		"        size: 2px;" + 
							  		"        fill-color: #26A65B;}" + 
						
							  		"        edge {shape: cubic-curve;" +
							  		"        fill-mode: gradient-horizontal;" + 
							  		"		 fill-color: yellow;"+	
							  		"		 arrow-size: 10px;}" +
							  		
							  		"        graph {fill-color: #2C3E50;}"
							  );
				 
			
				
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
