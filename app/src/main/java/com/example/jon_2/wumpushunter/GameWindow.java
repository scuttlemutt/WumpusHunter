package com.example.jon_2.wumpushunter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class GameWindow extends AppCompatActivity {

  //  public final static String[] EXTRA_MESSAGE = "com.example.WumpusHunter.Main";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_window);

        String[] foo =getIntent().getStringArrayExtra("GAME_DATA");
        Maze maze = new Maze(Integer.parseInt(foo[0]), Integer.parseInt(foo[1]));

        String s=maze.printMaze();
        System.out.println(s);

        TextView mazeDebug = (TextView) findViewById(R.id.mazePrint);
        mazeDebug.setText(s);
        mazeDebug.setMovementMethod(new ScrollingMovementMethod());

        LinearLayout layout = (TableRow) findViewById(R.id.buttonPanel);
        layout.setOrientation(LinearLayout.VERTICAL);  //Can also be done in xml by android:orientation="vertical"
        for (int i = 0; i < 3; i++) {
            LinearLayout row = new LinearLayout(this);
            row.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));

            for (int j = 0; j < 4; j++) {
                Button btnTag = new Button(this);
                btnTag.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
                btnTag.setText("Button " + (j + 1 + (i * 4)));
                btnTag.setId(j + 1 + (i * 4));
                row.addView(btnTag);
            }


            layout.addView(row);
        }

    }




}
