package tplanner.dimooon.com.tplanner;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.RatingBar;
import android.widget.TextView;

import com.j256.ormlite.android.apptools.OpenHelperManager;

import java.sql.SQLException;

import tplanner.dimooon.com.tplanner.database.TPlannerDatabaseOpenHalper;
import tplanner.dimooon.com.tplanner.team.Player;
import tplanner.dimooon.com.tplanner.team.PositionSkill;
import tplanner.dimooon.com.tplanner.team.PositionType;


public class AddPlayerActivity extends Activity {

    private NumberPicker height = null;
    private NumberPicker weight = null;

    private NumberPicker skillOutside = null;
    private NumberPicker skillRightSide = null;
    private NumberPicker skillOpposite = null;
    private NumberPicker skillMiddleBlocker = null;
    private NumberPicker skillLibero = null;
    private NumberPicker skillDefensive = null;
    private NumberPicker skillSetter = null;

    private RatingBar talent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_player);

        initView();

        initScrolls(height, 110, 240);
        initScrolls(weight, 40, 180);

        initScrolls(skillOutside,0,100);
        initScrolls(skillRightSide,0,100);
        initScrolls(skillOpposite,0,100);
        initScrolls(skillMiddleBlocker,0,100);
        initScrolls(skillLibero,0,100);
        initScrolls(skillDefensive,0,100);
        initScrolls(skillSetter,0,100);

        findViewById(R.id.add_player_button_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = ((TextView)findViewById(R.id.add_player_name)).getText().toString();
                int height = ((NumberPicker)findViewById(R.id.height_picker)).getValue();
                int weight = ((NumberPicker)findViewById(R.id.weight_picker)).getValue();

                try {
                    long id = OpenHelperManager.getHelper(AddPlayerActivity.this, TPlannerDatabaseOpenHalper.class).getPlayresDao().create(new Player(name,height,weight,"", talent.getRating()));

                    OpenHelperManager.getHelper(AddPlayerActivity.this, TPlannerDatabaseOpenHalper.class).getSkillsDao().create(new PositionSkill(PositionType.LIBERO,id,skillLibero.getValue()));
                    OpenHelperManager.getHelper(AddPlayerActivity.this, TPlannerDatabaseOpenHalper.class).getSkillsDao().create(new PositionSkill(PositionType.DEFENSIVE,id,skillDefensive.getValue()));
                    OpenHelperManager.getHelper(AddPlayerActivity.this, TPlannerDatabaseOpenHalper.class).getSkillsDao().create(new PositionSkill(PositionType.MIDDLE_BLOCKER,id,skillMiddleBlocker.getValue()));
                    OpenHelperManager.getHelper(AddPlayerActivity.this, TPlannerDatabaseOpenHalper.class).getSkillsDao().create(new PositionSkill(PositionType.OPPOSITE_HITTER,id,skillOpposite.getValue()));
                    OpenHelperManager.getHelper(AddPlayerActivity.this, TPlannerDatabaseOpenHalper.class).getSkillsDao().create(new PositionSkill(PositionType.OUTSIDE_HITTER,id,skillOutside.getValue()));
                    OpenHelperManager.getHelper(AddPlayerActivity.this, TPlannerDatabaseOpenHalper.class).getSkillsDao().create(new PositionSkill(PositionType.RIGHT_SIDE_HITTER,id,skillRightSide.getValue()));
                    OpenHelperManager.getHelper(AddPlayerActivity.this, TPlannerDatabaseOpenHalper.class).getSkillsDao().create(new PositionSkill(PositionType.SETTER,id,skillSetter.getValue()));

                    onBackPressed();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    private void initScrolls(NumberPicker numberPicker,int min,int max){
        numberPicker.setMaxValue(max);
        numberPicker.setMinValue(min);
        numberPicker.setWrapSelectorWheel(true);
    }

    private void initView(){
        height = (NumberPicker) findViewById(R.id.height_picker);
        weight = (NumberPicker) findViewById(R.id.weight_picker);

        skillOutside = (NumberPicker) findViewById(R.id.skill_outside_hitter);
        skillRightSide = (NumberPicker) findViewById(R.id.skill_right_side_hitter);
        skillOpposite = (NumberPicker) findViewById(R.id.skill_opposite_hitter);
        skillMiddleBlocker = (NumberPicker) findViewById(R.id.skill_middle_blocker);
        skillLibero = (NumberPicker) findViewById(R.id.skill_libero);
        skillDefensive = (NumberPicker) findViewById(R.id.skill_defensive_specialist);
        skillSetter = (NumberPicker) findViewById(R.id.skill_setter);

        talent = (RatingBar) findViewById(R.id.player_talent);
    }
}