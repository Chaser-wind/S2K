//
// Generated by JTB 1.3.2
//

package syntaxtree;

/**
 * Grammar production:
 * f0 -> Operator()
 * f1 -> Temp()
 * f2 -> SimpleExp()
 */
public class BinOp implements Node {
   public Operator f0;
   public Temp f1;
   public SimpleExp f2;

   public BinOp(Operator n0, Temp n1, SimpleExp n2) {
      f0 = n0;
      f1 = n1;
      f2 = n2;
   }

   public void accept(visitor.Visitor v) {
      v.visit(this);
   }
   public <R,A> R accept(visitor.GJVisitor<R,A> v, A argu) {
      return v.visit(this,argu);
   }
   public <R> R accept(visitor.GJNoArguVisitor<R> v) {
      return v.visit(this);
   }
   public <A> void accept(visitor.GJVoidVisitor<A> v, A argu) {
      v.visit(this,argu);
   }
}

