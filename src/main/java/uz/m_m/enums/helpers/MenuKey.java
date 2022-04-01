package uz.m_m.enums.helpers;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum MenuKey {
    CREATE_ORGANIZATION(1),
    DELETE_ORGANIZATION(2),
    BLOCK_ORGANIZATION(3),
    UNBLOCK_ORGANIZATION(4),
    SHOW_ORGANIZATIONS(5),
    SEE_ALL_BRANCH_LOCATIONS(6),
    DELETE_ADMIN(7),
    BLOCK_ADMIN(8),
    UNBLOCK_ADMIN(9),
    CREATE_ADMIN(10),
    CREATE_BRANCH(11),
    DELETE_BRANCH(12),
    BLOCK_BRANCH(13),
    UNBLOCK_BRANCH(14),
    SHOW_BRANCHES(15),
    SEE_BRANCH_LOCATIONS(16),
    CREATE_USER(17),
    DELETE_USER(18),
    BLOCK_USER(19),
    UNBLOCK_USER(20),
    ADD_DRUG(21),
    SHOW_DRUGS(22),
    SELL_DRUG(23),
    SEARCH_DRUG(24),
    RESET_PASSWORD(25),
    CHANGE_LANGUAGE(26),
    LOGOUT(27),
    LOGIN(28),
    EXIT(29),
    UNDEFINED(30);

    private final Integer code;

    public static MenuKey findByCode(Integer code) {
        for (MenuKey key : values()) {
            if (key.code.equals(code)) return key;
        }
        return MenuKey.UNDEFINED;
    }

    public static MenuKey findByName(String code) {
        for (MenuKey key : values()) {
            if (key.name().equalsIgnoreCase(code)) return key;
        }
        return MenuKey.UNDEFINED;
    }

    @Override
    public String toString() {
        return this.name();
    }
}
