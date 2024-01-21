import Exceptions.LineExistingException;
import Exceptions.StationExistingException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Metro {
    private String cityName;
    private Set<Line> lines = new HashSet<>(2);

    public void createNewLine(LineColor color) throws LineExistingException {
        Line newLine = new Line(color);
        if (!lines.contains(newLine)) {
            lines.add(newLine);
        } else {
            throw new LineExistingException("Линия с таким цветом уже существует!");
        }
    }

    // TODO: если линий еще не создано?
    public void createFirstStation(LineColor color, String newStationName, List<Station> stationsToChange)
            throws LineExistingException, StationExistingException {
        boolean isLineExists = false;
        for (Line line : lines) {
            if (line.getLineColor().equals(color)) {
                isLineExists = !isLineExists;
            }
        }
        if (!isLineExists) {
            throw new LineExistingException("Нет линии такого цвета!");
        }
        boolean isStationExists = false;
        for (Line line : lines) {
            for (Station currentStation : line.getStations()) {
                if (currentStation.getName().equals(newStationName)) {
                    throw new StationExistingException("Станция с таким именем уже существует!");
                }
            }
        }
    }
}
