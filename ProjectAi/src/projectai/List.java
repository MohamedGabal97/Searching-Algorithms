package projectai;

/**
 *
 * @author ALKODS
 */
public class List implements HList{
    private Node pFirstNode;
    private Node pLastNode;
    protected Node head;
    protected Node tail;
    List(){
        
    }
    List(Node pFirstNode , Node pLastNode){
        this.pFirstNode=pFirstNode;
        this.pLastNode=pLastNode;
    }
    @Override
    public void printList(){
        
        System.out.println("this is the list");
        Node n = pFirstNode;
        int num=0;
        for(;;){
            if(n == null){
                break;
            }
            else{
                if(n != null){
                    System.out.print("city "+n.getName());
                    System.out.print(" cost "+n.getCost());
                    //System.out.print(" perent "+n.getpParent().getName());
                    System.out.println(" explored "+n.isExplored());
                    n=n.getpNext();
                }
            }
        }
    }
    @Override
    public void printResult(){
        System.out.println("this is the result");
        Node n = pLastNode;
        int num=0;
        for(;;){
            if(n == null){
                break;
            }
            else{
                if(n != null){
                    System.out.print("city "+n.getName());
                    System.out.print(" cost "+n.getCost());
                    //System.out.print(" perent "+n.getpParent().getName());
                    System.out.println(" explored "+n.isExplored());
                    n=n.getpParent();
                }
            }
        }
    }

    /**
     * @return the pFirstNode
     */
    @Override
    public Node getpFirstNode() {
        return pFirstNode;
    }

    /**
     * @param pFirstNode the pFirstNode to set
     */
    @Override
    public void setpFirstNode(Node pFirstNode) {
        this.pFirstNode = pFirstNode;
    }

    /**
     * @return the pLastNode
     */
    @Override
    public Node getpLastNode() {
        return pLastNode;
    }

    /**
     * @param pLastNode the pLastNode to set
     */
    @Override
    public void setpLastNode(Node pLastNode) {
        this.pLastNode = pLastNode;
    }
    
    
}
