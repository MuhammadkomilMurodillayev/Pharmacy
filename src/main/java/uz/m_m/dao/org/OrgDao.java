package uz.m_m.dao.org;

import uz.m_m.models.organization.Organization;

import java.util.HashSet;
import java.util.Set;

public class OrgDao {
    private final static Set<Organization> organizations = new HashSet<>();

    public static boolean addOrg(Organization organization) {
        organizations.add(organization);
        return true;
    }

    public static Organization findById(String organizationId) {
        for (Organization organization : organizations) {
            if (organization.getId().equals(organizationId)) {
                return organization;
            }
        }
        return null;
    }
}
