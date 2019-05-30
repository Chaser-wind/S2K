package utils;
import java.util.*;

public class RegAlloc {
    HashMap<String, Method> mMethod;
    Graph curGraph;
    Method curMethod;
    public RegAlloc(HashMap<String, Method> m) {
        mMethod = m;
    }
    void LiveAnalyze() {}
    void GetLiveInterval() {}
    public void LinearScan() {}
}