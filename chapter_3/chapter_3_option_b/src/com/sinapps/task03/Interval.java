package com.sinapps.task03;

public class Interval {
    private double start;
    private double end;

    public Interval(double start) {
        this.start = start;
    }

    public Interval(double start, double end) {
        this.start = start;
        this.end = end;
    }

    public double getStart() {
        return start;
    }

    public void setStart(double start) {
        this.start = start;
    }

    public double getEnd() {
        return end;
    }

    public void setEnd(double end) {
        this.end = end;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        if (start == Double.NEGATIVE_INFINITY) {
            result.append("(-∞; ");
        } else {
            result.append("(").append(String.format("%.3f", start)).append("; ");
        }

        if (end == Double.POSITIVE_INFINITY) {
            result.append("+∞)");
        } else {
            result.append(String.format("%.3f", end)).append(")");
        }

        return result.toString();
    }
}
