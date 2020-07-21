package com.mononsoft.heterogeneouslayoutwithrecycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Created by Md Mehadi Hasan on 7/21/2020.
 * Email: bdmehadih@gmail.com
 * Website: www.mehadih.me
 * Project Name: Heterogeneous Layout with Recycle View
 */
public class ObjectAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<Object> objects;

    private final int CAR_TYPE=1;
    private final int Movie_TYPE=2;

    public ObjectAdapter(Context context, ArrayList<Object> objects) {
        this.context = context;
        this.objects = objects;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        RecyclerView.ViewHolder viewHolder = null;

        switch (viewType){
            case CAR_TYPE:
                View v= inflater.inflate(R.layout.car_single_row,parent,false);
                viewHolder= new CardViewHolder(v);
                break;
            case Movie_TYPE:
                View v1= inflater.inflate(R.layout.movie_single_row,parent,false);
                viewHolder= new MovieViewHolder(v1);
                break;
        }


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        switch (holder.getItemViewType()){
            case CAR_TYPE:
                CardViewHolder cvh = (CardViewHolder) holder;
                Car car = (Car) objects.get(position);
                cvh.carIV.setImageResource(car.getCarImage());
                cvh.carNameTV.setText(car.getCarName());
                cvh.carCompanyTV.setText(car.getCarCompany());
                 break;

            case Movie_TYPE:
                MovieViewHolder mvh =(MovieViewHolder) holder;
                Movie movie = (Movie) objects.get(position);
                mvh.movieNameTV.setText(movie.getMovieName());
                mvh.movieCategoryTV.setText(movie.getCategory());
                break;
        }



    }

    @Override
    public int getItemCount() {
        return objects.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder{

        ImageView carIV;
        TextView carNameTV;
        TextView carCompanyTV;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);

            carIV=itemView.findViewById(R.id.carImage);
            carNameTV=itemView.findViewById(R.id.carName);
            carCompanyTV=itemView.findViewById(R.id.carCompany);
        }
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder{

        TextView movieNameTV;
        TextView movieCategoryTV;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);

            movieNameTV=itemView.findViewById(R.id.movieName);
            movieCategoryTV=itemView.findViewById(R.id.movieCategory);
        }
    }

    @Override
    public int getItemViewType(int position) {

        if(objects.get(position) instanceof Car){
            return CAR_TYPE;
        }else if(objects.get(position) instanceof Movie){
            return Movie_TYPE;
        }

        return -1;
    }
}
