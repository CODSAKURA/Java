package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.util.*;


public class Main extends Application {
    private Node [][] map;//display the graph on interface
    private ArrayList<Node> node;//all nodes
    public static void main(String[] args) {
        Application.launch(args);
    }
    private int []parent;//array of disjoint set
    int find(int x)
    {
        return parent[x] == x ? x : find(parent[x]);
    }//find method of disjoint set
    private ArrayList<Integer> []v;//adjacency list
    private int []vis;// whether being visited
    private ArrayList<Edge> edges;//whole edge

    /*
    Generate a random graph, the result is stored in the adjacency matrix v
     */
    private void RandomGraph(){
        int cnt=0;
        while(cnt<6){
            int a=(int)(Math.random()*7)+1;
            int b=(int)(Math.random()*7)+1;
            int fa=find(a);
            int fb=find(b);
            if(fa!=fb){
                parent[fa]=fb;
                v[a].add(b);
                v[b].add(a);
                cnt++;
            }
        }
    }
    /*
    Put the node into the corresponding bit of the map to form a tree
    * */
    private void draw(Group g){
        Queue<Integer> q=new LinkedList<>();
        q.offer((int)(Math.random()*7)+1);
        q.offer(-1);//Layered road signs
        int level=0;
        int add=0;
        while (q.isEmpty()==false){//breadth-first traversal
            if(add==7)break;
            int t=q.poll();
            if(t==-1){//When encountering a road sign, increase the number of layers by one
                q.offer(-1);
                level++;
                continue;
            }
            if(vis[t]==1)continue;//no repeating
            vis[t]=1;
            add++;
            int k=0;
            for(int i=0;i<6;i++){//put the Node into map
                if( map[level][i]==null){
                    k=i;
                    map[level][i]=new Node(160*level,100*i,t);
                    node.add(map[level][i]);
                    g.getChildren().add( map[level][i].ellipse);
                    g.getChildren().add( map[level][i].text);
                    break;
                }
            }
            for(int i=0;i<v[t].size();i++){//connect this node with it's father AND add it's son into the queue
                if(level>0){
                    if(vis[v[t].get(i)]==1){
                        for(int j=0;j<6;j++){
                            if( map[level-1][j]!=null&& map[level-1][j].num==v[t].get(i)){
                                Edge e=new Edge((level-1)*160+100,j*100+50,160*level,k*100+50, map[level-1][j], map[level][k]);
                                edges.add(e);
                                g.getChildren().add(e.line);
                            }
                        }
                    }
                }
                if(vis[v[t].get(i)]==0){
                    q.offer(v[t].get(i));
                }
            }
        }
    }
    /*
The mouse will not be able to click on the node
    * */
    private void cannotSelect(){
        for(int i=0;i<7;i++){
            for(int j=0;j<6;j++){
                if( map[i][j]!=null){
                    map[i][j].mode=0;//set mode;mode==0:cannot choose;mode==1:chooseA;mode==2:chooseB;
                }
            }
        }
    }
    private void showA(){//shows the chosen A
        for(int i=0;i<7;i++){
            for(int j=0;j<6;j++){
                if( map[i][j]!=null){
                    map[i][j].mode=1;
                    map[i][j].show();//call display function
                }
            }
        }
        for(int i=0;i<edges.size();i++){//Check whether the two points of the edge are selected, if they are both selected, they will turn green
            if(edges.get(i).from.chooseA&&edges.get(i).to.chooseA){
                edges.get(i).line.setStroke(Color.GREEN);
                edges.get(i).line.setStrokeWidth(4);
            }
            else{
                edges.get(i).line.setStroke(Color.BLACK);
                edges.get(i).line.setStrokeWidth(2);
            }
        }
    }
    private void showB(){//shows the chosen B
        for(int i=0;i<7;i++){
            for(int j=0;j<6;j++){
                if( map[i][j]!=null){
                    map[i][j].mode=2;
                    map[i][j].show();//call display function
                }
            }
        }
        for(int i=0;i<edges.size();i++){//Check whether the two points of the edge are selected, if they are both selected, they will turn blue
            if(edges.get(i).from.chooseB&&edges.get(i).to.chooseB){
                edges.get(i).line.setStroke(Color.LIGHTBLUE);
                edges.get(i).line.setStrokeWidth(4);
            }
            else{
                edges.get(i).line.setStroke(Color.BLACK);
                edges.get(i).line.setStrokeWidth(2);
            }
        }
    }
    private void show(Set<Elem> A){//display a given collection
        for(int i=0;i<edges.size();i++){//show edge
            if(A.contains(edges.get(i))){
                edges.get(i).line.setStroke(Color.RED);
                edges.get(i).line.setStrokeWidth(4);
            }
            else{
                edges.get(i).line.setStroke(Color.BLACK);
                edges.get(i).line.setStrokeWidth(2);
            }
        }
        for (int i=0;i<node.size();i++){//show node
            if(A.contains(node.get(i))){
                node.get(i).ellipse.setFill(Color.RED);
            }
            else{
                node.get(i).ellipse.setFill(Color.WHITE);
            }
        }
    }
    private Set<Elem> complement1(Set<Elem> A){//complement set1
        Set<Elem> B=new HashSet<>();
        for (int i=0;i<edges.size();i++){
            if(!A.contains(edges.get(i))){
                B.add(edges.get(i));
                Edge t=edges.get(i);
                if(!B.contains(t.to)){
                    B.add(t.to);
                }
                if(!B.contains(t.from)){
                    B.add(t.from);
                }
            }
        }
        return B;
    }
    private Set<Elem> complement2(Set<Elem> A){//complement set2
        Set<Elem> B=new HashSet<>();
        for(int i=0;i<node.size();i++){
            if(!A.contains(node.get(i))){
                B.add(node.get(i));
            }
        }
        for (int i=0;i<edges.size();i++){
            if(B.contains(edges.get(i).from)&&B.contains(edges.get(i).to)){
                B.add(edges.get(i));
            }
        }
        return B;
    }
    private Set<Elem> union(Set<Elem> A,Set<Elem> B){//union
        Set<Elem> C=new HashSet<>();
        C.addAll(A);
        C.addAll(B);
        return C;
    }
    private Set<Elem> intersection(Set<Elem> A,Set<Elem> B){//intersection
        Set<Elem> C=new HashSet<>();
        C.addAll(A);
        C.retainAll(B);
        return C;
    }
    private int getPriority(char c){//get operator precedence
        if(c=='﹁'){
            return 2;
        }
        if(c=='﹂'){
            return 2;
        }
        if(c=='∩'){
            return 1;
        }
        if(c=='∪'){
            return 1;
        }
        return  0;
    }
    public String toRPN(String s){//Infix expression to postfix expression
        Stack<Character> stack=new Stack<>();//stack, put operator
        String rpn="";//results
        for(int i=0;i<s.length();i++){//Traverse infix expressions
            if(s.charAt(i)=='A'){
                rpn+='A';
            }
            else if(s.charAt(i)=='B'){
                rpn+='B';
            }
            else if(s.charAt(i)=='('){
                stack.push('(');
            }
            else if(s.charAt(i)==')'){
                while (!stack.empty()&&stack.peek()!='('){
                    rpn+=stack.peek();
                    stack.pop();
                }
            }
            else {
                while (!stack.empty()){
                    char c=stack.peek();
                    if(getPriority(c)>=getPriority(s.charAt(i))){
                        rpn+=stack.peek();
                        stack.pop();
                    }
                    else{
                        break;
                    }
                }
                stack.push(s.charAt(i));
            }
        }
        while (!stack.empty()){//operator pop
            if(stack.peek()!='(')rpn+=stack.peek();
            stack.pop();
        }
        return rpn;
    }
    private void calculate(String s){//Calculate postfix expressions
        Stack< Set<Elem>> set=new Stack<>();
        if(s.isEmpty())return;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='A'){//Need to generate a new set A, the content contains the selected subgraph
                Set<Elem> A=new HashSet<>();//an empty set
                for (int j=0;j<node.size();j++){
                    if(node.get(j).chooseA==true){
                        A.add(node.get(j));
                    }
                }//add edge to set A
                for (int j=0;j<edges.size();j++){
                    if(edges.get(j).from.chooseA&&edges.get(j).to.chooseA){
                        A.add(edges.get(j));
                    }
                }//add edge to set A
                set.push(A);
            }
            else if(s.charAt(i)=='B'){//Need to generate a new set B, the content contains the selected subgraph
                Set<Elem> B=new HashSet<>();//an empty set
                for (int j=0;j<node.size();j++){
                    if(node.get(j).chooseB==true){
                        B.add(node.get(j));
                    }
                }//add edge to set B
                for (int j=0;j<edges.size();j++){
                    if(edges.get(j).from.chooseB&&edges.get(j).to.chooseB){
                        B.add(edges.get(j));
                    }
                }//add edge to set B
                set.push(B);
            }
            else{//Calculate by operator
                if(s.charAt(i)=='﹂'){
                    Set<Elem> B=set.peek();
                    set.pop();
                    set.push(complement1(B));
                }
                else if(s.charAt(i)=='﹁'){
                    Set<Elem> B=set.peek();
                    set.pop();
                    set.push(complement2(B));
                }
                else if(s.charAt(i)=='∩'){
                    Set<Elem> B=set.peek();
                    set.pop();
                    Set<Elem> C=set.peek();
                    set.pop();
                    set.push(intersection(B,C));
                }
                else if(s.charAt(i)=='∪'){
                    Set<Elem> B=set.peek();
                    set.pop();
                    Set<Elem> C=set.peek();
                    set.pop();
                    set.push(union(B,C));
                }
            }
        }
        show(set.peek());//show results
    }
    @Override
    public void start(Stage primaryStage) {
        //initialization
        primaryStage.setTitle("Set Calculation");
        Group root = new Group();
        Group g = new Group();
        Scene scene = new Scene(root, 1500, 700, Color.WHITE);
        node=new ArrayList<>();
        map=new Node[7][6];
        parent=new int[8];
        vis=new int[8];
        v=new ArrayList[8];
        edges=new ArrayList<>();
        for(int i=1;i<=7;i++){
            parent[i]=i;
            vis[i]=0;
            v[i]=new ArrayList<>();
        }

        //screen layout
        RandomGraph();
        draw(g);
        Line line=new Line();
        line.setStartX(1100);
        line.setStartY(0);
        line.setEndX(1100);
        line.setEndY(700);
        line.setStrokeWidth(3);
        TextField text = new TextField();
        text.setLayoutX(1220);
        text.setLayoutY(50);
        text.setScaleY(2);
        text.setScaleX(2);

        Button bntShowRes=new Button("SHOW RESULT");
        bntShowRes.setLayoutX(1150);
        bntShowRes.setLayoutY(10);
        bntShowRes.setOnAction(new EventHandler<ActionEvent>() {//Design a click function
            @Override
            public void handle(ActionEvent actionEvent) {
                cannotSelect();
                System.out.println(toRPN(text.getText()));
                calculate(toRPN(text.getText()));
            }
        });

        Button bntShowA=new Button("SHOW A");
        bntShowA.setLayoutX(1265);
        bntShowA.setLayoutY(10);
        bntShowA.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                showA();
                cannotSelect();
            }
        });

        Button bntShowB=new Button("SHOW B");
        bntShowB.setLayoutX(1350);
        bntShowB.setLayoutY(10);
        bntShowB.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                showB();
                cannotSelect();
            }
        });

        Button bntA=new Button("A");
        bntA.setScaleX(2);
        bntA.setScaleY(2);
        bntA.setLayoutX(1200);
        bntA.setLayoutY(110);
        bntA.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                text.setText(text.getText()+"A");
            }
        });



        Button bntComplement2=new Button("﹁");
        bntComplement2.setScaleX(2);
        bntComplement2.setScaleY(2);
        bntComplement2.setLayoutX(1270);
        bntComplement2.setLayoutY(110);
        bntComplement2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                text.setText(text.getText()+"﹁");
            }
        });


        Button bntComplement1 = new Button("﹂");
        bntComplement1.setScaleX(2);
        bntComplement1.setScaleY(2);
        bntComplement1.setLayoutX(1340);
        bntComplement1.setLayoutY(110);
        bntComplement1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                text.setText(text.getText()+"﹂");
            }
        });

        Button bntIntersection=new Button("∩");
        bntIntersection.setScaleX(2);
        bntIntersection.setScaleY(2);
        bntIntersection.setLayoutX(1200);
        bntIntersection.setLayoutY(180);
        bntIntersection.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                text.setText(text.getText()+"∩");
            }
        });

        Button bntUnion=new Button("∪");
        bntUnion.setScaleX(2);
        bntUnion.setScaleY(2);
        bntUnion.setLayoutX(1270);
        bntUnion.setLayoutY(180);
        bntUnion.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                text.setText(text.getText()+"∪");
            }
        });
        Button bntLeftBracket=new Button("(");
        bntLeftBracket.setScaleX(2);
        bntLeftBracket.setScaleY(2);
        bntLeftBracket.setLayoutX(1340);
        bntLeftBracket.setLayoutY(180);
        bntLeftBracket.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                text.setText(text.getText()+"(");
            }
        });
        Button bntRightBracket=new Button(")");
        bntRightBracket.setScaleX(2);
        bntRightBracket.setScaleY(2);
        bntRightBracket.setLayoutX(1200);
        bntRightBracket.setLayoutY(250);
        bntRightBracket.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                text.setText(text.getText()+")");
            }
        });
        Button bntDel=new Button("del");
        bntDel.setScaleX(2);bntDel.setScaleY(2);
        bntDel.setLayoutX(1340);
        bntDel.setLayoutY(250);
        bntDel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String s="";
                for(int i=0;i<text.getText().length()-1;i++){
                    s+=text.getText().charAt(i);
                }
                text.setText(s);
            }
        });

        Button bntB=new Button("B");
        bntB.setScaleX(2);
        bntB.setScaleY(2);
        bntB.setLayoutX(1270);
        bntB.setLayoutY(250);
        bntB.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                text.setText(text.getText()+"B");
            }
        });

        Button selectA=new Button("select A");
        selectA.setLayoutX(1200);
        selectA.setLayoutY(310);
        selectA.setScaleX(2);
        selectA.setScaleY(2);
        selectA.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                showA();
            }
        });

        Button selectB=new Button("select B");
        selectB.setLayoutX(1200);
        selectB.setLayoutY(370);
        selectB.setScaleX(2);
        selectB.setScaleY(2);
        selectB.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                showB();
            }
        });
        g.getChildren().add(bntShowRes);
        g.getChildren().add(bntShowA);
        g.getChildren().add(bntShowB);
        g.getChildren().add(bntA);
        g.getChildren().add(bntComplement2);
        g.getChildren().add(bntComplement1);
        g.getChildren().add(bntIntersection);
        g.getChildren().add(bntUnion);
        g.getChildren().add(bntLeftBracket);
        g.getChildren().add(bntRightBracket);
        g.getChildren().add(bntDel);
        g.getChildren().add(bntB);
        g.getChildren().add(selectA);
        g.getChildren().add(selectB);
        g.getChildren().add(text);
        g.getChildren().add(line);
        root.getChildren().add(g);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
