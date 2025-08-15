// Generated from /Users/pserra/code/ufabc/compiladores/projeto-compiler/LangDef.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LangDefParser}.
 */
public interface LangDefListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LangDefParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(LangDefParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangDefParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(LangDefParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangDefParser#bloco}.
	 * @param ctx the parse tree
	 */
	void enterBloco(LangDefParser.BlocoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangDefParser#bloco}.
	 * @param ctx the parse tree
	 */
	void exitBloco(LangDefParser.BlocoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangDefParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterCmd(LangDefParser.CmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangDefParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitCmd(LangDefParser.CmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangDefParser#cmdRead}.
	 * @param ctx the parse tree
	 */
	void enterCmdRead(LangDefParser.CmdReadContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangDefParser#cmdRead}.
	 * @param ctx the parse tree
	 */
	void exitCmdRead(LangDefParser.CmdReadContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangDefParser#cmdWrite}.
	 * @param ctx the parse tree
	 */
	void enterCmdWrite(LangDefParser.CmdWriteContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangDefParser#cmdWrite}.
	 * @param ctx the parse tree
	 */
	void exitCmdWrite(LangDefParser.CmdWriteContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangDefParser#cmdAttr}.
	 * @param ctx the parse tree
	 */
	void enterCmdAttr(LangDefParser.CmdAttrContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangDefParser#cmdAttr}.
	 * @param ctx the parse tree
	 */
	void exitCmdAttr(LangDefParser.CmdAttrContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangDefParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(LangDefParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangDefParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(LangDefParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangDefParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(LangDefParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangDefParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(LangDefParser.TermContext ctx);
}