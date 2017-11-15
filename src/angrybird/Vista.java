/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package angrybird;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import Aleatorio.Aleatorio;
import javax.swing.JButton;
import javax.swing.Timer;

/**
 *
 * @author Lenovo
 */
public class Vista extends JFrame implements ActionListener{
    private Timer timer;
    private ControladorTeclas control;
    private Logica logica;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel pajaro;
    private ControladorBotones control2;
    private javax.swing.JLabel cerdo1;
    private javax.swing.JLabel cerdo2;
    private javax.swing.JLabel cerdo4;
    private javax.swing.JLabel cerdo5;
    private javax.swing.JLabel cerdo3;
    private Rectangle[] cerdosR;
    private int tiempo;
    private double velocidad;
    private Rectangle pajaroR;
    private int numero_pajaro;
    private int[] orden;
    private int puntaje;
    private JButton boton1;
    private JButton boton2;
   

    public Vista() {
        Intvista();
    }
    
    public void Intvista(){
        this.orden= new int[5];
        this.orden= Aleatorio.Aleatorio(5, 5);
        this.timer= new Timer(100,this);
        this.control= new ControladorTeclas(this);
        this.control2= new ControladorBotones(this);
        this.logica= new Logica();
        addKeyListener(control);
        
        setFocusable(true);
        
        boton1 = new javax.swing.JButton();
        boton2 = new javax.swing.JButton();
        
        getContentPane().add(boton1);
        getContentPane().add(boton2);
        
        boton1.setVisible(false);
        boton2.setVisible(false);
        
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pajaro = new javax.swing.JLabel();
        pajaroR= new Rectangle();
        this.cerdosR = new Rectangle [5];
        crearcuadro();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setMaximumSize(new java.awt.Dimension(1366, 680));
        setMinimumSize(new java.awt.Dimension(1366, 680));
        setPreferredSize(new java.awt.Dimension(1366, 680));
        setSize(new java.awt.Dimension(1366, 680));
        getContentPane().setLayout(null);

        agregarcerdos();
        agregarpajaro(pajaro, this.orden[this.numero_pajaro], pajaroR);
        
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cauchera.png"))); // NOI18N
        jLabel2.setMaximumSize(new java.awt.Dimension(79, 200));
        jLabel2.setMinimumSize(new java.awt.Dimension(79, 200));
        jLabel2.setPreferredSize(new java.awt.Dimension(79, 200));
        getContentPane().add(jLabel2);
        jLabel2.setBounds(150, 430, 110, 210);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo.png"))); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(1366, 657));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, -15, 1366, 657);
        
        
        
        pack();
    }
    
    
     @Override
    public void actionPerformed(ActionEvent ae) {
        this.tiempo++;
     if (this.numero_pajaro<5){
        jugar();
     } else{
         juegoterminado();
     }
        repaint();
    }
    
    
    public void agregarcerdos(){
        cerdo1 = new javax.swing.JLabel();
        getContentPane().add(cerdo1);
        cerdo1.setBounds(804, 465, 100, 100);
        cerdo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cerdo1.png")));
        this.cerdosR[0]= new Rectangle(); 
        this.cerdosR[0].setBounds(804, 465, 100, 100);
        
        cerdo2 = new javax.swing.JLabel();
        getContentPane().add(cerdo2);
        cerdo2.setBounds(870, 382, 100, 100);
        cerdo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cerdo2.png")));
        this.cerdosR[1]= new Rectangle(); 
        this.cerdosR[1].setBounds(870, 382, 100, 100);
        
        cerdo3 = new javax.swing.JLabel();
        getContentPane().add(cerdo3);
        cerdo3.setBounds(930, 300, 100, 100);
        cerdo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cerdo3.png")));
        this.cerdosR[2]= new Rectangle(); 
        this.cerdosR[2].setBounds(930, 300, 100, 100);
        
        cerdo4 = new javax.swing.JLabel();
        getContentPane().add(cerdo4);
        cerdo4.setBounds(730, 540, 100, 100);
        cerdo4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cerdo4.png")));
        this.cerdosR[3]= new Rectangle(); 
        this.cerdosR[3].setBounds(730, 560, 100, 100);
        
        cerdo5 = new javax.swing.JLabel();
        getContentPane().add(cerdo5);
        cerdo5.setBounds(1060, 230, 100, 100);
        cerdo5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cerdo1.png")));
        this.cerdosR[4]= new Rectangle(); 
        this.cerdosR[4].setBounds(1060, 230, 100, 100);
        
    }
    
   
    
    public void jugar(){

        double posicionX= this.pajaroR.x;
        double posicionY=this.pajaroR.y;
        
        if(fueralimitesfinal() && !tocarcerdoboolfinal())
        moverpajaro(this.pajaro,this.pajaroR);
        else{ if (this.numero_pajaro<4){
            this.tiempo=0;
            this.numero_pajaro++;
            this.pajaro.setBounds(120, 430,100,100);
            this.pajaroR.setBounds( 120, 430,100,100);
            this.pajaro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pajaro"+this.orden[this.numero_pajaro]+".png")));
            
        }else{
            this.numero_pajaro++;
        }
      }
    }
    
