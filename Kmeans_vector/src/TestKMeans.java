import java.util.List;

public class TestKMeans {
    public static void main(String[] args) {
        
        ManipularCSV archivo = new ManipularCSV();
		
        List<Vector_2> data = archivo.leerArchivo("C:\\Users\\DANYZ\\Downloads\\Inputs_POO\\FrutasClasificacionBinaria.csv");
        
        System.out.println(data.size());

         //Aplicar el algoritmo K-Means
        int k = 6;
        int maxIterations = 100;
        List<Vector_2> centroids = Kmeans.kmeans(data, k, maxIterations);

        int cant = 0;
        // Imprimir los centroides y la asignación de vectores a clústeres
        for (int i = 0; i < centroids.size(); i++) {
            System.out.println("Centroide " + i + ": " + centroids.get(i).getName());
            System.out.println("Cantidad de Puntos asignados al clúster " + i + ":");
            cant = 0;
            for (Vector_2 vector : data) {
	              if (vector.getCluster() == i) {
	                    cant++;
               }
            }
            System.out.println(cant);
        }
    }
}
