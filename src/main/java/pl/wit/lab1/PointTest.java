package pl.wit.lab1;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {
    private float x = 5.0F;
    private float y = 1.5F;
    private Point pt;

    @BeforeEach
    void setUp() {
        this.pt = new Point(this.x, this.y);
    }

    @AfterEach
    void tearDown() {
        this.pt = null;
    }

    @org.junit.jupiter.api.Test
    void moveX() {
        this.pt.moveX(1);

        assertEquals(6.0, this.pt.getX());
    }

    @org.junit.jupiter.api.Test
    void moveY() {
        this.pt.moveY(-2);

        assertEquals(-0.5, this.pt.getY());
    }

    @org.junit.jupiter.api.Test
    void add() {
        float dx = 12, dy = -6;
        Point p1 = new Point(dx, dy);

        this.pt.add(p1);

        assertEquals(this.x+dx, this.pt.getX());
        assertEquals(this.y+dy, this.pt.getY());
    }

    @org.junit.jupiter.api.Test
    void substract() {
        float dx = 10, dy = -8;
        Point p1 = new Point(dx, dy);

        this.pt.substract(p1);

        assertEquals(this.x-dx, this.pt.getX());
        assertEquals(this.y-dy, this.pt.getY());
    }

    @org.junit.jupiter.api.Test
    void addPoint() {
        float dx = 10, dy = -8;
        Point p1 = this.pt.addPoint(new Point(dx, dy));

        assertEquals(this.pt.getX()+dx, p1.getX());
        assertEquals(this.pt.getY()+dy, p1.getY());
    }
}