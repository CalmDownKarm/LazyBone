package in.edu.bml.cse.semester3.lazybone;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentManager;
import android.app.ListFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Rao_Order extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentManager fm = getFragmentManager();
        if (fm.findFragmentById(android.R.id.content) == null) {
            SimpleListFragment list = new SimpleListFragment();
            fm.beginTransaction().add(android.R.id.content, list).commit();
        }
    }


    public static class SimpleListFragment extends ListFragment {
        public int[] order_quantity = {0, 0, 0};
        @Override
        public void onSaveInstanceState(Bundle outState){
            super.onSaveInstanceState(outState);
            outState.putIntArray("Order Quantity", order_quantity);
        }

        //public List<String> Order= new ArrayList<String>();
        String[] items = new String[]{"Naan", "Parantha", "Shahi Paneer","Show Cart"};
        @Override
        public void onListItemClick(ListView l, View v, int position, long id) {
            String itemValue = (String) l.getItemAtPosition(position);

            if(itemValue.equals("Show Cart")){
                Intent intent = new Intent(getActivity(), Shopping_Cart.class);
                intent.putExtra("Order Quantity", order_quantity);
                startActivity(intent);
            }
            else{
                order_quantity[position]++;
                Log.d("LIST", itemValue+Integer.toString(order_quantity[position]));
                Toast.makeText(getActivity(), "ADDED", Toast.LENGTH_SHORT).show();
            }



            /*for(String s: Order){
                Log.d("LIST", s);
            }*/
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                    inflater.getContext(), android.R.layout.simple_list_item_1,
                    items);
            setListAdapter(adapter);
            return super.onCreateView(inflater, container, savedInstanceState);
        }

    }
}



