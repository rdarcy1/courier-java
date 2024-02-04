/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.courier.api.resources.notifications.types;

import com.courier.api.core.ObjectMappers;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = BaseCheck.Builder.class)
public final class BaseCheck implements IBaseCheck {
    private final String id;

    private final CheckStatus status;

    private final Map<String, Object> additionalProperties;

    private BaseCheck(String id, CheckStatus status, Map<String, Object> additionalProperties) {
        this.id = id;
        this.status = status;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("id")
    @java.lang.Override
    public String getId() {
        return id;
    }

    @JsonProperty("status")
    @java.lang.Override
    public CheckStatus getStatus() {
        return status;
    }

    @JsonProperty("type")
    @java.lang.Override
    public String getType() {
        return "custom";
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof BaseCheck && equalTo((BaseCheck) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(BaseCheck other) {
        return id.equals(other.id) && status.equals(other.status);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.id, this.status);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static IdStage builder() {
        return new Builder();
    }

    public interface IdStage {
        StatusStage id(String id);

        Builder from(BaseCheck other);
    }

    public interface StatusStage {
        _FinalStage status(CheckStatus status);
    }

    public interface _FinalStage {
        BaseCheck build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements IdStage, StatusStage, _FinalStage {
        private String id;

        private CheckStatus status;

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(BaseCheck other) {
            id(other.getId());
            status(other.getStatus());
            return this;
        }

        @java.lang.Override
        @JsonSetter("id")
        public StatusStage id(String id) {
            this.id = id;
            return this;
        }

        @java.lang.Override
        @JsonSetter("status")
        public _FinalStage status(CheckStatus status) {
            this.status = status;
            return this;
        }

        @java.lang.Override
        public BaseCheck build() {
            return new BaseCheck(id, status, additionalProperties);
        }
    }
}
