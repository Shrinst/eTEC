package Local;

public class S_Local {

    private S_Local next;
    private int posX;
    private int posY;
    private String name;
    private int type;

    public S_Local getNext() {
        return next;
    }

    public void setNext(S_Local next) {
        this.next = next;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
    
}
