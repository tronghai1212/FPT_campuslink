package entities;

public class UserRoles {
    private String id;
    private String authority;
    private String description;

    public UserRoles() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserRoles(String id, String authority, String description) {
        this.id = id;
        this.authority = authority;
        this.description = description;
    }

    public static UserRoles roleUser(){
        UserRoles roleUser = new UserRoles("1","user", "chi co quyen login");
        return roleUser;
    }
    public static UserRoles roleAdmin(){
        UserRoles roleAdmin = new UserRoles("2","admin", "full quyen");
        return roleAdmin;
    }

    @Override
    public String toString() {
        return
                "id='" + id + '\'' +
                ", authority='" + authority + '\'' +
                ", description='" + description + '\''
                ;
    }
}
