/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto_1;

import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import static proyecto_1.errores.listaErrores;
/**
 * 
 * @author sergi
 */
public class exregan extends javax.swing.JFrame {

    /**
     * Creates new form exregan
     */
    //File file;
    String ruta = "";
    File[] listaArchivos; 
    int imagenActual;
    public exregan() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaCodigo = new javax.swing.JTextArea();
        generarAutomatas = new javax.swing.JButton();
        analizarCadenas = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        comboBoxImagenes = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        areaConsola = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        nuevoArchivo = new javax.swing.JMenuItem();
        abrirArchivo = new javax.swing.JMenuItem();
        guardar = new javax.swing.JMenuItem();
        guardarComo = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ExRegan USAC");
        setResizable(false);

        jTabbedPane1.setAutoscrolls(true);

        areaCodigo.setColumns(20);
        areaCodigo.setFont(new java.awt.Font("Sitka Display", 0, 18)); // NOI18N
        areaCodigo.setRows(5);
        areaCodigo.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jScrollPane1.setViewportView(areaCodigo);

        generarAutomatas.setText("Generar Automatas");
        generarAutomatas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generarAutomatasActionPerformed(evt);
            }
        });

        analizarCadenas.setText("Analizar Cadenas");
        analizarCadenas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                analizarCadenasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(generarAutomatas, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(analizarCadenas, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 642, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(generarAutomatas, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(analizarCadenas, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Archivo1 ", jPanel1);

        comboBoxImagenes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Arboles", "Siguientes", "Transiciones", "AFD", "AFND" }));
        comboBoxImagenes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxImagenesActionPerformed(evt);
            }
        });

        jButton2.setText("Atras");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Siguiente");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jScrollPane3.setAutoscrolls(true);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1044, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        jScrollPane3.setViewportView(jPanel3);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(597, 597, 597)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                        .addComponent(comboBoxImagenes, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(comboBoxImagenes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
                .addGap(24, 24, 24))
        );

        jTabbedPane1.addTab("Reportes", jPanel2);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Consola");

        areaConsola.setEditable(false);
        areaConsola.setColumns(20);
        areaConsola.setFont(new java.awt.Font("Sitka Display", 0, 22)); // NOI18N
        areaConsola.setRows(5);
        areaConsola.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15));
        jScrollPane2.setViewportView(areaConsola);

        jButton1.setText("Limpiar Consola");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jMenu1.setLabel("Archivo");

        nuevoArchivo.setText("Nuevo Archivo");
        nuevoArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoArchivoActionPerformed(evt);
            }
        });
        jMenu1.add(nuevoArchivo);

        abrirArchivo.setText("Abrir Archivo");
        abrirArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirArchivoActionPerformed(evt);
            }
        });
        jMenu1.add(abrirArchivo);

        guardar.setText("Guardar");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });
        jMenu1.add(guardar);

        guardarComo.setText("Guardar Como");
        guardarComo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarComoActionPerformed(evt);
            }
        });
        jMenu1.add(guardarComo);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(451, 451, 451)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 621, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(2, 2, 2)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void analizarCadenasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_analizarCadenasActionPerformed
        // TODO add your handling code here:
        if (arboles.listArboles.isEmpty()) {
            JOptionPane.showMessageDialog(this,"NO EXISTEN AUTOMATAS GENERADOS","ERROR", HEIGHT);
            return;
        }
        validarLexemas.validar(areaConsola);
        areaConsola.append("CADENAS ANALIZADAS CON EXITO!!!!!!"+"\n");
    }//GEN-LAST:event_analizarCadenasActionPerformed

    private void abrirArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirArchivoActionPerformed
        // TODO add your handling code here:
        JFileChooser selector = new JFileChooser(new File("./"));
        selector.setFileFilter(new FileNameExtensionFilter("Archivo OLC (*.olc)","olc"));
        int resultado = selector.showOpenDialog(this);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            validarLexemas.nombreArchivo = selector.getSelectedFile().getName();
            if (validarLexemas.nombreArchivo.endsWith(".olc")) {
                validarLexemas.nombreArchivo = validarLexemas.nombreArchivo.substring(0, validarLexemas.nombreArchivo.length()-4);
            }
            ruta = selector.getSelectedFile().getPath();
            try {
                File file = new File(ruta);
                Scanner scanner = new Scanner(file);
                areaCodigo.setText("");
                while (scanner.hasNextLine()) {
                    areaCodigo.append(scanner.nextLine()+"\n");
                }
            } catch (FileNotFoundException ex) {
            }
        }
    }//GEN-LAST:event_abrirArchivoActionPerformed

    private void generarAutomatasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generarAutomatasActionPerformed
        // TODO add your handling code here:
        if (ruta.equals("")) {
            JOptionPane.showMessageDialog(this,"No hay archivo para analizar","ERROR", HEIGHT);
            return;
        }
        listaErrores.clear();
        exprRegulares.conjuntos.clear();
        exprRegulares.listExprRegulares.clear(); 
        lexemas.listLexemas.clear();
        arboles.listArboles.clear();
        try {
            lexer escaner = new lexer(new FileReader(ruta));
            parser sintactico = new parser(escaner);
            sintactico.parse();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(this, "ERROR AL GENERAR LEXER Y PARSER");
        }
        if (!listaErrores.isEmpty()) {
            errores.reporteHtmlErrores();
            JOptionPane.showMessageDialog(this,"Hay errores en el archivo de entrada","ERROR", HEIGHT);
            return;
        }
        arboles.crearArboles(exprRegulares.listExprRegulares);
        //MOSTRAR IMAGENES
        //
        comboBoxImagenes.actionPerformed(evt);
        areaConsola.append("AUTOMATAS GENERADOS CON EXITO!!!!!"+"\n");
    }//GEN-LAST:event_generarAutomatasActionPerformed

    private void nuevoArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoArchivoActionPerformed
        // TODO add your handling code here:
        JFileChooser selector = new JFileChooser(new File("./"));
        selector.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int resultado = selector.showOpenDialog(this);
        if (resultado ==  JFileChooser.APPROVE_OPTION) {
            File directorio = selector.getSelectedFile();
            String rutaDirectorio = directorio.getAbsolutePath();
            String nombreArchivo = JOptionPane.showInputDialog(this, "Ingrese Nombre para el nuevo archivo");
            if (nombreArchivo.equals("")) {
                JOptionPane.showMessageDialog(this, "NOMBRE DE ARCHIVO NO VALIDO");
                return;
            }
            File fileNuevo = new File(rutaDirectorio+"/"+nombreArchivo+".olc");
            try {
                PrintWriter pw = new PrintWriter(fileNuevo);
                pw.println("");
                pw.close();
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(this, "ERROR AL CREAR EL NUEVO ARCHIVO", "ERROR", ERROR);
                return;
            }
            ruta = rutaDirectorio+"/"+nombreArchivo+".olc";
            validarLexemas.nombreArchivo = nombreArchivo;
            areaCodigo.setText("");
            JOptionPane.showMessageDialog(this, "Archivo Creado");
        }
    }//GEN-LAST:event_nuevoArchivoActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        // TODO add your handling code here:
        if (ruta.equals("")) {
            JOptionPane.showMessageDialog(this, "Utilice la opcion \"Guardar Como\"");
            return;
        }
        File file = new File(ruta);
        try {
            PrintWriter pw = new PrintWriter(file);
            pw.println(areaCodigo.getText());
            pw.close();
        } catch (FileNotFoundException e) {
            System.out.println("ERROR AL GUARDAR EL ARCHIVO: "+e.getMessage());
        }
    }//GEN-LAST:event_guardarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        areaConsola.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void guardarComoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarComoActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser(new File("./"));
        fileChooser.setDialogTitle("Guardar Como");
        int userSelection = fileChooser.showSaveDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            String filePath = fileToSave.getAbsolutePath();
            File fileNuevo = new File(filePath+".olc");
            try {
                PrintWriter pw = new PrintWriter(fileNuevo);
                pw.println(areaCodigo.getText());
                pw.close();
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(this, "ERROR AL CREAR EL NUEVO ARCHIVO", "ERROR", ERROR);
                return;
            }
            ruta = filePath+".olc"; 
            JOptionPane.showMessageDialog(this, "ARCHIVO GUARDADO CON EXITO!!");
        }
    }//GEN-LAST:event_guardarComoActionPerformed

    private void cargarImagen(int i) {
        if (listaArchivos == null) {
            return;
        }
        if (listaArchivos[i].isFile()) {
            try {
                ImageIcon imageIcon = new ImageIcon(ImageIO.read(listaArchivos[i]));
                //Image imagenEscalada = imageIcon.getImage().getScaledInstance(jLabel2.getWidth(), jLabel2.getHeight(), Image.SCALE_SMOOTH);
                //jLabel2.setIcon(new ImageIcon(imagenEscalada));
                jLabel2.setIcon(imageIcon);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    private void comboBoxImagenesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxImagenesActionPerformed
        // TODO add your handling code here:
        if (arboles.listArboles.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Genere los automatas", "Información", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        File folder;
        imagenActual = 0;
        switch (comboBoxImagenes.getSelectedIndex()) {
            case 0://arboles
                folder = new File("./ARBOLES_202103216");
                listaArchivos = folder.listFiles();
                cargarImagen(0);
                break;
            case 1://siguientes
                folder = new File("./SIGUIENTES_202103216");
                listaArchivos = folder.listFiles();
                cargarImagen(0);
                break;
            case 2://transiones
                folder = new File("./TRANSICIONES_202103216");
                listaArchivos = folder.listFiles();
                cargarImagen(0);
                break;
            case 3://automatas
                folder = new File("./AFD_202103216");
                listaArchivos = folder.listFiles();
                cargarImagen(0);
                break;
            case 4://automatas
                folder = new File("./AFND_202103216");
                listaArchivos = folder.listFiles();
                cargarImagen(0);
                break;
            default:
                listaArchivos = null;
        }
    }//GEN-LAST:event_comboBoxImagenesActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (listaArchivos == null) {
            return;
        }
        if (0 <= imagenActual - 1) {
            imagenActual--;
        } else {
            imagenActual = listaArchivos.length - 1;
        }
        cargarImagen(imagenActual);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if (listaArchivos == null) {
            return;
        }
        if (listaArchivos.length > imagenActual + 1) {
            imagenActual++;
        } else {
            imagenActual = 0;
        }
        cargarImagen(imagenActual);
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    
    
    //public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        //try {
        /*    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(exregan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(exregan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(exregan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            //java.util.logging.Logger.getLogger(exregan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        //java.awt.EventQueue.invokeLater(new Runnable() {
            //public void run() {
                //new exregan().setVisible(true);
            //}
        //});
    //}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem abrirArchivo;
    private javax.swing.JButton analizarCadenas;
    private javax.swing.JTextArea areaCodigo;
    private javax.swing.JTextArea areaConsola;
    private javax.swing.JComboBox<String> comboBoxImagenes;
    private javax.swing.JButton generarAutomatas;
    private javax.swing.JMenuItem guardar;
    private javax.swing.JMenuItem guardarComo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JMenuItem nuevoArchivo;
    // End of variables declaration//GEN-END:variables
}