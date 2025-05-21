public class Ship {
    private final int size;

    //skäppets längd
    //kan ändra så att värdena för alla båtar är här men hinner ej
    public Ship(int size) {

        this.size = size;
    }

    //skickar tillbaka längden
    public int getSize() {

        return size;
    }
}
