package biz.gelicon.ac_tranreq;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import biz.gelicon.ac_tranreq.adapter.TranreqtypeAdapter;
import biz.gelicon.ac_tranreq.adapter.CategoryAdapter;
import biz.gelicon.ac_tranreq.model.Tranreqtype;
import biz.gelicon.ac_tranreq.model.Tab;

public class MainActivity extends AppCompatActivity {

    // https://www.youtube.com/watch?v=XWZGI-JqYiE&ab_channel=%D0%93%D0%BE%D1%88%D0%B0%D0%94%D1%83%D0%B4%D0%B0%D1%80%D1%8C

    RecyclerView tabRecycler;
    CategoryAdapter categoryAdapter;

    RecyclerView tranreqtypeRecycler;
    static TranreqtypeAdapter tranreqtypeAdapter;
    static List<Tranreqtype> tranreqtypeList = new ArrayList<>();
    static List<Tranreqtype> fullTranreqtypeList = new ArrayList<>();

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


        tranreqtypeList.add(new Tranreqtype(20011, "01", "Плановая", "schedule", "#C0C0C0", "Плановая Плановая", 3));
        tranreqtypeList.add(new Tranreqtype(20012, "02", "Аварийная", "crash", "#A52A2A", "Аварийная Аварийная", 3));
        tranreqtypeList.add(new Tranreqtype(20013, "03", "Срочная", "urgent", "#FF1493", "Срочная Срочная",1));
        tranreqtypeList.add(new Tranreqtype(20014, "04", "Дежурство на дому", "house", "#00FF7F", "Дежурство на дому Дежурство на дому",1));
        tranreqtypeList.add(new Tranreqtype(20015, "05", "Командировка", "trip", "#ADD8E6", "Командировка Командировка",2));

        // Заполним весь список
        fullTranreqtypeList.addAll(tranreqtypeList);

        settranreqtypeRecycler(tranreqtypeList);

    }

    public void openShoppingCard(View view) {
        Intent intent = new Intent(this, OrderPage.class);
        startActivity(intent);
    }


    private void settranreqtypeRecycler(List<Tranreqtype> tranreqtypeList) {
        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        tranreqtypeRecycler = findViewById(R.id.tranreqtypeRecycler);
        tranreqtypeRecycler.setLayoutManager(layoutManager);

        tranreqtypeAdapter = new TranreqtypeAdapter(this, tranreqtypeList);
        tranreqtypeRecycler.setAdapter(tranreqtypeAdapter);
    }

    private void setTabRecycler(List<Tab> tabList) {

        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        tabRecycler = findViewById(R.id.tabRecycler);
        tabRecycler.setLayoutManager(layoutManager);

        categoryAdapter = new CategoryAdapter(this, tabList);
        tabRecycler.setAdapter(categoryAdapter);

    }

    /**
     * Показывает только отфтльтрованный список типов заявки
     * @param category - категория
     */
    public static void showTranreqByCategory(int category) {

        tranreqtypeList.clear();

        List<Tranreqtype> filterTranregtypes = new ArrayList<>();

        for (Tranreqtype t : fullTranreqtypeList) {
            if (t.getCategory() == category) {
                filterTranregtypes.add(t);
            }
        }
        tranreqtypeList.addAll(filterTranregtypes);
        // Перерисуем
        tranreqtypeAdapter.notifyDataSetChanged();
    }
    
}