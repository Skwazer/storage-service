package com.epam.storageservice.service.database;

import com.epam.storageservice.dto.StorageDto;
import com.epam.storageservice.model.StorageEntity;

import java.util.Set;


public interface StorageService {

    int create(StorageDto dto);

    Iterable<StorageEntity> getAllStorages();

    void deleteStorages(Set<Integer> ids);

}
