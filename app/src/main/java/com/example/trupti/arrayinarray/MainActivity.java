package com.example.trupti.arrayinarray;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    TextView t1,t2,t3,t4;

    String rmc=" { \"data\":" +
            "[{\"DT_RowId\":\"row_1\"," +
            "\"PPID\":\"1\"," +
            "\"PPNo\":\"1\"," +
            "\"PPDate\":\"27-03-2018\"," +
            "\"Remarks\":\"TEST\"," +
            "\"EMPName\":\"ATUL\"," +
            "\"Shift\":\"Day\"," +
            "\"PPItemArray\":" +
            "[{\"PPItemID\":\"1\"," +
            "\"OrderID\":\"536\"," +
            "\"OrderNo\":\"517\"," +
            "\"ProductName\":\"GAME NACHLO NACHLO Rs. 5 \"," +
            "\"ProductCode\":\"SAI\\/NCHL5\"," +
            "\"ProductSize\":\"790\"," +
            "\"OrderQty\":\"500\"," +
            "\"PetQty\":\"185.663\"," +
            "\"PetUsedQty\":\"0.000\"}]}] } ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        t1=(TextView)findViewById(R.id.one);
        t2=(TextView)findViewById(R.id.two);
        t3=(TextView)findViewById(R.id.three);
        t4=(TextView)findViewById(R.id.four);


        jasonload();
    }

    private void jasonload() {

        try {
            JSONObject jsonObjecta=new JSONObject(rmc);


            JSONArray jsonArraya=jsonObjecta.getJSONArray("data");
            for (int i = 0; i < jsonArraya.length(); i++) {
                JSONObject jo = jsonArraya.getJSONObject(i);


                String rowid=jo.getString("DT_RowId");
                t1.setText(rowid);

                String EMPName=jo.getString("EMPName");
                t2.setText(EMPName);


                String Shift=jo.getString("Shift");
                t3.setText(Shift);
                Log.d("shift","shift"+Shift);


                JSONArray fjsonArray =new JSONArray(jsonArraya.getJSONObject(i).getString("PPItemArray"));
                for (int j=0;j<fjsonArray.length();j++){

                    String orderid=fjsonArray.getJSONObject(j).getString("OrderID");
                    t4.setText(orderid);
                }








            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }





}
