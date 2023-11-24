import java.util.List;

public class Vector_2 {
    private List<Double> values;
    private int cluster;
    private String name;

    public Vector_2(List<Double> list, String nom) {
        this.values = list;
        this.name = nom;
        this.cluster = -1;
    }

    public List<Double> getValues() {
        return values;
    }

    public int getCluster() {
        return cluster;
    }
    
    public String getName() {
    	return name;
    }

    public void setCluster(int cluster) {
        this.cluster = cluster;
    }
}
