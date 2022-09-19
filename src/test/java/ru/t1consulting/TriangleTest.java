package ru.t1consulting;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TriangleTest {
    @Test
    @DisplayName("Периметр прямоугольного треугольника")
    public void countPerimeter3_4_5_TriangleSuccessfulTest() {
        Triangle triangle = new Triangle(3, 4, 5); // создаем треугольник со сторонами 3,4,5
        int perimeter = triangle.countPerimeter(); // получаем периметр, воспользовавшись методом countPerimeter
        assertEquals(12, perimeter); // проверяем, что периметр равен 12
    }

    @Test
    @DisplayName("Периметр тупоугольного треугольника")
    public void countPerimeterTriangleWithAngleGreaterThan90SuccessfulTest() {
        Triangle triangle = new Triangle(3, 4, 6);
        int perimeter = triangle.countPerimeter();
        assertEquals(13, perimeter);
    }

    @Test
    @DisplayName("Периметр правильного треугольника")
    public void countPerimeterRightTriangleSuccessfulTest() {
        Triangle triangle = new Triangle(3, 3, 3);
        int perimeter = triangle.countPerimeter();
        assertEquals(9, perimeter);
    }

    public static Stream<Arguments> triangles() {
        return Stream.of(Arguments.of(new Triangle(3, 4, 5), 12),
                Arguments.of(new Triangle(3, 4, 6), 13),
                Arguments.of(new Triangle(3, 3, 3), 9));
    }

    @ParameterizedTest(name = "Периметр треугольника {0} должен быть равен {1}")
    @MethodSource("triangles")
    @DisplayName("Периметр треугольника: позитивный сценарий")
    public void countPerimeterTriangleSuccessfulTest(Triangle triangle, int expectedPerimeter) {
        int perimeter = triangle.countPerimeter();
        assertEquals(expectedPerimeter, perimeter);
    }

    @ParameterizedTest(name = "Периметр треугольника {0} должен быть равен {1}")
    @CsvSource({"3, 4, 5, 12",
            "3, 4, 6, 13",
            "3, 3, 3, 9"
    })
    @DisplayName("Периметр треугольника: позитивный сценарий")
    public void countPerimeterTriangleFromCsvSourceSuccessfulTest(int a, int b, int c, int expectedPerimeter) {
        int perimeter = new Triangle(a, b, c).countPerimeter();
        assertEquals(expectedPerimeter, perimeter);
    }

    @ParameterizedTest
    @CsvSource({"3, 3, 6, 'Triangle is invalid: one side greater than sum of another sides'",
            "-3, 3, 3, 'Triangle is invalid: sides must be positive'",
            "3, 0, 3, 'Triangle is invalid: sides must be positive'"
    })
    @DisplayName("Периметр треугольника: негативные сценарии")
    public void invalidTriangleErrorTest(int a, int b, int c, String errorText) {
        IllegalArgumentException illegalArgumentException =
                assertThrows(IllegalArgumentException.class, () -> new Triangle(a, b, c));
        assertEquals(errorText, illegalArgumentException.getMessage());
    }


}
