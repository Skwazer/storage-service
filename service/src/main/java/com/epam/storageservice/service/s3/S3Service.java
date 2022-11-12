package com.epam.storageservice.service.s3;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.CreateBucketRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
@RequiredArgsConstructor
@Slf4j
public class S3Service {

    @Value("${aws.region}")
    private String awsRegion;

    private final AmazonS3 s3Client;

    public void createBucket(String bucketName) {
        if (s3Client.doesBucketExistV2(bucketName)) {
            log.warn("Bucket name is not available. Try again with a different Bucket name.");
            return;
        }
        CreateBucketRequest request = new CreateBucketRequest(bucketName, awsRegion);
        Bucket bucket = s3Client.createBucket(request);
        log.info("Bucket with name: {} has been created", bucket.getName());
    }

    public void deleteBuckets(Set<String> bucketNames) {
        bucketNames.stream()
                .filter(s3Client::doesBucketExistV2)
                .forEach(s3Client::deleteBucket);
        log.info("Storages with names: {} have been deleted", bucketNames);
    }
}
