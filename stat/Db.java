package stat;

import java.util.*;
import utils.*;

public class Db {
    String str;
    Method method;
    HashMap<String, Method> map = new HashMap<String, Method>();
    public add() {
        if (str == null || method == null) {
            System.out.println("Failed to generate Method Object.");
            if (str != null) {
                System.out.println(String.format("Method name is %s."));
            }
            System.exit(0);
        }
        map[str] = method;
    }
}