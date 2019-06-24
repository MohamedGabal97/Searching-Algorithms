/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectai;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ALKODS
 */
public class Node implements HNode {

    private char name;
    private Node pParent;
    private Node pNext;
    private float cost;
    private boolean explored;

    //protected Node head;
    //protected Node tail;
    Node() {
        this.explored = false;
    }

    Node(char name, Node pParent, Node pNext, float cost, boolean explored) {
        this.name = name;
        this.pParent = pParent;
        this.pNext = pNext;
        this.cost = cost;
        this.explored = explored;
    }

    /**
     * @return the name
     */
    @Override
    public char getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    @Override
    public void setName(char name) {
        this.name = name;
    }

    /**
     * @return the pParent
     */
    @Override
    public Node getpParent() {
        return pParent;
    }

    /**
     * @param pParent the pParent to set
     */
    @Override
    public void setpParent(Node pParent) {
        this.pParent = pParent;
    }

    /**
     * @return the pNext
     */
    @Override
    public Node getpNext() {
        return pNext;
    }

    /**
     * @param pNext the pNext to set
     */
    @Override
    public void setpNext(Node pNext) {
        this.pNext = pNext;
    }

    /**
     * @return the cost
     */
    @Override
    public float getCost() {
        return cost;
    }

    /**
     * @param cost the cost to set
     */
    @Override
    public void setCost(float cost) {
        this.cost = cost;
    }

    /**
     * @return the explored
     */
    @Override
    public boolean isExplored() {
        return explored;
    }

    /**
     * @param explored the explored to set
     */
    @Override
    public void setExplored(boolean explored) {
        this.explored = explored;
    }

    @Override
    public boolean isGoal(char goalCity) {
        return this.name == goalCity;
    }

