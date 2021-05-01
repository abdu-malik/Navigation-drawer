package com.abdul.quroni_karim;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.abdul.quroni_karim.settings.SettingsActivity;
import com.abdul.quroni_karim.utils.CustomArrayAdapter;
import com.abdul.quroni_karim.utils.ListItemClass;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private ListView list;
    private String[] array, arraySecName;
    private CustomArrayAdapter adapter;
    private Toolbar toolbar;
    private DrawerLayout drawer;
    private int category_index;
    private int[] array_qaran_color = new int[]{R.color.green,R.color.yellow,R.color.green,R.color.red,R.color.red};
    private List<ListItemClass> listItemMain;
    private ListItemClass listItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
       setSupportActionBar(toolbar);
        list = findViewById(R.id.listViev);
        listItemMain = new ArrayList<>();

        fillArray(R.string.qaran,getResources().getStringArray(R.array.qaran_array),getResources().getStringArray(R.array.qaran_array_2),array_qaran_color,0);
        adapter = new CustomArrayAdapter(this,R.layout.list_view_item_1,listItemMain,getLayoutInflater());

        list.setAdapter(adapter);

        toolbar.setTitle(R.string.qaran);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Intent intent = new Intent(MainActivity.this,Text_Content_Activity.class);
                intent.putExtra("category",category_index);
                intent.putExtra("position",position);
                startActivity(intent);

            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        toolbar.setTitle(R.string.qaran);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent i = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(i);

        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem MenuItem) {
        int id = MenuItem.getItemId();
        if (id == R.id.id_karan) {
           fillArray(R.string.qaran,getResources().getStringArray(R.array.qaran_array),getResources().getStringArray(R.array.qaran_array_2),array_qaran_color,0);
        }


        else if(id == R.id.id_tajvid) {
            fillArray(R.string.tajvid,getResources().getStringArray(R.array.tajvid_array),getResources().getStringArray(R.array.tajvid_array_2),array_qaran_color,1);


        }

         else if (id == R.id.id_hadis) {
            fillArray(R.string.hadis,getResources().getStringArray(R.array.hadis_array),getResources().getStringArray(R.array.hadis_array_2),array_qaran_color,2);

        }
        else if (id == R.id.id_podelit) {
            fillArray(R.string.podelit,getResources().getStringArray(R.array.podelit_array),getResources().getStringArray(R.array.podelit_array_2),array_qaran_color,3);

        }
        else if (id == R.id.id_otsenit) {
            fillArray(R.string.otsenit,getResources().getStringArray(R.array.otsenit_array),getResources().getStringArray(R.array.otsenit_array_2),array_qaran_color,4);

        }
        {
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }
    }
    private void fillArray(int title,String[] nameArray,String[] secName,int[]image,int index)
    {

        toolbar.setTitle(title);
        if (adapter != null)  adapter.clear();
        for (int i=0; i < nameArray.length; i++)
        {
            listItem = new ListItemClass();
            listItem.setName(nameArray[i]);
            listItem.setSecond_name(secName[i]);
            listItemMain.add(listItem);
        }
       if (adapter != null) adapter.notifyDataSetChanged();
        category_index = index;
    }
}