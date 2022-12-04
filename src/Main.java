import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int a = 1;
        int b = num - 1;

        int minNOK = nok(a, b);
        int retA = a;
        int retB = b;

        int iterNok;
         for (int i = 0; i < num / 2; i++){
             a++;
             b--;
             iterNok = nok(a, b);
             if (iterNok < minNOK){
                 minNOK = iterNok;
                 retA = a;
                 retB = b;
             }
         }

        System.out.println(retA + " " + retB);
    }

    static int nod(int a,int b){
        return b == 0 ? a : nod(b,a % b);
    }

    static int nok(int a,int b){
        return a / nod(a,b) * b;
    }
}
