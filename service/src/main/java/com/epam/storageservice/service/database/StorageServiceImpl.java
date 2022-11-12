package com.epam.storageservice.service.database;

import com.epam.storageservice.dto.StorageDto;
import com.epam.storageservice.mapper.StorageMapper;
import com.epam.storageservice.model.StorageEntity;
import com.epam.storageservice.repository.StorageRepository;
import com.epam.storageservice.service.s3.S3Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toSet;


@Slf4j
@Service
@RequiredArgsConstructor
public class StorageServiceImpl implements StorageService {

    private final StorageRepository repository;
    private final StorageMapper mapper;
    private final S3Service s3Service;

    @Transactional
    @Override
    public int create(StorageDto dto) {
        s3Service.createBucket(mapper.mapBucketName(dto));
        StorageEntity entity = repository.save(mapper.toEntity(dto));
        log.info("Storage {} has been created", entity);
        return entity.getId();
    }

    public Iterable<StorageEntity> getAllStorages() {
        return repository.findAll();
    }

    @Override
    public void deleteStorages(Set<Integer> ids) {
        deleteBuckets(ids);
        deleteEntities(ids);
        log.info("Storages with ids: {} have been deleted", ids);
    }

    private void deleteEntities(Set<Integer> ids) {
        ids.forEach(id -> {
            if (repository.existsById(id)) {
                repository.deleteById(id);
            }
        });
    }

    private void deleteBuckets(Set<Integer> ids) {
        Iterable<StorageEntity> storageEntities = repository.findAllById(ids);
        Set<String> bucketNames = StreamSupport.stream(storageEntities.spliterator(), false)
                .map(StorageEntity::getBucketName)
                .collect(toSet());
        s3Service.deleteBuckets(bucketNames);
    }

}
