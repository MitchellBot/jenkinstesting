/*
 * Copyright (C) 2016 Yaakov.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
 */
package javasandbox1;

import java.io.IOException;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yaakov
 */
public class SandboxUserInterface extends javax.swing.JFrame {

    private RMQConnection RMQC;
    /**
     * Creates new form NewJFrame
     */
    public SandboxUserInterface() {
        initComponents();
        this.jConnectedLbl.setVisible((false));

        // don't want to allow access to these buttons until connect is active
        this.jAckMessageBtn.setEnabled(false);
        this.jGetMessageBtn.setEnabled(false);
        this.jSendBtn.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane = new javax.swing.JTabbedPane();
        jSendPanel = new javax.swing.JPanel();
        jSendMessageTxtBox = new javax.swing.JTextField();
        jSendBtn = new javax.swing.JButton();
        jReceivePanel = new javax.swing.JPanel();
        jRecvMessageTxtBox = new javax.swing.JTextField();
        jAckMessageBtn = new javax.swing.JButton();
        jGetMessageBtn = new javax.swing.JButton();
        jConnectPanel = new javax.swing.JPanel();
        jConnectedLbl = new javax.swing.JLabel();
        jConnectTglBtn = new javax.swing.JToggleButton();
        jQueueTxtBox = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sandbox");
        setType(java.awt.Window.Type.UTILITY);

        jSendPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(158, 158, 158)));

        jSendMessageTxtBox.setText("Message to Send...");
        jSendMessageTxtBox.setMinimumSize(new java.awt.Dimension(120, 28));
        jSendMessageTxtBox.setPreferredSize(new java.awt.Dimension(240, 28));
        jSendMessageTxtBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSendMessageTxtBoxActionPerformed(evt);
            }
        });
        jSendPanel.add(jSendMessageTxtBox);

        jSendBtn.setText("Send");
        jSendBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSendBtnActionPerformed(evt);
            }
        });
        jSendPanel.add(jSendBtn);

        jTabbedPane.addTab("Send", jSendPanel);

        jReceivePanel.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(153, 153, 153)));

        jAckMessageBtn.setText("Ack Message");
        jAckMessageBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAckMessageBtnActionPerformed(evt);
            }
        });

        jGetMessageBtn.setText("Get Message");
        jGetMessageBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGetMessageBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jReceivePanelLayout = new javax.swing.GroupLayout(jReceivePanel);
        jReceivePanel.setLayout(jReceivePanelLayout);
        jReceivePanelLayout.setHorizontalGroup(
            jReceivePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jReceivePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRecvMessageTxtBox)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jReceivePanelLayout.createSequentialGroup()
                .addContainerGap(152, Short.MAX_VALUE)
                .addGroup(jReceivePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jGetMessageBtn)
                    .addComponent(jAckMessageBtn))
                .addGap(143, 143, 143))
        );
        jReceivePanelLayout.setVerticalGroup(
            jReceivePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jReceivePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRecvMessageTxtBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jGetMessageBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jAckMessageBtn)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jTabbedPane.addTab("Receive", jReceivePanel);

        jConnectedLbl.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jConnectedLbl.setForeground(new java.awt.Color(153, 255, 102));
        jConnectedLbl.setText("Connected");
        jConnectPanel.add(jConnectedLbl);

        jConnectTglBtn.setText("Connect");
        jConnectTglBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jConnectTglBtnActionPerformed(evt);
            }
        });
        jConnectPanel.add(jConnectTglBtn);

        jQueueTxtBox.setText("Queue");
        jQueueTxtBox.setPreferredSize(new java.awt.Dimension(100, 28));
        jConnectPanel.add(jQueueTxtBox);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jConnectPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jConnectPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane.getAccessibleContext().setAccessibleName("Send");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jSendBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSendBtnActionPerformed
        IRMQProducer irqp = new RMQProducer();
        irqp.sendMessage(this.jQueueTxtBox.getText(), this.jSendMessageTxtBox.getText());
    }//GEN-LAST:event_jSendBtnActionPerformed

    private void jConnectTglBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jConnectTglBtnActionPerformed
        if (this.jConnectTglBtn.isSelected()) {
            try {
                connectToRMQ();
            } catch (IOException ex) {
                disableSendGetButtons();
                Logger.getLogger(SandboxUserInterface.class.getName()).log(Level.SEVERE, null, ex);
            } catch (TimeoutException ex) {
                disableSendGetButtons();
                Logger.getLogger(SandboxUserInterface.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                disableSendGetButtons();
                Logger.getLogger(SandboxUserInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.jConnectedLbl.setVisible(true);
            enableSendGetButtons();
        } else {
            try {
                RMQC.connectionClose();
            } catch (IOException ex) {
                Logger.getLogger(SandboxUserInterface.class.getName()).log(Level.SEVERE, null, ex);
            } catch (TimeoutException ex) {
                Logger.getLogger(SandboxUserInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.jConnectedLbl.setVisible(false);
            disableSendGetButtons();
        }
    }//GEN-LAST:event_jConnectTglBtnActionPerformed

    private void enableSendGetButtons() {
        this.jAckMessageBtn.setEnabled(true);
        this.jGetMessageBtn.setEnabled(true);
        this.jSendBtn.setEnabled(true);
    }

    private void disableSendGetButtons() {
        this.jAckMessageBtn.setEnabled(false);
        this.jGetMessageBtn.setEnabled(false);
        this.jSendBtn.setEnabled(false);
    }

    private void jSendMessageTxtBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSendMessageTxtBoxActionPerformed
        this.jSendMessageTxtBox.setText(null);
    }//GEN-LAST:event_jSendMessageTxtBoxActionPerformed

    private void jAckMessageBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAckMessageBtnActionPerformed
        IRMQConsumer irmqc = new RMQConsumer();
        String message = irmqc.getMessage();
        this.jRecvMessageTxtBox.setText(message);
    }//GEN-LAST:event_jAckMessageBtnActionPerformed

    private void jGetMessageBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGetMessageBtnActionPerformed
        IRMQConsumer irmqc = new RMQConsumer();
        String message = irmqc.getMessage();
        this.jRecvMessageTxtBox.setText(message);
    }//GEN-LAST:event_jGetMessageBtnActionPerformed

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
            java.util.logging.Logger.getLogger(SandboxUserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SandboxUserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SandboxUserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SandboxUserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new SandboxUserInterface().setVisible(true);
        });
    }

    private void connectToRMQ()
            throws IOException,
            TimeoutException,
            InterruptedException {
        
        try {
            RMQC = new RMQConnection(this.jQueueTxtBox.getText());
        } catch (IOException ex) {
            throw ex;
        } catch (TimeoutException ex) {
            throw ex;
        } catch (InterruptedException ex) {
            throw ex;
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jAckMessageBtn;
    private javax.swing.JPanel jConnectPanel;
    private javax.swing.JToggleButton jConnectTglBtn;
    private javax.swing.JLabel jConnectedLbl;
    private javax.swing.JButton jGetMessageBtn;
    private javax.swing.JTextField jQueueTxtBox;
    private javax.swing.JPanel jReceivePanel;
    private javax.swing.JTextField jRecvMessageTxtBox;
    private javax.swing.JButton jSendBtn;
    private javax.swing.JTextField jSendMessageTxtBox;
    private javax.swing.JPanel jSendPanel;
    private javax.swing.JTabbedPane jTabbedPane;
    // End of variables declaration//GEN-END:variables
}