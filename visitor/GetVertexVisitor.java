package visitor;
import java.util.*;
import syntaxtree.*;
import utils.*;

class GetVertexVisitor extends GJNoArguDepthFirst<String> {
    HashMap<String, Method> mMethod;
    HashMap<String, Integer> mLabel;
    Method current;
    int vtid;
    public GetVertexVisitor(HashMap<String, Method>m, 
    					HashMap<String, Integer>l) {
    	mMethod = m;
    	mLabel = l;
    }
    public String visit(NodeOptional n) {
		if (n.present()) {
			mLabel.put(n.node.accept(this), vtid);
		}
		return null;
    }
    public String visit(Goal n) {
		current = new Method("MAIN", 0);
		mMethod.put("MAIN", current);
		vtid = 0;
		current.graph.addVertex(vtid);
		vtid++;
		n.f1.accept(this);
		current.graph.addVertex(vtid);
		n.f3.accept(this);
		return null;
    }
    public String visit(Procedure n) {
		vtid = 0;
		String methodName = n.f0.f0.toString();
		int paramNum = Integer.parseInt(n.f2.accept(this));
		current = new Method(methodName, paramNum);
		mMethod.put(methodName, current);
		n.f4.accept(this);
		return null;
    }
    public String visit(Stmt n) {
		current.graph.addVertex(vtid);
		n.f0.accept(this);
		vtid++;
		return null;
    }
    public String visit(Call n) {
		n.f1.accept(this);
		n.f3.accept(this);
		current.graph.CallPos.add(vtid);
		if (current.callParamNum < n.f3.size())
			current.callParamNum = n.f3.size();
		return null;
    }
    public String visit(StmtExp n) {
		current.graph.addVertex(vtid);
		vtid++;
		n.f1.accept(this);
		current.graph.addVertex(vtid);
		vtid++;
		n.f3.accept(this);
		current.graph.addVertex(vtid);
		return null;
    }
    public String visit(Temp n) {
		Integer tempNo = Integer.parseInt(n.f1.accept(this));
		if (!current.mTemp.containsKey(tempNo)) {
			if (tempNo < current.paramNum)
				// parameter
				current.mTemp.put(tempNo, new Interval(tempNo, 0, vtid));
			else
				// local Temp (first shows up at vid)
				current.mTemp.put(tempNo, new Interval(tempNo, vtid, vtid));
		}
		return (tempNo).toString();
    }
    public String visit(IntegerLiteral n) {
		return n.f0.toString();
	}
	public String visit(Label n) {
		return n.f0.toString();
	}
}
