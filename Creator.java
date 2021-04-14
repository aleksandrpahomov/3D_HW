package com.matMod3d;

import java.util.ArrayList;
/*
Класс Creator. Вынес сюда методы, создающие Отдельные фигуры.
Содержит статические методы для удобной работы.
 */
public class Creator {
    public static void createPseudoSphere()
    {
        String fileSphere="pseudoSphere.ply";
        pseudoSphere_3D P=new pseudoSphere_3D(new Point_3D(0,0,0),5.0);
        PLY spherePLY=new PLY(P.Vertexes,P.Faces,fileSphere);
    }
    public static void createTetrahedron(ArrayList<Point_3D> points)
    {
        Double Radius=2.0;
        ArrayList<Point_3D> resVertexes=new ArrayList<>();
        ArrayList<ArrayList<Integer>> resFaces=new ArrayList<>();
        for(int i=0;i<points.size();i++)
        {
            Sphere_3D s=new Sphere_3D(points.get(i),Radius);
            for(int j=0;j<s.Faces.size();j++)
            {
                ArrayList<Integer> temp=new ArrayList<>();
                for(int k=0;k<s.Faces.get(j).size();k++)
                {
                    temp.add( s.Faces.get(j).get(k)+resVertexes.size());
                }
                s.Faces.set(j,temp);
            }
            resVertexes.addAll(s.Vertexes);
            resFaces.addAll(s.Faces);
        }
        //Add Edges
        for(int i=0;i<points.size()-1;i++)
        {
           for(int j=i+1;j<points.size();j++)
           {
               Line_3D line=new Line_3D(points.get(i),points.get(j),Radius-1.0);
               for(int k=0;k<line.Faces.size();k++)
               {
                   ArrayList<Integer> temp=new ArrayList<>();
                   for (int l=0;l<line.Faces.get(k).size();l++)
                   {
                       temp.add(line.Faces.get(k).get(l)+resVertexes.size());
                   }
                   line.Faces.set(k,temp);
               }
               resFaces.addAll(line.Faces);
               resVertexes.addAll(line.Vertexes);
           }
        }
        String fileName="tetra.ply";
        PLY spherePLY=new PLY(resVertexes,resFaces,fileName);
    }
}
