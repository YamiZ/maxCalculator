package com.vogella.testapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView p95, p90, p85,p80,p75,p70,p65,p60,p55,p50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         p95 = (TextView) findViewById(R.id.p95);
         p90 = (TextView) findViewById(R.id.p90);
         p85 = (TextView) findViewById(R.id.p85);
         p80 = (TextView) findViewById(R.id.p80);
         p75 = (TextView) findViewById(R.id.p75);
         p70 = (TextView) findViewById(R.id.p70);
         p65 = (TextView) findViewById(R.id.p65);
         p60 = (TextView) findViewById(R.id.p60);
         p55 = (TextView) findViewById(R.id.p55);
         p50 = (TextView) findViewById(R.id.p50);
    }

    public void CalcRm(View view) {
        TextView tv = (TextView) findViewById(R.id.result);
        Spinner s = (Spinner) findViewById(R.id.repsSelected);
        EditText w = (EditText) findViewById((R.id.weightEntered));
        if(w.getText().toString().isEmpty()!=true) {
            int x = calcOneRep(Integer.parseInt(w.getText().toString()), Integer.parseInt(s.getSelectedItem().toString()));
            setPercent(x);
            tv.setText("" + x);
        }else{
            clearPercent();
            tv.setText("");
        }
    }

    public int calcOneRep(int weight, int rep){
        return (int) Math.ceil(weight/getPercent(rep));
    }

    public int calcPercent(int x, double y){
        return (int) Math.ceil(x*y);
    }

    public void setPercent(int x){
        p50.setText(""+calcPercent(x,.5));
        p55.setText(""+calcPercent(x, .55));
        p60.setText(""+calcPercent(x,.6));
        p65.setText(""+calcPercent(x,.65));
        p70.setText(""+calcPercent(x,.7));
        p75.setText(""+calcPercent(x,.75));
        p80.setText(""+calcPercent(x,.8));
        p85.setText(""+calcPercent(x,.85));
        p90.setText(""+calcPercent(x,.9));
        p95.setText(""+calcPercent(x,.95));
    }

    public void clearPercent(){
        p50.setText("n/a");
        p55.setText("n/a");
        p60.setText("n/a");
        p65.setText("n/a");
        p70.setText("n/a");
        p75.setText("n/a");
        p80.setText("n/a");
        p85.setText("n/a");
        p90.setText("n/a");
        p95.setText("n/a");
    }

    public double getPercent(int x){
        switch(x){
            case 1:
                return 1;
            case 2:
                return .95;
            case 3:
                return .93;
            case 4:
                return .90;
            case 5:
                return .87;
            case 6:
                return .85;
            case 7:
                return .83;
            case 8:
                return .80;
            case 9:
                return .77;
            case 10:
                return .75;
            case 11:
                return .73;
            case 12:
                return .70;
        }
        return 0;
    }
}

