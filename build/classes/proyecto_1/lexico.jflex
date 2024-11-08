//----------------------Codigo de Usuario----------------------
package proyecto_1;
import java_cup.runtime.*;
import static proyecto_1.errores.listaErrores;

%%
//----------------------Opciones y Declaraciones----------------------
%class lexer
%unicode
%cup
%line
%column

%{

    StringBuffer string = new StringBuffer();

    private Symbol symbol(int type) {
      return new Symbol(type, yyline, yycolumn,yytext());
    }
    private Symbol symbol(int type, Object value) {
      return new Symbol(type, yyline, yycolumn, value);
    }

    public void imprimir(String c){
      System.out.println(c);
    }
%}

comentario_multilinea = "<!"[^"!>"]*"!>"
comentario_simple = "//"[^\r\n]*
ignorar = \r\n|\r|\n|\t|\f|\s
letra_min = [a-z]
letra_may = [A-Z]
digito = [0-9]
ascii = [\040-\057\072-\100\133-\140\173-\175]
id = [a-zA-Z][a-zA-Z0-9|"_"]*

%state STRING
%%
//----------------------Reglas Lexicas----------------------

    <YYINITIAL> {

      {ignorar}                      {}
      {comentario_multilinea}        {}
      {comentario_simple}            {}

      {letra_min}                    { return symbol(sym.LETRA_MIN);}
      {letra_may}                    { return symbol(sym.LETRA_MAY);}
      {digito}                       { return symbol(sym.DIGITO);}
      "CONJ"                         { return symbol(sym.CONJ);}
      {id}                           { return symbol(sym.ID);}
      //{string}                       {imprimir("STRING :"+yytext());
                                      //String cadena = yytext().substring(1, yytext().length()-1);
                                      //return symbol(sym.STRING,cadena);}
      \"                             { string.setLength(0); yybegin(STRING); } 
     
      "{"                            { return symbol(sym.CORCHETE_ABRE);}
      "}"                            { return symbol(sym.CORCHETE_CIERRA);}
      "."                            { return symbol(sym.CONCATENACION);}
      "|"                            { return symbol(sym.DISYUNCION);}
      "*"                            { return symbol(sym.C_KLEENE);}
      "+"                            { return symbol(sym.C_POSITIVA);}
      "?"                            { return symbol(sym.OPCIONAL);} 
      "~"                            { return symbol(sym.HASTA);}
      ","                            { return symbol(sym.COMA);}
      \\n                            { return symbol(sym.SALTO_LINEA);}
      \\\"                           { return symbol(sym.COMILLA_DOBLE);}
      \\\'                           { return symbol(sym.COMILLA_SIMPLE);}
      ":"                            { return symbol(sym.DOS_PUNTOS);}
      "-"                            { return symbol(sym.GUION);}
      ">"                            { return symbol(sym.MAYOR_QUE);}
      ";"                            { return symbol(sym.PUNTO_COMA);}
      "%%"                           { return symbol(sym.SEPARADOR);}
      {ascii}                        { return symbol(sym.ASCII);}
    
    }

    <STRING> {
      \"                             { yybegin(YYINITIAL); return symbol(sym.STRING,string.toString()); }
      [^\n\r\"\\]+                   { string.append( yytext() ); }
      \\t                            { string.append('\t'); }
      \\n                            { string.append("\\n"); }

      \\r                            { string.append('\r'); }
      \\\"                           { string.append('\"'); }
      \\\'                           { string.append('\''); }
      \\                             { string.append('\\'); }
      }

    [^]                              {listaErrores.add(new error("Error Léxico","El caracter : "+yytext(),yyline+1,yycolumn+1));}