package com.weddingwire.wedblog.activities;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.weddingwire.wedblog.R;
import com.weddingwire.wedblog.WBApplication;
import com.weddingwire.wedblog.models.Post;

public class CreatePostActivity extends Activity {
	private final static String TAG = CreatePostActivity.class.getSimpleName();

    private EditText mTitle;
    private EditText mAuthor;
    private EditText mBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_post);

        inject();
        setupButton();
    }

    private void inject() {
        mTitle = (EditText) findViewById(R.id.title);
        mAuthor = (EditText) findViewById(R.id.author);
        mBody = (EditText) findViewById(R.id.body);
    }

    private void setupButton() {
        Button submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (valid()) {
                    Post post = new Post();
                    post.setTitle(mTitle.getText().toString());
                    post.setAuthorName(mAuthor.getText().toString());
                    post.setBody(mBody.getText().toString());

                    Log.d(TAG, post.toString());
                    addPost(post);

                    Toast successToast = Toast.makeText(CreatePostActivity.this, "Successful post!", Toast.LENGTH_SHORT);
                    successToast.show();

                    mTitle.getText().clear();
                    mAuthor.getText().clear();
                    mBody.getText().clear();

                    mTitle.requestFocus();
                }
            }
        });
    }

    private boolean valid() {
        boolean valid = true;
        if (mTitle.getText().length() == 0) {
            mTitle.setError("Title cannot be blank!");
            mTitle.requestFocus();
            valid = false;
        }
        return valid;
    }

    private void addPost(Post post) {
        ((WBApplication)getApplication()).addPost(post);
    }
}
