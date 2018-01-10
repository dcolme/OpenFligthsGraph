package Display.graph;

import java.util.Iterator;
import java.util.List;

import org.graphstream.algorithm.Dijkstra;
import org.graphstream.graph.Node;
import org.graphstream.graph.Path;


public class DijkstraAlgorithm {

	
	public DijkstraAlgorithm() {
		// TODO Auto-generated constructor stub
	}

	public int MAX_SIZE = 10000;
	public void shortestPath (Aeropuerto origen, Aeropuerto destino, List<Ruta> mundoR ){
		
		//System.out.println("Entre en la clase");
		Node nodoDestino = Display.graph.getNode(destino.getId());
		Dijkstra dijkstra = new Dijkstra(Dijkstra.Element.EDGE, null, "length");

		Display.graph.display(false);
		dijkstra.setSource(Display.graph.getNode(origen.getId()));
		dijkstra.init(Display.graph);
		
		dijkstra.compute();
		

		
		if (dijkstra.getPathLength(nodoDestino) < MAX_SIZE){
		Iterator<Path> pathIterator = dijkstra.getAllPathsIterator(nodoDestino);

			String lineaCompletaCorchete = pathIterator.next().toString();
			String lineaCompleta = lineaCompletaCorchete.replaceAll("[ \\[\\] ]", "");
			String [] arrayNodosPath =  lineaCompleta.split(",");
			
			
			for (int j = 0; j <mundoR.size(); j++){
				try{
					Display.graph.removeEdge(mundoR.get(j).getId());
				} catch(Exception e) {};
			}
			
			
			
			
			for (int i = 0; i < arrayNodosPath.length - 1; i++){
				Node nodoOrigenAux = Display.graph.getNode(arrayNodosPath[i]);
				Node nodoDestinoAux = Display.graph.getNode(arrayNodosPath[i + 1]);
				
				Display.graph.addEdge(mundoR.get(i).getId(), nodoOrigenAux, nodoDestinoAux);
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
		
		else {
			System.out.println("Actualmente no hay rutas que conecten estos aeropuertos");
			for (int j = 0; j <mundoR.size(); j++){
				try{
					Display.graph.removeEdge(mundoR.get(j).getId());
				} catch(Exception e) {};
			}
		}
		
		
		
	
		 
	
	
		
	}
}
