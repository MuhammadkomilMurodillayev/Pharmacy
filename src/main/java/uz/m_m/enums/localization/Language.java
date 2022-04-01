package uz.m_m.enums.localization;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Language {
    UZ("UZ", "Uzbek"),
    EN("EN", "English"),
    RU("RU", "Russian");

    private final String code;
    private final String value;

    public static Language getByCode(String code) {
        for (Language language : values()) {
            if (language.getCode().equalsIgnoreCase(code)) return language;
        }
        return Language.RU;
    }


    @Override
    public String toString() {
        return value + " -> " + code;
    }
}