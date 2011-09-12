/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PlanSpeedWidget.java
 *
 * Created on 24-Aug-2010, 20:02:29
 */

package camp.anchors;

import utils.Loopable;

/**
 *
 * @author twak
 */
public class PlanSpeedWidget extends javax.swing.JPanel {

    NaturalStepUI stepUI;
    Loopable<Double> speed;

    final static double sliderMax = 150;

    /** Creates new form PlanSpeedWidget */
    public PlanSpeedWidget() {
        initComponents();
    }

    public PlanSpeedWidget(NaturalStepUI stepUI, Loopable<Double> speed)
    {
        this.stepUI = stepUI;
        this.speed = speed;
        initComponents();
        updateSlider();
        updateField();
    }


    boolean dontFire = false;

    private void updateSlider()
    {
        dontFire = true;
        try
        {
            int val = (int)((-speed.get() / (double)sliderMax) *
                (speedScrollBar.getMaximum()-speedScrollBar.getMinimum()));
            System.out.println("value is "+val);
            speedScrollBar.setValue(val);
        }
        finally
        {
            dontFire = false;
        }
    }

    private void updateField()
    {
        dontFire = true;
        try
        {
            field.setText(speed.get() + "");
        } finally
        {
            dontFire = false;
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        speedScrollBar = new javax.swing.JScrollBar();
        field = new javax.swing.JTextField();

        speedScrollBar.setMaximum(1500);
        speedScrollBar.setMinimum(-1500);
        speedScrollBar.setOrientation(javax.swing.JScrollBar.HORIZONTAL);
        speedScrollBar.setToolTipText("growth speed");
        speedScrollBar.setUnitIncrement(5);
        speedScrollBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                speedScrollBarMouseClicked(evt);
            }
        });
        speedScrollBar.addAdjustmentListener(new java.awt.event.AdjustmentListener() {
            public void adjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {
                speedScrollBarAdjustmentValueChanged(evt);
            }
        });

        field.setText("jTextField1");
        field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(speedScrollBar, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(field, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(speedScrollBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void speedScrollBarAdjustmentValueChanged(java.awt.event.AdjustmentEvent evt)//GEN-FIRST:event_speedScrollBarAdjustmentValueChanged
    {//GEN-HEADEREND:event_speedScrollBarAdjustmentValueChanged

        if (dontFire)
            return;
        
        double value = (-speedScrollBar.getValue()*sliderMax/(speedScrollBar.getMaximum() - speedScrollBar.getMinimum()) );
        speed.set(value);

        updateField();

        stepUI.skeletonCalculator.changed();
        stepUI.repaint();
//        System.out.println("speed is "+speed.get());
    }//GEN-LAST:event_speedScrollBarAdjustmentValueChanged

    private void speedScrollBarMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_speedScrollBarMouseClicked
    {//GEN-HEADEREND:event_speedScrollBarMouseClicked
        if (evt.getClickCount() == 2)
            speedScrollBar.setValue(0);
        speedScrollBarAdjustmentValueChanged(null);
    }//GEN-LAST:event_speedScrollBarMouseClicked

    private void fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldActionPerformed
        if (dontFire)
            return;

        speed.set(Double.parseDouble(field.getText()));

        updateSlider();
        
        stepUI.skeletonCalculator.changed();
        stepUI.repaint();
    }//GEN-LAST:event_fieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField field;
    private javax.swing.JScrollBar speedScrollBar;
    // End of variables declaration//GEN-END:variables
}
