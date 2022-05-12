/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

/**
 *
 * @author Brayan
 */
public class Map {
    int [][] map; 
    private int x,y,w,h,p;

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setW(int w) {
        this.w = w;
    }
    
    public void setP(int p){
        this.p=p;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int[][] getMap() {
        return map;
    }
    
    public Map(){
        map = new int[300][300];
    }
    
    public void imprimirMap(){
        for(int i = 0; i < map.length ; i++ ){
            for(int j = 0; j < map[i].length ; j++ ){
            System.out.print(map[i][j] + "");
            }
            System.out.println();
        }
    }
    
    public void agregarMap(int x, int y,int w,int h, int p){
        for(int i = 0; i < w ; i++ ){
            for(int j = 0; j < w ; j++ ){
                map[x+i][y+j]=p;
            //System.out.print(map[i][j] + "");
            }
            //System.out.println();
        }
    }
    
    public void borrarMap(int x, int y, int w, int h){
        for(int i = 0; i < w ; i++ ){
            for(int j = 0; j < w ; j++ ){
                map[x+i][y+j]=0;
            //System.out.print(map[i][j] + "");
            }
            //System.out.println();
        }
    }
}
