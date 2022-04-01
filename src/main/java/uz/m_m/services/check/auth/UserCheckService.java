package uz.m_m.services.check.auth;

import uz.m_m.dao.auth.AuthUserDao;
import uz.m_m.enums.auth.Role;
import uz.m_m.enums.auth.Status;
import uz.m_m.enums.internationalization.Message;
import uz.m_m.enums.localization.Language;
import uz.m_m.models.auth.User;
import uz.m_m.utils.Stickers;

import java.util.Objects;

import static uz.m_m.settings.Configs.getConfig;
import static uz.m_m.utils.Color.RED;
import static uz.m_m.utils.Output.println;

public class UserCheckService {
    public static boolean checkForNull(User user) {
        if (Objects.isNull(user)) {
            println(RED, Stickers.USER.get(Message.USER_NOTFOUND.get(Language.getByCode(getConfig("sys.language")))));
            return false;
        }
        return true;
    }

    public static boolean checkForActive(User user) {
        if (!user.getStatus().equals(Status.ACTIVE)) {
            println(RED, "User not active");
            return false;
        }
        return true;
    }

    public static boolean checkForCredentials(User user, String password) {
        if (!user.getPassword().equals(password)) {
            // TODO: 11/23/2021 you know what to do 😎
            println(RED, "Bad Credentials");
            return false;
        }
        return true;
    }

    public static boolean hasRole(Role role) {
        return AuthUserDao.session().getRole().equals(role);
    }

    public static boolean loggedIN() {
        return !hasRole(Role.ANONYMOUS);
    }

}
