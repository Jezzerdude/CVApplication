package com.example.cvapplication.ui.adapter;

import android.content.res.Resources;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cvapplication.R;
import com.example.cvapplication.data.network.model.CV;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class CVAdapter extends RecyclerView.Adapter<CVAdapter.CVViewHolder> {

    private final List<CV> mCvList;

    public CVAdapter() {
        this.mCvList = new ArrayList<>();
    }

    @NonNull
    @Override
    public CVViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CVViewHolder(LayoutInflater.from(parent.getContext()).inflate(
                R.layout.view_holder_cv, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CVViewHolder holder, int position) {
        holder.bind(mCvList.get(position));
    }

    @Override
    public int getItemCount() {
        return mCvList.size();
    }

    public void setData(List<CV> data) {
        mCvList.clear();
        mCvList.addAll(data);
        notifyDataSetChanged();
    }

    class CVViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_duration)
        TextView tvDuration;
        @BindView(R.id.tv_description)
        TextView tvDescription;
        @BindView(R.id.tv_techs)
        TextView tvTechs;


        CVViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(CV cv) {
            Resources resources = itemView.getResources();
            tvName.setText(Html.fromHtml(resources.getString(R.string.company, cv.getCompanyName())));
            tvDuration.setText(Html.fromHtml(resources.getString(R.string.duration, cv.getProjectDuration())));
            tvDescription.setText(Html.fromHtml(resources.getString(R.string.app_description, cv.getAppDescription())));
            StringBuilder stringBuilder = new StringBuilder();
            for (String tech : cv.getTechsUsed()) {
                stringBuilder.append(tech);
                stringBuilder.append(", ");
            }
            tvTechs.setText(Html.fromHtml(resources.getString(R.string.technologies, stringBuilder.toString())));
        }
    }
}