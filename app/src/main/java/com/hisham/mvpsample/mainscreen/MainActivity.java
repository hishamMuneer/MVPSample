package com.hisham.mvpsample.mainscreen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.hisham.mvpsample.App;
import com.hisham.mvpsample.R;
import com.hisham.mvpsample.data.Post;
import com.hisham.mvpsample.data.component.DaggerMainScreenComponent;
import com.hisham.mvpsample.data.component.NetComponent;
import com.hisham.mvpsample.data.module.MainScreenModule;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainScreenContract.View {

    @BindView(R.id.my_list) private ListView listView;
    private ArrayList<String> list;
    private ArrayAdapter<String> adapter;

    @Inject
    MainScreenPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        list = new ArrayList<>();

        DaggerMainScreenComponent.builder()
                .netComponent(((App) getApplicationContext()).getNetComponent())
                .mainScreenModule(new MainScreenModule(this))
                .build().inject(this);

        //Call the method in MainPresenter to make Network Request
        mainPresenter.loadPost();

    }

    @Override
    public void showPosts(List<Post> posts) {
        //Loop through the posts and get the title of the post and add it to our list object
        for (int i = 0; i < posts.size(); i++) {
            list.add(posts.get(i).getTitle());
        }
        //Create the array adapter and set it to list view
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);
    }

    @Override
    public void showError(String message) {
        //Show error message Toast
        Toast.makeText(getApplicationContext(), "Error" + message, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showComplete() {
        //Show completed message Toast
        Toast.makeText(getApplicationContext(), "Complete", Toast.LENGTH_SHORT).show();

    }
}
