package com.heima.greendao;

import android.database.sqlite.SQLiteDatabase;

import com.heima.greendao.dao.DaoMaster;
import com.heima.greendao.dao.DaoSession;

/**
 * Created by lidongzhi on 2017/2/3.
 */

public class GreenDaoUtils {

        private DaoMaster.DevOpenHelper mHelper;
        private SQLiteDatabase db;
        private DaoMaster mDaoMaster;
        private DaoSession mDaoSession;

        private static GreenDaoUtils greenDaoUtils;

        private GreenDaoUtils(){}

        public static GreenDaoUtils getSingleTon(){
                if (greenDaoUtils==null){
                        greenDaoUtils=new GreenDaoUtils();
                }
                return greenDaoUtils;
        }

        private void initGreenDao(){
                mHelper=new DaoMaster.DevOpenHelper(MyApplication.getApplication(),"test-db",null);
                db=mHelper.getWritableDatabase();
                mDaoMaster=new DaoMaster(db);
                mDaoSession=mDaoMaster.newSession();
        }

        public DaoSession getmDaoSession() {
                if (mDaoMaster==null){
                        initGreenDao();
                }
                return mDaoSession;
        }

        public SQLiteDatabase getDb() {
                if (db==null){
                        initGreenDao();
                }
                return db;
        }

}
