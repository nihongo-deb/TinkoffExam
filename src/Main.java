import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String s = scanner.nextLine();
        String colors = scanner.nextLine();

        List<String> colorsList = new ArrayList<>();
        List<String> sArray = Arrays.stream(s.split(" ")).toList();
        int errors = 0;


        for (int i = 0; i < sArray.size(); i++){
            int length = sArray.get(i).length();
            colorsList.add(colors.substring(0, length));
            colors = colors.replaceFirst(colors.substring(0, length), "");
        }

        for (String color : colorsList){
            for (int i = 0; i < color.length() - 1; i++){
                if(color.charAt(i) == color.charAt(i + 1)) {
                    errors++;
                    break;
                }
            }
        }

        System.out.println(errors);
    }
}
