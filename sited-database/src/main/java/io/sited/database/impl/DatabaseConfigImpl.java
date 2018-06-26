package io.sited.database.impl;

import io.sited.Binder;
import io.sited.database.DatabaseConfig;
import io.sited.database.Repository;
import io.sited.util.type.ClassValidator;
import io.sited.util.type.Types;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;

/**
 * @author chi
 */
public class DatabaseConfigImpl implements DatabaseConfig {
    private final Binder binder;
    private final DatabaseImpl database;

    public DatabaseConfigImpl(Binder binder, DatabaseImpl database) {
        this.binder = binder;
        this.database = database;
    }

    @Override
    public <T> DatabaseConfig entity(Class<T> entityClass) {
        validator(entityClass).validate();
        database.addEntityClassName(entityClass);
        binder.bind(Types.generic(Repository.class, entityClass)).toInstance(new RepositoryImpl<>(entityClass, database));
        return this;
    }

    private ClassValidator validator(Class<?> type) {
        return new ClassValidator(type)
            .allowEnum()
            .allow(String.class)
            .allow(Boolean.class)
            .allow(Byte.class)
            .allow(Integer.class)
            .allow(Long.class)
            .allow(Double.class)
            .allow(Float.class)
            .allow(BigDecimal.class)
            .allow(byte[].class)
            .allow(OffsetDateTime.class)
            .allow(LocalDate.class)
            .allow(LocalTime.class);
    }
}
