package camp.anchors;

import campskeleton.CampSkeleton;
import javax.swing.AbstractSpinnerModel;
import utils.AbstractDocumentListener;
import utils.WeakListener;

/**
 *
 * @author twak
 */
public class NaturalStepPanel extends javax.swing.JPanel {
    NaturalStepShip ship;
     WeakListener.Changed featureListChanged;

    /** Creates new form NaturalStepUI */
    public NaturalStepPanel() {
        initComponents();
    }
    public NaturalStepPanel(NaturalStepShip ship,  WeakListener.Changed featureListChanged) {
        this.ship = ship;
        this.featureListChanged = featureListChanged;
        initComponents();

        nameField.setText(ship.getFeatureName());

        nameField.getDocument().addDocumentListener(new AbstractDocumentListener() {
            @Override
            public void changed() {
                NaturalStepPanel.this.ship.name = nameField.getText();
            }
        });

        nGonSpinner.setModel(new ThreePlusSpinnerModel());
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nameField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        planEditButton = new javax.swing.JButton();
        nGonSpinner = new javax.swing.JSpinner();
        nGonButton = new javax.swing.JButton();

        nameField.setText("jTextField1");
        nameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameFieldActionPerformed(evt);
            }
        });

        jLabel1.setText("name:");

        planEditButton.setText("edit plan");
        planEditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                planEditButtonActionPerformed(evt);
            }
        });

        nGonButton.setText("to regular:");
        nGonButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nGonButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(4, 4, 4)
                .addComponent(nameField, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE))
            .addComponent(planEditButton, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(nGonButton, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nGonSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(planEditButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nGonSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nGonButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void planEditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_planEditButtonActionPerformed
        CampSkeleton.instance.setPlan( ship.createPlanUI(CampSkeleton.instance.new PlanEdgeSelected()) );
    }//GEN-LAST:event_planEditButtonActionPerformed

    private void nGonButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nGonButtonActionPerformed
        // now flush changes to the editor
        planEditButtonActionPerformed(evt);
    }//GEN-LAST:event_nGonButtonActionPerformed

    private void nameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameFieldActionPerformed
        featureListChanged.changed();
    }//GEN-LAST:event_nameFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton nGonButton;
    private javax.swing.JSpinner nGonSpinner;
    private javax.swing.JTextField nameField;
    private javax.swing.JButton planEditButton;
    // End of variables declaration//GEN-END:variables


    public static class ThreePlusSpinnerModel extends AbstractSpinnerModel {
        int value = 4;

        @Override
        public Object getValue() {
            return new Integer(value);
        }

        @Override
        public void setValue(Object value) {
            value = Integer.parseInt(value.toString());
        }

        @Override
        public Object getNextValue() {
            return value + 1;
        }

        @Override
        public Object getPreviousValue() {
            return Math.max(3, value - 1);
        }
    }

}
