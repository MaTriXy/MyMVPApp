package com.hfrsoussama.mymvpapp.features.myjokes.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hfrsoussama.mymvpapp.R;
import com.hfrsoussama.mymvpapp.data.network.model.Joke;

import java.util.List;

/**
 * Created by Oussama on 06/01/2018.
 */

public class JokesListAdapter extends RecyclerView.Adapter<JokesListAdapter.JokeItemViewHolder> {

    private List<Joke> jokeList;

    public JokesListAdapter(List<Joke> jokeList) {
        this.jokeList = jokeList;
    }

    @Override
    public JokeItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_joke_card, parent, false);
        return new JokeItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(JokeItemViewHolder holder, int position) {
        holder.bindJoke(jokeList.get(position), position);
    }

    @Override
    public int getItemCount() {
        return jokeList.size();
    }


    class JokeItemViewHolder extends RecyclerView.ViewHolder {

        private TextView mJokeNumber;
        private TextView mJokeContent;

        private Joke mJoke;

        public JokeItemViewHolder(View itemView) {
            super(itemView);

            mJokeNumber = itemView.findViewById(R.id.tv_joke_number);
            mJokeContent = itemView.findViewById(R.id.tv_joke_content);
        }

        public void bindJoke(Joke joke, int position) {
            this.mJoke = joke;
            mJokeNumber.setText("Joke N°" + position);
            mJokeContent.setText(joke.getContent());
        }
    }
}
