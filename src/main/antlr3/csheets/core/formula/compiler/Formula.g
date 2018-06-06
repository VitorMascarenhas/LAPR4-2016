grammar Formula;

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
	: EQ! operation EOF!
	;

operation
    : assignment | comparison | block
    ;

block
	: LBRA^ operation (SEMI! operation)+  RBRA!
	;

assignment
        : (CELL_REF | TEMP_VAR | GLOBAL_VAR) ASSIGN^ comparison
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
	:	arithmetic_medium
		( ( MULTI^ | DIV^ ) arithmetic_medium )*
	;

arithmetic_medium
	:	arithmetic_high
		( POWER^ arithmetic_high )?
	;

arithmetic_high
	:	arithmetic_highest ( PERCENT^ )?
	;

arithmetic_highest
	:	( MINUS^ )? atom
	;

atom
	:	function_call
	|	reference
        |       TEMP_VAR
        |       GLOBAL_VAR
	|	literal
	|	LPAR! comparison RPAR!
	;

function_call
	: WHILE^ LPAR! 
		( operation ( SEMI! operation )* )?
		RPAR!
	| FUNCTION^ LPAR! 
		( comparison ( SEMI! comparison )* )?
		RPAR!	
	| FUNCTION^ LBRA! ( assignment SEMI! comparison SEMI! assignment ( SEMI! operation )* )? RBRA!		
	;

reference
	:	CELL_REF
		( ( COLON^ ) CELL_REF )?
	;

literal
	:	NUMBER
	|	STRING
	;

WHILE	: 'dowhile' | 'whiledo' | 'DoWhile' | 'WhileDo' | 'DOWHILE' | 'WHILEDO'
	;

TEMP_VAR : UNDERSCORE(LETTER | DIGIT)+;

GLOBAL_VAR : AT(LETTER | DIGIT)+;
	
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
EQ	: '=';
ASSIGN  : ':=';
NEQ	: '<>' ;
LTEQ	: '<=' ;
GTEQ	: '>=' ;
GT	: '>' ;
LT	: '<' ;
UNDERSCORE : '_';
AT : '@';

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