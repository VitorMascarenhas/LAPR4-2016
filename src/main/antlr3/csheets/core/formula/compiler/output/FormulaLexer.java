// $ANTLR 3.5.1 D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g 2016-06-22 19:21:33

package csheets.core.formula.compiler;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class FormulaLexer extends Lexer {
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
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public FormulaLexer() {} 
	public FormulaLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public FormulaLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g"; }

	// $ANTLR start "WHILE"
	public final void mWHILE() throws RecognitionException {
		try {
			int _type = WHILE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:123:7: ( 'dowhile' | 'whiledo' | 'DoWhile' | 'WhileDo' | 'DOWHILE' | 'WHILEDO' )
			int alt1=6;
			switch ( input.LA(1) ) {
			case 'd':
				{
				alt1=1;
				}
				break;
			case 'w':
				{
				alt1=2;
				}
				break;
			case 'D':
				{
				int LA1_3 = input.LA(2);
				if ( (LA1_3=='o') ) {
					alt1=3;
				}
				else if ( (LA1_3=='O') ) {
					alt1=5;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 1, 3, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case 'W':
				{
				int LA1_4 = input.LA(2);
				if ( (LA1_4=='h') ) {
					alt1=4;
				}
				else if ( (LA1_4=='H') ) {
					alt1=6;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 1, 4, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}
			switch (alt1) {
				case 1 :
					// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:123:9: 'dowhile'
					{
					match("dowhile"); 

					}
					break;
				case 2 :
					// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:123:21: 'whiledo'
					{
					match("whiledo"); 

					}
					break;
				case 3 :
					// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:123:33: 'DoWhile'
					{
					match("DoWhile"); 

					}
					break;
				case 4 :
					// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:123:45: 'WhileDo'
					{
					match("WhileDo"); 

					}
					break;
				case 5 :
					// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:123:57: 'DOWHILE'
					{
					match("DOWHILE"); 

					}
					break;
				case 6 :
					// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:123:69: 'WHILEDO'
					{
					match("WHILEDO"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WHILE"

	// $ANTLR start "TEMP_VAR"
	public final void mTEMP_VAR() throws RecognitionException {
		try {
			int _type = TEMP_VAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:126:10: ( UNDERSCORE ( LETTER | DIGIT )+ )
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:126:12: UNDERSCORE ( LETTER | DIGIT )+
			{
			mUNDERSCORE(); 

			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:126:22: ( LETTER | DIGIT )+
			int cnt2=0;
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( ((LA2_0 >= '0' && LA2_0 <= '9')||(LA2_0 >= 'A' && LA2_0 <= 'Z')||(LA2_0 >= 'a' && LA2_0 <= 'z')) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt2 >= 1 ) break loop2;
					EarlyExitException eee = new EarlyExitException(2, input);
					throw eee;
				}
				cnt2++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TEMP_VAR"

	// $ANTLR start "GLOBAL_VAR"
	public final void mGLOBAL_VAR() throws RecognitionException {
		try {
			int _type = GLOBAL_VAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:128:12: ( AT ( LETTER | DIGIT )+ )
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:128:14: AT ( LETTER | DIGIT )+
			{
			mAT(); 

			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:128:16: ( LETTER | DIGIT )+
			int cnt3=0;
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( ((LA3_0 >= '0' && LA3_0 <= '9')||(LA3_0 >= 'A' && LA3_0 <= 'Z')||(LA3_0 >= 'a' && LA3_0 <= 'z')) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt3 >= 1 ) break loop3;
					EarlyExitException eee = new EarlyExitException(3, input);
					throw eee;
				}
				cnt3++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "GLOBAL_VAR"

	// $ANTLR start "LETTER"
	public final void mLETTER() throws RecognitionException {
		try {
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:130:16: ( ( 'a' .. 'z' | 'A' .. 'Z' ) )
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LETTER"

	// $ANTLR start "FUNCTION"
	public final void mFUNCTION() throws RecognitionException {
		try {
			int _type = FUNCTION;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:132:10: ( ( LETTER )+ )
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:133:4: ( LETTER )+
			{
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:133:4: ( LETTER )+
			int cnt4=0;
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( ((LA4_0 >= 'A' && LA4_0 <= 'Z')||(LA4_0 >= 'a' && LA4_0 <= 'z')) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:
					{
					if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt4 >= 1 ) break loop4;
					EarlyExitException eee = new EarlyExitException(4, input);
					throw eee;
				}
				cnt4++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FUNCTION"

	// $ANTLR start "CELL_REF"
	public final void mCELL_REF() throws RecognitionException {
		try {
			int _type = CELL_REF;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:138:2: ( ( ABS )? LETTER ( LETTER )? ( ABS )? ( DIGIT )+ )
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:139:3: ( ABS )? LETTER ( LETTER )? ( ABS )? ( DIGIT )+
			{
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:139:3: ( ABS )?
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0=='$') ) {
				alt5=1;
			}
			switch (alt5) {
				case 1 :
					// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:
					{
					if ( input.LA(1)=='$' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

			}

			mLETTER(); 

			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:139:19: ( LETTER )?
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( ((LA6_0 >= 'A' && LA6_0 <= 'Z')||(LA6_0 >= 'a' && LA6_0 <= 'z')) ) {
				alt6=1;
			}
			switch (alt6) {
				case 1 :
					// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:
					{
					if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

			}

			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:140:3: ( ABS )?
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0=='$') ) {
				alt7=1;
			}
			switch (alt7) {
				case 1 :
					// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:
					{
					if ( input.LA(1)=='$' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

			}

			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:140:12: ( DIGIT )+
			int cnt8=0;
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( ((LA8_0 >= '0' && LA8_0 <= '9')) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt8 >= 1 ) break loop8;
					EarlyExitException eee = new EarlyExitException(8, input);
					throw eee;
				}
				cnt8++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CELL_REF"

	// $ANTLR start "STRING"
	public final void mSTRING() throws RecognitionException {
		try {
			int _type = STRING;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:145:8: ( QUOT ( options {greedy=false; } : . )* QUOT )
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:145:10: QUOT ( options {greedy=false; } : . )* QUOT
			{
			mQUOT(); 

			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:146:3: ( options {greedy=false; } : . )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0=='\"') ) {
					alt9=2;
				}
				else if ( ((LA9_0 >= '\u0000' && LA9_0 <= '!')||(LA9_0 >= '#' && LA9_0 <= '\uFFFF')) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:146:28: .
					{
					matchAny(); 
					}
					break;

				default :
					break loop9;
				}
			}

			mQUOT(); 

			 setText(getText().substring(1, getText().length()-1)); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STRING"

	// $ANTLR start "QUOT"
	public final void mQUOT() throws RecognitionException {
		try {
			int _type = QUOT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:150:5: ( '\"' )
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:150:7: '\"'
			{
			match('\"'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "QUOT"

	// $ANTLR start "NUMBER"
	public final void mNUMBER() throws RecognitionException {
		try {
			int _type = NUMBER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:154:7: ( ( DIGIT )+ ( COMMA ( DIGIT )+ )? )
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:154:9: ( DIGIT )+ ( COMMA ( DIGIT )+ )?
			{
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:154:9: ( DIGIT )+
			int cnt10=0;
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( ((LA10_0 >= '0' && LA10_0 <= '9')) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt10 >= 1 ) break loop10;
					EarlyExitException eee = new EarlyExitException(10, input);
					throw eee;
				}
				cnt10++;
			}

			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:154:20: ( COMMA ( DIGIT )+ )?
			int alt12=2;
			int LA12_0 = input.LA(1);
			if ( (LA12_0==',') ) {
				alt12=1;
			}
			switch (alt12) {
				case 1 :
					// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:154:22: COMMA ( DIGIT )+
					{
					mCOMMA(); 

					// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:154:28: ( DIGIT )+
					int cnt11=0;
					loop11:
					while (true) {
						int alt11=2;
						int LA11_0 = input.LA(1);
						if ( ((LA11_0 >= '0' && LA11_0 <= '9')) ) {
							alt11=1;
						}

						switch (alt11) {
						case 1 :
							// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:
							{
							if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							if ( cnt11 >= 1 ) break loop11;
							EarlyExitException eee = new EarlyExitException(11, input);
							throw eee;
						}
						cnt11++;
					}

					}
					break;

			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NUMBER"

	// $ANTLR start "DIGIT"
	public final void mDIGIT() throws RecognitionException {
		try {
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:158:7: ( '0' .. '9' )
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:
			{
			if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DIGIT"

	// $ANTLR start "EQ"
	public final void mEQ() throws RecognitionException {
		try {
			int _type = EQ;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:160:4: ( '=' )
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:160:6: '='
			{
			match('='); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EQ"

	// $ANTLR start "ASSIGN"
	public final void mASSIGN() throws RecognitionException {
		try {
			int _type = ASSIGN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:161:9: ( ':=' )
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:161:11: ':='
			{
			match(":="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ASSIGN"

	// $ANTLR start "NEQ"
	public final void mNEQ() throws RecognitionException {
		try {
			int _type = NEQ;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:162:5: ( '<>' )
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:162:7: '<>'
			{
			match("<>"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NEQ"

	// $ANTLR start "LTEQ"
	public final void mLTEQ() throws RecognitionException {
		try {
			int _type = LTEQ;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:163:6: ( '<=' )
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:163:8: '<='
			{
			match("<="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LTEQ"

	// $ANTLR start "GTEQ"
	public final void mGTEQ() throws RecognitionException {
		try {
			int _type = GTEQ;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:164:6: ( '>=' )
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:164:8: '>='
			{
			match(">="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "GTEQ"

	// $ANTLR start "GT"
	public final void mGT() throws RecognitionException {
		try {
			int _type = GT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:165:4: ( '>' )
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:165:6: '>'
			{
			match('>'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "GT"

	// $ANTLR start "LT"
	public final void mLT() throws RecognitionException {
		try {
			int _type = LT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:166:4: ( '<' )
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:166:6: '<'
			{
			match('<'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LT"

	// $ANTLR start "UNDERSCORE"
	public final void mUNDERSCORE() throws RecognitionException {
		try {
			int _type = UNDERSCORE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:167:12: ( '_' )
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:167:14: '_'
			{
			match('_'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "UNDERSCORE"

	// $ANTLR start "AT"
	public final void mAT() throws RecognitionException {
		try {
			int _type = AT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:168:4: ( '@' )
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:168:6: '@'
			{
			match('@'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "AT"

	// $ANTLR start "AMP"
	public final void mAMP() throws RecognitionException {
		try {
			int _type = AMP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:171:6: ( '&' )
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:171:8: '&'
			{
			match('&'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "AMP"

	// $ANTLR start "PLUS"
	public final void mPLUS() throws RecognitionException {
		try {
			int _type = PLUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:174:6: ( '+' )
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:174:8: '+'
			{
			match('+'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PLUS"

	// $ANTLR start "MINUS"
	public final void mMINUS() throws RecognitionException {
		try {
			int _type = MINUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:175:7: ( '-' )
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:175:9: '-'
			{
			match('-'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MINUS"

	// $ANTLR start "MULTI"
	public final void mMULTI() throws RecognitionException {
		try {
			int _type = MULTI;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:176:7: ( '*' )
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:176:9: '*'
			{
			match('*'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MULTI"

	// $ANTLR start "DIV"
	public final void mDIV() throws RecognitionException {
		try {
			int _type = DIV;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:177:5: ( '/' )
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:177:7: '/'
			{
			match('/'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DIV"

	// $ANTLR start "POWER"
	public final void mPOWER() throws RecognitionException {
		try {
			int _type = POWER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:178:7: ( '^' )
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:178:9: '^'
			{
			match('^'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "POWER"

	// $ANTLR start "PERCENT"
	public final void mPERCENT() throws RecognitionException {
		try {
			int _type = PERCENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:179:9: ( '%' )
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:179:11: '%'
			{
			match('%'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PERCENT"

	// $ANTLR start "ABS"
	public final void mABS() throws RecognitionException {
		try {
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:182:14: ( '$' )
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:182:16: '$'
			{
			match('$'); 
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ABS"

	// $ANTLR start "EXCL"
	public final void mEXCL() throws RecognitionException {
		try {
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:183:14: ( '!' )
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:183:17: '!'
			{
			match('!'); 
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EXCL"

	// $ANTLR start "COLON"
	public final void mCOLON() throws RecognitionException {
		try {
			int _type = COLON;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:184:7: ( ':' )
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:184:9: ':'
			{
			match(':'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COLON"

	// $ANTLR start "COMMA"
	public final void mCOMMA() throws RecognitionException {
		try {
			int _type = COMMA;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:187:7: ( ',' )
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:187:9: ','
			{
			match(','); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMA"

	// $ANTLR start "SEMI"
	public final void mSEMI() throws RecognitionException {
		try {
			int _type = SEMI;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:188:6: ( ';' )
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:188:8: ';'
			{
			match(';'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SEMI"

	// $ANTLR start "LPAR"
	public final void mLPAR() throws RecognitionException {
		try {
			int _type = LPAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:189:6: ( '(' )
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:189:8: '('
			{
			match('('); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LPAR"

	// $ANTLR start "RPAR"
	public final void mRPAR() throws RecognitionException {
		try {
			int _type = RPAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:190:6: ( ')' )
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:190:8: ')'
			{
			match(')'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RPAR"

	// $ANTLR start "LBRA"
	public final void mLBRA() throws RecognitionException {
		try {
			int _type = LBRA;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:191:6: ( '{' )
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:191:8: '{'
			{
			match('{'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LBRA"

	// $ANTLR start "RBRA"
	public final void mRBRA() throws RecognitionException {
		try {
			int _type = RBRA;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:192:6: ( '}' )
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:192:8: '}'
			{
			match('}'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RBRA"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:196:3: ( ( ' ' | '\\r' '\\n' | '\\n' | '\\t' ) )
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:196:5: ( ' ' | '\\r' '\\n' | '\\n' | '\\t' )
			{
			// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:196:5: ( ' ' | '\\r' '\\n' | '\\n' | '\\t' )
			int alt13=4;
			switch ( input.LA(1) ) {
			case ' ':
				{
				alt13=1;
				}
				break;
			case '\r':
				{
				alt13=2;
				}
				break;
			case '\n':
				{
				alt13=3;
				}
				break;
			case '\t':
				{
				alt13=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 13, 0, input);
				throw nvae;
			}
			switch (alt13) {
				case 1 :
					// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:196:7: ' '
					{
					match(' '); 
					}
					break;
				case 2 :
					// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:197:4: '\\r' '\\n'
					{
					match('\r'); 
					match('\n'); 
					}
					break;
				case 3 :
					// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:198:4: '\\n'
					{
					match('\n'); 
					}
					break;
				case 4 :
					// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:199:4: '\\t'
					{
					match('\t'); 
					}
					break;

			}

			_channel=HIDDEN;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WS"

	@Override
	public void mTokens() throws RecognitionException {
		// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:1:8: ( WHILE | TEMP_VAR | GLOBAL_VAR | FUNCTION | CELL_REF | STRING | QUOT | NUMBER | EQ | ASSIGN | NEQ | LTEQ | GTEQ | GT | LT | UNDERSCORE | AT | AMP | PLUS | MINUS | MULTI | DIV | POWER | PERCENT | COLON | COMMA | SEMI | LPAR | RPAR | LBRA | RBRA | WS )
		int alt14=32;
		alt14 = dfa14.predict(input);
		switch (alt14) {
			case 1 :
				// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:1:10: WHILE
				{
				mWHILE(); 

				}
				break;
			case 2 :
				// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:1:16: TEMP_VAR
				{
				mTEMP_VAR(); 

				}
				break;
			case 3 :
				// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:1:25: GLOBAL_VAR
				{
				mGLOBAL_VAR(); 

				}
				break;
			case 4 :
				// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:1:36: FUNCTION
				{
				mFUNCTION(); 

				}
				break;
			case 5 :
				// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:1:45: CELL_REF
				{
				mCELL_REF(); 

				}
				break;
			case 6 :
				// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:1:54: STRING
				{
				mSTRING(); 

				}
				break;
			case 7 :
				// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:1:61: QUOT
				{
				mQUOT(); 

				}
				break;
			case 8 :
				// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:1:66: NUMBER
				{
				mNUMBER(); 

				}
				break;
			case 9 :
				// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:1:73: EQ
				{
				mEQ(); 

				}
				break;
			case 10 :
				// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:1:76: ASSIGN
				{
				mASSIGN(); 

				}
				break;
			case 11 :
				// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:1:83: NEQ
				{
				mNEQ(); 

				}
				break;
			case 12 :
				// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:1:87: LTEQ
				{
				mLTEQ(); 

				}
				break;
			case 13 :
				// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:1:92: GTEQ
				{
				mGTEQ(); 

				}
				break;
			case 14 :
				// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:1:97: GT
				{
				mGT(); 

				}
				break;
			case 15 :
				// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:1:100: LT
				{
				mLT(); 

				}
				break;
			case 16 :
				// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:1:103: UNDERSCORE
				{
				mUNDERSCORE(); 

				}
				break;
			case 17 :
				// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:1:114: AT
				{
				mAT(); 

				}
				break;
			case 18 :
				// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:1:117: AMP
				{
				mAMP(); 

				}
				break;
			case 19 :
				// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:1:121: PLUS
				{
				mPLUS(); 

				}
				break;
			case 20 :
				// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:1:126: MINUS
				{
				mMINUS(); 

				}
				break;
			case 21 :
				// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:1:132: MULTI
				{
				mMULTI(); 

				}
				break;
			case 22 :
				// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:1:138: DIV
				{
				mDIV(); 

				}
				break;
			case 23 :
				// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:1:142: POWER
				{
				mPOWER(); 

				}
				break;
			case 24 :
				// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:1:148: PERCENT
				{
				mPERCENT(); 

				}
				break;
			case 25 :
				// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:1:156: COLON
				{
				mCOLON(); 

				}
				break;
			case 26 :
				// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:1:162: COMMA
				{
				mCOMMA(); 

				}
				break;
			case 27 :
				// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:1:168: SEMI
				{
				mSEMI(); 

				}
				break;
			case 28 :
				// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:1:173: LPAR
				{
				mLPAR(); 

				}
				break;
			case 29 :
				// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:1:178: RPAR
				{
				mRPAR(); 

				}
				break;
			case 30 :
				// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:1:183: LBRA
				{
				mLBRA(); 

				}
				break;
			case 31 :
				// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:1:188: RBRA
				{
				mRBRA(); 

				}
				break;
			case 32 :
				// D:\\repos\\lapr4-2016-2na\\src\\main\\antlr3\\csheets\\core\\formula\\compiler\\Formula.g:1:193: WS
				{
				mWS(); 

				}
				break;

		}
	}


	protected DFA14 dfa14 = new DFA14(this);
	static final String DFA14_eotS =
		"\1\uffff\4\36\1\45\1\47\1\36\1\uffff\1\51\2\uffff\1\54\1\57\1\61\16\uffff"+
		"\1\36\1\uffff\6\36\15\uffff\30\36\6\120\1\uffff";
	static final String DFA14_eofS =
		"\121\uffff";
	static final String DFA14_minS =
		"\1\11\4\44\2\60\1\44\1\uffff\1\0\2\uffff\3\75\16\uffff\1\44\1\uffff\6"+
		"\44\15\uffff\1\150\1\154\1\150\1\110\1\154\1\114\1\151\1\145\1\151\1\111"+
		"\1\145\1\105\1\154\1\144\1\154\1\114\2\104\1\145\1\157\1\145\1\105\1\157"+
		"\1\117\6\101\1\uffff";
	static final String DFA14_maxS =
		"\1\175\7\172\1\uffff\1\uffff\2\uffff\1\75\1\76\1\75\16\uffff\1\167\1\uffff"+
		"\1\71\1\151\2\127\1\151\1\111\15\uffff\1\150\1\154\1\150\1\110\1\154\1"+
		"\114\1\151\1\145\1\151\1\111\1\145\1\105\1\154\1\144\1\154\1\114\2\104"+
		"\1\145\1\157\1\145\1\105\1\157\1\117\6\172\1\uffff";
	static final String DFA14_acceptS =
		"\10\uffff\1\5\1\uffff\1\10\1\11\3\uffff\1\22\1\23\1\24\1\25\1\26\1\27"+
		"\1\30\1\32\1\33\1\34\1\35\1\36\1\37\1\40\1\uffff\1\4\6\uffff\1\20\1\2"+
		"\1\21\1\3\1\7\1\6\1\12\1\31\1\13\1\14\1\17\1\15\1\16\36\uffff\1\1";
	static final String DFA14_specialS =
		"\11\uffff\1\0\107\uffff}>";
	static final String[] DFA14_transitionS = {
			"\2\34\2\uffff\1\34\22\uffff\1\34\1\uffff\1\11\1\uffff\1\10\1\25\1\17"+
			"\1\uffff\1\30\1\31\1\22\1\20\1\26\1\21\1\uffff\1\23\12\12\1\14\1\27\1"+
			"\15\1\13\1\16\1\uffff\1\6\3\7\1\3\22\7\1\4\3\7\3\uffff\1\24\1\5\1\uffff"+
			"\3\7\1\1\22\7\1\2\3\7\1\32\1\uffff\1\33",
			"\1\10\13\uffff\12\10\7\uffff\32\37\6\uffff\16\37\1\35\13\37",
			"\1\10\13\uffff\12\10\7\uffff\32\37\6\uffff\7\37\1\40\22\37",
			"\1\10\13\uffff\12\10\7\uffff\16\37\1\42\13\37\6\uffff\16\37\1\41\13"+
			"\37",
			"\1\10\13\uffff\12\10\7\uffff\7\37\1\44\22\37\6\uffff\7\37\1\43\22\37",
			"\12\46\7\uffff\32\46\6\uffff\32\46",
			"\12\50\7\uffff\32\50\6\uffff\32\50",
			"\1\10\13\uffff\12\10\7\uffff\32\37\6\uffff\32\37",
			"",
			"\0\52",
			"",
			"",
			"\1\53",
			"\1\56\1\55",
			"\1\60",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\10\13\uffff\12\10\75\uffff\1\62",
			"",
			"\1\10\13\uffff\12\10",
			"\1\10\13\uffff\12\10\57\uffff\1\63",
			"\1\10\13\uffff\12\10\35\uffff\1\64",
			"\1\10\13\uffff\12\10\35\uffff\1\65",
			"\1\10\13\uffff\12\10\57\uffff\1\66",
			"\1\10\13\uffff\12\10\17\uffff\1\67",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\70",
			"\1\71",
			"\1\72",
			"\1\73",
			"\1\74",
			"\1\75",
			"\1\76",
			"\1\77",
			"\1\100",
			"\1\101",
			"\1\102",
			"\1\103",
			"\1\104",
			"\1\105",
			"\1\106",
			"\1\107",
			"\1\110",
			"\1\111",
			"\1\112",
			"\1\113",
			"\1\114",
			"\1\115",
			"\1\116",
			"\1\117",
			"\32\36\6\uffff\32\36",
			"\32\36\6\uffff\32\36",
			"\32\36\6\uffff\32\36",
			"\32\36\6\uffff\32\36",
			"\32\36\6\uffff\32\36",
			"\32\36\6\uffff\32\36",
			""
	};

	static final short[] DFA14_eot = DFA.unpackEncodedString(DFA14_eotS);
	static final short[] DFA14_eof = DFA.unpackEncodedString(DFA14_eofS);
	static final char[] DFA14_min = DFA.unpackEncodedStringToUnsignedChars(DFA14_minS);
	static final char[] DFA14_max = DFA.unpackEncodedStringToUnsignedChars(DFA14_maxS);
	static final short[] DFA14_accept = DFA.unpackEncodedString(DFA14_acceptS);
	static final short[] DFA14_special = DFA.unpackEncodedString(DFA14_specialS);
	static final short[][] DFA14_transition;

	static {
		int numStates = DFA14_transitionS.length;
		DFA14_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA14_transition[i] = DFA.unpackEncodedString(DFA14_transitionS[i]);
		}
	}

	protected class DFA14 extends DFA {

		public DFA14(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 14;
			this.eot = DFA14_eot;
			this.eof = DFA14_eof;
			this.min = DFA14_min;
			this.max = DFA14_max;
			this.accept = DFA14_accept;
			this.special = DFA14_special;
			this.transition = DFA14_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( WHILE | TEMP_VAR | GLOBAL_VAR | FUNCTION | CELL_REF | STRING | QUOT | NUMBER | EQ | ASSIGN | NEQ | LTEQ | GTEQ | GT | LT | UNDERSCORE | AT | AMP | PLUS | MINUS | MULTI | DIV | POWER | PERCENT | COLON | COMMA | SEMI | LPAR | RPAR | LBRA | RBRA | WS );";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			IntStream input = _input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA14_9 = input.LA(1);
						s = -1;
						if ( ((LA14_9 >= '\u0000' && LA14_9 <= '\uFFFF')) ) {s = 42;}
						else s = 41;
						if ( s>=0 ) return s;
						break;
			}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 14, _s, input);
			error(nvae);
			throw nvae;
		}
	}

}
