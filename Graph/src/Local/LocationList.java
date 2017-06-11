package Local;

public class LocationList {

    private S_Local head;
    private S_Local last;
    private int size;

    public LocationList() {
        head = last = null;
        size = 0;

    }

    public boolean isEmpty() {
        return head == null;
    }

    public void insertGas(int x, int y, String name) {
        Gas_Station newNode = new Gas_Station(x, y, name);
        if (isEmpty()) {
            head = newNode;
        } else {
            last.setNext(newNode);
        }
        last = newNode;
        size++;
    }

    public void insertCenter(int x, int y, String name) {
        Distribution_Center newNode = new Distribution_Center(x, y, name);
        if (isEmpty()) {
            head = newNode;
        } else {
            last.setNext(newNode);
        }
        last = newNode;
        size++;
    }

    public void insertStore(int x, int y, String name) {
        Store newNode = new Store(x, y, name);
        if (isEmpty()) {
            head = newNode;
        } else {
            last.setNext(newNode);
        }
        last = newNode;
        size++;
    }
    public void insertTown(int x, int y, String name) {
        Store newNode = new Store(x, y, name);
        if (isEmpty()) {
            head = newNode;
        } else {
            last.setNext(newNode);
        }
        last = newNode;
        size++;
    }

    public int getposX(int nodo) {
        if (nodo == 0) {
            return head.getPosX();
        }else{
            S_Local temp = new S_Local();
            temp = head;
            for (int i = 0; i < nodo; i++) {
                temp = temp.getNext();
            }
            return temp.getPosX();
        }  
    }

    public int getposY(int nodo) {
        if (nodo == 0) {
            return head.getPosY();
        }else{
            S_Local temp = new S_Local();
            temp = head;
            for (int i = 0; i < nodo; i++) {
                temp = temp.getNext();
            }
            return temp.getPosY();
        }
    }

    public int getDistance(int first, int second) {
        int x1 = this.getposX(first);
        int x2 = this.getposX(second);
        int y1 = this.getposY(first);
        int y2 = this.getposY(second);
        int x = x1-x2;
        int y = y1-y2;
        int sol = (int)(Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2)));
        return sol;
    }
    public String getName(int nodo){
        if (nodo == 0) {
            return head.getName();
        }else{
            S_Local temp = new S_Local();
            temp = head;
            for (int i = 0; i < nodo; i++) {
                temp = temp.getNext();
            }
            return temp.getName();
        }
    }
    public int getType(int nodo){
        if (nodo == 0) {
            return head.getType();
        }else{
            S_Local temp = new S_Local();
            temp = head;
            for (int i = 0; i < nodo; i++) {
                temp = temp.getNext();
            }
            return temp.getType();
        }
    }
    public int getSize() {
        return size;
    }

    public S_Local getHead() {
        return this.head;
    }
}
