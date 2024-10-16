package math;

public class elipse {

    public static boolean pertenceElipse(double x, double y) {
        double a = 2;
        double b = 3;
        double epsilon = 1e-6;  // margem de erro para comparação com 1

        double elipse = (Math.pow(x, 2) / Math.pow(a, 2)) + (Math.pow(y, 2) / Math.pow(b, 2));

        return Math.abs(elipse - 1) < epsilon;
    }

    public static void main(String[] args) {
        int quant = 1000000;

        for (int k = 0; k < quant; k++) {
            double r = Math.random()*100000;
            double s = Math.random()*100000;
            if (pertenceElipse(r, s)) {
                System.out.println(r + " e " + s + " pertencem à elipse");
            }
        }
    }
}