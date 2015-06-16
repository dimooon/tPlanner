package tplanner.dimooon.com.tplanner.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

import tplanner.dimooon.com.tplanner.R;
import tplanner.dimooon.com.tplanner.team.Player;

public class TPlannerDatabaseOpenHalper extends OrmLiteSqliteOpenHelper {

    private static final String DATABASE_NAME = "players";
    private static final int DATABASE_VERSION = 1;

    private Dao<Player, Long> todoDao;

    public TPlannerDatabaseOpenHalper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION, R.raw.ormilite_config);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Player.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource,
                          int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, Player.class, false);
            onCreate(database, connectionSource);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Dao<Player, Long> getDao() throws SQLException {
        if(todoDao == null) {
            todoDao = getDao(Player.class);
        }
        return todoDao;
    }
}