package uz.m_m.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Stickers {
    USER("\uD83E\uDD35");
    private String code;

    public String get(String suf) {
        return this.getCode() + " " + suf;
    }
}
