import com.raylib.Raylib;

//import java.awt.Color;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import static com.raylib.Colors.*;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeUnit.*;


public class Board {
    int turn = 1;
    private final int rowsX;
    private final int rowsY;
    private final Tile[][] grid;
    private final List<Ship> ships;

    public Board(int rowsX, int rowsY){
        this.rowsX = rowsX;
        this.rowsY = rowsY;
        this.grid = new Tile[rowsX][rowsY];
        this.ships = new ArrayList<>();

        for (int i = 0; i < rowsX; i++) {
            for (int j = 0; j < rowsY; j++) {
                grid[i][j] = new Tile(i, j, TileType.EMPTY);
            }
        }
    }

    public void placeShips(Ship ship, int startX, int startY, boolean horizontal){
        for (int i = 0; i < ship.getSize(); i++) {
            int x = horizontal ? startX + i : startX;
            //int y = startX + i;
            int y = horizontal ? startY + i : startY + i;
            //int x = horizontal ? startX : startY;
            grid[x][y].setTileType(TileType.SHIP);
        }
        ships.add(ship);
    }

    public void hitTile(int x, int y){
        if (grid[x][y].getTileType() == TileType.SHIP){
            grid[x][y].setTileType(TileType.HIT);
            System.out.println("Hit at "+x+" : "+y);
        } else {
            grid[x][y].setTileType(TileType.MISS);
            System.out.println("Miss at "+x+" : "+y);
            System.out.println("next player turn");
            if (turn == 1){
                turn = 2;
            } else if (turn == 2){
                turn = 1;
            }
        }
    }

    public void drawBoard(int offsetX, int offsetY, int ShipTurn) throws InterruptedException {
        for (int i = 0; i < rowsX; i++) {
            for (int j = 0; j < rowsY; j++) {
                Tile tile = grid[j][i];
                Raylib.Color color = BLUE;
                if (tile.getTileType() == TileType.HIT){
                     color = RED;

                } else if (tile.getTileType() == TileType.MISS) {
                    color = GRAY;
                }
                //Thread.sleep(2500);
                //TimeUnit.SECONDS.sleep(4);
                if (ShipTurn==1&&tile.getTileType() == TileType.SHIP){
                    //TimeUnit.SECONDS.sleep(2);
                    color = GREEN;
                }
                /*
                else if (tile.getTileType() == TileType.SHIP) {
                    color = GREEN;
                }

                 */

                Raylib.DrawRectangle(offsetX + j * 40, offsetY + i * 40, 40, 40, color);
                Raylib.DrawRectangleLines(offsetX + j * 40, offsetY + i * 40, 40, 40, BLACK);
            }
        }
    }
}
