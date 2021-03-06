/*
 * AlgoElement.java
 *
 * Created on 08-May-2010, 01:41:30
 */

package org.twak.siteplan.junk;

import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.DefaultComboBoxModel;

import org.twak.siteplan.campskeleton.Profile;

/**
 *
 * @author twak
 */
public class AlgoElement extends javax.swing.JPanel
{
    String name;
    Set<Profile> profile;
    Map<String, Profile> mapping;
    
    /** Creates new form AlgoElement */
    public AlgoElement() {
        initComponents();
    }
    public AlgoElement(String name, List<Profile> profile, Map<String, Profile> mapping, Profile selected) {
        this.mapping = mapping;
        this.name = name;
        initComponents();

        DefaultComboBoxModel cm = new DefaultComboBoxModel();

        nameLabel.setText( name );

        for (Profile p : profile)
            cm.addElement( p );

        profileChooser.setModel( cm );
        profileChooser.setSelectedItem( selected == null ? profile.iterator().next() : selected );
        if (mapping.get(name) == null)
            mapping.put (name, (Profile)profileChooser.getSelectedItem());
    }



    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        profileChooser = new javax.swing.JComboBox();
        nameLabel = new javax.swing.JLabel();

        profileChooser.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        profileChooser.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                profileChooserItemStateChanged(evt);
            }
        });

        nameLabel.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(profileChooser, 0, 319, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(profileChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void profileChooserItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_profileChooserItemStateChanged
    {//GEN-HEADEREND:event_profileChooserItemStateChanged
        System.out.println(name+" set to "+ profileChooser.getSelectedItem());
        mapping.put( name, (Profile) profileChooser.getSelectedItem() );
    }//GEN-LAST:event_profileChooserItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel nameLabel;
    private javax.swing.JComboBox profileChooser;
    // End of variables declaration//GEN-END:variables

}
