/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;


import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import jxl.Sheet;
import jxl.Workbook;
import jxl.common.Logger;
import jxl.read.biff.BiffException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import Principal.*;
import static Principal.Ventana_HechosBP.modelo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashSet;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;


/**
 *
 * @author JL
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Importacion
     */
    DefaultTableModel modelo2=null;
    int band=0;
    public static Statement estSQL=null;
    DefaultTableModel modelo=null;
    Object fila [];
    static int valor=0;
    int aux=0;
    boolean sw=false;
    public Principal() {
        initComponents();
        insertImage();
        lblLoad.setVisible(false);
        btnImp.setEnabled(false);    
        conexionBD();
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Img/icono.png"));
        setIconImage(icon);
        cmbTabla.removeAllItems();
        cmbValorHechos.removeAllItems();
        this.setLocationRelativeTo(null);
        this.setTitle("Gestión de Datos");
        this.setResizable(false);
        String cabecera[]={};
        String datos[][]={};
        modelo=new DefaultTableModel(datos,cabecera);
        Tabla1.setModel(modelo); 
        limpiarTabla(tablaDim);
        limpiarTabla(Tabla1);
        cmbValorHechos.setEnabled(false);
        btnCodigos.setEnabled(false);
        btnValores.setEnabled(false);
        btnCargaAll.setEnabled(false);
        if(!SplashSc.cerrar2())
        {
            cerrar();
        }

    }
     public void conexionBD()
    {
        Procesos sql=new Procesos();
        estSQL=sql.conexion("sa","sa.1","Proyecto_ETL","JOEL-PC\\SQLSERVER2");
    }
    public void cerrar()
    {
        try
        {
            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter ()
            {
                public void windowClosing(WindowEvent e)
                {
                    dispose();
                }
            });        
        this.setVisible(true);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void insertImage()
    {
        ImagePanel Imagen = new ImagePanel();
        panel.add(Imagen);
        panel.repaint();
    }
   
    public class ImagePanel extends JPanel 
    {
        public ImagePanel()
        {
            //Se crea un método cuyo parámetro debe ser un objeto Graphics
            this.setSize(985,615);
        }
        @Override
        public void paint(Graphics grafico)
        {
            Dimension height = getSize();
            //Se selecciona la imagen que tenemos en el paquete de la //ruta del programa
            ImageIcon Img = new ImageIcon(getClass().getResource("/Img/LINEAS.jpg")); 
            //se dibuja la imagen que tenemos en el paquete Images //dentro de un panel
            grafico.drawImage(Img.getImage(), 0, 0, height.width, height.height, null);
            setOpaque(false);
            super.paintComponent(grafico);
        }
    }
     public void limpiarTabla(JTable tabla)
    {
        while(tabla.getRowCount()>0)
        {
            ((DefaultTableModel) tabla.getModel()).removeRow(0);
        }
        TableColumnModel modCol = tabla.getColumnModel();
        while(modCol.getColumnCount()>0)modCol.removeColumn(modCol.getColumn(0));
        String cabecera[]={};
        String datos[][]={};
        
        modelo=new DefaultTableModel(datos,cabecera);
        Tabla1.setModel(modelo); 
    }
    public void limpiarTabla2(JTable tabla)
    {
        while(tabla.getRowCount()>0)
        {
            ((DefaultTableModel) tabla.getModel()).removeRow(0);
        }
        TableColumnModel modCol = tabla.getColumnModel();
        while(modCol.getColumnCount()>0)modCol.removeColumn(modCol.getColumn(0));
        String cabecera[]={};
        String datos[][]={};
        
        modelo2=new DefaultTableModel(datos,cabecera);
        tablaDim.setModel(modelo2); 
    }
    public void limpiarTabla1(JTable tabla)
    {
        while(tabla.getRowCount()>0)
        {
            ((DefaultTableModel) tabla.getModel()).removeRow(0);
        }
        TableColumnModel modCol = tabla.getColumnModel();
        while(modCol.getColumnCount()>0)modCol.removeColumn(modCol.getColumn(0));
        
      
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla1 = new javax.swing.JTable();
        btnImp = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        cmbTabla = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaDim = new javax.swing.JTable();
        checkNull = new javax.swing.JCheckBox();
        checkMayus = new javax.swing.JCheckBox();
        checkUnique = new javax.swing.JCheckBox();
        jButton3 = new javax.swing.JButton();
        txtNull = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmbValorHechos = new javax.swing.JComboBox();
        btnCodigos = new javax.swing.JButton();
        btnValores = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        radioDimensiones = new javax.swing.JRadioButton();
        radioTablaHechos = new javax.swing.JRadioButton();
        btnCargaAll = new javax.swing.JButton();
        lblLoad = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel.setPreferredSize(new java.awt.Dimension(975, 557));

        jLabel1.setFont(new java.awt.Font("Calibri Light", 0, 28)); // NOI18N
        jLabel1.setText("Gestión de Datos");

        jLabel2.setFont(new java.awt.Font("Calibri Light", 1, 10)); // NOI18N
        jLabel2.setText("Seleccionar Archivo a Importar: ");

        Tabla1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(Tabla1);

        btnImp.setBackground(new java.awt.Color(255, 255, 255));
        btnImp.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        btnImp.setText("Importar");
        btnImp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImpActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jButton2.setText("Guardar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        cmbTabla.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbTabla.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbTablaItemStateChanged(evt);
            }
        });
        cmbTabla.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cmbTablaFocusGained(evt);
            }
        });
        cmbTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTablaActionPerformed(evt);
            }
        });

        tablaDim.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaDim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaDimMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaDim);

        checkNull.setFont(new java.awt.Font("Calibri Light", 0, 13)); // NOI18N
        checkNull.setText("Validar Nulos");
        checkNull.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                checkNullFocusLost(evt);
            }
        });

        checkMayus.setFont(new java.awt.Font("Calibri Light", 0, 13)); // NOI18N
        checkMayus.setText("Mayúsculas");
        checkMayus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkMayusActionPerformed(evt);
            }
        });

        checkUnique.setFont(new java.awt.Font("Calibri Light", 0, 13)); // NOI18N
        checkUnique.setText("Valores Únicos");
        checkUnique.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkUniqueActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jButton3.setText("Vista Previa");
        jButton3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jButton3FocusGained(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        txtNull.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNullFocusLost(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Calibri Light", 1, 10)); // NOI18N
        jLabel3.setText("Valor a Reemplazar:");

        jLabel4.setFont(new java.awt.Font("Calibri Light", 1, 10)); // NOI18N
        jLabel4.setText("Seleccionar Dimension: ");

        jLabel5.setFont(new java.awt.Font("Calibri Light", 1, 10)); // NOI18N
        jLabel5.setText("Seleccionar Valor para Tabla de Hechos: ");

        cmbValorHechos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbValorHechos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbValorHechosItemStateChanged(evt);
            }
        });
        cmbValorHechos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cmbValorHechosFocusGained(evt);
            }
        });

        btnCodigos.setBackground(new java.awt.Color(255, 255, 255));
        btnCodigos.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        btnCodigos.setText("Generar Códigos");
        btnCodigos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCodigosActionPerformed(evt);
            }
        });

        btnValores.setBackground(new java.awt.Color(255, 255, 255));
        btnValores.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        btnValores.setText("Generar Valores Cuantificables");
        btnValores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnValoresActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(255, 255, 255));
        jButton7.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jButton7.setText("Mostrar Datos en Ventana Completa");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Calibri Light", 1, 10)); // NOI18N
        jLabel6.setText("Parámetros para Almacenar:");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/excel-xls-icon.png"))); // NOI18N

        buttonGroup2.add(radioDimensiones);
        radioDimensiones.setFont(new java.awt.Font("Calibri Light", 0, 13)); // NOI18N
        radioDimensiones.setText("Cargar Dimensiones");
        radioDimensiones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioDimensionesActionPerformed(evt);
            }
        });

        buttonGroup2.add(radioTablaHechos);
        radioTablaHechos.setFont(new java.awt.Font("Calibri Light", 0, 13)); // NOI18N
        radioTablaHechos.setText("Cargar Tabla de Hechos");
        radioTablaHechos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioTablaHechosActionPerformed(evt);
            }
        });

        btnCargaAll.setBackground(new java.awt.Color(255, 255, 255));
        btnCargaAll.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        btnCargaAll.setText("Cargar Todo");
        btnCargaAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargaAllActionPerformed(evt);
            }
        });

        lblLoad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Loading_1.gif"))); // NOI18N

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator3))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 649, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(cmbValorHechos, javax.swing.GroupLayout.Alignment.LEADING, 0, 240, Short.MAX_VALUE)
                                            .addComponent(cmbTabla, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(34, 34, 34)
                                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnCodigos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(32, 32, 32)
                                        .addComponent(btnValores))
                                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 14, Short.MAX_VALUE))))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jSeparator2))
                    .addComponent(jSeparator1)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(radioDimensiones)
                                .addGap(18, 18, 18)
                                .addComponent(radioTablaHechos)
                                .addGap(18, 18, 18)
                                .addComponent(btnImp, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(btnCargaAll, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(lblLoad)))
                        .addGap(0, 8, Short.MAX_VALUE)))
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(checkUnique)
                                .addComponent(checkNull)
                                .addComponent(checkMayus)
                                .addComponent(jLabel6)
                                .addGroup(panelLayout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(43, 43, 43)
                                    .addComponent(txtNull, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(13, 13, 13))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addGap(6, 6, 6)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblLoad)
                            .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(radioDimensiones)
                                .addComponent(radioTablaHechos)
                                .addComponent(btnImp)
                                .addComponent(btnCargaAll)))
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2))
                        .addGap(23, 23, 23)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(9, 9, 9)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cmbValorHechos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnCodigos)
                                    .addComponent(btnValores)))
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(checkUnique)
                        .addGap(17, 17, 17)
                        .addComponent(checkMayus)
                        .addGap(14, 14, 14)
                        .addComponent(checkNull)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNull, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))))
                .addGap(20, 20, 20)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jButton7)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 970, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnImpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImpActionPerformed

        btnCargaAll.setEnabled(true);
        lblLoad.setVisible(true);
        limpiarTabla(tablaDim);
        cmbTabla.removeAllItems();
        cmbValorHechos.removeAllItems();
        
        if(radioDimensiones.isSelected())
        {
            importar();
            
        }else
        {
            sw=false;
            importarTodo();
            String cabecera1[]={};
            String datos1[][]={};
            modelo2=new DefaultTableModel(datos1,cabecera1);
            tablaDim.setModel(modelo2);
        }
        lblLoad.setVisible(false);
        sw=true;
        fila= new Object [modelo.getRowCount()];
    }//GEN-LAST:event_btnImpActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        if(cmbTabla.getSelectedItem().equals("tip_insc"))
        {
            validUniq("nombre_tipoinsc","tipo_insc");
            guardarDatos("tipo_insc");
            JOptionPane.showMessageDialog(null, "Datos Guardados en la tabla: "+cmbTabla.getSelectedItem().toString().trim());
        }else
        if(cmbTabla.getSelectedItem().equals("prov_insc"))
        {
            validUniq("nombre_provinsc","prov_insc");
            guardarDatos("prov_insc");
            JOptionPane.showMessageDialog(null, "Datos Guardados en la tabla: "+cmbTabla.getSelectedItem().toString().trim());
        }
        else
        if(cmbTabla.getSelectedItem().equals("fecha_insc"))
        {
            validUniq("nombre_fechainsc","fecha_insc");
            guardarDatos("fecha_insc");
            JOptionPane.showMessageDialog(null, "Datos Guardados en la tabla: "+cmbTabla.getSelectedItem().toString().trim());
        }
        else
        if(cmbTabla.getSelectedItem().equals("sexo"))
        {
             validUniq("nombre_sexo","sexo");
            guardarDatos("sexo");
            JOptionPane.showMessageDialog(null, "Datos Guardados en la tabla: "+cmbTabla.getSelectedItem().toString().trim());
        }
        else
        if(cmbTabla.getSelectedItem().equals("fecha_nac"))
        {
            validUniq("nombre_fechanac","fecha_nac");
            guardarDatos("fecha_nac");
            JOptionPane.showMessageDialog(null, "Datos Guardados en la tabla: "+cmbTabla.getSelectedItem().toString().trim());
        }
        else
        if(cmbTabla.getSelectedItem().equals("prov_nac"))
        {
             validUniq("nombre_provnac","prov_nac");
            guardarDatos("prov_nac");
            JOptionPane.showMessageDialog(null, "Datos Guardados en la tabla: "+cmbTabla.getSelectedItem().toString().trim());
        }
        else
        if(cmbTabla.getSelectedItem().equals("parr_nac"))
        {
             validUniq("nombre_parrnac","parr_nac");
            guardarDatos("parr_nac");
            JOptionPane.showMessageDialog(null, "Datos Guardados en la tabla: "+cmbTabla.getSelectedItem().toString().trim());
        }
        else
        if(cmbTabla.getSelectedItem().equals("cod_pais"))
        {
             validUniq("nombre_codpais","cod_pais");
            guardarDatos("cod_pais");
            JOptionPane.showMessageDialog(null, "Datos Guardados en la tabla: "+cmbTabla.getSelectedItem().toString().trim());
        }
        else
        if(cmbTabla.getSelectedItem().equals("etnia"))
        {
             validUniq("nombre_etnia","etnia");
            guardarDatos("etnia");
            JOptionPane.showMessageDialog(null, "Datos Guardados en la tabla: "+cmbTabla.getSelectedItem().toString().trim());
        }
        else
        if(cmbTabla.getSelectedItem().equals("est_civil"))
        {
             validUniq("nombre_estcivil","est_civil");
            guardarDatos("est_civil");
            JOptionPane.showMessageDialog(null, "Datos Guardados en la tabla: "+cmbTabla.getSelectedItem().toString().trim());
        }
        else
        if(cmbTabla.getSelectedItem().equals("sabe_leer"))
        {
             validUniq("sabe_leer","sabe_leer");
            guardarDatos("sabe_leer");
            JOptionPane.showMessageDialog(null, "Datos Guardados en la tabla: "+cmbTabla.getSelectedItem().toString().trim());
        }
        limpiarTabla2(tablaDim);
        Procesos sql=new Procesos();
        String sentenciaSQL="update registros set reg="+(valor-1);
        System.out.println(sentenciaSQL);
        sql.ingresarDatos(estSQL, sentenciaSQL);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cmbTablaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbTablaItemStateChanged
        if (evt.getSource()==cmbTabla && sw)
        {       
            if(cmbTabla.getSelectedItem().equals("tip_insc"))
            {
                caso5(0,"cod_tipoinsc",txtNull.getText().trim());
            }else
            if(cmbTabla.getSelectedItem().equals("prov_insc"))
            {
                caso5(1,"cod_provinsc",txtNull.getText().trim());
            }
            else
            if(cmbTabla.getSelectedItem().equals("cant_insc"))
            {
                caso5(2,"cod_cantinsc",txtNull.getText().trim());
            }
            else
            if(cmbTabla.getSelectedItem().equals("fecha_insc"))
            {
                caso5(3,"cod_fechainsc",txtNull.getText().trim());
            }
            else
            if(cmbTabla.getSelectedItem().equals("sexo"))
            {
                caso5(4,"cod_sexo",txtNull.getText().trim());
            }
            else
            if(cmbTabla.getSelectedItem().equals("talla"))
            {
                caso5(5,"talla",txtNull.getText().trim());
            }
            else
            if(cmbTabla.getSelectedItem().equals("peso"))
            {
                caso5(6,"cod_peso",txtNull.getText().trim());
            }
            else
            if(cmbTabla.getSelectedItem().equals("fecha_nac"))
            {
                caso5(7,"cod_fechanac",txtNull.getText().trim());
            }
            else
            if(cmbTabla.getSelectedItem().equals("prov_nac"))
            {
                caso5(8,"cod_provnac",txtNull.getText().trim());
            }
            else
            if(cmbTabla.getSelectedItem().equals("parr_nac"))
            {
                caso5(10,"cod_parrnac",txtNull.getText().trim());
            }
            else
            if(cmbTabla.getSelectedItem().equals("cod_pais"))
            {
                caso5(11,"cod_codpais",txtNull.getText().trim());
            }
            else
            if(cmbTabla.getSelectedItem().equals("edad_mad"))
            {
                caso5(12,"cod_edadmad",txtNull.getText().trim());
            }
            else
            if(cmbTabla.getSelectedItem().equals("hij_viv"))
            {
                caso5(13,"cod_hijviv",txtNull.getText().trim());
            }
            else
            if(cmbTabla.getSelectedItem().equals("etnia"))
            {
                caso5(14,"cod_etnia",txtNull.getText().trim());
            }
            else
            if(cmbTabla.getSelectedItem().equals("est_civil"))
            {
                caso5(15,"cod_estcivil",txtNull.getText().trim());
            }
            else
            if(cmbTabla.getSelectedItem().equals("sabe_leer"))
            {
                caso5(16,"cod_sabeleer",txtNull.getText().trim());
            }
        }
    }//GEN-LAST:event_cmbTablaItemStateChanged

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        lblLoad.setVisible(true);
        if(checkMayus.isSelected()==true && checkNull.isSelected()==true && checkUnique.isSelected()==true)
        {
            System.out.println("entro1");
            if(cmbTabla.getSelectedItem().equals("tip_insc"))
            {
                caso1(0,"cod_tipoinsc",txtNull.getText().trim());
            }else
            if(cmbTabla.getSelectedItem().equals("prov_insc"))
            {
                caso1(1,"cod_provinsc",txtNull.getText().trim());
            }
            else
            if(cmbTabla.getSelectedItem().equals("fecha_insc"))
            {
                caso1(3,"cod_fechainsc",txtNull.getText().trim());
            }
            else
            if(cmbTabla.getSelectedItem().equals("sexo"))
            {
                caso1(4,"cod_sexo",txtNull.getText().trim());
            }
            else
            
            if(cmbTabla.getSelectedItem().equals("fecha_nac"))
            {
                caso1(7,"cod_fechanac",txtNull.getText().trim());
            }
            else
            if(cmbTabla.getSelectedItem().equals("prov_nac"))
            {
                caso1(8,"cod_provnac",txtNull.getText().trim());
            }
            else
            if(cmbTabla.getSelectedItem().equals("parr_nac"))
            {
                caso1(10,"cod_parrnac",txtNull.getText().trim());
            }
            else
            if(cmbTabla.getSelectedItem().equals("cod_pais"))
            {
                caso1(11,"cod_codpais",txtNull.getText().trim());
            }
            else
            if(cmbTabla.getSelectedItem().equals("etnia"))
            {
                caso1(14,"cod_etnia",txtNull.getText().trim());
            }
            else
            if(cmbTabla.getSelectedItem().equals("est_civil"))
            {
                caso1(15,"cod_estcivil",txtNull.getText().trim());
            }
            else
            if(cmbTabla.getSelectedItem().equals("sabe_leer"))
            {
                caso1(16,"cod_sabeleer",txtNull.getText().trim());
            }
        }
        if(!checkMayus.isSelected() && checkNull.isSelected()==true && checkUnique.isSelected()==true)
        {
            System.out.println("entro2");
            if(cmbTabla.getSelectedItem().equals("tip_insc"))
            {
                caso2(0,"cod_tipoinsc");
            }else
            if(cmbTabla.getSelectedItem().equals("prov_insc"))
            {
                caso2(1,"cod_provinsc");
            }
            else
            if(cmbTabla.getSelectedItem().equals("cant_insc"))
            {
                caso2(2,"cod_cantinsc");
            }
            else
            if(cmbTabla.getSelectedItem().equals("fecha_insc"))
            {
                caso2(3,"cod_fechainsc");
            }
            else
            if(cmbTabla.getSelectedItem().equals("sexo"))
            {
                caso2(4,"cod_sexo");
            }
            else
            if(cmbTabla.getSelectedItem().equals("talla"))
            {
                caso2(5,"talla");
            }
            else
            if(cmbTabla.getSelectedItem().equals("peso"))
            {
                caso2(6,"cod_peso");
            }
            else
            if(cmbTabla.getSelectedItem().equals("fecha_nac"))
            {
                caso2(7,"cod_fechanac");
            }
            else
            if(cmbTabla.getSelectedItem().equals("prov_nac"))
            {
                caso2(8,"cod_provnac");
            }
            else
            if(cmbTabla.getSelectedItem().equals("parr_nac"))
            {
                caso2(10,"cod_parrnac");
            }
            else
            if(cmbTabla.getSelectedItem().equals("cod_pais"))
            {
                caso2(11,"cod_codpais");
            }
            else
            if(cmbTabla.getSelectedItem().equals("edad_mad"))
            {
                caso2(12,"cod_edadmad");
            }
            else
            if(cmbTabla.getSelectedItem().equals("hij_viv"))
            {
                caso2(13,"cod_hijviv");
            }
            else
            if(cmbTabla.getSelectedItem().equals("etnia"))
            {
                caso2(14,"cod_etnia");
            }
            else
            if(cmbTabla.getSelectedItem().equals("est_civil"))
            {
                caso2(15,"cod_estcivil");
            }
            else
            if(cmbTabla.getSelectedItem().equals("sabe_leer"))
            {
                caso2(16,"cod_sabeleer");
            }
        }
        if(checkMayus.isSelected()==true && !checkNull.isSelected() && checkUnique.isSelected()==true)
        {
            System.out.println("entro3");
            if(cmbTabla.getSelectedItem().equals("tip_insc"))
            {
                caso3(0,"cod_tipoinsc");
            }else
            if(cmbTabla.getSelectedItem().equals("prov_insc"))
            {
                caso3(1,"cod_provinsc");
            }
            else
            if(cmbTabla.getSelectedItem().equals("cant_insc"))
            {
                caso3(2,"cod_cantinsc");
            }
            else
            if(cmbTabla.getSelectedItem().equals("fecha_insc"))
            {
                caso3(3,"cod_fechainsc");
            }
            else
            if(cmbTabla.getSelectedItem().equals("sexo"))
            {
                caso3(4,"cod_sexo");
            }
            else
            if(cmbTabla.getSelectedItem().equals("talla"))
            {
                caso3(5,"talla");
            }
            else
            if(cmbTabla.getSelectedItem().equals("peso"))
            {
                caso3(6,"cod_peso");
            }
            else
            if(cmbTabla.getSelectedItem().equals("fecha_nac"))
            {
                caso3(7,"cod_fechanac");
            }
            else
            if(cmbTabla.getSelectedItem().equals("prov_nac"))
            {
                caso3(8,"cod_provnac");
            }
            else
            if(cmbTabla.getSelectedItem().equals("parr_nac"))
            {
                caso3(10,"cod_parrnac");
            }
            else
            if(cmbTabla.getSelectedItem().equals("cod_pais"))
            {
                caso3(11,"cod_codpais");
            }
            else
            if(cmbTabla.getSelectedItem().equals("edad_mad"))
            {
                caso3(12,"cod_edadmad");
            }
            else
            if(cmbTabla.getSelectedItem().equals("hij_viv"))
            {
                caso3(13,"cod_hijviv");
            }
            else
            if(cmbTabla.getSelectedItem().equals("etnia"))
            {
                caso3(14,"cod_etnia");
            }
            else
            if(cmbTabla.getSelectedItem().equals("est_civil"))
            {
                caso3(15,"cod_estcivil");
            }
            else
            if(cmbTabla.getSelectedItem().equals("sabe_leer"))
            {
                caso3(16,"cod_sabeleer");
            }
        }
        if(checkMayus.isSelected()==true && checkNull.isSelected()==true && !checkUnique.isSelected())
        {
            System.out.println("entro4");
            if(cmbTabla.getSelectedItem().equals("tip_insc"))
            {
                caso4(0,"cod_tipoinsc");
            }else
            if(cmbTabla.getSelectedItem().equals("prov_insc"))
            {
                caso4(1,"cod_provinsc");
            }
            else
            if(cmbTabla.getSelectedItem().equals("cant_insc"))
            {
                caso4(2,"cod_cantinsc");
            }
            else
            if(cmbTabla.getSelectedItem().equals("fecha_insc"))
            {
                caso4(3,"cod_fechainsc");
            }
            else
            if(cmbTabla.getSelectedItem().equals("sexo"))
            {
                caso4(4,"cod_sexo");
            }
            else
            if(cmbTabla.getSelectedItem().equals("talla"))
            {
                caso4(5,"talla");
            }
            else
            if(cmbTabla.getSelectedItem().equals("peso"))
            {
                caso4(6,"cod_peso");
            }
            else
            if(cmbTabla.getSelectedItem().equals("fecha_nac"))
            {
                caso4(7,"cod_fechanac");
            }
            else
            if(cmbTabla.getSelectedItem().equals("prov_nac"))
            {
                caso4(8,"cod_provnac");
            }
            else
            if(cmbTabla.getSelectedItem().equals("parr_nac"))
            {
                caso4(10,"cod_parrnac");
            }
            else
            if(cmbTabla.getSelectedItem().equals("cod_pais"))
            {
                caso4(11,"cod_codpais");
            }
            else
            if(cmbTabla.getSelectedItem().equals("edad_mad"))
            {
                caso4(12,"cod_edadmad");
            }
            else
            if(cmbTabla.getSelectedItem().equals("hij_viv"))
            {
                caso4(13,"cod_hijviv");
            }
            else
            if(cmbTabla.getSelectedItem().equals("etnia"))
            {
                caso4(14,"cod_etnia");
            }
            else
            if(cmbTabla.getSelectedItem().equals("est_civil"))
            {
                caso4(15,"cod_estcivil");
            }
            else
            if(cmbTabla.getSelectedItem().equals("sabe_leer"))
            {
                caso4(16,"cod_sabeleer");
            }
        }
        else
        if(!checkMayus.isSelected() && checkNull.isSelected()==true && !checkUnique.isSelected())
        {   
            System.out.println("entro5");
            if(cmbTabla.getSelectedItem().equals("tip_insc"))
            {
                caso5(0,"cod_tipoinsc",txtNull.getText().trim());
            }else
            if(cmbTabla.getSelectedItem().equals("prov_insc"))
            {
                caso5(1,"cod_provinsc",txtNull.getText().trim());
            }
            else
            if(cmbTabla.getSelectedItem().equals("cant_insc"))
            {
                caso5(2,"cod_cantinsc",txtNull.getText().trim());
            }
            else
            if(cmbTabla.getSelectedItem().equals("fecha_insc"))
            {
                caso5(3,"cod_fechainsc",txtNull.getText().trim());
            }
            else
            if(cmbTabla.getSelectedItem().equals("sexo"))
            {
                caso5(4,"cod_sexo",txtNull.getText().trim());
            }
            else
            if(cmbTabla.getSelectedItem().equals("talla"))
            {
                caso5(5,"talla",txtNull.getText().trim());
            }
            else
            if(cmbTabla.getSelectedItem().equals("peso"))
            {
                caso5(6,"cod_peso",txtNull.getText().trim());
            }
            else
            if(cmbTabla.getSelectedItem().equals("fecha_nac"))
            {
                caso5(7,"cod_fechanac",txtNull.getText().trim());
            }
            else
            if(cmbTabla.getSelectedItem().equals("prov_nac"))
            {
                caso5(8,"cod_provnac",txtNull.getText().trim());
            }
            else
            if(cmbTabla.getSelectedItem().equals("parr_nac"))
            {
                caso5(10,"cod_parrnac",txtNull.getText().trim());
            }
            else
            if(cmbTabla.getSelectedItem().equals("cod_pais"))
            {
                caso5(11,"cod_codpais",txtNull.getText().trim());
            }
            else
            if(cmbTabla.getSelectedItem().equals("edad_mad"))
            {
                caso5(12,"cod_edadmad",txtNull.getText().trim());
            }
            else
            if(cmbTabla.getSelectedItem().equals("hij_viv"))
            {
                caso5(13,"cod_hijviv",txtNull.getText().trim());
            }
            else
            if(cmbTabla.getSelectedItem().equals("etnia"))
            {
                caso5(14,"cod_etnia",txtNull.getText().trim());
            }
            else
            if(cmbTabla.getSelectedItem().equals("est_civil"))
            {
                caso5(15,"cod_estcivil",txtNull.getText().trim());
            }
            else
            if(cmbTabla.getSelectedItem().equals("sabe_leer"))
            {
                caso5(16,"cod_sabeleer",txtNull.getText().trim());
            }
        }else
        if(checkMayus.isSelected()==true && !checkNull.isSelected() && !checkUnique.isSelected())
        {
            System.out.println("entro6");
            if(cmbTabla.getSelectedItem().equals("tip_insc"))
            {
                caso6(0,"cod_tipoinsc");
            }else
            if(cmbTabla.getSelectedItem().equals("prov_insc"))
            {
                caso6(1,"cod_provinsc");
            }
            else
            if(cmbTabla.getSelectedItem().equals("cant_insc"))
            {
                caso6(2,"cod_cantinsc");
            }
            else
            if(cmbTabla.getSelectedItem().equals("fecha_insc"))
            {
                caso6(3,"cod_fechainsc");
            }
            else
            if(cmbTabla.getSelectedItem().equals("sexo"))
            {
                caso6(4,"cod_sexo");
            }
            else
            if(cmbTabla.getSelectedItem().equals("talla"))
            {
                caso6(5,"talla");
            }
            else
            if(cmbTabla.getSelectedItem().equals("peso"))
            {
                caso6(6,"cod_peso");
            }
            else
            if(cmbTabla.getSelectedItem().equals("fecha_nac"))
            {
                caso6(7,"cod_fechanac");
            }
            else
            if(cmbTabla.getSelectedItem().equals("prov_nac"))
            {
                caso6(8,"cod_provnac");
            }
            else
            if(cmbTabla.getSelectedItem().equals("parr_nac"))
            {
                caso6(10,"cod_parrnac");
            }
            else
            if(cmbTabla.getSelectedItem().equals("cod_pais"))
            {
                caso6(11,"cod_codpais");
            }
            else
            if(cmbTabla.getSelectedItem().equals("edad_mad"))
            {
                caso6(12,"cod_edadmad");
            }
            else
            if(cmbTabla.getSelectedItem().equals("hij_viv"))
            {
                caso6(13,"cod_hijviv");
            }
            else
            if(cmbTabla.getSelectedItem().equals("etnia"))
            {
                caso6(14,"cod_etnia");
            }
            else
            if(cmbTabla.getSelectedItem().equals("est_civil"))
            {
                caso6(15,"cod_estcivil");
            }
            else
            if(cmbTabla.getSelectedItem().equals("sabe_leer"))
            {
                caso6(16,"cod_sabeleer");
            } 
        }
        else
        if(!checkMayus.isSelected() && !checkNull.isSelected() && checkUnique.isSelected())
        {
            System.out.println("entro7");
            if(cmbTabla.getSelectedItem().equals("tip_insc"))
            {
                caso2(0,"cod_tipoinsc");
            }else
            if(cmbTabla.getSelectedItem().equals("prov_insc"))
            {
                caso2(1,"cod_provinsc");
            }
            else
            if(cmbTabla.getSelectedItem().equals("cant_insc"))
            {
                caso2(2,"cod_cantinsc");
            }
            else
            if(cmbTabla.getSelectedItem().equals("fecha_insc"))
            {
                caso2(3,"cod_fechainsc");
            }
            else
            if(cmbTabla.getSelectedItem().equals("sexo"))
            {
                caso2(4,"cod_sexo");
            }
            else
            if(cmbTabla.getSelectedItem().equals("talla"))
            {
                caso2(5,"talla");
            }
            else
            if(cmbTabla.getSelectedItem().equals("peso"))
            {
                caso2(6,"cod_peso");
            }
            else
            if(cmbTabla.getSelectedItem().equals("fecha_nac"))
            {
                caso2(7,"cod_fechanac");
            }
            else
            if(cmbTabla.getSelectedItem().equals("prov_nac"))
            {
                caso2(8,"cod_provnac");
            }
            else
            if(cmbTabla.getSelectedItem().equals("parr_nac"))
            {
                caso2(10,"cod_parrnac");
            }
            else
            if(cmbTabla.getSelectedItem().equals("cod_pais"))
            {
                caso2(11,"cod_codpais");
            }
            else
            if(cmbTabla.getSelectedItem().equals("edad_mad"))
            {
                caso2(12,"cod_edadmad");
            }
            else
            if(cmbTabla.getSelectedItem().equals("hij_viv"))
            {
                caso2(13,"cod_hijviv");
            }
            else
            if(cmbTabla.getSelectedItem().equals("etnia"))
            {
                caso2(14,"cod_etnia");
            }
            else
            if(cmbTabla.getSelectedItem().equals("est_civil"))
            {
                caso2(15,"cod_estcivil");
            }
            else
            if(cmbTabla.getSelectedItem().equals("sabe_leer"))
            {
                caso2(16,"cod_sabeleer");
            }
        }
        lblLoad.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void checkMayusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkMayusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkMayusActionPerformed

    private void checkUniqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkUniqueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkUniqueActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        
        Ventana_Datos obj=new Ventana_Datos();
        obj.setVisible(true);
        for (int i=0;i<modelo.getRowCount(); i++) 
        {
            Object fila [] = new Object [modelo.getColumnCount()];
            for (int j=0; j<modelo.getColumnCount(); j++)
            {
                fila[j] = modelo.getValueAt(i,j);
            }
            Ventana_Datos.modelo.addRow(fila);
        }
        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void txtNullFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNullFocusLost
        
    }//GEN-LAST:event_txtNullFocusLost

    private void checkNullFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_checkNullFocusLost
