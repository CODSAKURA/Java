package application;


import javafx.scene.shape.Line;

public class Edge extends Elem{//edge
    private int x1;//the coordinates of the straight line
    private int y1;
    private int x2;
    private int y2;
    public Node from;//start point
    public Node to;//end point
    public Line line;//straight line
    public Edge(int xx1,int yy1,int xx2,int yy2,Node f,Node t){
        x1=xx1;
        y1=yy1;
        x2=xx2;
        y2=yy2;
        from=f;
        to=t;
        line=new Line(x1,y1,x2,y2);
        line.setStrokeWidth(2);
    }
}

