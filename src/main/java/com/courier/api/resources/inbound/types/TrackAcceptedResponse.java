/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.courier.api.resources.inbound.types;

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
@JsonDeserialize(builder = TrackAcceptedResponse.Builder.class)
public final class TrackAcceptedResponse {
    private final String messageId;

    private final Map<String, Object> additionalProperties;

    private TrackAcceptedResponse(String messageId, Map<String, Object> additionalProperties) {
        this.messageId = messageId;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return A successful call returns a <code>202</code> status code along with a <code>requestId</code> in the response body.
     */
    @JsonProperty("messageId")
    public String getMessageId() {
        return messageId;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof TrackAcceptedResponse && equalTo((TrackAcceptedResponse) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(TrackAcceptedResponse other) {
        return messageId.equals(other.messageId);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.messageId);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static MessageIdStage builder() {
        return new Builder();
    }

    public interface MessageIdStage {
        _FinalStage messageId(String messageId);

        Builder from(TrackAcceptedResponse other);
    }

    public interface _FinalStage {
        TrackAcceptedResponse build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements MessageIdStage, _FinalStage {
        private String messageId;

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(TrackAcceptedResponse other) {
            messageId(other.getMessageId());
            return this;
        }

        /**
         * <p>A successful call returns a <code>202</code> status code along with a <code>requestId</code> in the response body.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("messageId")
        public _FinalStage messageId(String messageId) {
            this.messageId = messageId;
            return this;
        }

        @java.lang.Override
        public TrackAcceptedResponse build() {
            return new TrackAcceptedResponse(messageId, additionalProperties);
        }
    }
}
