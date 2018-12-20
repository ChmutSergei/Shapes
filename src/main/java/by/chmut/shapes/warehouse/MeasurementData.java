package by.chmut.shapes.warehouse;

public class MeasurementData {

    private double square;
    private double volume;

    public MeasurementData() {
    }

    public MeasurementData(double square, double volume) {
        this.square = square;
        this.volume = volume;
    }

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
