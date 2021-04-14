package com.matMod3d;
/*
Класс Вектор.
По сути, хранит начальную и конечную точку веткора, и его координаты.
 */
public class Vector_3D {
    Point_3D start;
    Point_3D end;
    Point_3D coord;
    Vector_3D(){
        start=new Point_3D(0,0,0);
        end=new Point_3D(0,0,0);
        coord=new Point_3D(0,0,0);
    }
}
