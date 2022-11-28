package biz.gelicon.ac_tranreq.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import biz.gelicon.ac_tranreq.R;
import biz.gelicon.ac_tranreq.model.Requesttype;

public class RequerttypeAdapter extends RecyclerView.Adapter<RequerttypeAdapter.RequesttypeViewHolder> {

    Context context;
    List<Requesttype> requesttypes;

    public RequerttypeAdapter(Context context, List<Requesttype> requesttypes) {
        this.context = context;
        this.requesttypes = requesttypes;
    }

    @NonNull
    @Override
    public RequesttypeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Указываем, какой дизайн будем использовать для отображения всех элементов
        View requesttypeItems = LayoutInflater.from(context).inflate(R.layout.requesttype_item, parent, false);
        return new RequerttypeAdapter.RequesttypeViewHolder(requesttypeItems);
    }

    @Override
    public void onBindViewHolder(@NonNull RequesttypeViewHolder holder, int position) {
        holder.requesttypeBg.setCardBackgroundColor(Color.parseColor(requesttypes.get(position).getColor()));

        int imageId = context.getResources().getIdentifier("ic_" + requesttypes.get(position).getImg(), "drawable", context.getPackageName());
        holder.requesttypeImage.setImageResource(imageId);

        holder.requesttypeName.setText(requesttypes.get(position).getName());
        holder.requesttypeCode.setText(requesttypes.get(position).getCode());

    }

    @Override
    public int getItemCount() {
        return requesttypes.size();
    }

    public static final class RequesttypeViewHolder extends RecyclerView.ViewHolder {

        CardView requesttypeBg; // Нижний слой модели, в нем будем менять фон
        ImageView requesttypeImage; // Изображение, которое будем ментья
        TextView requesttypeName;
        TextView requesttypeCode;

        public RequesttypeViewHolder(@NonNull View itemView) {
            super(itemView);

            requesttypeBg = itemView.findViewById(R.id.requesttypeBg);
            requesttypeImage = itemView.findViewById(R.id.requesttypeImage);
            requesttypeName = itemView.findViewById(R.id.requesttypeName);
            requesttypeCode = itemView.findViewById(R.id.requesttypeCode);

        }
    }
}
