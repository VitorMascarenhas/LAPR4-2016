// $ANTLR 3.5.1 D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g 2016-06-22 19:21:33

package csheets.core.formula.compiler;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.debug.*;
import java.io.IOException;
import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class FormulaParser extends DebugParser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ABS", "AMP", "ASSIGN", "AT", 
		"CELL_REF", "COLON", "COMMA", "DIGIT", "DIV", "EQ", "EXCL", "FUNCTION", 
		"GLOBAL_VAR", "GT", "GTEQ", "LBRA", "LETTER", "LPAR", "LT", "LTEQ", "MINUS", 
		"MULTI", "NEQ", "NUMBER", "PERCENT", "PLUS", "POWER", "QUOT", "RBRA", 
		"RPAR", "SEMI", "STRING", "TEMP_VAR", "UNDERSCORE", "WHILE", "WS"
	};
	public static final int EOF=-1;
	public static final int ABS=4;
	public static final int AMP=5;
	public static final int ASSIGN=6;
	public static final int AT=7;
	public static final int CELL_REF=8;
	public static final int COLON=9;
	public static final int COMMA=10;
	public static final int DIGIT=11;
	public static final int DIV=12;
	public static final int EQ=13;
	public static final int EXCL=14;
	public static final int FUNCTION=15;
	public static final int GLOBAL_VAR=16;
	public static final int GT=17;
	public static final int GTEQ=18;
	public static final int LBRA=19;
	public static final int LETTER=20;
	public static final int LPAR=21;
	public static final int LT=22;
	public static final int LTEQ=23;
	public static final int MINUS=24;
	public static final int MULTI=25;
	public static final int NEQ=26;
	public static final int NUMBER=27;
	public static final int PERCENT=28;
	public static final int PLUS=29;
	public static final int POWER=30;
	public static final int QUOT=31;
	public static final int RBRA=32;
	public static final int RPAR=33;
	public static final int SEMI=34;
	public static final int STRING=35;
	public static final int TEMP_VAR=36;
	public static final int UNDERSCORE=37;
	public static final int WHILE=38;
	public static final int WS=39;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public static final String[] ruleNames = new String[] {
		"invalidRule", "expression", "operation", "assignment", "arithmetic_highest", 
		"comparison", "reference", "block", "arithmetic_high", "concatenation", 
		"arithmetic_lowest", "atom", "arithmetic_medium", "literal", "arithmetic_low", 
		"function_call"
	};

	public static final boolean[] decisionCanBacktrack = new boolean[] {
		false, // invalid decision
		false, false, false, false, false, false, false, false, false, false, 
		    false, false, false, false, false, false, false, false, false, false, 
		    false
	};

 
	public int ruleLevel = 0;
	public int getRuleLevel() { return ruleLevel; }
	public void incRuleLevel() { ruleLevel++; }
	public void decRuleLevel() { ruleLevel--; }
	public FormulaParser(TokenStream input) {
		this(input, DebugEventSocketProxy.DEFAULT_DEBUGGER_PORT, new RecognizerSharedState());
	}
	public FormulaParser(TokenStream input, int port, RecognizerSharedState state) {
		super(input, state);
		DebugEventSocketProxy proxy =
			new DebugEventSocketProxy(this,port,adaptor);
		setDebugListener(proxy);
		setTokenStream(new DebugTokenStream(input,proxy));
		try {
			proxy.handshake();
		}
		catch (IOException ioe) {
			reportError(ioe);
		}
		TreeAdaptor adap = new CommonTreeAdaptor();
		setTreeAdaptor(adap);
		proxy.setTreeAdaptor(adap);
	}

	public FormulaParser(TokenStream input, DebugEventListener dbg) {
		super(input, dbg);
		 
		TreeAdaptor adap = new CommonTreeAdaptor();
		setTreeAdaptor(adap);

	}

	protected boolean evalPredicate(boolean result, String predicate) {
		dbg.semanticPredicate(result, predicate);
		return result;
	}

		protected DebugTreeAdaptor adaptor;
		public void setTreeAdaptor(TreeAdaptor adaptor) {
			this.adaptor = new DebugTreeAdaptor(dbg,adaptor);
		}
		public TreeAdaptor getTreeAdaptor() {
			return adaptor;
		}
	@Override public String[] getTokenNames() { return FormulaParser.tokenNames; }
	@Override public String getGrammarFileName() { return "D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g"; }


		protected void mismatch(IntStream input, int ttype, BitSet follow)
			throws RecognitionException 
		{
	    	throw new MismatchedTokenException(ttype, input);
		}

		public Object recoverFromMismatchedSet(IntStream input, RecognitionException e, BitSet follow)
			throws RecognitionException 
		{
			throw e; 
		}
		
		@Override
	  	protected Object recoverFromMismatchedToken(IntStream input, int ttype, BitSet follow) throws RecognitionException {
	    	throw new MismatchedTokenException(ttype, input);
	 	}


	public static class expression_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "expression"
	// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:45:1: expression : EQ ! operation EOF !;
	public final FormulaParser.expression_return expression() throws RecognitionException {
		FormulaParser.expression_return retval = new FormulaParser.expression_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token EQ1=null;
		Token EOF3=null;
		ParserRuleReturnScope operation2 =null;

		Object EQ1_tree=null;
		Object EOF3_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "expression");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(45, 0);

		try {
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:46:2: ( EQ ! operation EOF !)
			dbg.enterAlt(1);

			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:46:4: EQ ! operation EOF !
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(46,6);
			EQ1=(Token)match(input,EQ,FOLLOW_EQ_in_expression80); dbg.location(46,8);
			pushFollow(FOLLOW_operation_in_expression83);
			operation2=operation();
			state._fsp--;

			adaptor.addChild(root_0, operation2.getTree());
			dbg.location(46,21);
			EOF3=(Token)match(input,EOF,FOLLOW_EOF_in_expression85); 
			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}

			catch (RecognitionException e) {
				reportError(e);
				throw e; 
			}

		finally {
			// do for sure before leaving
		}
		dbg.location(47, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "expression");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "expression"


	public static class operation_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "operation"
	// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:49:1: operation : ( assignment | comparison | block );
	public final FormulaParser.operation_return operation() throws RecognitionException {
		FormulaParser.operation_return retval = new FormulaParser.operation_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope assignment4 =null;
		ParserRuleReturnScope comparison5 =null;
		ParserRuleReturnScope block6 =null;


		try { dbg.enterRule(getGrammarFileName(), "operation");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(49, 0);

		try {
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:50:5: ( assignment | comparison | block )
			int alt1=3;
			try { dbg.enterDecision(1, decisionCanBacktrack[1]);

			switch ( input.LA(1) ) {
			case CELL_REF:
				{
				int LA1_1 = input.LA(2);
				if ( (LA1_1==ASSIGN) ) {
					alt1=1;
				}
				else if ( (LA1_1==EOF||LA1_1==AMP||LA1_1==COLON||(LA1_1 >= DIV && LA1_1 <= EQ)||(LA1_1 >= GT && LA1_1 <= GTEQ)||(LA1_1 >= LT && LA1_1 <= NEQ)||(LA1_1 >= PERCENT && LA1_1 <= POWER)||(LA1_1 >= RBRA && LA1_1 <= SEMI)) ) {
					alt1=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 1, 1, input);
						dbg.recognitionException(nvae);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case FUNCTION:
			case LPAR:
			case MINUS:
			case NUMBER:
			case STRING:
			case WHILE:
				{
				alt1=2;
				}
				break;
			case TEMP_VAR:
				{
				int LA1_3 = input.LA(2);
				if ( (LA1_3==ASSIGN) ) {
					alt1=1;
				}
				else if ( (LA1_3==EOF||LA1_3==AMP||(LA1_3 >= DIV && LA1_3 <= EQ)||(LA1_3 >= GT && LA1_3 <= GTEQ)||(LA1_3 >= LT && LA1_3 <= NEQ)||(LA1_3 >= PERCENT && LA1_3 <= POWER)||(LA1_3 >= RBRA && LA1_3 <= SEMI)) ) {
					alt1=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 1, 3, input);
						dbg.recognitionException(nvae);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case GLOBAL_VAR:
				{
				int LA1_4 = input.LA(2);
				if ( (LA1_4==ASSIGN) ) {
					alt1=1;
				}
				else if ( (LA1_4==EOF||LA1_4==AMP||(LA1_4 >= DIV && LA1_4 <= EQ)||(LA1_4 >= GT && LA1_4 <= GTEQ)||(LA1_4 >= LT && LA1_4 <= NEQ)||(LA1_4 >= PERCENT && LA1_4 <= POWER)||(LA1_4 >= RBRA && LA1_4 <= SEMI)) ) {
					alt1=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 1, 4, input);
						dbg.recognitionException(nvae);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case LBRA:
				{
				alt1=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}
			} finally {dbg.exitDecision(1);}

			switch (alt1) {
				case 1 :
					dbg.enterAlt(1);

					// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:50:7: assignment
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(50,7);
					pushFollow(FOLLOW_assignment_in_operation100);
					assignment4=assignment();
					state._fsp--;

					adaptor.addChild(root_0, assignment4.getTree());

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:50:20: comparison
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(50,20);
					pushFollow(FOLLOW_comparison_in_operation104);
					comparison5=comparison();
					state._fsp--;

					adaptor.addChild(root_0, comparison5.getTree());

					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:50:33: block
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(50,33);
					pushFollow(FOLLOW_block_in_operation108);
					block6=block();
					state._fsp--;

					adaptor.addChild(root_0, block6.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}

			catch (RecognitionException e) {
				reportError(e);
				throw e; 
			}

		finally {
			// do for sure before leaving
		}
		dbg.location(51, 4);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "operation");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "operation"


	public static class block_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "block"
	// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:53:1: block : LBRA ^ operation ( SEMI ! operation )+ RBRA !;
	public final FormulaParser.block_return block() throws RecognitionException {
		FormulaParser.block_return retval = new FormulaParser.block_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token LBRA7=null;
		Token SEMI9=null;
		Token RBRA11=null;
		ParserRuleReturnScope operation8 =null;
		ParserRuleReturnScope operation10 =null;

		Object LBRA7_tree=null;
		Object SEMI9_tree=null;
		Object RBRA11_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "block");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(53, 0);

		try {
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:54:2: ( LBRA ^ operation ( SEMI ! operation )+ RBRA !)
			dbg.enterAlt(1);

			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:54:4: LBRA ^ operation ( SEMI ! operation )+ RBRA !
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(54,8);
			LBRA7=(Token)match(input,LBRA,FOLLOW_LBRA_in_block122); 
			LBRA7_tree = (Object)adaptor.create(LBRA7);
			root_0 = (Object)adaptor.becomeRoot(LBRA7_tree, root_0);
			dbg.location(54,10);
			pushFollow(FOLLOW_operation_in_block125);
			operation8=operation();
			state._fsp--;

			adaptor.addChild(root_0, operation8.getTree());
			dbg.location(54,20);
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:54:20: ( SEMI ! operation )+
			int cnt2=0;
			try { dbg.enterSubRule(2);

			loop2:
			while (true) {
				int alt2=2;
				try { dbg.enterDecision(2, decisionCanBacktrack[2]);

				int LA2_0 = input.LA(1);
				if ( (LA2_0==SEMI) ) {
					alt2=1;
				}

				} finally {dbg.exitDecision(2);}

				switch (alt2) {
				case 1 :
					dbg.enterAlt(1);

					// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:54:21: SEMI ! operation
					{
					dbg.location(54,25);
					SEMI9=(Token)match(input,SEMI,FOLLOW_SEMI_in_block128); dbg.location(54,27);
					pushFollow(FOLLOW_operation_in_block131);
					operation10=operation();
					state._fsp--;

					adaptor.addChild(root_0, operation10.getTree());

					}
					break;

				default :
					if ( cnt2 >= 1 ) break loop2;
					EarlyExitException eee = new EarlyExitException(2, input);
					dbg.recognitionException(eee);

					throw eee;
				}
				cnt2++;
			}
			} finally {dbg.exitSubRule(2);}
			dbg.location(54,44);
			RBRA11=(Token)match(input,RBRA,FOLLOW_RBRA_in_block136); 
			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}

			catch (RecognitionException e) {
				reportError(e);
				throw e; 
			}

		finally {
			// do for sure before leaving
		}
		dbg.location(55, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "block");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "block"


	public static class assignment_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "assignment"
	// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:57:1: assignment : ( CELL_REF | TEMP_VAR | GLOBAL_VAR ) ASSIGN ^ comparison ;
	public final FormulaParser.assignment_return assignment() throws RecognitionException {
		FormulaParser.assignment_return retval = new FormulaParser.assignment_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set12=null;
		Token ASSIGN13=null;
		ParserRuleReturnScope comparison14 =null;

		Object set12_tree=null;
		Object ASSIGN13_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "assignment");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(57, 0);

		try {
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:58:9: ( ( CELL_REF | TEMP_VAR | GLOBAL_VAR ) ASSIGN ^ comparison )
			dbg.enterAlt(1);

			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:58:11: ( CELL_REF | TEMP_VAR | GLOBAL_VAR ) ASSIGN ^ comparison
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(58,11);
			set12=input.LT(1);
			if ( input.LA(1)==CELL_REF||input.LA(1)==GLOBAL_VAR||input.LA(1)==TEMP_VAR ) {
				input.consume();
				adaptor.addChild(root_0, (Object)adaptor.create(set12));
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				dbg.recognitionException(mse);
				throw mse;
			}dbg.location(58,52);
			ASSIGN13=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_assignment167); 
			ASSIGN13_tree = (Object)adaptor.create(ASSIGN13);
			root_0 = (Object)adaptor.becomeRoot(ASSIGN13_tree, root_0);
			dbg.location(58,54);
			pushFollow(FOLLOW_comparison_in_assignment170);
			comparison14=comparison();
			state._fsp--;

			adaptor.addChild(root_0, comparison14.getTree());

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}

			catch (RecognitionException e) {
				reportError(e);
				throw e; 
			}

		finally {
			// do for sure before leaving
		}
		dbg.location(59, 8);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "assignment");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "assignment"


	public static class comparison_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "comparison"
	// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:61:1: comparison : concatenation ( ( EQ ^| NEQ ^| GT ^| LT ^| LTEQ ^| GTEQ ^) concatenation )? ;
	public final FormulaParser.comparison_return comparison() throws RecognitionException {
		FormulaParser.comparison_return retval = new FormulaParser.comparison_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token EQ16=null;
		Token NEQ17=null;
		Token GT18=null;
		Token LT19=null;
		Token LTEQ20=null;
		Token GTEQ21=null;
		ParserRuleReturnScope concatenation15 =null;
		ParserRuleReturnScope concatenation22 =null;

		Object EQ16_tree=null;
		Object NEQ17_tree=null;
		Object GT18_tree=null;
		Object LT19_tree=null;
		Object LTEQ20_tree=null;
		Object GTEQ21_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "comparison");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(61, 0);

		try {
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:62:2: ( concatenation ( ( EQ ^| NEQ ^| GT ^| LT ^| LTEQ ^| GTEQ ^) concatenation )? )
			dbg.enterAlt(1);

			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:62:4: concatenation ( ( EQ ^| NEQ ^| GT ^| LT ^| LTEQ ^| GTEQ ^) concatenation )?
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(62,4);
			pushFollow(FOLLOW_concatenation_in_comparison188);
			concatenation15=concatenation();
			state._fsp--;

			adaptor.addChild(root_0, concatenation15.getTree());
			dbg.location(63,3);
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:63:3: ( ( EQ ^| NEQ ^| GT ^| LT ^| LTEQ ^| GTEQ ^) concatenation )?
			int alt4=2;
			try { dbg.enterSubRule(4);
			try { dbg.enterDecision(4, decisionCanBacktrack[4]);

			int LA4_0 = input.LA(1);
			if ( (LA4_0==EQ||(LA4_0 >= GT && LA4_0 <= GTEQ)||(LA4_0 >= LT && LA4_0 <= LTEQ)||LA4_0==NEQ) ) {
				alt4=1;
			}
			} finally {dbg.exitDecision(4);}

			switch (alt4) {
				case 1 :
					dbg.enterAlt(1);

					// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:63:5: ( EQ ^| NEQ ^| GT ^| LT ^| LTEQ ^| GTEQ ^) concatenation
					{
					dbg.location(63,5);
					// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:63:5: ( EQ ^| NEQ ^| GT ^| LT ^| LTEQ ^| GTEQ ^)
					int alt3=6;
					try { dbg.enterSubRule(3);
					try { dbg.enterDecision(3, decisionCanBacktrack[3]);

					switch ( input.LA(1) ) {
					case EQ:
						{
						alt3=1;
						}
						break;
					case NEQ:
						{
						alt3=2;
						}
						break;
					case GT:
						{
						alt3=3;
						}
						break;
					case LT:
						{
						alt3=4;
						}
						break;
					case LTEQ:
						{
						alt3=5;
						}
						break;
					case GTEQ:
						{
						alt3=6;
						}
						break;
					default:
						NoViableAltException nvae =
							new NoViableAltException("", 3, 0, input);
						dbg.recognitionException(nvae);
						throw nvae;
					}
					} finally {dbg.exitDecision(3);}

					switch (alt3) {
						case 1 :
							dbg.enterAlt(1);

							// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:63:7: EQ ^
							{
							dbg.location(63,9);
							EQ16=(Token)match(input,EQ,FOLLOW_EQ_in_comparison196); 
							EQ16_tree = (Object)adaptor.create(EQ16);
							root_0 = (Object)adaptor.becomeRoot(EQ16_tree, root_0);

							}
							break;
						case 2 :
							dbg.enterAlt(2);

							// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:63:13: NEQ ^
							{
							dbg.location(63,16);
							NEQ17=(Token)match(input,NEQ,FOLLOW_NEQ_in_comparison201); 
							NEQ17_tree = (Object)adaptor.create(NEQ17);
							root_0 = (Object)adaptor.becomeRoot(NEQ17_tree, root_0);

							}
							break;
						case 3 :
							dbg.enterAlt(3);

							// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:63:20: GT ^
							{
							dbg.location(63,22);
							GT18=(Token)match(input,GT,FOLLOW_GT_in_comparison206); 
							GT18_tree = (Object)adaptor.create(GT18);
							root_0 = (Object)adaptor.becomeRoot(GT18_tree, root_0);

							}
							break;
						case 4 :
							dbg.enterAlt(4);

							// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:63:26: LT ^
							{
							dbg.location(63,28);
							LT19=(Token)match(input,LT,FOLLOW_LT_in_comparison211); 
							LT19_tree = (Object)adaptor.create(LT19);
							root_0 = (Object)adaptor.becomeRoot(LT19_tree, root_0);

							}
							break;
						case 5 :
							dbg.enterAlt(5);

							// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:63:32: LTEQ ^
							{
							dbg.location(63,36);
							LTEQ20=(Token)match(input,LTEQ,FOLLOW_LTEQ_in_comparison216); 
							LTEQ20_tree = (Object)adaptor.create(LTEQ20);
							root_0 = (Object)adaptor.becomeRoot(LTEQ20_tree, root_0);

							}
							break;
						case 6 :
							dbg.enterAlt(6);

							// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:63:40: GTEQ ^
							{
							dbg.location(63,44);
							GTEQ21=(Token)match(input,GTEQ,FOLLOW_GTEQ_in_comparison221); 
							GTEQ21_tree = (Object)adaptor.create(GTEQ21);
							root_0 = (Object)adaptor.becomeRoot(GTEQ21_tree, root_0);

							}
							break;

					}
					} finally {dbg.exitSubRule(3);}
					dbg.location(63,48);
					pushFollow(FOLLOW_concatenation_in_comparison226);
					concatenation22=concatenation();
					state._fsp--;

					adaptor.addChild(root_0, concatenation22.getTree());

					}
					break;

			}
			} finally {dbg.exitSubRule(4);}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}

			catch (RecognitionException e) {
				reportError(e);
				throw e; 
			}

		finally {
			// do for sure before leaving
		}
		dbg.location(64, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "comparison");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "comparison"


	public static class concatenation_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "concatenation"
	// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:66:1: concatenation : arithmetic_lowest ( AMP ^ arithmetic_lowest )* ;
	public final FormulaParser.concatenation_return concatenation() throws RecognitionException {
		FormulaParser.concatenation_return retval = new FormulaParser.concatenation_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token AMP24=null;
		ParserRuleReturnScope arithmetic_lowest23 =null;
		ParserRuleReturnScope arithmetic_lowest25 =null;

		Object AMP24_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "concatenation");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(66, 0);

		try {
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:67:2: ( arithmetic_lowest ( AMP ^ arithmetic_lowest )* )
			dbg.enterAlt(1);

			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:67:4: arithmetic_lowest ( AMP ^ arithmetic_lowest )*
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(67,4);
			pushFollow(FOLLOW_arithmetic_lowest_in_concatenation240);
			arithmetic_lowest23=arithmetic_lowest();
			state._fsp--;

			adaptor.addChild(root_0, arithmetic_lowest23.getTree());
			dbg.location(68,3);
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:68:3: ( AMP ^ arithmetic_lowest )*
			try { dbg.enterSubRule(5);

			loop5:
			while (true) {
				int alt5=2;
				try { dbg.enterDecision(5, decisionCanBacktrack[5]);

				int LA5_0 = input.LA(1);
				if ( (LA5_0==AMP) ) {
					alt5=1;
				}

				} finally {dbg.exitDecision(5);}

				switch (alt5) {
				case 1 :
					dbg.enterAlt(1);

					// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:68:5: AMP ^ arithmetic_lowest
					{
					dbg.location(68,8);
					AMP24=(Token)match(input,AMP,FOLLOW_AMP_in_concatenation246); 
					AMP24_tree = (Object)adaptor.create(AMP24);
					root_0 = (Object)adaptor.becomeRoot(AMP24_tree, root_0);
					dbg.location(68,10);
					pushFollow(FOLLOW_arithmetic_lowest_in_concatenation249);
					arithmetic_lowest25=arithmetic_lowest();
					state._fsp--;

					adaptor.addChild(root_0, arithmetic_lowest25.getTree());

					}
					break;

				default :
					break loop5;
				}
			}
			} finally {dbg.exitSubRule(5);}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}

			catch (RecognitionException e) {
				reportError(e);
				throw e; 
			}

		finally {
			// do for sure before leaving
		}
		dbg.location(69, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "concatenation");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "concatenation"


	public static class arithmetic_lowest_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "arithmetic_lowest"
	// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:71:1: arithmetic_lowest : arithmetic_low ( ( PLUS ^| MINUS ^) arithmetic_low )* ;
	public final FormulaParser.arithmetic_lowest_return arithmetic_lowest() throws RecognitionException {
		FormulaParser.arithmetic_lowest_return retval = new FormulaParser.arithmetic_lowest_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token PLUS27=null;
		Token MINUS28=null;
		ParserRuleReturnScope arithmetic_low26 =null;
		ParserRuleReturnScope arithmetic_low29 =null;

		Object PLUS27_tree=null;
		Object MINUS28_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "arithmetic_lowest");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(71, 0);

		try {
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:72:2: ( arithmetic_low ( ( PLUS ^| MINUS ^) arithmetic_low )* )
			dbg.enterAlt(1);

			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:72:4: arithmetic_low ( ( PLUS ^| MINUS ^) arithmetic_low )*
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(72,4);
			pushFollow(FOLLOW_arithmetic_low_in_arithmetic_lowest263);
			arithmetic_low26=arithmetic_low();
			state._fsp--;

			adaptor.addChild(root_0, arithmetic_low26.getTree());
			dbg.location(73,3);
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:73:3: ( ( PLUS ^| MINUS ^) arithmetic_low )*
			try { dbg.enterSubRule(7);

			loop7:
			while (true) {
				int alt7=2;
				try { dbg.enterDecision(7, decisionCanBacktrack[7]);

				int LA7_0 = input.LA(1);
				if ( (LA7_0==MINUS||LA7_0==PLUS) ) {
					alt7=1;
				}

				} finally {dbg.exitDecision(7);}

				switch (alt7) {
				case 1 :
					dbg.enterAlt(1);

					// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:73:5: ( PLUS ^| MINUS ^) arithmetic_low
					{
					dbg.location(73,5);
					// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:73:5: ( PLUS ^| MINUS ^)
					int alt6=2;
					try { dbg.enterSubRule(6);
					try { dbg.enterDecision(6, decisionCanBacktrack[6]);

					int LA6_0 = input.LA(1);
					if ( (LA6_0==PLUS) ) {
						alt6=1;
					}
					else if ( (LA6_0==MINUS) ) {
						alt6=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 6, 0, input);
						dbg.recognitionException(nvae);
						throw nvae;
					}

					} finally {dbg.exitDecision(6);}

					switch (alt6) {
						case 1 :
							dbg.enterAlt(1);

							// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:73:7: PLUS ^
							{
							dbg.location(73,11);
							PLUS27=(Token)match(input,PLUS,FOLLOW_PLUS_in_arithmetic_lowest271); 
							PLUS27_tree = (Object)adaptor.create(PLUS27);
							root_0 = (Object)adaptor.becomeRoot(PLUS27_tree, root_0);

							}
							break;
						case 2 :
							dbg.enterAlt(2);

							// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:73:15: MINUS ^
							{
							dbg.location(73,20);
							MINUS28=(Token)match(input,MINUS,FOLLOW_MINUS_in_arithmetic_lowest276); 
							MINUS28_tree = (Object)adaptor.create(MINUS28);
							root_0 = (Object)adaptor.becomeRoot(MINUS28_tree, root_0);

							}
							break;

					}
					} finally {dbg.exitSubRule(6);}
					dbg.location(73,24);
					pushFollow(FOLLOW_arithmetic_low_in_arithmetic_lowest281);
					arithmetic_low29=arithmetic_low();
					state._fsp--;

					adaptor.addChild(root_0, arithmetic_low29.getTree());

					}
					break;

				default :
					break loop7;
				}
			}
			} finally {dbg.exitSubRule(7);}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}

			catch (RecognitionException e) {
				reportError(e);
				throw e; 
			}

		finally {
			// do for sure before leaving
		}
		dbg.location(74, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "arithmetic_lowest");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "arithmetic_lowest"


	public static class arithmetic_low_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "arithmetic_low"
	// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:76:1: arithmetic_low : arithmetic_medium ( ( MULTI ^| DIV ^) arithmetic_medium )* ;
	public final FormulaParser.arithmetic_low_return arithmetic_low() throws RecognitionException {
		FormulaParser.arithmetic_low_return retval = new FormulaParser.arithmetic_low_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token MULTI31=null;
		Token DIV32=null;
		ParserRuleReturnScope arithmetic_medium30 =null;
		ParserRuleReturnScope arithmetic_medium33 =null;

		Object MULTI31_tree=null;
		Object DIV32_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "arithmetic_low");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(76, 0);

		try {
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:77:2: ( arithmetic_medium ( ( MULTI ^| DIV ^) arithmetic_medium )* )
			dbg.enterAlt(1);

			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:77:4: arithmetic_medium ( ( MULTI ^| DIV ^) arithmetic_medium )*
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(77,4);
			pushFollow(FOLLOW_arithmetic_medium_in_arithmetic_low295);
			arithmetic_medium30=arithmetic_medium();
			state._fsp--;

			adaptor.addChild(root_0, arithmetic_medium30.getTree());
			dbg.location(78,3);
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:78:3: ( ( MULTI ^| DIV ^) arithmetic_medium )*
			try { dbg.enterSubRule(9);

			loop9:
			while (true) {
				int alt9=2;
				try { dbg.enterDecision(9, decisionCanBacktrack[9]);

				int LA9_0 = input.LA(1);
				if ( (LA9_0==DIV||LA9_0==MULTI) ) {
					alt9=1;
				}

				} finally {dbg.exitDecision(9);}

				switch (alt9) {
				case 1 :
					dbg.enterAlt(1);

					// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:78:5: ( MULTI ^| DIV ^) arithmetic_medium
					{
					dbg.location(78,5);
					// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:78:5: ( MULTI ^| DIV ^)
					int alt8=2;
					try { dbg.enterSubRule(8);
					try { dbg.enterDecision(8, decisionCanBacktrack[8]);

					int LA8_0 = input.LA(1);
					if ( (LA8_0==MULTI) ) {
						alt8=1;
					}
					else if ( (LA8_0==DIV) ) {
						alt8=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 8, 0, input);
						dbg.recognitionException(nvae);
						throw nvae;
					}

					} finally {dbg.exitDecision(8);}

					switch (alt8) {
						case 1 :
							dbg.enterAlt(1);

							// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:78:7: MULTI ^
							{
							dbg.location(78,12);
							MULTI31=(Token)match(input,MULTI,FOLLOW_MULTI_in_arithmetic_low303); 
							MULTI31_tree = (Object)adaptor.create(MULTI31);
							root_0 = (Object)adaptor.becomeRoot(MULTI31_tree, root_0);

							}
							break;
						case 2 :
							dbg.enterAlt(2);

							// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:78:16: DIV ^
							{
							dbg.location(78,19);
							DIV32=(Token)match(input,DIV,FOLLOW_DIV_in_arithmetic_low308); 
							DIV32_tree = (Object)adaptor.create(DIV32);
							root_0 = (Object)adaptor.becomeRoot(DIV32_tree, root_0);

							}
							break;

					}
					} finally {dbg.exitSubRule(8);}
					dbg.location(78,23);
					pushFollow(FOLLOW_arithmetic_medium_in_arithmetic_low313);
					arithmetic_medium33=arithmetic_medium();
					state._fsp--;

					adaptor.addChild(root_0, arithmetic_medium33.getTree());

					}
					break;

				default :
					break loop9;
				}
			}
			} finally {dbg.exitSubRule(9);}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}

			catch (RecognitionException e) {
				reportError(e);
				throw e; 
			}

		finally {
			// do for sure before leaving
		}
		dbg.location(79, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "arithmetic_low");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "arithmetic_low"


	public static class arithmetic_medium_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "arithmetic_medium"
	// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:81:1: arithmetic_medium : arithmetic_high ( POWER ^ arithmetic_high )? ;
	public final FormulaParser.arithmetic_medium_return arithmetic_medium() throws RecognitionException {
		FormulaParser.arithmetic_medium_return retval = new FormulaParser.arithmetic_medium_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token POWER35=null;
		ParserRuleReturnScope arithmetic_high34 =null;
		ParserRuleReturnScope arithmetic_high36 =null;

		Object POWER35_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "arithmetic_medium");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(81, 0);

		try {
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:82:2: ( arithmetic_high ( POWER ^ arithmetic_high )? )
			dbg.enterAlt(1);

			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:82:4: arithmetic_high ( POWER ^ arithmetic_high )?
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(82,4);
			pushFollow(FOLLOW_arithmetic_high_in_arithmetic_medium327);
			arithmetic_high34=arithmetic_high();
			state._fsp--;

			adaptor.addChild(root_0, arithmetic_high34.getTree());
			dbg.location(83,3);
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:83:3: ( POWER ^ arithmetic_high )?
			int alt10=2;
			try { dbg.enterSubRule(10);
			try { dbg.enterDecision(10, decisionCanBacktrack[10]);

			int LA10_0 = input.LA(1);
			if ( (LA10_0==POWER) ) {
				alt10=1;
			}
			} finally {dbg.exitDecision(10);}

			switch (alt10) {
				case 1 :
					dbg.enterAlt(1);

					// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:83:5: POWER ^ arithmetic_high
					{
					dbg.location(83,10);
					POWER35=(Token)match(input,POWER,FOLLOW_POWER_in_arithmetic_medium333); 
					POWER35_tree = (Object)adaptor.create(POWER35);
					root_0 = (Object)adaptor.becomeRoot(POWER35_tree, root_0);
					dbg.location(83,12);
					pushFollow(FOLLOW_arithmetic_high_in_arithmetic_medium336);
					arithmetic_high36=arithmetic_high();
					state._fsp--;

					adaptor.addChild(root_0, arithmetic_high36.getTree());

					}
					break;

			}
			} finally {dbg.exitSubRule(10);}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}

			catch (RecognitionException e) {
				reportError(e);
				throw e; 
			}

		finally {
			// do for sure before leaving
		}
		dbg.location(84, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "arithmetic_medium");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "arithmetic_medium"


	public static class arithmetic_high_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "arithmetic_high"
	// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:86:1: arithmetic_high : arithmetic_highest ( PERCENT ^)? ;
	public final FormulaParser.arithmetic_high_return arithmetic_high() throws RecognitionException {
		FormulaParser.arithmetic_high_return retval = new FormulaParser.arithmetic_high_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token PERCENT38=null;
		ParserRuleReturnScope arithmetic_highest37 =null;

		Object PERCENT38_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "arithmetic_high");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(86, 0);

		try {
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:87:2: ( arithmetic_highest ( PERCENT ^)? )
			dbg.enterAlt(1);

			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:87:4: arithmetic_highest ( PERCENT ^)?
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(87,4);
			pushFollow(FOLLOW_arithmetic_highest_in_arithmetic_high350);
			arithmetic_highest37=arithmetic_highest();
			state._fsp--;

			adaptor.addChild(root_0, arithmetic_highest37.getTree());
			dbg.location(87,23);
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:87:23: ( PERCENT ^)?
			int alt11=2;
			try { dbg.enterSubRule(11);
			try { dbg.enterDecision(11, decisionCanBacktrack[11]);

			int LA11_0 = input.LA(1);
			if ( (LA11_0==PERCENT) ) {
				alt11=1;
			}
			} finally {dbg.exitDecision(11);}

			switch (alt11) {
				case 1 :
					dbg.enterAlt(1);

					// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:87:25: PERCENT ^
					{
					dbg.location(87,32);
					PERCENT38=(Token)match(input,PERCENT,FOLLOW_PERCENT_in_arithmetic_high354); 
					PERCENT38_tree = (Object)adaptor.create(PERCENT38);
					root_0 = (Object)adaptor.becomeRoot(PERCENT38_tree, root_0);

					}
					break;

			}
			} finally {dbg.exitSubRule(11);}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}

			catch (RecognitionException e) {
				reportError(e);
				throw e; 
			}

		finally {
			// do for sure before leaving
		}
		dbg.location(88, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "arithmetic_high");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "arithmetic_high"


	public static class arithmetic_highest_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "arithmetic_highest"
	// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:90:1: arithmetic_highest : ( MINUS ^)? atom ;
	public final FormulaParser.arithmetic_highest_return arithmetic_highest() throws RecognitionException {
		FormulaParser.arithmetic_highest_return retval = new FormulaParser.arithmetic_highest_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token MINUS39=null;
		ParserRuleReturnScope atom40 =null;

		Object MINUS39_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "arithmetic_highest");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(90, 0);

		try {
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:91:2: ( ( MINUS ^)? atom )
			dbg.enterAlt(1);

			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:91:4: ( MINUS ^)? atom
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(91,4);
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:91:4: ( MINUS ^)?
			int alt12=2;
			try { dbg.enterSubRule(12);
			try { dbg.enterDecision(12, decisionCanBacktrack[12]);

			int LA12_0 = input.LA(1);
			if ( (LA12_0==MINUS) ) {
				alt12=1;
			}
			} finally {dbg.exitDecision(12);}

			switch (alt12) {
				case 1 :
					dbg.enterAlt(1);

					// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:91:6: MINUS ^
					{
					dbg.location(91,11);
					MINUS39=(Token)match(input,MINUS,FOLLOW_MINUS_in_arithmetic_highest371); 
					MINUS39_tree = (Object)adaptor.create(MINUS39);
					root_0 = (Object)adaptor.becomeRoot(MINUS39_tree, root_0);

					}
					break;

			}
			} finally {dbg.exitSubRule(12);}
			dbg.location(91,16);
			pushFollow(FOLLOW_atom_in_arithmetic_highest377);
			atom40=atom();
			state._fsp--;

			adaptor.addChild(root_0, atom40.getTree());

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}

			catch (RecognitionException e) {
				reportError(e);
				throw e; 
			}

		finally {
			// do for sure before leaving
		}
		dbg.location(92, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "arithmetic_highest");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "arithmetic_highest"


	public static class atom_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "atom"
	// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:94:1: atom : ( function_call | reference | TEMP_VAR | GLOBAL_VAR | literal | LPAR ! comparison RPAR !);
	public final FormulaParser.atom_return atom() throws RecognitionException {
		FormulaParser.atom_return retval = new FormulaParser.atom_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token TEMP_VAR43=null;
		Token GLOBAL_VAR44=null;
		Token LPAR46=null;
		Token RPAR48=null;
		ParserRuleReturnScope function_call41 =null;
		ParserRuleReturnScope reference42 =null;
		ParserRuleReturnScope literal45 =null;
		ParserRuleReturnScope comparison47 =null;

		Object TEMP_VAR43_tree=null;
		Object GLOBAL_VAR44_tree=null;
		Object LPAR46_tree=null;
		Object RPAR48_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "atom");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(94, 0);

		try {
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:95:2: ( function_call | reference | TEMP_VAR | GLOBAL_VAR | literal | LPAR ! comparison RPAR !)
			int alt13=6;
			try { dbg.enterDecision(13, decisionCanBacktrack[13]);

			switch ( input.LA(1) ) {
			case FUNCTION:
			case WHILE:
				{
				alt13=1;
				}
				break;
			case CELL_REF:
				{
				alt13=2;
				}
				break;
			case TEMP_VAR:
				{
				alt13=3;
				}
				break;
			case GLOBAL_VAR:
				{
				alt13=4;
				}
				break;
			case NUMBER:
			case STRING:
				{
				alt13=5;
				}
				break;
			case LPAR:
				{
				alt13=6;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 13, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}
			} finally {dbg.exitDecision(13);}

			switch (alt13) {
				case 1 :
					dbg.enterAlt(1);

					// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:95:4: function_call
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(95,4);
					pushFollow(FOLLOW_function_call_in_atom388);
					function_call41=function_call();
					state._fsp--;

					adaptor.addChild(root_0, function_call41.getTree());

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:96:4: reference
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(96,4);
					pushFollow(FOLLOW_reference_in_atom393);
					reference42=reference();
					state._fsp--;

					adaptor.addChild(root_0, reference42.getTree());

					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:97:9: TEMP_VAR
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(97,9);
					TEMP_VAR43=(Token)match(input,TEMP_VAR,FOLLOW_TEMP_VAR_in_atom403); 
					TEMP_VAR43_tree = (Object)adaptor.create(TEMP_VAR43);
					adaptor.addChild(root_0, TEMP_VAR43_tree);

					}
					break;
				case 4 :
					dbg.enterAlt(4);

					// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:98:9: GLOBAL_VAR
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(98,9);
					GLOBAL_VAR44=(Token)match(input,GLOBAL_VAR,FOLLOW_GLOBAL_VAR_in_atom413); 
					GLOBAL_VAR44_tree = (Object)adaptor.create(GLOBAL_VAR44);
					adaptor.addChild(root_0, GLOBAL_VAR44_tree);

					}
					break;
				case 5 :
					dbg.enterAlt(5);

					// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:99:4: literal
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(99,4);
					pushFollow(FOLLOW_literal_in_atom418);
					literal45=literal();
					state._fsp--;

					adaptor.addChild(root_0, literal45.getTree());

					}
					break;
				case 6 :
					dbg.enterAlt(6);

					// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:100:4: LPAR ! comparison RPAR !
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(100,8);
					LPAR46=(Token)match(input,LPAR,FOLLOW_LPAR_in_atom423); dbg.location(100,10);
					pushFollow(FOLLOW_comparison_in_atom426);
					comparison47=comparison();
					state._fsp--;

					adaptor.addChild(root_0, comparison47.getTree());
					dbg.location(100,25);
					RPAR48=(Token)match(input,RPAR,FOLLOW_RPAR_in_atom428); 
					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}

			catch (RecognitionException e) {
				reportError(e);
				throw e; 
			}

		finally {
			// do for sure before leaving
		}
		dbg.location(101, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "atom");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "atom"


	public static class function_call_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "function_call"
	// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:103:1: function_call : ( WHILE ^ LPAR ! ( operation ( SEMI ! operation )* )? RPAR !| FUNCTION ^ LPAR ! ( comparison ( SEMI ! comparison )* )? RPAR !| FUNCTION ^ LBRA ! ( assignment SEMI ! comparison SEMI ! assignment ( SEMI ! operation )* )? RBRA !);
	public final FormulaParser.function_call_return function_call() throws RecognitionException {
		FormulaParser.function_call_return retval = new FormulaParser.function_call_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token WHILE49=null;
		Token LPAR50=null;
		Token SEMI52=null;
		Token RPAR54=null;
		Token FUNCTION55=null;
		Token LPAR56=null;
		Token SEMI58=null;
		Token RPAR60=null;
		Token FUNCTION61=null;
		Token LBRA62=null;
		Token SEMI64=null;
		Token SEMI66=null;
		Token SEMI68=null;
		Token RBRA70=null;
		ParserRuleReturnScope operation51 =null;
		ParserRuleReturnScope operation53 =null;
		ParserRuleReturnScope comparison57 =null;
		ParserRuleReturnScope comparison59 =null;
		ParserRuleReturnScope assignment63 =null;
		ParserRuleReturnScope comparison65 =null;
		ParserRuleReturnScope assignment67 =null;
		ParserRuleReturnScope operation69 =null;

		Object WHILE49_tree=null;
		Object LPAR50_tree=null;
		Object SEMI52_tree=null;
		Object RPAR54_tree=null;
		Object FUNCTION55_tree=null;
		Object LPAR56_tree=null;
		Object SEMI58_tree=null;
		Object RPAR60_tree=null;
		Object FUNCTION61_tree=null;
		Object LBRA62_tree=null;
		Object SEMI64_tree=null;
		Object SEMI66_tree=null;
		Object SEMI68_tree=null;
		Object RBRA70_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "function_call");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(103, 0);

		try {
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:104:2: ( WHILE ^ LPAR ! ( operation ( SEMI ! operation )* )? RPAR !| FUNCTION ^ LPAR ! ( comparison ( SEMI ! comparison )* )? RPAR !| FUNCTION ^ LBRA ! ( assignment SEMI ! comparison SEMI ! assignment ( SEMI ! operation )* )? RBRA !)
			int alt20=3;
			try { dbg.enterDecision(20, decisionCanBacktrack[20]);

			int LA20_0 = input.LA(1);
			if ( (LA20_0==WHILE) ) {
				alt20=1;
			}
			else if ( (LA20_0==FUNCTION) ) {
				int LA20_2 = input.LA(2);
				if ( (LA20_2==LPAR) ) {
					alt20=2;
				}
				else if ( (LA20_2==LBRA) ) {
					alt20=3;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 20, 2, input);
						dbg.recognitionException(nvae);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 20, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(20);}

			switch (alt20) {
				case 1 :
					dbg.enterAlt(1);

					// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:104:4: WHILE ^ LPAR ! ( operation ( SEMI ! operation )* )? RPAR !
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(104,9);
					WHILE49=(Token)match(input,WHILE,FOLLOW_WHILE_in_function_call440); 
					WHILE49_tree = (Object)adaptor.create(WHILE49);
					root_0 = (Object)adaptor.becomeRoot(WHILE49_tree, root_0);
					dbg.location(104,15);
					LPAR50=(Token)match(input,LPAR,FOLLOW_LPAR_in_function_call443); dbg.location(105,3);
					// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:105:3: ( operation ( SEMI ! operation )* )?
					int alt15=2;
					try { dbg.enterSubRule(15);
					try { dbg.enterDecision(15, decisionCanBacktrack[15]);

					int LA15_0 = input.LA(1);
					if ( (LA15_0==CELL_REF||(LA15_0 >= FUNCTION && LA15_0 <= GLOBAL_VAR)||LA15_0==LBRA||LA15_0==LPAR||LA15_0==MINUS||LA15_0==NUMBER||(LA15_0 >= STRING && LA15_0 <= TEMP_VAR)||LA15_0==WHILE) ) {
						alt15=1;
					}
					} finally {dbg.exitDecision(15);}

					switch (alt15) {
						case 1 :
							dbg.enterAlt(1);

							// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:105:5: operation ( SEMI ! operation )*
							{
							dbg.location(105,5);
							pushFollow(FOLLOW_operation_in_function_call451);
							operation51=operation();
							state._fsp--;

							adaptor.addChild(root_0, operation51.getTree());
							dbg.location(105,15);
							// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:105:15: ( SEMI ! operation )*
							try { dbg.enterSubRule(14);

							loop14:
							while (true) {
								int alt14=2;
								try { dbg.enterDecision(14, decisionCanBacktrack[14]);

								int LA14_0 = input.LA(1);
								if ( (LA14_0==SEMI) ) {
									alt14=1;
								}

								} finally {dbg.exitDecision(14);}

								switch (alt14) {
								case 1 :
									dbg.enterAlt(1);

									// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:105:17: SEMI ! operation
									{
									dbg.location(105,21);
									SEMI52=(Token)match(input,SEMI,FOLLOW_SEMI_in_function_call455); dbg.location(105,23);
									pushFollow(FOLLOW_operation_in_function_call458);
									operation53=operation();
									state._fsp--;

									adaptor.addChild(root_0, operation53.getTree());

									}
									break;

								default :
									break loop14;
								}
							}
							} finally {dbg.exitSubRule(14);}

							}
							break;

					}
					} finally {dbg.exitSubRule(15);}
					dbg.location(106,7);
					RPAR54=(Token)match(input,RPAR,FOLLOW_RPAR_in_function_call468); 
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:107:4: FUNCTION ^ LPAR ! ( comparison ( SEMI ! comparison )* )? RPAR !
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(107,12);
					FUNCTION55=(Token)match(input,FUNCTION,FOLLOW_FUNCTION_in_function_call474); 
					FUNCTION55_tree = (Object)adaptor.create(FUNCTION55);
					root_0 = (Object)adaptor.becomeRoot(FUNCTION55_tree, root_0);
					dbg.location(107,18);
					LPAR56=(Token)match(input,LPAR,FOLLOW_LPAR_in_function_call477); dbg.location(108,3);
					// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:108:3: ( comparison ( SEMI ! comparison )* )?
					int alt17=2;
					try { dbg.enterSubRule(17);
					try { dbg.enterDecision(17, decisionCanBacktrack[17]);

					int LA17_0 = input.LA(1);
					if ( (LA17_0==CELL_REF||(LA17_0 >= FUNCTION && LA17_0 <= GLOBAL_VAR)||LA17_0==LPAR||LA17_0==MINUS||LA17_0==NUMBER||(LA17_0 >= STRING && LA17_0 <= TEMP_VAR)||LA17_0==WHILE) ) {
						alt17=1;
					}
					} finally {dbg.exitDecision(17);}

					switch (alt17) {
						case 1 :
							dbg.enterAlt(1);

							// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:108:5: comparison ( SEMI ! comparison )*
							{
							dbg.location(108,5);
							pushFollow(FOLLOW_comparison_in_function_call485);
							comparison57=comparison();
							state._fsp--;

							adaptor.addChild(root_0, comparison57.getTree());
							dbg.location(108,16);
							// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:108:16: ( SEMI ! comparison )*
							try { dbg.enterSubRule(16);

							loop16:
							while (true) {
								int alt16=2;
								try { dbg.enterDecision(16, decisionCanBacktrack[16]);

								int LA16_0 = input.LA(1);
								if ( (LA16_0==SEMI) ) {
									alt16=1;
								}

								} finally {dbg.exitDecision(16);}

								switch (alt16) {
								case 1 :
									dbg.enterAlt(1);

									// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:108:18: SEMI ! comparison
									{
									dbg.location(108,22);
									SEMI58=(Token)match(input,SEMI,FOLLOW_SEMI_in_function_call489); dbg.location(108,24);
									pushFollow(FOLLOW_comparison_in_function_call492);
									comparison59=comparison();
									state._fsp--;

									adaptor.addChild(root_0, comparison59.getTree());

									}
									break;

								default :
									break loop16;
								}
							}
							} finally {dbg.exitSubRule(16);}

							}
							break;

					}
					} finally {dbg.exitSubRule(17);}
					dbg.location(109,7);
					RPAR60=(Token)match(input,RPAR,FOLLOW_RPAR_in_function_call502); 
					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:110:4: FUNCTION ^ LBRA ! ( assignment SEMI ! comparison SEMI ! assignment ( SEMI ! operation )* )? RBRA !
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(110,12);
					FUNCTION61=(Token)match(input,FUNCTION,FOLLOW_FUNCTION_in_function_call509); 
					FUNCTION61_tree = (Object)adaptor.create(FUNCTION61);
					root_0 = (Object)adaptor.becomeRoot(FUNCTION61_tree, root_0);
					dbg.location(110,18);
					LBRA62=(Token)match(input,LBRA,FOLLOW_LBRA_in_function_call512); dbg.location(110,20);
					// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:110:20: ( assignment SEMI ! comparison SEMI ! assignment ( SEMI ! operation )* )?
					int alt19=2;
					try { dbg.enterSubRule(19);
					try { dbg.enterDecision(19, decisionCanBacktrack[19]);

					int LA19_0 = input.LA(1);
					if ( (LA19_0==CELL_REF||LA19_0==GLOBAL_VAR||LA19_0==TEMP_VAR) ) {
						alt19=1;
					}
					} finally {dbg.exitDecision(19);}

					switch (alt19) {
						case 1 :
							dbg.enterAlt(1);

							// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:110:22: assignment SEMI ! comparison SEMI ! assignment ( SEMI ! operation )*
							{
							dbg.location(110,22);
							pushFollow(FOLLOW_assignment_in_function_call517);
							assignment63=assignment();
							state._fsp--;

							adaptor.addChild(root_0, assignment63.getTree());
							dbg.location(110,37);
							SEMI64=(Token)match(input,SEMI,FOLLOW_SEMI_in_function_call519); dbg.location(110,39);
							pushFollow(FOLLOW_comparison_in_function_call522);
							comparison65=comparison();
							state._fsp--;

							adaptor.addChild(root_0, comparison65.getTree());
							dbg.location(110,54);
							SEMI66=(Token)match(input,SEMI,FOLLOW_SEMI_in_function_call524); dbg.location(110,56);
							pushFollow(FOLLOW_assignment_in_function_call527);
							assignment67=assignment();
							state._fsp--;

							adaptor.addChild(root_0, assignment67.getTree());
							dbg.location(110,67);
							// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:110:67: ( SEMI ! operation )*
							try { dbg.enterSubRule(18);

							loop18:
							while (true) {
								int alt18=2;
								try { dbg.enterDecision(18, decisionCanBacktrack[18]);

								int LA18_0 = input.LA(1);
								if ( (LA18_0==SEMI) ) {
									alt18=1;
								}

								} finally {dbg.exitDecision(18);}

								switch (alt18) {
								case 1 :
									dbg.enterAlt(1);

									// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:110:69: SEMI ! operation
									{
									dbg.location(110,73);
									SEMI68=(Token)match(input,SEMI,FOLLOW_SEMI_in_function_call531); dbg.location(110,75);
									pushFollow(FOLLOW_operation_in_function_call534);
									operation69=operation();
									state._fsp--;

									adaptor.addChild(root_0, operation69.getTree());

									}
									break;

								default :
									break loop18;
								}
							}
							} finally {dbg.exitSubRule(18);}

							}
							break;

					}
					} finally {dbg.exitSubRule(19);}
					dbg.location(110,95);
					RBRA70=(Token)match(input,RBRA,FOLLOW_RBRA_in_function_call542); 
					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}

			catch (RecognitionException e) {
				reportError(e);
				throw e; 
			}

		finally {
			// do for sure before leaving
		}
		dbg.location(111, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "function_call");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "function_call"


	public static class reference_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "reference"
	// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:113:1: reference : CELL_REF ( ( COLON ^) CELL_REF )? ;
	public final FormulaParser.reference_return reference() throws RecognitionException {
		FormulaParser.reference_return retval = new FormulaParser.reference_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token CELL_REF71=null;
		Token COLON72=null;
		Token CELL_REF73=null;

		Object CELL_REF71_tree=null;
		Object COLON72_tree=null;
		Object CELL_REF73_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "reference");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(113, 0);

		try {
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:114:2: ( CELL_REF ( ( COLON ^) CELL_REF )? )
			dbg.enterAlt(1);

			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:114:4: CELL_REF ( ( COLON ^) CELL_REF )?
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(114,4);
			CELL_REF71=(Token)match(input,CELL_REF,FOLLOW_CELL_REF_in_reference556); 
			CELL_REF71_tree = (Object)adaptor.create(CELL_REF71);
			adaptor.addChild(root_0, CELL_REF71_tree);
			dbg.location(115,3);
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:115:3: ( ( COLON ^) CELL_REF )?
			int alt21=2;
			try { dbg.enterSubRule(21);
			try { dbg.enterDecision(21, decisionCanBacktrack[21]);

			int LA21_0 = input.LA(1);
			if ( (LA21_0==COLON) ) {
				alt21=1;
			}
			} finally {dbg.exitDecision(21);}

			switch (alt21) {
				case 1 :
					dbg.enterAlt(1);

					// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:115:5: ( COLON ^) CELL_REF
					{
					dbg.location(115,5);
					// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:115:5: ( COLON ^)
					dbg.enterAlt(1);

					// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:115:7: COLON ^
					{
					dbg.location(115,12);
					COLON72=(Token)match(input,COLON,FOLLOW_COLON_in_reference564); 
					COLON72_tree = (Object)adaptor.create(COLON72);
					root_0 = (Object)adaptor.becomeRoot(COLON72_tree, root_0);

					}
					dbg.location(115,16);
					CELL_REF73=(Token)match(input,CELL_REF,FOLLOW_CELL_REF_in_reference569); 
					CELL_REF73_tree = (Object)adaptor.create(CELL_REF73);
					adaptor.addChild(root_0, CELL_REF73_tree);

					}
					break;

			}
			} finally {dbg.exitSubRule(21);}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}

			catch (RecognitionException e) {
				reportError(e);
				throw e; 
			}

		finally {
			// do for sure before leaving
		}
		dbg.location(116, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "reference");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "reference"


	public static class literal_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "literal"
	// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:118:1: literal : ( NUMBER | STRING );
	public final FormulaParser.literal_return literal() throws RecognitionException {
		FormulaParser.literal_return retval = new FormulaParser.literal_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set74=null;

		Object set74_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "literal");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(118, 0);

		try {
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:119:2: ( NUMBER | STRING )
			dbg.enterAlt(1);

			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(119,2);
			set74=input.LT(1);
			if ( input.LA(1)==NUMBER||input.LA(1)==STRING ) {
				input.consume();
				adaptor.addChild(root_0, (Object)adaptor.create(set74));
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				dbg.recognitionException(mse);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}

			catch (RecognitionException e) {
				reportError(e);
				throw e; 
			}

		finally {
			// do for sure before leaving
		}
		dbg.location(121, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "literal");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "literal"

	// Delegated rules



	public static final BitSet FOLLOW_EQ_in_expression80 = new BitSet(new long[]{0x0000005809298100L});
	public static final BitSet FOLLOW_operation_in_expression83 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_expression85 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_assignment_in_operation100 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_comparison_in_operation104 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_block_in_operation108 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LBRA_in_block122 = new BitSet(new long[]{0x0000005809298100L});
	public static final BitSet FOLLOW_operation_in_block125 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_SEMI_in_block128 = new BitSet(new long[]{0x0000005809298100L});
	public static final BitSet FOLLOW_operation_in_block131 = new BitSet(new long[]{0x0000000500000000L});
	public static final BitSet FOLLOW_RBRA_in_block136 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_set_in_assignment155 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ASSIGN_in_assignment167 = new BitSet(new long[]{0x0000005809218100L});
	public static final BitSet FOLLOW_comparison_in_assignment170 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_concatenation_in_comparison188 = new BitSet(new long[]{0x0000000004C62002L});
	public static final BitSet FOLLOW_EQ_in_comparison196 = new BitSet(new long[]{0x0000005809218100L});
	public static final BitSet FOLLOW_NEQ_in_comparison201 = new BitSet(new long[]{0x0000005809218100L});
	public static final BitSet FOLLOW_GT_in_comparison206 = new BitSet(new long[]{0x0000005809218100L});
	public static final BitSet FOLLOW_LT_in_comparison211 = new BitSet(new long[]{0x0000005809218100L});
	public static final BitSet FOLLOW_LTEQ_in_comparison216 = new BitSet(new long[]{0x0000005809218100L});
	public static final BitSet FOLLOW_GTEQ_in_comparison221 = new BitSet(new long[]{0x0000005809218100L});
	public static final BitSet FOLLOW_concatenation_in_comparison226 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_arithmetic_lowest_in_concatenation240 = new BitSet(new long[]{0x0000000000000022L});
	public static final BitSet FOLLOW_AMP_in_concatenation246 = new BitSet(new long[]{0x0000005809218100L});
	public static final BitSet FOLLOW_arithmetic_lowest_in_concatenation249 = new BitSet(new long[]{0x0000000000000022L});
	public static final BitSet FOLLOW_arithmetic_low_in_arithmetic_lowest263 = new BitSet(new long[]{0x0000000021000002L});
	public static final BitSet FOLLOW_PLUS_in_arithmetic_lowest271 = new BitSet(new long[]{0x0000005809218100L});
	public static final BitSet FOLLOW_MINUS_in_arithmetic_lowest276 = new BitSet(new long[]{0x0000005809218100L});
	public static final BitSet FOLLOW_arithmetic_low_in_arithmetic_lowest281 = new BitSet(new long[]{0x0000000021000002L});
	public static final BitSet FOLLOW_arithmetic_medium_in_arithmetic_low295 = new BitSet(new long[]{0x0000000002001002L});
	public static final BitSet FOLLOW_MULTI_in_arithmetic_low303 = new BitSet(new long[]{0x0000005809218100L});
	public static final BitSet FOLLOW_DIV_in_arithmetic_low308 = new BitSet(new long[]{0x0000005809218100L});
	public static final BitSet FOLLOW_arithmetic_medium_in_arithmetic_low313 = new BitSet(new long[]{0x0000000002001002L});
	public static final BitSet FOLLOW_arithmetic_high_in_arithmetic_medium327 = new BitSet(new long[]{0x0000000040000002L});
	public static final BitSet FOLLOW_POWER_in_arithmetic_medium333 = new BitSet(new long[]{0x0000005809218100L});
	public static final BitSet FOLLOW_arithmetic_high_in_arithmetic_medium336 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_arithmetic_highest_in_arithmetic_high350 = new BitSet(new long[]{0x0000000010000002L});
	public static final BitSet FOLLOW_PERCENT_in_arithmetic_high354 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_arithmetic_highest371 = new BitSet(new long[]{0x0000005808218100L});
	public static final BitSet FOLLOW_atom_in_arithmetic_highest377 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_function_call_in_atom388 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_reference_in_atom393 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TEMP_VAR_in_atom403 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_GLOBAL_VAR_in_atom413 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_literal_in_atom418 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_atom423 = new BitSet(new long[]{0x0000005809218100L});
	public static final BitSet FOLLOW_comparison_in_atom426 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_RPAR_in_atom428 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WHILE_in_function_call440 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_LPAR_in_function_call443 = new BitSet(new long[]{0x0000005A09298100L});
	public static final BitSet FOLLOW_operation_in_function_call451 = new BitSet(new long[]{0x0000000600000000L});
	public static final BitSet FOLLOW_SEMI_in_function_call455 = new BitSet(new long[]{0x0000005809298100L});
	public static final BitSet FOLLOW_operation_in_function_call458 = new BitSet(new long[]{0x0000000600000000L});
	public static final BitSet FOLLOW_RPAR_in_function_call468 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FUNCTION_in_function_call474 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_LPAR_in_function_call477 = new BitSet(new long[]{0x0000005A09218100L});
	public static final BitSet FOLLOW_comparison_in_function_call485 = new BitSet(new long[]{0x0000000600000000L});
	public static final BitSet FOLLOW_SEMI_in_function_call489 = new BitSet(new long[]{0x0000005809218100L});
	public static final BitSet FOLLOW_comparison_in_function_call492 = new BitSet(new long[]{0x0000000600000000L});
	public static final BitSet FOLLOW_RPAR_in_function_call502 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FUNCTION_in_function_call509 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_LBRA_in_function_call512 = new BitSet(new long[]{0x0000001100010100L});
	public static final BitSet FOLLOW_assignment_in_function_call517 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_SEMI_in_function_call519 = new BitSet(new long[]{0x0000005809218100L});
	public static final BitSet FOLLOW_comparison_in_function_call522 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_SEMI_in_function_call524 = new BitSet(new long[]{0x0000001000010100L});
	public static final BitSet FOLLOW_assignment_in_function_call527 = new BitSet(new long[]{0x0000000500000000L});
	public static final BitSet FOLLOW_SEMI_in_function_call531 = new BitSet(new long[]{0x0000005809298100L});
	public static final BitSet FOLLOW_operation_in_function_call534 = new BitSet(new long[]{0x0000000500000000L});
	public static final BitSet FOLLOW_RBRA_in_function_call542 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CELL_REF_in_reference556 = new BitSet(new long[]{0x0000000000000202L});
	public static final BitSet FOLLOW_COLON_in_reference564 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_CELL_REF_in_reference569 = new BitSet(new long[]{0x0000000000000002L});
}
