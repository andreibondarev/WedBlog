package com.weddingwire.wedblog.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.weddingwire.wedblog.R;
import com.weddingwire.wedblog.WBApplication;
import com.weddingwire.wedblog.models.Post;

import java.util.List;

public class PostListActivity extends Activity {

    private ListView mPostsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_list);
        mPostsList = (ListView) findViewById(R.id.post_list);
        setupList();
    }

    private void setupList() {
        List<Post> posts = ((WBApplication)getApplication()).getPosts();
        ArrayAdapter<Post> adapter = new ArrayAdapter<Post>(this, android.R.layout.simple_list_item_1, posts);
        mPostsList.setAdapter(adapter);
    }

}
