# BUILD AND RUN

### Dependencias
* JDK-8u11 o superior.
* Se necesitan los archivos **.jar** de **JFELX** y **CUP**. También el archivo **.jar** de la librería **JSON** para crear los Reportes. Estos ya se encuentran en el repositorio pero los puede descargar por su cuenta.

* Necesita instalar **graphviz**, se utilizan para crear imágenes de los diferentes reportes que ofrece la aplicación. Lo puede Descargar desde aquí: [Graphviz](https://graphviz.org/download/).


### Build

1. Clone el repositorio.
    ```bash
    git clone https://github.com/Ralda-440/exreg
    ```
2. Abra el proyecto. Puede utilizar NetBeans o el de su preferencia. Para este proyecto se utilizo NetBeans.

3. Haga clic derecho sobre el proyecto agregado, y clic en la opción **Clean and Build**.

4. Se creara una carpeta **/dist** en la raíz del proyecto. En esta se encontrara el ejecutable de la aplicación.

### Run

1. Acceda a **/dist** y desde la terminal ejecute:
    ```bash
    java -jar "proyecto_1.jar"
    ```