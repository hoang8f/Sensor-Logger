package experia.GetData.model;

import org.la4j.vector.Vector;

public class Quaternion {
    private final double x0, x1, x2, x3;

    // create a new object with the given components
    public Quaternion(double x0, double x1, double x2, double x3) {
        this.x0 = x0;
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
    }

    public Quaternion(Vector vector) {
        this.x0 = vector.get(0);
        this.x1 = vector.get(1);
        this.x2 = vector.get(2);
        this.x3 = vector.get(3);
    }

    // return a string representation of the invoking object
    public String toString() {
//        return x0 + " + " + x1 + "i + " + x2 + "j + " + x3 + "k";
        return x0 + " " + x1 + " " + x2 + " " + x3 + "";
    }

    // return the quaternion norm
    public double norm() {
        return Math.sqrt(x0 * x0 + x1 * x1 + x2 * x2 + x3 * x3);
    }

    // return the quaternion conjugate
    public Quaternion conjugate() {
        return new Quaternion(x0, -x1, -x2, -x3);
    }

    // return a new Quaternion whose value is (this + b)
    public Quaternion plus(Quaternion b) {
        Quaternion a = this;
        return new Quaternion(a.x0 + b.x0, a.x1 + b.x1, a.x2 + b.x2, a.x3 + b.x3);
    }

    // return a new Quaternion whose value is (this * b)
    public Quaternion times(Quaternion b) {
        Quaternion a = this;
        double y0 = a.x0 * b.x0 - a.x1 * b.x1 - a.x2 * b.x2 - a.x3 * b.x3;
        double y1 = a.x0 * b.x1 + a.x1 * b.x0 + a.x2 * b.x3 - a.x3 * b.x2;
        double y2 = a.x0 * b.x2 - a.x1 * b.x3 + a.x2 * b.x0 + a.x3 * b.x1;
        double y3 = a.x0 * b.x3 + a.x1 * b.x2 - a.x2 * b.x1 + a.x3 * b.x0;
        return new Quaternion(y0, y1, y2, y3);
    }

    // return a new Quaternion whose value is the inverse of this
    public Quaternion inverse() {
        double d = x0 * x0 + x1 * x1 + x2 * x2 + x3 * x3;
        return new Quaternion(x0 / d, -x1 / d, -x2 / d, -x3 / d);
    }

    // return a / b
    public Quaternion divides(Quaternion b) {
        Quaternion a = this;
        return a.inverse().times(b);
    }
}
