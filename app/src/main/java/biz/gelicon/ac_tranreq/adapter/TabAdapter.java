package biz.gelicon.ac_tranreq.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import biz.gelicon.ac_tranreq.R;
import biz.gelicon.ac_tranreq.model.Tab;

public class TabAdapter extends RecyclerView.Adapter<TabAdapter.TabViewHolder> {

    Context context;
    List<Tab> tabs;

    public TabAdapter(Context context, List<Tab> tabs) {
        this.context = context;
        this.tabs = tabs;
    }

    @NonNull
    @Override
    public TabViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View tabItems = LayoutInflater.from(context).inflate(R.layout.tab_item, parent, false);
        return new TabViewHolder(tabItems);
    }

    @Override
    public void onBindViewHolder(@NonNull TabViewHolder holder, int position) {
        holder.tabTitle.setText(tabs.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return tabs.size();
    }

    public static final class TabViewHolder extends RecyclerView.ViewHolder {

        TextView tabTitle;

        public TabViewHolder(@NonNull View itemView) {

            super(itemView);

            tabTitle = itemView.findViewById(R.id.tabTitle);

        }
    }

}
