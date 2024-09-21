package mathme;

import java.util.Scanner;

public class circunferencia {

    public static void main (String [] args){
        Scanner sc = new Scanner(System.in);

        //dados da circunferencia:
        double cx0 = 2;
        double cy0 = 5;
        double raio = 3;

        //
        double x = Double.parseDouble(sc.nextLine());
        double y = Double.parseDouble(sc.nextLine());

        double firstTerm = Math.pow((x-cx0),2);
        double secTerm = Math.pow((y-cy0), 2);
        double r2 = Math.pow(raio, 2);

        double equacao = firstTerm + secTerm - r2;

        double eq = (Math.pow((x-cx0),2)+(Math.pow((y-cy0),2))-(Math.pow(raio,2)));

        System.out.println(eq);
        if (eq == 0){
            System.out.println("O ponto pertence a circunferencia!");
        } else {
            System.out.println("O ponto não pertence a circunferencia!");
        }

        sc.close();
    }

}