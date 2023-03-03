package com.example.szewonglastinitial_3175mt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //Datas
    List<String> CampNames = new ArrayList<>(Arrays.asList("Karate Kicks","Soccer Goals","Theatre"));
    List<String> CampTimes = new ArrayList<>(Arrays.asList("Morning Camp","Afternoon Camp"));
    List<Integer> CampTimePics = new ArrayList<>(Arrays.asList(R.drawable.amicon,R.drawable.pmicon));
    List<Integer> CampImages = new ArrayList<>(Arrays.asList(R.drawable.karate,R.drawable.soccer,R.drawable.theatre));
    List<Integer> SongRaws = new ArrayList<>(Arrays.asList(R.raw.karate,R.raw.soccer,R.raw.theatre));
    List<Camp> CampTimeList = new ArrayList<>();
    List<Camp> CampList = new ArrayList<>();
    EditText parentName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadCampTimeModelData();

        //Link to adapter


        parentName = findViewById(R.id.editTextParentName);
        ListView listViewShowTime = findViewById(R.id.listViewShowTimes);
        CampAdapter campAdapter = new CampAdapter(CampTimeList);
        listViewShowTime.setAdapter(campAdapter);

        if(parentName.getText().toString().isEmpty()){
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        }

        listViewShowTime.setOnItemClickListener((parent, view, position, id) -> {
                campAdapter.setSelectedInd(position);
                campAdapter.notifyDataSetChanged();
                Intent myResult = new Intent(MainActivity.this, MainActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("PARENTNAME", parentName.getText().toString());
                bundle.putString("CAMPTIME", CampTimes.get(position));
                myResult.putExtras(bundle);
                startActivity(myResult);
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            });
    }


    //Load data
    private void loadCampTimeModelData(){
        for(int i=0;i<CampTimePics.size();i++){
            Camp eachCampTime = new Camp(CampTimes.get(i),CampTimePics.get(i));
            CampTimeList.add(eachCampTime);
        }
    }
}