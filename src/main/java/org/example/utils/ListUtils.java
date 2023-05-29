package org.example.utils;

import org.assertj.core.api.Assertions;

import java.util.List;

public class ListUtils {
    public static <T> T getFirstElementOfList(List<T> list) {
        try {
            return list.get(0);
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Current list is empty. " + e.getMessage());
        }
    }

    public static <T> T getSingleElementOfList(List<T> list, String errorMessage) {
        Assertions.assertThat(list).as(errorMessage).hasSize(1);
        return getFirstElementOfList(list);
    }

    public static <T> T getSingleElementOfList(List<T> list) {
        return getSingleElementOfList(list, "Current list contains unexpected size.");
    }
}
