package com.epam.storageservice.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum StorageType {

    STAGING("staging"),
    PERMANENT("permanent");

    private final String name;

}
