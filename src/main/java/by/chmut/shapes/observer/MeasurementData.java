package by.chmut.shapes.observer;

public class MeasurementData {

    private double square;
    private double volume;

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "MeasurementData{" +
                "square=" + square +
                ", volume=" + volume +
                '}';
    }
}
