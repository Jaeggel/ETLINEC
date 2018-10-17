/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import static Principal.Principal.estSQL;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DIEGO VELASCO
 */
public class Ventana_HechosBP extends javax.swing.JFrame {

    /**
     * Creates new form Ventana_HechosBP
     */
    public static DefaultTableModel modelo=null;
    public Ventana_HechosBP() {
        initComponents();
        insertImage();
        lbl1.setVisible(false);
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Img/icono.png"));
        setIconImage(icon);
        this.setLocationRelativeTo(null);
        this.setTitle("Gestión de Datos");
        this.setResizable(false);
        String cabecera[]={};
        //String cabecera[]={"tip_insc","prov_insc","cant_insc","fecha_insc","sexo","talla","peso","fecha_nac","prov_nac","cant_nac","parr_nac","cod_pais","edad_mad","hij_viv","etnia","est_civil","sabe_leer"};
        String datos[][]={};
        modelo=new DefaultTableModel(datos,cabecera);
        tabla_hechos.setModel(modelo); 
        cerrar();
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMain = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_hechos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        lbl1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabla_hechos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabla_hechos);

        jLabel1.setFont(new java.awt.Font("Calibri Light", 0, 24)); // NOI18N
        jLabel1.setText("Tabla de Hechos");

        btnGuardar.setBackground(new java.awt.Color(255, 255, 255));
        btnGuardar.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        lbl1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Loading_1.gif"))); // NOI18N

        javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain);
        panelMain.setLayout(panelMainLayout);
        panelMainLayout.setHorizontalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMainLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 962, Short.MAX_VALUE))
                    .addGroup(panelMainLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl1)
                        .addGap(38, 38, 38)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelMainLayout.setVerticalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(btnGuardar))
                    .addComponent(lbl1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        Procesos sql=new Procesos();
        lbl1.setVisible(true);
        for(int i=0;i<modelo.getRowCount();i++)
        { 
            String sentenciaSQL="insert into hechos_bp "
            + "VALUES ("+modelo.getValueAt(i,0).toString().trim()+""
                    + ","+modelo.getValueAt(i,1).toString().trim()+""
                    + ","+modelo.getValueAt(i,2).toString().trim()+""
                    + ","+modelo.getValueAt(i,3).toString().trim()+""
                    + ","+modelo.getValueAt(i,4).toString().trim()+""
                    + ","+modelo.getValueAt(i,5).toString().trim()+""
                    + ","+modelo.getValueAt(i,6).toString().trim()+""
                    + ","+modelo.getValueAt(i,7).toString().trim()+""
                    + ","+modelo.getValueAt(i,8).toString().trim()+""
                    + ","+modelo.getValueAt(i,9).toString().trim()+""
                    + ","+modelo.getValueAt(i,10).toString().trim()+""
                    + ","+modelo.getValueAt(i,11).toString().trim()+""
                    + ","+modelo.getValueAt(i,12).toString().trim()+""
                    + ","+modelo.getValueAt(i,13).toString().trim()+""
                    + ","+modelo.getValueAt(i,14).toString().trim()+""
                    + ","+modelo.getValueAt(i,15).toString().trim()+""
                    + ","+modelo.getValueAt(i,16).toString().trim()+")";
            System.out.println(sentenciaSQL);
            sql.ingresarDatos(estSQL, sentenciaSQL);
            
        }
        JOptionPane.showMessageDialog(null, "Datos Guardados Correctamente.");
        lbl1.setVisible(false);
    }//GEN-LAST:event_btnGuardarActionPerformed
public void insertImage()
    {
        ImagePanel Imagen = new ImagePanel();
        panelMain.add(Imagen);
        panelMain.repaint();
    }
   
    public class ImagePanel extends JPanel 
    {
        public ImagePanel()
        {
            //Se crea un método cuyo parámetro debe ser un objeto Graphics
            this.setSize(985,515);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl1;
    private javax.swing.JPanel panelMain;
    private javax.swing.JTable tabla_hechos;
    // End of variables declaration//GEN-END:variables
}
