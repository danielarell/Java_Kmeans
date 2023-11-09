import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Kmeans {
    public static List<Vector> kmeans(List<Vector> data, int k, int maxIterations) {
        // Inicialización de centroides de manera aleatoria
        List<Vector> centroids = initializeCentroids(data, k);

        for (int iteration = 0; iteration < maxIterations; iteration++) {
            // Asignar cada vector al centroide más cercano
            assignPointsToCentroids(data, centroids);

            // Calcular nuevos centroides
            List<Vector> newCentroids = calculateNewCentroids(data, k);

            // Comprobar la convergencia
            if (converged(centroids, newCentroids)) {
                break;
            }

            centroids = newCentroids;
        }

        return centroids;
    }

    private static void assignPointsToCentroids(List<Vector> data, List<Vector> centroids) {
        for (Vector vector : data) {
            double minDistance = Double.MAX_VALUE;
            int closestCentroidIndex = -1;

            for (int i = 0; i < centroids.size(); i++) {
                double distance = calculateDistance(vector, centroids.get(i));
                if (distance < minDistance) {
                    minDistance = distance;
                    closestCentroidIndex = i;
                }
            }

            vector.setCluster(closestCentroidIndex);
        }
    }
    
    private static List<Vector> initializeCentroids(List<Vector> data, int k) {
        List<Vector> centroids = new ArrayList<>();
        Random random = new Random();

        if (data.size() <= k) {
            return new ArrayList<>(data); // Retornar los datos como centroides si k es mayor o igual al tamaño de los datos
        }

        Set<Integer> selectedIndices = new HashSet<>();
        while (selectedIndices.size() < k) {
            int randomIndex = random.nextInt(data.size());
            if (!selectedIndices.contains(randomIndex)) {
                selectedIndices.add(randomIndex);
                centroids.add(data.get(randomIndex));
            }
        }

        return centroids;
    }

    private static List<Vector> calculateNewCentroids(List<Vector> data, int k) {
        List<Vector> newCentroids = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            List<Double> sum = new ArrayList<>(data.get(0).getValues().size());
            for (int j = 0; j < data.get(0).getValues().size(); j++) {
                sum.add(0.0);
            }

            int count = 0;

            for (Vector vector : data) {
                if (vector.getCluster() == i) {
                    List<Double> values = vector.getValues();
                    for (int j = 0; j < values.size(); j++) {
                        sum.set(j, sum.get(j) + values.get(j));
                    }
                    count++;
                }
            }

            if (count > 0) {
                List<Double> newCentroid = new ArrayList<>(sum.size());
                for (int j = 0; j < sum.size(); j++) {
                    newCentroid.add(sum.get(j) / count);
                }
                newCentroids.add(new Vector(newCentroid));
            }
        }

        return newCentroids;
    }

    private static double calculateDistance(Vector v1, Vector v2) {
        List<Double> values1 = v1.getValues();
        List<Double> values2 = v2.getValues();
        double sum = 0.0;

        for (int i = 0; i < values1.size(); i++) {
            sum += Math.pow(values1.get(i) - values2.get(i), 2);
        }

        return Math.sqrt(sum);
    }

    private static boolean converged(List<Vector> centroids, List<Vector> newCentroids) {
    	
    	boolean t = true;
    	for(int i = 0; i < centroids.size(); i++)
    	{
    		if(centroids.get(i).equals(newCentroids.get(i)))
    		{
    			t = true;
    		}else
    		{
    			t = false;
    			break;
    		}
    	}
        return t;
    }
}
