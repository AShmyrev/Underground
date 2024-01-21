import java.util.ArrayList;

public class Line {
    private LineColor lineColor;
    ArrayList<Station> stations = new ArrayList<>(6);
    private Metro metro;

    public Line(LineColor lineColor) {
        this.lineColor = lineColor;
    }

    public LineColor getLineColor() {
        return lineColor;
    }

    public ArrayList<Station> getStations() {
        return stations;
    }
}
