
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Hp Pavilion g6
 */
public class SelectedAspirants {
     static ArrayList<String> selected=new ArrayList<>();

    public static ArrayList addSelected(int listIndex,String aspirant, String opponent){
        if(!selected.isEmpty()){
            if(aspirant!=null){
                if(!selected.contains(aspirant)){
                    // if array already contains the opponent
                    if(selected.contains(opponent) && selected.indexOf(opponent)==listIndex){
                        selected.remove(opponent);
                        selected.add(listIndex,aspirant); 
                    }
                    // if none is already at the index where aspirant should be
                    else if(selected.contains("none") && selected.indexOf("none")==listIndex){
                        selected.remove(selected.get(listIndex));
                        selected.add(listIndex,aspirant); 
                    }
                    else if(selected.size()==listIndex){
                        selected.add(listIndex,aspirant); 
                    }    
                }
                else{
                    selected.remove(aspirant);
                    selected.add(listIndex,aspirant); 
                }
            }


            else if(aspirant==null){
                aspirant="none";
                if(selected.get(listIndex).isEmpty()){
                   selected.add(listIndex,aspirant); 
                }  
                else if(selected.get(listIndex).equals(aspirant)){
                    selected.remove(aspirant);
                    selected.add(listIndex,aspirant); 
                }
                else if(!selected.get(listIndex).equals(aspirant)){
                    selected.remove(selected.get(listIndex));
                    selected.add(listIndex,aspirant); 
                }
            }
        }
        else{
            selected.add(listIndex,aspirant);
            
        }
        
//        else if(selected.contains(aspirant)){
//            selected.remove(opponent);
//            selected.add(listIndex,aspirant); 
//        }
        return selected;
    }
//    public static boolean addSelected(){
//        selected.add(aspirant);
//        return selected;
//    }
    
}
