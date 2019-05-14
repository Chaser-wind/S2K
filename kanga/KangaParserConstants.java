/* Generated By:JavaCC: Do not edit this line. KangaParserConstants.java */

/**
 * Token literal values and constants.
 * Generated by org.javacc.parser.OtherFilesGen#start()
 */
package kanga;

public interface KangaParserConstants {

  /** End of File. */
  int EOF = 0;
  /** RegularExpression Id. */
  int SINGLE_LINE_COMMENT = 6;
  /** RegularExpression Id. */
  int FORMAL_COMMENT = 7;
  /** RegularExpression Id. */
  int MULTI_LINE_COMMENT = 8;
  /** RegularExpression Id. */
  int LPAREN = 9;
  /** RegularExpression Id. */
  int RPAREN = 10;
  /** RegularExpression Id. */
  int LBRACE = 11;
  /** RegularExpression Id. */
  int RBRACE = 12;
  /** RegularExpression Id. */
  int LSQPAREN = 13;
  /** RegularExpression Id. */
  int RSQPAREN = 14;
  /** RegularExpression Id. */
  int DOT = 15;
  /** RegularExpression Id. */
  int LT = 16;
  /** RegularExpression Id. */
  int LE = 17;
  /** RegularExpression Id. */
  int GT = 18;
  /** RegularExpression Id. */
  int GE = 19;
  /** RegularExpression Id. */
  int NE = 20;
  /** RegularExpression Id. */
  int EQ = 21;
  /** RegularExpression Id. */
  int PLUS = 22;
  /** RegularExpression Id. */
  int MINUS = 23;
  /** RegularExpression Id. */
  int AND = 24;
  /** RegularExpression Id. */
  int OR = 25;
  /** RegularExpression Id. */
  int NOT = 26;
  /** RegularExpression Id. */
  int TIMES = 27;
  /** RegularExpression Id. */
  int MAIN = 28;
  /** RegularExpression Id. */
  int CODE = 29;
  /** RegularExpression Id. */
  int HALLOCATE = 30;
  /** RegularExpression Id. */
  int SPILLEDARG = 31;
  /** RegularExpression Id. */
  int END = 32;
  /** RegularExpression Id. */
  int NOOP = 33;
  /** RegularExpression Id. */
  int MOVE = 34;
  /** RegularExpression Id. */
  int CALL = 35;
  /** RegularExpression Id. */
  int ERROR = 36;
  /** RegularExpression Id. */
  int PRINT = 37;
  /** RegularExpression Id. */
  int BEGIN = 38;
  /** RegularExpression Id. */
  int RETURN = 39;
  /** RegularExpression Id. */
  int JUMP = 40;
  /** RegularExpression Id. */
  int CJUMP = 41;
  /** RegularExpression Id. */
  int HSTORE = 42;
  /** RegularExpression Id. */
  int HLOAD = 43;
  /** RegularExpression Id. */
  int ALOAD = 44;
  /** RegularExpression Id. */
  int ASTORE = 45;
  /** RegularExpression Id. */
  int PASSARG = 46;
  /** RegularExpression Id. */
  int MEM = 47;
  /** RegularExpression Id. */
  int TEMP = 48;
  /** RegularExpression Id. */
  int ARG = 49;
  /** RegularExpression Id. */
  int ZERO = 50;
  /** RegularExpression Id. */
  int at = 51;
  /** RegularExpression Id. */
  int v0 = 52;
  /** RegularExpression Id. */
  int v1 = 53;
  /** RegularExpression Id. */
  int a0 = 54;
  /** RegularExpression Id. */
  int a1 = 55;
  /** RegularExpression Id. */
  int a2 = 56;
  /** RegularExpression Id. */
  int a3 = 57;
  /** RegularExpression Id. */
  int t0 = 58;
  /** RegularExpression Id. */
  int t1 = 59;
  /** RegularExpression Id. */
  int t2 = 60;
  /** RegularExpression Id. */
  int t3 = 61;
  /** RegularExpression Id. */
  int t4 = 62;
  /** RegularExpression Id. */
  int t5 = 63;
  /** RegularExpression Id. */
  int t6 = 64;
  /** RegularExpression Id. */
  int t7 = 65;
  /** RegularExpression Id. */
  int s0 = 66;
  /** RegularExpression Id. */
  int s1 = 67;
  /** RegularExpression Id. */
  int s2 = 68;
  /** RegularExpression Id. */
  int s3 = 69;
  /** RegularExpression Id. */
  int s4 = 70;
  /** RegularExpression Id. */
  int s5 = 71;
  /** RegularExpression Id. */
  int s6 = 72;
  /** RegularExpression Id. */
  int s7 = 73;
  /** RegularExpression Id. */
  int t8 = 74;
  /** RegularExpression Id. */
  int t9 = 75;
  /** RegularExpression Id. */
  int k0 = 76;
  /** RegularExpression Id. */
  int k1 = 77;
  /** RegularExpression Id. */
  int gp = 78;
  /** RegularExpression Id. */
  int sp = 79;
  /** RegularExpression Id. */
  int fp = 80;
  /** RegularExpression Id. */
  int ra = 81;
  /** RegularExpression Id. */
  int INTEGER_LITERAL = 82;
  /** RegularExpression Id. */
  int IDENTIFIER = 83;
  /** RegularExpression Id. */
  int LETTER = 84;
  /** RegularExpression Id. */
  int DIGIT = 85;

