import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(findS(n));
        System.out.println(findR(n));
        System.out.println(findDeflectionAngle(n));

        double angel = findAngle(n);
        double defAng = findDeflectionAngle(n);
        ArrayList<Vert> verts = new ArrayList<>();
        verts.add(new Vert(0.0, 0.0));

        for (int i = 1; i < n; i++){
            verts.add(findNewVertByDefAngle(
                    verts.get(i - 1),
                    defAng
            ));
            defAng -= angel;
            System.out.println(verts.get(i));
        }
    }

    static double findS(int n){
        double R = 1/(2*Math.sin(Math.PI/n));
        return 0.5 * R * R * n * Math.sin(Math.PI * 2 /n);
    }

    static double findR(int n){
        return 1/(2*Math.sin(Math.PI/n));
    }

    static double findDeflectionAngle(int n){
        return (Math.PI - findAngle(n))/2;
    }

    static double findAngle(int n){
        return (n-2) * Math.PI / n;
    }

    static Vert findNewVertByDefAngle(Vert vert, double defAngle){
        return new Vert(vert.x + Math.cos(defAngle), vert.y + Math.sin(defAngle));
    }

    static double findTriangleSquare(Vert v1, Vert v2, Vert v3){
        return 0.5 * Math.abs((v2.x - v1.x) * (v3.y-v1.y) - (v3.x - v1.x) * (v2.y - v1.y));
    }

    static class Vert{
        public Vert(double x, double y) {
            this.x = x;
            this.y = y;
        }

        double x;
        double y;

        @Override
        public String toString() {
            return "(" + x + "\t" + y + ")";
        }
    }
}
