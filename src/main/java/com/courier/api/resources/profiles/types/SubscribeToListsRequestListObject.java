/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.courier.api.resources.profiles.types;

import com.courier.api.core.ObjectMappers;
import com.courier.api.resources.commons.types.RecipientPreferences;
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
@JsonDeserialize(builder = SubscribeToListsRequestListObject.Builder.class)
public final class SubscribeToListsRequestListObject {
    private final String listId;

    private final Optional<RecipientPreferences> preferences;

    private final Map<String, Object> additionalProperties;

    private SubscribeToListsRequestListObject(
            String listId, Optional<RecipientPreferences> preferences, Map<String, Object> additionalProperties) {
        this.listId = listId;
        this.preferences = preferences;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("listId")
    public String getListId() {
        return listId;
    }

    @JsonProperty("preferences")
    public Optional<RecipientPreferences> getPreferences() {
        return preferences;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof SubscribeToListsRequestListObject && equalTo((SubscribeToListsRequestListObject) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(SubscribeToListsRequestListObject other) {
        return listId.equals(other.listId) && preferences.equals(other.preferences);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.listId, this.preferences);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static ListIdStage builder() {
        return new Builder();
    }

    public interface ListIdStage {
        _FinalStage listId(String listId);

        Builder from(SubscribeToListsRequestListObject other);
    }

    public interface _FinalStage {
        SubscribeToListsRequestListObject build();

        _FinalStage preferences(Optional<RecipientPreferences> preferences);

        _FinalStage preferences(RecipientPreferences preferences);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements ListIdStage, _FinalStage {
        private String listId;

        private Optional<RecipientPreferences> preferences = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(SubscribeToListsRequestListObject other) {
            listId(other.getListId());
            preferences(other.getPreferences());
            return this;
        }

        @java.lang.Override
        @JsonSetter("listId")
        public _FinalStage listId(String listId) {
            this.listId = listId;
            return this;
        }

        @java.lang.Override
        public _FinalStage preferences(RecipientPreferences preferences) {
            this.preferences = Optional.of(preferences);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "preferences", nulls = Nulls.SKIP)
        public _FinalStage preferences(Optional<RecipientPreferences> preferences) {
            this.preferences = preferences;
            return this;
        }

        @java.lang.Override
        public SubscribeToListsRequestListObject build() {
            return new SubscribeToListsRequestListObject(listId, preferences, additionalProperties);
        }
    }
}
