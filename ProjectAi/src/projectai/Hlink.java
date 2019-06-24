/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectai;

/**
 *
 * @author ALKODS
 */
public class Hlink implements HHLink{
    private char c1;
    private int linkCost;
    public Hlink(){
        
    }
    public Hlink(char c1 , int linkCost){
        this.c1=c1;
        this.linkCost=linkCost;
    }

    /**
     * @return the c1
     */
    @Override
    public char getC1() {
        return c1;
    }

    /**
     * @param c1 the c1 to set
     */
    @Override
    public void setC1(char c1) {
        this.c1 = c1;
    }

    /**
     * @return the linkCost
     */
    @Override
    public int getLinkCost() {
        return linkCost;
    }

    /**
     * @param linkCost the linkCost to set
     */
    @Override
    public void setLinkCost(int linkCost) {
        this.linkCost = linkCost;
    }
    
}
