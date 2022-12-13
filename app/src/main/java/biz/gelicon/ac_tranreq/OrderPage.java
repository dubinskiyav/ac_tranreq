package biz.gelicon.ac_tranreq;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import biz.gelicon.ac_tranreq.model.Order;
import biz.gelicon.ac_tranreq.model.Tranreqtype;

public class OrderPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_page);

        ListView orders_list = findViewById(R.id.orders_list);

        List<String> coursesTitle = new ArrayList<>();
        for (Tranreqtype t: MainActivity.fullTranreqtypeList) {
            if (Order.items_id.contains(t.getId())) {
                coursesTitle.add(t.getName());
            }
        }

        orders_list.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, coursesTitle));
    }
}