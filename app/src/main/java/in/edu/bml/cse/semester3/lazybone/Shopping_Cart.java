package in.edu.bml.cse.semester3.lazybone;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class Shopping_Cart extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping__cart2);
        Intent fuck = getIntent();
        int [] order_quantity = fuck.getIntArrayExtra("Order Quantity");
        Log.d("TAG", Integer.toString(order_quantity[0]));
    }
}
