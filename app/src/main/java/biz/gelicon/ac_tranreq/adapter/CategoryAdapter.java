package biz.gelicon.ac_tranreq.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import biz.gelicon.ac_tranreq.MainActivity;
import biz.gelicon.ac_tranreq.R;
import biz.gelicon.ac_tranreq.model.Tab;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.TabViewHolder> {

    Context context;
    List<Tab> categories;

    public CategoryAdapter(Context context, List<Tab> categories) {
        this.context = context;
        this.categories = categories;
    }

    @NonNull
    @Override
    public TabViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View tabItems = LayoutInflater.from(context).inflate(R.layout.tab_item, parent, false);
        return new TabViewHolder(tabItems);
    }

    @Override
    public void onBindViewHolder(@NonNull TabViewHolder holder, int position) {
        holder.tabTitle.setText(categories.get(position).getTitle());

        // Обработчик нажатия
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            // При нажатии на категорию вызываем show...
            // и передаем id той категории, на которую нажали
            @Override
            public void onClick(View view) {
                MainActivity.showTranreqByCategory(categories.get(position).getId());
            }
        });

    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public static final class TabViewHolder extends RecyclerView.ViewHolder {

        TextView tabTitle;

        public TabViewHolder(@NonNull View itemView) {

            super(itemView);

            tabTitle = itemView.findViewById(R.id.tabTitle);

        }
    }

}
