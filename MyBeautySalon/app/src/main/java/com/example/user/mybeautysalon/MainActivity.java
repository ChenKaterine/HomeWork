package com.example.user.mybeautysalon;

import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks {
    private SQLiteDatabase mDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getLoaderManager().initLoader(Loader_ID,null,this);
    }

    public void clickChk(View v){
        Intent it=new Intent(MainActivity.this,Main2Activity.class);
        startActivity(it);
    }

    @Override
    public Loader onCreateLoader(int id, Bundle args) {
        SQLiteOpenHelper dbHelper=new MyDBHelper(this);
        mDB=dbHelper.getWritableDatabase();
        MyCursorLoader loader=new MyCursorLoader(this,mDB);
        return loader;
    }

    @Override
    public void onLoadFinished(Loader loader, Object o) {

    }

    @Override
    public void onLoaderReset(Loader loader) {

    }
}
