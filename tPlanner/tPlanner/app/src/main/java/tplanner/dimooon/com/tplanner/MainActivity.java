package tplanner.dimooon.com.tplanner;

import android.app.Activity;
import android.content.Intent;
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
import tplanner.dimooon.com.tplanner.team.PositionSkill;
import tplanner.dimooon.com.tplanner.team.PositionType;


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
        initAddPlayerButton();
    }

    @Override
    protected void onResume() {
        super.onResume();

        mAdapter = new MyAdapter(getPlayersFromDatabase());
        mRecyclerView.setAdapter(mAdapter);
    }

    private void initAddPlayerButton() {
        findViewById(R.id.add_player_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,AddPlayerActivity.class));
            }
        });
    }

    private void createPlayersList(){
         mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

    }

    private List<Player> getPlayersFromDatabase(){
        TPlannerDatabaseOpenHalper tPlannerOpenDatabaseHelper = OpenHelperManager.getHelper(this, TPlannerDatabaseOpenHalper.class);
        Dao<Player, Long> playersDao = null;
        Dao<PositionSkill, Long> skillsDao = null;
        ArrayList<Player> players = new ArrayList<>();

        try {
            playersDao = tPlannerOpenDatabaseHelper.getPlayresDao();
            skillsDao = tPlannerOpenDatabaseHelper.getSkillsDao();
            players.addAll(playersDao.queryForAll());
            for(Player player : players){
                player.setSkills(skillsDao.queryBuilder().where().eq("playerId",player.getId()).query());

            }
            return players;
        } catch (SQLException e) {
            e.printStackTrace();
        }
         return new ArrayList<Player>();
    }
}
