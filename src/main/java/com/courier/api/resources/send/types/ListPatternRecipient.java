/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.courier.api.resources.send.types;

import com.courier.api.core.ObjectMappers;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = ListPatternRecipient.Builder.class)
public final class ListPatternRecipient implements IListPatternRecipientType {
    private final Optional<String> listPattern;

    private final Optional<Map<String, Object>> data;

    private final Map<String, Object> additionalProperties;

    private ListPatternRecipient(
            Optional<String> listPattern,
            Optional<Map<String, Object>> data,
            Map<String, Object> additionalProperties) {
        this.listPattern = listPattern;
        this.data = data;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("list_pattern")
    public Optional<String> getListPattern() {
        return listPattern;
    }

    @JsonProperty("data")
    public Optional<Map<String, Object>> getData() {
        return data;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ListPatternRecipient && equalTo((ListPatternRecipient) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ListPatternRecipient other) {
        return listPattern.equals(other.listPattern) && data.equals(other.data);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.listPattern, this.data);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> listPattern = Optional.empty();

        private Optional<Map<String, Object>> data = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(ListPatternRecipient other) {
            listPattern(other.getListPattern());
            data(other.getData());
            return this;
        }

        @JsonSetter(value = "list_pattern", nulls = Nulls.SKIP)
        public Builder listPattern(Optional<String> listPattern) {
            this.listPattern = listPattern;
            return this;
        }

        public Builder listPattern(String listPattern) {
            this.listPattern = Optional.of(listPattern);
            return this;
        }

        @JsonSetter(value = "data", nulls = Nulls.SKIP)
        public Builder data(Optional<Map<String, Object>> data) {
            this.data = data;
            return this;
        }

        public Builder data(Map<String, Object> data) {
            this.data = Optional.of(data);
            return this;
        }

        public ListPatternRecipient build() {
            return new ListPatternRecipient(listPattern, data, additionalProperties);
        }
    }
}
