import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.Random;
import java.util.StringTokenizer;

public class Main {

    public static final int DATE_SEED = 0;
    public static final int OVERLY_COMPLEX_SEED = 1;

    public static void main(String[] args) {

        String input = "apple blackberry cherry dragonfruit grapefruit kumquat mango" +
                " nectarine persimmon raspberry raspberry";
        String output = shuffleString(stringToArray(input), OVERLY_COMPLEX_SEED);

        System.out.println(output);

        input = "a e i o u";
        output = shuffleString(stringToArray(input), DATE_SEED);

        System.out.println(output);
        
    }

    public static String shuffleString(String[] stringArr, int option) {
        String shuffledString = "";
        int count = stringArr.length;
        int seed;
        Random rand = new Random();

        for (int i = 0; i < count; ) {

            switch (option) {
                case DATE_SEED:
                    seed = getSeedWithDate(count);
                    break;
                case OVERLY_COMPLEX_SEED:
                    try {
                        seed = getSeedWithOverlyComplexBullshit(count);
                        break;
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                default:
                    seed = rand.nextInt(count);
            }
            if (!stringArr[seed].equals("-1")) {
                shuffledString = shuffledString +
                        stringArr[seed] + " ";
                stringArr[seed] = "-1";
                i++;
            }
        }

        return shuffledString;
    }

    public static String[] stringToArray(String strng) {
        StringTokenizer token = new StringTokenizer(strng, " ");
        int tokenCount = token.countTokens();
        String[] stringArr = new String[tokenCount];

        for (int i = 0; i < tokenCount; i++) {
            stringArr[i] = token.nextToken();
        }

        return stringArr;
    }

    public static int getSeedWithDate(int count) {
        Date date = new Date();
        int seed = (date.getSeconds()) % count;

        return seed;
    }

    public static int getSeedWithOverlyComplexBullshit(int count) throws Exception {
        URL url = null;
        int seed = 0;

        url = new URL("https://en.wikipedia.org/wiki/Special:Random");
        URLConnection con = url.openConnection();
        InputStream is = con.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line = null;


        while ((line = br.readLine()) != null) {
            seed = seed + line.indexOf("e");
        }

        return seed % count;
    }
}


