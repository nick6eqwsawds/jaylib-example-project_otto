public class Tile {
    private final int x;
    private final int y;
    private TileType tileType;

    public Tile(int x, int y, TileType tileType) {
        this.x = x;
        this.y = y;
        this.tileType = tileType;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public TileType getTileType(){
        return tileType;
    }
    public void setTileType(TileType tileType){
        this.tileType = tileType;
    }
}

enum TileType {
    EMPTY,
    SHIP,
    HIT,
    MISS
}
