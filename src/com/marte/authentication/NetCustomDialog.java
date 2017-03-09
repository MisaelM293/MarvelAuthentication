/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marte.authentication;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JDialog; 
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
/**
 *
 * @author Network Admin
 */
public class NetCustomDialog extends JDialog implements ActionListener {
    
    private NetButton okButton = null;    
    private boolean answer = false;
    
    /**
     * Constructor de clase
     * @param frame
     * @param modal
     * @param message
     */
    public NetCustomDialog(JFrame frame, boolean modal, String message) {        
        super(frame, modal);
        NetCustomDialog.this.setPreferredSize( new Dimension(400,60));
        NetCustomDialog.this.setUndecorated(true);
        GridBagConstraints gridBagConstraints;
        
        JPanel myPanel = new JPanel();
        myPanel.setPreferredSize(new Dimension(500,100));
        myPanel.setBorder(BorderFactory.createLineBorder(new Color(119,232,228), 2));
        myPanel.setBackground(new Color(0,0,0));
        myPanel.setLayout(new GridBagLayout());
        
        NetCustomDialog.this.getContentPane().add(myPanel);        
        
        JLabel lbMsg = new JLabel(message);
        lbMsg.setForeground(new Color(255,255,255));
        lbMsg.setOpaque(false);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 20);
        myPanel.add(lbMsg,gridBagConstraints);
        
        okButton = new NetButton();
        okButton.setText("OK");
        okButton.setPreferredSize(new Dimension(80,34));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        myPanel.add(okButton,gridBagConstraints);           
        
        //listener
        NetCustomDialog.this.okButton.addActionListener(NetCustomDialog.this);        
              
        NetCustomDialog.this.pack();
        NetCustomDialog.this.setLocationRelativeTo(frame);
        NetCustomDialog.this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(okButton == e.getSource()) {
            answer = true;
            setVisible(false);
        }        
    }
    
    public boolean getAnswer() { return answer; }
}
