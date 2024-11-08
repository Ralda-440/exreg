# Exreg Intérprete de Expresiones Regulares

Intérprete de Expresiones Regulares con Java utilizando [JFLEX](https://cgi.cse.unsw.edu.au/~kleing/jflex/download.html) y [CUP](https://www2.cs.tum.edu/projects/cup/)

Permite analizar lexemas utilizando una expresión regular como patrón.

Recibe como entrada lexemas (secuencias de caracteres)  y expresiones regulares (patrones) en notación prefija para evaluar si los lexemas corresponden a las expresiones regulares. 

Para identificar las expresiones regulares y los lexemas definidos en la entrada, se utiliza JFLEX y CUP.

Para cada expresión regular se realiza el método del Árbol y se crea un Autómata Finito Determinista (AFD), y el método de Thompson para crear un Autómata Finito No Determinista (AFND). El análisis de los lexemas se hace a través del AFD creado a partir de la expresión regular.

La sintaxis que se utiliza en la entrada para definir las expresiones regulares y los lexemas a evaluar es la siguiente:

```c
{
    //Conjuntos
    CONJ: nombre_del_conjunto -> notacion_del_conjunto;
 
    //Expresiones Regulares
    nombre_expresion -> notacion_expresion_regular_en_prefijo;

    //Separador Obligatorio
    %%
    %%

    //Lexemas a evaluar
    nombre_de_la_expresion_a_utilizar : "Lexema";
}
```

## Notación para Conjuntos

|Notación|Definición|
|-|-|
|**a~c**|Conjunto de la letra **a** hasta la letra **c** en minúsculas|
|**a~z**|Conjunto de la letra **a** hasta la letra **z** en minúsculas|
|**A~Z**|Conjunto de la letra **A** hasta la letra **Z** en mayúsculas|
|**0~9**|Conjunto del **0** al **9**|
|**0,2,6,9**|Conjunto de dígitos **{0,2,6,9}**|
|**0,8,A,z,Y**|Conjunto de dígitos y caracteres **{0,a,A,z,Y}**
|**!~&**|Conjuntos de signos desde **!** (33 en ASCII) hasta **&** (38 en ASCII) **Nota: el rango debe estar dentro de 32 ASCII hasta el 125 ASCII. En estos rangos se omite las letras y los dígitos**| 

#### Nota: Estos conjuntos son ejemplos de las diferentes variantes que éstos pueden tomar.

## Caracteres Especiales

|Notación|Definición|
|-|-|
|**\n**|Salto de Lineá|
|**\'**|Comilla Simple|
|**\"**|Comilla Doble|

## Notación para las Expresiones regulares

|Notación|Definición|
|-|-|
|**.ab**|Concatenación entre **a** y **b**|
|**\|ab**|Disyunción entre **a** y **b**|
|**\*a**|0 o más veces|
|**+a**|1 o más veces|
|**?a**|0 o una vez|

#### Nota: a y b pueden ser caracteres, conjuntos definidos con anterioridad o caracteres especiales.

## Ejemplo de Entrada

```c
{
    //Conjuntos 
    CONJ: letra -> a~z; // declarando conjunto de letras desde a hasta z en minusculas
    CONJ: digito -> 0~3; // declarango conjunto de digitos solo para 0, 1, 2 y 3



    //Expresiones regulares
    identificador -> . {letra} * | "_" | {letra} {digito};
    decimales -> . +{digito} . "." + {digito};

    //Separador Obligatorio
    %%
    %%

    identificador :  "hola_soy_id_1";   //correcto
    identificador :  "HoLA";            //incorrecto
    decimales : "301.59";               //incorrecto
    decimales: "1200.31";               //correcto

}
```

## Build and Run

Para crear el ejecutable **.jar** e instalar las dependencias para la ejecución, vea [Build and Run](BUILD_AND_RUN.md)

## Manual
* Para aprender como utilizar la aplicación y ver los Reportes, vea [User Manual](/manuals/USER_MANUAL.md)