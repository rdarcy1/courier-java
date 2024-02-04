/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.courier.api.resources.commons.types;

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
@JsonDeserialize(builder = Rule.Builder.class)
public final class Rule {
    private final Optional<String> start;

    private final String until;

    private final Map<String, Object> additionalProperties;

    private Rule(Optional<String> start, String until, Map<String, Object> additionalProperties) {
        this.start = start;
        this.until = until;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("start")
    public Optional<String> getStart() {
        return start;
    }

    @JsonProperty("until")
    public String getUntil() {
        return until;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof Rule && equalTo((Rule) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(Rule other) {
        return start.equals(other.start) && until.equals(other.until);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.start, this.until);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static UntilStage builder() {
        return new Builder();
    }

    public interface UntilStage {
        _FinalStage until(String until);

        Builder from(Rule other);
    }

    public interface _FinalStage {
        Rule build();

        _FinalStage start(Optional<String> start);

        _FinalStage start(String start);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements UntilStage, _FinalStage {
        private String until;

        private Optional<String> start = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(Rule other) {
            start(other.getStart());
            until(other.getUntil());
            return this;
        }

        @java.lang.Override
        @JsonSetter("until")
        public _FinalStage until(String until) {
            this.until = until;
            return this;
        }

        @java.lang.Override
        public _FinalStage start(String start) {
            this.start = Optional.of(start);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "start", nulls = Nulls.SKIP)
        public _FinalStage start(Optional<String> start) {
            this.start = start;
            return this;
        }

        @java.lang.Override
        public Rule build() {
            return new Rule(start, until, additionalProperties);
        }
    }
}
