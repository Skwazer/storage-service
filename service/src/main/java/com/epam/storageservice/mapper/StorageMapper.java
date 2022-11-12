package com.epam.storageservice.mapper;

import com.epam.storageservice.dto.StorageDto;
import com.epam.storageservice.model.StorageEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface StorageMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "bucketName", source = "dto", qualifiedByName="bucketNameMapper")
    public StorageEntity toEntity(StorageDto dto);

    @Named("bucketNameMapper")
    default String mapBucketName(StorageDto dto) {
        return dto.getType().getName() + "-" + dto.getBucketName();
    }

}
