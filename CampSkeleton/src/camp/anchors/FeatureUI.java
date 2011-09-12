/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FeatureList.java
 *
 * Created on 24-Jun-2010, 09:58:19
 */

package camp.anchors;

import campskeleton.CampSkeleton;
import campskeleton.Plan;
import campskeleton.PlanSkeleton;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.DefaultListModel;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.Popup;
import javax.swing.PopupFactory;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import utils.DuckTypeAlphabetComparator;
import utils.WeakListener;

/**
 *
 * @author twak
 */
public class FeatureUI extends javax.swing.JPanel {

    Plan plan;

    WeakListener rebuildShipPanel = new WeakListener();

    boolean fireFeatureEvents = true;

    WeakListener.Changed shipChanged = new WeakListener.Changed() {

            @Override
            public void changed() {
                if (ship != null) {
                    shipPanel.removeAll();
                    shipPanel.add(new ShipUI(ship, FeatureUI.this));
                    shipPanel.revalidate();
                    shipPanel.repaint();
                }
            }
        };

    WeakListener.Changed rebuildFeatureList = new WeakListener.Changed() {

        @Override
        public void changed()
        {
            setupFeatureList( false );
        }
    };

    Ship ship = null;

    /** Creates new form FeatureList */
    public FeatureUI( Plan ps )
    {
        this.plan = ps;

        initComponents();

        setupFeatureList( true );

        rebuildShipPanel.add(shipChanged);
    }

    void removeShip(Ship ship) {
        plan.ships.remove(ship);
        shipOptionsPanel.removeAll();
        shipPanel.removeAll();
        setupFeatureList( true );
    }

    private class TwoString
    {
        String a,b;
        TwoString (String a, String b)
        {
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString() {
            return a;
        }
    }


    private void addFeature(String className)
    {
        Ship neu = Ship.createAShip(className);
        plan.ships.add( neu );
        setupFeatureList( true );
        shipList.setSelectedValue(neu, true);
    }

    void setupFeatureList( boolean fireEvents )
    {
        if (!fireEvents)
            fireFeatureEvents = false;

        Object o = shipList.getSelectedValue();

        CampSkeleton.instance.nowSelectingFor(null);
        CampSkeleton.instance.highlightFor(new ArrayList<Anchor>());
        DefaultListModel lm = new DefaultListModel();
        Collections.sort(plan.ships, DuckTypeAlphabetComparator.byToString());

        for (Ship i : plan.ships)
            lm.addElement( i );

        shipList.setModel(lm);

        shipList.setSelectedValue(o, true);

        fireFeatureEvents = true;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        newFeatureButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        shipList = new javax.swing.JList();
        shipOptionsPanel = new javax.swing.JPanel();
        noOptionPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        shipPanel = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();

        newFeatureButton.setText("+");
        newFeatureButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                newFeatureButtonMousePressed(evt);
            }
        });

        shipList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                shipListMouseClicked(evt);
            }
        });
        shipList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                shipListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(shipList);

        shipOptionsPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        shipOptionsPanel.setLayout(new java.awt.GridLayout(1, 0));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("[no options]");

        javax.swing.GroupLayout noOptionPanelLayout = new javax.swing.GroupLayout(noOptionPanel);
        noOptionPanel.setLayout(noOptionPanelLayout);
        noOptionPanelLayout.setHorizontalGroup(
            noOptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(noOptionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                .addContainerGap())
        );
        noOptionPanelLayout.setVerticalGroup(
            noOptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(noOptionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                .addContainerGap())
        );

        shipOptionsPanel.add(noOptionPanel);

        shipPanel.setLayout(new java.awt.GridLayout(1, 0));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("features");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(newFeatureButton, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
            .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
            .addComponent(shipOptionsPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
            .addComponent(shipPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(1, 1, 1)
                .addComponent(newFeatureButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(shipOptionsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(shipPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void shipListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_shipListValueChanged
        if (fireFeatureEvents)
        {
            ship = (Ship) shipList.getSelectedValue();

            shipOptionsPanel.removeAll();
            shipPanel.removeAll();

            if (ship != null)
            {
                JComponent comp = ship.getToolInterface(rebuildShipPanel, rebuildFeatureList, plan);
                shipOptionsPanel.add(comp == null ? noOptionPanel : comp);
                shipPanel.add(new ShipUI(ship, this));
                shipPanel.revalidate();
            }
        }
    }//GEN-LAST:event_shipListValueChanged

    private void newFeatureButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newFeatureButtonMousePressed

        DefaultListModel lm = new DefaultListModel();
        for (String s[] : PlanSkeleton.getShipTypes()) {
            lm.addElement(new TwoString(s[1], s[0]));
        }

        final JList list = new JList(lm);
        list.setBorder(new LineBorder(Color.black, 2));

        Point pt = evt.getPoint();
        SwingUtilities.convertPointToScreen( pt, newFeatureButton );

        final Popup pop = PopupFactory.getSharedInstance().getPopup( this, list, pt.x, pt.y );//pt.x + CampSkeleton.instance.getX(), pt.y + CampSkeleton.instance.getY());
        pop.show();

        list.addMouseListener( new MouseAdapter() {
            @Override
            public void mouseExited( MouseEvent e )
            {
                pop.hide();
            }
        });

        list.getSelectionModel().addListSelectionListener( new ListSelectionListener()
        {
            @Override
            public void valueChanged( ListSelectionEvent e )
            {
                Object o = list.getSelectedValue();
                if (o != null && o instanceof TwoString)
                {
                    // adds to plan!
                    addFeature ( ((TwoString)o).b );
                }
                pop.hide();
            }
        });
    }//GEN-LAST:event_newFeatureButtonMousePressed

    private void shipListMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_shipListMouseClicked
    {//GEN-HEADEREND:event_shipListMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON3 )
        {
             JPopupMenu popup = new JPopupMenu();
//            JMenu menu = new JMenu("type:");
//            popup.add(menu);

            JMenuItem rel = new JMenuItem("clone");
//            popup.add(rel);

            rel.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e)
                {
                    Ship ship = (Ship) shipList.getSelectedValue();
                    if (ship != null)
                    {
                        Ship neu = ship.clone(plan);
                        plan.ships.add(neu);
                        setupFeatureList(true);
                        shipList.setSelectedValue(neu, true);
                    }
                }
            });

            popup.add(rel);

            rel = new JMenuItem("delete");

            rel.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    Ship ship = (Ship) shipList.getSelectedValue();
                    if (ship != null)
                    {
                        removeShip(ship);
                        CampSkeleton.instance.showRoot();
                    }
                }
            });
            popup.add(rel);

            popup.show(this, evt.getX(), evt.getY()+popup.getPreferredSize().height);
        }
    }//GEN-LAST:event_shipListMouseClicked



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton newFeatureButton;
    private javax.swing.JPanel noOptionPanel;
    private javax.swing.JList shipList;
    private javax.swing.JPanel shipOptionsPanel;
    private javax.swing.JPanel shipPanel;
    // End of variables declaration//GEN-END:variables

}