    /**
     *
     * @param links
     * @param frontier
     * @param type
     * @param hlink
     */
    @Override
    public void Expand(ArrayList<Link> links, List frontier, String type, ArrayList<Hlink> hlink) {

        String str = type;
        ArrayList<Node> list = new ArrayList<>();
        float valuecost;
        Node node = null;
        Node n = null;
        int goalIsExist = 0, found = 0, addnode = 0;
        int size = links.size();
        node = frontier.getpFirstNode();
        list.add(new Node(node.getName(), node.getpParent(), node.getpNext(), node.getCost(), node.isExplored()));
        for (int g = 0; g < size; g++) {
            addnode = 0;
            for (int i = 0; i < size; i++) {
                n = node;
                valuecost = n.getCost();

                if (n.getName() == frontier.getpFirstNode().getName() && n.getName() == frontier.getpLastNode().getName()) {
                    goalIsExist = 1;
                    break;
                } else if (n.getName() == frontier.getpLastNode().getName()) {
                    frontier.setpLastNode(n);
                    goalIsExist = 1;
                    break;
                } //add node 
                else if (n.getName() == links.get(i).getC1() || n.getName() == links.get(i).getC2()) {

                    if (n.getName() == links.get(i).getC1()) {
                        if (list.size() > 0) {
                            found = 0;
                            for (int j = 0; j < list.size(); j++) {
                                if (links.get(i).getC2() == list.get(j).getName()) { //->b [list]
                                    if (list.get(j).isExplored() == true) {
                                        //city is explored in list 
                                    } else {
                                        if (type.equals("depth")) {

                                        } else if ("astar".equals(type)) {

                                        } else if ("Gready".equals(type)) {

                                        }else if ("Breadth".equals(type)) {

                                        } 
                                        else if (type.equals("cheapest")) {
                                            //comper cost to get low cost of noode
                                            //add node exist in list and new cost
                                            links.get(i).setLinkCost(valuecost + links.get(i).getLinkCost());
                                            if (links.get(i).getLinkCost() < list.get(j).getCost()) {
                                                list.remove(j);
                                                list.add(new Node(links.get(i).getC1(), n, null, links.get(i).getLinkCost(), false));

                                            }
                                        }

                                    }
                                    found = 1;
                                    j = list.size();
                                }
                            }
                            if (found == 0) {// the city (b) is not fount in list
                                links.get(i).setLinkCost(valuecost + links.get(i).getLinkCost());
                                list.add(new Node(links.get(i).getC2(), n, null, links.get(i).getLinkCost(), false));
                                addnode = 1;
                            }
                        }
                        continue;
                    } else if (n.getName() == links.get(i).getC2()) {
                        if (list.size() > 0) {
                            found = 0;
                            for (int j = 0; j < list.size(); j++) {
                                if (links.get(i).getC1() == list.get(j).getName()) { // city --> [list]

                                    if (list.get(j).isExplored() == true) {
                                        //city is explored in list 
                                    } else {

                                        if ("depth".equals(type)) {

                                        } else if ("astar".equals(type)) {

                                        } else if ("Gready".equals(type)) {

                                        }else if ("Breadth".equals(type)) {

                                        }
                                        
                                        else if (type.equals("cheapest")) {
                                            //comper cost to get low cost of noode
                                            //add node exist in list and new cost
                                            links.get(i).setLinkCost(valuecost + links.get(i).getLinkCost());
                                            if (links.get(i).getLinkCost() < list.get(j).getCost()) {
                                                list.remove(j);
                                                list.add(new Node(links.get(i).getC1(), n, null, links.get(i).getLinkCost(), false));

                                            }
                                        }
                                    }
                                    found = 1;
                                    j = list.size();
                                }
                            }
                            if (found == 0) {// the city is not fount in list
                                links.get(i).setLinkCost(valuecost + links.get(i).getLinkCost());
                                list.add(new Node(links.get(i).getC1(), n, null, links.get(i).getLinkCost(), false));
                                addnode = 1;
                            }
                        }
                        continue;

                    } else {
                    }
                } else {
                }
            }
            if (addnode == 0) {
                n = n.getpParent();
            }

            if (goalIsExist == 0) {
                try {
                    node = pushnode(list, frontier, n, str, hlink);
                } catch (Throwable ex) {
                    Logger.getLogger(Node.class.getName()).log(Level.SEVERE, null, ex);
                }
                n = node;
            } else {
                g = links.size();
            }
            frontier.printList();
            
        }
        frontier.printResult();
    }

    int x = 1;

    @Override
    public Node pushnode(ArrayList<Node> list, List frontier, Node perentnode, String text, ArrayList<Hlink> hlink) {
        try {
            Node node = null;
            if (null != text) {
                switch (text) {
                    case "depth":
                        node = isqualifiedDepth(list, perentnode);
                        break;
                    case "cheapest":
                        node = isqualifiedCheapest(list);
                        break;
                    case "astar":
                        node = isqualifiedAstar(list, perentnode, hlink);
                        break;
                        
                    case "Gready":
                        node =isqualifiedGready(list, perentnode, hlink);
                        break; 
                    case "Breadth":
                        node =isqualifiedBreadth(list);
                        break;
                    default:
                        break;
                }
            }
            Node no = frontier.getpFirstNode();

            for (;;) {
                if (no.getpNext() == null) {
                    if (x == 1) {
                        frontier.getpFirstNode().setpNext(node);
                        x = 0;
                        break;
                    } else {
                        no.setpNext(node);
                        break;
                    }
                }
                no = no.getpNext();
            }
            return node;
        } catch (Throwable ex) {
            Logger.getLogger(Node.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    @Override
    public Node isqualifiedDepth(ArrayList<Node> list, Node perentnode) {
        Node n = null;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getpParent() == perentnode && list.get(i).isExplored() == false) {
                list.get(i).setExplored(true);
                n = new Node(list.get(i).getName(), list.get(i).getpParent(), null, list.get(i).getCost(), true);

                break;
            }
        }
        return n;
    }

    @Override
    public Node isqualifiedCheapest(ArrayList<Node> list) {

        ArrayList<Node> list1 = new ArrayList<>();
        float tempcost;
        int index = 0;
        Node n = null;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isExplored() == false) {
                list1.add(new Node(list.get(i).getName(), list.get(i).getpParent(), null, list.get(i).getCost(), false));
            }
        }

