import org.jsoup.internal.StringUtil;

public class StringProcessing {
    public StringProcessing()
    {
        // Strings are IMMUTABLE
        String text = "    this is my text        ... this is the end     ";

        // 1. Strip whitespace

        text = text.strip();

        // 2. Replacing certain content in a string
        text = text.replace("this", "here");

        // 3. Break long strings into subsections
        /*String[] words = text.split(" ");
        for(String word: words){
            System.out.println(word);
        }*/

        // 4. Case management
        String text1 = text.toUpperCase();
        String text2 = text.toLowerCase();

        // 5. Check if content is in a string
        System.out.println(text.contains("this"));
        System.out.println(text.contains("here"));

        // 6. Slice our strings; substring
        System.out.println(text.substring(1,7)); // second index is EXCLUSIVE

        System.out.println(text);
        System.out.println(text1);
        System.out.println(text2);

    }
}
