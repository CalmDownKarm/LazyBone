package in.edu.bml.cse.semester3.lazybone;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class OrderActivity extends AppCompatActivity implements View.OnClickListener {
    String info[] = new String[3];
    ImageButton rao;
    ImageButton muskaan;
    ImageButton adda;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Intent in = getIntent();
        info = in.getStringArrayExtra("info");
        rao = (ImageButton) findViewById(R.id.RAO);
        rao.setOnClickListener(this);
        muskaan = (ImageButton) findViewById(R.id.muskaan);
        muskaan.setOnClickListener(this);
        adda = (ImageButton) findViewById(R.id.Adda);
        adda.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.RAO:
                Intent newintent = new Intent(this,Rao_Order.class);
                newintent.putExtra("Info",info);
                startActivity(newintent);
                break;
            case R.id.muskaan:
                //TODO: INTENT TO MUSKAAN ORDER SCREEN
                break;
            case R.id.Adda:
                //TODO INTENT TO ADDA ORDER SCREEN
                break;
        }
    }
}
