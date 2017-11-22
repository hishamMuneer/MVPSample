package com.hisham.mvpsample.mainscreen;

import com.hisham.mvpsample.data.Post;

import java.util.List;

/**
 * Created by Hisham on 22/Nov/2017 - 15:05
 */

public interface MainScreenContract {
    interface View {
        void showPosts(List<Post> posts);

        void showError(String message);

        void showComplete();
    }

    interface Presenter {
        void loadPost();
    }
}
