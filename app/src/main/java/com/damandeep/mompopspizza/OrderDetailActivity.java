package com.damandeep.mompopspizza;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class OrderDetailActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<String> orderList;
    private int userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);

        orderList = new ArrayList<>();

        listView = findViewById(R.id.order_list);
        ArrayAdapter adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,orderList);
        listView.setAdapter(adapter);

        OrderDatabaseHelper ODH = new OrderDatabaseHelper(this);

        Intent intent = getIntent();
        userID = intent.getIntExtra("userID", 0);

        Cursor cursor = ODH.getData(userID);


        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                String orderDetail = "Order ID: " + cursor.getString(cursor.getColumnIndex(OrderDatabaseHelper.COL0));

                if (!cursor.getString(cursor.getColumnIndex(OrderDatabaseHelper.COL2)).equals("0")) {
                    orderDetail += "\n\nPizza Order: ";
                    orderDetail += "\nToppings: " + cursor.getString(cursor.getColumnIndex(OrderDatabaseHelper.COL3)) + " "
                            + cursor.getString(cursor.getColumnIndex(OrderDatabaseHelper.COL4)) + " "
                            + cursor.getString(cursor.getColumnIndex(OrderDatabaseHelper.COL5));
                    orderDetail += "\nSize: " + cursor.getString(cursor.getColumnIndex(OrderDatabaseHelper.COL6));
                    orderDetail += "\nQty: " + cursor.getString(cursor.getColumnIndex(OrderDatabaseHelper.COL7));
                    orderDetail += "\nPrice: $" + cursor.getString(cursor.getColumnIndex(OrderDatabaseHelper.COL8));

                }

                if (!cursor.getString(cursor.getColumnIndex(OrderDatabaseHelper.COL9)).equals("0")) {
                    orderDetail += "\n\nCalzone Order: ";
                    orderDetail += "\nToppings: " + cursor.getString(cursor.getColumnIndex(OrderDatabaseHelper.COL10)) + " "
                            + cursor.getString(cursor.getColumnIndex(OrderDatabaseHelper.COL11)) + " "
                            + cursor.getString(cursor.getColumnIndex(OrderDatabaseHelper.COL12));
                    orderDetail += "\nSize: " + cursor.getString(cursor.getColumnIndex(OrderDatabaseHelper.COL13));
                    orderDetail += "\nQty: " + cursor.getString(cursor.getColumnIndex(OrderDatabaseHelper.COL14));
                    orderDetail += "\nPrice: $" + cursor.getString(cursor.getColumnIndex(OrderDatabaseHelper.COL15));

                }

                if (!cursor.getString(cursor.getColumnIndex(OrderDatabaseHelper.COL16)).equals("0")) {
                    orderDetail += "\n\nPasta Order: ";
                    orderDetail += "\nToppings: " + cursor.getString(cursor.getColumnIndex(OrderDatabaseHelper.COL17)) + " "
                            + cursor.getString(cursor.getColumnIndex(OrderDatabaseHelper.COL18)) + " "
                            + cursor.getString(cursor.getColumnIndex(OrderDatabaseHelper.COL19));
                    orderDetail += "\nQty: " + cursor.getString(cursor.getColumnIndex(OrderDatabaseHelper.COL20));
                    orderDetail += "\nPrice: $" + cursor.getString(cursor.getColumnIndex(OrderDatabaseHelper.COL21));

                }

                if (!cursor.getString(cursor.getColumnIndex(OrderDatabaseHelper.COL22)).equals("0")) {
                    orderDetail += "\n\nWings Order: ";
                    orderDetail += "\nSauce: " + cursor.getString(cursor.getColumnIndex(OrderDatabaseHelper.COL23)) + " "
                            + cursor.getString(cursor.getColumnIndex(OrderDatabaseHelper.COL24)) + " "
                            + cursor.getString(cursor.getColumnIndex(OrderDatabaseHelper.COL25));
                    orderDetail += "\nQty: " + cursor.getString(cursor.getColumnIndex(OrderDatabaseHelper.COL26));
                    orderDetail += "\nPrice: $" + cursor.getString(cursor.getColumnIndex(OrderDatabaseHelper.COL27));

                }

                if (!cursor.getString(cursor.getColumnIndex(OrderDatabaseHelper.COL28)).equals("0")) {
                    orderDetail += "\n\nFries Order: ";
                    orderDetail += "\nSize: " + cursor.getString(cursor.getColumnIndex(OrderDatabaseHelper.COL29));
                    orderDetail += "\nQty: " + cursor.getString(cursor.getColumnIndex(OrderDatabaseHelper.COL30));
                    orderDetail += "\nPrice: $" + cursor.getString(cursor.getColumnIndex(OrderDatabaseHelper.COL31));

                }

                if (!cursor.getString(cursor.getColumnIndex(OrderDatabaseHelper.COL32)).equals("0")) {
                    orderDetail += "\n\nSoda Order: ";
                    orderDetail += "\nType: " + cursor.getString(cursor.getColumnIndex(OrderDatabaseHelper.COL33));
                    orderDetail += "\nQty: " + cursor.getString(cursor.getColumnIndex(OrderDatabaseHelper.COL34));
                    orderDetail += "\nPrice: $" + cursor.getString(cursor.getColumnIndex(OrderDatabaseHelper.COL35));

                }

                orderDetail += "\n\nGrand Total: "  + cursor.getString(cursor.getColumnIndex(OrderDatabaseHelper.COL36));

                orderList.add(orderDetail);
                cursor.moveToNext();
            }
        }

        cursor.close();

    }
}