    public void agregarpajaro(JLabel pajaro, int numero, Rectangle pajaroR){
        getContentPane().add(pajaro);
        pajaro.setBounds(  120, 430,100, 100);
        pajaro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pajaro"+numero+".png")));
        pajaroR.setBounds( 120, 430, 100, 100);
    }
    
    public void moverpajaro(JLabel pajaro, Rectangle pajaroR){
    
    
        double posicionX=this.logica.posicionenX(this.tiempo,this.logica.velocidad(velocidad, tiempo));
        double posicionY= this.logica.posicionenY(this.tiempo,this.logica.velocidad(velocidad, tiempo));
 
        pajaroR.setLocation((int)posicionX, (int)posicionY);
        pajaro.setBounds((int)posicionX, (int)posicionY, 100, 100);
       
        
    }
    public boolean fueralimites(){
        double posicionX= this.pajaroR.x;
        double posicionY=this.pajaroR.y;
        return posicionX<1366 && posicionY<657;
    }
    
    public boolean fueralimitesfinal(){
        if(fueralimites()){
        return true;
        }else{
        this.timer.stop();
        return false;
        }
    }

    public Timer getTimer() {
        return timer;
    }
    

    
    public boolean tocarcerdobool(){
        boolean ac= false;
        
        for (Rectangle rectangle : cerdosR) {
            ac = ac || this.pajaroR.intersects(rectangle);
        }
          return ac;
          
    }
    
    public boolean tocarcerdoboolfinal(){
        if(!tocarcerdobool()){
            return false;
        }else{
            this.puntaje += 100;
            jLabel6.setText("Puntuacion=  "+ this.puntaje);
            this.timer.stop();
            return true;
        }
    }
    
    
    public boolean siguentepajaro(){
        double posicionX = this.logica.posicionenX(this.tiempo,this.velocidad);
        double posicionY= this.logica.posicionenY(this.tiempo,this.velocidad);
        boolean ac= false;
        ac= tocarcerdobool() && posicionX==1366 && posicionY==657;
        return ac;
    }
    public Logica getLogica() {
        return logica;
    }
    
    public void juegoterminado(){
        
        jLabel3.setVisible(false);
        jLabel4.setVisible(false);
        jLabel5.setVisible(false);
        jLabel1.setVisible(false);
        jLabel2.setVisible(false);
        
        boton1.setVisible(true);
        boton2.setVisible(true);
        jLabel6.setLocation(300, 150);
        jLabel6.setText("Puntiacion final: "+ this.puntaje);
        

        
        boton1.setBounds(500, 300, 200, 50);
        boton2.setBounds(200, 300, 200, 50);
        
        boton1.setActionCommand("boton1");
        boton2.setActionCommand("boton2");
        
        boton1.setText("Finalizar");
        boton2.setText("Volverl a jugar");
        
        boton1.addActionListener(control2);
        boton2.addActionListener(control2);
        jLabel1.setVisible(true);
        jLabel2.setVisible(true);        
        
        
    }



    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    public JLabel getPajaro() {
        return pajaro;
    }

    public Rectangle getPajaroR() {
        return pajaroR;
    }
    
    public void crearcuadro(){
        jLabel3.setFont(new java.awt.Font("Aparajita", 3, 18));
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 40, 200, 50);
        jLabel3.setText("El angulo de tiro es: "+ this.logica.getAngulo());
        
        jLabel4.setFont(new java.awt.Font("Aparajita", 3, 18));
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 70, 200, 50);
        jLabel4.setText("La velocidad inicial es "+ this.velocidad);
        
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setFont(new java.awt.Font("Aparajita", 3, 18));
        getContentPane().add(jLabel5);
        jLabel5.setBounds(10, 10, 1350, 50);
        jLabel5.setText("Utilice las flechas arriba y abajo para cambiar el angulo, las flechas derecha y izquerda para cambiar la velocidad y la barra espaciadora para disparar ");
        
        jLabel6.setFont(new java.awt.Font("Aparajita", 3, 26));
        getContentPane().add(jLabel6);
        jLabel6.setBounds(1200, 40, 200, 50);
        jLabel6.setText("Puntuacion=  "+ this.puntaje);
        
    }
    
    public void texto(){
     
        jLabel3.setText("El angulo de tiro es: "+ this.logica.getAngulo());
        jLabel4.setText("La velocidad inicial es "+ this.velocidad); 
    }

    public JButton getBoton1() {
        return boton1;
    }

    public JButton getBoton2() {
        return boton2;
    }

    public int getNumero_pajaro() {
        return numero_pajaro;
    }

    public void setNumero_pajaro(int numero_pajaro) {
        this.numero_pajaro = numero_pajaro;
    }
    
   
}
