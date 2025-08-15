// Generated from /home/pserra/code/ufabc/compiladores/LangDef.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LangDefParser}.
 */
public interface LangDefListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LangDefParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(LangDefParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangDefParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(LangDefParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangDefParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(LangDefParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangDefParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(LangDefParser.ExpressionContext ctx);
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
	/**
	 * Enter a parse tree produced by {@link LangDefParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(LangDefParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangDefParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(LangDefParser.FactorContext ctx);
}