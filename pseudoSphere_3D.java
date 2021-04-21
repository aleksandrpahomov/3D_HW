package com.matMod3d;

import java.util.ArrayList;

/*
Класс Псевдосферы.
Поля:
 Центр
 Радиус
 Вершины
 Грани
Конструктор реализует параметрическое задание фигуры
Метод generateParameters генерирует список значений от начальной точки до конечной по числу шагов.Распределние точек -равномерное.
 */
public class pseudoSphere_3D {
    Point_3D center;
    Double Radius;
    ArrayList<Point_3D> Vertexes;
    ArrayList<ArrayList<Integer>> Faces;
    pseudoSphere_3D(Point_3D c,Double R)
    {
        Vertexes= new ArrayList<>();
        Faces=new ArrayList<>();
        ArrayList<Double> t_list = generateParameters(0.2,Math.PI-0.2,100);
        ArrayList<Double> p_list = generateParameters(0.0,2*Math.PI,100);

        for(double t:t_list)
        {
            for(double p:p_list)
            {
                Point_3D element=new Point_3D();
                element.setX(c.getX()+R*Math.sin(t)*Math.cos(p));
                element.setY(c.getY()+R*Math.sin(t)*Math.sin(p));
                element.setZ(c.getZ()+R*(Math.cos(t)+Math.log(Math.tan(t/2))));
                Vertexes.add(element);
            }
        }
        Integer dim = p_list.size();
        for(int i=0;i<Vertexes.size()-dim;i++)
        {
            ArrayList<Integer> Face=new ArrayList<Integer>();
            Face.add(i);
            Face.add(i+dim);
            if(i%dim!=dim-1) {
                Face.add((i + dim + 1) % (Vertexes.size()));
                Face.add(i + 1);
            }
            else
            {
                Face.add(i+1);
                Face.add(i+1-dim);
            }
            Faces.add(Face);
        }

        /*ArrayList<Integer> Face=new ArrayList<Integer>();
        Face.add(0);
        Face.add(Vertexes.size()-2);
        Face.add(Vertexes.size()-1);
        Face.add(1);
        Faces.add(Face);

         */
        Point_3D c1=new Point_3D(c.getX(),c.getY(),Vertexes.get(0).getZ());
        Point_3D c2 = new Point_3D(c.getX(),c.getY(),Vertexes.get(Vertexes.size()-1).getZ());
        for (int i=0;i<dim;i++) {
            ArrayList<Integer> Face=new ArrayList<Integer>();
            Face.add(Vertexes.size());//Добавляем сайз, потому что центр будет с таким индексом
            if(i!=dim-1) {
                Face.add(i);
                Face.add(i + 1);
            }
            else
            {
                Face.add(i);
                Face.add(0);
            }
            Faces.add(Face);
        }
        for (int i=0;i<dim;i++) {
            ArrayList<Integer> Face=new ArrayList<Integer>();
            Face.add(Vertexes.size()+1);//Добавляем сайз+1, потому что центр будет с таким индексом
            if(i!=dim-1) {
                Face.add(Vertexes.size()-i-1);
                Face.add(Vertexes.size()-i-2);
            }
            else
            {
                Face.add(Vertexes.size()-i-1);
                Face.add(Vertexes.size()-1);
            }
            Faces.add(Face);
        }
        Vertexes.add(c1);
        Vertexes.add(c2);
        this.center=c;
        this.Radius=R;

    }
    public static ArrayList<Double> generateParameters(Double start,Double end,Integer numOfPoints)
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
