package thud.baitapduan.adapter;

import android.app.Activity;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;

import thud.baitapduan.R;
import thud.baitapduan.model.Movie;

public class MovieArrayAdapter extends ArrayAdapter {
    Activity context;
    int layoutId;
    ArrayList<Movie> arrMovie;

    public MovieArrayAdapter(Activity context, int layoutId, ArrayList<Movie> arrMovie) {
        super(context, layoutId, arrMovie);
        this.context = context;
        this.layoutId = layoutId;
        this.arrMovie = arrMovie;
    }

    public void setArrMovie(ArrayList<Movie> arrMovie) {
        this.arrMovie = arrMovie;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return arrMovie.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        convertView = inflater.inflate(layoutId, null);
        if (arrMovie.size() > 0 && position >= 0) {
            final Movie movie = arrMovie.get(position);
            final TextView txtTitle = convertView.findViewById(R.id.txt_title);
            txtTitle.setText(movie.getTitle());
            final ImageView imageView = convertView.findViewById(R.id.imageView);
            imageView.setImageResource(arrMovie.get(position).getImage());
            final TextView txtDirector = convertView.findViewById(R.id.txt_director);
            txtDirector.setText("Director: " + movie.getDirector());
            final TextView txtCast = convertView.findViewById(R.id.txt_cast);
            txtCast.setText("Cast: " + movie.getCast());
            final TextView txtDescription = convertView.findViewById(R.id.txt_description);
            txtDescription.setText("Description:" + movie.getDescription());
            final TextView txtDuration = convertView.findViewById(R.id.txt_duration);
            txtDuration.setText("Movie duration: " + String.valueOf(movie.getDuration()) + " minutes");
        }
        return convertView;
    }
}
