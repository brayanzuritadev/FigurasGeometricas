/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

/**
 *
 * @author Brayan
 */
public class Cuadrado {
    
    private int x;
    private int y;
    private int w;
    private int h;
    private Color color;
    private static int id;
    private int[][] mapPixeles = new int[700][500];

    /**
     *  (x,y)
     *    |------------| -
     *    |            | |
     *    |            | h 
     *    |            | |
     *    |------------| -
     *          w
     */
    Cuadrado(int x, int y, int w, int h,Color color)
    {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.color=color;
        id++;
    }

    Cuadrado() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void paintCuadrado(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, w, h);
        //remarcarCuadrado(g);
       
    }
    
    public String getInformacion(){
         String info = "El Cuadro selecionado es el numero : " + id + "\n" +"Su lados miden : " + w +"\n" +" Su color es : "+"RGB ["+color.getRed()+","+color.getGreen()+","+color.getBlue()+"]" +"\n"+"Sus vertices estan : " 
                 +"\n"+"vertice 1 "+"["+ x + " , "+y +"]" + ", " +"\n"+"vertice 2 "+"["+ (x+w) + " , "+y +"]" + ", " +"\n"+"vertice 3 "
                 +"["+ (x+w) + " , "+(y+h) +"]" + ", "+"\n"+"vertice 4 "+"["+ x + " , "+(y+h) +"]";
         return info; 
    }
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }
    
    public int getId(){
        return id;
    }
    
    public Color getColor(){
        return color;
    }
    
    public void setColor(Color color){
        this.color=color;
    }
}
