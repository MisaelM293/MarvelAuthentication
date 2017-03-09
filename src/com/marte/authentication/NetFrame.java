/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marte.authentication;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
/**
 *
 * @author Network Admin
 */
public class NetFrame extends JFrame implements MouseListener,MouseMotionListener{
    
    private final Font LABEL_FONT   =   new Font("Agency FB", Font.PLAIN, 24 );
    private final Color LABEL_COLOR =   new Color(214,214,212);
    
    private Point initialClick;//para el movimiento
    
    
    /**
     * Constructor de clase
     */
    public NetFrame(){
      NetFrame.this.setUndecorated(true);
      initComponents();
      NetFrame.this.setLocationRelativeTo(null);      
      NetFrame.this.addMouseListener(NetFrame.this);
      NetFrame.this.addMouseMotionListener(NetFrame.this);
      
    }
     
    private void initComponents() {                
        setResizable(false);
        NetFrame.this.setBackground(new Color(0,0,0,0));//transparencia total
        
        NetPanel panel = new NetPanel();
        panel.setLayout(null);
        
        //objetos que forman la interfaz
        
        JLabel lbName = new JLabel("USUARIO");
        lbName.setFont(LABEL_FONT);
        lbName.setBounds(80, 80, 340, 32); 
        lbName.setForeground(LABEL_COLOR);
        
        NetTextField userText = new NetTextField();        
        userText.setBounds(80, 120, 340, 36); 
        
        JLabel lbPass = new JLabel("CONTRASEÑA");
        lbPass.setFont(LABEL_FONT);
        lbPass.setBounds(80, 170, 340, 32); 
        lbPass.setForeground(LABEL_COLOR);
        
        NetTextField passText = new NetTextField();        
        passText.setBounds(80, 210, 340, 36); 
        
        //botones
        NetButton btn1 = new NetButton();
        btn1.setText("ACEPTAR");
        btn1.setBounds(80, 260, 120, 36); 
        
        NetButton btn2 = new NetButton();
        btn2.setText("CANCELAR");
        btn2.setBounds(210, 260, 120, 36); 
        
        //listener        
        btn1.addActionListener((ActionEvent e) -> {
            if(userText.getText().equals("MisaelM293") && passText.getText().equals("123456")){
                NetCustomDialog myDialog = new NetCustomDialog(NetFrame.this, true, "Exito: Los datos son correctos");
                 if(myDialog.getAnswer()){
                     /* accion a realizar */
                 }    
            }else{
                NetCustomDialog myDialog = new NetCustomDialog(NetFrame.this, true, "Error: Los datos son incorrectos!");
                 if(myDialog.getAnswer()){
                     /* accion a realizar */
                 }    
            }
        });//btn1
        
        lbName.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null, "Eggs are not supposed to be green.");
            }
        });
        
        
        btn2.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });//btn2
        
        //se añade todo 
        panel.add(lbName);
        panel.add(userText);        
        panel.add(lbPass);
        panel.add(passText);        
        panel.add(btn1);
        panel.add(btn2);
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);        
        getContentPane().add(panel);
        pack();
        
       
    }
    
    public static void main(String args[]){
        EventQueue.invokeLater(() -> {
            new NetFrame().setVisible(true);
        });
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        //obtiene posicion de la ventana
        int thisX = getLocation().x;
        int thisY = getLocation().y;

        //determina el desplazamiento
        int xMoved = (thisX + e.getX()) - (thisX + initialClick.x);
        int yMoved = (thisY + e.getY()) - (thisY + initialClick.y);

        //mueve la ventana a su nueva posicion
        int X = thisX + xMoved;
        int Y = thisY + yMoved;
        this.setLocation(X, Y);
    }

    @Override
    public void mouseMoved(MouseEvent e) {}

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {
        setCursor(new Cursor(Cursor.MOVE_CURSOR));
        initialClick = e.getPoint();
        getComponentAt(initialClick);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}