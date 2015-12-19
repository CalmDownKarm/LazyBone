package in.edu.bml.cse.semester3.lazybone;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class FinishOrder extends Activity implements View.OnClickListener {
ImageButton button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_order);
        button = (ImageButton)findViewById(R.id.buttonrecvd);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent newb = new Intent(this, Final.class);
        startActivity(newb);
    }
}
