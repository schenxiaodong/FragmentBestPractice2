package com.example.fragmentbestpractice2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.fragmentbestpractice2.fragment.NewsContentFragment;

public class NewsContentActivity extends AppCompatActivity {

    //为前台需要调用接口的界面提供接口提高效率，详情于《第一行代码》第二版2.6.3
    public static void actionStart(Context context,String newsTitle,String newsContent){
        Intent intent = new Intent(context,NewsContentActivity.class);
        intent.putExtra("newsTitle",newsTitle);
        intent.putExtra("newsContent",newsContent);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_content);
        //获取传入的新闻标题
        String newsTitle = getIntent().getStringExtra("newsTitle");
        //获取传入的新闻内容
        String newsContent = getIntent().getStringExtra("newsContent");
        //得到newsContentFragment实例
        NewsContentFragment newsContentFragment = (NewsContentFragment) getSupportFragmentManager().findFragmentById(R.id.news_content_fragment);
        //刷新NewsContentFragment界面
        newsContentFragment.refresh(newsTitle,newsContent);

    }
}