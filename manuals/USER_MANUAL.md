# USER MANUAL

## Elementos Ventana Principal

![principal](/manuals/images/principal.png)

* ### Archivo
    Es un menu para manejar los archivos de entrada. Tiene las opciones:

    * #### Nuevo Archivo
        Abre una ventana para elegir el directorio donde se guardara el nuevo archivo, seguido se pedirá que ingrese el nombre para el nuevo archivo.

    * #### Abrir Archivo
        Abre una ventana para elegir el archivo que se desea usar como entrada.
    * #### Guardar
        Guarda los cambios del archivo que se encuentra abierto. Tiene que haber un archivo abierto para que funcione la opción guardar.
    * #### Guardar Como
        Abre una ventana para elegir el directorio donde se desea guardar el contenido que se encuentra en el área de código.
* ### Generar Autómatas
    Al presionar el botón, lo escrito en el área de código pasara por un escáner léxico (**JFLEX**) y un parser sintáctico (**CUP**) para identificar las expresiones regulares y los lexemas a evaluar, también verifica que no haya errores en la entrada. Si no hay errores se crearan los AFD que serán utilizados para analizar los lexemas.

* ### Analizar Cadenas
    Si hay AFDs creados, se analizaran los lexemas que se definieron en la entrada. Si no hay AFDs, se advertirá que es necesario crearlos.

* ### Limpiar Consolar
    Limpia toda el área de consola.

## Reportes

![Reportes](/manuals/images/reportes.png)

* ### Lista Desplegable
    En esta lista se puede seleccionar que tipo de reporte desea ver. La lista muestra: **Árbol, Tabla de Siguiente, Tabla de Transiciones, AFD y AFND**.
* ### Botones Atrás y Siguiente
    Permite navegar entre los diferentes reportes que hay en el tipo de reporte seleccionado. 