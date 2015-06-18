package tplanner.dimooon.com.tplanner.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

import tplanner.dimooon.com.tplanner.R;
import tplanner.dimooon.com.tplanner.team.Player;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
        private List<Player> Players;

        public static class ViewHolder extends RecyclerView.ViewHolder {

            public TextView textView;
            public TextView bestSkill;
            public RatingBar talent;
            public ViewHolder(View v) {
                super(v);

                textView = (TextView) v.findViewById(R.id.player_name);
                bestSkill = (TextView) v.findViewById(R.id.best_position);
                talent = (RatingBar) v.findViewById(R.id.player_talent);

            }
        }

        public MyAdapter(List<Player> players) {
            Players = players;
        }

        @Override
        public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);

            ViewHolder vh = new ViewHolder(v);
            return vh;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.textView.setText(Players.get(position).getName());
            holder.bestSkill.setText(String.valueOf(Players.get(position).getBestSkill().getValue()));
            holder.talent.setRating((float) Players.get(position).getTalent());
        }

        @Override
        public int getItemCount() {
            return Players.size();
        }
    }