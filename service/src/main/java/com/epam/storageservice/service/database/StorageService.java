package com.epam.storageservice.service.database;

import com.epam.storageservice.dto.StorageDto;

import java.util.Collection;
import java.util.Set;


public interface StorageService {

    int create(StorageDto dto);

    Collection<StorageDto> getAllStorages();

    void deleteStorages(Set<Integer> ids);

    StorageDto findStorage(Integer storageId);
}
