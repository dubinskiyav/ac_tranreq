package biz.gelicon.ac_tranreq.adapter;

import android.content.Context;
import android.graphics.Color;
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
import biz.gelicon.ac_tranreq.model.tranreqtype;

public class RequerttypeAdapter extends RecyclerView.Adapter<RequerttypeAdapter.tranreqtypeViewHolder> {

    Context context;
    List<tranreqtype> tranreqtypes;

    public RequerttypeAdapter(Context context, List<tranreqtype> tranreqtypes) {
        this.context = context;
        this.tranreqtypes = tranreqtypes;
    }

    @NonNull
    @Override
    public tranreqtypeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Указываем, какой дизайн будем использовать для отображения всех элементов
        View tranreqtypeItems = LayoutInflater.from(context).inflate(R.layout.tranreqtype_item, parent, false);
        return new RequerttypeAdapter.tranreqtypeViewHolder(tranreqtypeItems);
    }

    @Override
    public void onBindViewHolder(@NonNull tranreqtypeViewHolder holder, int position) {
        holder.tranreqtypeBg.setCardBackgroundColor(Color.parseColor(tranreqtypes.get(position).getColor()));

        int imageId = context.getResources().getIdentifier("ic_" + tranreqtypes.get(position).getImg(), "drawable", context.getPackageName());
        holder.tranreqtypeImage.setImageResource(imageId);

        holder.tranreqtypeName.setText(tranreqtypes.get(position).getName());
        holder.tranreqtypeCode.setText(tranreqtypes.get(position).getCode());

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
