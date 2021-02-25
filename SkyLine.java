
package skyline;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;



public class SkyLine {
    
    ListDoublePoints LP1;
    ListDoublePoints LP2;
    
    public void readFromFile(String filepath,String spliter){
        Path file = Paths.get(filepath);
        if(Files.exists(file) && Files.isReadable(file)) {
            try {
                try (BufferedReader reader = Files.newBufferedReader(file, Charset.defaultCharset())) {
                    String line;
                    String[] pointers = new String[2];
                    while((line = reader.readLine()) != null) {
                        pointers = line.split(spliter);
                        this.LP1.List.add(new DoublePoint(Double.parseDouble(pointers[0]),Double.parseDouble(pointers[1])));
                        this.LP1.Pointers.add(1);
                        this.LP2.List.add(new DoublePoint(Double.parseDouble(pointers[0]),Double.parseDouble(pointers[1])));
                        this.LP2.Pointers.add(1);
                    }
                }
            } 
            catch (IOException | NumberFormatException e) {
            }
        }
    }//αναγνωση σημείων από αρχείο
    
    public static void main(String[] args) {
        int i;
        
        SkyLine SL = new SkyLine();
        SL.LP1 = new ListDoublePoints();
        SL.LP2 = new ListDoublePoints();
        double x,y;
        Random R = new Random();
        int[] Rounds = {1000,10000,100000,1000000};
        for (int k = 0;k<4;k++){
            System.out.println(Rounds[k]+" Points");
            for (i = 0;i<Rounds[k];i++){
                
                double x1 = R.nextDouble()*10000;
                double x2 = R.nextDouble()*10000;
                
                SL.LP1.List.add(new DoublePoint(x1,x2));
                SL.LP1.Pointers.add(1);
                SL.LP2.List.add(new DoublePoint(x1,x2));
                SL.LP2.Pointers.add(1);
            }
            
            //ΑΝΑΓΝΩΣΗ ΑΠΟ ΑΡΧΕΙΟ 
            //readFromFile("c:\\arxeio.txt",",");
            int dt1 = SL.LP1.SkyLineAlg1();
            System.out.println("Results");
            System.out.println("Algo 1 SKYLINE ("+ dt1+")");
            
            int dt2 = SL.LP2.SkyLineAlg2();
            System.out.println("Algo 2 SKYLINE ("+ dt2+")");
           
        }
    }
    
}
