package me.proxima.database.model.decrypted;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;

import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;

public abstract class DecryptedTable<T extends DecryptedTable>{
    private Class<T> decryptedClazz;

    @SuppressWarnings("uncheck")
    protected DecryptedTable() {
        this.decryptedClazz = (Class<T>)
                ((ParameterizedType)getClass()
                        .getGenericSuperclass())
                        .getActualTypeArguments()[0];
    }

    public Dao<T, ?> getDao(ConnectionSource source){
        Dao<T, ?> dao = null;
        try{
            dao = DaoManager.createDao(source, decryptedClazz);
        }catch (Exception e){
            dao = null;
        }
        return dao;
    }

    public void appendRow(ConnectionSource source){
        try {
            Dao<T, ?> dao = this.getDao(source);
            dao.create((T)this);
        } catch (SQLException e) {
            return;
        }
    }
}
