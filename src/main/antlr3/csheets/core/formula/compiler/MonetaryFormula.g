grammar MonetaryFormula;

options {
	language=Java;
	output=AST;
}


@parser::header {
package csheets.core.formula.compiler;
}

@lexer::header {
package csheets.core.formula.compiler;
}

// Alter code generation so catch-clauses get replace with
// this action.
@rulecatch {
	catch (RecognitionException e) {
		reportError(e);
		throw e;
	}
}

@members {
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
}

expression
	: EQ! (block | operation) EOF! |
		MONETARY! (block | operation) EOF!
	;

operation
    : assignment | comparison
    ;

block
	: LBRA^ operation (SEMI! operation)+  RBRA!
	;

assignment
        : (CELL_REF | TEMP_VAR) ASSIGN^ comparison
        ;

comparison
	: concatenation
		( ( EQ^ | NEQ^ | GT^ | LT^ | LTEQ^ | GTEQ^ ) concatenation )?
	;

concatenation
	: arithmetic_lowest
		( AMP^ arithmetic_lowest )*
	;

arithmetic_lowest
	:	arithmetic_low
		( ( PLUS^ | MINUS^ ) arithmetic_low )*
	;

arithmetic_low
	:
		( ( MULTI^ | DIV^ )? atom )*
	;

atom
	:	reference
	|       TEMP_VAR
	|	literal
	|	LPAR! comparison RPAR!
	|	currencyname^ LBRA! comparison RBRA!
	;

reference
	:	CELL_REF
		( ( COLON^ ) CELL_REF )?
	;

literal
	: NUMBER
	| NUMBER currencysymbol
	| STRING
	;
/* Currency */
currencyname : EUR | POUND | DOLLAR;
currencysymbol : EUR_SYM | POUND_SYM | DOLLAR_SYM;

/* Currency symbols */
EUR: 'euro' | 'euros' | 'eur' | 'EURO' | 'EUROS' | 'EUR';
POUND: 'pound' | 'pounds' | 'POUND' | 'POUNDS' | 'GBP' | 'gbp';
DOLLAR: 'dollar' | 'dollars' | 'USD' | 'usd' | 'DOLLAR' | 'DOLLARS';

/* Currency name */
EUR_SYM: '€';
POUND_SYM: '£';
DOLLAR_SYM: '$';

fragment LETTER: ('a'..'z'|'A'..'Z') ;

FUNCTION :
	  ( LETTER )+
	;

CELL_REF
	:
		( ABS )? LETTER ( LETTER )?
		( ABS )? ( DIGIT )+
	;

/* String literals, i.e. anything inside the delimiters */

STRING	:	QUOT
		(options {greedy=false;}:.)*
		QUOT  { setText(getText().substring(1, getText().length()-1)); }
	;

QUOT: '"'
	;

/* Numeric literals */
NUMBER: ( DIGIT )+ ( COMMA ( DIGIT )+ )? ;

fragment
DIGIT : '0'..'9' ;

/* Comparison operators */
MONETARY : '#';
EQ	: '=';
ASSIGN  : ':=';
NEQ	: '<>' ;
LTEQ	: '<=' ;
GTEQ	: '>=' ;
GT	: '>' ;
LT	: '<' ;

/* Text operators */
AMP		: '&' ;

/* Arithmetic operators */
PLUS	: '+' ;
MINUS	: '-' ;
MULTI	: '*' ;
DIV	: '/' ;
POWER	: '^' ;
PERCENT : '%' ;

/* Reference operators */
fragment ABS : '$' ;
fragment EXCL:  '!'  ;
COLON	: ':' ;

/* Miscellaneous operators */
COMMA	: ',' ;
SEMI	: ';' ;
LPAR	: '(' ;
RPAR	: ')' ;
LBRA	: '{' ;
RBRA	: '}' ;


/* White-space (ignored) */
WS: ( ' '
	| '\r' '\n'
	| '\n'
	| '\t'
	) {$channel=HIDDEN;}
	;

/*Temporal Variables*/
UNDERSCORE : '_';
TEMP_VAR : UNDERSCORE(LETTER | DIGIT)(LETTER | DIGIT)*;
