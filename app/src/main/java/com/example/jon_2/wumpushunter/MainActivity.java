package com.example.jon_2.wumpushunter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

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
        maze.generateMaze();
    }

}
