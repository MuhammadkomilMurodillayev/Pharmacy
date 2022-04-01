package uz.m_m.dao.auth;

import uz.m_m.enums.localization.Language;
import uz.m_m.models.auth.AuthUser;
import uz.m_m.models.auth.Session;
import uz.m_m.models.auth.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static uz.m_m.utils.Color.RED;
import static uz.m_m.utils.Output.println;

public class AuthUserDao {
    private static final List<User> users = new ArrayList<>();
    private static Session session = new Session();

    public static User findUserByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(username)) return user;
        }
        return null;
    }

    public static Session login(User user) {
        AuthUser authUser = new AuthUser(user);
        session = new Session();
        session.setAuthUser(authUser);
        session.setBranchId(user.getBranchId());
        session.setOrganizationId(user.getOrganizationId());
        session.setLanguage(user.getLanguage());
        session.setRole(user.getRole());
        return session;
    }

    public static Session session() {
        return session;
    }

    public static boolean addUser(User user) {
        if (Objects.nonNull(findUserByUsername(user.getUsername()))) {
            // TODO: 11/23/2021 Create localization for down
            println(RED, "User name already taken");
            return false;
        }
        users.add(user);
        return true;
    }


    public static void changeLanguage(String userId, Language language) {
        users.forEach(user -> {
            if (user.getId().equals(userId)) {
                user.setLanguage(language);
                session.setLanguage(language);
            }
        });

    }

}
