/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package angrybird;

/**
 *
 * @author Lenovo
 */
public class Logica {
    private double posicioninicialX;
    private double posicioninicialY;
    private int angulo;

    public Logica() {
        this.posicioninicialX = 120;
        this.posicioninicialY =430;
    }
    
    
    public double posicionenX(int tiempo, double velocidad){
        double b = this.posicioninicialX+ velocidad*Math.cos(Math.toRadians(this.angulo))*tiempo;
        return b;
    }
    
     public double posicionenY(int tiempo, double velocidad){
        double b= this.posicioninicialY-velocidad*Math.sin(Math.toRadians(this.angulo))*tiempo + 4.9* Math.pow(tiempo,2);
        return b;
    }
    
    public double velocidad (double velocidad, int tiempo){
        double b= velocidad*Math.cos(Math.toRadians(this.angulo))-9.8*tiempo;
        return b;
    } 

    public double getPosicioninicialX() {
        return posicioninicialX;
    }

    public void setPosicioninicialX(double posicioninicialX) {
        this.posicioninicialX = posicioninicialX;
    }

    public double getPosicioninicialY() {
        return posicioninicialY;
    }

    public void setPosicioninicialY(double posicioninicialY) {
        this.posicioninicialY = posicioninicialY;
    }

    public int getAngulo() {
        return angulo;
    }

    public void setAngulo(int angulo) {
        this.angulo = angulo;
    }
     
}
