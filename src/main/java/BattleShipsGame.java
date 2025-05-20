import java.awt.datatransfer.Clipboard;

import static com.raylib.Colors.*;
import static com.raylib.Raylib.*;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeUnit.*;

public class BattleShipsGame {
    private static Board playerBoard;
    private static Board enemyBoard;
    static int turn=1;
    static int playerx = 920;
    static int playery = 100;
    static int BombWidth = 40;
    static int BombHeight = 40;

    public static void main(String[] args) throws Exception {
        InitWindow(1400, 800, "BattleShips");
        SetTargetFPS(60);

        playerBoard = new Board(10, 10);
        enemyBoard = new Board(10, 10);


        playerBoard.placeShips(new Ship(3), 3, 2, false);
        playerBoard.placeShips(new Ship(3), 5, 4, true);
        playerBoard.placeShips(new Ship(2), 1, 5, false);
        playerBoard.placeShips(new Ship(3), 9, 0, false);
        enemyBoard.placeShips(new Ship(4), 3, 3, false);
        enemyBoard.placeShips(new Ship(4), 9, 0, false);
        enemyBoard.placeShips(new Ship(2), 0, 7, false);
        enemyBoard.placeShips(new Ship(4), 5, 5, true);

        while (!WindowShouldClose()){
            handleInput();

            BeginDrawing();
            ClearBackground(WHITE);
            //SetTargetFPS(60);
            DrawFPS(10, 10);

            //playerBoard.drawBoard(100, 100);
            //enemyBoard.drawBoard(800, 100);

            if (turn==1){
                //DrawRectangle(100, 100, 399, 399, WHITE);
                enemyBoard.drawBoard(800, 100, 0);
                //playerBoard.drawBoard(100, 100, 0);
                //Thread.sleep(2500);
                //TimeUnit.SECONDS.sleep(3);
                playerBoard.drawBoard(100, 100, 1);
                DrawRectangle(playerx, playery, BombWidth-1, BombHeight-1, YELLOW);
            } else if (turn==2){
                //DrawRectangle(800, 100, 399, 399, WHITE);
                playerBoard.drawBoard(100, 100, 0);
                //enemyBoard.drawBoard(800, 100, 0);
                //Thread.sleep(5000);
                enemyBoard.drawBoard(800, 100, 1);
                DrawRectangle(playerx-700, playery, BombWidth-1, BombHeight-1, YELLOW);
            }

            //System.out.println(GetMouseX()+ " " + GetMouseY());

            EndDrawing();
        }
        CloseWindow();
    }

    private static void handleInput() throws Exception {

            if (IsKeyPressed(KEY_A)) {
                playerx = playerx - 40;
            }
            if (IsKeyPressed(KEY_D)) {
                playerx = playerx + 40;
            }
            if (IsKeyPressed(KEY_W)) {
                playery = playery - 40;
            }
            if (IsKeyPressed(KEY_S)) {
                playery = playery + 40;
            }
            if (IsKeyPressed(KEY_ENTER)) {
                if (turn == 1) {
                    turn = 2;
                } else if (turn == 2) {
                    turn = 1;
                }
            }
            if (IsKeyPressed(KEY_ONE)) {
                BombWidth = 40;
                BombHeight = 40;
            }
            if (IsKeyPressed(KEY_TWO)) {
                BombWidth=40*3;
                BombHeight = 40;
            }
            if (IsKeyPressed(KEY_THREE)) {
                BombWidth = 40*2;
                BombHeight = 40*2;
            }
            if (playery+BombHeight<100+BombHeight){
                playery = playery + 40;
            } else if (playery+BombHeight>540-BombHeight/2){
                playery = playery - 40;
            }
            if (turn == 1) {
                if (playerx+BombWidth < 800+BombWidth) {
                    playerx = playerx + 40;
                } else if (playerx+BombWidth > 1200) {
                    playerx = playerx - 40;
                }
            }
            if (turn == 2) {

                if (playerx-700 < 100) {
                    playerx = playerx + 40;
                } else if (playerx-700 > 460) {
                    playerx = playerx - 40;
                }
            }


        /*
        if (IsMouseButtonPressed(MOUSE_BUTTON_LEFT)&&turn==1){
            //int x = (GetMouseX() - 700) / 40;
            //int y = (GetMouseY() - 100) / 40;
            int x = (GetMouseX() - 800) / 40;
            int y = (GetMouseY() - 100) / 40;

            if (x >= 10){
                System.out.println("You missed");
            }
            if (y >= 10){
                System.out.println("You missed");
                turn =2;
            } else
             */
        //if (IsKeyPressed(KEY_SPACE) && turn == 1) {
        if (turn == 1) {
            if (IsKeyPressed(KEY_SPACE)) {
                int x = (playerx - 800) / 40;
                int y = (playery - 100) / 40;
                if (x >= 0 && y >= 0 && x < 10 && y < 10) {
                    if (BombWidth>40){
                        for (int i = 0; i < (BombWidth/40) ; i++) {
                            enemyBoard.hitTile(x+i, y);
                        }
                    }
                    if (BombHeight > 40){
                        for (int i = 0; i < (BombHeight/40); i++) {
                            for (int j = 0; j < 2; j++) {
                                enemyBoard.hitTile(x+j, y+i);
                            }
                        }
                    } else {
                        enemyBoard.hitTile(x, y);
                    }
                    //Thread.sleep(1000);
                    //turn = 2;
                } else {
                    System.out.println("You missed");
                    //Thread.sleep(1000);
                    //turn = 2;

                }
                //turn = 2;
            }
        }
        /*
        if (IsMouseButtonPressed(MOUSE_BUTTON_RIGHT)&&turn==2){
            int x = (GetMouseX() - 100) / 40;
            int y = (GetMouseY() - 100) / 40;

         */
        //if (IsKeyPressed(KEY_SPACE)&&turn==2){
        if (turn == 2) {
            if (IsKeyPressed(KEY_SPACE)) {
                int x = (playerx - 800) / 40;
                int y = (playery - 100) / 40;
                if (x >= 0 && y >= 0 && x < 10 && y < 10) {
                    if (BombWidth>40){
                        for (int i = 0; i < (BombWidth/40) ; i++) {
                            playerBoard.hitTile(x+i, y);
                        }
                    }
                    if (BombHeight > 40){
                        for (int i = 0; i < (BombHeight/40); i++) {
                            for (int j = 0; j < 2; j++) {
                                playerBoard.hitTile(x+j, y+i);
                            }
                        }
                    } else {
                        playerBoard.hitTile(x, y);
                    }
                } else {
                    System.out.println("You missed");
                }
            }
        }
    }
}
