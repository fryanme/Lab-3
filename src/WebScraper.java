import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WebScraper {

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }




    public static int wordCount(String word) {
        String Spa = word.replaceAll("\\s"," ");
        String lit = Spa.replaceAll("\\p{Punct}", " ");
        String[] last = lit.split(" ");
        int wordcount = last.length;
        return wordcount;
    }
    public static int countWord(String word, String essay) {
        String lit = essay.replaceAll("\\p{Punct}", " ");
        String a = lit.toLowerCase();
        String[] last = a.split(" ");

        int count = 0;
        String w = word.toLowerCase();

        for (int i = 0; i < last.length; i++) {
            if (last[i].equals(w)) {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] unused) {
        System.out.println(urlToString("http://erdani.com/tdpl/hamlet.txt"));
        System.out.println(wordCount(urlToString("http://erdani.com/tdpl/hamlet.txt")));
        System.out.println(countWord("prince", urlToString("http://erdani.com/tdpl/hamlet.txt")));
    }
}
