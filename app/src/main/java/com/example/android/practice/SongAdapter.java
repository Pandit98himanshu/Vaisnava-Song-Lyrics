package com.example.android.practice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<Song> implements Filterable {

    private Context mContext;
    private LayoutInflater inflater;
    private ArrayList<Song> songsList, mOriginalList;

    public SongAdapter(@NonNull Context context, ArrayList<Song> list) {
        super(context, 0 , list);
        mContext = context;
        inflater = LayoutInflater.from(mContext);
        songsList = list;
    }

    @Override
    public int getCount() {
        return songsList.size();
    }

    @Nullable
    @Override
    public Song getItem(int position) {
        return songsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null)
        listItem = LayoutInflater.from(mContext).inflate(R.layout.list_item, parent,false);

        Song currentSong = songsList.get(position);

        TextView name = (TextView) listItem.findViewById(R.id.song_name);
        name.setText(currentSong.getmName());

        return listItem;
    }

    /**
     * @Link https://stackoverflow.com/questions/10532194/filter-listview-with-arrayadapter
     */
    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {

            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                songsList = (ArrayList<Song>) results.values; // has the filtered values
                notifyDataSetChanged();  // notifies the data with new filtered values
            }

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults results = new FilterResults();        // Holds the results of a filtering operation in values
                ArrayList<Song> filteredSongList = new ArrayList<Song>();

                if (mOriginalList == null) {
                    mOriginalList = new ArrayList<Song>(songsList); // saves the original data in mOriginalList
                }

                /******************************************************************************************************
                 *                                                                                                    *
                 *  If constraint(CharSequence that is received) is null returns the mOriginalList(Original) values *
                 *  else does the Filtering and returns filteredSongList(Filtered)                                     *
                 *                                                                                                    *
                 ******************************************************************************************************/
                if (constraint == null || constraint.length() == 0) {
                    // set the Original result to return
                    results.count = mOriginalList.size();
                    results.values = mOriginalList;
                } else {
                    constraint = constraint.toString().toLowerCase();
                    for (int i = 0; i < mOriginalList.size(); i++) {
                        Song s = mOriginalList.get(i);
                        if (s.getmName().toLowerCase().contains(constraint.toString())) {
                            filteredSongList.add(s);
                        }
                    }
                    // set the Filtered result to return
                    results.count = filteredSongList.size();
                    results.values = filteredSongList;
                }
                return results;
            }
        };
        return filter;
    }
}
