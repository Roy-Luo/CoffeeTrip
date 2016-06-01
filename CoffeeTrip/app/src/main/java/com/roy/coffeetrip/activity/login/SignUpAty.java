package com.roy.coffeetrip.activity.login;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.text.Editable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.roy.coffeetrip.R;
import com.roy.coffeetrip.activity.MainActivity;
import com.roy.coffeetrip.base.BaseActivity;
import com.roy.coffeetrip.greendaolite.Collection;
import com.roy.coffeetrip.greendaolite.CollectionDao;
import com.roy.coffeetrip.greendaolite.GreenDaoSingleton;
import com.roy.coffeetrip.greendaolite.UserName;
import com.roy.coffeetrip.greendaolite.UserNameDao;

/**
 * Created by ${Roy} on 16/5/30.
 */
public class SignUpAty extends BaseActivity implements View.OnClickListener, TextWatcher {

    private ImageView finishImg;
    private TextView getTv, agreeTv, agreementTv;
    private UserNameDao userNameDao;
    private EditText idEt, messageEt,passEt;

    @Override
    public int getLayout() {
        return R.layout.aty_sign_up;
    }

    @Override
    public void initView() {

        finishImg = (ImageView) findViewById(R.id.sign_up_finish_img);
        getTv = (TextView) findViewById(R.id.sign_up_message_tv);
        agreeTv = (TextView) findViewById(R.id.sign_up_agree_tv);
        agreementTv = (TextView) findViewById(R.id.sigh_up_agreement_tv);
        idEt = (EditText) findViewById(R.id.sign_up_id_et);
//        messageEt = (EditText) findViewById(R.id.sign_up_message_tv);
        passEt = (EditText) findViewById(R.id.sign_up_password_et);

    }

    @Override
    public void initData() {

        finishImg.setOnClickListener(this);
        getTv.setOnClickListener(this);
        agreeTv.setOnClickListener(this);
        idEt.addTextChangedListener(this);

        // 数据库
        userNameDao = GreenDaoSingleton.getInstance().getUserNameDao();

        // 通过SpannableString 设置超链接来显示服务协议
        SpannableString web = new SpannableString("面包旅行用户隐私协议");
        // 设置下划线
        web.setSpan(new UnderlineSpan(), 0, 10, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        // 超级链接
        web.setSpan(new URLSpan("http://web.breadtrip.com/terms/"), 0, 10, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        // 设置字体颜色
        web.setSpan(new ForegroundColorSpan(Color.WHITE), 0, 10, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        agreementTv.setText(web);
        // 因为使用了超链  所以需要setMovementMethod()方法来响应
        agreementTv.setMovementMethod(LinkMovementMethod.getInstance());
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.sign_up_finish_img:

                finish();

                break;

            case R.id.sign_up_message_tv:

                Toast.makeText(this, "你猜我发没发", Toast.LENGTH_SHORT).show();

                break;

            case R.id.sign_up_agree_tv:

                // 将数据信息存储到数据库中
                String ids = idEt.getText().toString();
                String passWord = passEt.getText().toString();
//                String message = messageEt.getText().toString();

                    UserName userName = new UserName(System.currentTimeMillis(),ids,passWord);

                    userNameDao.insert(userName);

                // 跳转界面
        if (ids.length() == 11 && passWord.length()!=0) {
            finish();
            break;
        }
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (idEt.length()==11){
            Toast.makeText(this, "输入正确", Toast.LENGTH_SHORT).show();
        }
    }

    private void getDialog() {
//        AlertDialog dialog;
//        AlertDialog.Builder builder = new AlertDialog.Builder(SignUpAty.this);
//        builder.setTitle("消息").setIcon(android.R.drawable.stat_notify_error);
//        builder.setMessage("你输出的整型数字有误，请改正");
//        builder.setPositiveButton("确定", new DialogInterface.OnClickListener(){
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                // TODO Auto-generated method stub
//
//            }
//        });
//        dialog = builder.create();
//        dialog.show();
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
