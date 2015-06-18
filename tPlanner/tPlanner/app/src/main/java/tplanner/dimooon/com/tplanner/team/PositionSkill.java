package tplanner.dimooon.com.tplanner.team;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "positionSkills")
public class PositionSkill {

    @DatabaseField(generatedId = true)
    private long id;
    @DatabaseField
    private int skillType;
    @DatabaseField
    private long playerId;
    @DatabaseField
    private int value;
    
    public PositionSkill(){

    }

    public PositionSkill(int skillType, long playerId, int value) {
        this.skillType = skillType;
        this.playerId = playerId;
        this.value = value;
    }

    public int getSkillType() {
        return skillType;
    }

    public void setSkillType(int skillType) {
        this.skillType = skillType;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "PositionSkill{" +
                "id=" + id +
                ", skillType=" + skillType +
                ", playerId=" + playerId +
                ", value=" + value +
                '}';
    }
}
