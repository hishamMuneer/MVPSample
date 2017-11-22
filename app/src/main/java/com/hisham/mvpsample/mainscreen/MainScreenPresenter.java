package com.hisham.mvpsample.mainscreen;

import com.hisham.mvpsample.data.Post;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.POST;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Hisham on 22/Nov/2017 - 15:21
 */

public class MainScreenPresenter implements MainScreenContract.Presenter {

    private interface PostService {
        @POST("/posts")
        Observable<List<Post>> getPostList();
    }

    @Override
    public void loadPost() {
        retrofit.create(PostService.class).getPostList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(new Observer<List<Post>>() {
                    @Override
                    public void onCompleted() {
                        view.showComplete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(List<Post> posts) {
                        view.showPosts(posts);
                    }
                });
    }

    Retrofit retrofit;
    MainScreenContract.View view;

    @Inject
    public MainScreenPresenter(Retrofit retrofit, MainScreenContract.View mView) {
        this.retrofit = retrofit;
        this.view = mView;
    }

}
