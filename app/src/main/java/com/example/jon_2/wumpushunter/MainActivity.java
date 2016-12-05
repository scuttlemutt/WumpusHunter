package com.example.jon_2.wumpushunter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "com.example.WumpusHunter.Main";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void startGame(View view) {

        EditText mEdit = (EditText)findViewById(R.id.nameField);
        String name = mEdit.getText().toString();
        System.out.println(name);
        if(name!=null){
            System.out.println(name);

       }

        Maze maze = new Maze();
        maze.generateMaze(0);

        String[] gameData=new String[3];

        Intent intent = new Intent(getBaseContext(), GameWindow.class);
        intent.putExtra(EXTRA_MESSAGE, gameData);
        startActivity(intent);



    }

}
