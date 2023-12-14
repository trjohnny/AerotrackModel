package com.aerotrack.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AerotrackStage {
    ALPHA(new ApiEndpoint("https://u4ck1qvmfe.execute-api.eu-west-1.amazonaws.com/prod/", "ySPfILwuHkgUiE36bYHH235s9AgFrGg7huBDcXo1")),
    PROD(new ApiEndpoint("https://bfq0c9l0dl.execute-api.eu-west-1.amazonaws.com/prod/", "uT7NWMVVKt2ysdrCzxjMd7X6Ye64g7C5aI0xAiIc")),
    DEV_GIOVANNI(new ApiEndpoint("https://f1muce19kh.execute-api.eu-west-1.amazonaws.com/prod/", "z9inDLaWtOamHqvOCl25w33KtSbqVpOf61oPHGhK")),
    DEV_THOMAS(new ApiEndpoint("https://inqp96fh39.execute-api.eu-west-1.amazonaws.com/prod/", "8y3Q8oI4Rd9GPjICC8NXj4JRNeHQKenm4VAnn6AO"));

    private final ApiEndpoint apiEndpoint;
    public record ApiEndpoint(String baseUrl, String apiKey) {
    }
}
