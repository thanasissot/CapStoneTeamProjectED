package com.eurodyn.service;

import java.util.Collection;

public interface GenericService<T, K> {
    T create(T model);
    Collection<T> read();
    T read(K modelId);
    T update(K modelId, T newModel);
    T delete(K modelId);
}
