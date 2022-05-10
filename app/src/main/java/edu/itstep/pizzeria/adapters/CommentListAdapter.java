package edu.itstep.pizzeria.adapters;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

import edu.itstep.pizzeria.R;
import edu.itstep.pizzeria.classes.Comment;

public class CommentListAdapter extends ArrayAdapter<Comment> {
    private static final String TAG = "CommentListAdapter";

    private final Context mContext;
    private final int mResource;

    public CommentListAdapter(Context context, int resource, ArrayList<Comment> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @SuppressLint("ViewHolder")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Comment comment = getItem(position);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView tvCommentatorName = convertView.findViewById(R.id.tvCommentatorName);
        TextView tvRating = convertView.findViewById(R.id.tvRating);
        TextView tvReview = convertView.findViewById(R.id.tvReview);

        tvCommentatorName.setText(comment.getCommentatorName());
        tvRating.setText(String.valueOf(comment.getRating()));
        tvReview.setText(comment.getReview());

        return convertView;
    }
}
