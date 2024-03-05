package com.eurodyn.service;

import java.util.List;

public interface GenericService<T, K> {
    T create(T model);
    List<T> read();
    T read(K modelId);
    T update(K modelId, T newModel);
    T delete(K modelId);
}
