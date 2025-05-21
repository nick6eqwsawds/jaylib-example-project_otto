public class Tile {
    private final int x;
    private final int y;
    private TileType tileType;

    //hittar var rutan är och vilken typ av ruta det är
    public Tile(int x, int y, TileType tileType) {
        this.x = x;
        this.y = y;
        this.tileType = tileType;
    }
    //skaffar x
    public int getX() {
        return x;
    }
    //skaffar y
    public int getY() {
        return y;
    }
    //frågar vilken ruta det är och får svar
    public TileType getTileType(){
        return tileType;
    }
    //bestämmer rut-typen
    public void setTileType(TileType tileType){
        this.tileType = tileType;
    }
}

//de olika typerna av rutor
enum TileType {
    EMPTY,
    SHIP,
    HIT,
    MISS
}
