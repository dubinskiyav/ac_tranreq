package biz.gelicon.ac_tranreq.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import biz.gelicon.ac_tranreq.R;
import biz.gelicon.ac_tranreq.TranreqtypePage;
import biz.gelicon.ac_tranreq.model.tranreqtype;

public class TranreqtypeAdapter extends RecyclerView.Adapter<TranreqtypeAdapter.tranreqtypeViewHolder> {

    Context context;
    List<tranreqtype> tranreqtypes;

    public TranreqtypeAdapter(Context context, List<tranreqtype> tranreqtypes) {
        this.context = context;
        this.tranreqtypes = tranreqtypes;
    }

    @NonNull
    @Override
    public tranreqtypeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Указываем, какой дизайн будем использовать для отображения всех элементов
        View tranreqtypeItems = LayoutInflater.from(context).inflate(R.layout.tranreqtype_item, parent, false);
        return new TranreqtypeAdapter.tranreqtypeViewHolder(tranreqtypeItems);
    }

    @Override
    public void onBindViewHolder(@NonNull tranreqtypeViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.tranreqtypeBg.setCardBackgroundColor(Color.parseColor(tranreqtypes.get(position).getColor()));

        int imageId = context.getResources().getIdentifier("ic_" + tranreqtypes.get(position).getImg(), "drawable", context.getPackageName());
        holder.tranreqtypeImage.setImageResource(imageId);

        holder.tranreqtypeName.setText(tranreqtypes.get(position).getName());
        holder.tranreqtypeCode.setText(tranreqtypes.get(position).getCode());

        // Обработчик события на элемент списка (на itemView)
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, TranreqtypePage.class);

                // Анимация картинок
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(
                        (Activity) context,
                        new Pair<View, String>(holder.tranreqtypeImage, "tranreqimage")
                );

                // Передадим данные
                // Цвет берем такой же, какой установили для жлемента списка
                intent.putExtra("tranreqtypeBg", Color.parseColor(tranreqtypes.get(position).getColor()));
                intent.putExtra("tranreqtypeImage", imageId);
                intent.putExtra("tranreqtypeName", tranreqtypes.get(position).getName());
                intent.putExtra("tranreqtypeCode", tranreqtypes.get(position).getCode());
                intent.putExtra("tranreqtypeText", tranreqtypes.get(position).getText());

                context.startActivity(intent, options.toBundle());
            }
        });

    }

    @Override
    public int getItemCount() {
        return tranreqtypes.size();
    }

    public static final class tranreqtypeViewHolder extends RecyclerView.ViewHolder {

        CardView tranreqtypeBg; // Нижний слой модели, в нем будем менять фон
        ImageView tranreqtypeImage; // Изображение, которое будем ментья
        TextView tranreqtypeName;
        TextView tranreqtypeCode;

        public tranreqtypeViewHolder(@NonNull View itemView) {
            super(itemView);

            tranreqtypeBg = itemView.findViewById(R.id.tranreqtypeBg);
            tranreqtypeImage = itemView.findViewById(R.id.tranreqtypeImage);
            tranreqtypeName = itemView.findViewById(R.id.tranreqtypeName);
            tranreqtypeCode = itemView.findViewById(R.id.tranreqtypeCode);

        }
    }
}
