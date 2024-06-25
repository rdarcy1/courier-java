/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.courier.api.resources.users.preferences.types;

import com.courier.api.core.ObjectMappers;
import com.courier.api.resources.commons.types.Paging;
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
@JsonDeserialize(builder = UserPreferencesListResponse.Builder.class)
public final class UserPreferencesListResponse {
    private final Paging paging;

    private final List<TopicPreference> items;

    private final Map<String, Object> additionalProperties;

    private UserPreferencesListResponse(
            Paging paging, List<TopicPreference> items, Map<String, Object> additionalProperties) {
        this.paging = paging;
        this.items = items;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return Deprecated - Paging not implemented on this endpoint
     */
    @JsonProperty("paging")
    public Paging getPaging() {
        return paging;
    }

    /**
     * @return The Preferences associated with the user_id.
     */
    @JsonProperty("items")
    public List<TopicPreference> getItems() {
        return items;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof UserPreferencesListResponse && equalTo((UserPreferencesListResponse) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(UserPreferencesListResponse other) {
        return paging.equals(other.paging) && items.equals(other.items);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.paging, this.items);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static PagingStage builder() {
        return new Builder();
    }

    public interface PagingStage {
        _FinalStage paging(Paging paging);

        Builder from(UserPreferencesListResponse other);
    }

    public interface _FinalStage {
        UserPreferencesListResponse build();

        _FinalStage items(List<TopicPreference> items);

        _FinalStage addItems(TopicPreference items);

        _FinalStage addAllItems(List<TopicPreference> items);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements PagingStage, _FinalStage {
        private Paging paging;

        private List<TopicPreference> items = new ArrayList<>();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(UserPreferencesListResponse other) {
            paging(other.getPaging());
            items(other.getItems());
            return this;
        }

        /**
         * <p>Deprecated - Paging not implemented on this endpoint</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("paging")
        public _FinalStage paging(Paging paging) {
            this.paging = paging;
            return this;
        }

        /**
         * <p>The Preferences associated with the user_id.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage addAllItems(List<TopicPreference> items) {
            this.items.addAll(items);
            return this;
        }

        /**
         * <p>The Preferences associated with the user_id.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage addItems(TopicPreference items) {
            this.items.add(items);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "items", nulls = Nulls.SKIP)
        public _FinalStage items(List<TopicPreference> items) {
            this.items.clear();
            this.items.addAll(items);
            return this;
        }

        @java.lang.Override
        public UserPreferencesListResponse build() {
            return new UserPreferencesListResponse(paging, items, additionalProperties);
        }
    }
}
