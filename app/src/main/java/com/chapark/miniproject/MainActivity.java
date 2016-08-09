package com.chapark.miniproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.chapark.miniproject.data.NetworkResult;
import com.chapark.miniproject.data.User;
import com.chapark.miniproject.manager.NetworkManager;
import com.chapark.miniproject.manager.NetworkRequest;
import com.chapark.miniproject.request.FriendListRequest;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.listView)
    ListView listView;

    ArrayAdapter<User> mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        mAdapter = new ArrayAdapter<User>(this, android.R.layout.simple_list_item_1);
        listView.setAdapter(mAdapter);

        FriendListRequest request = new FriendListRequest(this);
        NetworkManager.getInstance().getNetworkData(request, new NetworkManager.OnResultListener<NetworkResult<List<User>>>() {
            @Override
            public void onSuccess(NetworkRequest<NetworkResult<List<User>>> request, NetworkResult<List<User>> result) {
                List<User> users = result.getResult();
                mAdapter.addAll(users);
            }

            @Override
            public void onFail(NetworkRequest<NetworkResult<List<User>>> request, int errorCode, String errorMessage, Throwable e) {

            }
        });
    }
}
