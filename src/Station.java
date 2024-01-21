import java.time.Duration;
import java.util.ArrayList;

public class Station {
    private String name;
    private Station previousStation;
    private Station nextStation;
    private Duration timeToNextStation;
    private Line line;
    private ArrayList<Station> availableStations = new ArrayList<>(); // TODO: wtf
    private Metro metro;

    public String getName() {
        return name;
    }
}
