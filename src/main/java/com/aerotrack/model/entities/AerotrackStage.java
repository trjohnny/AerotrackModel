package com.aerotrack.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum AerotrackStage {
    ALPHA("ALPHA", new ApiEndpoint("https://u4ck1qvmfe.execute-api.eu-west-1.amazonaws.com/prod/", "ySPfILwuHkgUiE36bYHH235s9AgFrGg7huBDcXo1")),
    PROD("PROD", new ApiEndpoint("https://bfq0c9l0dl.execute-api.eu-west-1.amazonaws.com/prod/", "uT7NWMVVKt2ysdrCzxjMd7X6Ye64g7C5aI0xAiIc")),
    DEV_GIOVANNI("gcoro", new ApiEndpoint("https://f1muce19kh.execute-api.eu-west-1.amazonaws.com/prod/", "z9inDLaWtOamHqvOCl25w33KtSbqVpOf61oPHGhK")),
    DEV_THOMAS("trossime", new ApiEndpoint("https://inqp96fh39.execute-api.eu-west-1.amazonaws.com/prod/", "8y3Q8oI4Rd9GPjICC8NXj4JRNeHQKenm4VAnn6AO"));

    private final String stage;
    private final ApiEndpoint apiEndpoint;

    public record ApiEndpoint(String baseUrl, String apiKey) {
    }

    public static AerotrackStage fromName(String name) {
        return Arrays.stream(AerotrackStage.values())
                .filter(stage -> stage.getStage().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No enum constant " + AerotrackStage.class.getCanonicalName() + "." + name));
    }
}
