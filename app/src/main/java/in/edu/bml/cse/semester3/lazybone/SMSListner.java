package in.edu.bml.cse.semester3.lazybone;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Telephony;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

public class SMSListner extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (Telephony.Sms.Intents.SMS_RECEIVED_ACTION.equals(intent.getAction())) {
            for (SmsMessage smsMessage : Telephony.Sms.Intents.getMessagesFromIntent(intent)) {
                String messageBody = smsMessage.getMessageBody();
                if(messageBody!=null){
                    if(messageBody.contains("Order Number ABCD AT GATE")){
                        Toast.makeText(context, messageBody, Toast.LENGTH_SHORT).show();
                        Intent myIntent = new Intent ( context,AtGate.class );
                        myIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(myIntent);
                        //Trigger an SMS TO RECEIVER
                    }
                    else if(messageBody.contains("Order Number ABCD FOR PICKUP")){
                        Toast.makeText(context, messageBody, Toast.LENGTH_SHORT).show();
                        Intent phone = new Intent();
                        Intent myIntent = new Intent ( context,PickUpActivity.class );
                        myIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(myIntent);

                    }
                }

            }
        }
    }
}