package com.sinapps.task05;

public class Interval {
    private double start;
    private boolean startInclude;

    private double end;
    private boolean endInclude;

    public Interval() {
        start = Double.NEGATIVE_INFINITY;
        startInclude = false;

        end = Double.POSITIVE_INFINITY;
        endInclude = false;
    }

    public Interval(double start, boolean startInclude, double end, boolean endInclude) {
        this.start = start;
        this.startInclude = startInclude;
        this.end = end;
        this.endInclude = endInclude;
    }

    public double getStart() {
        return start;
    }

    public void setStart(double start) {
        this.start = start;
    }

    public boolean isStartInclude() {
        return startInclude;
    }

    public void setStartInclude(boolean startInclude) {
        this.startInclude = startInclude;
    }

    public double getEnd() {
        return end;
    }

    public void setEnd(double end) {
        this.end = end;
    }

    public boolean isEndInclude() {
        return endInclude;
    }

    public void setEndInclude(boolean endInclude) {
        this.endInclude = endInclude;
    }

    public Interval crossing(Interval interval) {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        if (startInclude && start != Double.NEGATIVE_INFINITY) {
            result.append("[");
        } else {
            result.append("(");
        }

        if (start == Double.NEGATIVE_INFINITY) {
            result.append("-∞");
        } else {
            result.append(String.format("%.3f", start));
        }

        result.append("; ");

        if (end == Double.POSITIVE_INFINITY) {
            result.append("+∞");
        } else {
            result.append(String.format("%.3f", end));
        }

        if (endInclude && end != Double.POSITIVE_INFINITY) {
            result.append("]");
        } else {
            result.append(")");
        }

        return result.toString();
    }
}
