
public class Ejercicio2
{
    public boolean puedoGenerar(String []a,String x){
        int tamlista=a.length-1;
        int tamx=x.length()-1;
        return puedoGenerar(a,x,tamlista,tamx);
    }
    private boolean puedoGenerar(String []a,String x,int tamlista,int tamx){
        boolean res;
        if(tamx==0){
            String aux=x.charAt(0)+"";
            String aux2=a[tamlista];
            if(aux.equals(aux2)){  
               res=true; 
            }else{
               if(tamlista==0){
                  if(aux.equals(aux2)){
                      res=true;
                  }else{
                      res=false;
                  }
               }else{
                  res=puedoGenerar(a,x,tamlista-1,tamx);
               }
            }
        }else{
            String aux=x.charAt(tamx)+"";
            String aux2=a[tamlista];
            if(aux.equals(aux2)){
                res=puedoGenerar(a,x,tamlista-1,tamx-1);
            }else{
                res=false;
            }
        }
        return res;
    }
}
