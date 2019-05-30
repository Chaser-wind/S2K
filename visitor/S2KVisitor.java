package visitor;
import java.util.*;
import utils.*;

public class S2KVisitor extends GJNoArguDepthFirst<String> {
    HashMap<String, Method> mMethod;
    public S2KVisitor(HashMap<String, Method> m) {
        mMethod = m;
    }
}