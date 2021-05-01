package com.abdul.quroni_karim;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class Text_Content_Activity extends AppCompatActivity {
    private ActionBar actionBar;
    private TextView text_content;
    private Typeface fase1;
    private ImageView iContent;
    private SharedPreferences def_pref;
    private int category = 0;
    private int position = 0;
    private int [] array_qaran = {R.string.qaran_1,R.string.qaran_2,R.string.qaran_3,R.string.qaran_4,R.string.qaran_5,R.string.qaran_6,
            R.string.qaran_7,R.string.qaran_8,R.string.qaran_9,R.string.qaran_10,R.string.qaran_11,R.string.qaran_12,R.string.qaran_13,R.string.qaran_14,
            R.string.qaran_15,R.string.qaran_16,R.string.qaran_17,R.string.qaran_18,R.string.qaran_19,R.string.qaran_20,R.string.qaran_21,
            R.string.qaran_22,R.string.qaran_23,R.string.qaran_24,R.string.qaran_25,R.string.qaran_26,R.string.qaran_27,R.string.qaran_28,
            R.string.qaran_29,R.string.qaran_30,R.string.qaran_31,R.string.qaran_32,R.string.qaran_33,R.string.qaran_34,R.string.qaran_35,
            R.string.qaran_36,R.string.qaran_37,R.string.qaran_38,R.string.qaran_39,R.string.qaran_40,
            R.string.qaran_41,R.string.qaran_42,R.string.qaran_43,R.string.qaran_44,R.string.qaran_45,R.string.qaran_46,R.string.qaran_47,
            R.string.qaran_48,R.string.qaran_49,R.string.qaran_50,R.string.qaran_51,R.string.qaran_52,R.string.qaran_53,R.string.qaran_54,
            R.string.qaran_55,R.string.qaran_56,R.string.qaran_57,R.string.qaran_58,R.string.qaran_59,R.string.qaran_60,R.string.qaran_61,
            R.string.qaran_62,R.string.qaran_63,R.string.qaran_64,R.string.qaran_65,R.string.qaran_66,R.string.qaran_67,R.string.qaran_68,
            R.string.qaran_69,R.string.qaran_70,R.string.qaran_71,R.string.qaran_72,R.string.qaran_73,R.string.qaran_74,R.string.qaran_75,
            R.string.qaran_76,R.string.qaran_77,R.string.qaran_78,R.string.qaran_79,R.string.qaran_80,
            R.string.qaran_81,R.string.qaran_82,R.string.qaran_83,R.string.qaran_84,R.string.qaran_85,R.string.qaran_86,R.string.qaran_87,
            R.string.qaran_88,R.string.qaran_89,R.string.qaran_90,R.string.qaran_91,R.string.qaran_92,R.string.qaran_93,R.string.qaran_94,
            R.string.qaran_95,R.string.qaran_96,R.string.qaran_97,R.string.qaran_98,R.string.qaran_99,R.string.qaran_100,R.string.qaran_101,
            R.string.qaran_102,R.string.qaran_103,R.string.qaran_104,R.string.qaran_105,R.string.qaran_106,R.string.qaran_107,R.string.qaran_108,
            R.string.qaran_109,R.string.qaran_110,R.string.qaran_111,R.string.qaran_112,R.string.qaran_113,R.string.qaran_114  };
    private int [] array_tajvid = {R.string.tajvid_1,R.string.tajvid_2,R.string.tajvid_3,R.string.tajvid_4,R.string.tajvid_5};
    private int [] array_hadis = {R.string.hadis_1,R.string.hadis_2,R.string.hadis_3,R.string.hadis_4,R.string.hadis_5};
    private int [] array_podelit = {R.string.podelit_1};
    private int [] array_otsenit = {R.string.otsenit_1};
    private String [] array_title_qaran = {"АЛЬ-ФАТИХА","АЛЬ-БАКАРА","АЛЬ-ИМРАН","АН-НИСА","АЛЬ-МАИДА"};
    private String [] array_title_tajvid = {"aaa","sss","ddd","qqq","wwww"};
    private String [] array_title_hadis = {"zzz","xxx","ccc","vvv","bbb"};
    private String [] array_title_podelit = {"podelit"};
    private String [] array_title_otsenit = {"otsenit"};





    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_content);
        {
            actionBar = getSupportActionBar();
            actionBar.setDisplayHomeAsUpEnabled(true);

        }
        init();

        reciveIntent();

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home)
        {
            finish();
        }
        return true;
    }

    private void reciveIntent()
    {
        Intent i = getIntent();
        if(i != null)
        {
         category = i.getIntExtra("category",0);
         position = i.getIntExtra("position",0);
        }
        switch (category) {
            case 0:
                text_content.setText(array_qaran[position]);
                actionBar.setTitle(array_title_qaran[position]);
                break;
            case 1:
                text_content.setText(array_tajvid[position]);
                actionBar.setTitle(array_title_tajvid[position]);
                break;
            case 2:
                text_content.setText(array_hadis[position]);
                actionBar.setTitle(array_title_hadis[position]);
                break;
            case 3:
                text_content.setText(array_podelit[position]);
                actionBar.setTitle(array_title_podelit[position]);
                break;
            case 4:
                text_content.setText(array_otsenit[position]);
                actionBar.setTitle(array_title_otsenit[position]);
                break;
        }
    }
    private void init()
    {
        def_pref = PreferenceManager.getDefaultSharedPreferences(this);
        text_content = findViewById(R.id.text_main_content);
        iContent = findViewById(R.id.imageContent);

        text_content.setTypeface(fase1);
        actionBar = getSupportActionBar();
        String text = def_pref.getString("main_text_1","Средный");
        if(text != null)
        switch (text)
        {
            case "Большой" :
                text_content.setTextSize(30);
                break;
            case "Средный" :
                text_content.setTextSize(24);
                break;
            case "Маленкий" :
                text_content.setTextSize(18);
                break;
        }

    }
}
