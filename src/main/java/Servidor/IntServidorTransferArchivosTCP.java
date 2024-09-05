package Servidor;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class IntServidorTransferArchivosTCP extends javax.swing.JFrame {

    private ServerSocket serverSocket;
    private static List<ClientHandler> clientHandlers = new ArrayList<>();
    private boolean serverRunning;
    private List<String> clientNames = new ArrayList<>();

    public IntServidorTransferArchivosTCP() {
        initComponents();
        serverRunning = false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        iniciarServidor = new javax.swing.JButton();
        detenerServidor = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaMs = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        iniciarServidor.setBackground(new java.awt.Color(204, 204, 204));
        iniciarServidor.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        iniciarServidor.setText("INICIAR SERVIDOR");
        iniciarServidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciarServidorActionPerformed(evt);
            }
        });

        detenerServidor.setBackground(new java.awt.Color(204, 204, 204));
        detenerServidor.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        detenerServidor.setText("DETENER SERVIDOR");
        detenerServidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detenerServidorActionPerformed(evt);
            }
        });

        jTextAreaMs.setColumns(20);
        jTextAreaMs.setRows(5);
        jScrollPane1.setViewportView(jTextAreaMs);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(iniciarServidor, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(detenerServidor, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(iniciarServidor, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(detenerServidor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void iniciarServidorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciarServidorActionPerformed
        if (!serverRunning) {
            try {
                serverSocket = new ServerSocket(12345);
                serverRunning = true;
                jTextAreaMs.append("Servidor iniciado en el puerto 12345\n");

                new Thread(() -> {
                    while (serverRunning) {
                        try {
                            Socket socket = serverSocket.accept();
                            ClientHandler clientHandler = new ClientHandler(socket);
                            clientHandlers.add(clientHandler);
                            new Thread(clientHandler).start();
                            jTextAreaMs.append("Nuevo cliente conectado\n");
                        } catch (IOException e) {
                            jTextAreaMs.append("Error al aceptar cliente: " + e.getMessage() + "\n");
                        }
                    }
                }).start();

            } catch (IOException e) {
                jTextAreaMs.append("Error al iniciar el servidor: " + e.getMessage() + "\n");
            }
        } else {
            jTextAreaMs.append("El servidor ya está en funcionamiento\n");
        }
    }//GEN-LAST:event_iniciarServidorActionPerformed

    private void detenerServidorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detenerServidorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_detenerServidorActionPerformed
    
        public void broadcastMessage(String message, ClientHandler sender) {
        for (ClientHandler client : clientHandlers) {
            if (client != sender) {
                client.sendMessage(message);
            }
        }
    }

    private void detenerServidor() throws IOException {
        iniciarServidor.setEnabled(true);

            if (serverSocket != null && !serverSocket.isClosed()) {
                serverSocket.close();
            }

            jTextAreaMs.append("Servidor detenido.\n");
        
    }
    
    public void sendMessageToClient(String message, String clientName) {
        for (ClientHandler client : clientHandlers) {
            if (client.getClientName().equals(clientName)) {
                client.sendMessage(message);
                break;
            }
        }
    }

    public class ClientHandler implements Runnable {
        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;
        private String clientName;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public String getClientName() {
            return clientName;
        }

        public void sendMessage(String message) {
            out.println(message);
        }

        public void sendFile(byte[] fileBytes, String fileName) {
            try {
                OutputStream outputStream = socket.getOutputStream();
                PrintWriter pw = new PrintWriter(outputStream, true);
                
                // Enviar el nombre del archivo
                pw.println("FILE:" + fileName);

                // Enviar los datos del archivo
                BufferedOutputStream bos = new BufferedOutputStream(outputStream);
                bos.write(fileBytes, 0, fileBytes.length);
                bos.flush();
                jTextAreaMs.append("Archivo enviado: " + fileName + " a " + clientName + "\n");

            } catch (IOException e) {
                jTextAreaMs.append("Error al enviar archivo a " + clientName + ": " + e.getMessage() + "\n");
            }
        }

        @Override
        public void run() {
            try {
                out = new PrintWriter(socket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                clientName = in.readLine(); // Recibir nombre del cliente
                synchronized (clientNames) {
                    clientNames.add(clientName);
                }
                updateClientList();
                broadcastMessage(clientName + " se ha conectado.", this);

                String message;
                while ((message = in.readLine()) != null) {
                    if (message.startsWith("ALL:")) {
                        broadcastMessage(clientName + " envió un archivo.", this);
                        receiveAndSendFile(null); // Enviar a todos
                    } else if (message.startsWith("TO:")) {
                        String targetClientName = message.split(":")[1];
                        broadcastMessage(clientName + " envió un archivo a " + targetClientName, this);
                        receiveAndSendFile(targetClientName); // Enviar a un cliente específico
                    } else {
                        broadcastMessage(clientName + ": " + message, this);
                    }
                }

            } catch (IOException e) {
                jTextAreaMs.append("Error en la comunicación con un cliente.\n");
            } finally {
                try {
                    socket.close();
                    synchronized (clientNames) {
                        clientNames.remove(clientName);
                    }
                    updateClientList();
                    broadcastMessage(clientName + " se ha desconectado.", this);
                } catch (IOException e) {
                    jTextAreaMs.append("Error al cerrar la conexión del cliente.\n");
                }
            }
        }

        private void receiveAndSendFile(String targetClientName) throws IOException {
            InputStream inputStream = socket.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(inputStream);
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();

            int bytesRead;
            byte[] data = new byte[1024];
            while ((bytesRead = bis.read(data, 0, data.length)) != -1) {
                buffer.write(data, 0, bytesRead);
            }
            byte[] fileBytes = buffer.toByteArray();

            if (targetClientName != null) {
                sendFileToClient(fileBytes, targetClientName);
            } else {
                sendFileToAllClients(fileBytes, clientName);
            }
        }

        private void sendFileToAllClients(byte[] fileBytes, String senderClientName) {
            for (ClientHandler client : clientHandlers) {
                if (!client.getClientName().equals(senderClientName)) {
                    client.sendFile(fileBytes, "archivo_enviado");
                }
            }
        }

        private void sendFileToClient(byte[] fileBytes, String targetClientName) {
            for (ClientHandler client : clientHandlers) {
                if (client.getClientName().equals(targetClientName)) {
                    client.sendFile(fileBytes, "archivo_enviado");
                    break;
                }
            }
        }

        private void updateClientList() {
            String clientList = String.join(",", clientNames);
            for (ClientHandler clientHandler : clientHandlers) {
                clientHandler.sendMessage("UPDATE_CLIENT_LIST:" + clientList);
            }
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
            java.util.logging.Logger.getLogger(IntServidorTransferArchivosTCP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IntServidorTransferArchivosTCP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IntServidorTransferArchivosTCP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IntServidorTransferArchivosTCP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IntServidorTransferArchivosTCP().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton detenerServidor;
    private javax.swing.JButton iniciarServidor;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaMs;
    // End of variables declaration//GEN-END:variables
//JButton iniciar servidor = Boton para iniciar el servidor
//JTextArea jTextAreaMs = Area de texto para mostrar los mensajes del servidor
}

