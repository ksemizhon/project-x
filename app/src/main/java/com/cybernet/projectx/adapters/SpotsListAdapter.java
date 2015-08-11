package com.cybernet.projectx.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cybernet.projectx.R;

import java.util.Random;

public class SpotsListAdapter extends RecyclerView.Adapter<SpotsListAdapter.ViewHolder> {
    private String[] mDataset;
    private int titleCount = 0;
    private long subtileCount = (Math.round(Math.random() * 2)+2);
    private int dayCount = 1;


    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final View v;
        public ViewHolder(View v) {
            super(v);
            this.v = v;
        }

        public View getV() {
            return v;
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public SpotsListAdapter(String[] myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public SpotsListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.spot_layout, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        String[] timeFor =  holder.getV().getRootView().getResources().getStringArray(R.array.phase_one_questions);
        TextView title = (TextView) holder.getV().findViewById(R.id.spot_title);
        TextView subtitle = (TextView) holder.getV().findViewById(R.id.spot_subtitle);

        if(position == titleCount){
            title.setVisibility(View.VISIBLE);
            title.setText("Day "+dayCount);

            subtitle.setVisibility(View.VISIBLE);
            subtitle.setText("Start time");

            titleCount+= Math.round(Math.random() * 3)+6;
            dayCount++;
        }
        else if(position == subtileCount){
            subtitle.setVisibility(View.VISIBLE);
            subtitle.setText("TIme for"+timeFor[((int) Math.round(Math.random() * timeFor.length))]);
            subtileCount+= Math.round(Math.random() * 2)+2;
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}