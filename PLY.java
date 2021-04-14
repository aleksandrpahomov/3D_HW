package com.matMod3d;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/*Класс PLY
Здесь реализована генерация файла по списку вершин и Граней.
 */

public class PLY {

    private File thisFile;
    private String rootDir="C://Users//Aleksandr//IdeaProjects//MatMod_3d//Res";
    private String fileName;

    PLY(ArrayList<Point_3D> vertexData,ArrayList<ArrayList<Integer>> faceData,String inputFileName) {
        this.fileName=inputFileName;
        this.thisFile = new File(this.rootDir,this.fileName);
        createFileFromArrays(vertexData,faceData);
    }

    private void createFileFromArrays(ArrayList<Point_3D> Vertexes,ArrayList<ArrayList<Integer>> Faces){
        String vertexesSize = Integer.toString(Vertexes.size());
        String facesSize = Integer.toString(Faces.size());
        String Res="ply \n format ascii 1.0 \n " +
                "element vertex "+ vertexesSize +"\n property float x \n property float y \n property float z \n" +
                " element face " + facesSize + "\n property list uchar int vertex_index \n " +
                "end_header \n";
        for(int i = 0;i< Vertexes.size();i++)
            Res+=Vertexes.get(i).toStringForPLY() +"\n";


        for(int i = 0;i< Faces.size();i++) {
            Res += Faces.get(i).size() ;
            for(int j=0;j<Faces.get(i).size();j++){
                Res+=" "+ Integer.toString(Faces.get(i).get(j));
            }
            Res+="\n";
        }

        try (FileOutputStream FOS =new FileOutputStream(this.rootDir+"\\"+this.fileName))
        {
            byte[] buffer = Res.getBytes();
            FOS.write(buffer, 0, buffer.length);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public  File getFile() {
        File k=new File("C");
        return k;
    }
}
