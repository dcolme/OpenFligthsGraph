package Display.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JFrame;

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import org.graphstream.ui.swingViewer.View;
import org.graphstream.ui.swingViewer.Viewer;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.Font;

public class Display extends JFrame
{
	

	 static List<Aeropuerto> mundoA = new ArrayList<Aeropuerto>();
	 static List<Aerolinea> mundoL = new ArrayList<Aerolinea>();
	 static List<Ruta> mundoR = new ArrayList<Ruta>();
	 static Display frame = new Display();
	  
	  
	public Display() {
		getContentPane().setBackground(Color.decode("#5C97BF"));
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.decode("#59ABE3"));
		panel.setBounds(6, 16, 288, 74);
		getContentPane().add(panel);
		
		JLabel lblIngrese = new JLabel("Ingrese el codigo ICAO del aeropuerto");
		lblIngrese.setFont(new Font("Lantinghei TC", Font.PLAIN, 12));
		panel.add(lblIngrese);
		lblIngrese.setHorizontalAlignment(SwingConstants.CENTER);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		//RUTASDESDEAEROPUERTO FUNCION
		JButton btnNewButton = new JButton("Encontrar rutas");
		btnNewButton.setFont(new Font("Lantinghei TC", Font.PLAIN, 13));
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.decode("#59ABE3"));
		panel_1.setBounds(6, 100, 288, 108);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblIngreseElCodigo = new JLabel("Ingrese el codigo ICAO de los aeropuertos");
		lblIngreseElCodigo.setFont(new Font("Lantinghei TC", Font.PLAIN, 11));
		lblIngreseElCodigo.setBounds(15, 5, 258, 16);
		lblIngreseElCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblIngreseElCodigo);
		
		textField_1 = new JTextField();
		textField_1.setBounds(25, 27, 130, 26);
		textField_1.setColumns(10);
		panel_1.add(textField_1);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setFont(new Font("Lantinghei TC", Font.PLAIN, 13));
		btnEnviar.setBounds(177, 33, 82, 52);
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textField_1.getText().isEmpty() && !textField_2.getText().isEmpty()){
					Consulta consulta = new Consulta ();
					consulta.consultarUsuario(mundoA,mundoR, textField_1.getText(), textField_2.getText());
					frame.setVisible(false);
				}
				else {
					System.out.println("SHGIET BOY");
				}
			}
		});
		panel_1.add(btnEnviar);
		
		textField_2 = new JTextField();
		textField_2.setBounds(25, 65, 130, 26);
		textField_2.setColumns(10);
		panel_1.add(textField_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.decode("#5C97BF"));
		panel_2.setBounds(6, 220, 288, 52);
		getContentPane().add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JButton btnTodasLasRutas = new JButton("TODAS LAS RUTAS");
		btnTodasLasRutas.setFont(new Font("Lantinghei TC", Font.PLAIN, 13));
		btnTodasLasRutas.setBackground(Color.RED);
		btnTodasLasRutas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarTodo();
				frame.setVisible(false);
			}
		});
		panel_2.add(btnTodasLasRutas);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  RutasDesdeAeropuerto rutasDesdeAeropuerto = new RutasDesdeAeropuerto();
				  rutasDesdeAeropuerto.encontrarRutas(mundoR, mundoA, textField.getText());	
				  Viewer viewer = graph.display();
				  viewer.disableAutoLayout();  
				  frame.setVisible(false);
				  
			}
		});
	}
	
  static Graph graph = new MultiGraph("Mundo");
  private static JTextField textField;
  private JTextField textField_1;
  private JTextField textField_2;

  
  public static void main(String[] args)
  {
	  

	  
	  Data data = new Data();

	  HashMap<Integer, List<String>> mapitaL = data.llenarListaL();
	  HashMap<Integer, List<String>> mapitaA = data.llenarListaA();
	  HashMap<Integer, List<String>> mapitaR = data.llenarListaR();
	  
	  //HashMap a lista de objetos.
	  ListaAeropuertos lista = new ListaAeropuertos();
	  
	 
	  
	  mundoA = lista.llenarListaA(mapitaA);
	  mundoL = lista.llenarListaL(mapitaL);
	  mundoR = lista.llenarListaR(mapitaR);
	  //mostrarTodo();
	  crearMundo(mundoA,mundoL,mundoR);
	  visual();


	  
	  //Informacion a partir de dos aeropuertos
	
	  
	    
  }
  
	public static void visual (){
			
		  frame.setSize(300, 300);
		  frame.setVisible(true);
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

