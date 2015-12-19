package in.edu.bml.cse.semester3.lazybone;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class OrderOrPickup extends AppCompatActivity implements View.OnClickListener{
    String info[] =  new String[3];
    ImageButton order;
    ImageButton pickup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Cuz who needs an APIClientObject
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_order_or_pickup);
            Intent in = getIntent();
            order = (ImageButton)findViewById(R.id.Order);
            pickup = (ImageButton)findViewById(R.id.PickUp);
            order.setOnClickListener(this);
            pickup.setOnClickListener(this);
            info = in.getStringArrayExtra("Info");
            Log.d("ORDER OR PICKUP",info[0]);
            Log.d("ORDER OR PICKUP",info[1]);
            Log.d("ORDER OR PICKUP",info[2]);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Order:

                Intent intent = new Intent(this,OrderActivity.class);
                intent.putExtra("Info",info);
                startActivity(intent);
                break;
            case R.id.PickUp:
                Intent shitintent = new Intent(this, Wait.class);
                shitintent.putExtra("info",info);
                startActivity(shitintent);
                break;
        }
    }
}