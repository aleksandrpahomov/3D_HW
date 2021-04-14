package com.matMod3d;

/*
Класс Линии. В контексте решаемой задачи Линия-цилиндр, обтягивающий отрезок.
Поля
Первая точка отрезка(start)
Вторая точка(end)
Вершины
Грани
 */

import java.util.ArrayList;

public class Line_3D {
    Point_3D start;
    Point_3D end;
    ArrayList<Point_3D> Vertexes;
    ArrayList<ArrayList<Integer>> Faces;
    Line_3D(Point_3D s,Point_3D e, Double R)
    {
        Vertexes= new ArrayList<>();
        Faces=new ArrayList<>();
        ArrayList<Circle_3D> circlesOnLine= new ArrayList<Circle_3D>();
        Vector_3D normal=new Vector_3D();
        normal.coord.setX(s.getX()-e.getX());
        normal.coord.setY(s.getY()-e.getY());
        normal.coord.setZ(s.getZ()-e.getZ());
        Circle_3D st=new Circle_3D(s,R,normal);
        circlesOnLine.add(st);
        Vertexes.addAll(st.onCirclePoints);
        circlesOnLine.add(new Circle_3D(e,R,normal));
        Vertexes.addAll(circlesOnLine.get(circlesOnLine.size()-1).onCirclePoints);
        Integer numOfFaces=Vertexes.size()/2;
        for(int i=0;i<numOfFaces;i++)
        {
            ArrayList<Integer> Face=new ArrayList<Integer>();
            Face.add(i);
            Face.add(i+numOfFaces);
            Face.add((i+numOfFaces+1)%(Vertexes.size()));
            Face.add(i+1);
            Faces.add(Face);
        }
        this.start=s;
        this.end=e;
    }
    public ArrayList<Point_3D> generatePointsDistribution(Point_3D start, Point_3D end,Integer numOfPoints)
    {
        ArrayList<Point_3D> res=new ArrayList<Point_3D>();
        Double step=length()/numOfPoints;
        for(int i=0;i<numOfPoints;i++)
        {
            Point_3D temp= new Point_3D(start.getX()+step,start.getY()+step,start.getZ()+step);
            res.add(temp);
        }
        return res;
    }
    private double length()
    {
        return Math.sqrt(Math.pow((this.start.getX())-this.end.getX(),2)+ Math.pow((this.start.getY())-this.end.getY(),2)+Math.pow((this.start.getZ())-this.end.getZ(),2));
    }
}
