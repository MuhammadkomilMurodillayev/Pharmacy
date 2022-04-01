package uz.m_m.dao.branch;

import uz.m_m.models.branch.Branch;

import java.util.ArrayList;
import java.util.List;

public class BranchDao {
    private final static List<Branch> branches = new ArrayList<>();


    public static Branch findById(String branchId) {
        for (Branch branch : branches) {
            if (branch.getId().equals(branchId)) return branch;
        }
        return null;
    }
}
