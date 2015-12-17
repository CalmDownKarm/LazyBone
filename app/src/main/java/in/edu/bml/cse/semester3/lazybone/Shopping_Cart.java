package in.edu.bml.cse.semester3.lazybone;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Shopping_Cart extends Activity implements View.OnClickListener {
    int[] order_quantity = new int[3];
    TextView input1,input2,input3,quantity1,quantity2,quantity3,totalcost;
    Button confirm,cancel;
    @Override
    protected void onDestroy(){
        input1.setVisibility(View.INVISIBLE);
        input2.setVisibility(View.INVISIBLE);
        input3.setVisibility(View.INVISIBLE);
        quantity1.setVisibility(View.INVISIBLE);
        quantity2.setVisibility(View.INVISIBLE);
        quantity3.setVisibility(View.INVISIBLE);
        totalcost.setVisibility(View.INVISIBLE);

        super.onDestroy();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping__cart2);
        input1 = (TextView)findViewById(R.id.item1);
        input2 = (TextView)findViewById(R.id.item2);
        input3 = (TextView)findViewById(R.id.item3);
        quantity3 = (TextView)findViewById(R.id.quantity3);
        quantity2 = (TextView)findViewById(R.id.quantity2);
        quantity1 = (TextView)findViewById(R.id.quantity1);
        totalcost = (TextView)findViewById(R.id.totalcost);
        confirm = (Button)findViewById(R.id.confirmation_button);

        cancel = (Button)findViewById(R.id.cancelation_button);
        Intent gg = getIntent();
      //  Toast.makeText(this, "NIGGER", Toast.LENGTH_LONG).show();
        order_quantity = gg.getIntArrayExtra("Order Quantity");
        confirm.setOnClickListener(this);
        cancel.setOnClickListener(this);
        int i=0;
        for(i=0;i<3;i++){
            switch (i){
                case 0:
                        if(order_quantity[i]!=0){
                                input1.setVisibility(View.VISIBLE);
                                quantity1.setVisibility(View.VISIBLE);
                                quantity1.setText(Integer.toString(order_quantity[0]));
                        }
                        break;
                case 1:
                    if(order_quantity[i]!=0){
                        input2.setVisibility(View.VISIBLE);
                        quantity2.setVisibility(View.VISIBLE);
                        quantity2.setText(Integer.toString(order_quantity[1]));
                    }
                    break;
                case 2:
                    if(order_quantity[i]!=0){
                        input3.setVisibility(View.VISIBLE);
                        quantity3.setVisibility(View.VISIBLE);
                        quantity3.setText(Integer.toString(order_quantity[2]));
                    }
            }
        }
        int total = 40*order_quantity[0]+45*order_quantity[1]+90*order_quantity[2];
        totalcost.setText(Integer.toString(total));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.confirmation_button:
                SmsManager smsManager = SmsManager.getDefault();
                String SmsString = "Order ID : ABCD\nNaan ";
                Toast.makeText(this, "ORDER PLACED", Toast.LENGTH_SHORT).show();
                SmsString+=Integer.toString(order_quantity[0])+"\nParantha "+Integer.toString(order_quantity[1])+"\nPaneer "+Integer.toString(order_quantity[2]);
                smsManager.sendTextMessage(getResources().getString(R.string.RaoNumber), null, SmsString, null, null);
                Intent finishOrder = new Intent(this, FinishOrder.class);
                startActivity(finishOrder);
                break;
            case R.id.cancelation_button:
                int i=0;

                for(i=0;i<3;i++){
                    order_quantity[i]=0;
                }
                Intent backpeddle = new Intent(this, OrderActivity.class);
                startActivity(backpeddle);

        }
    }
}
