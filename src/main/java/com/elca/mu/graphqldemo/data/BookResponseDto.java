package com.elca.mu.graphqldemo.data;

import java.util.List;

public record BookResponseDto(List<Book> books, Integer totalPages, Integer totalElements) {
}
