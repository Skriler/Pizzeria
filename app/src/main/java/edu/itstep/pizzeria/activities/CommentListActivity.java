package edu.itstep.pizzeria.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import edu.itstep.pizzeria.R;
import edu.itstep.pizzeria.adapters.CommentListAdapter;
import edu.itstep.pizzeria.classes.Comment;
import edu.itstep.pizzeria.services.CommentService;

public class CommentListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_list);

        ArrayList<Comment> comments = CommentService.getComments();
        CommentListAdapter adapterComment = new CommentListAdapter(this, R.layout.custom_list_view_item, comments);

        ListView lvComments = findViewById(R.id.lvComments);
        lvComments.setAdapter(adapterComment);

        Button btnCloseWindow = findViewById(R.id.btnCloseWindow);
        btnCloseWindow.setOnClickListener(view -> {
            finish();
        });
    }


}