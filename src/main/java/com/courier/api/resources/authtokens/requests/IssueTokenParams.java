/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.courier.api.resources.authtokens.requests;

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
@JsonDeserialize(builder = IssueTokenParams.Builder.class)
public final class IssueTokenParams {
    private final String scope;

    private final String expiresIn;

    private final Map<String, Object> additionalProperties;

    private IssueTokenParams(String scope, String expiresIn, Map<String, Object> additionalProperties) {
        this.scope = scope;
        this.expiresIn = expiresIn;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("scope")
    public String getScope() {
        return scope;
    }

    @JsonProperty("expires_in")
    public String getExpiresIn() {
        return expiresIn;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof IssueTokenParams && equalTo((IssueTokenParams) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(IssueTokenParams other) {
        return scope.equals(other.scope) && expiresIn.equals(other.expiresIn);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.scope, this.expiresIn);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static ScopeStage builder() {
        return new Builder();
    }

    public interface ScopeStage {
        ExpiresInStage scope(String scope);

        Builder from(IssueTokenParams other);
    }

    public interface ExpiresInStage {
        _FinalStage expiresIn(String expiresIn);
    }

    public interface _FinalStage {
        IssueTokenParams build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements ScopeStage, ExpiresInStage, _FinalStage {
        private String scope;

        private String expiresIn;

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(IssueTokenParams other) {
            scope(other.getScope());
            expiresIn(other.getExpiresIn());
            return this;
        }

        @java.lang.Override
        @JsonSetter("scope")
        public ExpiresInStage scope(String scope) {
            this.scope = scope;
            return this;
        }

        @java.lang.Override
        @JsonSetter("expires_in")
        public _FinalStage expiresIn(String expiresIn) {
            this.expiresIn = expiresIn;
            return this;
        }

        @java.lang.Override
        public IssueTokenParams build() {
            return new IssueTokenParams(scope, expiresIn, additionalProperties);
        }
    }
}
