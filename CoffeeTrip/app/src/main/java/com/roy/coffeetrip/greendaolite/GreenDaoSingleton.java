package com.roy.coffeetrip.greendaolite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.roy.coffeetrip.base.MyApplication;

/**
 * Created by ${Roy} on 16/5/30.
 */
public class GreenDaoSingleton {

    private SQLiteDatabase database;  // 数据库
    private DaoMaster master;  // 管理者
    private DaoSession session;  // 会话者
    private CollectionDao collectionDao;  // 数据库内相应表的操作对象
    private UserNameDao userNameDao;
    private Context context;
    private DaoMaster.DevOpenHelper helper;

    public UserNameDao getUserNameDao() {
        if (userNameDao == null){
            userNameDao = getSession().getUserNameDao();
        }

        return userNameDao;
    }


    public SQLiteDatabase getDatabase() {
        if (database == null){
            database = getHelper().getWritableDatabase();
        }
        return database;
    }

    public DaoMaster getMaster() {
        if (master == null){
            master = new DaoMaster(getDatabase());
        }
        return master;
    }

    public DaoSession getSession() {
        if (session == null){
            session = getMaster().newSession();
        }
        return session;
    }

    public CollectionDao getCollectionDao() {
        if (collectionDao == null){
            collectionDao = getSession().getCollectionDao();
        }
        return collectionDao;
    }

    public DaoMaster.DevOpenHelper getHelper() {
        if (helper == null){
            helper = new DaoMaster.DevOpenHelper(context,"Collection.db",null);
        }
        return helper;
    }

    private static GreenDaoSingleton ourInstance = new GreenDaoSingleton();

    public static GreenDaoSingleton getInstance() {
        if (ourInstance == null) {
            synchronized (GreenDaoSingleton.class) {
                if (ourInstance == null) {
                    ourInstance = new GreenDaoSingleton();
                }
            }
        }

        return ourInstance;
    }

    private GreenDaoSingleton() {
        context = MyApplication.getContext();
    }
}
