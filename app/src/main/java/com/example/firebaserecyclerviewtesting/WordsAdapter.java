package com.example.firebaserecyclerviewtesting;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class WordsAdapter extends RecyclerView.Adapter<WordsAdapter.WordsHolder> {

    LayoutInflater mInflater;
    Context context;
    WordsDataSource data;

    WordsAdapter(Context context, WordsDataSource wordsDataSource){
        mInflater = LayoutInflater.from( context);
        // TODO 1 Initialize the instance variables
    }

    @NonNull
    @Override
    public WordsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        /** this is pretty much standard code so we will leave it here
         *  inflates the xml layout for each list item and is ready for the data to be added */
        View itemView = mInflater.inflate(R.layout.layout, parent, false);
        return new WordsHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull WordsHolder holder, int position) {
        //TODO 2 get the data point at position from the data source and assign it to the Viewholder
    }

    @Override
    public int getItemCount() {
        // TODO 3 return the number of data points
        return 0;
    }

    class WordsHolder extends RecyclerView.ViewHolder{

        private TextView textView;
        public WordsHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textViewWord);

            // TODO 4 Write code to detect a long click
            /*** detecting a longClick and deleting the list item
             * 1 call setOnLongClickListener on itemView
             * 2 get the position that is being long-clicked
             * by calling getAbsoluteAdapterPosition
             * 3 with the position, remove the data
             * 4 notify the recyclerview by calling notifyDataSetChanged() */
        }

        public TextView getTextView() {
            return textView;
        }
    }
}
