/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Local;

/**
 *
 * @author Vinicio
 */
public class Town extends S_Local{
    
    public Town(int posX, int posY, String name){
        super.setPosX(posX);
        super.setPosY(posY);
        super.setName(name);
        super.setType(3);
    }
}
