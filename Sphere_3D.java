package com.matMod3d;

import java.util.ArrayList;
/*
Класс Сферы.
Поля:
 Центр
 Радиус
 Вершины
 Грани
Конструктор реализует параметрическое задание фигуры
Метод generateParameters генерирует список значений от начальной точки до конечной по числу шагов.Распределние точек -равномерное.
 */

public class Sphere_3D {
    Point_3D center;
    Double Radius;
    ArrayList<Point_3D> Vertexes;
    ArrayList<ArrayList<Integer>> Faces;
    Sphere_3D(Point_3D c,Double R)
    {
        Vertexes= new ArrayList<>();
        Faces=new ArrayList<>();
        ArrayList<Double> t_list = generateParametrs(0.0,Math.PI,100);
        ArrayList<Double> p_list = generateParametrs(0.0,2*Math.PI,100);

        for(double t:t_list)
        {
            for(double p:p_list)
            {
                Point_3D element=new Point_3D();
                element.setX(c.getX()+R*Math.sin(t)*Math.cos(p));
                element.setY(c.getY()+R*Math.sin(t)*Math.sin(p));
                element.setZ(c.getZ()+R*Math.cos(t));
                Vertexes.add(element);
            }
        }
        Integer dim = p_list.size();
        for(int i=0;i<Vertexes.size()-dim;i++)
        {
            ArrayList<Integer> Face=new ArrayList<Integer>();
            Face.add(i);
            Face.add(i+dim);
            Face.add((i+dim+1)%(Vertexes.size()));
            Face.add(i+1);
            Faces.add(Face);
        }
        this.center=c;
        this.Radius=R;
    }
    public static ArrayList<Double> generateParametrs(Double start,Double end,Integer numOfPoints)
    {
        ArrayList<Double> res=new ArrayList<Double>();
        Double step=(Math.abs(end-start)/numOfPoints);
        Double temp = start;
        while (temp<=end)
        {
            res.add(temp);
            temp+=step;
        }
        return res;
    }
}
