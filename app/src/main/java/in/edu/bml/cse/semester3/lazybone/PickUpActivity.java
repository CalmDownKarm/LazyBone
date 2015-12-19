package in.edu.bml.cse.semester3.lazybone;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class PickUpActivity extends AppCompatActivity implements  View.OnClickListener{
    String order_info;
    ImageButton input;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_pick_up);
        Intent in = getIntent();
       // order_info = in.getStringExtra("Order Info");
        input = (ImageButton)findViewById(R.id.buttonpicked);

        input.setOnClickListener(this);
        SmsManager smsManager = SmsManager.getDefault();
        String SmsString = "Order Number ABCD is AT THE GATE";
        smsManager.sendTextMessage(getResources().getString(R.string.ReceiverNumber), null, SmsString, null, null);
    }

    @Override
    public void onClick(View v) {
        Intent out = new Intent(getApplicationContext(),Final.class);
        startActivity(out);
    }
}
