/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.courier.api.resources.brands.types;

import com.courier.api.core.ObjectMappers;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = BrandSnippets.Builder.class)
public final class BrandSnippets {
    private final List<BrandSnippet> items;

    private final Map<String, Object> additionalProperties;

    private BrandSnippets(List<BrandSnippet> items, Map<String, Object> additionalProperties) {
        this.items = items;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("items")
    public List<BrandSnippet> getItems() {
        return items;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof BrandSnippets && equalTo((BrandSnippets) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(BrandSnippets other) {
        return items.equals(other.items);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.items);
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
        private List<BrandSnippet> items = new ArrayList<>();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(BrandSnippets other) {
            items(other.getItems());
            return this;
        }

        @JsonSetter(value = "items", nulls = Nulls.SKIP)
        public Builder items(List<BrandSnippet> items) {
            this.items.clear();
            this.items.addAll(items);
            return this;
        }

        public Builder addItems(BrandSnippet items) {
            this.items.add(items);
            return this;
        }

        public Builder addAllItems(List<BrandSnippet> items) {
            this.items.addAll(items);
            return this;
        }

        public BrandSnippets build() {
            return new BrandSnippets(items, additionalProperties);
        }
    }
}
