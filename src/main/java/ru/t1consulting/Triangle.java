package ru.t1consulting;


public class Triangle {
    private int a;
    private int b;
    private int c;

    public Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
        checkSidesArePositive();
        checkValidTriangle();
    }

    private void checkValidTriangle() {
        if (a >= b + c || b >= a + c || c >= b + a) {
            throw new IllegalArgumentException("Triangle is invalid: one side greater than sum of another sides");
        }
    }

    private void checkSidesArePositive() {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Triangle is invalid: sides must be positive");
        }
    }

    public int countPerimeter() {
        return a + b + c;
    }

    public boolean hasTheSamePerimeter(Triangle triangle) {
        if (triangle == null) return false;
        return this.countPerimeter() == triangle.countPerimeter();
    }
}
