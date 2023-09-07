package com.tomatosoup.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

@Data
public class Tile {

    private TileType type;
    private boolean toBeCleared;

    public Tile(TileType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tile tile = (Tile) o;
        return type == tile.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }

    public enum TileType {

        COIN("\uD83E\uDE99"), PIG("\uD83D\uDC37"),

        WALLET("\uD83D\uDC5B"), CASE("\uD83D\uDCBC"),

        HOURGLASS("⌛"), SPECIAL("\uD83C\uDF1F"),

        EMPTY("⛔");

        private final String symbol;

        TileType(String symbol) {
            this.symbol = symbol;
        }

        @Override
        public String toString() {
            return symbol;
        }
    }
}
