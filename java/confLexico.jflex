package Compilador;
import java_cup.runtime.Symbol;
import java.io.*;
import java.util.*;

%%
%{
  public static Stack<String> pilaErrores = new Stack<>();

       public Stack<String> getError(){
          return pilaErrores;
       }
%}
%class AnalizadorLexico
%public
%char
%line
%column
%cup
numero = [0-9]+
%%
/*------------  3ra Area: Reglas Lexicas ---------*/
"coloca"              { return new Symbol(sym.COLOCA, yyline, yycolumn, yytext());}
"fin repetir"         { return new Symbol(sym.FINREPETIR, yyline, yycolumn, yytext());}
"repetir"             { return new Symbol(sym.REPETIR, yyline, yycolumn, yytext());}
"mover"               { return new Symbol(sym.MOVER, yyline, yycolumn, yytext());}
"arriba"              { return new Symbol(sym.ARRIBA, yyline, yycolumn, yytext());}
"abajo"               { return new Symbol(sym.ABAJO, yyline, yycolumn, yytext());}
"izquierda"           { return new Symbol(sym.IZQUIERDA, yyline, yycolumn, yytext());}
"derecha"             { return new Symbol(sym.DERECHA, yyline, yycolumn, yytext());}
{numero}              { return new Symbol(sym.NUMERO, yyline, yycolumn, yytext());}

[ \t\r\n\f]           {/* Espacios en blanco, se ignoran */}
[\s]+                 { /* Ignorar espacios en blanco */ }
.                     { String datos = yytext()+" "+yyline+" "+yycolumn+" Error Lexico "+"Simbolo no existe en el lenguaje";
                        pilaErrores.add(datos); }