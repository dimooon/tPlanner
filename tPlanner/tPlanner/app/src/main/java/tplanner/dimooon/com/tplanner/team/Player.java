package tplanner.dimooon.com.tplanner.team;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@DatabaseTable(tableName = "players")
public class Player {

    @DatabaseField(generatedId = true)
    private long id;
    @DatabaseField
    private String name;
    @DatabaseField
    private int height;
    @DatabaseField
    private int weight;
    @DatabaseField
    private String avatar;
    @DatabaseField
    private double talent;

    private ArrayList<PositionSkill> skills = null;

    public Player(){
        skills = new ArrayList<>();
    }

    public Player(String name, int height, int weight, String avatar, double talent) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.avatar = avatar;
        this.talent = talent;

        skills = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public long getId(){
        return this.id;
    }

    public double getTalent() {
        return talent;
    }

    public void setTalent(double talent) {
        this.talent = talent;
    }

    public ArrayList<PositionSkill> getSkills() {
        return skills;
    }

    public void setSkills(List<PositionSkill> skills) {
        this.skills = new ArrayList<>(skills);
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", avatar='" + avatar + '\'' +
                ", talent=" + talent +
                ", skills=" + skills +
                '}';
    }

    public PositionSkill getBestSkill(){

        Collections.sort(skills, new Comparator<PositionSkill>() {
            @Override
            public int compare(PositionSkill positionSkill, PositionSkill t1) {

                if(positionSkill.getValue() == t1.getValue()){
                    return 0;
                }else{
                    return positionSkill.getValue() > t1.getValue() ? -1 : 1;
                }
            }
        });

        return skills.get(0);
    }

}