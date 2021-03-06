package Display.graph;


import java.util.ArrayList;
import java.util.List;


import org.graphstream.graph.*;
import org.graphstream.ui.swingViewer.Viewer;




public class RutasDesdeAeropuerto{
	
	Aeropuerto seleccion;
	
	public RutasDesdeAeropuerto() {
	
	}

	
	public void encontrarRutas (List<Ruta> mundoR, List<Aeropuerto> mundoA, String entrada){
		List<String> conexiones = new ArrayList<String>();
		System.out.println("-");
		String aeropuertoAux = entrada;
		String aeropuertoIngresado = '"' + aeropuertoAux + '"';
	
	
		for (int i = 0; i < mundoA.size(); i++){
			try{
				if (aeropuertoIngresado.equals(mundoA.get(i).getN4())){
					seleccion = mundoA.get(i);
				}
			}catch(Exception e){};
		}
		
		for (int j = 0; j < mundoR.size(); j ++ ){
			String aux = mundoR.get(j).getN4Origen();
			String n4AeropuertoSeleccionado = '"' + aux + '"';
			try{
				if (seleccion.getN3().equals(n4AeropuertoSeleccionado)){
					conexiones.add(mundoR.get(j).getIdDestino());
				}
			}catch(Exception e){};
		}
		
	
		
		for (int j = 0; j <mundoR.size(); j++){
			try{
				Display.graph.removeEdge(mundoR.get(j).getId());
			} catch(Exception e) {};
		}
		
		
		Node nodoOrigen = Display.graph.getNode(seleccion.getId());
		
		
		for (int i = 0; i < conexiones.size(); i++){
			try{
			Node nodoDestino = Display.graph.getNode(conexiones.get(i));
		
			Display.graph.addEdge(String.valueOf(i), nodoOrigen, nodoDestino);
			Display.graph.addAttribute("ui.stylesheet", 
						"		 node {shape: circle;" + 
				  		"        size: 2px;" + 
		
				  		"        fill-color: rgba(3, 166, 120,200);}" + 
				  		
				  		"        edge { shape: cubic-curve;" +
				  		"        fill-mode: gradient-horizontal;" + 
				  		"		 fill-color: rgba(210, 77, 87,250);"+	
				  		"        z-index: 100;" + 
				  		"		 arrow-size: 10px;}" +
				  		
				  		"        graph {fill-color: #2C3E50;}"
			);
		}catch(Exception e){}
		}
		
	
	
	
	}	
}


