package uz.m_m.services.org;

import uz.m_m.enums.auth.Role;

import static uz.m_m.services.check.auth.UserCheckService.hasRole;

public class OrgService {
    public static void allBranchLocations() {

    }

    public static void create() {
        if (hasRole(Role.SUPER_ADMIN)) {
            System.out.println("Do some stuff");
        } else {
            System.out.println("You are not authorized to perform this action");
        }
    }

    public static void delete() {

    }

    public static void block() {

    }

    public static void unblock() {

    }

    public static void showOrganizationsList() {

    }
}
