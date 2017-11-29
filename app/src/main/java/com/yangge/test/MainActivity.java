package com.yangge.test;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.yangge.test.utils.IToast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    private android.support.v7.widget.Toolbar toolbar;
    private android.support.v4.widget.DrawerLayout drawerLayout;
    private android.support.design.widget.NavigationView navview;
    private android.support.design.widget.FloatingActionButton fab;
    private ImageBean[] imageBeens = {
            new ImageBean("image1", R.drawable.iv1),
            new ImageBean("image2", R.drawable.iv2),
            new ImageBean("image3", R.drawable.iv3),
            new ImageBean("image4", R.drawable.iv4),
            new ImageBean("image5", R.drawable.iv5),
            new ImageBean("image6", R.drawable.iv6),
            new ImageBean("image7", R.drawable.iv7),
            new ImageBean("image8", R.drawable.iv8),
            new ImageBean("image9", R.drawable.iv9),
            new ImageBean("image10", R.drawable.iv10),
            new ImageBean("image11", R.drawable.iv11),
            new ImageBean("image12", R.drawable.iv12),
            new ImageBean("image13", R.drawable.iv13),
            new ImageBean("image14", R.drawable.iv14),
            new ImageBean("image15", R.drawable.iv15),
            new ImageBean("image16", R.drawable.iv16),
            new ImageBean("image17", R.drawable.iv17),
            new ImageBean("image18", R.drawable.iv18),
            new ImageBean("image19", R.drawable.iv19),
            new ImageBean("image20", R.drawable.iv20),
            new ImageBean("image21", R.drawable.iv21),
            new ImageBean("image22", R.drawable.iv22),
            new ImageBean("image23", R.drawable.iv23),
            new ImageBean("image24", R.drawable.iv24),
            new ImageBean("image25", R.drawable.iv25),
            new ImageBean("image26", R.drawable.iv26),
            new ImageBean("image27", R.drawable.iv27),
            new ImageBean("image28", R.drawable.iv28),
            new ImageBean("image29", R.drawable.iv29),
            new ImageBean("image30", R.drawable.iv30),
            new ImageBean("image31", R.drawable.iv31)
    };
    private List<ImageBean> list = new ArrayList<>();
    private ImagesAdapter adapter;
    private android.support.v7.widget.RecyclerView recyclerview;
    private android.support.v4.widget.SwipeRefreshLayout swipeRefresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.swipeRefresh = (SwipeRefreshLayout) findViewById(R.id.swipeRefresh);
        this.recyclerview = (RecyclerView) findViewById(R.id.recycler_view);
        this.fab = (FloatingActionButton) findViewById(R.id.fab);
        this.navview = (NavigationView) findViewById(R.id.nav_view);
        this.drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
            supportActionBar.setHomeAsUpIndicator(R.drawable.navigation);
        }
        View headerView = navview.getHeaderView(0);
        headerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IToast.toast("headerView");
            }
        });
        headerView.findViewById(R.id.icon_image).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IToast.toast("头像");
            }
        });
        headerView.findViewById(R.id.username).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IToast.toast("名称");
            }
        });
        headerView.findViewById(R.id.good).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IToast.toast("问候语");
            }
        });
        navview.setCheckedItem(R.id.nav_call);
        navview.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_call:
                        IToast.toast("电话");
                        break;
                    case R.id.nav_friend:
                        IToast.toast("friend");
                        break;
                    case R.id.nav_location:
                        IToast.toast("位置");
                        break;
                    case R.id.nav_mail:
                        IToast.toast("e_mail");
                        break;
                    case R.id.nav_task:
                        IToast.toast("task");
                        break;
                }
                drawerLayout.closeDrawers();
                return true;
            }
        });
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "提示", Snackbar.LENGTH_INDEFINITE)
                        .setAction("确定", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast.makeText(MainActivity.this, "clicked", Toast.LENGTH_SHORT).show();
                            }
                        }).show();
                ;
            }
        });
        initIamges();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerview.setLayoutManager(gridLayoutManager);
        adapter = new ImagesAdapter(list);
        recyclerview.setAdapter(adapter);
        swipeRefresh.setColorSchemeResources(R.color.colorPrimary);
        swipeRefresh.setOnRefreshListener(this);


    }

    private void initIamges() {
        list.clear();
        for (int i = 0; i < 31; i++) {
            int j = new Random().nextInt(31);
            Log.e("TAG", "j = " + j);
//            if(i > 31) {//有31张其他照片
//                new ImageBean("hhl", R.drawable.hhl (1));
//            }
            list.add(imageBeens[j]);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.i1:
                IToast.toast("上传");
                break;
            case R.id.i2:
                IToast.toast("删除");
                break;
            case R.id.i3:
                IToast.toast("设置");
                break;
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onRefresh() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        initIamges();
                        adapter.notifyDataSetChanged();
                        swipeRefresh.setRefreshing(false);
                        Toast.makeText(MainActivity.this, "加载成功", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }).start();
    }
}
