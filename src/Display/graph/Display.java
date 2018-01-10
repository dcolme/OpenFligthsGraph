package Display.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import org.graphstream.ui.swingViewer.View;
import org.graphstream.ui.swingViewer.Viewer;

public class Display
{
	
  static Graph graph = new MultiGraph("Mundo");
	  
  public static void main(String[] args)
  {
	  
	  //La linea loca
	  //System.setProperty("org.graphstream.ui.renderer", "org.graphstream.ui.j2dviewer.J2DGraphRenderer");
	  
	  //Base de datos a HashMap
	  
	  Data data = new Data();

	  HashMap<Integer, List<String>> mapitaL = data.llenarListaL();
	  HashMap<Integer, List<String>> mapitaA = data.llenarListaA();
	  HashMap<Integer, List<String>> mapitaR = data.llenarListaR();
	  
	  //HashMap a lista de objetos.
	  ListaAeropuertos lista = new ListaAeropuertos();
	  
	  List<Aeropuerto> mundoA = new ArrayList<Aeropuerto>();
	  List<Aerolinea> mundoL = new ArrayList<Aerolinea>();
	  List<Ruta> mundoR = new ArrayList<Ruta>();
	  
	  mundoA = lista.llenarListaA(mapitaA);
	  mundoL = lista.llenarListaL(mapitaL);
	  mundoR = lista.llenarListaR(mapitaR);
	  crearMundo(mundoA,mundoL,mundoR);
	  
	  
	  //Informacion a partir del grafo
	  Consulta consulta = new Consulta ();
	  consulta.consultarUsuario(mundoA,mundoR);
	  
  }
  
  public static void mostrarTodo () {
		Viewer viewer = Display.graph.display();
		View view = viewer.getDefaultView();
		 //view.getCamera().setViewPercent(1.7);
		viewer.disableAutoLayout(); 
  }
  
  
  public static void crearMundo(List<Aeropuerto> mundoA,List<Aerolinea> mundoL,List<Ruta> mundoR) {
	
		 //Interfaz visual del grafo
		// Viewer viewer = graph.display();
		// View view = viewer.getDefaultView();
		 //view.getCamera().setViewPercent(1.7);
		// viewer.disableAutoLayout();  
	 
	 
	  //Generar nodos
	  for (int i=0; i<mundoA.size();i++) {
		  try{
		  graph.addNode(mundoA.get(i).getId());
		  Node node = graph.getNode(mundoA.get(i).getId());
			  node.setAttribute("x", Double.parseDouble(mundoA.get(i).getLongitud()));
			  node.setAttribute("y", Double.parseDouble(mundoA.get(i).getLatitud()));
			  graph.addAttribute("ui.stylesheet", 
					"		 node {shape: circle;" + 
			  		"        size: 2px;" + 
					"		 z-index:1;"+
			  		"        fill-color: rgba(3, 166, 120,250);}" + 
			  		
			  		"        edge { shape: cubic-curve;" +
			  		"        fill-mode: gradient-horizontal;" + 
			  		"		 fill-color: rgba(137,196,244,50);"+ 
			  		"		 z-index: 0;" +	
			  		"		 arrow-size: 10px;}" +
			  		
			  		"        graph {fill-color: #2C3E50;}"
			  );
		  }catch (Exception e){};
		  
	  }
	  
	  //Generar ejes
	  for (int i=0; i<mundoR.size();i++) {
		  
		  final String NULO = mundoR.get(7).getIdDestino(); // El string nulo tiene como valor "\N"
		  String origen = mundoR.get(i).getIdOrigen();
		  String destino = mundoR.get(i).getIdDestino();

		  
		  if (!origen.equals(NULO) && !destino.equals(NULO)){
			  for (int j=0; j<mundoA.size();j++){
				  if (mundoA.get(j).getId().equals(origen)){
					  for (int k=0;k<mundoA.size();k++){
						  if ((mundoA.get(k).getId().equals(destino))){	
							  try{
								  mundoR.get(i).setDistancia((Math.sqrt(Math.pow(Double.parseDouble(mundoA.get(k).getLatitud())-Double.parseDouble(mundoA.get(j).getLatitud()), 2)+Math.pow(Double.parseDouble(mundoA.get(k).getLongitud())-Double.parseDouble(mundoA.get(j).getLongitud()), 2))));
								  
								  graph.addEdge(mundoR.get(i).getId(), origen, destino).addAttribute("length", (int) mundoR.get(i).getDistancia());
								 
								  break;
							  }catch(Exception e){};
						  }
					  }
					  break;
				  }
			  }
		  }
	  }
	  

  }
  
  
}

