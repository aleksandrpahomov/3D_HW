package com.matMod3d;
import java.util.ArrayList;
import java.util.Scanner;

public class Application {


    public static void main(String[] args)
    {

        //Псевдосфера
        Creator.createPseudoSphere();
        ArrayList<Point_3D> tetraPoints=new ArrayList<>();
        tetraPoints.add(new Point_3D(0,0,0));
        tetraPoints.add(new Point_3D(50,25,50));
        tetraPoints.add(new Point_3D(50,50,0));
        tetraPoints.add(new Point_3D(0,50,0));
        // Тетраэдр
        Creator.createTetrahedron(tetraPoints);
    }


}
