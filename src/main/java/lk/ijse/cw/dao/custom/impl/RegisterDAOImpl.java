package lk.ijse.cw.dao.custom.impl;

import lk.ijse.cw.dao.custom.RegisterDAO;
import lk.ijse.cw.entity.Register;

import java.util.List;

public class RegisterDAOImpl implements RegisterDAO {


    @Override
    public boolean save(Register entity) {
        return false;
    }

    @Override
    public boolean update(Register entity) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public List<Register> getAll() {
        return List.of();
    }

    @Override
    public Register search(String id) {
        return null;
    }

    @Override
    public String genarateNextID() {
        return "";
    }
}
