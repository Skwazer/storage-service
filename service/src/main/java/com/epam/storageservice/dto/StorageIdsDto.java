package com.epam.storageservice.dto;

import lombok.AllArgsConstructor;
import lombok.Value;

import java.util.Set;


@Value
@AllArgsConstructor
public class StorageIdsDto {

    Set<Integer> ids;

}
