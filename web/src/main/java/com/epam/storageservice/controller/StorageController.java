package com.epam.storageservice.controller;

import com.epam.storageservice.dto.StorageDto;
import com.epam.storageservice.dto.StorageIdDto;
import com.epam.storageservice.dto.StorageIdsDto;
import com.epam.storageservice.service.database.StorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Set;


@Validated
@RestController
@RequestMapping("/storages")
@RequiredArgsConstructor
public class StorageController {

    private final StorageService storageService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StorageIdDto createStorage(@RequestBody StorageDto storageDto) {
        int id = storageService.create(storageDto);
        return new StorageIdDto(id);
    }

    @GetMapping
    public Collection<StorageDto> getStorages() {
        return storageService.getAllStorages();
    }

    @GetMapping("/{storageId}")
    public StorageDto getStorage(@PathVariable Integer storageId) {
        return storageService.findStorage(storageId);
    }

    @DeleteMapping
    public StorageIdsDto deleteStorages(@RequestParam Set<Integer> id) {
        storageService.deleteStorages(id);
        return new StorageIdsDto(id);
    }

}
