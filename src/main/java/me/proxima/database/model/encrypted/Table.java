package me.proxima.database.model.encrypted;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import me.proxima.database.model.decrypted.DecryptedTable;

import java.lang.reflect.ParameterizedType;

public abstract class Table<C extends Table, D extends DecryptedTable>{
    private Class<C> commonTableClazz;
    private Class<D> decryptedTableClazz;

    @SuppressWarnings("uncheck")
    protected Table(){
        this.commonTableClazz = (Class<C>)
                ((ParameterizedType)getClass()
                        .getGenericSuperclass())
                        .getActualTypeArguments()[0];
        this.decryptedTableClazz = (Class<D>)
                ((ParameterizedType)getClass()
                        .getGenericSuperclass())
                        .getActualTypeArguments()[1];;
    }

    public Dao<C, ?> getDao(ConnectionSource source){
        Dao<C, ?> dao = null;
        try{
            dao = DaoManager.createDao(source, commonTableClazz);
        }catch(Exception e){
            e.printStackTrace();
            dao = null;
        }
        return dao;
    }

    public Class<D> getDecryptedType(){
        return this.decryptedTableClazz;
    }

    public abstract D decrypt();
}
