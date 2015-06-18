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
import tplanner.dimooon.com.tplanner.team.PositionSkill;

public class TPlannerDatabaseOpenHalper extends OrmLiteSqliteOpenHelper {

    private static final String DATABASE_NAME = "tplanner";
    private static final int DATABASE_VERSION = 1;

    private Dao<Player, Long> playersDAO;
    private Dao<PositionSkill, Long> SkillDAO;

    public TPlannerDatabaseOpenHalper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Player.class);
            TableUtils.createTable(connectionSource, PositionSkill.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource,
                          int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, Player.class, false);
            TableUtils.dropTable(connectionSource, PositionSkill.class, false);
            onCreate(database, connectionSource);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Dao<Player, Long> getPlayresDao() throws SQLException {
        if(playersDAO == null) {
            playersDAO = getDao(Player.class);
        }
        return playersDAO;
    }
    public Dao<PositionSkill, Long> getSkillsDao() throws SQLException {
        if(SkillDAO == null) {
            SkillDAO = getDao(PositionSkill.class);
        }
        return SkillDAO;
    }
}