import static com.raylib.Colors.*;
import static com.raylib.Raylib.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        boolean newPlace= true;
        int i = 425;
        int j = 425;
        InitWindow( 850, 800, "Window");
        SetTargetFPS(60);
            while(!WindowShouldClose()) {
                BeginDrawing();
                ClearBackground(WHITE);
                //DrawRectangle(0, 0, 1000, 800, BLACK);
                DrawRectangleLines(10, 10, 830, 780, BLACK);
                DrawRectangleLines(245, 245, 360, 360, BLACK);
                DrawLine(120 + 245, 245, 120 + 245, 605, BLACK);
                DrawLine(240 + 245, 245, 240 + 245, 605, BLACK);
                DrawLine(245, 120 + 245, 360 + 245, 120 + 245, BLACK);
                DrawLine(245, 240 + 245, 360 + 245, 240 + 245, BLACK);

                if (IsKeyPressed(KEY_A)) {
                    i = i - 120;
                } else if (IsKeyPressed(KEY_D)) {
                    i = i + 120;
                } else if (IsKeyPressed(KEY_W)) {
                    j = j - 120;
                } else if (IsKeyPressed(KEY_S)) {
                    j = j + 120;
                }
                DrawCircle(i, j, 40, YELLOW);
                DrawText(i + " : " + j, 100, 150, 20, GREEN);
                Boolean Alive = true;
                //int placeX=0;
                //int placeY=0;
                // Thread.sleep(1000);

                //Thread.sleep(10000);

                if (IsKeyDown(KEY_L)) {
                    //Thread.sleep(2500);
                    //placeX = (int) (Math.random() * 3) +1;
                    //placeY = (int) (Math.random() * 3) +1;
                    newPlace = true;

                    Alive = false;
                }
                if (IsKeyDown(KEY_K)) {
                    Alive = true;
                }


                int placeY;
                int placeX;
                if (Alive == false) {

                    //if (newPlace==true) {
                    //Thread.sleep(1000);
                    placeX = (int) (Math.random() * 3);
                    placeY = (int) (Math.random() * 3);
                    //newPlace = false;
                    //}
                    System.out.println(placeX + " " + placeY);
                    //DrawCircle(305+120*placeX, 305+120*placeY, 20, BLUE);
                    //newPlace = false;
                }
                if (Alive == true) {
                    System.out.println(placeX + " "+placeY);
                }

                //int placeY2 = placeY;
                //int placeX2 = placeX;
                DrawCircle(305 + 120 * placeX2, 305 + 120 * placeY2, 20, PINK);
                newPlace = false;
                //DrawCircle(305+120*placeX, 305+120*placeY, 20, YELLOW);

                //DrawCircle(307, 310, 30, YELLOW);
                //DrawRectangle(250, 250, 110, 110, YELLOW );
                //DrawRectangle(255+115, 255, 105, 105, YELLOW );

                DrawFPS(100, 100);
                EndDrawing();
            }


    }
}

        /*
        String appHomeDir = System.getenv("APP_HOME");
        System.out.println(appHomeDir);
        InitWindow(800, 450, "Demo");
        SetTargetFPS(60);
        Camera3D camera = new Camera3D()._position(new Vector3().x(18).y(16).z(18))
                .target(new Vector3())
                .up(new Vector3().x(0).y(1).z(0))
                .fovy(45).projection(CAMERA_PERSPECTIVE);

        while (!WindowShouldClose()) {
            UpdateCamera(camera, CAMERA_ORBITAL);
            BeginDrawing();
            ClearBackground(RAYWHITE);
            BeginMode3D(camera);
            DrawGrid(20, 1.0f);
            EndMode3D();
            DrawText("Skibbidi Fortnite", 190, 200, 20, VIOLET);
            DrawFPS(20, 20);
            EndDrawing();
        }
        CloseWindow();
    }
}

         */