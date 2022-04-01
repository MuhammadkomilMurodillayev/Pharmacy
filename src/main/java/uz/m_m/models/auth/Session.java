package uz.m_m.models.auth;

import uz.m_m.enums.auth.Role;
import uz.m_m.enums.localization.Language;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

import static uz.m_m.settings.Configs.getConfig;

@Getter
@Setter
@AllArgsConstructor
public class Session {
    private String organizationId;
    private String branchId;
    private Language language;
    private Role role;
    private AuthUser authUser;

    public Session() {
        this.role = Role.ANONYMOUS;
    }

    public Language getLanguage() {
        return Objects.isNull(language) ? Language.getByCode(getConfig("sys.language")): language;
    }
}
