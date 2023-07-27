public class Student {

    String _id;
    String name;
    String age;
    String telephone;

    public Student(String _id, String name, String age, String telephone) {
        this._id = _id;
        this.name = name;
        this.age = age;
        this.telephone = telephone;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
