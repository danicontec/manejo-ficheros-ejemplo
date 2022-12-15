package stream;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EntryBytes {
  public void readBytes(){
      try {
          List<Integer>data = new ArrayList<>();
          FileInputStream fileBytes = new FileInputStream("imagenes/female_reference.jpg");
          int bytes = 0;
          int segments = 0;
          boolean state = false;
          String console = "";
          while(!state){
              bytes = fileBytes.read();
              if (bytes!=-1){
                  System.out.println("Fichero leido con exito.");
                  data.add(segments,bytes);
              }
              else{
                  state = true;
              }
              segments++;
          }
          for(int i = 0; i< data.size();i++) {
              System.out.println(data.get(i));
          }

              System.out.println("Desea crear copia del archivo? S/N");
              Scanner sc = new Scanner(System.in);
              String answer = sc.next();
              console = String.valueOf(answer.charAt(0)).toUpperCase();
              System.out.println(console);
              boolean choose = false;

          while((!console.equalsIgnoreCase("s") || !console.equalsIgnoreCase("n")) && !choose){
              System.out.println("Solo S o N");
              answer = sc.next();
              console = String.valueOf(answer.charAt(0)).toUpperCase();
              if(console.equalsIgnoreCase("s") || console.equalsIgnoreCase("n"))
                  choose = true;
          }

          if (console.equalsIgnoreCase("s")) {
              System.out.println("Copiando datos");
              copyBytes(data);
          }
          if (console.equalsIgnoreCase("n")) {
              System.out.println("Programa finalizado");
          }
          fileBytes.close();
      } catch (IOException io){
          System.out.println("No se encuentra la ruta del archivo");
      }

  }
  public void copyBytes(List<Integer> data){
      try {
          FileOutputStream path = new FileOutputStream("imagenes/copia.png");
          for(int i = 0; i< data.size(); i++){
            path.write(data.get(i));
          }
      }catch(FileNotFoundException fnf){
          System.out.println("No se encuentra el fichero");
      }
      catch (IOException io){
          System.out.println("No se pudo copiar el fichero");
      }
  }
}
