package pl.wit.lab1;

/**
 * Ta klasa reprezentuje położenie punktu na płaszczyźnie.
 *
 * @author Julian Bednarz
 */
public class Point {
    private float x;
    private float y;

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void moveX(float dx) {
        this.setX(this.getX()+dx);
    }

    public void moveY(float dy) {
        this.setY(this.getY()+dy);
    }

    public void add(Point pt) {
        this.moveX(pt.x);
        this.moveY(pt.y);
    }

    public void substract(Point pt) {
        this.moveX(-pt.x);
        this.moveY(-pt.y);
    }

    public Point addPoint(Point pt) {
        return new Point(this.x + pt.x, this.y + pt.y);
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
}
