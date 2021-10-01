package com.xeype.config;

import com.xeype.util.ResourceUtil;
import com.xeype.dao.*;

import java.util.Map;

public class DaoFactory {

    private static DaoFactory instance;
    private CrudDao authorDao;
    private CrudDao bookDao;
    private DaoType daoType;

    private DaoFactory() { }

    public static DaoFactory getInstance() {
        if (instance == null) {
            instance = new DaoFactory();
        }
        return instance;
    }

    public CrudDao getAuthorDao() {
        if (daoType == null) {
            Map<String, String> map = ResourceUtil.getResource("application.properties");
            daoType = DaoType.init(map.get("dao.type"));
        }
        switch (daoType) {
            case CSV: {
                if (authorDao == null) {
                    authorDao = new CsvAuthorDao();
                }
            }
            break;
            case JSON: {
                if (authorDao == null) {
                    authorDao = new JsonAuthorDao();
                }
            }
            break;
        }
        return authorDao;
    }

    public CrudDao getBookDao() {
        if (daoType == null) {
            Map<String, String> map = ResourceUtil.getResource("application.properties");
            daoType = DaoType.init(map.get("dao.type"));
        }
        switch (daoType) {
            case CSV : {
                if (bookDao == null) {
                    bookDao = new CsvBookDao();
                }
            } break;
            case JSON : {
                if (bookDao == null) {
                    bookDao = new JsonBookDao();
                }
            } break;
        }
        return bookDao;
    }
}
