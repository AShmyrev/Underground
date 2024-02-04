import Exceptions.LineExistingException;
import Exceptions.StationExistingException;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Metro {
    private String cityName;
    private Set<Line> lines = new HashSet<>(2);

    public void createFirstStation(LineColor lineColor, String newStationName, List<Station> changeLines)
            throws LineExistingException, StationExistingException {
        if (!isLineExists(lineColor)) {
            throw new LineExistingException("Нет линии такого цвета!");
        }
        if (!isStationNameUnique(newStationName)) {
            throw new StationExistingException("Станция с таким именем уже существует!");
        }
        if (!hasLineStations(lineColor)) {
            throw new LineExistingException("В линии нет станций!");
        }
        for (Line line : lines) {
            if (line.getLineColor().equals(lineColor)) {
                line.addStation(new Station(newStationName, line, this));
            }
        }
    }

    private boolean isLineExists(LineColor color) {
        boolean isLineExists = false;
        for (Line line : lines) {
            if (line.getLineColor().equals(color)) {
                isLineExists = !isLineExists;
            }
        }
        return isLineExists;
    }

    private boolean isStationNameUnique(String newStationName) {
        for (Line line : lines) {
            for (Station currentStation : line.getStations()) {
                if (currentStation.getName().equals(newStationName)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean hasLineStations(LineColor color) {
        for (Line line : lines) {
            if (line.getLineColor().equals(color)) {
                return !line.getStations().isEmpty();
            }
        }
        return true;
    }

    public void createStation(LineColor lineColor, String newStationName, Duration durationForPrevStation,
                              List<Station> changeLines)
            throws LineExistingException, StationExistingException {
        if (!isLineExists(lineColor)) {
            throw new LineExistingException("Нет линии такого цвета!");
        }
        if (!isPrevStationExists(lineColor)) {
            throw new StationExistingException("В линии нет станций! Необходимо добавить хотя бы одну станцию");
        }
        if (!hasPrevStationNextStation(lineColor)) {
            throw new StationExistingException("");
        }
    }

    private boolean isPrevStationExists(LineColor color) {
        for (Line line : lines) {
            if (line.getLineColor().equals(color)) {
                return !line.getStations().isEmpty();
            }
        }
        return false;
    }

    private boolean hasPrevStationNextStation(LineColor color) {
        Line currentLine = null;
        for (Line line : lines) {
            if (line.getLineColor().equals(color)) {
                currentLine = line;
            }
        }
        if (currentLine == null) {
            throw new RuntimeException("Не удалось перейти к выбранной ветке");
        }
        Station currentStation = null;
        for (Station station : currentLine.getStations()) {
            return station.getNextStation() == null;
            // TODO: station. ???
        }
        return false;
    }
}
