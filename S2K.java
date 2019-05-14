import kanga.*;
import visitor.*;
import syntaxtree.*;
import java.io.*;

public class S2K {
    static public void main(String[] args) {
        try {
            if (args.length < 1) {
                usage(args);
                return;
            }
            InputStream in = new FileInputStream(args[0]);
            Node root = new KangaParser(in).Goal();
            String outputfile = null;
            if (args.length > 1) {
                outputfile = args[1];
            } else {
                outputfile = args[0].substring(0, args[0].length() - 4) + ".kg";
            }
            OutputStream out = new FileOutputStream(outputfile);
            //out.write();
            System.out.println(String.format("%s -> %s is finished.", args[0], outputfile));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return;
    }
    static void usage(String[] args) {
        System.out.println(String.format("Usage:"));
        System.out.println(String.format("\tjava S2K input_file [output_file]"));
    }
}