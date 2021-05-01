package com.abdul.quroni_karim;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;


public class Logo_Activity extends Activity {
    //Создаем переменные для нашей анимации
    private Animation logoAnim,buttonLogoAnim ;
    //private Button bAnim;

    private ImageView logoImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logo_activity);
        init();
        startMainActivity();

    }
    private void init()
    {
// Загружаем анимации в переменные
        logoAnim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.logo_anim);
        buttonLogoAnim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.logo_anim);

       logoImage = findViewById(R.id.imageView2);
       // bAnim = findViewById(R.id.button);
//Запускаем анимацию
        logoImage.startAnimation(logoAnim);
        //bAnim.startAnimation(buttonLogoAnim);

    }

    public void onClickStart(View view)
    {
        Intent i = new Intent(Logo_Activity.this,MainActivity.class);
        startActivity(i);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }
    private void startMainActivity()
    {
    new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Intent i = new Intent(Logo_Activity.this,MainActivity.class);
            startActivity(i);
        }
    }).start();
    }
}
