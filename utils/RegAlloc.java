package utils;
import java.util.*;

public class RegAlloc {
    HashMap<String, Method> mMethod;
    Graph curGraph;
    Method curMethod;
    public RegAlloc(HashMap<String, Method> m) {
        mMethod = m;
    }
    void LiveAnalyze() {
        boolean notOver = true;
        int size = curGraph.Vertexs.size();
		// Iterate
		while (notOver) {
			notOver = false;
			for (int currVid = size - 1; currVid >= 0; currVid--) {
				// System.out.println(currVid);
				GraphVertex currVertex = curGraph.VertexMap.get(currVid);
				// System.out.println(currVertex.toString());
				for (GraphVertex nextVertex : currVertex.Succ)
					currVertex.Out.addAll(nextVertex.In);

				HashSet<Integer> newIn = new HashSet<Integer>();
				// 'Out' - 'Def' + 'Use'
				newIn.addAll(currVertex.Out);
				newIn.removeAll(currVertex.Def);
				newIn.addAll(currVertex.Use);
				// 'In' changes, iteration not over
				if (!currVertex.In.equals(newIn)) {
					currVertex.In = newIn;
					notOver = true;
				}
			}
		}
    }
    void GetLiveInterval() {
        int size = curGraph.VertexMap.size();

		// update interval 'end'
		for (int vid = 0; vid < size; vid++) {
			GraphVertex currVertex = curGraph.VertexMap.get(vid);
			for (Integer tempNo : currVertex.In)
				curMethod.mTemp.get(tempNo).end = vid;
			for (Integer tempNo : currVertex.Out)
				curMethod.mTemp.get(tempNo).end = vid;
		}

		for (Interval interval : curMethod.mTemp.values()) {
			for (int callPos : curGraph.CallPos) {
				// across a method call, better use callee-saved regS
				if (interval.begin < callPos && interval.end > callPos)
					interval.S = true;
			}
		}
    }
    public void LinearScan() {
        for (Method method : mMethod.values()) {
			// System.out.println(method.methodName);
			curMethod = method;
			curGraph = curMethod.graph;
			LiveAnalyze();
			GetLiveInterval();

			// sort the intervals by [begin, end]
			ArrayList<Interval> intervals = new ArrayList<Interval>();
			for (Interval interval : curMethod.mTemp.values())
				intervals.add(interval);
			Collections.sort(intervals);
            
			Interval[] Tinterval = new Interval[10];
			Interval[] Sinterval = new Interval[8];
			for (Interval interval : intervals) {
				// last: the reg contains interval which ends last
				// empty: empty reg
				int lastT = -1, lastS = -1, emptyT = -1, emptyS = -1;
				// analyze t0-t9
				for (int regIdx = 9; regIdx >= 0; regIdx--) {
					if (Tinterval[regIdx] != null) {
						// not empty
						if (Tinterval[regIdx].end <= interval.begin) {
							// interval already ends
							curMethod.regT.put("TEMP " + Tinterval[regIdx].tempNo, "t" + regIdx);
							Tinterval[regIdx] = null;
							emptyT = regIdx;
						} else {
							if (lastT == -1 || Tinterval[regIdx].end > Tinterval[lastT].end)
								lastT = regIdx;
						}
					} else {
						emptyT = regIdx;
					}
				}
				// analyze s0-s7
				for (int regIdx = 7; regIdx >= 0; regIdx--) {
					if (Sinterval[regIdx] != null) {
						if (Sinterval[regIdx].end <= interval.begin) {
							curMethod.regS.put("TEMP " + Sinterval[regIdx].tempNo, "s" + regIdx);
							Sinterval[regIdx] = null;
							emptyS = regIdx;
						} else {
							if (lastS == -1 || Sinterval[regIdx].end > Sinterval[lastS].end)
								lastS = regIdx;
						}
					} else {
						emptyS = regIdx;
					}
				}
				// first assign T
				if (!interval.S) {
					if (emptyT != -1) {
						// assign empty T to interval
						Tinterval[emptyT] = interval;
						interval = null;
					} else {
						// swap with the last T
						if (interval.end < Tinterval[lastT].end) {
							Interval swapTmp = Tinterval[lastT];
							Tinterval[lastT] = interval;
							interval = swapTmp;
						}
					}
				}
				// then assign S
				if (interval != null) {
					if (emptyS != -1) {
						Sinterval[emptyS] = interval;
						interval = null;
					} else {
						if (interval.end < Sinterval[lastS].end) {
							Interval swapTmp = Sinterval[lastS];
							Sinterval[lastS] = interval;
							interval = swapTmp;
						}
					}
				}
				// if not assigned, spill it
				if (interval != null)
					curMethod.regSpilled.put("TEMP " + interval.tempNo, "");
			}
			for (int idx = 0; idx < 10; idx++) {
				if (Tinterval[idx] != null)
					curMethod.regT.put("TEMP " + Tinterval[idx].tempNo, "t" + idx);
			}
			for (int idx = 0; idx < 8; idx++) {
				if (Sinterval[idx] != null)
					curMethod.regS.put("TEMP " + Sinterval[idx].tempNo, "s" + idx);
			}
			// calculate stackNum:
			// contains params(>4), spilled regs, callee-saved S
			int stackIdx = (curMethod.paramNum > 4 ? curMethod.paramNum - 4 : 0) + curMethod.regS.size();
			for (String temp : curMethod.regSpilled.keySet()) {
				curMethod.regSpilled.put(temp, "SPILLEDARG " + stackIdx);
				stackIdx++;
			}
			curMethod.stackNum = stackIdx;
		}
    }
}