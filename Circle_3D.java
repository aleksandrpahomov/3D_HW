package com.matMod3d;

import java.util.ArrayList;

public class Circle_3D {
    Point_3D center;
    Double radius;
    ArrayList<Point_3D> onCirclePoints;
    Circle_3D(Point_3D c,Double Radius,Vector_3D normal)
    {
        onCirclePoints=new ArrayList<Point_3D>();
        ArrayList<Double> params=generateParametrs(0.0,2*Math.PI,100);

        Double A=normal.coord.getX();
        Double B=normal.coord.getY();
        Double C=normal.coord.getZ();
        //Параметрическое задание окружности
        for (Double t: params) {
            Point_3D element=new Point_3D();
            if(A*A+C*C<0.001)
            {
                element.setX(c.getX()+Radius*Math.cos(t));
                element.setY(c.getY());
                element.setZ(c.getZ()+Radius*Math.sin(t));
            }
            else
            {
                element.setX(c.getX()+(Radius/Math.sqrt(A*A+C*C))*(C*Math.cos(t)-A*B*Math.sin(t)/Math.sqrt(A*A+B*B*C*C)));
                element.setY(c.getY()+ Radius*Math.sqrt(A*A+C*C)/Math.sqrt(A*A+B*B+C*C)*Math.sin(t));
                element.setZ(c.getZ()-(Radius/Math.sqrt(A*A+C*C))*(A*Math.cos(t)+B*C*Math.sin(t)/Math.sqrt(A*A+B*B*C*C)));
            }
            onCirclePoints.add(element);
        }

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
