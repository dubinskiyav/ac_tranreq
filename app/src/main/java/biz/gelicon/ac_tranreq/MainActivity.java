package biz.gelicon.ac_tranreq;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import biz.gelicon.ac_tranreq.adapter.RequerttypeAdapter;
import biz.gelicon.ac_tranreq.adapter.TabAdapter;
import biz.gelicon.ac_tranreq.model.tranreqtype;
import biz.gelicon.ac_tranreq.model.Tab;

public class MainActivity extends AppCompatActivity {

    RecyclerView tabRecycler;
    TabAdapter tabAdapter;

    RecyclerView tranreqtypeRecycler;
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

        List<tranreqtype> tranreqtypeList = new ArrayList<>();
        tranreqtypeList.add(new tranreqtype(20011, "01", "Плановая", "schedule", "#C0C0C0"));
        tranreqtypeList.add(new tranreqtype(20012, "02", "Аварийная", "crash", "#A52A2A"));
        tranreqtypeList.add(new tranreqtype(20013, "03", "Срочная", "urgent", "#FF1493"));
        tranreqtypeList.add(new tranreqtype(20014, "04", "Дежурство на дому", "house", "#00FF7F"));
        tranreqtypeList.add(new tranreqtype(20015, "05", "Командировка", "trip", "#ADD8E6"));

        settranreqtypeRecycler(tranreqtypeList);


    }

    private void settranreqtypeRecycler(List<tranreqtype> tranreqtypeList) {
        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        tranreqtypeRecycler = findViewById(R.id.tranreqtypeRecycler);
        tranreqtypeRecycler.setLayoutManager(layoutManager);

        requerttypeAdapter = new RequerttypeAdapter(this, tranreqtypeList);
        tranreqtypeRecycler.setAdapter(requerttypeAdapter);
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