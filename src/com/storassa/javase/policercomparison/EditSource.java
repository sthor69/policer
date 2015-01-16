/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.storassa.javase.policercomparison;

import javax.swing.JOptionPane;

/**
 *
 * @author storassa
 */
public class EditSource extends javax.swing.JDialog {

    MainTest parent;
    boolean isEditing;
    Source editedSource;

    /**
     * Creates new form EditSource
     */
    public EditSource(javax.swing.JFrame _parent, boolean modal) {
        super(_parent, modal);
        initComponents();

        parent = (MainTest) _parent;
        setLocationRelativeTo(null);
        getRootPane().setDefaultButton(okButton);
        okButton.requestFocus();
    }

    public EditSource(Source _source, javax.swing.JFrame _parent, boolean modal) {
        super(_parent, modal);
        initComponents();

        parent = (MainTest) _parent;
        setLocationRelativeTo(null);
        getRootPane().setDefaultButton(okButton);
        okButton.requestFocus();

        editedSource = _source;
        isEditing = true;

        idTextField.setText(_source.getId());

        if (_source.getSourceType() == SourceType.TRIANGULAR) {
            triangRadioButton.setSelected(true);
        } else if (_source.getSourceType() == SourceType.RECTANGULAR) {
            rectRadioButton.setSelected(true);
        } else if (_source.getSourceType() == SourceType.SINUSOIDAL) {
            sinRadioButton.setSelected(true);
        } else if (_source.getSourceType() == SourceType.LINEAR) {
            linRadioButton.setSelected(true);
        }

        highRateTextField.setText(String.valueOf(_source.getHigh()));
        lowRateTextField.setText(String.valueOf(_source.getLow()));
        periodTextField.setText(String.valueOf(_source.getPeriod()));

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
        jLabel3 = new javax.swing.JLabel();
        idTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        sinRadioButton = new javax.swing.JRadioButton();
        triangRadioButton = new javax.swing.JRadioButton();
        rectRadioButton = new javax.swing.JRadioButton();
        linRadioButton = new javax.swing.JRadioButton();
        cancelButton = new javax.swing.JButton();
        okButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lowRateTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        highRateTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        periodTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel3.setText("Name of the source:");

        jLabel4.setText("Type of source");

        buttonGroup1.add(sinRadioButton);
        sinRadioButton.setText("Synusoidal");

        buttonGroup1.add(triangRadioButton);
        triangRadioButton.setText("Triangular");

        buttonGroup1.add(rectRadioButton);
        rectRadioButton.setText("Rectangular");

        buttonGroup1.add(linRadioButton);
        linRadioButton.setText("Linear");

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Low rate");

        jLabel2.setText("High rate");

        jLabel5.setText("Period");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(idTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(triangRadioButton)
                                    .addComponent(sinRadioButton)
                                    .addComponent(rectRadioButton)
                                    .addComponent(linRadioButton)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lowRateTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                                    .addComponent(periodTextField))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(highRateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(sinRadioButton)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(triangRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rectRadioButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(linRadioButton)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lowRateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(highRateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(periodTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(okButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed

        Source source = getSource();

        if (null != source) {

            if (!isEditing && parent.addSource(source)) {
                dispose();
            } else if (isEditing) {
                if (source.getId().equals(editedSource.getId())) {
                    parent.editSource(source);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this,
                        "Cannot change the id of an edited policer",
                        "Input error",
                        JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this,
                        "Policers cannot have same id",
                        "Input error",
                        JOptionPane.WARNING_MESSAGE);
            }
        }


    }//GEN-LAST:event_okButtonActionPerformed

    private Source getSource() {
        Source s = new Source();

        try {

            s.setId(idTextField.getText());
            s.setHigh(Integer.parseInt(highRateTextField.getText()));
            s.setLow(Integer.parseInt(lowRateTextField.getText()));
            s.setPeriod(Double.parseDouble(periodTextField.getText()));

            if (sinRadioButton.isSelected()) {
                s.setSourceType(SourceType.SINUSOIDAL);
            } else if (triangRadioButton.isSelected()) {
                s.setSourceType(SourceType.TRIANGULAR);
            } else if (rectRadioButton.isSelected()) {
                s.setSourceType(SourceType.RECTANGULAR);
            } else if (linRadioButton.isSelected()) {
                s.setSourceType(SourceType.LINEAR);
            }

            return s;

        } catch (IllegalArgumentException e) {

            JOptionPane.showMessageDialog(this,
                    "Check fields",
                    "Input error",
                    JOptionPane.WARNING_MESSAGE);

            return null;
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
            java.util.logging.Logger.getLogger(EditSource.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditSource.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditSource.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditSource.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EditSource dialog = new EditSource(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField highRateTextField;
    private javax.swing.JTextField idTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JRadioButton linRadioButton;
    private javax.swing.JTextField lowRateTextField;
    private javax.swing.JButton okButton;
    private javax.swing.JTextField periodTextField;
    private javax.swing.JRadioButton rectRadioButton;
    private javax.swing.JRadioButton sinRadioButton;
    private javax.swing.JRadioButton triangRadioButton;
    // End of variables declaration//GEN-END:variables
}