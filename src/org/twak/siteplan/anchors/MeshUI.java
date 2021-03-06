/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MeshShipUI.java
 *
 * Created on 27-Jun-2010, 04:10:23
 */

package org.twak.siteplan.anchors;

import java.io.File;

import org.twak.siteplan.campskeleton.Siteplan;
import org.twak.utils.WeakListener;
import org.twak.utils.ui.AbstractDocumentListener;
import org.twak.utils.ui.SimpleFileChooser;

/**
 *
 * @author twak
 */
public class MeshUI extends javax.swing.JPanel {

    MeshShip ms;
    WeakListener refreshAnchors;

    /** Creates new form MeshShipUI */
    public MeshUI()
    {
        initComponents();
    }
    public MeshUI(MeshShip in, WeakListener refreshAnchors)
    {
        this.refreshAnchors = refreshAnchors;
        this.ms = in;
        initComponents();
        fileField.setText(in.meshFile);
        firstNormalCheckBox.setSelected(in.firstNormalForAll);

        fileField.getDocument().addDocumentListener( new AbstractDocumentListener()
        {
            @Override
            public void changed() {
                if (fileField.getText().length() == 0)
                    return;
                try {
                    ms.setMeshFile(fileField.getText());
                } catch (Throwable th) {
                    System.out.println("while trying to cache "+fileField.getText());
                    th.printStackTrace();
                }
                MeshUI.this.refreshAnchors.fire();
            }
        });

        scaleSlider.setValue( (int) ( in.scale * scaleSlider.getMaximum()/5 ));
    }

    

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        fileField = new javax.swing.JTextField();
        browseButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        scaleSlider = new javax.swing.JScrollBar();
        firstNormalCheckBox = new javax.swing.JCheckBox();

        jLabel1.setText("mesh:");

        fileField.setText("mesh.md5");
        fileField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileFieldActionPerformed(evt);
            }
        });

        browseButton.setText("browse");
        browseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("scale:");

        scaleSlider.setMaximum(1000);
        scaleSlider.setOrientation(javax.swing.JScrollBar.HORIZONTAL);
        scaleSlider.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                scaleSliderMouseClicked(evt);
            }
        });
        scaleSlider.addAdjustmentListener(new java.awt.event.AdjustmentListener() {
            public void adjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {
                scaleSliderAdjustmentValueChanged(evt);
            }
        });

        firstNormalCheckBox.setText("don't twist");
        firstNormalCheckBox.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        firstNormalCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstNormalCheckBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(firstNormalCheckBox)
                        .addContainerGap())
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(fileField, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(browseButton))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(scaleSlider, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                            .addContainerGap()))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fileField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(browseButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(scaleSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(firstNormalCheckBox)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void browseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseButtonActionPerformed

        new SimpleFileChooser (Siteplan.instance, false, "select mesh") {
            @Override
            public void heresTheFile(File f) throws Throwable {
                fileField.setText( f.getPath() );
                ms.refreshFeatureListener.changed();
            }
        };
    }//GEN-LAST:event_browseButtonActionPerformed

    private void scaleSliderAdjustmentValueChanged(java.awt.event.AdjustmentEvent evt)//GEN-FIRST:event_scaleSliderAdjustmentValueChanged
    {//GEN-HEADEREND:event_scaleSliderAdjustmentValueChanged
        ms.scale = scaleSlider.getValue() * 5. / scaleSlider.getMaximum();
    }//GEN-LAST:event_scaleSliderAdjustmentValueChanged

    private void scaleSliderMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_scaleSliderMouseClicked
    {//GEN-HEADEREND:event_scaleSliderMouseClicked
        if (evt.getClickCount() == 2)
            scaleSlider.setValue(scaleSlider.getMaximum()/5);
    }//GEN-LAST:event_scaleSliderMouseClicked

    private void firstNormalCheckBoxActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_firstNormalCheckBoxActionPerformed
    {//GEN-HEADEREND:event_firstNormalCheckBoxActionPerformed
        ms.firstNormalForAll = firstNormalCheckBox.isSelected();
    }//GEN-LAST:event_firstNormalCheckBoxActionPerformed

    private void fileFieldActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_fileFieldActionPerformed
    {//GEN-HEADEREND:event_fileFieldActionPerformed

    }//GEN-LAST:event_fileFieldActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton browseButton;
    private javax.swing.JTextField fileField;
    private javax.swing.JCheckBox firstNormalCheckBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollBar scaleSlider;
    // End of variables declaration//GEN-END:variables

}
