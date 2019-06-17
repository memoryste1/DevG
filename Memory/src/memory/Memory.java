/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memory;

import java.util.HashMap;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import javax.imageio.ImageIO;


/**
 *
 * @author Slyvain
 */
public class Memory {
    HashMap<String, Object> map = new HashMap<String, Object>();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }                
    
    /***
     * @author Théo
     */
    public void getPictures(){
        int i = map.size();
        i++;
        String url="./"+i+".png";
        //map.put(map.size(), ImageIO.read(getClass().getResource("/images/c.png")));
    }
}
