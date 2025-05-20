import java.awt.datatransfer.Clipboard;

import static com.raylib.Colors.*;
import static com.raylib.Raylib.*;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeUnit.*;

public class BattleShipsGame {
    private static Board playerBoard;
    private static Board enemyBoard;
    static int turn = 1;
    static int stage = 1;
    static int playerx = 920;
    static int playery = 100;
    static int BombWidth = 40;
    static int BombHeight = 40;
    static int boats = 0;

    public static void main(String[] args) throws Exception {
        InitWindow(1400, 800, "BattleShips");
        SetTargetFPS(60);

        playerBoard = new Board(10, 10);
        enemyBoard = new Board(10, 10);


/*
        playerBoard.placeShips(new Ship(3), 3, 2, false);
        playerBoard.placeShips(new Ship(3), 5, 4, true);
        playerBoard.placeShips(new Ship(2), 1, 5, false);
        playerBoard.placeShips(new Ship(3), 9, 0, false);
        enemyBoard.placeShips(new Ship(4), 3, 3, false);
        enemyBoard.placeShips(new Ship(4), 9, 0, false);
        enemyBoard.placeShips(new Ship(2), 0, 7, false);
        enemyBoard.placeShips(new Ship(4), 5, 5, true);

 */


        while (!WindowShouldClose()) {
            handleInput();

            BeginDrawing();
            ClearBackground(WHITE);
            //SetTargetFPS(60);
            DrawFPS(10, 10);
            if (stage == 1) {
                DrawText("Press space to begin", 300, 200, 75, BLACK);
                DrawText("--SPACE--", 540, 340, 60, BLACK);

            }

            if (stage == 2) {
                DrawText("Player 2", 250, 50, 30, BLACK);
                DrawText("Choose your ships!", 650, 50, 30, BLACK);
                for (int i = 1; i < 3; i++) {
                    DrawText("["+i+"] : ", 200+i*400, 150, 30, BLACK);
                }
                for (int i = 1; i < 3; i++) {
                    int numr=2+i;
                    DrawText("["+numr+"] : ", 200+i*400, 350, 30, BLACK);
                }
                for (int i = 1; i < 3; i++) {
                    int numr=4+i;
                    DrawText("["+numr+"] : ", 200+i*400, 550, 30, BLACK);
                }

                DrawRectangle(675, 140, 199, 39, GREEN);
                DrawRectangle(1075, 140, 119, 39, GREEN);
                DrawRectangle(675, 340, 79, 39, GREEN);
                DrawRectangle(1075, 340, 239, 39, GREEN);
                DrawRectangle(675, 540, 39, 39, GREEN);
                DrawRectangle(715, 580, 39, 39, GREEN);
                DrawRectangle(755, 620, 39, 39, GREEN);
                DrawRectangle(1075, 540, 39, 39, GREEN);
                DrawRectangle(1115, 580, 39, 39, GREEN);
                DrawRectangle(1155, 620, 39, 39, GREEN);
                DrawRectangle(1195, 660, 39, 39, GREEN);
                for (int i = 0; i < 6; i++) {
                    DrawRectangleLines(675+40*i, 140, 39, 39, BLACK);
                    DrawRectangleLines(1075+40*i, 140, 39, 39, BLACK);
                    DrawRectangleLines(675+40*i, 340, 39, 39, BLACK);
                    DrawRectangleLines(1075+40*i, 340, 39, 39, BLACK);
                    DrawRectangleLines(675+40*i, 540, 39, 39, BLACK);
                    DrawRectangleLines(1075+40*i, 540, 39, 39, BLACK);
                    DrawRectangleLines(675+40*i, 580, 39, 39, BLACK);
                    DrawRectangleLines(1075+40*i, 580, 39, 39, BLACK);
                    DrawRectangleLines(675+40*i, 620, 39, 39, BLACK);
                    DrawRectangleLines(1075+40*i, 620, 39, 39, BLACK);
                    DrawRectangleLines(1075+40*i, 660, 39, 39, BLACK);
                }

                DrawText("Press numbers to pick and place at your character", 40, 560, 20, BLACK);
                playerBoard.drawBoard(100, 100, 1);
                if (IsKeyPressed(KEY_ONE)){
                    int shipx1 = (playerx-800)/40;
                    int shipy1 = (playery-100)/40;
                    playerBoard.placeShips(new Ship(5), shipx1, shipy1, false);
                    boats = boats +1;
                }
                if (IsKeyPressed(KEY_TWO)){
                    int shipx2 = (playerx-800)/40;
                    int shipy2 = (playery-100)/40;
                    playerBoard.placeShips(new Ship(3), shipx2, shipy2, false);
                    boats = boats +1;
                }
                if (IsKeyPressed(KEY_THREE)){
                    int shipx3 = (playerx-800)/40;
                    int shipy3 = (playery-100)/40;
                    playerBoard.placeShips(new Ship(2), shipx3, shipy3, false);
                    boats = boats +1;
                }
                if (IsKeyPressed(KEY_FOUR)){
                    int shipx4 = (playerx-800)/40;
                    int shipy4 = (playery-100)/40;
                    playerBoard.placeShips(new Ship(6), shipx4, shipy4, false);
                    boats = boats +1;
                }
                if (IsKeyPressed(KEY_FIVE)){
                    int shipx5 = (playerx-800)/40;
                    int shipy5 = (playery-100)/40;
                    playerBoard.placeShips(new Ship(3), shipx5, shipy5, true);
                    boats = boats +1;
                }
                if (IsKeyPressed(KEY_SIX)){
                    int shipx6 = (playerx-800)/40;
                    int shipy6 = (playery-100)/40;
                    playerBoard.placeShips(new Ship(4), shipx6, shipy6, true);
                    boats = boats +1;
                }
                DrawRectangle(playerx-700, playery, BombWidth - 1, BombHeight - 1, YELLOW);
                if (boats == 6){
                    DrawRectangle(1,1,1390,790,WHITE);
                    DrawText("Press Enter", 500, 200, 30, BLACK);
                    if (IsKeyPressed(KEY_ENTER)){
                        stage = 3;
                    }
                }
            }
            if (stage == 3) {
                System.out.println(boats);
                //DrawRectangle(1,1,1399,799,WHITE);
                DrawText("Player 2", 950, 50, 30, BLACK);
                DrawText("Choose your ships!", 950 - 650, 50, 30, BLACK);
                for (int i = 1; i < 3; i++) {
                    DrawText("[" + i + "] : ", (200 + i * 400) - 575, 150, 30, BLACK);
                }
                for (int i = 1; i < 3; i++) {
                    int numr = 2 + i;
                    DrawText("[" + numr + "] : ", (200 + i * 400) - 575, 350, 30, BLACK);
                }
                for (int i = 1; i < 3; i++) {
                    int numr = 4 + i;
                    DrawText("[" + numr + "] : ", (200 + i * 400) - 575, 550, 30, BLACK);
                }

                DrawRectangle(675 - 575, 140, 199, 39, GREEN);
                DrawRectangle(1075 - 575, 140, 119, 39, GREEN);
                DrawRectangle(675 - 575, 340, 79, 39, GREEN);
                DrawRectangle(1075 - 575, 340, 239, 39, GREEN);
                DrawRectangle(675 - 575, 540, 39, 39, GREEN);
                DrawRectangle(715 - 575, 580, 39, 39, GREEN);
                DrawRectangle(755 - 575, 620, 39, 39, GREEN);
                DrawRectangle(1075 - 575, 540, 39, 39, GREEN);
                DrawRectangle(1115 - 575, 580, 39, 39, GREEN);
                DrawRectangle(1155 - 575, 620, 39, 39, GREEN);
                DrawRectangle(1195 - 575, 660, 39, 39, GREEN);
                for (int i = 0; i < 6; i++) {
                    DrawRectangleLines((675 + 40 * i) - 575, 140, 39, 39, BLACK);
                    DrawRectangleLines((1075 + 40 * i) - 575, 140, 39, 39, BLACK);
                    DrawRectangleLines((675 + 40 * i) - 575, 340, 39, 39, BLACK);
                    DrawRectangleLines((1075 + 40 * i) - 575, 340, 39, 39, BLACK);
                    DrawRectangleLines((675 + 40 * i) - 575, 540, 39, 39, BLACK);
                    DrawRectangleLines((1075 + 40 * i) - 575, 540, 39, 39, BLACK);
                    DrawRectangleLines((675 + 40 * i) - 575, 580, 39, 39, BLACK);
                    DrawRectangleLines((1075 + 40 * i) - 575, 580, 39, 39, BLACK);
                    DrawRectangleLines((675 + 40 * i) - 575, 620, 39, 39, BLACK);
                    DrawRectangleLines((1075 + 40 * i) - 575, 620, 39, 39, BLACK);
                    DrawRectangleLines((1075 + 40 * i) - 575, 660, 39, 39, BLACK);
                }

                DrawText("Press numbers to pick and place at your character", 820, 560, 20, BLACK);
                enemyBoard.drawBoard(800, 100, 1);
                if (IsKeyPressed(KEY_ONE)) {
                    int shipx12 = (playerx - 800) / 40;
                    int shipy12 = (playery - 100) / 40;
                    playerBoard.placeShips(new Ship(5), shipx12, shipy12, false);
                    boats = boats + 1;
                }
                if (IsKeyPressed(KEY_TWO)) {
                    int shipx2 = (playerx - 800) / 40;
                    int shipy2 = (playery - 100) / 40;
                    enemyBoard.placeShips(new Ship(3), shipx2, shipy2, false);
                    boats = boats + 1;
                }
                if (IsKeyPressed(KEY_THREE)) {
                    int shipx3 = (playerx - 800) / 40;
                    int shipy3 = (playery - 100) / 40;
                    enemyBoard.placeShips(new Ship(2), shipx3, shipy3, false);
                    boats = boats + 1;
                }
                if (IsKeyPressed(KEY_FOUR)) {
                    int shipx4 = (playerx - 800) / 40;
                    int shipy4 = (playery - 100) / 40;
                    enemyBoard.placeShips(new Ship(6), shipx4, shipy4, false);
                    boats = boats + 1;
                }
                if (IsKeyPressed(KEY_FIVE)) {
                    int shipx5 = (playerx - 800) / 40;
                    int shipy5 = (playery - 100) / 40;
                    enemyBoard.placeShips(new Ship(3), shipx5, shipy5, true);
                    boats = boats + 1;
                }
                if (IsKeyPressed(KEY_SIX)) {
                    int shipx6 = (playerx - 800) / 40;
                    int shipy6 = (playery - 100) / 40;
                    enemyBoard.placeShips(new Ship(4), shipx6, shipy6, true);
                    boats = boats + 1;
                }

                DrawRectangle(playerx, playery, BombWidth - 1, BombHeight - 1, YELLOW);
                if (boats == 12){
                    DrawRectangle(1,1,1390,790,WHITE);
                    DrawText("Press Enter", 500, 200, 30, BLACK);
                    if (IsKeyPressed(KEY_ENTER)){
                        stage = 4;
                    }
                }
            }


            if (stage == 4) {
                DrawText("Press 1 for normal bomb", 100, 500, 20, BLACK);
                DrawText("Press 2 for long bomb", 100, 540, 20, BLACK);
                DrawText("Press 3 for square bomb", 100, 580, 20, BLACK);
                DrawText("Press Enter next persons turn", 300, 500, 20, BLACK);
                DrawText("Press SPACE to fire bomb ", 300, 560, 20, BLACK);

                //playerBoard.drawBoard(100, 100);
                //enemyBoard.drawBoard(800, 100);

                if (turn == 1) {
                    //DrawRectangle(100, 100, 399, 399, WHITE);
                    enemyBoard.drawBoard(800, 100, 0);
                    //playerBoard.drawBoard(100, 100, 0);
                    //Thread.sleep(2500);
                    //TimeUnit.SECONDS.sleep(3);
                    playerBoard.drawBoard(100, 100, 1);
                    DrawRectangle(playerx, playery, BombWidth - 1, BombHeight - 1, YELLOW);
                } else if (turn == 2) {
                    //DrawRectangle(800, 100, 399, 399, WHITE);
                    playerBoard.drawBoard(100, 100, 0);
                    //enemyBoard.drawBoard(800, 100, 0);
                    //Thread.sleep(5000);
                    enemyBoard.drawBoard(800, 100, 1);
                    DrawRectangle(playerx - 700, playery, BombWidth - 1, BombHeight - 1, YELLOW);
                }
            }

            //System.out.println(GetMouseX()+ " " + GetMouseY());

            EndDrawing();
        }
        CloseWindow();
    }

