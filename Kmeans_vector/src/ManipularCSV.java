import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.*;

import javax.swing.JOptionPane;

public class ManipularCSV {
	
	private BufferedReader lector;
	private String linea;
	private String partes[] = null;
	private Vector<Vector_2>data = new Vector<Vector_2>();
	
	public Vector<Vector_2> leerArchivo(String nombrearchivo) {
	    try {
	        lector = new BufferedReader(new FileReader(nombrearchivo));
	        int numeroLinea = 0;
	        while ((linea = lector.readLine()) != null) {
	        	numeroLinea++;

	            // Ignorar la primera línea (títulos de las columnas)
	            if (numeroLinea == 1) {
	                continue;
	            }
	            partes = linea.split(",");
	            
	            // Verificamos que haya al menos un elemento en el array 'partes'
	            if (partes.length > 0) {
	                // Guardamos el primer elemento en una variable de tipo String
	                String primerElemento = partes[0];
	                
	                // Convertimos los demás elementos a double
	                List<Double> valores = new ArrayList<>();
	                for (int i = 1; i < partes.length; i++) {
	                    valores.add(Double.parseDouble(partes[i]));
	                }
	                
	                // Ahora 'valores' contiene los elementos numéricos de 'partes'
	                data.add(new Vector_2(valores, primerElemento));
	                //System.out.println();
	            }
	        }
	        //imprimirLinea();
	        lector.close();
	        linea = null;
	        partes = null;
	        return data;
	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(null, e);
	    }
		return null;
	}

}
