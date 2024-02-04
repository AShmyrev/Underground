import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Line {
    private LineColor lineColor;
    private Set<Station> stations = new LinkedHashSet<>(6);
    private Metro metro;

    public Line(LineColor lineColor) {
        this.lineColor = lineColor;
    }

    public LineColor getLineColor() {
        return lineColor;
    }

    public Set<Station> getStations() {
        return stations;
    }

    public void addStation(Station stationToAdd) {
        stations.add(stationToAdd);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return lineColor == line.lineColor && Objects.equals(stations, line.stations) && Objects.equals(metro, line.metro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lineColor, stations, metro);
    }
}
