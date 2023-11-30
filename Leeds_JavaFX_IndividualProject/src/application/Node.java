package application;


import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Node extends Elem{//node
    public Ellipse ellipse;//circle
    public Text text;//number
    private Color color;//color
    public int num;//number
    public boolean chooseA;//whether chose A
    public boolean chooseB;//Whether chose B
    public int mode=0;
    private int x;//x level
    private int y;//y level
    public Node(int x,int y,int num){//construct function
        this.num=num;
        this.x=x;
        this.y=y;
        mode=0;
        chooseA=false;
        chooseB=false;
        ellipse=new Ellipse(x+50,y+50,35,35);
        ellipse.setFill(Color.WHITE);
        ellipse.setStroke(Color.BLACK);
        color=Color.WHITE;
        text=new Text(x+45,y+55,""+num);
        text.setFont(new Font(16));
        ellipse.setOnMouseClicked(new EventHandler<MouseEvent>() {//Click  change color to change the selected state
            @Override
            public void handle(MouseEvent event) {
                if(mode==0){

                }
                else if(mode==1){
                    if(color.equals(Color.WHITE)){
                        color=Color.GREEN;
                        chooseA=true;
                    }
                    else {
                        color=Color.WHITE;
                        chooseA=false;
                    }
                    ellipse.setFill(color);
                }
                else {
                    if(color.equals(Color.WHITE)){
                        color=Color.LIGHTBLUE;
                        chooseB=true;
                    }
                    else {
                        color=Color.WHITE;
                        chooseB=false;
                    }
                    ellipse.setFill(color);
                }
            }

        });
    }
    public void clear(){//not display nodes
        text.setText("");
        ellipse.setStroke(Color.WHITE);
        ellipse.setFill(Color.WHITE);
    }
    public void show(){//display nodes correctly
        if(mode==1){
            if(chooseA){
                color=Color.GREEN;
            }
            else{
                color=Color.WHITE;
            }
        }
        else if(mode==2){
            if(chooseB){
                color=Color.LIGHTBLUE;
            }
            else{
                color=Color.WHITE;
            }
        }
        text.setText(""+num);
        ellipse.setStroke(Color.BLACK);
        ellipse.setFill(color);
    }
}

