package org.JFarrow.Core;

public class PositionComponent {
    private final double x;
    private final double y;

    public PositionComponent(double x, double y){
        this.x  = x;
        this.y = y;
    }

    public PositionComponent(int x, int y){
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int intX(){
        return (int) Math.round(x);
    }

    public int intY(){
        return (int) Math.round(y);
    }

    @Override
    public String toString() {
        return String.format("row: %s, col: %s", x, y);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof PositionComponent p){
            return p.x == this.x && p.y == this.y;
        }
        return false;
    }
}
