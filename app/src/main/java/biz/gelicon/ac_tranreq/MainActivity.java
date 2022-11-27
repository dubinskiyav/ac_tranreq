package biz.gelicon.ac_tranreq;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import biz.gelicon.ac_tranreq.adapter.TabAdapter;
import biz.gelicon.ac_tranreq.model.Tab;

public class MainActivity extends AppCompatActivity {

    RecyclerView tabRecycler;
    TabAdapter tabAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Tab> tabList = new ArrayList<>();
        tabList.add(new Tab(1, "Общее"));
        tabList.add(new Tab(2, "Доп-но"));
        tabList.add(new Tab(3, "Ст-сть"));
        tabList.add(new Tab(4, "Маршрут"));
        tabList.add(new Tab(5, "Аналит."));
        tabList.add(new Tab(6, "Эл. мат."));

        setTabRecycler(tabList);

    }

    private void setTabRecycler(List<Tab> tabList) {

        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        tabRecycler = findViewById(R.id.tabRecycler);
        tabRecycler.setLayoutManager(layoutManager);

        tabAdapter = new TabAdapter(this, tabList);
        tabRecycler.setAdapter(tabAdapter);

    }
}