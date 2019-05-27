package visitor;

import java.util.*;
import utils.*;
import visitor.GJVoidDepthFirst;
import syntaxtree.*;
import stat.*;

class GetGraphVertex extends GJVoidDepthFirst<Db> {
    int sid;
    int getid(IntegerLiteral n) {
        return Integer.parseInt(n.f0.toString());
    }
    int getstr(Label n) {
        return n.toString();
    }
    public void visit(Goal n, Db d) {
        n.f0.accept(this, argu);
        sid = 0;
        d.method = new Method("MAIN", 0);
        n.f1.accept(this, argu);
        d.add();
        n.f2.accept(this, argu);
        n.f3.accept(this, argu);
        n.f4.accept(this, argu);
    }
    public void visit(Stmt n, Db d) {
        n.f0.accept(this, argu);
        ++sid;
    }
    public void visit(Procedure n, Db d) {
        sid = 0;
        n.f0.accept(this, argu);
        n.f1.accept(this, argu);
        n.f2.accept(this, argu);
        n.f3.accept(this, argu);
        d.method = new Method(getstr(n.f0), getid(n.f2));
        n.f4.accept(this, argu);
        d.add();
    }
}
