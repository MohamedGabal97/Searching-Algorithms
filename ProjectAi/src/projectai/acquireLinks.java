/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectai;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ALKODS
 */
public class acquireLinks implements HacquireLinks{

    /**
     * @param links
     * @return
     */
    @Override
    public ArrayList<Link> acquireLinks(ArrayList <Link> links){
        try {
            File x = new File("E:\\CS\\Level 3\\2\\AI\\m.txt");
            
            Scanner in = new Scanner(x);
            while(in.hasNext()){
                String line=in.next();
                char a=line.charAt(0);
                char b=line.charAt(1);
                int value=Integer.valueOf(line.charAt(2)+"");
                links.add(new Link(a,b,value));
                
            }
            return links;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(acquireLinks.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    @Override
    public  ArrayList<Hlink> acquireLink(ArrayList <Hlink> link) {
        try {
            File h = new File("E:\\CS\\Level 3\\2\\AI\\he.txt");
            Scanner hin = new Scanner(h);
            while(hin.hasNext()){
                String line=hin.next();
                char a=line.charAt(0);
                int value=Integer.valueOf(line.charAt(1)+"");
                link.add(new Hlink(a,value));
                
            }
            return link;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(acquireLinks.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static void main(String[] args) throws FileNotFoundException, Throwable {
        // TODO code application logic here
        acquireLinks a =new acquireLinks();
        String model = null;
        Scanner in = new Scanner(System.in);
        System.out.println("1-cheapest");
        System.out.println("2-depth");
        System.out.println("3-Astar");
        System.out.println("4-Gready");
        System.out.println("5-Breadth");
        int type=in.nextInt();
        switch (type) {
            case 1:
                model="cheapest";
                break;
            case 2:
                model="depth";
                break;
            case 3:
                model="astar";
                break;
            case 4:
                model="Gready";
                        break;
            case 5:
                model="Breadth";
                        break;
            default:
                break;
        }
        ArrayList<Link> list = new ArrayList<>();
        a.acquireLinks(list);
        ArrayList<Hlink> lists = new ArrayList<>();
        a.acquireLink(lists);
        Node fn = new Node('a' , null ,null , 0 ,true);
        Node ln = new Node('g' , null ,null , 0 ,false);
        List l = new List(fn ,ln);
        Node n = new Node();
        n.Expand(list, l ,model , lists);
    }
    
}
