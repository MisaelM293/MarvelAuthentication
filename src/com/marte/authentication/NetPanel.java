/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marte.authentication;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.TexturePaint;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
/**
 *
 * @author Network Admin
 */
public class NetPanel extends JPanel{
    
    private final Dimension dimension   =   new Dimension(500,400);    
    private final Image image           =   new ImageIcon(getClass().
                                            getResource("/com/marte/authentication/resource/boxnet.png")).getImage();
    private final Image logo            =   new ImageIcon(getClass().
                                            getResource("/com/marte/authentication/resource/shield.png")).getImage();
    private BufferedImage bufferedImage;    
    
    /**
     * Constructor de clase
     */
    public NetPanel(){
        super();        
        bufferedImage = imageToBI(image);              
        //tamaño del panel
        NetPanel.this.setSize(dimension);
        NetPanel.this.setPreferredSize(dimension);
    }
    
    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2 =(Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);            
        
        //coordenadas de la figura principal
        int x1Points[] = {25,290,318,399,404,497,497,480,480,497,497,105,59,25,3,3,25,25,3,3};  
        int y1Points[] = {3,3,30,30,25,25,72,89,143,170,350,350,396,396,375,221,199,71,49,25};
        
        GeneralPath polygonPrincipal = new GeneralPath(GeneralPath.WIND_EVEN_ODD,x1Points.length);                 
        polygonPrincipal.moveTo(x1Points[0], y1Points[0]); 
        for(int i=0;i<x1Points.length;i++){
            polygonPrincipal.lineTo(x1Points[i], y1Points[i]);     
        }
        polygonPrincipal.closePath();
        
        //transparencia del jpanel
        g2.setComposite(AlphaComposite.getInstance(
            AlphaComposite.SRC_OVER, 0.8f));
        
        //se cargan las texturas
        TexturePaint paint = new TexturePaint( bufferedImage,
                new Rectangle2D.Double( 0, 0, bufferedImage.getWidth(), bufferedImage.getHeight() ) );                
        
        //pinta cuerpo y borde del panel
        g2.setPaint(paint);
        g2.fill( polygonPrincipal );        
        g2.setColor( new Color(119,232,228) );
        g2.setStroke(new BasicStroke( 3 ));
        g2.draw( polygonPrincipal );
        
        //panel rectangular central
        Polygon panelCentral = new Polygon();
        panelCentral.addPoint( 40, 40 );
        panelCentral.addPoint( 460, 40 );
        panelCentral.addPoint( 460, 340 );
        panelCentral.addPoint( 40, 340 );        
        g2.setPaint(new GradientPaint(0, 0, new Color(18,62,69,240), 460, 0, new Color(0,2,6,220)));
        g2.fill( panelCentral );
        
        //bordes panel central
        g2.setStroke(new BasicStroke( 1 ));
        g2.setColor( new Color(221,0,1) );
        g2.draw(panelCentral );
        //esquinas
        g2.setStroke(new BasicStroke( 3 ));
        
        g2.drawLine(40, 40, 50, 40);
        g2.drawLine(40, 40, 40, 50);
        
        g2.drawLine(460, 40, 450, 40);
        g2.drawLine(460, 40, 460, 50);
        
        g2.drawLine(460, 340, 460, 330);
        g2.drawLine(460, 340, 450, 340);
        
        g2.drawLine(40, 340, 50, 340);
        g2.drawLine(40, 340, 40, 330);
        
        //logo jc mouse :) 
        g2.drawImage(logo, 367, 256, 80, 80, null);    
    }
    
    /**
     * dado un image retorna un BufferedImage
     * @param img Image
     * @return BufferedImage
     */
    private BufferedImage imageToBI(Image img){          
        BufferedImage bi = new BufferedImage(img.getWidth(null), img.getHeight(null),BufferedImage.TYPE_INT_RGB);
        Graphics g = bi.createGraphics();
        g.drawImage(img, 0, 0, null);
        g.dispose();
        return bi;
    }
    
}//NetPanel
