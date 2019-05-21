import spiglet.*;
import visitor.*;
import syntaxtree.*;
import java.io.*;
import utils.*;

public class S2K {
    static public void main(String[] args) {
        try {
            if (args.length < 1) {
                usage(args);
                return;
            }
            InputStream in = new FileInputStream(args[0]);
            Node root = new SpigletParser(in).Goal();

            GraphVertexVisitor VVis = new GetGraphVertex();
            root.accept(VVis);
            
            new SpigletParser(in);
			Node AST = SpigletParser.Goal();
			// visit 1: Get Flow Graph Vertex
			AST.accept(new GetFlowGraphVertex());
			// visit 2: Get Flow Graph
			AST.accept(new GetFlowGraph());
			// Linear Scan Algorithm on Flow Graph
			new Temp2Reg().LinearScan();
			// visit 3: Spiglet->Kanga
            AST.accept(new Spiglet2Kanga());
            
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