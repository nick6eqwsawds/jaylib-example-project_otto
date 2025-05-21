import com.raylib.Raylib;

//import java.awt.Color;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import static com.raylib.Colors.*;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeUnit.*;


public class Board {
    private static int turn = 1;
    private final int rowsX;
    private final int rowsY;
    private final Tile[][] grid;
    private final List<Ship> ships;

    //skapar brädan
    public Board(int rowsX, int rowsY){
        this.rowsX = rowsX;
        this.rowsY = rowsY;
        this.grid = new Tile[rowsX][rowsY];
        this.ships = new ArrayList<>();

        // skapar först en tom bräda
        for (int i = 0; i < rowsX; i++) {
            for (int j = 0; j < rowsY; j++) {
                grid[i][j] = new Tile(i, j, TileType.EMPTY);
            }
        }
    }

    //skapar ships med x och y position och om de ska vara horizontella, sparar det i ett värde, byter de rutor som ship är på till ship
    // sparar sedan var ship är i en array lista
    public void placeShips(Ship ship, int startX, int startY, boolean horizontal){
        for (int i = 0; i < ship.getSize(); i++) {
            int x = horizontal ? startX + i : startX+i;
            //int y = startX + i;
            int y = horizontal ? startY+i : startY;
            //int x = horizontal ? startX : startY;
            grid[x][y].setTileType(TileType.SHIP);

        }
        ships.add(ship);
    }

    // kollar vilken typ av tile som spelarna träffat och byter värdet på vilken typ av ruta det är efter
    public void hitTile(int x, int y){
        if (grid[x][y].getTileType() == TileType.SHIP){
            grid[x][y].setTileType(TileType.HIT);
            System.out.println("Hit at "+x+" : "+y);
        } else if (grid[x][y].getTileType() != TileType.HIT) {
            grid[x][y].setTileType(TileType.MISS);
            System.out.println("Miss at "+x+" : "+y);
            System.out.println("next player turn");
            //byter mellan turns för spelarna
            if (turn == 1){
                turn = 2;
            } else if (turn == 2){
                turn = 1;
            }
        }
    }

    // ritar brädan och de olika rutorna och ändrar färgen beroende på vad som händer med rutan
    public void drawBoard(int offsetX, int offsetY, int ShowShip) throws InterruptedException {
        for (int i = 0; i < rowsX; i++) {
            for (int j = 0; j < rowsY; j++) {
                Tile tile = grid[j][i];
                Raylib.Color color = BLUE;
                if (tile.getTileType() == TileType.HIT){
                     color = RED;

                } else if (tile.getTileType() == TileType.MISS) {
                    color = GRAY;
                }

                //gör så att man bara kan se sina egna skäpp under sin tur
                if (ShowShip==1&&tile.getTileType() == TileType.SHIP){
                    //TimeUnit.SECONDS.sleep(2);
                    color = GREEN;
                }

                //byter färgen och ritar rutnätet
                Raylib.DrawRectangle(offsetX + j * 40, offsetY + i * 40, 40, 40, color);
                Raylib.DrawRectangleLines(offsetX + j * 40, offsetY + i * 40, 40, 40, BLACK);
            }
        }
    }
}
