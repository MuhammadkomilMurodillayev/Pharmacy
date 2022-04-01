package uz.m_m.dao.menu;

import uz.m_m.dao.auth.AuthUserDao;
import uz.m_m.enums.auth.Role;
import uz.m_m.enums.helpers.MenuKey;
import uz.m_m.enums.internationalization.Message;
import uz.m_m.enums.localization.Language;

import java.util.Comparator;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

import static uz.m_m.enums.auth.Role.*;

public class MenuDao {
    public static Map<MenuKey, String> getMenus(Role role) {
        Language language = Objects.nonNull(AuthUserDao.session().getLanguage()) ? AuthUserDao.session().getLanguage() : Language.RU;

        Map<MenuKey, String> menus = new TreeMap<>(Comparator.comparing(MenuKey::getCode));
        // Super Admin
        if (role.in(SUPER_ADMIN)) {
            menus.put(MenuKey.CREATE_ORGANIZATION, Message.CREATE_ORGANIZATION.get(language));
            menus.put(MenuKey.DELETE_ORGANIZATION, Message.DELETE_ORGANIZATION.get(language));
            menus.put(MenuKey.BLOCK_ORGANIZATION, Message.BLOCK_ORGANIZATION.get(language));
            menus.put(MenuKey.UNBLOCK_ORGANIZATION, Message.UNBLOCK_ORGANIZATION.get(language));
            menus.put(MenuKey.SHOW_ORGANIZATIONS, Message.SHOW_ORGANIZATIONS.get(language));
            menus.put(MenuKey.SEE_ALL_BRANCH_LOCATIONS, Message.SEE_ALL_BRANCH_LOCATIONS.get(language));
            menus.put(MenuKey.DELETE_ADMIN, Message.DELETE_ADMIN.get(language));
            menus.put(MenuKey.BLOCK_ADMIN, Message.BLOCK_ADMIN.get(language));
            menus.put(MenuKey.UNBLOCK_ADMIN, Message.UNBLOCK_ADMIN.get(language));
            menus.put(MenuKey.CREATE_ADMIN, Message.CREATE_ADMIN.get(language));
            // Admin
        } else if (role.in(ADMIN)) {
            menus.put(MenuKey.CREATE_ADMIN, Message.CREATE_ADMIN.get(language));
            menus.put(MenuKey.CREATE_BRANCH, Message.CREATE_BRANCH.get(language));
            menus.put(MenuKey.DELETE_BRANCH, Message.DELETE_BRANCH.get(language));
            menus.put(MenuKey.BLOCK_BRANCH, Message.BLOCK_BRANCH.get(language));
            menus.put(MenuKey.UNBLOCK_BRANCH, Message.UNBLOCK_BRANCH.get(language));
            menus.put(MenuKey.SHOW_BRANCHES, Message.SHOW_BRANCHES.get(language));
            menus.put(MenuKey.SEE_BRANCH_LOCATIONS, Message.SEE_BRANCH_LOCATIONS.get(language));
            menus.put(MenuKey.CREATE_USER, Message.CREATE_USER.get(language));
            menus.put(MenuKey.DELETE_USER, Message.DELETE_USER.get(language));
            menus.put(MenuKey.BLOCK_USER, Message.BLOCK_USER.get(language));
            menus.put(MenuKey.UNBLOCK_USER, Message.UNBLOCK_USER.get(language));
            menus.put(MenuKey.ADD_DRUG, Message.ADD_DRUG.get(language));
            menus.put(MenuKey.SHOW_DRUGS, Message.SHOW_DRUGS.get(language));
            menus.put(MenuKey.SELL_DRUG, Message.SELL_DRUG.get(language));
            menus.put(MenuKey.SEARCH_DRUG, Message.SEARCH_DRUG.get(language));
        } else if (role.in(USER)) {
            menus.put(MenuKey.SHOW_DRUGS, Message.SHOW_DRUGS.get(language));
            menus.put(MenuKey.SELL_DRUG, Message.SELL_DRUG.get(language));
            menus.put(MenuKey.SEARCH_DRUG, Message.SEARCH_DRUG.get(language));
        } else if (role.in(ANONYMOUS)) {
            // TODO: 11/23/2021 localize these messages
            menus.put(MenuKey.LOGIN, "login");
        }
        if (role.notIn(ANONYMOUS)) {
            menus.put(MenuKey.RESET_PASSWORD, Message.RESET_PASSWORD.get(language));
            menus.put(MenuKey.CHANGE_LANGUAGE, Message.CHANGE_LANGUAGE.get(language));
            menus.put(MenuKey.LOGOUT, Message.LOGOUT.get(language));
        }
        // TODO: 11/23/2021 you know what to do 😎
        menus.put(MenuKey.EXIT, "exit");
        return menus;
    }
}