  /** Lexical state. */
  int DEFAULT = 0;

  /** Literal token values. */
  String[] tokenImage = {
    "<EOF>",
    "\" \"",
    "\"\\t\"",
    "\"\\n\"",
    "\"\\r\"",
    "\"\\f\"",
    "<SINGLE_LINE_COMMENT>",
    "<FORMAL_COMMENT>",
    "<MULTI_LINE_COMMENT>",
    "\"(\"",
    "\")\"",
    "\"{\"",
    "\"}\"",
    "\"[\"",
    "\"]\"",
    "\".\"",
    "\"LT\"",
    "\"LE\"",
    "\"GT\"",
    "\"GE\"",
    "\"NE\"",
    "\"EQ\"",
    "\"PLUS\"",
    "\"MINUS\"",
    "\"AND\"",
    "\"OR\"",
    "\"NOT\"",
    "\"TIMES\"",
    "\"MAIN\"",
    "\"CODE\"",
    "\"HALLOCATE\"",
    "\"SPILLEDARG\"",
    "\"END\"",
    "\"NOOP\"",
    "\"MOVE\"",
    "\"CALL\"",
    "\"ERROR\"",
    "\"PRINT\"",
    "\"BEGIN\"",
    "\"RETURN\"",
    "\"JUMP\"",
    "\"CJUMP\"",
    "\"HSTORE\"",
    "\"HLOAD\"",
    "\"ALOAD\"",
    "\"ASTORE\"",
    "\"PASSARG\"",
    "\"MEM\"",
    "\"TEMP\"",
    "\"ARG\"",
    "\"zero\"",
    "\"at\"",
    "\"v0\"",
    "\"v1\"",
    "\"a0\"",
    "\"a1\"",
    "\"a2\"",
    "\"a3\"",
    "\"t0\"",
    "\"t1\"",
    "\"t2\"",
    "\"t3\"",
    "\"t4\"",
    "\"t5\"",
    "\"t6\"",
    "\"t7\"",
    "\"s0\"",
    "\"s1\"",
    "\"s2\"",
    "\"s3\"",
    "\"s4\"",
    "\"s5\"",
    "\"s6\"",
    "\"s7\"",
    "\"t8\"",
    "\"t9\"",
    "\"k0\"",
    "\"k1\"",
    "\"gp\"",
    "\"sp\"",
    "\"fp\"",
    "\"ra\"",
    "<INTEGER_LITERAL>",
    "<IDENTIFIER>",
    "<LETTER>",
    "<DIGIT>",
  };

}
