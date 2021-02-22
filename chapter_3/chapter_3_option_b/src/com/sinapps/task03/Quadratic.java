package com.sinapps.task03;

public class Quadratic {
    // уравнение вида a*x^2 + b*x + c = 0
    private double a;
    private double b;
    private double c;

    public Quadratic(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getDiscriminant() {
        return Math.pow(b, 2) - 4 * a * c;
    }

    public double[] getRoots() {
        double discriminant = getDiscriminant();
        double[] result;

        if (discriminant < 0) {
            result = new double[0];
        } else if (discriminant == 0) {
            result = new double[1];
            result[0] = (-b + Math.sqrt(discriminant)) / (2 * a);
        } else {
            result = new double[2];
            result[0] = (-b + Math.sqrt(discriminant)) / (2 * a);
            result[1] = (-b - Math.sqrt(discriminant)) / (2 * a);
        }

        return result;
    }

    public Point getExtremum() {
        return new Point(-b / (2 * a), c - (Math.pow(b, 2) / (4 * a)));
    }

    public Interval getDecreasingInterval() {
        return (a > 0) ? new Interval(Double.NEGATIVE_INFINITY, getExtremum().getX()) :
                new Interval(getExtremum().getX(), Double.POSITIVE_INFINITY);
    }

    public Interval getRiseInterval() {
        return (a > 0) ? new Interval(getExtremum().getX(), Double.POSITIVE_INFINITY) :
                new Interval(Double.NEGATIVE_INFINITY, getExtremum().getX());
    }

    @Override
    public String toString() {
        double[] roots = getRoots();
        StringBuilder result = new StringBuilder();
        result.append("Квадратное уравнение: ").
                append(String.format("%.3f", a)).
                append("*x^2 + ").
                append(String.format("%.3f", b)).
                append("*x + ").
                append(String.format("%.3f", c)).
                append(" = 0.\n\tКоличество корней: ").
                append(roots.length);
        ;
        if (roots.length == 1) {
           result.append("\n\tКорень x = ").append(roots[0]);
        } else if (roots.length > 1) {
            result.append("\n\tКорни: x1 = ").append(String.format("%.3f", roots[0])).
                    append("; x2 = ").append(String.format("%.3f", roots[1]));
        }

        result.append("\nЭкстремум функции: ").append(getExtremum());
        result.append("\nИтервал убывания: ").append(getDecreasingInterval());
        result.append("\nИнтервал возрастания: ").append(getRiseInterval());

        return result.toString();
    }
}
