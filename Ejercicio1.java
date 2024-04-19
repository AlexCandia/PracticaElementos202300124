
public class Ejercicio1
{   
    int tamaño;
    String[][] maze;
    int x,y;
    /*={
        {"*","*","*","*","*","*"},
        {"?","?","*","?","?","?"},
        {"?","?","*","*","*","*"},
        {"?","*","?","*","?","*"},
        {"*","?","?","?","?","*"},
        {"*","?","?","*","?","E"},
    };*/
    private boolean esValida(int x,int y){
        if(x>tamaño||y>tamaño||x<0||y<0){
            return false;
        }else if(maze[x][y]=="?"|| maze[x][y]=="R"){
            return false;
        }else{
            return true;
        }
    }
    public boolean puedoSalir(String[][] maze,int n){
        this.maze=maze;
        this.tamaño=n-1;
        x=0;
        y=0;
        return puedoSalir( x, y);
    }
    private boolean puedoSalir(int x,int y){
        boolean res;
        if(esValida(x,y)){
            if(maze[x][y]=="E"){ 
                res=true;
            }else{
                maze[x][y]="R";
                res =puedoSalir(x-1,y);
                if(!res){
                    res=puedoSalir(x,y+1);
                    if(!res){
                        res=puedoSalir(x+1,y);
                        if(!res){
                        res=puedoSalir(x,y-1);    
                        }
                    }
                }
            }
        }
        else{
            res=false;
        }
        return res;
    }
}
