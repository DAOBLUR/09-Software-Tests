package utest.evidencia1.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import utest.evidencia1.clases.Area;

class AreaTest {

	@Test
    void testSurfaceAreaCubePositive() {
        double result = Area.surfaceAreaCube(3.0);
        assertEquals(54.0, result, 0.001);
    }

    @Test
    void testSurfaceAreaCubeNegative() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Area.surfaceAreaCube(-2.0);
        });
        assertEquals("Must be a positive sideLength", exception.getMessage());
    }

    @Test
    void testSurfaceAreaSpherePositive() {
        double result = Area.surfaceAreaSphere(2.0);
        assertEquals(50.265, result, 0.001);
    }

    @Test
    void testSurfaceAreaSphereNegative() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Area.surfaceAreaSphere(-1.0);
        });
        assertEquals("Must be a positive radius", exception.getMessage());
    }

    @Test
    void testSurfaceAreaRectanglePositive() {
        double result = Area.surfaceAreaRectangle(5.0, 3.0);
        assertEquals(15.0, result, 0.001);
    }

    @Test
    void testSurfaceAreaRectangleNegativeLength() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Area.surfaceAreaRectangle(-5.0, 3.0);
        });
        assertEquals("Must be a positive length", exception.getMessage());
    }

    @Test
    void testSurfaceAreaRectangleNegativeWidth() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Area.surfaceAreaRectangle(5.0, -3.0);
        });
        assertEquals("Must be a positive width", exception.getMessage());
    }

    @Test
    void testSurfaceAreaCylinderPositive() {
        double result = Area.surfaceAreaCylinder(3.0, 5.0);
        assertEquals(150.796, result, 0.001);
    }

    @Test
    void testSurfaceAreaCylinderNegativeRadius() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Area.surfaceAreaCylinder(-3.0, 5.0);
        });
        assertEquals("Must be a positive radius", exception.getMessage());
    }

    @Test
    void testSurfaceAreaCylinderNegativeHeight() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Area.surfaceAreaCylinder(3.0, -5.0);
        });
        assertEquals("Must be a positive radius", exception.getMessage());
    }
}
