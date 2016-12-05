package com.example.jon_2.wumpushunter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

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

//        Spinner mySpinner=(Spinner) findViewById(R.id.spinner);
//        String sides = mySpinner.getSelectedItem().toString();

        Spinner mySpinner=(Spinner) findViewById(R.id.vertexSpinner);
        String vertexes = mySpinner.getSelectedItem().toString();

        Spinner mySpinner2=(Spinner) findViewById(R.id.connectionSpinner);
        String connections = mySpinner2.getSelectedItem().toString();

        Maze maze = new Maze();
        maze.generateMaze2(Integer.parseInt(vertexes), Integer.parseInt(connections));

        String[] gameData=new String[3];

        Intent intent = new Intent(getBaseContext(), GameWindow.class);
        intent.putExtra(EXTRA_MESSAGE, gameData);
        startActivity(intent);



    }

}
