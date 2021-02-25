import java.util.Scanner;

 

public class Average {

  public int[] numbers;

  public static double average;


  protected static double mesosOros(int numbers[]) {

      double average=0;

      int sum=0;

      for(int i=0; i<6; i++)
        sum += numbers[i];

      average = (double) sum / 6;

      return average;

  }


  public static void main(String args[]){

     int[] numbers = new int[6];

     Scanner scnr = new Scanner(System.in);

     for (int i=0; i<6; i++) {
        System.out.println("Δώσε αριθμό:");
        numbers[i] = scnr.nextInt();
      }

      average = mesosOros(numbers); 

     System.out.println("The value is " + average);

  }

}