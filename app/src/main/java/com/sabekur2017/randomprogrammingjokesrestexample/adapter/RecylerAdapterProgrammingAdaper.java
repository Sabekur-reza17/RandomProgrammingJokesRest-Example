package com.sabekur2017.randomprogrammingjokesrestexample.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sabekur2017.randomprogrammingjokesrestexample.R;
import com.sabekur2017.randomprogrammingjokesrestexample.model.ProgrammingJokesModel;

import java.util.List;

public class RecylerAdapterProgrammingAdaper extends RecyclerView.Adapter<RecylerAdapterProgrammingAdaper.CustomRecyclerViewHolder> {
    private Context context;
    private List<ProgrammingJokesModel> jokesModelList;

    public RecylerAdapterProgrammingAdaper(Context context, List<ProgrammingJokesModel> jokesModelList) {
        this.context = context;
        this.jokesModelList = jokesModelList;
    }

    @NonNull
    @Override
    public CustomRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyler_item, parent, false);

        return new CustomRecyclerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomRecyclerViewHolder holder, int position) {
        holder.setup.setText(jokesModelList.get(position).getSetup());
        holder.punchline.setText(jokesModelList.get(position).getPunchline());

    }

    @Override
    public int getItemCount() {
        return jokesModelList.size();
    }

    class CustomRecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView setup, punchline;

        public CustomRecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            setup = itemView.findViewById(R.id.setup_txt);
            punchline = itemView.findViewById(R.id.punchline_txt);
        }
    }
}
