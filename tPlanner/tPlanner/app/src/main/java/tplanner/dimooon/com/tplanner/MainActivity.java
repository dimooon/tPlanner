package tplanner.dimooon.com.tplanner;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;

import tplanner.dimooon.com.tplanner.adapters.MyAdapter;
import tplanner.dimooon.com.tplanner.database.TPlannerDatabaseOpenHalper;
import tplanner.dimooon.com.tplanner.team.Player;


public class MainActivity extends Activity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createPlayersList();

    }

    private void createPlayersList(){
         mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new MyAdapter(getPlayersFromDatabase());
        mRecyclerView.setAdapter(mAdapter);
    }

    private List<Player> getPlayersFromDatabase(){
        TPlannerDatabaseOpenHalper playerOpenDatabaseHelper = OpenHelperManager.getHelper(this, TPlannerDatabaseOpenHalper.class);

        Dao<Player, Long> todoDao = null;
        try {
            todoDao = playerOpenDatabaseHelper.getDao();

            return todoDao.queryForAll();

        } catch (SQLException e) {
            e.printStackTrace();
        }
         return new ArrayList<Player>();
    }
}
