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
public class Link implements LinkH{
    private char c1;
    private char c2;
    private float linkCost;
    public Link(){
        
    }
    public Link(char c1 , char c2 , float linkCost){
        this.c1=c1;
        this.c2=c2;
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
     * @return the c2
     */
    @Override
    public char getC2() {
        return c2;
    }

    /**
     * @param c2 the c2 to set
     */
    @Override
    public void setC2(char c2) {
        this.c2 = c2;
    }

    /**
     * @return the linkCost
     */
    @Override
    public float getLinkCost() {
        return linkCost;
    }

    /**
     * @param linkCost the linkCost to set
     */
    @Override
    public void setLinkCost(float linkCost) {
        this.linkCost = linkCost;
    }
}
