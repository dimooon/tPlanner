package tplanner.dimooon.com.tplanner.team;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "players")
public class Player {

    public Player(){

    }

    public Player(String name, int height, int weight, String avatar) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.avatar = avatar;
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

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}