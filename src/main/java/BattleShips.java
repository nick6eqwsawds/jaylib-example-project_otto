import static com.raylib.Colors.*;
import static com.raylib.Raylib.*;


public class BattleShips {
    public static void main(String[] args) throws Exception {
        int Screenwidth = 1300;
        int Screenheight = 850;
        InitWindow(Screenwidth, Screenheight, "Battle Ships");
        SetTargetFPS(60);
        int x = 255;
        int y = 355;
        int x2 = 1005;
        int y2 = 355;
        int X = 0;
        int Y = 0;
        int BombWith = 40;
        int BombHeight = 40;
        int BombWith1 = 0;
        int BombHeight1 = 0;
        int posX = 0;
        int posY = 0;
        int stage = 1;
        int drawing = 1;
        Color color = RED;
        while (!WindowShouldClose()) {
            BeginDrawing();

            while (stage == 1) {
                ClearBackground(WHITE);
                DrawText("Press Space to start", Screenwidth/2, Screenheight/5, 25, BLACK);
                if (IsKeyPressed(KEY_SPACE)) {
                    stage = 2;
                }
                EndDrawing();
            }




            while (stage == 2) {
                ClearBackground(WHITE);
                DrawRectangleLines(50, 150, 1200, 450, BLACK);
                //DrawRectangle(50, 50, 500, 500, BLACK);
                for (int i = 0; i < 25; i++) {
                    DrawLine(50 * i, 150, 50 * i, 600, BLACK);
                }
                for (int i = 0; i < 10; i++) {
                    DrawLine(50, 150 + (50 * i), 1250, 150 + (50 * i), BLACK);
                }
                for (int i = 1; i < 10; i++) {
                    DrawText("A" + i, ((450 / 9) * i) + 13, 165, 20, GRAY);
                    DrawText("B" + i, (50 * i) + 13, 165 + 50, 20, GRAY);
                    DrawText("C" + i, (50 * i) + 13, 165 + 100, 20, GRAY);
                    DrawText("D" + i, (50 * i) + 13, 165 + 150, 20, GRAY);
                    DrawText("E" + i, (50 * i) + 13, 165 + 200, 20, GRAY);
                    DrawText("F" + i, (50 * i) + 13, 165 + 250, 20, GRAY);
                    DrawText("G" + i, (50 * i) + 13, 165 + 300, 20, GRAY);
                    DrawText("H" + i, (50 * i) + 13, 165 + 350, 20, GRAY);
                    DrawText("I" + i, (50 * i) + 15, 165 + 400, 20, GRAY);
                }

                DrawRectangle(500, 140, 299, 560, WHITE);
                if (IsKeyPressed(KEY_W)) {
                    y = y - 50;
                } else if (IsKeyPressed(KEY_S)) {
                    y = y + 50;
                } else if (IsKeyPressed(KEY_A)) {
                    x = x - 50;
                } else if (IsKeyPressed(KEY_D)) {
                    x = x + 50;
                }

                if (IsKeyPressed(KEY_ONE)) {
                    BombWith = 40;
                    BombHeight = 39;
                    BombWith = BombWith * 3 + 19;
                } else if (IsKeyPressed(KEY_TWO)) {
                    BombWith = 40;
                    BombHeight = 40;
                    BombWith = BombWith * 2 + 9;
                    BombHeight = BombHeight * 2 + 9;
                } else if (IsKeyPressed(KEY_THREE)) {
                    BombWith = 39;
                    BombHeight = 39;
                } else if (IsKeyPressed(KEY_R)) {
                    BombWith1 = BombHeight;
                    BombHeight1 = BombWith;
                    BombHeight = BombHeight1;
                    BombWith = BombWith1;
                } else if (IsKeyPressed(KEY_SPACE)) {
                    X = x;
                    Y = y;
                    posY = BombWith;
                    posX = BombHeight;
                    if (drawing == 2){
                        drawing = 1;
                    } else if (drawing == 1){
                        drawing = 2;
                    }

                    //DrawRectangle(X, Y, posY, posX, RED);
                }
                if (IsKeyPressed(KEY_UP)) {
                    y2 = y2 - 50;
                } else if (IsKeyPressed(KEY_DOWN)) {
                    y2 = y2 + 50;
                } else if (IsKeyPressed(KEY_LEFT)) {
                    x2 = x2 - 50;
                } else if (IsKeyPressed(KEY_RIGHT)) {
                    x2 = x2 + 50;
                }
                //DrawRectangle(x, y, BombWith, BombHeight, RED);
                //DrawText("1", x + (BombWith / 2) - 3, y + (BombHeight / 2) - 10, 25, BLACK);
                int boatx1 = 0;
                int boaty1 = 0;
                int boatposX = 0;
                int boatposY = 0;
                int boatx2 = 0;
                int boaty2 = 0;
                int boatposX2 = 0;
                int boatposY2 = 0;
                if (drawing == 1) {
                     boatx1 = X;
                     boaty1 = Y;
                     boatposX = posX;
                     boatposY = posY;
                    color = BLUE;
                    //DrawRectangle(boatx1, boaty1, boatposY, boatposX, RED);
                } else if (drawing == 2) {
                     boatx2 = X;
                     boaty2 = Y;
                     boatposX2 = posX;
                     boatposY2 = posY;
                     color = RED;
                //DrawRectangle(boatx2, boaty2, boatposY2, boatposX2, BLUE);
                //drawing = 1;
            }
                DrawRectangle(x, y, (BombWith/3)-7, BombHeight, color);
                DrawRectangle(x+50, y, (BombWith/3)-7, BombHeight, color);
                DrawRectangle(x+100, y, (BombWith/3)-7, BombHeight, color);
                DrawRectangle(boatx2, boaty2, boatposY2, boatposX2, BLUE);
                DrawRectangle(boatx1, boaty1, boatposY, boatposX, RED);
                DrawText("1", x + (BombWith / 2) - 3, y + (BombHeight / 2) - 10, 25, BLACK);

               // DrawRectangle(x2, y2, BombWith, BombHeight, BLUE);
                //DrawText("2", x2 + (BombWith / 2) - 6, y2 + (BombHeight / 2) - 10, 25, BLACK);
                DrawText("1. Long Bomb", 100, 650, 25, GREEN);
                DrawText("2. Big Bertha", 100, 700, 25, GREEN);
                DrawText("3. Normal", 100, 750, 25, GREEN);
                EndDrawing();
            }
        }
    }
}
