package com.sinapps.task03;

public class QuadraticArrayUtils {
    public static double findMinimalRoot(Quadratic[] arr) {
        double result = Double.NEGATIVE_INFINITY;
        int i = 0;
        while (i < arr.length) {
            if (arr[i].getRoots().length == 1) {
                result = arr[i].getRoots()[i];
                break;
            } else if (arr[i].getRoots().length == 2) {
                result = Math.min(arr[i].getRoots()[0], arr[i].getRoots()[1]);
                break;
            } else {
                i++;
            }
        }

        if (result != Double.NEGATIVE_INFINITY){
            i++;

            for (int index = i; index < arr.length; index++) {
                if (arr[index].getRoots().length == 1) {
                    result = Math.min(result, arr[index].getRoots()[0]);
                } else if (arr[index].getRoots().length == 2) {
                    double value = Math.min(arr[index].getRoots()[0], arr[index].getRoots()[1]);
                    result = Math.min(result, value);
                }
            }
        }

        return result;
    }

    public static double findMaximalRoot(Quadratic[] arr) {
        double result = Double.NEGATIVE_INFINITY;
        int i = 0;
        while (i < arr.length) {
            if (arr[i].getRoots().length == 1) {
                result = arr[i].getRoots()[i];
                break;
            } else if (arr[i].getRoots().length == 2) {
                result = Math.max(arr[i].getRoots()[0], arr[i].getRoots()[1]);
                break;
            } else {
                i++;
            }
        }

        if (result != Double.NEGATIVE_INFINITY){
            for (int index = i; index < arr.length; index++) {
                if (arr[index].getRoots().length == 1) {
                    result = Math.max(result, arr[index].getRoots()[0]);
                } else if (arr[index].getRoots().length == 2) {
                    double value = Math.max(arr[index].getRoots()[0], arr[index].getRoots()[1]);
                    result = Math.max(result, value);
                }
            }
        }

        return result;
    }

}
