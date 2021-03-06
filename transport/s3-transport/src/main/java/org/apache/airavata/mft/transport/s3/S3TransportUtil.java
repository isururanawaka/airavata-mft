/*
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.airavata.mft.transport.s3;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

public class S3TransportUtil {
    public static S3ResourceIdentifier getS3ResourceIdentifier(String resourceId) {
        S3ResourceIdentifier identifier = new S3ResourceIdentifier();

        switch (resourceId){
            case "3":
                identifier.setAccessKey("key");
                identifier.setSecretKey("secret");
                identifier.setBucket("airavata-s3");
                identifier.setRegion("us-east-2");
                identifier.setRemoteFile("file.txt");
                return identifier;
            case "4":
                identifier.setAccessKey("key");
                identifier.setSecretKey("secret");
                identifier.setBucket("airavata-s3");
                identifier.setRegion("us-east-2");
                identifier.setRemoteFile("file2.txt");
                return identifier;
            default:
                return null;
        }
    }

    public static AmazonS3 getS3Client(String accessKey, String secretKey, String region) {
        AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
        AmazonS3 s3client = AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(Regions.fromName(region))
                .build();
        return s3client;
    }
}
