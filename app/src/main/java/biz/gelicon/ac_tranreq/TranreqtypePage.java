package biz.gelicon.ac_tranreq;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import biz.gelicon.ac_tranreq.model.Order;

public class TranreqtypePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tranreqtype_page);

        // найдем объекты из дизанйа
        ConstraintLayout tranreqtypePageBg = findViewById(R.id.tranreqtypePageBg);

        ImageView tranreqtypePageImage = findViewById(R.id.tranreqtypePageImage);
        TextView tranreqtypePageName = findViewById(R.id.tranreqtypePageName);
        TextView tranreqtypePageCode = findViewById(R.id.tranreqtypePageCode);
        TextView tranreqtypeText = findViewById(R.id.tranreqtypeText);

        // Установим значения из переданных в адаптере
        tranreqtypePageBg.setBackgroundColor(getIntent().getIntExtra("tranreqtypeBg", 0));
        tranreqtypePageImage.setImageResource(getIntent().getIntExtra("tranreqtypeImage", 0));
        tranreqtypePageName.setText(getIntent().getStringExtra("tranreqtypeName"));
        tranreqtypePageCode.setText(getIntent().getStringExtra("tranreqtypeCode"));
        tranreqtypeText.setText(getIntent().getStringExtra("tranreqtypeText"));
    }

    public void addToCard(View view) {
        int item_id = getIntent().getIntExtra("tranreqtypeId", 0);
        Order.items_id.add(item_id);
        Toast.makeText(this, "Добавлено! :", Toast.LENGTH_LONG).show();
    }
}