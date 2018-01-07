package com.hfrsoussama.mymvpapp.data.db;

import android.content.Context;

import com.hfrsoussama.mymvpapp.data.db.model.DaoMaster;

import org.greenrobot.greendao.database.Database;

/**
 * Created by Oussama on 06/01/2018.
 */

public class DbOpenHelper extends DaoMaster.OpenHelper {


    public DbOpenHelper(Context context, String name) {
        super(context, name);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, newVersion);
        // Handle updating database schema
    }
}
