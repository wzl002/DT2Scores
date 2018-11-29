package ca.bcit.engineering.project.zilong.dt2scores.feature;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ca.bcit.engineering.project.zilong.dt2scores.feature.model.Match;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Match} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyMatchRecyclerViewAdapter extends RecyclerView.Adapter<MyMatchRecyclerViewAdapter.ViewHolder> {

    private final List<Match> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyMatchRecyclerViewAdapter(List<Match> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_match, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Match match = holder.mItem = mValues.get(position);
        holder.mIdView.setText(match.getFormatedDate());
        holder.mContentView1.setText(holder.mItem.getTeam1().getName());
        holder.mContentView2.setText(holder.mItem.getTeam2().getName());
        holder.mScore1.setText(holder.mItem.getTeam1Score()+"");
        holder.mScore2.setText(holder.mItem.getTeam2Score()+"");

//        holder.mView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (null != mListener) {
//                    // Notify the active callbacks interface (the activity, if the
//                    // fragment is attached to one) that an item has been selected.
//                    mListener.onListFragmentInteraction(holder.mItem);
//                }
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final TextView mContentView1;
        public final TextView mContentView2;
        public final TextView mScore1;
        public final TextView mScore2;
        public Match mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.matchtime);
            mContentView1 = (TextView) view.findViewById(R.id.team1);
            mContentView2 = (TextView) view.findViewById(R.id.team2);
            mScore1 = (TextView) view.findViewById(R.id.team1score);
            mScore2 = (TextView) view.findViewById(R.id.team2score);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView1.getText() + "'";
        }
    }
}