    private static void handleInput() throws Exception {

        if (stage == 1) {
            if (IsKeyPressed(KEY_SPACE)) {
                stage = 2;
            }
        }
            if (stage > 1){
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
                if (playery + BombHeight < 100 + BombHeight) {
                    playery = playery + 40;
                } else if (playery > 500 - BombHeight) {
                    playery = playery - 40;
                }
                if (turn == 1) {
                    if (playerx < 800) {
                        playerx = playerx + 40;
                    } else if (playerx + BombWidth > 1200) {
                        playerx = playerx - 40;
                    }
                }
                if (turn == 2) {

                    if (playerx - 700 < 100) {
                        playerx = playerx + 40;
                    } else if (playerx - 700 + BombWidth > 500) {
                        playerx = playerx - 40;
                    }
                }
            }
            if (stage == 2){

            }
            if (stage == 3){

            }
         if (stage == 4) {

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
                BombWidth = 40 * 4;
                BombHeight = 40;
            }
            if (IsKeyPressed(KEY_THREE)) {
                BombWidth = 40 * 2;
                BombHeight = 40 * 2;
            }
            if (IsKeyPressed(KEY_R)) {
                int BombWidth1 = BombWidth;
                int BombHeight1 = BombHeight;
                BombWidth = BombHeight1;
                BombHeight = BombWidth1;
            }
            /*
            if (playery + BombHeight < 100 + BombHeight) {
                playery = playery + 40;
            } else if (playery > 500 - BombHeight) {
                playery = playery - 40;
            }
            if (turn == 1) {
                if (playerx < 800) {
                    playerx = playerx + 40;
                } else if (playerx + BombWidth > 1200) {
                    playerx = playerx - 40;
                }
            }
            if (turn == 2) {

                if (playerx - 700 < 100) {
                    playerx = playerx + 40;
                } else if (playerx - 700 + BombWidth > 500) {
                    playerx = playerx - 40;
                }
            }

             */


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
                    /*
                    if (BombWidth>40){
                        for (int i = 0; i < (BombWidth/40) ; i++) {
                            enemyBoard.hitTile(x+i, y);
                        }
                    }

                     */
                        if (BombHeight > 40 || BombWidth > 40) {
                            for (int i = 0; i < (BombHeight / 40); i++) {
                                for (int j = 0; j < (BombWidth / 40); j++) {
                                    enemyBoard.hitTile(x + j, y + i);
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
                    /*
                    if (BombWidth>40){
                        for (int i = 0; i < (BombWidth/40) ; i++) {
                            playerBoard.hitTile(x+i, y);
                        }
                    }

                     */
                        if (BombHeight > 40 || BombWidth > 40) {
                            for (int i = 0; i < (BombHeight / 40); i++) {
                                for (int j = 0; j < (BombWidth / 40); j++) {
                                    playerBoard.hitTile(x + j, y + i);
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
}
