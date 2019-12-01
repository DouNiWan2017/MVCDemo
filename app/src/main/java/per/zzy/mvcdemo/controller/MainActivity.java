package per.zzy.mvcdemo.controller;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import per.zzy.mvcdemo.R;
import per.zzy.mvcdemo.model.IUser;
import per.zzy.mvcdemo.model.OnUserListener;
import per.zzy.mvcdemo.model.User;
import per.zzy.mvcdemo.model.UserImpl;

public class MainActivity extends AppCompatActivity implements OnUserListener {

    IUser iUser;
    EditText tvName, tvUserName, tvPassWord;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iUser = new UserImpl();
        initView();
    }

    private void initView() {
        tvName = findViewById(R.id.tvName);
        tvUserName = findViewById(R.id.tvUserName);
        tvPassWord = findViewById(R.id.tvPassWord);
        btnRegister = findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iUser.getUser(new User(tvName.getText().toString(), tvUserName.getText().toString(), tvPassWord.getText().toString()), MainActivity.this);
            }
        });
    }

    @Override
    public void onSuccess(User user) {
        Toast.makeText(this, "注册成功!\n"+user.toString(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onError() {
        Toast.makeText(this, "该用户已注册!", Toast.LENGTH_SHORT).show();
    }
}
