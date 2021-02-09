import java.io.*;
import java.util.Scanner;

public class TestFile {

    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("");
        FileReader fr = new FileReader(f);
        InputStream is = new FileInputStream("a");
        InputStreamReader isr = new InputStreamReader(is);
        StringReader sr = new StringReader("");
        Scanner sc = new Scanner(fr);
    }

}
