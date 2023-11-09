import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestKMeans {
    public static void main(String[] args) {
        // Crear una lista de vectores de prueba (cada vector es un objeto Vector)
        List<Vector> data = new ArrayList<>();
        data.add(new Vector(Arrays.asList(1.0, 2.0, 3.0, 4.0, 7.5)));
        data.add(new Vector(Arrays.asList(2.0, 1.5, 2.5, 9.0, 6.5)));
        data.add(new Vector(Arrays.asList(2.5, 2.5, 1.0, 7.5, 5.0)));
        data.add(new Vector(Arrays.asList(6.0, 5.0, 6.5, 6.5, 3.0)));
        data.add(new Vector(Arrays.asList(6.5, 6.0, 5.5, 3.5, 4.5)));
        data.add(new Vector(Arrays.asList(7.0, 5.5, 7.5, 5.5, 1.0)));
        data.add(new Vector(Arrays.asList(3.0, 8.0, 8.5, 8.0, 7.5)));
        data.add(new Vector(Arrays.asList(4.0, 8.5, 9.0, 7.0, 8.0)));
        data.add(new Vector(Arrays.asList(9.0, 9.0, 9.0, 2.5, 3.5)));

        // Aplicar el algoritmo K-Means
        int k = 3;
        int maxIterations = 100;
        List<Vector> centroids = Kmeans.kmeans(data, k, maxIterations);

        // Imprimir los centroides y la asignación de vectores a clústeres
        for (int i = 0; i < centroids.size(); i++) {
            System.out.println("Centroide " + i + ": " + centroids.get(i).getValues());
            System.out.println("Puntos asignados al clúster " + i + ":");
            for (Vector vector : data) {
                if (vector.getCluster() == i) {
                    System.out.println(vector.getValues());
                }
            }
        }
    }
}
