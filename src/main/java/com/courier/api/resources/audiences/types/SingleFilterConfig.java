/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.courier.api.resources.audiences.types;

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
@JsonDeserialize(builder = SingleFilterConfig.Builder.class)
public final class SingleFilterConfig implements IBaseFilterConfig {
    private final Operator operator;

    private final String value;

    private final String path;

    private final Map<String, Object> additionalProperties;

    private SingleFilterConfig(Operator operator, String value, String path, Map<String, Object> additionalProperties) {
        this.operator = operator;
        this.value = value;
        this.path = path;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The operator to use for filtering
     */
    @JsonProperty("operator")
    @java.lang.Override
    public Operator getOperator() {
        return operator;
    }

    /**
     * @return The value to use for filtering
     */
    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    /**
     * @return The attribe name from profile whose value will be operated against the filter value
     */
    @JsonProperty("path")
    public String getPath() {
        return path;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof SingleFilterConfig && equalTo((SingleFilterConfig) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(SingleFilterConfig other) {
        return operator.equals(other.operator) && value.equals(other.value) && path.equals(other.path);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.operator, this.value, this.path);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static OperatorStage builder() {
        return new Builder();
    }

    public interface OperatorStage {
        ValueStage operator(Operator operator);

        Builder from(SingleFilterConfig other);
    }

    public interface ValueStage {
        PathStage value(String value);
    }

    public interface PathStage {
        _FinalStage path(String path);
    }

    public interface _FinalStage {
        SingleFilterConfig build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements OperatorStage, ValueStage, PathStage, _FinalStage {
        private Operator operator;

        private String value;

        private String path;

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(SingleFilterConfig other) {
            operator(other.getOperator());
            value(other.getValue());
            path(other.getPath());
            return this;
        }

        /**
         * <p>The operator to use for filtering</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("operator")
        public ValueStage operator(Operator operator) {
            this.operator = operator;
            return this;
        }

        /**
         * <p>The value to use for filtering</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("value")
        public PathStage value(String value) {
            this.value = value;
            return this;
        }

        /**
         * <p>The attribe name from profile whose value will be operated against the filter value</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("path")
        public _FinalStage path(String path) {
            this.path = path;
            return this;
        }

        @java.lang.Override
        public SingleFilterConfig build() {
            return new SingleFilterConfig(operator, value, path, additionalProperties);
        }
    }
}
