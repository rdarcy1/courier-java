/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.courier.api.resources.messages.requests;

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
@JsonDeserialize(builder = ListMessagesRequest.Builder.class)
public final class ListMessagesRequest {
    private final Optional<Boolean> archived;

    private final Optional<String> cursor;

    private final Optional<String> event;

    private final Optional<String> list;

    private final Optional<String> messageId;

    private final Optional<String> notification;

    private final Optional<String> recipient;

    private final Optional<String> status;

    private final Optional<String> tags;

    private final Optional<String> enqueuedAfter;

    private final Optional<String> traceId;

    private final Map<String, Object> additionalProperties;

    private ListMessagesRequest(
            Optional<Boolean> archived,
            Optional<String> cursor,
            Optional<String> event,
            Optional<String> list,
            Optional<String> messageId,
            Optional<String> notification,
            Optional<String> recipient,
            Optional<String> status,
            Optional<String> tags,
            Optional<String> enqueuedAfter,
            Optional<String> traceId,
            Map<String, Object> additionalProperties) {
        this.archived = archived;
        this.cursor = cursor;
        this.event = event;
        this.list = list;
        this.messageId = messageId;
        this.notification = notification;
        this.recipient = recipient;
        this.status = status;
        this.tags = tags;
        this.enqueuedAfter = enqueuedAfter;
        this.traceId = traceId;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return A boolean value that indicates whether archived messages should be included in the response.
     */
    @JsonProperty("archived")
    public Optional<Boolean> getArchived() {
        return archived;
    }

    /**
     * @return A unique identifier that allows for fetching the next set of message statuses.
     */
    @JsonProperty("cursor")
    public Optional<String> getCursor() {
        return cursor;
    }

    /**
     * @return A unique identifier representing the event that was used to send the event.
     */
    @JsonProperty("event")
    public Optional<String> getEvent() {
        return event;
    }

    /**
     * @return A unique identifier representing the list the message was sent to.
     */
    @JsonProperty("list")
    public Optional<String> getList() {
        return list;
    }

    /**
     * @return A unique identifier representing the message_id returned from either /send or /send/list.
     */
    @JsonProperty("messageId")
    public Optional<String> getMessageId() {
        return messageId;
    }

    /**
     * @return A unique identifier representing the notification that was used to send the event.
     */
    @JsonProperty("notification")
    public Optional<String> getNotification() {
        return notification;
    }

    /**
     * @return A unique identifier representing the recipient associated with the requested profile.
     */
    @JsonProperty("recipient")
    public Optional<String> getRecipient() {
        return recipient;
    }

    /**
     * @return An indicator of the current status of the message. Multiple status values can be passed in.
     */
    @JsonProperty("status")
    public Optional<String> getStatus() {
        return status;
    }

    /**
     * @return A comma delimited list of 'tags'. Messages will be returned if they match any of the tags passed in.
     */
    @JsonProperty("tags")
    public Optional<String> getTags() {
        return tags;
    }

    /**
     * @return The enqueued datetime of a message to filter out messages received before.
     */
    @JsonProperty("enqueued_after")
    public Optional<String> getEnqueuedAfter() {
        return enqueuedAfter;
    }

    /**
     * @return The unique identifier used to trace the requests
     */
    @JsonProperty("traceId")
    public Optional<String> getTraceId() {
        return traceId;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ListMessagesRequest && equalTo((ListMessagesRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ListMessagesRequest other) {
        return archived.equals(other.archived)
                && cursor.equals(other.cursor)
                && event.equals(other.event)
                && list.equals(other.list)
                && messageId.equals(other.messageId)
                && notification.equals(other.notification)
                && recipient.equals(other.recipient)
                && status.equals(other.status)
                && tags.equals(other.tags)
                && enqueuedAfter.equals(other.enqueuedAfter)
                && traceId.equals(other.traceId);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(
                this.archived,
                this.cursor,
                this.event,
                this.list,
                this.messageId,
                this.notification,
                this.recipient,
                this.status,
                this.tags,
                this.enqueuedAfter,
                this.traceId);
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
        private Optional<Boolean> archived = Optional.empty();

        private Optional<String> cursor = Optional.empty();

        private Optional<String> event = Optional.empty();

        private Optional<String> list = Optional.empty();

        private Optional<String> messageId = Optional.empty();

        private Optional<String> notification = Optional.empty();

        private Optional<String> recipient = Optional.empty();

        private Optional<String> status = Optional.empty();

        private Optional<String> tags = Optional.empty();

        private Optional<String> enqueuedAfter = Optional.empty();

        private Optional<String> traceId = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(ListMessagesRequest other) {
            archived(other.getArchived());
            cursor(other.getCursor());
            event(other.getEvent());
            list(other.getList());
            messageId(other.getMessageId());
            notification(other.getNotification());
            recipient(other.getRecipient());
            status(other.getStatus());
            tags(other.getTags());
            enqueuedAfter(other.getEnqueuedAfter());
            traceId(other.getTraceId());
            return this;
        }

        @JsonSetter(value = "archived", nulls = Nulls.SKIP)
        public Builder archived(Optional<Boolean> archived) {
            this.archived = archived;
            return this;
        }

        public Builder archived(Boolean archived) {
            this.archived = Optional.of(archived);
            return this;
        }

        @JsonSetter(value = "cursor", nulls = Nulls.SKIP)
        public Builder cursor(Optional<String> cursor) {
            this.cursor = cursor;
            return this;
        }

        public Builder cursor(String cursor) {
            this.cursor = Optional.of(cursor);
            return this;
        }

        @JsonSetter(value = "event", nulls = Nulls.SKIP)
        public Builder event(Optional<String> event) {
            this.event = event;
            return this;
        }

        public Builder event(String event) {
            this.event = Optional.of(event);
            return this;
        }

        @JsonSetter(value = "list", nulls = Nulls.SKIP)
        public Builder list(Optional<String> list) {
            this.list = list;
            return this;
        }

        public Builder list(String list) {
            this.list = Optional.of(list);
            return this;
        }

        @JsonSetter(value = "messageId", nulls = Nulls.SKIP)
        public Builder messageId(Optional<String> messageId) {
            this.messageId = messageId;
            return this;
        }

        public Builder messageId(String messageId) {
            this.messageId = Optional.of(messageId);
            return this;
        }

        @JsonSetter(value = "notification", nulls = Nulls.SKIP)
        public Builder notification(Optional<String> notification) {
            this.notification = notification;
            return this;
        }

        public Builder notification(String notification) {
            this.notification = Optional.of(notification);
            return this;
        }

        @JsonSetter(value = "recipient", nulls = Nulls.SKIP)
        public Builder recipient(Optional<String> recipient) {
            this.recipient = recipient;
            return this;
        }

        public Builder recipient(String recipient) {
            this.recipient = Optional.of(recipient);
            return this;
        }

        @JsonSetter(value = "status", nulls = Nulls.SKIP)
        public Builder status(Optional<String> status) {
            this.status = status;
            return this;
        }

        public Builder status(String status) {
            this.status = Optional.of(status);
            return this;
        }

        @JsonSetter(value = "tags", nulls = Nulls.SKIP)
        public Builder tags(Optional<String> tags) {
            this.tags = tags;
            return this;
        }

        public Builder tags(String tags) {
            this.tags = Optional.of(tags);
            return this;
        }

        @JsonSetter(value = "enqueued_after", nulls = Nulls.SKIP)
        public Builder enqueuedAfter(Optional<String> enqueuedAfter) {
            this.enqueuedAfter = enqueuedAfter;
            return this;
        }

        public Builder enqueuedAfter(String enqueuedAfter) {
            this.enqueuedAfter = Optional.of(enqueuedAfter);
            return this;
        }

        @JsonSetter(value = "traceId", nulls = Nulls.SKIP)
        public Builder traceId(Optional<String> traceId) {
            this.traceId = traceId;
            return this;
        }

        public Builder traceId(String traceId) {
            this.traceId = Optional.of(traceId);
            return this;
        }

        public ListMessagesRequest build() {
            return new ListMessagesRequest(
                    archived,
                    cursor,
                    event,
                    list,
                    messageId,
                    notification,
                    recipient,
                    status,
                    tags,
                    enqueuedAfter,
                    traceId,
                    additionalProperties);
        }
    }
}