        tempcost = list1.get(0).getCost();
        for (int i = 0; i < list1.size(); i++) {
            if (tempcost >= list1.get(i).getCost()) {
                tempcost = list1.get(i).getCost();
                index = i;
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName() == list1.get(index).getName()) {
                list.get(i).setExplored(true);
                break;
            }
        }
        n = new Node(list1.get(index).getName(), list1.get(index).getpParent(), null, list1.get(index).getCost(), true);
        list1.removeAll(list1);
        return n;

    }

    @Override
    public Node isqualifiedGready(ArrayList<Node> list, Node perentnode, ArrayList<Hlink> hlink) {
        ArrayList<Node> list1 = new ArrayList<>();
        ArrayList<Node> h = new ArrayList<>();
        float tempcost;
        int index = 0;
        Node n = null;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getpParent() == perentnode && list.get(i).isExplored() == false) {
                list1.add(new Node(list.get(i).getName(), list.get(i).getpParent(), null, list.get(i).getCost(), list.get(i).isExplored()));

            }
        }

        for (int j = 0; j < list1.size(); j++) {
            for (int i = 0; i < hlink.size(); i++) {

                if (list1.get(j).getName() == hlink.get(i).getC1()) {
                    System.out.println(hlink.get(i).getC1());
                    h.add(new Node('0', null, null, hlink.get(i).getLinkCost(), false));
                }
            }

        }
        tempcost = h.get(0).getCost();
        for (int i = 0; i < list1.size(); i++) {
            if (tempcost >= h.get(i).getCost()) {
                tempcost = h.get(i).getCost();
                index = i;
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName() == list1.get(index).getName()) {
                list.get(i).setExplored(true);
            }
        }
        n = new Node(list1.get(index).getName(), list1.get(index).getpParent(), null, list1.get(index).getCost(), true);

        list1.removeAll(list1);
        h.removeAll(h);
        return n;

    }

    @Override
    public Node isqualifiedAstar(ArrayList<Node> list, Node perentnode, ArrayList<Hlink> hlink) {
        ArrayList<Node> list1 = new ArrayList<>();
        ArrayList<Node> h = new ArrayList<>();
        float tempcost;
        float total = 0;
        int index = 0;
        Node n = null;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getpParent() == perentnode && list.get(i).isExplored() == false) {
                list1.add(new Node(list.get(i).getName(), list.get(i).getpParent(), null, list.get(i).getCost(), list.get(i).isExplored()));
                
            }
        }
        
        for (int j = 0; j < list1.size(); j++) {
            total=0;
            for (int i = 0; i < hlink.size(); i++) {

                if (list1.get(j).getName() == hlink.get(i).getC1()) {
                    total=hlink.get(i).getLinkCost()+list1.get(j).getCost();
                    h.add(new Node('0', null, null, total, false));
                }
            }

        }
        tempcost = h.get(0).getCost();
        for (int i = 0; i < list1.size(); i++) {
            if (tempcost >= h.get(i).getCost()) {
                tempcost = h.get(i).getCost();
                index = i;
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName() == list1.get(index).getName()) {
                list.get(i).setExplored(true);
            }
        }
        n = new Node(list1.get(index).getName(), list1.get(index).getpParent(), null, list1.get(index).getCost(), true);
        list1.removeAll(list1);
        h.removeAll(h);
        return n;

    }
    public Node isqualifiedBreadth(ArrayList<Node> list) {
        ArrayList<Node> list1 = new ArrayList<>();
        Node n = null;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isExplored() == false) {
                list.get(i).setExplored(true);
                n = new Node(list.get(i).getName(), list.get(i).getpParent(), null, list.get(i).getCost(), true);

                break;
            }
        }
        return n;
    }

}
