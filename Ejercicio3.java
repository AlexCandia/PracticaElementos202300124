
public class Ejercicio3
{   
    String[][]lab;
    int n,m;
    private String esValida(int cx,int cy,int tx,int ty){
        if(cx<n&&cy<m&&cx>=0&&cy>=0&&lab[cx][cy]!="R"){
            if((cx==tx && cy!=ty) || (cy==ty && cx!=tx)){
                return "casTor";
            }else{
                return "casV";
            }
        }else{
            return "casInv";
        }
    }
    public String simular(int n,int m,int cx,int cy,int tx,int ty){
        String[][]laberinto=new String[n][m];
        if(n<2||m<2){
            return "laberinto invalido";
        }else if((cx!=tx && cy!=ty) && (cy!=ty && cx!=tx)){
            for(int i=0;i<=n-1;i++){
                for(int j=0;j<=m-1;j++){
                    laberinto[i][j]="*";
                }
            }
            laberinto[tx][ty]="T";
            this.lab=laberinto;
            this.n=n;
            this.m=m;
            return simular (cx, cy, tx, ty);
        }else{
            return "second";
        }
    }
    private String simular(int cx,int cy,int tx,int ty){
        String res;
        String cond=esValida(cx,cy,tx,ty);
        if(cond=="casV"){
            if(lab[cx][cy]=="T"){
               res="First"; 
            }else{
                lab[cx][cy]="R";
                res =simular(cx-2,cy+1,tx,ty);
                            if(res=="draw"){
                                res =simular(cx-1,cy+2,tx,ty);
                                if(res=="draw"){
                                    res =simular(cx+1,cy+2,tx,ty);
                                    if(res=="draw"){
                                        res =simular(cx+2,cy+1,tx,ty);
                                        if(res=="draw"){
                                            res =simular(cx+2,cy-1,tx,ty);
                                            if(res=="draw"){
                                                res =simular(cx+1,cy-2,tx,ty);
                                                if(res=="draw"){
                                                    res =simular(cx-1,cy-2,tx,ty);
                                                    if(res=="draw"){
                                                    res =simular(cx-2,cy-1,tx,ty);  
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            } 
            }
        }else{
            res="draw";
        }
        return res;
    }
    }
