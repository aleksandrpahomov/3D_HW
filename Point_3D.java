package com.matMod3d;
/*
Класс Точки
Поля -координаты точки
Методы Set и Get для работы с ними.
Метод toStringForPLY преобразует точки в нужны формат для PLY файла
 */
public class Point_3D {
    private double X;
    private double Y;
    private double Z;

    Point_3D()
    {
        this.X=0;
        this.Y=0;
        this.Z=0;
    }

    Point_3D(double x, double y, double z) {
        this.X=x;
        this.Y=y;
        this.Z=z;
    }

    public static double spaceBetweenPoints(Point_3D A,Point_3D B) {
        return (double) Math.sqrt(Math.pow(A.X- B.X,2)+Math.pow(A.Y- B.Y,2)+Math.pow(A.Z- B.Z,2));
    }
    public Point_3D getPoint_3D(){
        return this;
    }
    public double getX(){
        return this.X;
    }

    public double getY() {
        return this.Y;
    }

    public double getZ() {
        return this.Z;
    }
    public void setX(Double x)
    {
        this.X = x;
    }
    public void setY(Double y)
    {
        this.Y = y;
    }
    public void setZ(Double z)
    {
        this.Z = z;
    }
    public String toStringForPLY(){
        return String.format("%.2f",this.X).replace(',','.')+" "+ String.format("%.2f",this.Y).replace(',','.')+" "+ String.format("%.2f",this.Z).replace(',','.');
    }
}
