package com.epam.storageservice.dto;

import com.epam.storageservice.model.StorageType;
import lombok.AllArgsConstructor;
import lombok.Value;


@Value
@AllArgsConstructor
public class StorageDto {

    Integer id;
    StorageType type;
    String bucketName;
    String path;

}
