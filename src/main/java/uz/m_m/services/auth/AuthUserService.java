package uz.m_m.services.auth;

import uz.m_m.dao.auth.AuthUserDao;
import uz.m_m.dao.branch.BranchDao;
import uz.m_m.dao.org.OrgDao;
import uz.m_m.enums.auth.Role;
import uz.m_m.enums.auth.Status;
import uz.m_m.enums.internationalization.Message;
import uz.m_m.enums.localization.Language;
import uz.m_m.models.auth.User;
import uz.m_m.models.branch.Branch;
import uz.m_m.models.organization.Organization;
import uz.m_m.services.check.auth.UserCheckService;

import java.util.Objects;

import static uz.m_m.settings.Configs.getConfig;
import static uz.m_m.utils.Color.*;
import static uz.m_m.utils.Input.getStr;
import static uz.m_m.utils.Output.println;

public class AuthUserService {

    public static boolean login() {
        String username = getStr(Message.USERNAME.get(getConfig("sys.language")) + ":");
        String password = getStr(Message.PASSWORD.get(getConfig("sys.language")) + ":");
        User user = AuthUserDao.findUserByUsername(username);
        if (!UserCheckService.checkForNull(user)) return false;
        if (!UserCheckService.checkForActive(user)) return false;
        if (!UserCheckService.checkForCredentials(user, password)) return false;

        Organization organization = OrgDao.findById(user.getOrganizationId());
        if (Objects.isNull(organization)) {
            // TODO: 11/23/2021 you know what to do 😎
            println(RED, "Organization not found");
            return false;
        }

        if (!organization.getStatus().equals(Status.ACTIVE)) {
            // TODO: 11/23/2021 you know what to do 😎
            println(RED, "Organization not active");
            return false;
        }

        if (user.getRole().equals(Role.USER)) {
            String branchId = user.getBranchId();
            Branch branch = BranchDao.findById(branchId);
            if (Objects.isNull(branch) || !branch.getStatus().equals(Status.ACTIVE)) {
                // TODO: 11/23/2021 you know what to do 😎
                println(RED, "Something wrong with you");
                return false;
            }
        }

        // TODO: 11/23/2021 localize this too
        AuthUserDao.login(user);
        println(GREEN, "Successfully logged in");
        return true;
    }

    public static void logout() {

    }

    public static void quit() {

    }


    public static void changeLanguage() {
        if (UserCheckService.loggedIN()) {
            println(PURPLE, Language.RU);
            println(PURPLE, Language.UZ);
            println(PURPLE, Language.EN);
            String lang = getStr("?:");
            Language language = Language.getByCode(lang);
            String userId = AuthUserDao.session().getAuthUser().getId();
            AuthUserDao.changeLanguage(userId, language);
        }
    }
}
