package sample;

public class UserPriv {
    private boolean insert;
    private String[] insert_table;
    private boolean select = true;
    private String[] select_table;
    private boolean update;
    private String[] update_table;
    private boolean delete;
    private String[] delete_table;
    private   String[] tables;
    private int id_user;
    private String email_user;
    private String first_name_user;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail_user() {
        return email_user;
    }

    public void setEmail_user(String email_user) {
        this.email_user = email_user;
    }

    public String getFirst_name_user() {
        return first_name_user;
    }

    public void setFirst_name_user(String first_name_user) {
        this.first_name_user = first_name_user;
    }

    public String getLast_name_user() {
        return last_name_user;
    }

    public void setLast_name_user(String last_name_user) {
        this.last_name_user = last_name_user;
    }

    private String last_name_user;

    public String[] getInsert_table() {
        return insert_table;
    }

    public void setInsert_table(String[] insert_table) {
        this.insert_table = insert_table;
    }

    public String[] getSelect_table() {
        return select_table;
    }

    public void setSelect_table(String[] select_table) {
        this.select_table = select_table;
    }

    public String[] getUpdate_table() {
        return update_table;
    }

    public void setUpdate_table(String[] update_table) {
        this.update_table = update_table;
    }

    public String[] getDelete_table() {
        return delete_table;
    }

    public void setDelete_table(String[] delete_table) {
        this.delete_table = delete_table;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String[] getTables() {
        return tables;
    }

    public void setTables(String[] tables) {
        this.tables = tables;
    }

    public boolean isInsert() {
        return insert;
    }

    public void setInsert(boolean insert) {
        this.insert = insert;
    }

    public boolean isSelect() {
        return select;
    }

    public void setSelect(boolean select) {
        this.select = select;
    }

    public boolean isUpdate() {
        return update;
    }

    public void setUpdate(boolean update) {
        this.update = update;
    }

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }


    public UserPriv(int id_user){
        this.id_user = id_user;
    }
    public UserPriv(UserPriv user){
         insert= user.insert;
         insert_table =user.insert_table;
         select_table= user.select_table;
         update= user.update;
        update_table= user.update_table;
        delete= user.delete;
        delete_table= user.delete_table;
        tables= user.tables;
        id_user= user.id_user;
        email_user= user.email_user;
        first_name_user=user.first_name_user;
        password= user.password;
    }
}
