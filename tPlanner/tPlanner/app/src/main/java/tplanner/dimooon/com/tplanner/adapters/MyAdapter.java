package tplanner.dimooon.com.tplanner.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import tplanner.dimooon.com.tplanner.R;
import tplanner.dimooon.com.tplanner.team.Player;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
        private List<Player> mDataset;

        public static class ViewHolder extends RecyclerView.ViewHolder {

            public TextView mTextView;
            public ViewHolder(TextView v) {
                super(v);
                mTextView = v;
            }
        }

        public MyAdapter(List<Player> myDataset) {
            mDataset = myDataset;
        }

        @Override
        public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);

            ViewHolder vh = new ViewHolder((TextView)v);
            return vh;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.mTextView.setText(mDataset.get(position).getName());

        }

        @Override
        public int getItemCount() {
            return mDataset.size();
        }
    }