package com.mycompany.calculadora;
import java_cup.runtime.Symbol;
%%
%public
%class Lexico
%cup
%%
"+" { return new Symbol(Simbolos.PLUS); }
"-" { return new Symbol(Simbolos.MINUS); }
"*" { return new Symbol(Simbolos.TIMES); }
"/" { return new Symbol(Simbolos.DIV); }
"(" { return new Symbol(Simbolos.LPAREN); }
")" { return new Symbol(Simbolos.RPAREN); }
[0-9]+ { return new Symbol(Simbolos.NUMBER, new Integer(yytext())); }
[ \t\r\f\n] { /* ignore white space. */ }
. { System.err.println("Illegal character: "+yytext()); }