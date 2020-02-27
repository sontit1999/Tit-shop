package com.example.titshop.fragment.review;

import androidx.lifecycle.MutableLiveData;

import com.example.titshop.adapter.CommentAdapter;
import com.example.titshop.base.BaseViewmodel;
import com.example.titshop.model.Comment;
import com.example.titshop.model.User;

import java.util.ArrayList;

public class ReviewViewModel extends BaseViewmodel {
    CommentAdapter commentAdapter = new CommentAdapter();
    MutableLiveData<ArrayList<Comment>> arrComment = new MutableLiveData<>();
    public MutableLiveData<ArrayList<Comment>> getArrComment(){
        ArrayList<Comment> arr = new ArrayList<>();
        arr.add(new Comment(new User("Sơn tít","https://zicxa.com/hinh-anh/wp-content/uploads/2019/09/Tuy%E1%BB%83n-t%E1%BA%ADp-h%C3%ACnh-%E1%BA%A3nh-hot-girl-h%E1%BB%8Dc-sinh-Cute-d%E1%BB%85-th%C6%B0%C6%A1ng-16.jpg","0984352391","Hà tây","try your best"),"Giá bao nhiêu vậy shop","4 PM"));
        arr.add(new Comment(new User("Sơn tít","https://zicxa.com/hinh-anh/wp-content/uploads/2019/09/Tuy%E1%BB%83n-t%E1%BA%ADp-h%C3%ACnh-%E1%BA%A3nh-hot-girl-h%E1%BB%8Dc-sinh-Cute-d%E1%BB%85-th%C6%B0%C6%A1ng-16.jpg","0984352391","Hà tây","try your best"),"Đẹp quá đi à >>","4 PM"));
        arr.add(new Comment(new User("Sơn tít","https://zicxa.com/hinh-anh/wp-content/uploads/2019/09/Tuy%E1%BB%83n-t%E1%BA%ADp-h%C3%ACnh-%E1%BA%A3nh-hot-girl-h%E1%BB%8Dc-sinh-Cute-d%E1%BB%85-th%C6%B0%C6%A1ng-16.jpg","0984352391","Hà tây","try your best"),"Mình đang tìm đây rồi !","4 PM"));
        arr.add(new Comment(new User("Sơn tít","https://zicxa.com/hinh-anh/wp-content/uploads/2019/09/Tuy%E1%BB%83n-t%E1%BA%ADp-h%C3%ACnh-%E1%BA%A3nh-hot-girl-h%E1%BB%8Dc-sinh-Cute-d%E1%BB%85-th%C6%B0%C6%A1ng-16.jpg","0984352391","Hà tây","try your best"),"Được của nó :D","4 PM"));
        arr.add(new Comment(new User("Sơn tít","https://zicxa.com/hinh-anh/wp-content/uploads/2019/09/Tuy%E1%BB%83n-t%E1%BA%ADp-h%C3%ACnh-%E1%BA%A3nh-hot-girl-h%E1%BB%8Dc-sinh-Cute-d%E1%BB%85-th%C6%B0%C6%A1ng-16.jpg","0984352391","Hà tây","try your best"),"Rổ giá sao ad ?","4 PM"));
        arr.add(new Comment(new User("Sơn tít","https://zicxa.com/hinh-anh/wp-content/uploads/2019/09/Tuy%E1%BB%83n-t%E1%BA%ADp-h%C3%ACnh-%E1%BA%A3nh-hot-girl-h%E1%BB%8Dc-sinh-Cute-d%E1%BB%85-th%C6%B0%C6%A1ng-16.jpg","0984352391","Hà tây","try your best"),"500k quất luôn","4 PM"));
        arr.add(new Comment(new User("Sơn tít","https://zicxa.com/hinh-anh/wp-content/uploads/2019/09/Tuy%E1%BB%83n-t%E1%BA%ADp-h%C3%ACnh-%E1%BA%A3nh-hot-girl-h%E1%BB%8Dc-sinh-Cute-d%E1%BB%85-th%C6%B0%C6%A1ng-16.jpg","0984352391","Hà tây","try your best"),"Đẹp thiệt!","4 PM"));
        arr.add(new Comment(new User("Sơn tít","https://zicxa.com/hinh-anh/wp-content/uploads/2019/09/Tuy%E1%BB%83n-t%E1%BA%ADp-h%C3%ACnh-%E1%BA%A3nh-hot-girl-h%E1%BB%8Dc-sinh-Cute-d%E1%BB%85-th%C6%B0%C6%A1ng-16.jpg","0984352391","Hà tây","try your best"),"Bán cho mình 1 cái đi :v","4 PM"));
        arrComment.postValue(arr);
        return arrComment;
    }
}
