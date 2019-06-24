/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectai;

import java.util.ArrayList;

/**
 *
 * @author ALKODS
 */
public interface HNode {

    public char getName();

    public void setName(char name);

    public Node getpParent();

    public void setpParent(Node pParent);

    public Node getpNext();

    public void setpNext(Node pNext);

    public float getCost();

    public void setCost(float cost);

    public boolean isExplored();

    public void setExplored(boolean explored);

    boolean isGoal(char goalCity);

    public void Expand(ArrayList<Link> links, List frontier, String type, ArrayList<Hlink> hlink);

    public Node pushnode(ArrayList<Node> list, List frontier, Node perentnode, String text, ArrayList<Hlink> hlink);

    public Node isqualifiedDepth(ArrayList<Node> list, Node perentnode);

    public Node isqualifiedCheapest(ArrayList<Node> list);

    public Node isqualifiedAstar(ArrayList<Node> list, Node perentnode, ArrayList<Hlink> hlink);
    
    public Node isqualifiedGready(ArrayList<Node> list, Node perentnode, ArrayList<Hlink> hlink);

}
