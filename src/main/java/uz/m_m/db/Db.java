package uz.m_m.db;

import uz.m_m.dao.auth.AuthUserDao;
import uz.m_m.dao.menu.MenuDao;
import uz.m_m.dao.org.OrgDao;
import uz.m_m.enums.auth.Status;
import uz.m_m.enums.localization.Language;
import uz.m_m.models.auth.User;
import uz.m_m.models.organization.Organization;

import static uz.m_m.enums.auth.Role.SUPER_ADMIN;
import static uz.m_m.settings.Configs.getConfig;

public class Db {
    public static void init() {
        Organization organization = new Organization(getConfig("sys.org.name"), true);
        User user = new User(getConfig("sys.username"), getConfig("sys.password"), organization.getId());
        user.setRole(SUPER_ADMIN);
        user.setMenus(MenuDao.getMenus(SUPER_ADMIN));
        user.setLanguage(Language.RU);
        user.setStatus(Status.ACTIVE);
        AuthUserDao.addUser(user);
        OrgDao.addOrg(organization);
    }

}
