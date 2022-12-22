/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codefiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

/**
 *
 * @author Lenovo
 */
public class decompress {
    
    public static void decompressFunction(File file) throws FileNotFoundException, IOException{
        String dir=file.getParent();
        //System.out.println(dir);
        
        FileInputStream fis= new FileInputStream(file);
        GZIPInputStream gzipIS= new GZIPInputStream (fis);
        FileOutputStream fos= new FileOutputStream(dir+"/DecompressedFile.txt");
        
        byte[] buffer= new byte[1024];
        int len;
        
        while((len=gzipIS.read(buffer))!=-1){
            fos.write(buffer,0,len);
        }
        gzipIS.close();
        fis.close();
        fos.close();
    }
    public static void main(String[] args) throws IOException{
        File path= new File("C:\\Users\\Lenovo\\Desktop\\Minor Project 1\\CompressedFile.gz");
        
        decompressFunction(path);
    }
    
}
