package com.example.jack.activity.db.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import com.example.jack.activity.db.apppackagedb;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jack on 2017/4/21.
 */

public class apppackagedao {
    private final apppackagedb myappapckage;
    private final Context contexxt;

    //单例模式

    //1构造私有化方法
    private apppackagedao(Context context){
        //创建数据库已有的表结构
         myappapckage=new apppackagedb(context);
        this.contexxt=context;
    }
    //声明一个类的对象
     private  static apppackagedao myapppackagedao=null;
    //提供一个方法，如果当前类为空则创建一个
    public static apppackagedao getInstance(Context context){

        if(myapppackagedao==null){
            myapppackagedao=new apppackagedao(context);

        }
        return myapppackagedao;
    }
    public void insert(String packagename){
        SQLiteDatabase db = myappapckage.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("packagename",packagename);
        db.insert("appbackage",null,values);
        contexxt.getContentResolver().notifyChange(Uri.parse("content://change"),null);
        db.close();
    }
    public  void delete(String appbackage){
        SQLiteDatabase db = myappapckage.getWritableDatabase();
        db.delete("appbackage","packagename=?",new String[]{appbackage});
        contexxt.getContentResolver().notifyChange(Uri.parse("content://change"),null);
        db.close();
    }

    public List<String> findall(){
        SQLiteDatabase db = myappapckage.getWritableDatabase();

        Cursor cursor = db.query("appbackage", new String[]{"packagename"}, null, null, null, null, null);

        ArrayList<String> applocklist=new ArrayList<>();
        while (cursor.moveToNext()){
          applocklist.add(cursor.getString(0)) ;
        }
        cursor.close();
        db.close();
         return   applocklist;
    }

}

