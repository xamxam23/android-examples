package com.example.maximembabele.test_viewmodel;

import android.arch.lifecycle.ViewModel;

/**
 * The ViewModel class allows data to survive configuration changes such as screen rotations.
 */
public class MyViewModel  extends ViewModel{

    private MutableLiveData<List<User>> users;
    public LiveData<List<User>> getUsers() {
        if (users == null) {
            users = new MutableLiveData<List<Users>>();
            loadUsers();
        }
        return users;
    }

    private void loadUsers() {
        // Do an asynchronous operation to fetch users.
    }
}
