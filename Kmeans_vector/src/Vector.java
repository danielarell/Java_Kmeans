import java.util.List;

public class Vector {
    private List<Double> values;
    private int cluster;

    public Vector(List<Double> values) {
        this.values = values;
        this.cluster = -1;
    }

    public List<Double> getValues() {
        return values;
    }

    public int getCluster() {
        return cluster;
    }

    public void setCluster(int cluster) {
        this.cluster = cluster;
    }
}
