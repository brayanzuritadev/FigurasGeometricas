package proyecto;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;

/**
 *
 * @author Brayan
 */
public class Pizarra extends JPanel implements MouseListener {

    ArrayList<Cuadrado> c = new ArrayList<Cuadrado>();
    boolean b;
    Map m = new Map();
    Remarcador r = new Remarcador();
    int p;
    int x, y;
    int w = 40;
    int h = 40;
    Color color=Color.BLACK;

    public Pizarra(Dimension d) {
        setSize(d);
        setPreferredSize(d);
        setVisible(true);
        addMouseListener(this);
    }

    public void paint(Graphics g) {

        super.paint(g);

       /* c.forEach((objCua) -> {
            objCua.paintCuadrado(g);
        });*/
       for(Cuadrado objCua : c){
           objCua.paintCuadrado(g);
       }
        
        r.remarcarPaint(g);
        //r.reDimensionar(g);
        /*for(int i=0;i<c.size();i++){
            c.get(i).paintCuadrado(g);
        }*/

    }
    
    public void cambiarColor(){
        c.get(p-1).setColor(color);
    }
    
    public String getInfo(){
        return c.get(p-1).getInformacion();
    }

    public void agregarCuadrado() {
        //agregamos la figura a la lista
        c.add(new Cuadrado(x, y, w, h, color));
    }
    
    public void setDimension(int w,int h){
        //borramos la figura del map
        m.borrarMap(c.get(p-1).getX(), c.get(p-1).getY(), c.get(p-1).getW(), c.get(p-1).getH());
        
        //establecemos las nuevas dimensiones
        c.get(p-1).setW(w);
        c.get(p-1).setH(h);
        
        //remarcamos
        r.setH(c.get(p-1).getH());
        r.setW(c.get(p-1).getW());
        r.setX(c.get(p-1).getX());
        r.setY(c.get(p-1).getY());
        
        //agregamos al mapa
        m.agregarMap(c.get(p-1).getX(), c.get(p-1).getY(), w, h, p);
    }

    public void borrarFigura() {
        if (p > 0) {
            //repintamos
            if(p>0){
            repaint();
            }
            //borramos en el map 
            m.borrarMap(c.get(p - 1).getX(), c.get(p - 1).getY(), c.get(p - 1).getW(), c.get(p - 1).getH());

            //removemos  el cuadrado de la lista
            
            c.set(p - 1,new Cuadrado(0, 0, 0, 0, Color.BLACK));
            
            //remarcamos
            r.setH(0);
            r.setW(0);
            r.setX(0);
            r.setY(0);
            
            //regresamos la posicion a 0
            p = 0;
            System.out.println("Borrar");
        }
    }

    public void mouseClicked(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        while (b) {

            agregarCuadrado();
            repaint();
            System.out.println("hola");
            m.agregarMap(x, y, w, h, c.size());
            //m.imprimirMap();
            b = false;
        }
        if (m.getMap()[e.getX()][e.getY()] != 0) {
            p = m.getMap()[e.getX()][e.getY()];
            
            cambiarColor();
            
            //remarcamos
            r.setH(c.get(p-1).getH());
            r.setW(c.get(p-1).getW());
            r.setX(c.get(p-1).getX());
            r.setY(c.get(p-1).getY());
            
            repaint();
            System.out.println("este es numero de elemento " + m.getMap()[e.getX()][e.getY()]);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
    public void setColor(Color color){
        this.color=color;
    }
}
