// Generated from Teora.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TeoraParser}.
 */
public interface TeoraListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TeoraParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(TeoraParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link TeoraParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(TeoraParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link TeoraParser#listaComandos}.
	 * @param ctx the parse tree
	 */
	void enterListaComandos(TeoraParser.ListaComandosContext ctx);
	/**
	 * Exit a parse tree produced by {@link TeoraParser#listaComandos}.
	 * @param ctx the parse tree
	 */
	void exitListaComandos(TeoraParser.ListaComandosContext ctx);
	/**
	 * Enter a parse tree produced by {@link TeoraParser#comando}.
	 * @param ctx the parse tree
	 */
	void enterComando(TeoraParser.ComandoContext ctx);
	/**
	 * Exit a parse tree produced by {@link TeoraParser#comando}.
	 * @param ctx the parse tree
	 */
	void exitComando(TeoraParser.ComandoContext ctx);
	/**
	 * Enter a parse tree produced by {@link TeoraParser#declaracao}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracao(TeoraParser.DeclaracaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link TeoraParser#declaracao}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracao(TeoraParser.DeclaracaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link TeoraParser#atribuicao}.
	 * @param ctx the parse tree
	 */
	void enterAtribuicao(TeoraParser.AtribuicaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link TeoraParser#atribuicao}.
	 * @param ctx the parse tree
	 */
	void exitAtribuicao(TeoraParser.AtribuicaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link TeoraParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(TeoraParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link TeoraParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(TeoraParser.TipoContext ctx);
	/**
	 * Enter a parse tree produced by {@link TeoraParser#comandoIf}.
	 * @param ctx the parse tree
	 */
	void enterComandoIf(TeoraParser.ComandoIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link TeoraParser#comandoIf}.
	 * @param ctx the parse tree
	 */
	void exitComandoIf(TeoraParser.ComandoIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link TeoraParser#comandoWhile}.
	 * @param ctx the parse tree
	 */
	void enterComandoWhile(TeoraParser.ComandoWhileContext ctx);
	/**
	 * Exit a parse tree produced by {@link TeoraParser#comandoWhile}.
	 * @param ctx the parse tree
	 */
	void exitComandoWhile(TeoraParser.ComandoWhileContext ctx);
	/**
	 * Enter a parse tree produced by {@link TeoraParser#comandoFor}.
	 * @param ctx the parse tree
	 */
	void enterComandoFor(TeoraParser.ComandoForContext ctx);
	/**
	 * Exit a parse tree produced by {@link TeoraParser#comandoFor}.
	 * @param ctx the parse tree
	 */
	void exitComandoFor(TeoraParser.ComandoForContext ctx);
	/**
	 * Enter a parse tree produced by {@link TeoraParser#incremento}.
	 * @param ctx the parse tree
	 */
	void enterIncremento(TeoraParser.IncrementoContext ctx);
	/**
	 * Exit a parse tree produced by {@link TeoraParser#incremento}.
	 * @param ctx the parse tree
	 */
	void exitIncremento(TeoraParser.IncrementoContext ctx);
	/**
	 * Enter a parse tree produced by {@link TeoraParser#comandoOutput}.
	 * @param ctx the parse tree
	 */
	void enterComandoOutput(TeoraParser.ComandoOutputContext ctx);
	/**
	 * Exit a parse tree produced by {@link TeoraParser#comandoOutput}.
	 * @param ctx the parse tree
	 */
	void exitComandoOutput(TeoraParser.ComandoOutputContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AndExpr}
	 * labeled alternative in {@link TeoraParser#expressao}.
	 * @param ctx the parse tree
	 */
	void enterAndExpr(TeoraParser.AndExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AndExpr}
	 * labeled alternative in {@link TeoraParser#expressao}.
	 * @param ctx the parse tree
	 */
	void exitAndExpr(TeoraParser.AndExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TrueExpr}
	 * labeled alternative in {@link TeoraParser#expressao}.
	 * @param ctx the parse tree
	 */
	void enterTrueExpr(TeoraParser.TrueExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TrueExpr}
	 * labeled alternative in {@link TeoraParser#expressao}.
	 * @param ctx the parse tree
	 */
	void exitTrueExpr(TeoraParser.TrueExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IdExpr}
	 * labeled alternative in {@link TeoraParser#expressao}.
	 * @param ctx the parse tree
	 */
	void enterIdExpr(TeoraParser.IdExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IdExpr}
	 * labeled alternative in {@link TeoraParser#expressao}.
	 * @param ctx the parse tree
	 */
	void exitIdExpr(TeoraParser.IdExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NumExpr}
	 * labeled alternative in {@link TeoraParser#expressao}.
	 * @param ctx the parse tree
	 */
	void enterNumExpr(TeoraParser.NumExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NumExpr}
	 * labeled alternative in {@link TeoraParser#expressao}.
	 * @param ctx the parse tree
	 */
	void exitNumExpr(TeoraParser.NumExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RelExpr}
	 * labeled alternative in {@link TeoraParser#expressao}.
	 * @param ctx the parse tree
	 */
	void enterRelExpr(TeoraParser.RelExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RelExpr}
	 * labeled alternative in {@link TeoraParser#expressao}.
	 * @param ctx the parse tree
	 */
	void exitRelExpr(TeoraParser.RelExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParExpr}
	 * labeled alternative in {@link TeoraParser#expressao}.
	 * @param ctx the parse tree
	 */
	void enterParExpr(TeoraParser.ParExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParExpr}
	 * labeled alternative in {@link TeoraParser#expressao}.
	 * @param ctx the parse tree
	 */
	void exitParExpr(TeoraParser.ParExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddExpr}
	 * labeled alternative in {@link TeoraParser#expressao}.
	 * @param ctx the parse tree
	 */
	void enterAddExpr(TeoraParser.AddExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddExpr}
	 * labeled alternative in {@link TeoraParser#expressao}.
	 * @param ctx the parse tree
	 */
	void exitAddExpr(TeoraParser.AddExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IncDecExpr}
	 * labeled alternative in {@link TeoraParser#expressao}.
	 * @param ctx the parse tree
	 */
	void enterIncDecExpr(TeoraParser.IncDecExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IncDecExpr}
	 * labeled alternative in {@link TeoraParser#expressao}.
	 * @param ctx the parse tree
	 */
	void exitIncDecExpr(TeoraParser.IncDecExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RealExpr}
	 * labeled alternative in {@link TeoraParser#expressao}.
	 * @param ctx the parse tree
	 */
	void enterRealExpr(TeoraParser.RealExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RealExpr}
	 * labeled alternative in {@link TeoraParser#expressao}.
	 * @param ctx the parse tree
	 */
	void exitRealExpr(TeoraParser.RealExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code OrExpr}
	 * labeled alternative in {@link TeoraParser#expressao}.
	 * @param ctx the parse tree
	 */
	void enterOrExpr(TeoraParser.OrExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code OrExpr}
	 * labeled alternative in {@link TeoraParser#expressao}.
	 * @param ctx the parse tree
	 */
	void exitOrExpr(TeoraParser.OrExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FalseExpr}
	 * labeled alternative in {@link TeoraParser#expressao}.
	 * @param ctx the parse tree
	 */
	void enterFalseExpr(TeoraParser.FalseExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FalseExpr}
	 * labeled alternative in {@link TeoraParser#expressao}.
	 * @param ctx the parse tree
	 */
	void exitFalseExpr(TeoraParser.FalseExprContext ctx);
}