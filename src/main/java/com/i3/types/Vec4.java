package com.i3.types;

public class Vec4 {
    double x;
    double y;
    double z;
    double rotation;

    public Vec4(final double x, final double y, final double z, final double rotation) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.rotation = rotation;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getZ() {
        return this.z;
    }

    public double getRotation() {
        return this.rotation;
    }
}
