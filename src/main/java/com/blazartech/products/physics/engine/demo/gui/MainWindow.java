/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MainWindow.java
 *
 * Created on Oct 7, 2010, 3:24:34 PM
 */

package com.blazartech.products.physics.engine.demo.gui;

import java.awt.EventQueue;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;

/**
 *
 * @author aar1069
 */
public class MainWindow extends JFrame {

    /** Creates new form MainWindow */
    public MainWindow() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        demoPanel = new com.blazartech.products.physics.engine.demo.gui.DemoPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout demoPanelLayout = new javax.swing.GroupLayout(demoPanel);
        demoPanel.setLayout(demoPanelLayout);
        demoPanelLayout.setHorizontalGroup(
            demoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        demoPanelLayout.setVerticalGroup(
            demoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        getContentPane().add(demoPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.blazartech.products.physics.engine.demo.gui.DemoPanel demoPanel;
    // End of variables declaration//GEN-END:variables

    public DemoPanel getDemoPanel() { return demoPanel; }

    private class UpdateDemoPanelTask extends TimerTask {

        @Override
        public void run() {
            getDemoPanel().repaint();
        }

    }

    private Timer timer = new Timer("demoUpdateTimer");

    public void showDemo() {
        timer.scheduleAtFixedRate(new UpdateDemoPanelTask(), 0, 200);
    }

    public void stopDemo() {
        timer.cancel();
    }
}
