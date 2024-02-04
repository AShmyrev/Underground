import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;

public class Station {
    private String name;
    private Station previousStation;
    private Station nextStation;
    private Duration timeToNextStation;
    private Line line;
    private ArrayList<Station> changeLines = new ArrayList<>(); // TODO: wtf
    private Metro metro;

    public Station(String name, Line line, Metro metro) {
        this.name = name;
        this.line = line;
        this.metro = metro;
    }

    public String getName() {
        return name;
    }

    public Station getPreviousStation() {
        return previousStation;
    }

    public Station getNextStation() {
        return nextStation;
    }
}
