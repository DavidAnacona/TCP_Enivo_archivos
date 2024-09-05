package Cliente;

import javax.swing.*;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class IntClienteTransferArchivosTCP extends javax.swing.JFrame {

    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    String nombreCliente;
    private List<String> comboBoxItems = new ArrayList<>();
    private File selectedFile = null;

    public IntClienteTransferArchivosTCP() {
        initComponents();
        nombreCliente = pedirNombnre();
        jNombreCliente.setText(nombreCliente);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        conectarServidor = new javax.swing.JButton();
        desconectarServidor = new javax.swing.JButton();
        selecArchivo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaMc = new javax.swing.JTextArea();
        enviar = new javax.swing.JButton();
        ClientesConectados = new javax.swing.JComboBox<>();
        EnviarTodos = new javax.swing.JCheckBox();
        EnviarUno = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        jNombreCliente = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        conectarServidor.setBackground(new java.awt.Color(204, 204, 204));
        conectarServidor.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        conectarServidor.setText("CONECTAR CON SERVIDOR");
        conectarServidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conectarServidorActionPerformed(evt);
            }
        });

        desconectarServidor.setBackground(new java.awt.Color(204, 204, 204));
        desconectarServidor.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        desconectarServidor.setText("DESCONECTAR SERVIDOR");
        desconectarServidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desconectarServidorActionPerformed(evt);
            }
        });

        selecArchivo.setBackground(new java.awt.Color(204, 204, 204));
        selecArchivo.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        selecArchivo.setText("Adjuntar archivo");
        selecArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selecArchivoActionPerformed(evt);
            }
        });

        jTextAreaMc.setColumns(20);
        jTextAreaMc.setRows(5);
        jScrollPane1.setViewportView(jTextAreaMc);

        enviar.setBackground(new java.awt.Color(204, 204, 204));
        enviar.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        enviar.setText("Enviar");
        enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarActionPerformed(evt);
            }
        });

        ClientesConectados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClientesConectadosActionPerformed(evt);
            }
        });

        EnviarTodos.setText("Enviar a Todos");
        EnviarTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnviarTodosActionPerformed(evt);
            }
        });

        EnviarUno.setText("Enviar a Uno");
        EnviarUno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnviarUnoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Cliente:");

        jNombreCliente.setText("jLabel4");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(conectarServidor)
                    .addComponent(desconectarServidor, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(EnviarUno)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(EnviarTodos)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ClientesConectados, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(selecArchivo)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(enviar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(10, 10, 10))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(conectarServidor, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(desconectarServidor, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(9, 9, 9)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ClientesConectados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EnviarTodos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(EnviarUno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selecArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(enviar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void conectarServidorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conectarServidorActionPerformed
        try {
            socket = new Socket("localhost", 12345);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            out.println(nombreCliente);

            jTextAreaMc.append("Conectado al servidor como " + nombreCliente + "\n");

            new Thread(() -> {
                try {
                    String serverMessage;
                    while ((serverMessage = in.readLine()) != null) {
                        if (serverMessage.startsWith("UPDATE_CLIENT_LIST:")) {
                            String clientList = serverMessage.substring("UPDATE_CLIENT_LIST:".length());
                            String[] clients = clientList.split(",");
                            comboBoxItems.clear();
                            for (String client : clients) {
                                comboBoxItems.add(client);
                            }
                            updateClientComboBox();
                        } else {
                            jTextAreaMc.append(serverMessage + "\n");
                        }
                    }
                } catch (IOException e) {
                    jTextAreaMc.append("Error en la comunicación con el servidor.\n");
                }
            }).start();

        } catch (IOException e) {
            jTextAreaMc.append("No se pudo conectar al servidor.\n");
        }
    }//GEN-LAST:event_conectarServidorActionPerformed

    private String pedirNombnre() {
        nombreCliente = JOptionPane.showInputDialog(this, "Ingresa tu nombre:", "Nombre del Cliente", JOptionPane.PLAIN_MESSAGE);

        if (nombreCliente == null || nombreCliente.trim().isEmpty()) {
            jTextAreaMc.append("Conexión cancelada. Debes ingresar un nombre.\n");
        }
        return nombreCliente;
    }

    private void desconectarServidorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desconectarServidorActionPerformed
        try {
            if (socket != null && !socket.isClosed()) {
                socket.close();
                jTextAreaMc.append("Desconectado del servidor\n");
            }
        } catch (IOException e) {
            jTextAreaMc.append("Error al desconectar del servidor: " + e.getMessage() + "\n");
        }
    }//GEN-LAST:event_desconectarServidorActionPerformed

    private void selecArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selecArchivoActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            selectedFile = fileChooser.getSelectedFile();
            jTextAreaMc.append("Archivo seleccionado: " + selectedFile.getName() + "\n");
        }
    }//GEN-LAST:event_selecArchivoActionPerformed

    private void enviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviarActionPerformed
        if (selectedFile != null) {
            try {
                FileInputStream fileIn = new FileInputStream(selectedFile);
                BufferedOutputStream outStream = new BufferedOutputStream(socket.getOutputStream());

                if (EnviarTodos.isSelected()) {
                    out.println("ALL:");
                } else if (EnviarUno.isSelected()) {
                    String selectedClient = (String) ClientesConectados.getSelectedItem();
                    if (selectedClient != null && !selectedClient.equals("Seleccionar")) {
                        out.println("TO:" + selectedClient + ":");
                    } else {
                        jTextAreaMc.append("Seleccione un cliente válido\n");
                        return;
                    }
                }

                // Enviar el nombre del archivo primero
                out.println(selectedFile.getName());

                // Enviar los datos del archivo
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = fileIn.read(buffer)) != -1) {
                    outStream.write(buffer, 0, bytesRead);
                }
                outStream.flush();
                fileIn.close();
                jTextAreaMc.append("Archivo enviado: " + selectedFile.getName() + "\n");
            } catch (IOException e) {
                jTextAreaMc.append("Error al enviar el archivo: " + e.getMessage() + "\n");
            }
        } else {
            jTextAreaMc.append("Seleccione un archivo antes de enviar.\n");
        }
    }//GEN-LAST:event_enviarActionPerformed

    private void EnviarTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnviarTodosActionPerformed
        if (EnviarTodos.isSelected()) {
            EnviarUno.setSelected(false);
        }
    }//GEN-LAST:event_EnviarTodosActionPerformed

    private void EnviarUnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnviarUnoActionPerformed
        if (EnviarUno.isSelected()) {
            EnviarTodos.setSelected(false);
        }
    }//GEN-LAST:event_EnviarUnoActionPerformed

    private void ClientesConectadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClientesConectadosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ClientesConectadosActionPerformed

    private void updateClientComboBox() {
        ClientesConectados.removeAllItems();
        for (String item : comboBoxItems) {
            ClientesConectados.addItem(item);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(IntClienteTransferArchivosTCP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IntClienteTransferArchivosTCP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IntClienteTransferArchivosTCP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IntClienteTransferArchivosTCP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IntClienteTransferArchivosTCP().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ClientesConectados;
    private javax.swing.JCheckBox EnviarTodos;
    private javax.swing.JCheckBox EnviarUno;
    private javax.swing.JButton conectarServidor;
    private javax.swing.JButton desconectarServidor;
    private javax.swing.JButton enviar;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jNombreCliente;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaMc;
    private javax.swing.JButton selecArchivo;
    // End of variables declaration//GEN-END:variables
    //JButton conectarServidor = Boton para conectar con IntServidor
    //JButton desconectarServidor = Boton para desconectar con IntServidor
    //JButton enviar = Boton para enviar el archivo plano seleccionado
    //JTextArea jTextAreaMc = Area de texto donde se ven mensajes de que se cargo el archivo y mensajes de informacion
    //JButton selecArchivo = Boton para seleccionar el archivo del explorador de archivos.
    //JComboBox<String> ClientesConectados = Combo box de donde van a aparecer a que cliente desea enviar el archivo
    //JCheckBox EnviarTodos = Check para enviar el archivo a todos los clientes conectados.
    //JCheckBox EnviarUno = Check para enviar el archivo a solo un cliente conectado.

}
