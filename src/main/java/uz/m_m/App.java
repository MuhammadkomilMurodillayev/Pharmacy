package uz.m_m;

import uz.m_m.dao.auth.AuthUserDao;
import uz.m_m.dao.menu.MenuDao;
import uz.m_m.db.Db;
import uz.m_m.enums.helpers.MenuKey;
import uz.m_m.services.admin.AdminService;
import uz.m_m.services.auth.AuthUserService;
import uz.m_m.services.org.OrgService;
import uz.m_m.settings.Configs;

import java.text.MessageFormat;

import static uz.m_m.utils.Color.BLUE;
import static uz.m_m.utils.Color.RED;
import static uz.m_m.utils.Input.getNum;
import static uz.m_m.utils.Output.println;

public class App {

    static {
        Db.init();
    }

    public static void main(String[] args) {
        // TODO: 11/23/2021 you know what to do 😎
        //System.out.println(MessageFormat.format(Configs.getConfig("hello"), "Mr", "John"));
//        println(GREEN, Message.PLEASE_CHOOSE_MENU.get(AuthUserDao.session().getLanguage()));
        MenuDao.getMenus(AuthUserDao.session().getRole()).forEach((key, val) -> println(BLUE, val + "->" + key.getCode()));

        Integer code = getNum("?:");
        MenuKey key = MenuKey.findByCode(code);
        if (MenuKey.UNDEFINED.equals(key)) println(RED, "Wrong Key Chosen");
        else
            switch (key) {
                case CREATE_ORGANIZATION -> OrgService.create();
                case DELETE_ORGANIZATION -> OrgService.delete();
                case BLOCK_ORGANIZATION -> OrgService.block();
                case UNBLOCK_ORGANIZATION -> OrgService.unblock();
                case SHOW_ORGANIZATIONS -> OrgService.showOrganizationsList();
                case SEE_ALL_BRANCH_LOCATIONS -> OrgService.allBranchLocations();
                case CREATE_ADMIN -> AdminService.create();
                case DELETE_ADMIN -> AdminService.delete();
                case BLOCK_ADMIN -> AdminService.block();
                case UNBLOCK_ADMIN -> AdminService.unblock();
                case LOGIN -> AuthUserService.login();
                case LOGOUT -> AuthUserService.logout();
                case CHANGE_LANGUAGE -> AuthUserService.changeLanguage();
                case EXIT -> {
                    AuthUserService.quit();
                    return;
                }
                default -> println(RED, "Wrong choice");
            }
        main(args);
    }
}
