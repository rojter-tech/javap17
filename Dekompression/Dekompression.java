import java.util.*;

public class Dekompression {

    private static final String openBrace = "(<";
    private static final String closeBrace = ")>";

    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //String input = in.nextLine();
        String input = "2(3b3(ab))";
        ParExp(input, CompositionStructure(input));
        System.out.println("");
    }

    private static void ParExp(String input, int[] inPairBrn) {
        StringBuilder expString = new StringBuilder(); // The expanded inner string parenthesis
        StringBuilder expFactorString = new StringBuilder(); // By witch factor the inner string parenthesis will repeat

        if (inPairBrn[2] > 0) {  // Check if there is an inner pair of bracers

            if (inPairBrn[0]-2 > -1) {
                for (int i = inPairBrn[0] - 2; i < inPairBrn[0]; i++) {
                    if (Character.isDigit(input.charAt(i))) expFactorString.append(input.charAt(i));
                }
            } else {
                for (int i = inPairBrn[0] - 1; i < inPairBrn[0]; i++) {
                    if (Character.isDigit(input.charAt(i))) expFactorString.append(input.charAt(i));
                }
            }

            int expFactor =  Integer.valueOf(expFactorString.toString()); // Expand integer value
            int expSize = expFactorString.length(); // Expand factor size

            // Append the string with expanded inner string
            for (int i = 0; i < inPairBrn[0]-expSize; i++) {
                expString.append(input.charAt(i));
            }

            for (int j = 0; j < expFactor; j++) {
                for (int i = inPairBrn[0]+1; i < inPairBrn[1]; i++) {
                    expString.append(input.charAt(i));
                }
            }
            for (int i = inPairBrn[1] + 1; i < input.length(); i++) {
                expString.append(input.charAt(i));
            }
            ParExp(expString.toString(), CompositionStructure(expString.toString()));
        } else {
            ExpandSimpleString(input);
        }
    }

    private static void ExpandSimpleString(String expString)  {
        StringBuilder finalScale = new StringBuilder();
        for (int i = 0; i < expString.length(); i++) {
            if (Character.isDigit(expString.charAt(i))) {
                finalScale.append(expString.charAt(i));
            } else {
                if (finalScale.length() > 0) {
                    for (int j = 0; j < Integer.valueOf(finalScale.toString()); j++) {
                        System.out.print(expString.charAt(i));
                    }
                    finalScale = new StringBuilder();
                } else {
                    System.out.print(expString.charAt(i));
                }
            }
        }

    }

    private static int[] CompositionStructure(String input) {

        // Just checkin if the string contains any open brace
        int checkIfBrace = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == openBrace.charAt(0)) {
                checkIfBrace = 1;
            }
        }

        // If there is brace, determining last open brace position
        int ctp = 0;
        int otp = 0;
        int lop = 0;
        if (checkIfBrace == 1) {
            // Quantifying bracers pair
            while (input.charAt(ctp) != closeBrace.charAt(0)) {
                ctp++;
                if (input.charAt(ctp) == openBrace.charAt(0)) {
                    otp++;
                    lop = ctp;
                }
            }

        }

        int[] inPairBrn = new int[3];   // The most inner pair of bracers and total number of bracer pair

        //Setting up conditions
        if (otp > 0) {
            inPairBrn[0] = lop; inPairBrn[1] = ctp; inPairBrn[2] = otp;
        } else {
            inPairBrn[0] = 0;
            inPairBrn[1] = 0;
            inPairBrn[2] = 0;
        }
        return inPairBrn;
    }

}