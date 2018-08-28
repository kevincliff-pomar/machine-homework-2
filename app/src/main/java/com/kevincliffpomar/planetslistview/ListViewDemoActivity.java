package com.kevincliffpomar.planetslistview;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListViewDemoActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView planetsListView = null;
    private int[] drawableIds = {
            R.drawable.img_id_row1, R.drawable.img_id_row2,
            R.drawable.img_id_row3, R.drawable.img_id_row4,
            R.drawable.img_id_row5, R.drawable.img_id_row6,
            R.drawable.img_id_row7, R.drawable.img_id_row8,
            R.drawable.img_id_row9 };
    private String[] planets = {
            "Mercury",
            "Venus",
            "Earth",
            "Mars",
            "Jupiter",
            "Saturn",
            "Neptune",
            "Uranus",
            "Pluto",};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_demo);

        planetsListView = findViewById(R.id.planets_listview);
        PlanetsAdapter adapter = new PlanetsAdapter(this, R.layout.planets_item_layout, planets, drawableIds);
        planetsListView.setAdapter(adapter);
        planetsListView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView planetsTextView = view.findViewById(R.id.planet_name);
        if (planetsTextView.getText().toString().equals("Pluto")){
            Toast.makeText(this, planetsTextView.getText().toString() + " is not part of solar system anymore" , Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this, planetsTextView.getText().toString() + " is part of solar system." , Toast.LENGTH_LONG).show();
        }
    }

}
