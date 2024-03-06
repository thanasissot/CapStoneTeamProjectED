package com.eurodyn.exception;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NominationException extends RuntimeException {
    public NominationException(String message) {
        super(message);
    }

    public NominationException() {
        super();
    }

    public static List<Object> getRandomObjects(List<Object> originalList) {
        // Create a new list to store random objects
        List<Object> randomObjects = new ArrayList<>();

        int originalSize = originalList.size();

        Random random = new Random();

        int numObjectsToSelect = random.nextInt(3) + 4;

        // Select random objects from the original list
        for (int i = 0; i < numObjectsToSelect; i++) {
            // Generate a random index to select an object from the original list
            int randomIndex = random.nextInt(originalSize);

            // Add the randomly selected object to the new list
            randomObjects.add(originalList.get(randomIndex));
        }

        return randomObjects;
    }
}
