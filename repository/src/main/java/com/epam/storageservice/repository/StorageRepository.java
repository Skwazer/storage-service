package com.epam.storageservice.repository;

import com.epam.storageservice.model.StorageEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StorageRepository extends CrudRepository<StorageEntity, Integer> {
}
