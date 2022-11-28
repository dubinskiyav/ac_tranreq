package biz.gelicon.ac_tranreq;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import biz.gelicon.ac_tranreq.adapter.RequerttypeAdapter;
import biz.gelicon.ac_tranreq.adapter.TabAdapter;
import biz.gelicon.ac_tranreq.model.Requesttype;
import biz.gelicon.ac_tranreq.model.Tab;

public class MainActivity extends AppCompatActivity {

    RecyclerView tabRecycler;
    TabAdapter tabAdapter;

    RecyclerView requesttypeRecycler;
    RequerttypeAdapter requerttypeAdapter;

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

        List<Requesttype> requesttypeList = new ArrayList<>();
        requesttypeList.add(new Requesttype(20011, "01", "Плановая", "schedule", "#C0C0C0"));
        requesttypeList.add(new Requesttype(20012, "02", "Аварийная", "crash", "#A52A2A"));
        requesttypeList.add(new Requesttype(20013, "03", "Срочная", "urgent", "#FF1493"));
        requesttypeList.add(new Requesttype(20014, "04", "Дежурство на дому", "house", "#00FF7F"));
        requesttypeList.add(new Requesttype(20015, "05", "Командировка", "trip", "#ADD8E6"));

        setRequesttypeRecycler(requesttypeList);


    }

    private void setRequesttypeRecycler(List<Requesttype> requesttypeList) {
        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        requesttypeRecycler = findViewById(R.id.requesttypeRecycler);
        requesttypeRecycler.setLayoutManager(layoutManager);

        requerttypeAdapter = new RequerttypeAdapter(this, requesttypeList);
        requesttypeRecycler.setAdapter(requerttypeAdapter);
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