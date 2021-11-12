package model;

public class Profile {
    private int s_id;
    private boolean activation;
    private String name;
    private int pr_img;
    private int age;
    private int sleep_habit;
    private int lifestyle;
    private int smoking;
    private int grade;
    private String major;
    private int mbti;
    private int cleaning;
    private int indoor_eating;
    private int sharing;
    private int habitude;

    public Profile() {}


    public Profile(int s_id, boolean activation, String name, int pr_img, int age, int sleep_habit, int lifestyle, int smoking, int grade, String major, int cleaning, int indoor_eating, int mbti, int sharing, int habitude) {
        this.s_id = s_id;
        this.activation = activation;
        this.name = name;
        this.pr_img = pr_img;
        this.age = age;
        this.sleep_habit = sleep_habit;
        this.lifestyle = lifestyle;
        this.smoking = smoking;
        this.grade = grade;
        this.major = major;
        this.cleaning = cleaning;
        this.indoor_eating = indoor_eating;
        this.mbti = mbti;
        this.sharing = sharing;
        this.habitude = habitude;
    }

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public boolean getActivation() {
        return activation;
    }

    public void setActivation(boolean activation) {
        this.activation = activation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPr_img() {
        return pr_img;
    }

    public void setPr_img(int pr_img) {
        this.pr_img = pr_img;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSleep_habit() {
        return sleep_habit;
    }

    public void setSleep_habit(int sleep_habit) {
        this.sleep_habit = sleep_habit;
    }

    public int getLifestyle() {
        return lifestyle;
    }

    public void setLifestyle(int lifestyle) {
        this.lifestyle = lifestyle;
    }

    public int getSmoking() {
        return smoking;
    }

    public void setSmoking(int smoking) {
        this.smoking = smoking;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getMbti() {
        return mbti;
    }

    public void setMbti(int mbti) {
        this.mbti = mbti;
    }

    public int getCleaning() {
        return cleaning;
    }

    public void setCleaning(int cleaning) {
        this.cleaning = cleaning;
    }

    public int getIndoor_eating() {
        return indoor_eating;
    }

    public void setIndoor_eating(int indoor_eating) {
        this.indoor_eating = indoor_eating;
    }

    public int getSharing() {
        return sharing;
    }

    public void setSharing(int sharing) {
        this.sharing = sharing;
    }

    public int getHabitude() {
        return habitude;
    }

    public void setHabitude(int habitude) {
        this.habitude = habitude;
    }

    boolean isActivation(Profile profile) {
        if (profile.activation)
            return true;
        else
            return false;
    }

//    boolean isNullChecked(Profile profile) {
//        if ((profile.name != null && profile.pr_img != null && profile.age != null
//    }
}
