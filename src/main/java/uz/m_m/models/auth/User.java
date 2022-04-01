package uz.m_m.models.auth;

import uz.m_m.enums.auth.Role;
import uz.m_m.enums.auth.Status;
import uz.m_m.enums.helpers.MenuKey;
import uz.m_m.enums.localization.Language;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class User extends AuthUser {
    private Role role = Role.ANONYMOUS;
    private Status status = Status.NON_ACTIVE;
    private String organizationId;
    private String branchId;
    private Language language;

    public User(String username, String password) {
        super(username, password);
    }

    public User(String username, String password, Map<MenuKey, String> menus) {
        super(username, password, menus);
    }

    public User(String username, String password, Role role) {
        this(username, password);
        this.role = role;
    }

    public User(String username, String password, String organizationId) {
        this(username, password);
        this.role = Role.ANONYMOUS;
        this.organizationId = organizationId;
    }
}
