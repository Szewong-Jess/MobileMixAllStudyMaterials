package com.example.szewonglastinitial_3175mt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {
    Spinner spinnerCamp;
    RadioGroup radioGroup;
    ImageView imgViewChosenCamp;
    EditText editTextNumKids;
    Button btn;
    double TotalCost;
    TextView txtViewResults;
    List<Double> costList = new ArrayList<>();
    String result="";
    String resultFood="";
    TextView txtViewParentNameCampTime;
    String outPutStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        try{
            Bundle bundle = getIntent().getExtras();
            if(bundle != null){
                String parentName = bundle.getString("PARENTNAME");
                String camTime = bundle.getString("CAMPTIME");
                Log.d("bundle:",parentName);
                outPutStr = String.format("Parent Name: "+parentName +"\n"+"Camp Time: "+camTime);
                txtViewParentNameCampTime = findViewById(R.id.txtViewParentNameCampTime);
                txtViewParentNameCampTime.setText(outPutStr);

                txtViewParentNameCampTime.setGravity(Gravity.CENTER);
                txtViewParentNameCampTime.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL);}

        }catch (Exception ex){
            ex.printStackTrace();
        }



        spinnerCamp = findViewById(R.id.spinnerCamps);
        editTextNumKids = findViewById(R.id.editTextNumKids);
        imgViewChosenCamp = findViewById(R.id.imgViewChosenCamp);
        btn = findViewById(R.id.btnBookCamp);
        radioGroup = findViewById(R.id.radGroupFoodNeeded);

        spinnerCamp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                double cost = 0;
               // if(!(editTextNumKids.getText().toString()).isEmpty()) {
                    if (position == 0) {
                        imgViewChosenCamp.setImageResource(R.drawable.soccer);
                        result ="Type: Soccer Goals \n";
                        TotalCost = 165.99;
                    } else if (position == 1) {
                        imgViewChosenCamp.setImageResource(R.drawable.theatre);
                        result ="Type: Theatre Acts \n";
                        TotalCost = 179.9;
                    } else if (position == 2) {
                        imgViewChosenCamp.setImageResource(R.drawable.karate);
                        result ="Type: Karate Kicks \n";
                        TotalCost = 189.99;
                    }
               // }else{
               //     Toast.makeText(SecondActivity.this, "Number of kids can not be empty!", Toast.LENGTH_SHORT).show();
              //  }
            }
            //
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if(checkedId == R.id.radBtnFood){
                double FinTotalCost = (TotalCost *Double.parseDouble(editTextNumKids.getText().toString())) + 29.9;
                resultFood ="Food: needed \n"+ "Final cost is" + FinTotalCost;
            }else if(checkedId == R.id.radBtnNoFood){
                double FinTotalCost = (TotalCost * Double.parseDouble(editTextNumKids.getText().toString()));
                resultFood = "Food: No need \n"+"Final cost is" + FinTotalCost;
            }
        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtViewResults = findViewById(R.id.txtViewResults);
                String finalOutPut = result + resultFood ;
                txtViewResults.setText(finalOutPut);
            }
        });



    }
}