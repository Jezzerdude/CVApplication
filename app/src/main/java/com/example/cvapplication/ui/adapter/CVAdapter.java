package com.example.cvapplication.ui.adapter;

import android.annotation.SuppressLint;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cvapplication.R;
import com.example.cvapplication.data.Network.Model.CV;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class CVAdapter extends RecyclerView.Adapter<CVAdapter.CVViewHolder> {

    private List<CV> mCvList;
    private static final String COMPANY_NAME = "Company Name: ";
    private static final String DURATION = "Duration: ";
    private static final String COMPANY_ID = "Company ID: ";
    private static final String DESCRIPTION = "App Description: ";
    private static final String TECHS = "Technologies used: ";

    public CVAdapter(List<CV> cvList) {
        this.mCvList = cvList;
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

    class CVViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_duration)
        TextView tvDuration;
        @BindView(R.id.tv_id)
        TextView tvid;
        @BindView(R.id.tv_description)
        TextView tvdescription;
        @BindView(R.id.tv_techs)
        TextView tvtechs;

        public CVViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @SuppressLint("SetTextI18n")
        public void bind(CV cv) {
            tvName.setText(Html.fromHtml("<b>" + COMPANY_NAME + "</b> " + cv.getCompany()));
            tvDuration.setText(Html.fromHtml("<b>" + DURATION + "</b> " + cv.getDuration()));
            tvid.setText(Html.fromHtml("<b>" + COMPANY_ID + "</b> " + Integer.toString(((int) cv.getProjectId()))));
            tvdescription.setText(Html.fromHtml("<b>" + DESCRIPTION + "</b> " + cv.getRoleDescription()));
            String techs = "";
            for(String tech : cv.getTechStack()){
                techs = techs.concat(tech + ", ");
            }
            tvtechs.setText(Html.fromHtml("<b>" + TECHS + "</b> " + techs));
        }
    }
}