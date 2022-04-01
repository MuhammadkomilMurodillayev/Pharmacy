package uz.m_m.models.auth;

import uz.m_m.enums.helpers.MenuKey;
import lombok.*;

import uz.m_m.models.Entity;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(of = {"username"})
public class AuthUser extends Entity {
    private String username;
    private String password;
    private Map<MenuKey, String> menus = new HashMap<>();


    public AuthUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public AuthUser(User user) {
        this(user.getUsername(), user.getPassword());
        this.setId(user.getId());
        this.menus = user.getMenus();
    }
}