/*        if(checkNull.isSelected()&&txtNull.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null,"Ingresar una Palabra para reemplazar valores NULL.");
        }*/
    }//GEN-LAST:event_checkNullFocusLost

    private void jButton3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jButton3FocusGained
        
    }//GEN-LAST:event_jButton3FocusGained

    private void btnCodigosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCodigosActionPerformed
        Ventana_HechosBP obj=new Ventana_HechosBP();
        obj.setVisible(true);
        
        Object fila [] = new Object [modelo.getRowCount()];
        for (int j=0; j<modelo.getRowCount(); j++)
        {
            fila[j] = genCodHechos("cod_tipoinsc", "tipo_insc","nombre_tipoinsc", modelo.getValueAt(j,0).toString());
            if(Integer.parseInt(fila[j].toString())==0)
            {
                fila[j]=1;
            }
        }
        Ventana_HechosBP.modelo.addColumn("tip_insc",fila);
        
        
        for (int j=0; j<modelo.getRowCount(); j++)
        {
            fila[j] = genCodHechos("cod_provinsc", "prov_insc","nombre_provinsc", modelo.getValueAt(j,1).toString());
            if(Integer.parseInt(fila[j].toString())==0)
            {
                fila[j]=1;
            }
        }
        Ventana_HechosBP.modelo.addColumn("prov_insc",fila);
        
        
        for (int j=0; j<modelo.getRowCount(); j++)
        {
            fila[j] = genCodHechos("cod_fechainsc", "fecha_insc","nombre_fechainsc", modelo.getValueAt(j,3).toString());
            if(Integer.parseInt(fila[j].toString())==0)
            {
                fila[j]=1;
            }
        }
        Ventana_HechosBP.modelo.addColumn("fecha_insc",fila);
        
        
        for (int j=0; j<modelo.getRowCount(); j++)
        {
            fila[j] = genCodHechos("cod_sexo", "sexo","nombre_sexo", modelo.getValueAt(j,4).toString());
            if(Integer.parseInt(fila[j].toString())==0)
            {
                fila[j]=1;
            }
        }
        Ventana_HechosBP.modelo.addColumn("sexo",fila);
        
        
        for (int j=0; j<modelo.getRowCount(); j++)
        {
            fila[j] = genCodHechos("cod_fechanac", "fecha_nac","nombre_fechanac", modelo.getValueAt(j,7).toString());
            if(Integer.parseInt(fila[j].toString())==0)
            {
                fila[j]=1;
            }
        }
        Ventana_HechosBP.modelo.addColumn("fecha_nac",fila);
        
        
        for (int j=0; j<modelo.getRowCount(); j++)
        {
            fila[j] = genCodHechos("cod_sabeleer", "sabe_leer","nombre_sabeleer", modelo.getValueAt(j,16).toString());
            if(Integer.parseInt(fila[j].toString())==0)
            {
                fila[j]=1;
            }
        }
        Ventana_HechosBP.modelo.addColumn("sabe_leer",fila);
        
        for (int j=0; j<modelo.getRowCount(); j++)
        {
            fila[j] = genCodHechos("cod_estcivil", "est_civil","nombre_estcivil", modelo.getValueAt(j,15).toString());
            if(Integer.parseInt(fila[j].toString())==0)
            {
                fila[j]=1;
            }
        }
        Ventana_HechosBP.modelo.addColumn("est_civil",fila);
        
        
        for (int j=0; j<modelo.getRowCount(); j++)
        {
            fila[j] = genCodHechos("cod_etnia", "etnia","nombre_etnia", modelo.getValueAt(j,14).toString());
            if(Integer.parseInt(fila[j].toString())==0)
            {
                fila[j]=1;
            }
        }
        Ventana_HechosBP.modelo.addColumn("etnia",fila);
        
        
        for (int j=0; j<modelo.getRowCount(); j++)
        {
            fila[j] = genCodHechos("cod_codpais", "cod_pais","nombre_codpais", modelo.getValueAt(j,11).toString());
            if(Integer.parseInt(fila[j].toString())==0)
            {
                fila[j]=1;
            }
        }
        Ventana_HechosBP.modelo.addColumn("cod_pais",fila);
        
        
        for (int j=0; j<modelo.getRowCount(); j++)
        {
            fila[j] = genCodHechos("cod_parrnac", "parr_nac","nombre_parrnac", modelo.getValueAt(j,10).toString());
            if(Integer.parseInt(fila[j].toString())==0)
            {
                fila[j]=1;
            }
        }
        Ventana_HechosBP.modelo.addColumn("parr_nac",fila);
        
        
        for (int j=0; j<modelo.getRowCount(); j++)
        {
            fila[j] = genCodHechos("cod_provnac", "prov_nac","nombre_provnac", modelo.getValueAt(j,8).toString());
            if(Integer.parseInt(fila[j].toString())==0)
            {
                fila[j]=1;
            }
        }
        Ventana_HechosBP.modelo.addColumn("prov_nac",fila);
        
    }//GEN-LAST:event_btnCodigosActionPerformed

    private void radioDimensionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioDimensionesActionPerformed
        btnImp.setEnabled(true);    
       // cmbValorHechos.setEnabled(false);
        //btnCodigos.setEnabled(false);
        //btnValores.setEnabled(false);
        sw=false;
    }//GEN-LAST:event_radioDimensionesActionPerformed

    private void cmbValorHechosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbValorHechosItemStateChanged
    
        if (evt.getSource()==cmbValorHechos && sw)
        { 
            /*String cabecera1[]={};
            String datos1[][]={};
            modelo2=new DefaultTableModel(datos1,cabecera1);
            tablaDim.setModel(modelo2); */
            if(radioTablaHechos.isSelected() || radioDimensiones.isSelected())
            {
                //2,5,6,9,12,13
                //"cant_insc","talla","peso","ant_nac","edad_mad","hij_viv"
                if(cmbValorHechos.getSelectedItem().equals("cant_insc"))
                {
                    genValorCuant(2, "cant_insc");
                    tablaDim.removeColumn(tablaDim.getColumnModel().getColumn(1));
                }
                if(cmbValorHechos.getSelectedItem().equals("talla"))
                {
                    genValorCuant(5, "talla");
                    tablaDim.removeColumn(tablaDim.getColumnModel().getColumn(2));
                }
                if(cmbValorHechos.getSelectedItem().equals("peso"))
                {
                    genValorCuant(6, "peso");
                    tablaDim.removeColumn(tablaDim.getColumnModel().getColumn(3));
                }
                if(cmbValorHechos.getSelectedItem().equals("cant_nac"))
                {
                    genValorCuant(9, "cant_nac");
                    tablaDim.removeColumn(tablaDim.getColumnModel().getColumn(4));
                }
                if(cmbValorHechos.getSelectedItem().equals("edad_mad"))
                {
                    genValorCuant(12, "edad_mad");
                    tablaDim.removeColumn(tablaDim.getColumnModel().getColumn(5));
                }
                if(cmbValorHechos.getSelectedItem().equals("hij_viv"))
                {
                    genValorCuant(13, "hij_viv");
                    tablaDim.removeColumn(tablaDim.getColumnModel().getColumn(6));
                }
            }
        }
        
        
    }//GEN-LAST:event_cmbValorHechosItemStateChanged

    private void cmbValorHechosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbValorHechosFocusGained
        band=1;
        sw=true;
        limpiarTabla2(tablaDim);
    }//GEN-LAST:event_cmbValorHechosFocusGained

    private void tablaDimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaDimMouseClicked

    }//GEN-LAST:event_tablaDimMouseClicked

    private void btnValoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnValoresActionPerformed

        //"cant_insc","talla","peso","ant_nac","edad_mad","hij_viv"
        Object fila [] = new Object [modelo2.getRowCount()];
        for (int j=0; j<modelo2.getRowCount(); j++)
        {
            fila[j] = modelo2.getValueAt(j,5).toString();
        }
        Ventana_HechosBP.modelo.addColumn("hij_viv",fila);
        
        for (int j=0; j<modelo2.getRowCount(); j++)
        {
            fila[j] = modelo2.getValueAt(j,4).toString();
        }
        Ventana_HechosBP.modelo.addColumn("edad_mad",fila);
        
        
        for (int j=0; j<modelo2.getRowCount(); j++)
        {
            fila[j] = modelo2.getValueAt(j,0).toString();
        }
        Ventana_HechosBP.modelo.addColumn("cant_insc",fila);
        
           
        for (int j=0; j<modelo2.getRowCount(); j++)
        {
            fila[j] = modelo2.getValueAt(j,3).toString();
        }
        Ventana_HechosBP.modelo.addColumn("cant_nac",fila);
        
        for (int j=0; j<modelo2.getRowCount(); j++)
        {
            fila[j] = modelo2.getValueAt(j,1).toString();
        }
        Ventana_HechosBP.modelo.addColumn("talla",fila);
        
        for (int j=0; j<modelo2.getRowCount(); j++)
        {
            fila[j] = modelo2.getValueAt(j,2).toString();
        }
        Ventana_HechosBP.modelo.addColumn("peso",fila);
     
        
        
        
        
    }//GEN-LAST:event_btnValoresActionPerformed

    private void cmbTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTablaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTablaActionPerformed

    private void radioTablaHechosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioTablaHechosActionPerformed
        btnImp.setEnabled(true);
        cmbValorHechos.setEnabled(true);
        btnCodigos.setEnabled(true);
        btnValores.setEnabled(true);
        sw=false;
    }//GEN-LAST:event_radioTablaHechosActionPerformed

    private void btnCargaAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargaAllActionPerformed

        JOptionPane.showMessageDialog(null,"Empezando la carga...\nEste Proceso puede tardar varios minutos.");
        lblLoad.setVisible(true);
        caso1(0,"cod_tipoinsc","NO DEFINIDO");
        validUniq("nombre_tipoinsc","tipo_insc");
        guardarDatos("tipo_insc");

        lblLoad.setVisible(true);
        caso1(1,"cod_provinsc","NO DEFINIDO");
        validUniq("nombre_provinsc","prov_insc");
        guardarDatos("prov_insc");

        lblLoad.setVisible(true);    
        caso5(3,"cod_fechainsc","01/01/2000");
        validUniq("nombre_fechainsc","fecha_insc");
        guardarDatos("fecha_insc");
        
        
        lblLoad.setVisible(true);
        caso1(4,"cod_sexo","NO DEFINIDO");
        validUniq("nombre_sexo","sexo");
        guardarDatos("sexo");
        

        
        caso5(7,"cod_fechanac","01/01/2000");
        validUniq("nombre_fechanac","fecha_nac");
        guardarDatos("fecha_nac");
        


        caso1(8,"cod_provnac","NO DEFINIDO");
        validUniq("nombre_provnac","prov_nac");
        guardarDatos("prov_nac");
        

        lblLoad.setVisible(true);
        caso1(10,"cod_parrnac","NO DEFINIDO");
        validUniq("nombre_parrnac","parr_nac");
        guardarDatos("parr_nac");
        


        caso1(11,"cod_codpais","NO DEFINIDO");
        validUniq("nombre_codpais","cod_pais");
        guardarDatos("cod_pais");
        


        caso1(14,"cod_etnia","NO DEFINIDO");
        validUniq("nombre_etnia","etnia");
        guardarDatos("etnia");
        
        
        
        caso1(15,"cod_estcivil","NO DEFINIDO");
        validUniq("nombre_estcivil","est_civil");
        guardarDatos("est_civil");
        


        caso1(16,"cod_sabeleer","NO DEFINIDO");
        validUniq("nombre_sabeleer","sabe_leer");
        guardarDatos("sabe_leer");
        lblLoad.setVisible(true);
        limpiarTabla2(tablaDim);
        JOptionPane.showMessageDialog(null, "Todas las dimensiones han sido guardadas exitosamente.");
        
        
        //--------------------------------------------------------
        lblLoad.setVisible(true);
        codigosHechos();
        genValorCuant(13, "hij_viv");
        genValorCuant(12, "edad_mad");
        genValorCuant(2, "cant_insc");
        genValorCuant(9, "cant_nac");
        genValorCuant(5, "talla");
        genValorCuant(6, "peso");
        
        
        Procesos sql=new Procesos();
        for(int i=0;i<modelo2.getRowCount();i++)
        { 
            String sentenciaSQL="insert into hechos_bp "
            + "VALUES ("+modelo2.getValueAt(i,0).toString().trim()+""
                    + ","+modelo2.getValueAt(i,1).toString().trim()+""
                    + ","+modelo2.getValueAt(i,2).toString().trim()+""
                    + ","+modelo2.getValueAt(i,3).toString().trim()+""
                    + ","+modelo2.getValueAt(i,4).toString().trim()+""
                    + ","+modelo2.getValueAt(i,5).toString().trim()+""
                    + ","+modelo2.getValueAt(i,6).toString().trim()+""
                    + ","+modelo2.getValueAt(i,7).toString().trim()+""
                    + ","+modelo2.getValueAt(i,8).toString().trim()+""
                    + ","+modelo2.getValueAt(i,9).toString().trim()+""
                    + ","+modelo2.getValueAt(i,10).toString().trim()+""
                    + ","+modelo2.getValueAt(i,11).toString().trim()+""
                    + ","+modelo2.getValueAt(i,12).toString().trim()+""
                    + ","+modelo2.getValueAt(i,13).toString().trim()+""
                    + ","+modelo2.getValueAt(i,14).toString().trim()+""
                    + ","+modelo2.getValueAt(i,15).toString().trim()+""
                    + ","+modelo2.getValueAt(i,16).toString().trim()+")";
            System.out.println(sentenciaSQL);
            sql.ingresarDatos(estSQL, sentenciaSQL);
        }
        
        JOptionPane.showMessageDialog(null, "Datos Guardados en la Tabla de Hechos Correctamente.");
        lblLoad.setVisible(false);
        int valor1=JOptionPane.showConfirmDialog(this,"¿Desea ver los datos que se han guardado?","Advertencia",JOptionPane.YES_NO_OPTION);
        if(valor1==0)
        {
            Ventana_Datos obj=new Ventana_Datos();
            obj.setVisible(true);
            String cabecera[]={"codtip_insc","codprov_insc","codfecha_insc","cod_sexo","codfecha_nac","codsabe_leer","cod_estcivil","cod_etnia","cod_pais","codparr_nac","cod_provnac","hij_viv","edad_mad","cant_insc","cant_nac","talla","peso"};
            String datos[][]={};
            Ventana_Datos.modelo=new DefaultTableModel(datos,cabecera);
            
            Ventana_Datos.tablaComp.setModel(Ventana_Datos.modelo);
            for (int i=0;i<modelo2.getRowCount(); i++) 
            {
                Object fila [] = new Object [modelo2.getColumnCount()];
                for (int j=0; j<modelo2.getColumnCount(); j++)
                {
                    fila[j] = modelo2.getValueAt(i,j);
                }
                Ventana_Datos.modelo.addRow(fila);
            }
            limpiarTabla2(tablaDim);
        }else
        {
            limpiarTabla2(tablaDim);
        }
        
        String sentenciaSQL="update registros set reg="+(valor-1);
        System.out.println(sentenciaSQL);
        sql.ingresarDatos(estSQL, sentenciaSQL);
        
        
        
    }//GEN-LAST:event_btnCargaAllActionPerformed

    private void cmbTablaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbTablaFocusGained
        sw=true;
    }//GEN-LAST:event_cmbTablaFocusGained
    public void importar()
    {
        limpiarTabla(Tabla1);
        
        int reg=genNumReg();
        JFileChooser examinar=new JFileChooser();
        examinar.setFileFilter(new FileNameExtensionFilter("Archivos Excel","xlsx","xls"));
        int opcion=examinar.showOpenDialog(this);
        File archivoExcel=null;
        cmbTabla.removeAllItems();
        if(opcion==JFileChooser.APPROVE_OPTION)
        {
            archivoExcel=examinar.getSelectedFile().getAbsoluteFile();
            try{
                Workbook leerExcel=Workbook.getWorkbook(archivoExcel);
                
                for(int hoja=0;hoja<leerExcel.getNumberOfSheets();hoja++)
                {
                    Sheet hojaP=leerExcel.getSheet(hoja);
                    int columnas=hojaP.getColumns();
                    int filas=hojaP.getRows();
                    System.out.println("reg: "+reg);
                    System.out.println("filas: "+filas);
                    
                    valor=filas;
                    if(reg!=(filas-1))
                    {
                        if(filas!=0)
                        {
                            JOptionPane.showMessageDialog(null, "Importación Exitosa\nN° de Registros: "+(filas-reg-1));
                            Object data[]=new Object[columnas];
                            for(int fila=reg;fila<filas;fila++)
                            {
                                for(int columna=0;columna<columnas;columna++)
                                {
                                    if(fila==reg)
                                    {
                                        modelo.addColumn(hojaP.getCell(columna,0).getContents());
                                        cmbTabla.addItem(hojaP.getCell(columna,0).getContents());
                                        cmbValorHechos.addItem(hojaP.getCell(columna,0).getContents());
                                    }
                                    if(fila>=reg)
                                    {
                                        data[columna]=hojaP.getCell(columna,fila).getContents();
                                    }
                                }
                                modelo.addRow(data);
                            }
                            modelo.removeRow(0);    

                        }else
                        {
                            JOptionPane.showMessageDialog(null, "No hay Datos para Tratar...");
                        }
                    }else
                    {
                        JOptionPane.showMessageDialog(null, "No hay Datos Nuevos en el Archivo para Tratar...");
                    }
                }
            } catch (IOException | BiffException ex) 
            {
                java.util.logging.Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al almacenar el Excel en el WorkBook");
            }
        
        }
        sw=true;
        /*String cabecera1[]={"Codigo","Nombre"};
            String datos1[][]={};
            modelo2=new DefaultTableModel(datos1,cabecera1);
            tablaDim.setModel(modelo2); 

        int filas=modelo.getRowCount()+1;
        Object[]fila= new Object[filas];
        for(int j=0;j<filas-1;j++)
                {    
                    fila[0]=genClave("cod_tipoinsc")+j+1;
                    fila[1]=modelo.getValueAt(j,0);
                    modelo2.addRow(fila);
                }*/
        genClave("cod_tipoinsc");
    }
    public void importarTodo()
    {
        limpiarTabla(Tabla1);
        
        JFileChooser examinar=new JFileChooser();
        examinar.setFileFilter(new FileNameExtensionFilter("Archivos Excel","xlsx","xls"));
        int opcion=examinar.showOpenDialog(this);
        File archivoExcel=null;
        cmbTabla.removeAllItems();
        if(opcion==JFileChooser.APPROVE_OPTION)
        {
            archivoExcel=examinar.getSelectedFile().getAbsoluteFile();
            try{
                Workbook leerExcel=Workbook.getWorkbook(archivoExcel);
                
                for(int hoja=0;hoja<leerExcel.getNumberOfSheets();hoja++)
                {
                    Sheet hojaP=leerExcel.getSheet(hoja);
                    int columnas=hojaP.getColumns();
                    int filas=hojaP.getRows();
                    
                    
                    valor=filas;
                    
                        if(filas!=0)
                        {
                            JOptionPane.showMessageDialog(null, "Importación Exitosa\nN° de Registros: "+(filas-1));
                            Object data[]=new Object[columnas];
                            for(int fila=0;fila<filas;fila++)
                            {
                                for(int columna=0;columna<columnas;columna++)
                                {
                                    if(fila==0)
                                    {
                                        modelo.addColumn(hojaP.getCell(columna,0).getContents());
                                        cmbTabla.addItem(hojaP.getCell(columna,0).getContents());
                                        cmbValorHechos.addItem(hojaP.getCell(columna,0).getContents());
                                    }
                                    if(fila>=1)
                                    {
                                        data[columna]=hojaP.getCell(columna,fila).getContents();
                                    }
                                }
                                modelo.addRow(data);
                            }
                            modelo.removeRow(0);    

                        }else
                        {
                            JOptionPane.showMessageDialog(null, "No hay Datos para Tratar...");
                        }
                    
                }
            } catch (IOException | BiffException ex) 
            {
                java.util.logging.Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al almacenar el Excel en el WorkBook");
            }
        
        }
        sw=true;
        /*String cabecera1[]={"Codigo","Nombre"};
            String datos1[][]={};
            modelo2=new DefaultTableModel(datos1,cabecera1);
            tablaDim.setModel(modelo2); 

        int filas=modelo.getRowCount()+1;
        Object[]fila= new Object[filas];
        for(int j=0;j<filas-1;j++)
                {    
                    fila[0]=genClave("cod_tipoinsc")+j+1;
                    fila[1]=modelo.getValueAt(j,0);
                    modelo2.addRow(fila);
                }*/
        genClave("cod_tipoinsc");
        band=0;
    }
    
    public void genValorCuant(int index,String ref)
    {
        for (int j=0; j<modelo.getRowCount(); j++)
        {
            if(modelo.getValueAt(j, index)=="")
            {
                fila[j]="0";   
            }else
            {
                fila[j]=modelo.getValueAt(j,index).toString();
            }
        }
        modelo2.addColumn(ref,fila);
    }
    public int genClave(String ref)
    {
        Procesos sql=new Procesos();
        String cadeql="select CONVERT(int,LAST_VALUE)from sys.identity_columns WHERE name ='"+ref+"'";
        ResultSet rs=sql.consultarUltimoId(estSQL,cadeql);
        Object valorO;
        int index=0;
        try
        {   
            rs.next();
            valorO=rs.getObject(1);    
            if(valorO!=null)
            {
                index=Integer.parseInt(valorO.toString().trim());
            }else
                index=0;
        }catch(Exception e)
        {    
        }
        return index;
    }
    //select COUNT(*) from tipo_insc WHERE nombre_tipoinsc='INTEGRA'
    public int genNum(String ref,String table,String column)
    {
        Procesos sql=new Procesos();
        String cadeql="select COUNT(*) from "+table+" WHERE "+column+"='"+ref+"'";
        System.out.println(cadeql);
        ResultSet rs=sql.consultarUltimoId(estSQL,cadeql);
        Object valorO;
        int index=0;
        try
        {   
            rs.next();
            valorO=rs.getObject(1);    
            if(valorO!=null)
            {
                index=Integer.parseInt(valorO.toString().trim());
            }else
                index=1;
        }catch(Exception e)
        {    
        }
        return index;
    }
    public void validUniq(String column,String table)
    {
        int filas=modelo2.getRowCount();            
            for(int j=0;j<filas;j++)
            {    
               if(genNum(modelo2.getValueAt(j,1).toString(),table,column)>0)
               {
                   JOptionPane.showMessageDialog(null,"Ya existe ese valor en a Base de Datos\nFila: "+j);
                   modelo2.removeRow(j);
               }
            }
    }
    public int genNumReg()
    {
        Procesos sql=new Procesos();
        String cadeql="select max(reg) from registros";
        ResultSet rs=sql.consultarUltimoId(estSQL,cadeql);
        Object valorO;
        int index=0;
        try
        {   
            rs.next();
            valorO=rs.getObject(1);    
            if(valorO!=null)
            {
                index=Integer.parseInt(valorO.toString().trim());
            }else
                index=1;
        }catch(Exception e)
        {    
        }
        return index;
    }
     public int genNumNull(String refC,String refT,String codRef,String nullRef)
    {
        Procesos sql=new Procesos();
        String cadeql="select "+codRef+" from "+refT+" where "+refC+"='"+nullRef+"'";
        ResultSet rs=sql.consultarUltimoId(estSQL,cadeql);
        System.out.println(cadeql);
        Object valorO;
        int index=0;
        try
        {   
            rs.next();
            valorO=rs.getObject(1);    
            if(valorO!=null)
            {
                index=Integer.parseInt(valorO.toString().trim());
            }else
                index=1;
        }catch(Exception e)
        {    
        }
        return index;
    }
    public int genCodHechos(String cod,String tabla,String campo,String aux)
    {
        int index=0;
        if(aux=="" && tabla=="tipo_insc")
        {
            index=genNumNull(campo, tabla, cod,"NO DEFINIDO");
        }else
        if(aux=="" && tabla=="prov_insc")
        {
            index=genNumNull(campo, tabla, cod,"NO DEFINIDO");
        }else
        if(aux=="" && tabla=="fecha_insc")
        {
            index=genNumNull(campo, tabla, cod,"01/01/2000");
        }else
        if(aux=="" && tabla=="fecha_nac")
        {
            index=genNumNull(campo, tabla, cod,"01/01/2000");
        }else
        if(aux=="" && tabla=="sexo")
        {
            index=genNumNull(campo, tabla, cod,"NO DEFINIDO");
        }else
        if(aux=="" && tabla=="parr_nac")
        {
            index=genNumNull(campo, tabla, cod,"NO DEFINIDO");
        }else
        if(aux=="" && tabla=="cod_pais")
        {
            index=genNumNull(campo, tabla, cod,"NO DEFINIDO");
        }else
        if(aux=="" && tabla=="etnia")
        {
            index=genNumNull(campo, tabla, cod,"NO DEFINIDO");
        }else
        if(aux=="" && tabla=="est_civil")
        {
            index=genNumNull(campo, tabla, cod,"NO DEFINIDO");
        }else
        if(aux=="" && tabla=="prov_nac")
        {
            index=genNumNull(campo, tabla, cod,"NO DEFINIDO");
        }else
        if(aux=="" && tabla=="sabe_leer")
        {
            index=genNumNull(campo, tabla, cod,"NO DEFINIDO");
        }
        
        Procesos sql=new Procesos();
        String cadeql="select "+cod+" from "+tabla+" where "+campo+"='"+aux+"'";
        System.out.println(cadeql);
        ResultSet rs=sql.consultarUltimoId(estSQL,cadeql);
        Object valorO;
        
        try
        {   
            rs.next();
            valorO=rs.getObject(1);    
            if(valorO!=null)
            {
                index=Integer.parseInt(valorO.toString().trim());
            }
                
        }catch(Exception e)
        {    
        }
        return index;
    }
    
    public void guardarDatos(String combo)
    {
        Procesos sql=new Procesos();
        for(int i=0;i<modelo2.getRowCount();i++)
        { 
            String sentenciaSQL="insert into "+combo+" "
            + "VALUES ('"+modelo2.getValueAt(i,1).toString().trim()+"')";
            System.out.println(sentenciaSQL);
            sql.ingresarDatos(estSQL, sentenciaSQL);
        }
    }
    
    public String[] unicos(String []words)
    {
        
        List<String> oldList = Arrays.asList(words); 
        List<String> uniqueList = new ArrayList<String>(
        new HashSet<String>(oldList));

        System.out.println("Resultado:");
        for (String string : uniqueList) {
         System.out.println("\t - " + string);
        }
          String vect[]=uniqueList.toArray(new String[uniqueList.size()]);
          aux=uniqueList.size()-1;
       return vect;   
    }
    public void codigosHechos()
    {
        
        Object fila [] = new Object [modelo.getRowCount()];
        for (int j=0; j<modelo.getRowCount(); j++)
        {
            fila[j] = genCodHechos("cod_tipoinsc", "tipo_insc","nombre_tipoinsc", modelo.getValueAt(j,0).toString());
            if(Integer.parseInt(fila[j].toString())==0)
            {
                fila[j]=1;
            }
        }
        modelo2.addColumn("tip_insc",fila);
        
        
        for (int j=0; j<modelo.getRowCount(); j++)
        {
            fila[j] = genCodHechos("cod_provinsc", "prov_insc","nombre_provinsc", modelo.getValueAt(j,1).toString());
            if(Integer.parseInt(fila[j].toString())==0)
            {
                fila[j]=1;
            }
        }
        modelo2.addColumn("prov_insc",fila);
        
        
        for (int j=0; j<modelo.getRowCount(); j++)
        {
            fila[j] = genCodHechos("cod_fechainsc", "fecha_insc","nombre_fechainsc", modelo.getValueAt(j,3).toString());
            if(Integer.parseInt(fila[j].toString())==0)
            {
                fila[j]=1;
            }
        }
        modelo2.addColumn("fecha_insc",fila);
        
        
        for (int j=0; j<modelo.getRowCount(); j++)
        {
            fila[j] = genCodHechos("cod_sexo", "sexo","nombre_sexo", modelo.getValueAt(j,4).toString());
            if(Integer.parseInt(fila[j].toString())==0)
            {
                fila[j]=1;
            }
        }
        modelo2.addColumn("sexo",fila);
        
        
        for (int j=0; j<modelo.getRowCount(); j++)
        {
            fila[j] = genCodHechos("cod_fechanac", "fecha_nac","nombre_fechanac", modelo.getValueAt(j,7).toString());
            if(Integer.parseInt(fila[j].toString())==0)
            {
                fila[j]=1;
            }
        }
        modelo2.addColumn("fecha_nac",fila);
        
        
        for (int j=0; j<modelo.getRowCount(); j++)
        {
            fila[j] = genCodHechos("cod_sabeleer", "sabe_leer","nombre_sabeleer", modelo.getValueAt(j,16).toString());
            if(Integer.parseInt(fila[j].toString())==0)
            {
                fila[j]=1;
            }
        }
        modelo2.addColumn("sabe_leer",fila);
        
        for (int j=0; j<modelo.getRowCount(); j++)
        {
            fila[j] = genCodHechos("cod_estcivil", "est_civil","nombre_estcivil", modelo.getValueAt(j,15).toString());
            if(Integer.parseInt(fila[j].toString())==0)
            {
                fila[j]=1;
            }
        }
        modelo2.addColumn("est_civil",fila);
        
        
        for (int j=0; j<modelo.getRowCount(); j++)
        {
            fila[j] = genCodHechos("cod_etnia", "etnia","nombre_etnia", modelo.getValueAt(j,14).toString());
            if(Integer.parseInt(fila[j].toString())==0)
            {
                fila[j]=1;
            }
        }
        modelo2.addColumn("etnia",fila);
        
        
        for (int j=0; j<modelo.getRowCount(); j++)
        {
            fila[j] = genCodHechos("cod_codpais", "cod_pais","nombre_codpais", modelo.getValueAt(j,11).toString());
            if(Integer.parseInt(fila[j].toString())==0)
            {
                fila[j]=1;
            }
        }
        modelo2.addColumn("cod_pais",fila);
        
        
        for (int j=0; j<modelo.getRowCount(); j++)
        {
            fila[j] = genCodHechos("cod_parrnac", "parr_nac","nombre_parrnac", modelo.getValueAt(j,10).toString());
            if(Integer.parseInt(fila[j].toString())==0)
            {
                fila[j]=1;
            }
        }
        modelo2.addColumn("parr_nac",fila);
        
        
        for (int j=0; j<modelo.getRowCount(); j++)
        {
            fila[j] = genCodHechos("cod_provnac", "prov_nac","nombre_provnac", modelo.getValueAt(j,8).toString());
            if(Integer.parseInt(fila[j].toString())==0)
            {
                fila[j]=1;
            }
        }
        modelo2.addColumn("prov_nac",fila);
        
    }
    //************************************************************
    //************************************************************
    //************************************************************
    //************************************************************
    public void caso1(int index,String ref,String nullval)
    {
        String cabecera1[]={"Codigo","Nombre"};
        String datos1[][]={};
        modelo2=new DefaultTableModel(datos1,cabecera1);
        tablaDim.setModel(modelo2); 

        int columnas=modelo.getColumnCount();
        int filas=modelo.getRowCount()+1;
        System.out.println(columnas+"   "+filas);
        Object[]fila= new Object[filas];
        String vect[]=new String[filas];
        for(int j=0;j<filas-1;j++)
        {    
            if(modelo.getValueAt(j,index)=="")
            {
                vect[j]=nullval;
            }else
            {
                vect[j]=modelo.getValueAt(j,index).toString();
            }
        }
        List<String> oldList = Arrays.asList(vect); 
        List<String> uniqueList = new ArrayList<String>(
        new HashSet<String>(oldList));

        System.out.println("Resultado:");
        for (String string : uniqueList) {
            System.out.println("\t - " + string);
        }
        uniqueList.remove(0);
        String vect2[]=uniqueList.toArray(new String[uniqueList.size()]);

        for(int j=0;j<uniqueList.size();j++)
        {    
            fila[0]=genClave(ref)+j+1;
            fila[1]=vect2[j].toUpperCase();
            modelo2.addRow(fila); 
        }
    }
    public void caso2(int index,String ref)
    {
        String cabecera1[]={"Codigo","Nombre"};
        String datos1[][]={};
        modelo2=new DefaultTableModel(datos1,cabecera1);
        tablaDim.setModel(modelo2); 

        int columnas=modelo.getColumnCount();
        int filas=modelo.getRowCount()+1;
        System.out.println(columnas+"   "+filas);
        Object[]fila= new Object[filas];
        String vect[]=new String[filas];
            
        for(int j=0;j<filas-1;j++)
        {    
            if(modelo.getValueAt(j,index)=="")
            {
                vect[j]=txtNull.getText().trim();
            }else
            {
                vect[j]=modelo.getValueAt(j,index).toString();
            }
        }
        List<String> oldList = Arrays.asList(vect); 
        List<String> uniqueList = new ArrayList<String>(
        new HashSet<String>(oldList));

        System.out.println("Resultado:");
        for (String string : uniqueList) {
            System.out.println("\t - " + string);
        }
        uniqueList.remove(0);
        String vect2[]=uniqueList.toArray(new String[uniqueList.size()]);

        for(int j=0;j<uniqueList.size();j++)
        {    
            fila[0]=genClave(ref)+j+1;
            fila[1]=vect2[j];
            modelo2.addRow(fila); 
        }
    }
    public void caso3(int index,String ref)
    {
        String cabecera1[]={"Codigo","Nombre"};
        String datos1[][]={};
        modelo2=new DefaultTableModel(datos1,cabecera1);
        tablaDim.setModel(modelo2); 

        int columnas=modelo.getColumnCount();
        int filas=modelo.getRowCount()+1;
        System.out.println(columnas+"   "+filas);
        Object[]fila= new Object[filas];
        String vect[]=new String[filas];
        
        for(int j=0;j<filas-1;j++)
        {    
            if(modelo.getValueAt(j,0)=="")
            {
                vect[j]=" ";
            }else
            {
                vect[j]=modelo.getValueAt(j,0).toString();
            }
        }
        List<String> oldList = Arrays.asList(vect); 
        List<String> uniqueList = new ArrayList<String>(
        new HashSet<String>(oldList));

        System.out.println("Resultado:");
        for (String string : uniqueList) {
            System.out.println("\t - " + string);
        }
        uniqueList.remove(0);
        String vect2[]=uniqueList.toArray(new String[uniqueList.size()]);

        for(int j=0;j<uniqueList.size();j++)
        {    
            fila[0]=genClave(ref)+j+1;
            fila[1]=vect2[j].toUpperCase();
            modelo2.addRow(fila); 
        }
    }
    public void caso4(int index,String ref)
    {
        String cabecera1[]={"Codigo","Nombre"};
        String datos1[][]={};
        modelo2=new DefaultTableModel(datos1,cabecera1);
        tablaDim.setModel(modelo2); 

        int columnas=modelo.getColumnCount();
        int filas=modelo.getRowCount()+1;
        System.out.println(columnas+"   "+filas);
        Object[]fila= new Object[filas];
        for(int j=0;j<filas-1;j++)
        {    
            fila[0]=genClave(ref)+j+1;
            if(modelo.getValueAt(j, index)=="")
            {
                fila[1]=txtNull.getText().toUpperCase();   
            }else
            {
                fila[1]=modelo.getValueAt(j,index).toString().toUpperCase();
            }
            modelo2.addRow(fila); 
        }
    }
    public void caso5(int index,String ref,String valnul)
    {
        String cabecera1[]={"Codigo","Nombre"};
        String datos1[][]={};
        modelo2=new DefaultTableModel(datos1,cabecera1);
        tablaDim.setModel(modelo2); 

        int columnas=modelo.getColumnCount();
        int filas=modelo.getRowCount()+1;
        System.out.println(columnas+"   "+filas);
        Object[]fila= new Object[filas];
        for(int j=0;j<filas-1;j++)
        {    
            fila[0]=genClave(ref)+j+1;
            if(modelo.getValueAt(j, index)=="")
            {

                fila[1]=txtNull.getText();

            }else
            {
                fila[1]=modelo.getValueAt(j,index);
            }
            modelo2.addRow(fila); 
        }
    }
    public void caso6(int index,String ref)
    {
        String cabecera1[]={"Codigo","Nombre"};
        String datos1[][]={};
        modelo2=new DefaultTableModel(datos1,cabecera1);
        tablaDim.setModel(modelo2); 

        int columnas=modelo.getColumnCount();
        int filas=modelo.getRowCount()+1;
        System.out.println(columnas+"   "+filas);
        Object[]fila= new Object[filas];
        for(int j=0;j<filas-1;j++)
        {    
            fila[0]=genClave(ref)+j+1;
            fila[1]=modelo.getValueAt(j,index).toString().toUpperCase();
            modelo2.addRow(fila); 
        }
    }
    
    //************************************************************
    //************************************************************
    //************************************************************
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       new Thread(new SplashSc()).start();
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla1;
    private javax.swing.JButton btnCargaAll;
    private javax.swing.JButton btnCodigos;
    private javax.swing.JButton btnImp;
    private javax.swing.JButton btnValores;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JCheckBox checkMayus;
    private javax.swing.JCheckBox checkNull;
    private javax.swing.JCheckBox checkUnique;
    private javax.swing.JComboBox cmbTabla;
    private javax.swing.JComboBox cmbValorHechos;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblLoad;
    private javax.swing.JPanel panel;
    private javax.swing.JRadioButton radioDimensiones;
    private javax.swing.JRadioButton radioTablaHechos;
    private javax.swing.JTable tablaDim;
    private javax.swing.JTextField txtNull;
    // End of variables declaration//GEN-END:variables
}
