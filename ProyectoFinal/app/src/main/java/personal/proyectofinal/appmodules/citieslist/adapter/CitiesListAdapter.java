package personal.proyectofinal.appmodules.citieslist.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import personal.proyectofinal.R;
import personal.proyectofinal.model.City;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by RIVARA on 12/08/2016.
 */

public class CitiesListAdapter extends RecyclerView.Adapter<CitiesListAdapter.CityRowViewHolder>{

    private ArrayList<City> mCitiesList;
    private final OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(City city, ImageView profilePicture, TextView cityName);
    }

    public static class CityRowViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.image_view_city) ImageView mImageViewCity;
        @BindView(R.id.text_view_city_name_value) TextView mTextViewCityName;

        public CityRowViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(final City item, final ImageView imageViewCity, final TextView textViewName,final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    listener.onItemClick(item, imageViewCity, textViewName);
                }
            });
        }

    }

    public CitiesListAdapter(OnItemClickListener onItemClickListener){
        mOnItemClickListener = onItemClickListener;
        mCitiesList = new ArrayList<>();
    }

    @Override
    public CityRowViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.city_row_item, parent, false);
        CityRowViewHolder viewHolder = new CityRowViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CityRowViewHolder holder, int position) {
        City city = mCitiesList.get(position);

        if(city != null)
            buildCityCell(city, holder);
    }

    private void buildCityCell(City city, CityRowViewHolder holder) {
        holder.bind(city, holder.mImageViewCity, holder.mTextViewCityName, mOnItemClickListener);
        holder.mTextViewCityName.setText(city.getName());
    }

    @Override
    public int getItemCount() {
        return mCitiesList.size();
    }

    public void setCitiesList(ArrayList<City> mCitiesList) {
        this.mCitiesList = mCitiesList;
        notifyDataSetChanged();
    }
}
