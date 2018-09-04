import java.io.*;
import java.nio.CharBuffer;
import java.util.Scanner;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) throws IOException {
        File list = new File("C:\\Users\\dreut\\OneDrive\\KTH\\Kurser\\DD2310 Javaprogrammering för Pythonprogrammerare\\Problem\\Regex\\src\\list.txt");
        Scanner sc = new Scanner(list);
        BufferedReader br = new BufferedReader(new FileReader(list));


        //while (sc.hasNextLine()) System.out.println(input.nextLine());
        String nextLine;

        //Pattern p = Pattern.compile("((?<=.{0})\d[.](.*)(?=([.]{50})))([.]{3,})");
        String input =  "1.1 The Evolution of Database Systems..................................................1";
        Pattern p = Pattern.compile("((?<=.{0})\\d+[.].*(?=[.]{50}))([.]{3,})(\\d+)");
        Matcher m;
        String s1,s2,s3;
        int g1,g2,g3,cL;

        while (br.readLine() != null) {
            nextLine = br.readLine();
            m = p.matcher(nextLine);
                while (m.find()) {
                    s1 = m.group(1);
                    s2 = m.group(2);
                    s3 = m.group(3);
                    g1 = m.group(1).length();
                    g2 = m.group(2).length();
                    g3 = m.group(3).length();
                    cL = 150 - (g1 + g2 + g3);
                    String dots = new String(new char[cL]).replace("\0", ".");
                    System.out.println(s1 + s2 + dots + s3);
                }
                if (!m.matches()) System.out.println(nextLine);
            }

    }

    private static void printAll() throws FileNotFoundException {
        File list = new File("C:\\Users\\dreut\\OneDrive\\KTH\\Kurser\\DD2310 Javaprogrammering för Pythonprogrammerare\\Problem\\Regex\\src\\list.txt");
        Scanner input = new Scanner(list);
    }

    private static String spaces(int spaces) {
        return CharBuffer.allocate(spaces).toString().replace( '\0', '.' );
    }

}